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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="<%=basePath%>css/index.css" type="text/css"></link>

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('tr:odd').css('background-color', '#ccc');
	});
	function editItemsAllSubmit(){
		document.itemsForm.action="<%=basePath%>items/editItemsAllSubmit.action";
		document.itemsForm.submit();
	}
</script>
</head>
<body>
	<form name="itemsForm" method="post">
		<table width="51%" border="1" align="center">
			<tr>
				<td id="text" height="88" colspan="5" align="center">
					<h1>
						<strong>商品列表</strong><br/>
						<input type="button" onclick="editItemsAllSubmit()" value="批量修改" />
					</h1>
				</td>
			</tr>
			<tr class="top">
				<td align="center"><strong>商品名称</strong></td>
				<td align="center"><strong>商品价格</strong></td>
				<td align="center"><strong>生产日期</strong></td>
				<td align="center"><strong>商品描述</strong></td>
			</tr>
			<c:forEach var="items" items="${itemsList}" varStatus="status">
				<input type="hidden" name="itemsList[${status.index }].id" value="${items.id}" />
				<%-- <input type="hidden" name="itemsMap['id']" value="${items.id}" /> --%>
				<tr>
					<!-- list<ItemsCustom>集合批量修改 -->
					<td align="center"><input type="text" name="itemsList[${status.index }].name" value="${items.name}" /></td>
					<td align="center"><input type="text" name="itemsList[${status.index }].price" value="${items.price}" /></td>
					<td align="center"><input type="text" name="itemsList[${status.index }].createtime" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd" />" /></td>
					<td align="center"><input type="text" name="itemsList[${status.index }].detail" value="${items.detail}" /></td>
					
					<!-- list<Map<String,ItemsCustom>>集合批量修改		（未实现 ）-->
					<%-- <td align="center"><input type="text" name="itemsMap['name']" value="${items.name}" /></td>
					<td align="center"><input type="text" name="itemsMap['price']" value="${items.price}" /></td>
					<td align="center"><input type="text" name="itemsMap['createtime']" value="<fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd" />" /></td>
					<td align="center"><input type="text" name="itemsMap['detail']" value="${items.detail}" /></td> --%>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
