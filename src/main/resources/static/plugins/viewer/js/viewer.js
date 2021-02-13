$(function () {
    $(".image-viewer").each(function (index, el) {
        var options = {
            readonly: $(el).attr("data-readonly") && $(el).attr("data-readonly") === 'true',
            loop: $(el).attr("data-loop") && $(el).attr("data-loop") === 'true',
            showQueue: $(el).attr("data-queue") && $(el).attr("data-queue") === 'true',
            browserHeight: $(el).attr("data-browser-height"),
            imageHeight: $(el).attr("data-image-height"),
            images: $(el).attr("data-images") ? $(el).attr("data-images").split(",") : [],
        };

        var images = [];

        $.each(options.images, function (index, el) {
            images.push(el.replace(/\s+/g,""))
        })

        options.images = images;

        $(el).imageViewer(options);
    })
});


function ImageViewer(container, settings) {
    this.container = container;
    this.setting = settings;
}

ImageViewer.prototype = {
    _index: 0,
    _init: function () {
        let viewBox = [
            "<div class='iv-box' style='height: " + this.setting.browserHeight + "'>",
            "   <div class='iv-pre'></div>",
            "   <div class='iv-next'></div>",
            "   <div class='iv-browser'></div>",
            "</div>"
        ];

        let lengthBox = [
            "<div class='iv-length'>",
            "<span class='name'></span>",
            "<span class='this'></span>",
            "<span> / </span>",
            "<span class='all'></span>",
            "</div>"
        ];

        let queueBox = [
            "<div class='iv-queue'>" +
            "   <div class='iv-pre'></div>",
            "   <div class='iv-next'></div>",
            "</div>",
        ];

        this.container.append($(viewBox.join("\r\n")));
        this.container.append($(lengthBox.join("\r\n")));
        this.container.append($(queueBox.join("\r\n")));
        this._loadImage();
    },

    _loadImage: function () {
        var that = this;
        this._index = 0;
        this.container.find(".iv-browser div.iv-image").remove();
        this.container.find(".iv-queue div.iv-image").remove();
        this.container.find("div").unbind();
        if (this.setting.images.length === 0)
            return;

        this.container.find(".iv-browser").append($("<div class='iv-image iv-image-show'></div>"))
        $.each(this.setting.images, function (index, el) {
            that._addImage(that.container, el, that.setting.readonly, index)
        });

        this._bindRemove();

        this.container.find(".iv-image-queue").css("height", this.setting.imageHeight)

        if (!this.setting.showQueue)
            this.container.find(".iv-image-queue").css("display", "none")

        this._setView(this.setting.images[this._index]);

        $('.iv-length .this').html(this._index + 1);
        $('.iv-length .all').html(this.setting.images.length);

        this._btnShowHide();

        this.container.find(".iv-pre").on("click", function () {
            that._preOne(that)
            that._border(that)
        })
        this.container.find(".iv-next").on("click", function () {
            that._nextOne(that)
            that._border(that)
        })

        this._border(this)
    },
    _bindRemove: function() {
        var that = this;
        this.container.find(".iv-queue div").unbind();
        this.container.find(".iv-queue div").bind("click", function () {
            var index = $(this).attr("data-index");
            // that.setting.images.splice(index, 1);
            // that._loadImage();
        })
    },
    getImages: function() {
        return this.setting.images;
    },
    _addImage: function(container, url, readonly, index) {
        var img = $("<div class='iv-image iv-image-queue' style='background-image: url(" + url + ");'></div>");
        if(!readonly)
            img = img.append("<i data-index='" + index + "' class='iv-remove'>&times;</i>");

        container.find(".iv-queue").append(img);
    },
    _setView: function (url) {
        $('.iv-length .name').html(url);
        this.container.find(".iv-image-show").css({
            backgroundImage: "url(" + url + ")",
        }).attr({
            'data-toggle': 'lightbox',
            'data-image': url,
            'data-group': 0,
        });
    },
    _btnShowHide: function () {
        if (!this.setting.loop) {
            if (this.setting.images.length - 1 === this._index)
                this.container.find(".iv-next").css("display", "none");
            else
                this.container.find(".iv-next").css("display", "");
            if (this._index === 0)
                this.container.find(".iv-pre").css("display", "none");
            else
                this.container.find(".iv-pre").css("display", "");
        } else {
            this.container.find(".iv-next").css("display", "");
            this.container.find(".iv-pre").css("display", "");
        }
    },
    _preOne: function (that) {
        if (!that.setting.loop && that._index === 0) {
            return;
        }
        that._index = that._index === 0 ? that.setting.images.length - 1 : that._index - 1;

        if (that._index === 0){
            $('.iv-length .name').html(that.setting.images[0]);
            $('.iv-length .this').html(1);
        } else {
            $('.iv-length .name').html(that.setting.images[that._index]);
            $('.iv-length .this').html(that._index);
        }

        that._btnShowHide();
        var tempBox = "<div class='iv-image iv-image-show'></div>";
        var current = that.container.find(".iv-image-show");
        tempBox = $(tempBox).prependTo(that.container.find(".iv-browser")).css("left", "-100%").css("background-image", "url(" + that.setting.images[that._index] + ")");

        tempBox.attr({
            'data-toggle': 'lightbox',
            'data-image': that.setting.images[that._index],
            'data-group': 0,
        });

        setTimeout(function () {
            tempBox.animate({left: ""}, 500)
        }, 10)
        setTimeout(function () {
            current.animate({left: "100%"}, 500, function () {
                tempBox.css("left", "")
                current.remove();
            })
        }, 10)
    },
    _nextOne: function (that) {
        var maxIndex = that.setting.images.length - 1;
        if (!that.setting.loop && that._index === maxIndex) {
            return;
        }
        that._index = that._index === maxIndex ? 0 : that._index + 1;

        $('.iv-length .name').html(that.setting.images[that._index]);

        $('.iv-length .this').html(that._index + 1);

        that._btnShowHide();
        var tempBox = "<div class='iv-image iv-image-show'></div>";
        var current = that.container.find(".iv-image-show");
        tempBox = $(tempBox).prependTo(that.container.find(".iv-browser")).css("left", "100%").css("background-image", "url(" + that.setting.images[that._index] + ")");
        tempBox.attr({
            'data-toggle': 'lightbox',
            'data-image': that.setting.images[that._index],
            'data-group': 0,
        });

        setTimeout(function () {
            tempBox.animate({left: ""}, 500)
        }, 10)
        setTimeout(function () {
            current.animate({
                left: "-100%"
            }, 500, function () {
                tempBox.css("left", "");
                current.remove();
            })
        }, 10);
    },
    _border: function (that) {
        that.container.find(".iv-image-queue:eq(" + that._index + ")").css("border", "2px solid #282828").siblings().css("border", "1px solid darkgray");
    },
};

$.fn.imageViewer = function (options) {

    let defaultOptions = {
        readonly: true,
        loop: true,
        showQueue: true,
        images: [],
        browserHeight: "300px",
        imageHeight: "5rem",
        width: "100%",
        __index: ''
    };

    if ($(this).data("imageViewer") && !options)
        return $(this).data("imageViewer");

    let setting = $.extend({}, defaultOptions, options);

    let imageViewer = new ImageViewer($(this), setting);
    imageViewer._init();
    $(this).data("imageViewer", imageViewer);
};