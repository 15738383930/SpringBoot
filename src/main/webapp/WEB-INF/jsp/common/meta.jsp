<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="<%=request.getContextPath() %>" scope="session" />
<link rel="shortcut icon" href="${ctx}/resources/images/logo.ico" type="image/x-icon"/>
<link rel="stylesheet" href="${ctx}/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx}/resources/css/common.css">
<script type="text/javascript" src="${ctx}/resources/js/common/jquery-2.2.1.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="${ctx}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/resources/js/common/modal_dialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/common/message.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/common/common.js"></script>

<!--全局变量，请求上下文路径 -->
<script type="text/javascript">
    const SYS_CTX = '${ctx}';
</script>