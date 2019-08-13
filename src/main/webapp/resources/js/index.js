/**
 * 首页js
 * @Author zhou
 * @Date  2019/7/29 16:58
 */

/**
 * 人物表单提交按钮
 * @type {string}
 */
var submitUser = '#submitUser';
// 性别对象
var btnSex = "button[name=sex_e]";
var uSex = "#u_sex";
// 性别索引-男
var manI = 0;
// 性别索引-女
const womanI = 1;
$(function () {

    // 性别切换 （实现方式有多种，这里也许不是最简便的）
    $(btnSex).on("click", function () {
        var clazz = $(this).attr(CLASS);
        var value = $(this).val();
        if (clazz.indexOf(B_C_BTN_INFO) > -1) {
            $(this).removeClass(B_C_BTN_INFO).addClass(B_C_BTN_DEFAULT);
            $(btnSex).eq(womanI).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(uSex).val(SEX_DEF);
        } else if (clazz.indexOf(B_C_BTN_DANGER) > -1) {
            $(this).removeClass(B_C_BTN_DANGER).addClass(B_C_BTN_DEFAULT);
            $(btnSex).eq(manI).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(uSex).val(SEX_DEF);
        } else if (clazz.indexOf(B_C_BTN_DEFAULT) > -1 && $.trim($(this).text()) == MAN) {
            $(this).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_INFO);
            $(btnSex).eq(womanI).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(uSex).val(MAN);
        } else if (clazz.indexOf(B_C_BTN_DEFAULT) > -1 && $.trim($(this).text()) == WOMAN) {
            $(this).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_DANGER);
            $(btnSex).eq(manI).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(uSex).val(WOMAN);
        } else {
            $(btnSex).eq(manI).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(btnSex).eq(womanI).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(uSex).val(SEX_DEF);
        }
    });

    $("#toSaveUserPage").click(toSaveUserPage);

    $(submitUser).on('click',saveUserInfo);

    $(".toUpdateUserPage").click(function () {
        toUpdateUserPage($(this));
    });
});

/**
 * 跳转人物添加页面
 */
function toSaveUserPage() {
    $(submitUser).unbind('click').on('click',saveUserInfo);
    $("#userModal").modal("show");
}

/**
 * 新增人物信息
 */
function saveUserInfo() {
    var $userForm = $("#editUserForm");
    $(submitUser).attr(DISABLED, true);
    var formData = new FormData($userForm[0]);
    $.ajax({
        type: POST,
        url: SYS_CTX + "/user/saveResult.json",
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            $(submitUser).removeAttr(DISABLED);
            if (data.code == 1) {
                // window.location.reload();
                successCallback(data.msg);
                // Z.message.success(data.msg);
            } else {
                // class状态值  0-默认   1-没有class   2-有class但class中没有zh-tooltip
                /*var classStatus = 0;
                var $labelObj = $userForm.find('input[name='+ data.data +']');
                if($labelObj.size() <= 0){
                    $labelObj = $userForm.find('select[name='+ data.data +']');
                }

                if($labelObj.attr('class').length <= 0){
                    $labelObj.attr('class', 'zh-tooltip');
                    classStatus = 1;
                }else if($labelObj.attr('class').indexOf('zh-tooltip') < 0){
                    $labelObj.addClass(' zh-tooltip');
                    classStatus = 2;
                }

                var title = $labelObj.attr('title');
                $labelObj.attr('title', data.msg);
                renderingTooltip();
                $userForm.find('label[for=u_'+ data.data +']').click();*/

                Z.message.warning(data.msg);
            }
        },
        error: function (data) {
            $(submitUser).removeAttr(DISABLED);
            Z.alert.error(C_ERROR_MSG);
        }
    })
}

/**
 * 跳转人物修改页面
 * @param obj 编辑按钮
 */
function toUpdateUserPage(obj) {
    $(submitUser).unbind('click').on('click',updateUserInfo);
    $("#userModal").modal("show");
}

/**
 * 修改人物信息
 */
function updateUserInfo() {
    var $userForm = $("#editUserForm");
    $(submitUser).attr(DISABLED, true);
    var formData = new FormData($userForm[0]);
    $.ajax({
        type: POST,
        url: SYS_CTX + "/user/editResult.json",
        data: formData,
        async: false,
        cache: false,
        contentType: false,
        processData: false,
        success: function (data) {
            $(submitUser).removeAttr(DISABLED);
            if (data.code == 1) {
                successCallback(data.msg);
            } else {
                Z.message.warning(data.msg);
            }
        },
        error: function (data) {
            $(submitUser).removeAttr(DISABLED);
            Z.alert.error(C_ERROR_MSG);
        }
    })
}