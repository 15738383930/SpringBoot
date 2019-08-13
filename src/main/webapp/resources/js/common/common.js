/**
 * 公共js
 * @Author zhou
 * @Date  2019/7/26 11:36
 */
$(function () {

    // 开启title样式
    renderingTooltip();

    /*$('.confirm').click(function(){
        $modal({
            type: 'confirm', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
            icon: 'info', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
            title:'问你个问题', // 提示文字
            content: '人间值得?', // 提示文字
            transition: 300, //过渡动画 默认 200   单位ms
            closable: true, // 是否显示可关闭按钮  默认为 false
            mask:true, // 是否显示遮罩层   默认为 false
            pageScroll: false, // 是否禁止页面滚动
            width:500, // 单位 px 默认显示宽度 最下默认为300
            maskClose:true, // 是否点击遮罩层可以关闭提示框 默认为false
            cancelText:'取消',// 取消按钮 默认为 取消
            confirmText:'确认',// 确认按钮 默认未 确认
            cancel:function(close){  // 回调函数  //  函数返回关闭事件 调用-关闭弹窗
                $modal({
                    type: 'message', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
                    icon: 'success', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
                    content: '用户点击了取消', // 提示文字
                })
                close() // 调用返回的 关闭弹框函数 才能关闭
            },
            confirm:function(close){ // 回调函数  //  函数返回关闭事件 调用-关闭弹窗
                $modal({
                    type: 'message', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
                    icon: 'success', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
                    content: '用户点击了确认', // 提示文字
                })
                close() // 调用返回的 关闭弹框函数 才能关闭
            }
        })
    })*/

})

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
        Z.message.success(msg);
        setTimeout(function () {
            window.location.reload();
        }, M_SUCCESS_CALLBACK)
    }else{
        window.location.reload();
    }
}