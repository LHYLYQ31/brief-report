/**
 * ***********************************************************************************************
 * verify js
 * ***********************************************************************************************
 */

/**
 * 审核报送
 */
var verifyTableColumns = [];

var verifyTableData = [];

layui.use(['table', 'laytpl'], function(){
    var table = layui.table;
    var templet = layui.laytpl;

    var columns = [];

    var defaultColumns = [
        {type:'checkbox'},
        {field: 'id', title: '编号',},
        {field: 'infoType', title: '信息类型', width: 110, sort: true, templet: '#infoType'},
        {field: 'dangerType', title: '紧急程度', sort: true, templet: '#dangerType'},
        {field: 'title', title: '报送标题',},
        {field: 'content', title: '报送内容',},
        {field: 'depart', title: '部门',},
        {field: 'user', title: '报送人',},
        {field: 'time', title: '报送时间', sort: true,},
        {field: 'weight', title: '重要程度', sort: true,},
        {field: 'infoStatus', title: '信息状态', sort: true, templet: '#infoStatus'},
        {field: 'attr', title: '附件', templet: '#attr-verify'},
        {
            title: '操作',
            toolbar: '#dataTableRowTools-verify',
            width: 120,
            align: 'center'
        }
    ];

    readyTableData(7, 1, defaultColumns);

    $('[data-switch="switch-verify-type"]').click(function () {
        $('[data-switch="switch-verify-type"]').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        var type = $(this).data('type');

        if (type === 1){
            readyTableData(7, type, defaultColumns);
        }

        if (type === 2){
            columns = [
                {type:'checkbox'},
                {field: 'id', title: '编号',},
                {field: 'infoType', title: '信息类型', sort: true, templet: '#markerType'},
                {field: 'dangerType', title: '紧急程度', sort: true, templet: '#dangerType'},
                {field: 'title', title: '标注标题', sort: true,},
                {field: 'lat', title: '经度',},
                {field: 'lng', title: '纬度',},
                {field: 'depart', title: '部门',},
                {field: 'user', title: '标注人', sort: true,},
                {field: 'time', title: '标注时间', sort: true,},
                {field: 'infoStatus', title: '信息状态', sort: true, templet: '#infoStatus'},
                {field: 'attr', title: '附件', templet: '#attr-verify'},
                {
                    title: '操作',
                    toolbar: '#dataTableRowTools-verify',
                    width: 120,
                    align: 'center'
                }
            ];
            readyTableData(12, type, columns);
        }

        if (type === 3){
            columns = [
                {type:'checkbox'},
                {field: 'id', title: '编号',},
                {field: 'infoType', title: '信息类型', sort: true, templet: '#infoType'},
                {field: 'dangerType', title: '紧急程度', sort: true, templet: '#dangerType'},
                {field: 'title', title: '报送标题',},
                {field: 'content', title: '报送内容',},
                {field: 'depart', title: '部门',},
                {field: 'user', title: '报送人',},
                {field: 'time', title: '报送时间', sort: true,},
                {field: 'weight', title: '重要程度', sort: true,},
                {field: 'feedback', title: '反馈状态', sort: true,},
                {field: 'infoStatus', title: '信息状态', sort: true, templet: '#infoStatus'},
                {field: 'attr', title: '附件', templet: '#attr-verify'},
                {
                    title: '操作',
                    toolbar: '#dataTableRowTools-verify',
                    width: 120,
                    align: 'center'
                }
            ];
            readyTableData(7, type, columns);
        }

        if (type === 4){
            columns = [
                {type:'checkbox'},
                {field: 'id', title: '编号',},
                {field: 'infoType', title: '信息类型', sort: true, templet: '#markerType'},
                {field: 'dangerType', title: '紧急程度', sort: true, templet: '#dangerType'},
                {field: 'title', title: '标注标题', sort: true,},
                {field: 'lat', title: '经度', },
                {field: 'lng', title: '纬度',},
                {field: 'depart', title: '部门',},
                {field: 'user', title: '标注人', sort: true,},
                {field: 'time', title: '标注时间', sort: true,},
                {field: 'infoStatus', title: '信息状态', sort: true, templet: '#infoStatus'},
                {field: 'attr', title: '附件', templet: '#attr-verify'},
                {
                    title: '操作',
                    toolbar: '#dataTableRowTools-verify',
                    width: 120,
                    align: 'center'
                }
            ];
            readyTableData(12, type, columns);
        }

        if (type === 5){
            columns = [
                {type:'checkbox'},
                {field: 'id', title: '编号',},
                {field: 'shareType', title: '分享类型', sort: true, templet: '#shareType'},
                {field: 'infoType', title: '信息类型', sort: true, templet: '#infoType'},
                {field: 'dangerType', title: '紧急程度', sort: true, templet: '#dangerType'},
                {field: 'title', title: '报送标题', },
                {field: 'depart', title: '部门', },
                {field: 'user', title: '报送人', },
                {field: 'time', title: '报送时间', sort: true,},
                {field: 'weight', title: '重要程度', sort: true,},
                {field: 'viewType', title: '阅读状态', sort: true, templet: '#view-type'},
                {field: 'downTimer', title: '分享倒计时', sort: true, templet: '#down-timer'},
                {field: 'attr', title: '附件', templet: '#attr-verify'},
                {
                    title: '操作',
                    toolbar: '#dataTableRowTools-verify',
                    width: 120,
                    align: 'center'
                }
            ];
            readyTableData(5, type, columns);
        }

        if (type === 6){
            columns = [
                {type:'checkbox'},
                {field: 'id', title: '编号',},
                {field: 'shareType', title: '分享类型', sort: true, templet: '#shareType'},
                {field: 'infoType', title: '信息类型', sort: true, templet: '#infoType'},
                {field: 'dangerType', title: '紧急程度', sort: true, templet: '#dangerType'},
                {field: 'title', title: '报送标题',},
                {field: 'depart', title: '部门',},
                {field: 'user', title: '报送人',},
                {field: 'time', title: '报送时间', sort: true,},
                {field: 'weight', title: '重要程度', sort: true,},
                {field: 'viewType', title: '阅读状态', sort: true, templet: '#view-type'},
                {field: 'downTimer', title: '分享倒计时', sort: true, templet: '#down-timer'},
                {field: 'attr', title: '附件', templet: '#attr-verify'},
                {
                    title: '操作',
                    toolbar: '#dataTableRowTools-verify',
                    width: 120,
                    align: 'center'
                }
            ];
            readyTableData(5, type, columns);
        }
    });

    function readyTableData(data, type, columns){
        verifyTableColumns = columns;
        verifyTableData = [];
        if (type === 1){
            for (var i = 1; i <= data; i++){
                verifyTableData.push({
                    id: i,
                    infoType: i,
                    dangerType: i,
                    title: '巡查万尾辖区路段',
                    content: '今天对万尾辖区内路段进行巡查今天对万尾辖区内路段进行巡查今天对万尾辖区内路段进行巡查今天对万尾辖区内路段进行巡查',
                    depart: '东兴市',
                    user: '刘华强',
                    time: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                    weight: '无',
                    status: i,
                    attr: i,
                    rowKey: 'verify-baosong-no'
                });
            }
        }

        if (type === 2){
            for (var i = 1; i <= data; i++){
                verifyTableData.push({
                    id: i,
                    infoType: i,
                    dangerType: i,
                    title: '巡查万尾辖区路段',
                    depart: '东兴市',
                    lat: 106.37363,
                    lng: 22.3636525,
                    user: '刘华强',
                    time: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                    status: i,
                    attr: i,
                    rowKey: 'verify-marker-no'
                });
            }
        }

        if (type === 3){
            for (var i = 1; i <= data; i++){
                verifyTableData.push({
                    id: i,
                    infoType: i,
                    danger: i,
                    title: '巡查万尾辖区路段',
                    content: '今天对万尾辖区内路段进行巡查',
                    depart: '东兴市',
                    user: '刘华强',
                    time: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                    weight: '无',
                    feedback: '无',
                    status: i,
                    attr: i,
                    rowKey: 'verify-baosong-ok'
                });
            }
        }

        if (type === 4){
            for (var i = 1; i <= data; i++){
                verifyTableData.push({
                    id: i,
                    infoType: i,
                    dangerType: i,
                    title: '巡查万尾辖区路段',
                    depart: '东兴市',
                    lat: 106.37363,
                    lng: 22.3636525,
                    user: '刘华强',
                    time: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                    status: i,
                    attr: i,
                    rowKey: 'verify-marker-ok'
                });
            }
        }

        if (type === 5){
            for (var i = 1; i <= data; i++){
                verifyTableData.push({
                    id: i,
                    infoType: i,
                    shareType: i,
                    dangerType: i,
                    title: '巡查万尾辖区路段',
                    depart: '东兴市',
                    user: '刘华强',
                    time: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                    weight: '无',
                    viewType: i,
                    downTimer: i,
                    attr: i,
                    rowKey: 'view-share-my'
                });
            }
        }
        if (type === 6){
            for (var i = 1; i <= data; i++){
                verifyTableData.push({
                    id: i,
                    infoType: i,
                    shareType: i,
                    dangerType: i,
                    title: '巡查万尾辖区路段',
                    depart: '东兴市',
                    user: '刘华强',
                    time: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                    weight: '无',
                    viewType: i,
                    downTimer: i,
                    attr: i,
                    rowKey: 'view-share-in'
                });
            }
        }

        table.render({
            elem: '#dataTable-verify',
            cols: [verifyTableColumns],
            data: verifyTableData,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
        __readyTooltips();
    }

    //监听表格复选框选择
    var onFilter = 'checkbox(dataTableFilter-verify)';
    table.on(onFilter, function(data){
        console.log('this.row.checked---------->', data);
    });


    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTableFilter-verify)', function(obj){
        var data = obj.data;
        console.log('this.row.data---------->', data);
        $('body').addClass('overflow-hidden');


        if(obj.event === 'annex'){
            // todo
        }

        if(obj.event === 'review-baosong-no'){
            $('[data-box="review-baosong-no"]').show();
        }

        if(obj.event === 'review-baosong-ok'){
            $('[data-box="review-baosong-ok"]').show();
        }

        if(obj.event === 'review-marker-no'){
            $('[data-box="review-marker-no"]').show();
        }

        if(obj.event === 'review-marker-ok'){
            $('[data-box="review-marker-ok"]').show();
        }

        if(obj.event === 'view-share-my'){
            $('[data-box="view-share-my"]').show();
        }

        if(obj.event === 'view-share-in'){
            $('[data-box="view-share-in"]').show();
        }

        if(obj.event === 'send'){
            $('#shareing').modal({ show: true, });
        }

        if(obj.event === 'del'){
            swal({
                title: "您确定要删除这条信息吗",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                swal("删除成功！", "您已经永久删除了这条信息。", "success");
            });
        }
    });
});

function __readyTooltips() {
    var nodes = $('.layui-table-main td[data-field="content"] > div');
    for (var i = 0; i < nodes.length; i++){
        $(nodes[i]).attr({
            'data-toggle': 'tooltip',
            'data-placement': 'bottom',
            'title': nodes[i].innerText,
        });
    }
    $('[data-toggle="tooltip"]').tooltip();
}

function __verifyPhotosViewer() {

    var verifyBaosongPhotoView = new Swiper('[data-swiper="verify-baosong-photo-view"]', {
        autoplay: false,
        loop: true,
        pagination: {
            el: '.swiper-pagination',
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
    console.log('this.verifyBaosongPhotoView---------->', verifyBaosongPhotoView);

    var verifyMarkerPhotoView = new Swiper('[data-swiper="verify-marker-photo-view"]', {
        autoplay: false,
        loop: true,
        pagination: {
            el: '.swiper-pagination',
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
    });
    console.log('this.verifyMarkerPhotoView---------->', verifyMarkerPhotoView);


    var imageArray = [
        "images/books/img-02.png",
        "images/books/img-03.png",
        "images/books/img-02.png",
        "images/books/img-03.png",
    ];
    $('[data-box="verifyBaosongPhotosViewerOk"]').imageViewer({
        readonly: true,
        loop: true,
        showQueue: true,
        images: imageArray,
        browserHeight: "480px",
        imageHeight: "10rem",
        width: "100%",
    });
    $('[data-box="verifyBaosongPhotosViewerNO"]').imageViewer({
        readonly: true,
        loop: true,
        showQueue: true,
        images: imageArray,
        browserHeight: "480px",
        imageHeight: "10rem",
        width: "100%",
    });

    $('[data-box="verifyMarkerPhotosViewerOk"]').imageViewer({
        readonly: true,
        loop: true,
        showQueue: true,
        images: imageArray,
        browserHeight: "480px",
        imageHeight: "10rem",
        width: "100%",
    });
    $('[data-box="verifyMarkerPhotosViewerNo"]').imageViewer({
        readonly: true,
        loop: true,
        showQueue: true,
        images: imageArray,
        browserHeight: "480px",
        imageHeight: "10rem",
        width: "100%",
    });
}

$(function () {

    $('select.chosen-select').chosen({
        no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
        disable_search_threshold: 10, // 10 个以下的选择项则不显示检索框
        search_contains: true         // 从任意位置开始检索
    });

    $('#searchboxExample').searchBox({
        escToClear: true, // 设置点击 ESC 键清空搜索框
        onSearchChange: function(searchKey, isEmpty) {
            console.log('搜索框文本变更：', searchKey);
        }
    });

    $.fn.datetimepicker.dates['zh-CN'] = {
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
        daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
        daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
        months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        today: "今天",
        suffix: [],
        meridiem: ["上午", "下午"]
    };

    // 仅选择日期
    $(".form-date").datetimepicker({
        language:'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0,
        format: "yyyy-mm-dd"
    });

    $('[data-btn="show-search-toolbar-verify"]').click(function () {
        $('[data-sort="verify"]').hide();
        $('[data-search="verify"]').show();
    });
    $('[data-btn="hide-search-toolbar-verify"]').click(function () {
        $('[data-sort="verify"]').show();
        $('[data-search="verify"]').hide();
    });

    $('[data-hide="review-baosong-no"]').click(function () {
        $('[data-box="review-baosong-no"]').hide();
    });
    $('[data-hide="review-baosong-ok"]').click(function () {
        $('[data-box="review-baosong-ok"]').hide();
    });

    $('[data-hide="review-marker-no"]').click(function () {
        $('[data-box="review-marker-no"]').hide();
    });
    $('[data-hide="review-marker-ok"]').click(function () {
        $('[data-box="review-marker-ok"]').hide();
    });

    $('[data-hide="view-share-my"]').click(function () {
        $('[data-box="view-share-my"]').hide();
    });
    $('[data-hide="view-share-in"]').click(function () {
        $('[data-box="view-share-in"]').hide();
    });

    // 禁止下拉菜单事件传递
    $(".dropdown-menu").on("click", "[data-stop-propagation]", function(e) {
        e.stopPropagation();
    });


    // 选择分享用户
    var shareUsers = $('[data-box="avatar-cell"]');
    shareUsers.click(function () {
        $(this).toggleClass('active');
    });

    // photo viewer
    __verifyPhotosViewer();

});
