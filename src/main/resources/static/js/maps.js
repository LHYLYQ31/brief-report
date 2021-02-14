
/**
 * ***********************************************************************************************
 * maps js
 * ***********************************************************************************************
 */

$(function () {

    // 全屏显示
    $('#fullScreen').on('click', function () {
        $(document).toggleFullScreen();
    });

    // 操作：控制条
    $('[data-toggle="tools"]').click(function () {
        $('[data-box="maps-tools"]').toggleClass('d-none');
    });
    $('[data-box="maps-tools"] .items').click(function () {
        $('[data-box="maps-tools"] .items').removeClass('active');
        $(this).toggleClass('active');
        var type = $(this).data('type');
        __toggleMapsChangeBox(type)
    });

    // 关闭：地图操作层
    $('[data-icon="close-maps-change"]').click(function () {
        $('[data-box="maps-tools"] .items').removeClass('active');
        $(this).parents('[data-box="mapsChange"]').hide();
    });

    // 切换：区域
    __toggleArea();

    // 点击：护边员 头像
    $('[data-avatar="hby-avatar"]').click(function () {
        $('[data-back="back-parent-hby"]').toggleClass('d-none');
        $('[data-box="hby-list"]').hide();
        $('[data-box="hby-details"]').show();
    });
    // 返回：护边员 上一级
    $('[data-back="back-parent-hby"]').click(function () {
        $('[data-back="back-parent-hby"]').toggleClass('d-none');
        $('[data-box="hby-list"]').show();
        $('[data-box="hby-details"]').hide();
    });

    // 点击：界碑 头像
    $('[data-avatar="jiebei-avatar"]').click(function () {
        $('[data-back="back-parent-jiebei"]').toggleClass('d-none');
        $('[data-box="jiebei-list"]').hide();
        $('[data-box="jiebei-details"]').show();
    });
    $('[data-back="back-parent-jiebei"]').click(function () {
        $('[data-back="back-parent-jiebei"]').toggleClass('d-none');
        $('[data-box="jiebei-list"]').show();
        $('[data-box="jiebei-details"]').hide();
    });

    // 点击：摄像头 头像
    $('[data-avatar="camera-avatar"]').click(function () {
        $('[data-back="back-parent-camera"]').toggleClass('d-none');
        $('[data-box="camera-list"]').hide();
        $('[data-box="camera-details"]').show();
    });
    $('[data-back="back-parent-camera"]').click(function () {
        $('[data-back="back-parent-camera"]').toggleClass('d-none');
        $('[data-box="camera-list"]').show();
        $('[data-box="camera-details"]').hide();
    });


    $('[data-view="hby-baosong"]').click(function () {
        $('[data-box="view-hby-baosong"]').show();
    });
    $('[data-hide="view-hby-baosong"]').click(function () {
        $('[data-box="view-hby-baosong"]').hide();
    });

    $('[data-view="task-details"]').click(function () {
        $('[data-box="task-details"]').show();
    });
    $('[data-hide="task-details"]').click(function () {
        $('[data-box="task-details"]').hide();
    });

    __verifyPhotosViewer();

});

// 切换：地图操作层
function __toggleMapsChangeBox(type) {
    var DOMS = $('[class="maps-change"] [data-box="mapsChange"]');
    $(DOMS).hide();
    for (var i = 0; i < DOMS.length; i++){
        if ($(DOMS[i]).data('type') === type){
            $(DOMS[i]).show();
        }
    }
}

// 切换：区域
function __toggleArea(){
    var doms = $('[data-toggle="area"] .btn');
    doms.click(function () {
        doms.removeClass('btn-blue');
        var text = $(this).text();
        $('[data-name="area"]').text(text);
        $(this).addClass('btn-blue');
    })
}

layui.use('element', function(){
    var $ = layui.jquery, element = layui.element;

    console.log(element);

    /********************************************************************
     * 监听：切换tabs
     * ********************************************************************
     */
    // 护边员：filter-hby
    element.on('tab(tabs-hby)', function(){
        location.hash = 'tabs-hby=';
    });

});

function __verifyPhotosViewer() {
    var imageArray = [
        "images/books/img-02.png",
        "images/books/img-03.png",
        "images/books/img-02.png",
        "images/books/img-03.png",
    ];
    $('[data-box="verifyPhotosViewer"]').imageViewer({
        readonly: true,
        loop: true,
        showQueue: true,
        images: imageArray,
        browserHeight: "480px",
        imageHeight: "10rem",
        width: "100%",
    });
}