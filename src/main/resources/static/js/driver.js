/**
 * ***********************************************************************************************
 * driver js
 * ***********************************************************************************************
 */

var tableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'name', title: '项目名称', sort: true},
    {field: 'driverType', title: '建设类型', width: 110, templet: '#driverType', sort: true},
    {field: 'driverArea', title: '建设区域', sort: true},
    {field: 'mapType', title: '地形类别', templet: '#subType', sort: true},
    {field: 'useDepartment', title: '使用单位', templet: '#infoType', sort: true},
    {field: 'magDepartment', title: '管理单位', sort: true},
    {field: 'driverSize', title: '建设规模', sort: true},
    {field: 'driverStatus', title: '建设状态', templet: '#driverStatus', sort: true},
    {field: 'useStatus', title: '使用状态', templet: '#useStatus', sort: true},
    {
        title: '操作',
        toolbar: '#rowTools',
        align: 'center',
        width: 108,
    }
];
var tableData = [];

function readDriverTable(data) {
    tableData = [];
    for (var i = 1; i <= data; i++){
        tableData.push({
            id: i,
            name: '项目名称' + i,
            driverType: i,
            driverArea: '建设区域' + i,
            mapType: '地形' + i,
            useDepartment: '使用单位' + i,
            magDepartment: '管理单位' + i,
            driverSize: '规模' + i,
            driverStatus: i,
            useStatus: i,
        });
    }
}

layui.use(['table'], function(){
    var table = layui.table;

    readDriverTable(5);
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
        console.log(data);
        if(obj.event === 'change'){
            $('[data-change="baosong"]').show();
        } else if(obj.event === 'print'){
            layer.alert('打印');
        } else if(obj.event === 'del'){
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

$(function () {

    $('[data-show="driver-sharch"]').click(function () {
        $('[data-search="driver"]').show();
    });
    $('[data-hide="driver-search"]').click(function () {
        $('[data-search="driver"]').hide();
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

    $('select.chosen-select').chosen({
        no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
        disable_search_threshold: 10, // 10 个以下的选择项则不显示检索框
        search_contains: true         // 从任意位置开始检索
    });

    $('[data-btn="delete-all"]').click(function () {
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