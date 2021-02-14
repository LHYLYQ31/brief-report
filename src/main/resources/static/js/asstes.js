/**
 * ***********************************************************************************************
 * assets js
 * ***********************************************************************************************
 */

/**
 * 电子书
 */
var booksTableData = [];
var booksTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', sort: true},
    {field: 'title', title: '标题', sort: true},
    {field: 'parent', title: '父级栏目',  sort: true},
    {field: 'views', title: '浏览量', sort: true},
    {field: 'number', title: '编号', sort: true},
    {field: 'sendTime', title: '发布时间', sort: true},
    {field: 'sendPeople', title: '发布人', sort: true},
    {field: 'status', title: '状态', sort: true, templet: '#status-books'},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-books',
        width: 150,
        align: 'center'
    }
];

/**
 * 图文资料
 */
var staticTableData = [];
var staticTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号',sort: true},
    {field: 'title', title: '标题', sort: true},
    {field: 'parent', title: '父级栏目', sort: true},
    {field: 'views', title: '浏览量', sort: true},
    {field: 'number', title: '编号', sort: true},
    {field: 'sendTime', title: '发布时间', sort: true},
    {field: 'sendPeople', title: '发布人', sort: true},
    {field: 'status', title: '状态', sort: true, templet: '#status-books'},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-static',
        width: 150,
        align: 'center'
    }
];

/**
 * 照片库
 */
var photosTableData = [];
var photosTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', sort: true},
    {field: 'title', title: '标题', sort: true},
    {field: 'parent', title: '父级栏目', sort: true},
    {field: 'views', title: '浏览量', sort: true},
    {field: 'number', title: '编号', sort: true},
    {field: 'sendTime', title: '发布时间', sort: true},
    {field: 'sendPeople', title: '发布人', sort: true},
    {field: 'status', title: '状态', sort: true, templet: '#status-photos'},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-photos',
        width: 150,
        align: 'center'
    }
];

/**
 * 视频库
 */
var videosTableData = [];
var videosTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', sort: true},
    {field: 'title', title: '标题', sort: true},
    {field: 'parent', title: '父级栏目', sort: true},
    {field: 'views', title: '浏览量', sort: true},
    {field: 'number', title: '编号', sort: true},
    {field: 'sendTime', title: '发布时间', sort: true},
    {field: 'sendPeople', title: '发布人', sort: true},
    {field: 'status', title: '状态', sort: true, templet: '#status-photos'},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-videos',
        width: 150,
        align: 'center'
    }
];

layui.use('table', function(){
    var table = layui.table;

    booksDataTable(3);

    $('[data-filter="assets-books"] button').click(function () {
        $('[data-filter="assets-books"] button').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        var type = $(this).data('type');
        switch (type) {
            case 1:
                booksDataTable(3);
                break;
            case 2:
                booksDataTable(6);
                break;
            case 3:
                booksDataTable(3);
                break;
            case 4:
                booksDataTable(6);
                break;
        }
    });

    function booksDataTable(data){
        booksTableData = [];
        for (var i = 0; i < data; i++){
            booksTableData.push({
                id: i,
                title: '电子书标题' + i,
                parent: '父级栏目' + i,
                views: i,
                number: i,
                sendTime: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                sendPeople: 'User ' + i,
                status: i,
            });
        }
        table.render({
            elem: '#dataTable-books',
            cols: [booksTableColumns],
            data: booksTableData,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    staticDataTable(3);
    $('[data-filter="assets-static"] button').click(function () {
        $('[data-filter="assets-static"] button').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        var type = $(this).data('type');
        switch (type) {
            case 1:
                staticDataTable(3);
                break;
            case 2:
                staticDataTable(6);
                break;
            case 3:
                staticDataTable(3);
                break;
            case 4:
                staticDataTable(6);
                break;
        }
    });

    function staticDataTable(data){
        staticTableData = [];
        for (var i = 0; i < data; i++){
            staticTableData.push({
                id: i,
                title: '图文资料标题' + i,
                parent: '父级栏目' + i,
                views: i,
                number: i,
                sendTime: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                sendPeople: 'User ' + i,
                status: i,
            });
        }
        table.render({
            elem: '#dataTable-static',
            cols: [staticTableColumns],
            data: staticTableData,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    photosDataTable(3);
    $('[data-filter="assets-photos"] button').click(function () {
        $('[data-filter="assets-photos"] button').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        var type = $(this).data('type');
        switch (type) {
            case 1:
                photosDataTable(3);
                break;
            case 2:
                photosDataTable(6);
                break;
            case 3:
                photosDataTable(3);
                break;
            case 4:
                photosDataTable(6);
                break;
        }
    });

    function photosDataTable(data){
        photosTableData = [];
        for (var i = 0; i < data; i++){
            photosTableData.push({
                id: i,
                title: '照片标题' + i,
                parent: '父级栏目' + i,
                views: i,
                number: i,
                sendTime: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                sendPeople: 'User ' + i,
                status: i,
            });
        };
        table.render({
            elem: '#dataTable-photos',
            cols: [photosTableColumns],
            data: photosTableData,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    videosDataTable(3);
    $('[data-filter="assets-videos"] button').click(function () {
        $('[data-filter="assets-videos"] button').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        var type = $(this).data('type');
        switch (type) {
            case 1:
                videosDataTable(3);
                break;
            case 2:
                videosDataTable(6);
                break;
            case 3:
                videosDataTable(3);
                break;
            case 4:
                videosDataTable(6);
                break;
        }
    });

    function videosDataTable(data){
        videosTableData = [];
        for (var i = 0; i < data; i++){
            videosTableData.push({
                id: i,
                title: '视频标题' + i,
                parent: '父级栏目' + i,
                views: i,
                number: i,
                sendTime: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
                sendPeople: 'User ' + i,
                status: i,
            });
        }
        table.render({
            elem: '#dataTable-videos',
            cols: [videosTableColumns],
            data: videosTableData,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    // 监听表格复选框选择
    var onFilter = 'checkbox(dataTableFilter-books), checkbox(dataTableFilter-static), checkbox(dataTableFilter-photos), checkbox(dataTableFilter-videos)';
    table.on(onFilter, function(obj){
        console.log(obj);
    });

    /**
     ******************** 监听工具条 ********************
     */
    // 电子书
    table.on('tool(dataTableFilter-books)', function(obj){
        var data = obj.data;
        $('body').addClass('overflow-hidden');
        if(obj.event === 'view'){
            $('[data-box="books-view"]').show();
        } else if(obj.event === 'editor'){
            $('[data-box="books-editor"]').show();
        } else if(obj.event === 'verify'){
            $('[data-box="books-verify"]').show();
        } else if(obj.event === 'del'){
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

    // 图文资料
    table.on('tool(dataTableFilter-static)', function(obj){
        var data = obj.data;
        if (obj.event === 'view'){
            $('[data-box="static-view"]').show();
        } else if(obj.event === 'editor'){
            $('[data-box="static-editor"]').show();
        } else if(obj.event === 'verify'){
            $('[data-box="static-verify"]').show();
        } else if(obj.event === 'del'){
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

    // 照片库
    table.on('tool(dataTableFilter-photos)', function(obj){
        var data = obj.data;
        $('body').addClass('overflow-hidden');
        if(obj.event === 'view'){
            $('[data-box="photos-views"]').show();
        } else if(obj.event === 'editor'){
            $('[data-box="photos-editor"]').show();
        } else if(obj.event === 'verify'){
            $('[data-box="photos-verify"]').show();
        } else if(obj.event === 'del'){
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

    // 视频库
    table.on('tool(dataTableFilter-videos)', function(obj){
        var data = obj.data;
        $('body').addClass('overflow-hidden');
        if(obj.event === 'view'){
            $('[data-box="videos-views"]').show();
        } else if(obj.event === 'editor'){
            $('[data-box="videos-editor"]').show();
        } else if(obj.event === 'verify'){
            $('[data-box="videos-verify"]').show();
        } else if(obj.event === 'del'){
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

    // var $ = layui.$, active = {
    //     getCheckData: function(){ //获取选中数据
    //         var checkStatus = table.checkStatus('dataTable-books'),
    //             data = checkStatus.data;
    //         layer.alert(JSON.stringify(data));
    //     },
    //     getCheckLength: function(){ //获取选中数目
    //         var checkStatus = table.checkStatus('dataTable-books'),
    //             data = checkStatus.data;
    //         layer.msg('选中了：'+ data.length + ' 个');
    //     },
    //     isAll: function(){ //验证是否全选
    //         var checkStatus = table.checkStatus('dataTable-books');
    //         layer.msg(checkStatus.isAll ? '全选': '未全选')
    //     }
    // };
    //
    // $('dataTableHeaderTools-books .btn').on('click', function(){
    //     var type = $(this).data('type');
    //     active[type] ? active[type].call(this) : '';
    // });

    // function __readyTooltips() {
    //     var nodes = $('.layui-table-main td[data-field="content"] > div');
    //     for (var i = 0; i < nodes.length; i++){
    //         $(nodes[i]).attr({
    //             'data-toggle': 'tooltip',
    //             'data-placement': 'bottom',
    //             'title': nodes[i].innerText,
    //         });
    //     }
    //     $('[data-toggle="tooltip"]').tooltip();
    // }

});

$(function () {

    $('select.chosen-select').chosen({
        no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
        disable_search_threshold: 10, // 10 个以下的选择项则不显示检索框
        search_contains: true         // 从任意位置开始检索
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

    // 初始化内容编辑器
    __readyContentEditor();

    // 电子书
    $('.menu-books-add').click(function () {
        $('[data-box="books-editor"]').show();
    });

    $('[data-btn="show-search-toolbar-books"]').click(function () {
        $('[data-sort="books"]').show();
        $('[data-filter="assets-books"]').hide();
    });
    $('[data-btn="hide-search-toolbar-books"]').click(function () {
        $('[data-sort="books"]').hide();
        $('[data-filter="assets-books"]').show();
    });

    $('[data-btn="books-show-cover"]').click(function () {
        $(this).hide();
        $('#dataTableCell-books').hide();
        $('[data-btn="books-show-list"], #dataListCell-books').show();
    });
    $('[data-btn="books-show-list"]').click(function () {
        $(this).hide();
        $('#dataListCell-books').hide();
        $('[data-btn="books-show-cover"], #dataTableCell-books').show();
    });

    $('[data-btn="books-fengmian-zhangjie"]').click(function () {
        var type = $(this).data('show');
        if (type === 'zhangjie'){
            $('[data-box="books-fengmian"]').hide();
            $('[data-box="books-zhangjie"]').show();
        }
        if (type === 'fengmian'){
            $('[data-box="books-fengmian"]').show();
            $('[data-box="books-zhangjie"]').hide();
        }
    });

    $('.single-slider').jRange({
        from: 18, //最小值
        to: 32, //最大值
        step: 2, //每次拖动
        scale: [20, 22, 24, 26, 28, 30],
        theme: "theme-blue",//主题:theme-green / theme-blue
        width: 240,
        snap: true,
        // 数字变化的时候的回调
        onstatechange: function () {
            var size = $(".single-slider").val();
            console.log(size);
            var DOM = $('[data-document="books-view"] *');
            DOM.css({
                fontSize: size + 'px',
                lineHeight: size * 1.618 + 'px'
            });
        },
    });

    // 选中
    $("[data-box='books-list-cover'] .tools input[type='checkbox']").change(function(){
        var data = $(this).is(':checked');
        if(data){
            $(this).prop("checked", true);
            $(this).parent().addClass('active');
        } else {
            $(this).prop("checked", false);
            $(this).parent().removeClass('active');
        }
    });

    $('[data-icon="books-close"]').click(function () {
        $('[data-box="books-view"]').hide();
        $('body').removeClass('overflow-hidden');
    });
    $('[data-icon="books-verify-close"]').click(function () {
        $('[data-box="books-verify"]').hide();
        $('body').removeClass('overflow-hidden');
    });
    $('[data-icon="books-show-directory"]').click(function () {
        $('[data-box="books-directory"]').show();
    });
    $('[data-box="books-directory"] .mask').click(function () {
        $('[data-box="books-directory"]').hide();
    });

    $('[data-btn="btn-books-search"]').click(function () {
        $('[data-box="books-search"]').show();
    });
    $('[data-box="books-search"] .mask').click(function () {
        $('[data-box="books-search"]').hide();
    });

    $('[data-btn="books-editor-close"]').click(function () {
        $('[data-box="books-editor"]').hide();
        $('body').removeClass('overflow-hidden');
    });
    $('[data-btn="books-verify-ok"]').click(function () {
        swal({
            title: "提示",
            text: "审核成功",
            type: "success"
        });
    });
    $('[data-btn="books-verify-no"]').click(function () {
        swal({
            title: "是否确定审核不通过？",
            // text: "text",
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false
        }, function () {
            swal("提示", "操作成功", "success");
        });
    });

    // 图文资料
    $('.menu-static-add').click(function () {
        $('[data-box="static-editor"]').show();
    });
    $('[data-btn="close-static-editor"]').click(function () {
        $('[data-box="static-editor"]').hide();
    });
    $('[data-btn="close-static-verify"]').click(function () {
        $('[data-box="static-verify"]').hide();
    });
    $('[data-btn="show-search-toolbar-static"]').click(function () {
        $('[data-sort="static"]').show();
        $('[data-filter="assets-static"]').hide();
    });
    $('[data-btn="hide-search-toolbar-static"]').click(function () {
        $('[data-sort="static"]').hide();
        $('[data-filter="assets-static"]').show();
    });

    $('[data-btn="static-editor-close"]').click(function () {
        $('[data-box="static-view"]').hide();
    });

    // 照片库
    $('.menu-photos-add').click(function () {
        $('[data-box="photos-add"]').show();
    });
    $('[data-btn="close-photos-add"]').click(function () {
        $('[data-box="photos-add"]').hide();
    });
    $('[data-btn="show-search-toolbar-photos"]').click(function () {
        $('[data-filter="assets-photos"]').hide();
        $('[data-search="photos"]').show();
    });
    $('[data-btn="hide-search-toolbar-photos"]').click(function () {
        $('[data-search="photos"]').hide();
        $('[data-filter="assets-photos"]').show();
    });


    $('[data-btn="photos-views-close"]').click(function () {
        $('[data-box="photos-views"]').hide();
    });
    $('[data-btn="photos-editor-close"]').click(function () {
        $('[data-box="photos-editor"]').hide();
    });
    $('[data-btn="photos-verify-close"]').click(function () {
        $('[data-box="photos-verify"]').hide();
    });

    $('[data-btn="assets-photos-toggle-cover"]').click(function () {
        $(this).children('i').toggleClass('glyphicon-list');
        $('#dataTable-photos-cell').toggleClass('d-none');
        $('#dataCover-photos').toggleClass('d-none');
    });

    $(".cover-photos input[type='checkbox']").change(function(){
        var data = $(this).is(':checked');
        if(data){
            $(this).prop("checked", true);
            $(this).parent().addClass('active');
        } else {
            $(this).prop("checked", false);
            $(this).parent().removeClass('active');
        }
    });

    // 视频库
    $('.menu-videos-add').click(function () {
        $('[data-box="videos-add"]').show();
    });
    $('[data-btn="close-videos-add"]').click(function () {
        $('[data-box="videos-add"]').hide();
    });
    $('[data-btn="show-search-toolbar-videos"]').click(function () {
        $('[data-sort="videos"]').show();
        $('[data-filter="assets-videos"]').hide();
    });
    $('[data-btn="hide-search-toolbar-videos"]').click(function () {
        $('[data-sort="videos"]').hide();
        $('[data-filter="assets-videos"]').show();
    });

    $('[data-btn="videos-views-close"]').click(function () {
        $('[data-box="videos-views"]').hide();
    });
    $('[data-btn="videos-editor-close"]').click(function () {
        $('[data-box="videos-editor"]').hide();
    });
    $('[data-btn="videos-verify-close"]').click(function () {
        $('[data-box="videos-verify"]').hide();
    });

    $('[data-btn="assets-videos-toggle-cover"]').click(function () {
        $(this).children('i').toggleClass('glyphicon-list');
        $('#dataTable-videos-cell').toggleClass('d-none');
        $('#dataCover-videos').toggleClass('d-none');
    });

    $(".cover-vidoes input[type='checkbox']").change(function(){
        var data = $(this).is(':checked');
        if(data){
            $(this).prop("checked", true);
            $(this).parent().addClass('active');
        } else {
            $(this).prop("checked", false);
            $(this).parent().removeClass('active');
        }
    });


    $('.assets-all-verify-ok, .assets-all-verify-no').click(function () {
        swal({
            title: "提示",
            text: "操作成功",
            type: "success"
        });
    });
    $('[data-btn="assets-all-delete"]').click(function () {
        swal({
            title: "您确定要删除选中信息吗",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false
        }, function () {
            swal("提示", "操作成功", "success");
        });
    });

    $('[data-btn="init-fullscreen"]').click(function () {
        fullScreen();
        $('[data-btn="exit-fullscreen"]').show();
    });
    $('[data-btn="exit-fullscreen"]').click(function () {
        exitScreen();
        $(this).hide();
    });

    // 监听键盘按键ESC
    document.onkeydown = function(e){
        let keyCode = window.event.keyCode;
        if(keyCode === 27){ // 键值 27
            $('[data-btn="exit-fullscreen"]').hide();
        }
    }

});

// 全屏
function fullScreen(){
    var el = document.documentElement;
    var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen;

    // typeof rfs != "undefined" && rfs
    if (rfs) {
        rfs.call(el);
    } else if (typeof window.ActiveXObject !== "undefined") {
        //for IE，这里其实就是模拟了按下键盘的F11，使浏览器全屏
        var wscript = new ActiveXObject("WScript.Shell");
        if (wscript != null) {
            wscript.SendKeys("{F11}");
        }
    }
}

//退出全屏
function exitScreen(){
    var el = document;
    var cfs = el.cancelFullScreen || el.webkitCancelFullScreen || el.mozCancelFullScreen || el.exitFullScreen;

    //typeof cfs != "undefined" && cfs
    debugger
    if (cfs) {
        cfs.call(el);
    } else if (typeof window.ActiveXObject !== "undefined") {
        //for IE，这里和fullScreen相同，模拟按下F11键退出全屏
        var wscript = new ActiveXObject("WScript.Shell");
        if (wscript != null) {
            wscript.SendKeys("{F11}");
        }
    }
}

// 初始化 编辑器
function __readyContentEditor() {
    var html = '编辑器内容...';

    KindEditor.ready(function(K) {
        window.editor = K.create('#contentEditorStaticEditor');
        editor.html(html);
    });

    KindEditor.ready(function(K) {
        window.editor = K.create('#contentEditor');
        editor.html(html);
    });
}