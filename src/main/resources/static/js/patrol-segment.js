/**
 * ***********************************************************************************************
 * patrol segment js
 * ***********************************************************************************************
 */

var tableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '编号', width: 64,},
    {field: 'name', title: '责任段名称', sort: true},
    {field: 'size', title: '巡防点数', sort: true},
    {field: 'teams', title: '关联小组', sort: true},
    {field: 'leader', title: '负责人', sort: true},
    {field: 'createTime', title: '创建时间', sort: true},
    {field: 'status', title: '状态', templet: '#status', sort: true}, // 0正常 1删除
    {
        title: '操作',
        toolbar: '#dataTable-action',
        align: 'center',
        width: 144,
    }
];

var tableData = [];
for (var i = 0; i <= 5; i++){
    tableData.push({
        id: i,
        name: '责任段'+ i,
        size: i,
        teams: '小组' + i,
        leader: '负责人' + i,
        createTime: moment(new Date().getTime()).format('YYYY-DD-MM hh:mm:ss'),
        status: i,
    });
}

layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#dataTable',
        cols: [tableColumns],
        data: tableData,
        page: true,
        limits: [15, 30, 50, 100, 200],
        limit: 15,
        skin: 'line', // 行边框风格
        even: true, // 启用斑马纹背景
    });

    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTable-filter)', function(obj){
        var data = obj.data;
        if(obj.event === 'add'){
            $('#patrolMaker').modal({
                show: true
            });
        } else if(obj.event === 'editor'){
            $('#changeSegment').modal({
                show: true
            });
        } else if(obj.event === 'view'){
            $('#patrolMaker').modal({
                show: true
            });
        } else if(obj.event === 'delete'){
            console.log(data);
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

    tooltips();

});

function tooltips() {
    var button = $('.layui-table-cell button');
    for (var i = 0; i < button.length; i++){
        $(button[i]).attr({
            'data-toggle': 'tooltip',
            'data-placement': 'bottom',
        });
    }
    $('[data-toggle="tooltip"]').tooltip();
}

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

    // 选择用户
    var users = $('[data-box="avatar-cell"]');
    users.click(function () {
        $(this).toggleClass('active');
    });

    $('[data-btn="all-delete"]').click(function () {
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
    });
});