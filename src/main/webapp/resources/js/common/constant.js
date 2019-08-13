/**
 * 公共常量js
 * @Author zhou
 * @Date  2019/8/12 13:53
 */


//----------------公共域-------------------
/**
 * class
 * @type {string}
 */
const CLASS = "class";

const SEX_DEF = "未知";
const MAN = "男";
const WOMAN = "女";
/**
 * disabled 禁止
 * @type {string}
 */
const DISABLED = "disabled";
/**
 * 请求类型-post
 * @type {string}
 */
const POST = "post";
/**
 * 请求类型-get
 * @type {string}
 */
const GET = "get";


//----------------bootstrap域-------------------
const B_C_BTN = "btn ";
const B_C_BTN_DEFAULT = "btn-default";
const B_C_BTN_INFO = "btn-info";
const B_C_BTN_DANGER = "btn-danger";


//----------------消息框域-------------------
// 默认
const M_INFO_ICON = "info";
const M_INFO_TIMEOUT = 2000;
const M_INFO_TRANSITION = 200;

// 成功
const M_SUCCESS_ICON = "success";
const M_SUCCESS_TIMEOUT = M_INFO_TIMEOUT;
const M_SUCCESS_TRANSITION = M_INFO_TRANSITION;
const M_SUCCESS_CALLBACK = M_SUCCESS_TIMEOUT + M_SUCCESS_TRANSITION;

// 警告
const M_WARNING_ICON = "warning";
const M_WARNING_TIMEOUT = 3000;
const M_WARNING_TRANSITION = M_INFO_TRANSITION;

// 询问
const M_QUESTION_ICON = "question";
const M_QUESTION_TIMEOUT = 4000;
const M_QUESTION_TRANSITION = M_INFO_TRANSITION;

// 失败
const M_ERROE_ICON = "error";
const M_ERROE_TIMEOUT = 5000;
const M_ERROE_TRANSITION = 300;


//----------------回调域-------------------
/**
 * 错误消息
 * @type {string}
 */
const C_ERROR_MSG = "服务器开了个小差>_>";
