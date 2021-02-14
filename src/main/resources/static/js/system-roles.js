/**
 * ***********************************************************************************************
 * system roles js
 * ***********************************************************************************************
 */

/**
 * 角色
 */
var rolesTableColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', width: 64,},
    {field: 'name', title: '角色名', sort: true},
    {field: 'user', title: '关联用户', sort: true},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-roles',
        align: 'center',
        width: 110,
    }
];

var rolesTableData = [];
for (var i = 0; i <= 5; i++){
    rolesTableData.push({
        id: i,
        name: '超级管理员',
        user: i,
    });
}

layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#dataTable-roles',
        cols: [rolesTableColumns],
        data: rolesTableData,
        page: true,
        limits: [15, 30, 50, 100, 200],
        limit: 15,
        skin: 'line', // 行边框风格
        even: true, // 启用斑马纹背景
    });

    /**
     ******************** 监听工具条 ********************
     */
    table.on('tool(dataTableFilter-roles)', function(obj){
        var data = obj.data;
        if(obj.event === 'editor'){
            $('#changeRoles').modal({
                show: true,
            })
        } else if(obj.event === 'auth'){
            $('#rolseMenuGroup').show();
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