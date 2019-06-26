<jsp:include page="../common/meta.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>人物列表</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="${ctx}/css/index.css" type="text/css"></link>

<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('tr:odd').css('background-color', '#ccc');
	});
	function deleteItems(){
		document.itemsForm.action="${ctx}/items/deleteItems.action";
		document.itemsForm.submit();
	}
	function selectItems(){
		document.itemsForm.action="${ctx}/items/queryItems.action";
		document.itemsForm.submit();
	}
</script>
</head>
<body>
	<c:if test="${not empty user }">
		${user.name}
	</c:if>
	<%-- <form name="itemsForm" method="post">
		<table width="51%" border="1" align="center">
			<tr>
				<td id="text" height="88" colspan="5" align="center"><h1>
						<strong>商品列表</strong><br/>
													
							<input type="text" name="itemsCustom.name"/>
							<input type="button" onclick="selectItems()" value="查询" />&nbsp;&nbsp;&nbsp;<input type="button" onclick="deleteItems()" value="批量删除" />
							<select name="itemtype">
								<c:forEach items="${itemsType }" var="itemtype">
									<option value="${itemtype.key }">${itemtype.value }</option>
								</c:forEach>
							</select>
					</h1></td>
			</tr>
			<tr class="top">
				<td align="center"><strong>选&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;择</strong></td>
				<td align="center"><strong>商品名称</strong></td>
				<td align="center"><strong>商品价格</strong></td>
				<td align="center"><strong>生产日期</strong></td>
				<td align="center"><strong>商品描述</strong></td>
				<td align="center"><strong>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</strong></td>
			</tr>
			<c:forEach var="items" items="${itemsList}">
				<tr>
					<td align="center"><input type="checkbox" name="items_id" value="${items.id }" /></td>
					<td align="center">${items.name}</td>
					<td align="center">${items.price}</td>
					<td align="center"><fmt:formatDate value="${items.createtime}" pattern="yyyy-MM-dd" /></td>
					<td align="center">${items.detail}</td>
					<td align="center">
					<!-- ${pageContext.request.contextPath } 相当于 'basePath'
					
						非REST的url
					<a href="items/editItems.action?id=${items.id }">
						REST的url（使用中）
					<a href="items/itemView/${items.id }">
					-->
					<a href="${ctx}/items/itemView/${items.id }">修改</a>
						&nbsp;<a
						href="${ctx}/#">删除</a>
						</td>
				</tr>
			</c:forEach>
		</table>
	</form> --%>
</body>
</html>
