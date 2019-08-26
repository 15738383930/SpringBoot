/**
 * 公共js
 * @Author zhou
 * @Date  2019/7/26 11:36
 */

// 模态框id
var modalId;
// 操作对象
var $obj;
$(function () {

    // 开启title样式
    renderingTooltip();

    //模态框打开事件
    $(modalId).on('show.bs.modal',function() {
        $obj.attr(DISABLED, true);
    });

    //模态框隐藏事件
    $(modalId).on('hide.bs.modal',function() {
        $obj.removeAttr(DISABLED);
    });

});

/**
 * 渲染标签title
 */
function renderingTooltip() {
    $("[data-toggle='tooltip']").tooltip();
}

/**
 * 成功回调
 * @param msg 成功消息
 */
function successCallback(msg){
    if(msg){
        Z.alert.success(msg);
        setTimeout(function () {
            window.location.reload();
        }, M_SUCCESS_CALLBACK)
    }else{
        window.location.reload();
    }
}

function modalEvent() {
    //模态框打开事件
    $(modalId).on('show.bs.modal',function() {
        $obj.attr(DISABLED, true);
    });

    //模态框隐藏事件
    $(modalId).on('hide.bs.modal',function() {
        $obj.removeAttr(DISABLED);
    });
}