/**
 * ***********************************************************************************************
 * system dict js
 * ***********************************************************************************************
 */

/**
 * 字典
 */
var dictTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'name', title: '字典名', sort: true},
    {field: 'value', title: '字典值', sort: true},
    {field: 'info', title: '概要', sort: true},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-dict',
        align: 'center',
        width: 100,
    }
];

var dictTableData = [];
for (var i = 0; i <= 5; i++){
    dictTableData.push({
        id: i,
        name: '字典名' + i,
        value: '字典值' + i,
        info: '概要' + i,
    });
}

layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#dataTable-dict',
        cols: [dictTableColumns],
        data: dictTableData,
        page: true,
        limits: [15, 30, 50, 100, 200],
        limit: 15,
        skin: 'line', // 行边框风格
        even: true, // 启用斑马纹背景
    });

    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTableFilter-dict)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            console.log(data);
        } else if(obj.event === 'del'){
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
});

$('select.chosen-select').chosen({
    no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
    disable_search_threshold: 10, // 10 个以下的选择项则不显示检索框
    search_contains: true         // 从任意位置开始检索
});

$(function () {

    var dictTypeList = $('.dict-type-list a');

    dictTypeList.removeClass('active');
    dictTypeList.click(function () {
        dictTypeList.removeClass('active');
        $(this).addClass('active');
    });

    $('[data-btn="delete-all-dict"]').click(function () {
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