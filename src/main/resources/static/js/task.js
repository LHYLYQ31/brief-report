/**
 * ***********************************************************************************************
 * task js
 * ***********************************************************************************************
 */

/**
 * 任务
 */
var taskTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'taskName', title: '任务名称', sort: true},
    {field: 'department', title: '主办单位', sort: true},
    {field: 'zerenUser', title: '责任人', sort: true},
    {field: 'jianguanUser', title: '监管人', sort: true},
    {field: 'childTask', title: '子任务', templet: '#childTask', sort: true},
    {field: 'taskStatus', title: '任务状态', templet: '#taskStatus', sort: true},
    {field: 'cuibanStatus', title: '催办状态', templet: '#cuibanStatus', sort: true},
    {field: 'taskProgress', title: '进度', templet: '#taskProgress', sort: true},
    {field: 'newHuibao', title: '新汇报', templet: '#newHuibao', sort: true},
    {field: 'time', title: '限时结办', sort: true},
    {
        title: '操作',
        toolbar: '#dataTableTools-task',
        align: 'center',
        width: 150,
    }
];

var taskTableData = [];
for (var i = 1; i <= 6; i++){
    taskTableData.push({
        id: i,
        taskName: '任务名称' + i,
        department: '主办单位' + i,
        zerenUser: '责任人' + i,
        jianguanUser: '监管人' + i,
        childTask: i,
        taskStatus: i,
        cuibanStatus: i,
        taskProgress: i,
        newHuibao: i,
        time: '2020-12-31 00:00:00',
    });
}

layui.use('element', function(){
    var element = layui.element;
});

layui.use('table', function(){
    var table = layui.table;

    readTable(6);

    $('[data-btn="task-back-all"]').click(function () {
        $(this).hide();
        readTable(6);
    });
    $('[data-switch="task-type"]').click(function () {
        $('[data-btn="task-back-all"]').hide();
        $('[data-switch="task-type"]').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        var type = $(this).data('type');

        if (type === 1){

            readTable(6);
        }
        if (type === 2){
            readTable(10);
        }
    });

    function readTable(data) {
        taskTableData = [];
        for (var i = 1; i <= data; i++){
            taskTableData.push({
                id: i,
                taskName: '任务名称' + i,
                department: '主办单位' + i,
                zerenUser: '责任人' + i,
                jianguanUser: '监管人' + i,
                childTask: i,
                taskStatus: i,
                cuibanStatus: i,
                taskProgress: i,
                newHuibao: i,
                time: '2020-12-31 00:00:00',
            });
        }
        table.render({
            elem: '#dataTable-task',
            cols: [taskTableColumns],
            data: taskTableData,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    __readyTooltips();

    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTableFilter-task)', function(obj){
        var data = obj.data;
        if(obj.event === 'editor'){
            $('[data-box="taskChange"]').show();
        } else if(obj.event === 'child'){
            readTable(3);
            $('[data-btn="task-back-all"]').show();
        } else if(obj.event === 'cuiban'){
            swal("提示", "催办成功", "success");
        } else if(obj.event === 'del'){
            console.log(data);
            swal({
                title: "提示",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                cancelButtonText: "取消",
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "删除",
                closeOnConfirm: false
            }, function () {
                swal("提示", "删除成功", "success");
            });
        }
    });

});

function __readyTooltips() {
    var nodes = $('[data-field="taskName"] > div');
    for (var i = 0; i < nodes.length; i++){
        $(nodes[i]).attr({
            'data-toggle': 'tooltip',
            'data-placement': 'bottom',
            'title': nodes[i].innerText,
        });
    }
    $('[data-toggle="tooltip"]').tooltip();
}

$(function () {

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

    $('select.chosen-select').chosen({
        no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
        disable_search_threshold: 10, // 10 个以下的选择项则不显示检索框
        search_contains: true         // 从任意位置开始检索
    });

    $('[data-btn="show-search-task"]').click(function () {
        $('[data-search="task"]').show();
        $('[data-sort="task"]').hide();
    });
    $('[data-btn="hide-search-task"]').click(function () {
        $('[data-search="task"]').hide();
        $('[data-sort="task"]').show();
    });

    $('[data-hide="taskChange"]').click(function () {
        $('[data-box="taskChange"]').hide();
    });

    $('[data-btn="delete-all-task"]').click(function () {
        swal({
            title: "提示",
            text: "删除后将无法恢复，请谨慎操作！",
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "删除",
            closeOnConfirm: false
        }, function () {
            swal("提示", "删除成功", "success");
        });
    });

    // 选择用户
    var selectUser = $('[data-box="avatar-cell"]');
    selectUser.click(function () {
        $(this).toggleClass('active');
    });

});