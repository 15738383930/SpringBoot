<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>修改商品信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" href="css/add.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function check() {
		var bname = $('#name').val();
		var bauthor = $('#price').val();
		var btime = $('#createtime').val();

		if (bname == "" || bauthor == "") {
			alert("商品名称和商品价格不能为空");
			return false;
		}
		/* var reg = /^[0-9]{4}-[0-1]?[0-9]{1}-[0-3]?[0-9]{1}$/;
		if (!reg.test(btime)) {
			alert("日期格式错误！");
			return false;
		} */
		return true;
	}
</script>
</head>

<body>
<c:if test="${allErrors!=null }">
	<c:forEach var="error" items="${allErrors }">
	<font color="red">${error.defaultMessage }</font>
	</c:forEach>

</c:if>
	<form action="items/editItemsSubmit.action" method="post"
		onsubmit="return check()" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${itemsCustom.id }" />
		<p>
			<strong>修改商品信息</strong>
		</p>
		<p>
			商品名称：<input type="text" name="name" id="name" value="${itemsCustom.name }" />
		</p>
		<p>
			商品价格：<input type="text" name="price" id="price"
				value="${itemsCustom.price }" />
		</p>
		<p>
			生产日期：<input type="text" name="createtime" id="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd" />" />
			yyyy-MM-dd格式
		</p>
		<p>
			商品图片：<input type="file" name="items_pic" /><br/><c:if test="${itemsCustom.pic != null && itemsCustom.pic != ''}">
						<img src="images/2016-12/${itemsCustom.pic }" width="100" height="100" />
				   </c:if>
			
		</p>
		<p>
			商品简介：<br/><textarea rows="3" cols="30" name="detail" >${itemsCustom.detail }</textarea>
		</p>
		<input type="submit" class="in" value="提交" />
	</form>
</body>
</html>
