
/**
 * ztree.js
 * @type {{data: {simpleData: {enable: boolean}}, check: {enable: boolean}}}
 */

var sectTreeClickNode = null;

var sectTreeCheckedNode = null;

var setting = {
    callback: {
        onClick: onTreeClick,
        onCheck: onTreeChecked,
    },
};

var zTree;

var zNodes = [
    {
        name: "执勤交通",
        open: true,
        children: [
            {
                name: "执勤道路",
                type: 'daolu',
                icon: 'plugins/ztree/icon/daolu-color@16px.png',
            },
            {
                name: "桥梁",
                type: 'qiaoliang',
                icon: 'plugins/ztree/icon/qiaoliang-color@16px.png',
            },
            {
                name: "码头",
                type: 'matou',
                icon: 'plugins/ztree/icon/matou-color@16px.png',
            },
        ]
    },
    {
        name: "拦阻报警",
        open: true,
        noR: true,
        checked: false,
        showIcon: false,
        children: [
            {
                name: "铁丝网",
                type: 'tiesiwang',
                icon: 'plugins/ztree/icon/daolu-color@16px.png',
            },
        ]
    },
];

// 点击节点
function onTreeClick(event, treeId, treeNode, clickFlag){
    console.log('this.onTreeClick---------->', event, treeId, treeNode, clickFlag);
    sectTreeClickNode = {};
    sectTreeClickNode = {
        event: event,
        treeId: treeId,
        treeNode: treeNode,
        clickFlag: clickFlag,
    };
    if (treeNode.level !== 0){
        $('[data-title="table"]').text(treeNode.name);
        toggleTreeNodes(treeNode.type);
    } else {
        // 根节点 点击 无效
        return false;
    }
}

// 勾选节点
function onTreeChecked(event, treeId, treeNode, clickFlag){
    console.log('this.onTreeChecked---------->', event, treeId, treeNode, clickFlag);
    sectTreeCheckedNode = {};
    sectTreeCheckedNode = {
        event: event,
        treeId: treeId,
        treeNode: treeNode,
        clickFlag: clickFlag,
    };
    if (treeNode.level !== 0){
        $('[data-title="title-assets"]').text(treeNode.name);
        $('[data-tips="content-assets"]').hide();
        $('[data-box="assets-editable"]').show();
    } else {
        return false;
    }
}

$(function(){
    $.fn.zTree.init($("#driverTree"), setting, zNodes);
    zTree = $.fn.zTree.getZTreeObj("driverTree");

    // 选择用户
    var shareUsers = $('#selectShareUsers [data-box="avatar-cell"]');
    shareUsers.click(function () {
        $(this).toggleClass('active');
    });
});

/**
 * 切换 数节点
 * @param data
 * @returns {boolean}
 */
function toggleTreeNodes(data){
    console.log('this.type---------->', data);
    if (!data){
        return false;
    }
}