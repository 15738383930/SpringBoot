<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="common/meta.jsp" />
<html lang="en">
	<head>
		<title>人物列表</title>
		<meta charset="UTF-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="${ctx}/resources/font-awesome-4.7.0/css/font-awesome.min.css">
		<script type="text/javascript">
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
		<div class="container">
			<h2 align="center">人物列表</h2>
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control">
				</div>
			</div>
			<!-- <div>
				<input type="text" class="form-control" name="itemsCustom.name"/>
				<input type="button" onclick="selectItems()" value="查询" />&nbsp;&nbsp;&nbsp;<input type="button" onclick="deleteItems()" value="批量删除" />
			</div> --></br>
			<form name="itemsForm" method="post">
				<table class="table">
					<thead>
						<tr>
							<th>选择</th>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th>类型</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td><input type="checkbox" name="items_id" value="${user.id }" /></td>
								<td>${user.name}</td>
								<td>${user.sex}</td>
								<td>${user.age}</td>
								<td>
									<c:forEach var="dictionary" items="${dictionarys }">
										<c:if test="${user.type eq dictionary.code }">
											${dictionary.name}
										</c:if>
									</c:forEach>
								</td>
								<td align="center">
								<!-- ${pageContext.request.contextPath } 相当于 'basePath'
								
									非REST的url
								<a href="items/editItems.action?id=${items.id }">
									REST的url（使用中）
								<a href="items/itemView/${items.id }">
								-->
								<a href="${ctx}/items/itemView/${user.id }">修改</a>
									&nbsp;<a
									href="${ctx}/#">删除</a>
									</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</body>
</html>
