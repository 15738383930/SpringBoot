/**
 * 首页js
 * @Author zhou
 * @Date  2019/7/29 16:58
 */

/**
 * 编辑表单id
 * @type {string}
 */
var editUserForm = "#editUserForm";
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
var womanI = 1;
// 图片span
var portrait_span = "u_portrait_span";
$(function () {

    // 性别切换
    $(btnSex).on("click", function () {
        var clazz = $(this).attr(CLASS);
        if (clazz.indexOf(B_C_BTN_DEFAULT) > -1 && $.trim($(this).text()) == MAN) {
            $(btnSex).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(this).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_INFO);
            $(uSex).val(MAN);
        } else if (clazz.indexOf(B_C_BTN_DEFAULT) > -1 && $.trim($(this).text()) == WOMAN) {
            $(btnSex).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(this).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_DANGER);
            $(uSex).val(WOMAN);
        } else {
            $(btnSex).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
            $(uSex).val(SEX_DEF);
        }
    });

    $("#toSaveUserPage").click(function () {
        toSaveUserPage($(this));
    });

    $(submitUser).on('click',saveUserInfo);

    $(".toUpdateUserPage").click(function () {
        toUpdateUserPage($(this));
    });

    // 开启模态框事件
    modalId = "#userModal";
    modalEvent();
});

/**
 * 跳转人物添加页面
 * @param obj 添加按钮
 */
function toSaveUserPage(obj) {
    // 模态框操作对象
    $obj = obj;
    reset();
    $(submitUser).unbind('click').on('click',saveUserInfo);
    $(modalId).modal("show");
}

/**
 * 新增人物信息
 */
function saveUserInfo() {
    $(submitUser).attr(DISABLED, true);
    var formData = new FormData($(editUserForm)[0]);
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
    // 模态框操作对象
    $obj = obj;
    reset();
    $(submitUser).unbind('click').on('click',updateUserInfo);
    $.ajax({
        type: GET,
        url: SYS_CTX + '/user/'+ obj.val() +'.json',
        dataType: 'json',
        success: function (data) {
            if (data.code == 1) {
                var result = data.data;
                if(result){
                    //信息变更前的name
                    var name = null;
                    //信息变更前的value
                    var value = null;
                    for(var key in result){
                        $(editUserForm + " [name='"+ key +"']").val(result[key]);
                    }
                    sexRendering(result.sex);
                    loadImage(result.portrait);
                }
            } else {
                Z.message.warning(data.msg);
            }
        },
        error: function (data) {
            Z.alert.error(C_ERROR_MSG);
        }
    });
    $(modalId).modal("show");
}

/**
 * 修改人物信息
 */
function updateUserInfo() {
    $(submitUser).attr(DISABLED, true);
    var formData = new FormData($(editUserForm)[0]);
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

/**
 * 表单重置
 */
function reset() {
    $(editUserForm).find("input").val("");
    $(editUserForm).find("select").val("");
    $(editUserForm).find("#" + portrait_span).remove();
    $(btnSex).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT);
    $(uSex).val(SEX_DEF);
}

/**
 * 性别渲染
 * @param sex
 */
function sexRendering(sex) {
    if (sex) {
        if (sex == MAN) {
            $(btnSex).eq(manI).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_INFO);
        } else if (sex == WOMAN) {
            $(btnSex).eq(womanI).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_DANGER);
        }
    }
}

/**
 * 加载图片
 * @param imageUrl
 */
function loadImage(imageUrl) {
    if(imageUrl){
        $("#portrait_div").append('<span id="'+ portrait_span +'"><br/><img src="'+ imageUrl +'" class="img-responsive img-circle" alt="您貌若天仙的肖像^_^" width="200" height="200"></span>');
    }
}