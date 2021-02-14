/**
 * ***********************************************************************************************
 * system user js
 * ***********************************************************************************************
 */

/**
 * 用户
 */
var userTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'userName', title: '用户名', sort: true},
    {field: 'realName', title: '真实姓名', sort: true},
    {field: 'isAdmin', title: '是否管理员', sort: true},
    {field: 'department', title: '部门', sort: true},
    {field: 'status', title: '状态', sort: true},
    {
        // fixed: 'right',
        title: '操作',
        toolbar: '#dataTableRowTools-user',
        align: 'center',
        width: 150,
    }
];

var userTableData = [];
for (var i = 0; i <= 5; i++){
    userTableData.push({
        id: i,
        userName: '用户名' + i,
        realName: '真实姓名' + i,
        isAdmin: true,
        department: '部门' + i,
        status: true,
    });
}

layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#dataTable-user',
        cols: [userTableColumns],
        data: userTableData,
        page: true,
        limits: [15, 30, 50, 100, 200],
        limit: 15,
        skin: 'line', // 行边框风格
        even: true, // 启用斑马纹背景
    });

    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTableFilter-user)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){

        } else if(obj.event === 'send'){
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

    $('[data-btn="show-search-toolbar-user"]').click(function () {
        $('[data-search="user"]').show();
    })
    $('[data-btn="hide-search-toolbar-user"]').click(function () {
        $('[data-search="user"]').hide();
    })
});