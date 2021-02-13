// CalculateWindowSize
function CalculateWindowSize() {
    var winHeight;
    var winWidth;
    //Get Window Width and Height
    if (window.innerWidth)
        winWidth = window.innerWidth;
    else if ((document.body) && (document.body.clientWidth))
        winWidth = document.body.clientWidth;
    //Get This Window Height
    if (window.innerHeight)
        winHeight = window.innerHeight;
    else if ((document.body) && (document.body.clientHeight))
        winHeight = document.body.clientHeight;
    if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) {
        winHeight = document.documentElement.clientHeight;
        winWidth = document.documentElement.clientWidth;
    };

    // html body
    // $('html, body').height(winHeight).width(winWidth);

    // content
    $('#verifyGalleryPhotos').width(winWidth / 2 - 24);

    // maps
    $('.maps-container, #chinaMaps').width(winWidth).height(winHeight);
    $('[data-box="mapsChange"]').height(winHeight - 72);

    $('[data-box="maps-baosong-no"], [data-box="maps-baosong-ok"]').height(winHeight / 2 + 68);
    $('[data-box="maps-marker-no"], [data-box="maps-marker-ok"]').height(winHeight / 2 + 68);
    $('[data-box="maps-share-my"], [data-box="maps-share-in"]').height(winHeight / 2 + 68);
    $('.assets-tree-cell').height(winHeight - 130);

};

window.onresize = function() {
    CalculateWindowSize();
};

// TabLink
// TabLinkShow
// TabContent
function TabWarpFuncClick(TabLink, TabContent, TabLinkShow) {
    $(TabLink).click(function() {
        $(TabLink).removeClass(TabLinkShow);
        $(this).addClass(TabLink + " " + TabLinkShow);
        var i = $(this).prevAll().length;
        $(TabContent).hide();
        $($(TabContent).get(i)).show();
    });
};

$(function() {
    // CalculateWindowSize
    CalculateWindowSize();

    // tabs-exercise
    TabWarpFuncClick('[data-tabs-header="dashboard"] .tabs-link', '[data-tabs-container="dashboard"] .tabs-content', "active");

});
