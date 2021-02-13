/**
 * ***********************************************************************************************
 * jianbao js
 * ***********************************************************************************************
 */

/**
 * 简报
 */

var jianbaoType = 1;

var tableColumnsBaosong = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'title', title: '标题', sort: true},
    {field: 'user', title: '上报人', sort: true},
    {field: 'department', title: '上报单位', sort: true},
    {field: 'subType', title: '提交类型', templet: '#subType-baosong', sort: true},
    {field: 'infoType', title: '信息类型', templet: '#infoType-baosong', sort: true},
    {field: 'status', title: '状态', templet: '#status-baosong', sort: true},
    {field: 'accept', title: '采用情况', templet: '#accept-baosong', sort: true},
    {field: 'time', title: '发布时间', sort: true},
    {
        title: '操作',
        toolbar: '#rowTools-baosong',
        align: 'center',
        width: 108,
    }
];
var tableDataBaosong = [];





var tableColumnsFankui = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'title', title: '标题', sort: true},
    {field: 'user', title: '上报人', sort: true},
    {field: 'department', title: '上报单位', sort: true},
    {field: 'subType', title: '上报类型', templet: '#subType-fankui', sort: true},
    {field: 'infoType', title: '信息类型', templet: '#infoType-fankui', sort: true},
    {field: 'content', title: '反馈内容', templet: '#content-fankui', sort: true},
    {field: 'reply', title: '批示内容', templet: '#reply-fankui', sort: true},
    {field: 'time', title: '上报时间', sort: true},
    {
        title: '操作',
        toolbar: '#rowTools-fankui',
        align: 'center',
        width: 80,
    }
];
var tableDataFankui = [];





var tableColumnsReports = [
    {field: 'department', title: '单位', sort: true},
    {field: 'subNumber', title: '报送数量', sort: true},
    {field: 'adoptNumber', title: '被采用数量', sort: true},
    {field: 'adoptRatio', title: '被采用率', sort: true},
    {field: 'replyNumber', title: '领导批示数量', sort: true},
    {field: 'replyRatio', title: '领导批示占比', sort: true},
    {field: 'content', title: '批示内容', sort: true},
];
var tableDataReports = [];

layui.use(['table'], function(){
    var table = layui.table;

    $('[data-switch="baosong"]').click(function () {
        $('[data-switch="baosong"]').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        readTableBaosong($(this).data('type') * 5);
    });

    readTableBaosong(5);
    function readTableBaosong(data) {
        tableDataBaosong = [];
        for (var i = 1; i <= data; i++){
            tableDataBaosong.push({
                id: i,
                title: '标题' + i,
                user: '上报人' + i,
                department: '上报单位' + i,
                subType: i,
                infoType: i,
                status: i,
                accept: i,
                time: '2020-12-31 00:00:00',
            });
        }
        table.render({
            elem: '#dataTable-baosong',
            cols: [tableColumnsBaosong],
            data: tableDataBaosong,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }


    $('[data-switch="fankui"]').click(function () {
        $('[data-switch="fankui"]').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        readTableFankui($(this).data('type') * 10);
    });

    readTableFankui(5);
    function readTableFankui(data) {
        tableDataFankui = [];
        for (var i = 1; i <= data; i++){
            tableDataFankui.push({
                id: i,
                title: '标题' + i,
                user: '上报人' + i,
                department: '上报单位' + i,
                subType: i,
                infoType: i,
                content: '反馈内容' + i,
                reply: '批示内容' + i,
                time: '2020-12-31 00:00:00',
            });
        }
        table.render({
            elem: '#dataTable-fankui',
            cols: [tableColumnsFankui],
            data: tableDataFankui,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    $('[data-switch="reports"]').click(function () {
        $('[data-switch="reports"]').removeClass('btn-success').addClass('btn-default');
        $(this).addClass('btn-success');
        $('[data-charts="reports"], [data-table="reports"], [data-show-search="reports"]').hide();
        if ($(this).data('type') === 1){
            $('[data-charts="reports"]').show();
        }
        if ($(this).data('type') === 2){
            $('[data-table="reports"], [data-show-search="reports"]').show();
            readTableReports($(this).data('type') * 5);
        }
    });
    function readTableReports(data) {
        tableDataReports = [];
        for (var i = 1; i <= data; i++){
            tableDataReports.push({
                department: '单位' + i,
                subNumber: i,
                adoptNumber: i,
                adoptRatio: i + '%',
                replyNumber: i,
                replyRatio: i + '%',
                content: '批示内容' + i,
            });
        }
        table.render({
            elem: '#dataTable-reports',
            cols: [tableColumnsReports],
            data: tableDataReports,
            page: true,
            limits: [15, 30, 50, 100, 200],
            limit: 15,
            skin: 'line', // 行边框风格
            even: true, // 启用斑马纹背景
        });
    }

    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTableFilter-baosong)', function(obj){
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
    table.on('tool(dataTableFilter-fankui)', function(obj){
        var data = obj.data;
        console.log(data);
        if(obj.event === 'change'){
            $('[data-change="fankui"]').show();
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

    $('[data-btn="change-baosong"]').click(function () {
        $('[data-change="baosong"]').show();
    });

    $('[data-menu="jianbao"] a').click(function () {
        $('[data-menu="jianbao"] a').removeClass('active');
        $(this).addClass('active');
        jianbaoType = $(this).data('type');
        console.log('this.jianbaoType---------->', jianbaoType);
        $('[data-table="baosong"], [data-table="fankui"], [data-table="tongji"]').hide();
        if (jianbaoType === 1){
            $('[data-table="baosong"]').show();
        } else if (jianbaoType === 2){
            $('[data-table="fankui"]').show();
        } else {
            $('[data-table="tongji"]').show();
            __baosongNumberReports();
            __baosongAcceptReports();
        }
        $('[data-title="table"]').text($(this).text());
    });

    $('[data-show-sharch="baosong"]').click(function () {
        $('[data-search="baosong"]').show();
        $('[data-sort="baosong"]').hide();
    });
    $('[data-hide="baosong-search"]').click(function () {
        $('[data-search="baosong"]').hide();
        $('[data-sort="baosong"]').show();
    });
    $('[data-close="change-baosong"]').click(function () {
        $('[data-change="baosong"]').hide();
    });

    $('[data-show-search="fankui"]').click(function () {
        $('[data-sort="fankui"]').hide();
        $('[data-search="fankui"]').show();
    });
    $('[data-hide-search="fankui"]').click(function () {
        $('[data-sort="fankui"]').show();
        $('[data-search="fankui"]').hide();
    });


    $('[data-close="change-fankui"]').click(function () {
        $('[data-change="fankui"]').hide();
    });

    $('[data-show-search="reports"]').click(function () {
        $('[data-sort="reports"]').hide();
        $('[data-search="reports"]').show();
    });
    $('[data-hide-search="reports"]').click(function () {
        $('[data-sort="reports"]').show();
        $('[data-search="reports"]').hide();
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

    __readyContentEditor();

});

// 初始化 编辑器
function __readyContentEditor() {
    var html = '编辑器内容...';

    KindEditor.ready(function(K) {
        window.editor = K.create('#contentEditorBaosong');
        editor.html(html);
    });

    KindEditor.ready(function(K) {
        window.editor = K.create('#contentEditorFankui');
        editor.html(html);
    });
}

function __baosongNumberReports() {
    var charts = echarts.init(document.getElementById('__baosongNumberReports'));

    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['报送数量', '采用数量']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['2020/01', '2020/02', '2020/03', '2020/04', '2020/05', '2020/06']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '报送数量',
                type: 'bar',
                data: [320, 332, 320, 332, 320, 332],
                itemStyle: {
                    color: '#166cfa'
                }
            },
            {
                name: '采用数量',
                type: 'bar',
                data: [120, 132, 120, 132, 120, 132],
                itemStyle: {
                    color: '#3dcd9b'
                }
            }
        ]
    };
    charts.setOption(option);
}

function __baosongAcceptReports() {
    var charts = echarts.init(document.getElementById('__baosongAcceptReports'));

    var option = {
        tooltip: {
            trigger: 'item'
        },
        legend: {
            top: '0',
            left: 'center'
        },
        series: [
            {
                name: '统计',
                type: 'pie',
                radius: '75%',
                data: [
                    {
                        value: 735,
                        name: '报送数量',
                        itemStyle: {
                            color: '#166cfa'
                        }
                    },
                    {
                        value: 1048,
                        name: '采用数量',
                        itemStyle: {
                            color: '#3dcd9b'
                        }
                    },
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    charts.setOption(option);
}