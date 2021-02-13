
/**
 * ztree.js
 * @type {{data: {simpleData: {enable: boolean}}, check: {enable: boolean}}}
 */

var sectTreeClickNode = null;

var sectTreeCheckedNode = null;

var setting = {
    view: {
        dblClickExpand: false,
    },
    check: {
        enable: false,
        chkStyle: "radio",
        radioType: "level"
    },
    callback: {
        onRightClick: OnRightClick,
        onClick: onTreeClick,
        onCheck: onTreeChecked,
    }
};

var orgNodes =[
    {
        name: "自治区边海防办",
        open: true,
        noR: true,
        checked: false,
        children:[
            {
                name: "崇左市",
                noR: false,
                open: true,
                children:[
                    {
                        name: "宁明县",
                        noR: true,
                        open: true,
                    },
                    {
                        name: "龙州县",
                        noR: true,
                        open: true,
                    },
                ]
            },
            {
                name: "百色市",
                noR: false,
                open: true,
                children:[
                    {
                        name: "百色市 1",
                        noR: true,
                        open: true,
                    },
                    {
                        name: "百色市 2",
                        noR: true,
                        open: true,
                    },
                ]
            },
            {
                name: "很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题",
                noR: false,
                open: true,
                children:[
                    {
                        name: "百色市 1",
                        noR: true,
                        open: true,
                    },
                    {
                        name: "百色市 2",
                        noR: true,
                        open: true,
                    },
                ]
            },
            {
                name: "很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题",
                noR: false,
                open: true,
                children:[
                    {
                        name: "百色市 1",
                        noR: true,
                        open: true,
                    },
                    {
                        name: "百色市 2",
                        noR: true,
                        open: true,
                    },
                ]
            },
            {
                name: "很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题",
                noR: false,
                open: true,
                children:[
                    {
                        name: "百色市 1",
                        noR: true,
                        open: true,
                    },
                    {
                        name: "百色市 2",
                        noR: true,
                        open: true,
                    },
                ]
            },
            {
                name: "很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题很长的标题",
                noR: false,
                open: true,
                children:[
                    {
                        name: "百色市 1",
                        noR: true,
                        open: true,
                    },
                    {
                        name: "百色市 2",
                        noR: true,
                        open: true,
                    },
                ]
            },
        ]
    },
];

var zTree, rMenu;

function OnRightClick(event, treeId, treeNode) {
    if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
        zTree.cancelSelectedNode();
        showRMenu("root", event.clientX, event.clientY);
    } else if (treeNode && !treeNode.noR) {
        zTree.selectNode(treeNode);
        showRMenu("node", event.clientX, event.clientY);
    }
}

function showRMenu(type, x, y) {
    $("#rMenu ul").show();
    if (type=="root") {
        $("#m_del").hide();
        $("#m_check").hide();
        $("#m_unCheck").hide();
    } else {
        $("#m_del").show();
        $("#m_check").show();
        $("#m_unCheck").show();
    }

    y += document.body.scrollTop;
    x += document.body.scrollLeft;
    rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

    $("body").bind("mousedown", onBodyMouseDown);
}
function hideRMenu() {
    if (rMenu) rMenu.css({"visibility": "hidden"});
    $("body").unbind("mousedown", onBodyMouseDown);
}
function onBodyMouseDown(event){
    if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
        rMenu.css({"visibility" : "hidden"});
    }
}
var addCount = 1;
function addTreeNode() {
    hideRMenu();
    var newNode = { name:"增加" + (addCount++)};
    if (zTree.getSelectedNodes()[0]) {
        newNode.checked = zTree.getSelectedNodes()[0].checked;
        zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
    } else {
        zTree.addNodes(null, newNode);
    }
}
function removeTreeNode() {
    hideRMenu();
    var nodes = zTree.getSelectedNodes();
    if (nodes && nodes.length>0) {
        if (nodes[0].children && nodes[0].children.length > 0) {
            var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
            if (confirm(msg)==true){
                zTree.removeNode(nodes[0]);
            }
        } else {
            zTree.removeNode(nodes[0]);
        }
    }
}
function authTreeNode() {
    var nodes = zTree.getSelectedNodes();
    console.log(nodes);
}
function checkTreeNode(checked) {
    var nodes = zTree.getSelectedNodes();
    if (nodes && nodes.length>0) {
        zTree.checkNode(nodes[0], checked, true);
    }
    hideRMenu();
}

// 恢复zTree
function resetTree() {
    hideRMenu();
    $.fn.zTree.init($("#orgTree"), setting, orgNodes);
}

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
        $('[data-title="title-assets"]').text(treeNode.name);
        toggleTreeNodes(treeNode.nodeType);
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
    $.fn.zTree.init($("#orgTree"), setting, orgNodes);
    zTree = $.fn.zTree.getZTreeObj("orgTree");
    rMenu = $("#rMenu");
});

/**
 * 切换 数节点
 * @param data
 * @returns {boolean}
 */
function toggleTreeNodes(data){
    console.log('this.nodeType---------->', data);
    if (!data){
        return false;
    }
    $('[data-content="assets"], [data-tips="assets"]').hide();
    switch (data) {
        case 'books':
            $('[data-assets="books"]').show();
            break;
        case 'static':
            $('[data-assets="static"]').show();
            break;
        case 'photos':
            $('[data-assets="photos"]').show();
            break;
        case 'videos':
            $('[data-assets="videos"]').show();
            break;
    }
}