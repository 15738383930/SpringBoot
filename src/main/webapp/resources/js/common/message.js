/**
 * 弹出框js （模仿vue提示框样式）
 * @Author zhou
 * @Date  2019/8/1 16:54
 */

// 声明函数
(function () {
    Z = {
        message: {
            info: function(content){
                message("info", null, content,null, null);
            },
            success: function(content){
                message("success", null, content, null, null);
            },
            error: function(content){
                message("error", 5000, content, 300, true);
            },
            warning: function(content){
                message("warning", 3000, content, null, null);
            },
            question: function(content){
                message("question", 4000, content, null, true);
            }
        },
        alert: {
            info: function(content){
                alert("info", null, "温馨提示", content, null, true, null, true);
            },
            success: function(content){
                alert("success", null, "成功提示", content, null, true, null, true);
            },
            error: function(content){
                alert("error", 5000, "失败提示", content, 500, true, null, null);
            },
            warning: function(content){
                alert("warning", null, "警告提示", content, 400, null, null, null);
            },
            question: function(content){
                alert("question", 4000, "询问提示", content, 300, true, null, null);
            }
        },
        B_alert: {
            info: function(title, content){
                alert("info", null, title, content, null, true, null, true);
            },
            success: function(title, content){
                alert("success", null, title, content, null, true, null, true);
            },
            error: function(title, content){
                alert("error", 5000, title, content, 500, true, null, null);
            },
            warning: function(title, content){
                alert("warning", null, title, content, 400, null, null, null);
            },
            question: function(title, content){
                alert("question", 4000, title, content, 300, true, null, null);
            }
        },
        confirm: A_confirm,
        B_confirm: B_confirm,
        C_confirm: C_confirm,
        D_confirm: D_confirm
    }
})();

/**
 * 确认框
 * @param content 提示内容
 */
function D_confirm(content){
    $modal({
        type: 'confirm', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
        icon: 'question', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
        title: '询问提醒',
        content: content,
        transition: 300, //过渡动画 默认 200   单位ms
        closable: true, // 是否显示可关闭按钮  默认为 false
        mask: true, // 是否显示遮罩层   默认为 false
        top: 400, //距离顶部距离 单位px
        center: true,// 是否绝对居中 默认为false  设置true后   top无效
        pageScroll: false, // 是否禁止页面滚动
        width: 500, // 单位 px 默认显示宽度 最下默认为300
        maskClose: false, // 是否点击遮罩层可以关闭提示框 默认为false
        cancelText: '取消',// 取消按钮 默认为 取消
        confirmText: '确认',// 确认按钮 默认未 确认
        cancel: function(close){ close(); },
        confirm: function(close){ Z.alert.info("您点击了确认。"); close(); }
    })
}

/**
 * 确认框
 * @param content 提示内容<br>
 * @param confirm 回调函数 确认事件
 */
function A_confirm(content, confirm){
    if(content && confirm && $.isFunction(confirm)){
        $modal({
            type: 'confirm', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
            icon: 'question', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
            title: '询问提醒',
            content: content,
            transition: 300, //过渡动画 默认 200   单位ms
            closable: true, // 是否显示可关闭按钮  默认为 false
            mask: true, // 是否显示遮罩层   默认为 false
            top: 400, //距离顶部距离 单位px
            center: true,// 是否绝对居中 默认为false  设置true后   top无效
            pageScroll: false, // 是否禁止页面滚动
            width: 500, // 单位 px 默认显示宽度 最下默认为300
            maskClose: false, // 是否点击遮罩层可以关闭提示框 默认为false
            cancelText: '取消',// 取消按钮 默认为 取消
            confirmText: '确认',// 确认按钮 默认未 确认
            cancel: function(close){ close(); },
            confirm: function (close) { confirm(); close(); }
        })
    } else {
        Z.alert.warning("非法调用！")
    }
}

/**
 * 确认框
 * @param title 提示标题
 * @param content 提示内容
 * @param confirm 回调函数 确认事件
 */
function B_confirm(title, content, confirm){
    if(title && content && confirm && $.isFunction(confirm)){
        $modal({
            type: 'confirm', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
            icon: 'question', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
            title: title,
            content: content,
            transition: 300, //过渡动画 默认 200   单位ms
            closable: true, // 是否显示可关闭按钮  默认为 false
            mask: true, // 是否显示遮罩层   默认为 false
            top: 400, //距离顶部距离 单位px
            center: true,// 是否绝对居中 默认为false  设置true后   top无效
            pageScroll: false, // 是否禁止页面滚动
            width: 500, // 单位 px 默认显示宽度 最下默认为300
            maskClose: false, // 是否点击遮罩层可以关闭提示框 默认为false
            cancelText: '取消',// 取消按钮 默认为 取消
            confirmText: '确认',// 确认按钮 默认未 确认
            cancel: function(close){ close(); },
            confirm: function (close) { confirm(); close(); }
        })
    } else {
        Z.alert.warning("非法调用！")
    }
}

/**
 * 确认框
 * @param title 提示标题
 * @param content 提示内容
 * @param cancel 回调函数 关闭事件
 * @param confirm 回调函数 确认事件
 */
function C_confirm(title, content, cancel, confirm){
    if(title && content && cancel && confirm && $.isFunction(cancel) && $.isFunction(confirm)){
        $modal({
            type: 'confirm', //弹框类型  'alert' or  'confirm' or 'message'   message提示(开启之前如果之前含有弹框则清除)
            icon: 'question', // 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
            title: title,
            content: content,
            transition: 300, //过渡动画 默认 200   单位ms
            closable: true, // 是否显示可关闭按钮  默认为 false
            mask: true, // 是否显示遮罩层   默认为 false
            top: 400, //距离顶部距离 单位px
            center: true,// 是否绝对居中 默认为false  设置true后   top无效
            pageScroll: false, // 是否禁止页面滚动
            width: 500, // 单位 px 默认显示宽度 最下默认为300
            maskClose: false, // 是否点击遮罩层可以关闭提示框 默认为false
            cancelText: '取消',// 取消按钮 默认为 取消
            confirmText: '确认',// 确认按钮 默认未 确认
            cancel: function (close) { cancel(); close(); },
            confirm: function (close) { confirm(); close(); }
        })
    } else {
        Z.alert.warning("非法调用！")
    }
}

/**
 *
 * 消息框
 * @param icon 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
 * @param timeout 单位 ms  显示多少毫秒后关闭弹框 （ confirm 下无效 | 不传默认为 2000ms | 最短显示时间为500ms）
 * @param content 提示内容
 * @param transition 过渡动画 默认 200   单位ms
 * @param closable 是否显示可关闭按钮  默认为 false
 */
function message(icon, timeout, content, transition, closable) {
    if(!timeout){ timeout = 2000; }
    if(!transition){ transition = 200; }
    $modal({
        type: 'message', //弹框类型  'alert' or  'confirm' or 'message'  message提示(开启之前如果之前含有弹框则清除)
        icon: icon,
        timeout: timeout,
        content: content,
        center: false,// 是否绝对居中 默认为false  设置true后   top无效
        top:100, //距离顶部距离 单位px
        transition: transition,
        closable: closable,
        mask: true // 是否显示遮罩层   默认为 false
    })
}

/**
 * 提示框
 * @param icon 提示图标显示 'info' or 'success' or 'warning' or 'error'  or 'question'
 * @param timeout 单位 ms  显示多少毫秒后关闭弹框 （ confirm 下无效 | 不传默认为 2000ms | 最短显示时间为500ms）
 * @param title 提示标题
 * @param content 提示内容
 * @param transition 过渡动画 默认 200   单位ms
 * @param closable 是否显示可关闭按钮  默认为 false
 * @param width 单位 px 默认显示宽度 最下默认为300
 * @param maskClose 是否点击遮罩层可以关闭提示框 默认为false
 */
function alert(icon, timeout, title, content, transition, closable, width, maskClose){
    if(!timeout){ timeout = 2000; }
    if(!transition){ transition = 200; }
    if(!width){ width = 300; }
    $modal({
        type: 'alert', //弹框类型  'alert' or  'confirm' or 'message'  message提示(开启之前如果之前含有弹框则清除)
        icon: icon,
        timeout: timeout,
        title: title,
        content: content,
        top:300, //距离顶部距离 单位px
        center: false,// 是否绝对居中 默认为false  设置true后   top无效
        transition: transition,
        closable: closable,
        mask: true, // 是否显示遮罩层   默认为 false
        pageScroll: true, // 是否禁止页面滚动
        width: width,
        maskClose: maskClose
    })
}