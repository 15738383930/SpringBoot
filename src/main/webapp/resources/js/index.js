/**
 * 首页js
 * @Author zhou
 * @Date  2019/7/29 16:58
 */
const BTN_SEX = "button[name=sex]";

const CLASS = "class";

const MAN_I = 0;
const WOMAN_I = 1;

const SEX_DEF = null;
const MAN = "男";
const WOMAN = "女";

const B_C_BTN = "btn ";
const B_C_BTN_DEFAULT = "btn-default";
const B_C_BTN_INFO = "btn-info";
const B_C_BTN_DANGER = "btn-danger";
$(function () {

    // 性别切换 （实现方式有多种，这里也许不是最简便的）
    $(BTN_SEX).on("click", function () {
        var clazz = $(this).attr(CLASS);
        var value = $(this).val();
        if (clazz.indexOf(B_C_BTN_INFO) > -1) {
            $(this).removeClass(B_C_BTN_INFO).addClass(B_C_BTN_DEFAULT).val(SEX_DEF);
            $(BTN_SEX).eq(WOMAN_I).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT).val(SEX_DEF);
        } else if (clazz.indexOf(B_C_BTN_DANGER) > -1) {
            $(this).removeClass(B_C_BTN_DANGER).addClass(B_C_BTN_DEFAULT).val(SEX_DEF);
            $(BTN_SEX).eq(MAN_I).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT).val(SEX_DEF);
        } else if (clazz.indexOf(B_C_BTN_DEFAULT) > -1 && $.trim($(this).text()) == MAN) {
            $(this).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_INFO).val(MAN);
            $(BTN_SEX).eq(WOMAN_I).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT).val(SEX_DEF);
        } else if (clazz.indexOf(B_C_BTN_DEFAULT) > -1 && $.trim($(this).text()) == WOMAN) {
            $(this).removeClass(B_C_BTN_DEFAULT).addClass(B_C_BTN_DANGER).val(WOMAN);
            $(BTN_SEX).eq(MAN_I).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT).val(SEX_DEF);
        } else {
            $(BTN_SEX).eq(MAN_I).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT).val(SEX_DEF);
            $(BTN_SEX).eq(WOMAN_I).attr(CLASS, B_C_BTN + B_C_BTN_DEFAULT).val(SEX_DEF);
        }
    });

    //模态框打开时重置表单
    $('#userModal').on('show.bs.modal',function() {
    });


    //模态框打开时重置表单
    $('#qu').on('click',function() {
        Z.B_confirm("您不配", "您确定吗？", function () {
            Z.message.question("那到底是配还是不配呢")
        })
    });

    $('#submitUser').on('click',function() {
        $(this).attr("disabled", true);
        var formData = new FormData($("#editUserForm")[0]);
        var url = SYS_CTX;
        url += "/user/saveResult.json";
        $.ajax({
            type : "POST",
            url : url,
            data : formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data) {
                $('#submitUser').removeAttr("disabled");
                if (data.code == 1) {
                    // $("#queryAgencyPensionInfo").submit();
                } else {
                    Z.message.error(data.msg);
                }
            },
            error: function(data){
                $('#submitUser').removeAttr("disabled");
                Z.alert.warning("服务器开了个小差>_>");
            }
        });
    });
});