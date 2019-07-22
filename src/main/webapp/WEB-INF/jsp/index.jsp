<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="common/meta.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<link rel="stylesheet" href="${ctx}/resources/css/search.css">
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
			<h2 class="text-center">人物列表</h2><hr>
			<form class="form-horizontal" role="search" action="${ctx}/">
				<div class="col-lg-6">
					<div class="input-group zh-float-left">
						<input autocomplete="off" type="text" class="form-control" id="name" placeholder="昵称(支持模糊检索)">
					</div>
					<button type="button" class="btn btn-primary zh-search-button">检 索</button>
				</div>
			</form>
			</br></br></br>
			<form name="itemsForm" method="post">
				<table class="table">
					<thead style="text-align: center;">
						<tr>
							<th class="text-center">选择</th>
							<th class="text-center">昵称</th>
							<th class="text-center">性别</th>
							<th class="text-center">年龄</th>
							<th class="text-center">类型</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody class="text-center">
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
								<td>
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
