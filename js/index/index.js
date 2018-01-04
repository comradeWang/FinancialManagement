$(function () {
    $('#index').show();
});
var LOCAL = "http://localhost:8081/";
function switchPage(page,th) {
    $('.cc').hide();
    $('li.sidebar-nav-link a').removeClass('active');
    $(th).addClass("active");
    switch (page){
        case 1:
            $('#index').show();
            break;
        case 2:
            $('#roleManage').show();
            break;
        case 3:
            $('#companyManage').show();
            break;
        case 4:
            $('#dataManage').show();
            break;
        case 5:
            $('#customerManage').show();
            break;
        default:
            break;
    }
}
/*************************数据字典项目开始****************************************/
/**
 * 显示数据字典项目的数据
 */
function showProject() {
    $.ajax({
        url:LOCAL+"fm/project/getAllfmProject",
        type:"post",
        success:function (result) {
            var htmlStr = "";
            var $table = $('#projectTable');
            $.each(result.data,function (index,obj) {
                htmlStr+='<tr class="gradeX">' +
                    '<td>'+obj.id+'</td>' +
                    '<td>'+obj.type+'</td>' +
                    '<td>'+obj.projectId+'</td>' +
                    '<td>'+obj.showValue+'</td>' +
                    '<td>'+obj.createId+'</td>' +
                    '<td><div class="tpl-table-black-operation">\n' +
                    '<a href="javascript:void(0);" onclick="getTemplate(4,'+obj.id+')">\n' +
                    ' <i class="am-icon-pencil"></i> 编辑\n' +
                    '</a>\n' +
                    '<a href="javascript:deleteProject('+obj.id+');" class="tpl-table-black-operation-del">\n' +
                    ' <i class="am-icon-trash"></i> 删除\n' +
                    '/a>\n' +
                    '</div></td>' +
                    '</tr>'
            })
        }
    })
}

/**
 * 删除project
 * @param id
 */
function deleteProject(id) {
    $.ajax({
        url:LOCAL+"fm/project/getAllfmProject",
        type:"post",
        data:{id:id},
        success:function (result) {
            alert("删除成功");
        }
    })
}

/**
 * 更新project
 * @param id
 */
function updateProject(id) {
    $.ajax({
        url:LOCAL+"fm/project/getAllfmProject",
        type:"post",
        data:{id:id},
        success:function (result) {
            alert("更新成功");
        }
    })
}
/*************************数据字典项目结束****************************************/
/*************************公共方法开始*******************************************/

/**
 * 生成模态框内的模板
 * @param type
 * @param id
 */
function getTemplate(type,id) {
    var innerStr = '';
    switch (type){
        case 1:
            innerStr = "";
            break;
        case 2:
            innerStr = '';
            break;
        case 3:
            innerStr = '';
            break;
        case 4:
            innerStr = '<form class="am-form">' +
                '' +
                '</form>';
            break;
        case 5:
            innerStr = '';
            break;
        default:
            break;
    }
    return innerStr;
}






//弹出模态框的公共方法
function showModal(title,template) {
    $('.am-popup-bd').html(template);
    $('.am-popup-title').html(title);
    $('#my-popup').modal();
}
/*************************公共方法结束*******************************************/
