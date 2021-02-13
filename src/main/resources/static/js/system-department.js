/**
 * ***********************************************************************************************
 * system department js
 * ***********************************************************************************************
 */

/**
 * 部门
 */
var departmentTableColumns  = [
    {field: 'authorityName', title: '机构名称'},
    {field: 'authorityId', title: '机构编号'},
    {field: 'authorityType', title: '机构类型'},
    {
        title: '操作',
        width: 120,
        toolbar: '#dataTable-department-toolbar',
        align: 'center',
    }
];

var departmentTableData = [
    {
        authorityName: "系统管理",
        authorityId: 1,
        authorityType: '部门',

        isMenu: 0,
        parentId: -1,
        open: true
    },
    {
        authorityName: "用户管理",
        authorityId: 2,
        authorityType: '部门',

        isMenu: 0,
        parentId: 1,
        open: true,
    },
    {
        authorityName: "查询用户",
        authorityId: 3,
        authorityType: '部门',

        isMenu: 1,
        parentId: 2,
        open: true
    },
];

var dataTableDepartmentPeoplesColumns = [
    {type:'checkbox'},
    {field: 'id', title: '序号', sort: true},
    {field: 'userName', title: '用户名', sort: true},
    {field: 'realName', title: '真实姓名', sort: true},
    {field: 'isAdmin', title: '是否管理与', sort: true},
    {field: 'status', title: '状态', sort: true},
    {
        title: '操作',
        toolbar: '#dataTableRowTools-department-people',
        width: 80,
    }
];
var dataTableDepartmentPeoplesData = [];

layui.config({
    base: 'plugins/layui/'
}).use(['layer', 'table', 'treeTable'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var treeTable = layui.treeTable;

    // 渲染表格
    var insTb = treeTable.render({
        elem: '#dataTable-department',
        data: departmentTableData,
        cols: departmentTableColumns,
        tree: {
            isPidData: true,
            idName: 'authorityId',
            pidName: 'parentId'
        },
        page: true,
        limits: [15, 30, 50, 100, 200],
        limit: 15,
        skin: 'line', // 行边框风格
        even: true, // 启用斑马纹背景
    });

    for (var i = 0; i < 3; i++){
        dataTableDepartmentPeoplesData.push({
            id: i,
            userName: '用户名' + i,
            realName: '真实姓名' + i,
            isAdmin: true,
            status: '状态' + i,
        });
    }

    // 工具列点击事件
    treeTable.on('tool(dataTable-department)', function (obj) {
        var event = obj.event;
        if (event === 'editor'){
            $('#changeDepartment').modal({
                show: true,
            });
        } else if (event === 'view') {
            $('#dataTableCell-department-peoples').show();
            table.render({
                elem: '#dataTable-department-peoples',
                cols: [dataTableDepartmentPeoplesColumns],
                data: dataTableDepartmentPeoplesData,
                page: true,
                limits: [15, 30, 50, 100, 200],
                limit: 15,
                skin: 'line', // 行边框风格
                even: true, // 启用斑马纹背景
            });
        } else if (event === 'del') {
            layer.msg('删除成功');
        }
    });
});

$(function () {

    $('select.chosen-select').chosen({
        no_results_text: '没有找到',    // 当检索时没有找到匹配项时显示的提示文本
        disable_search_threshold: 10, // 10 个以下的选择项则不显示检索框
        search_contains: true         // 从任意位置开始检索
    });

    $('[data-btn="department-add"]').click(function () {

    })
});