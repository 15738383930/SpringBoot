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
		<script type="text/javascript" src="${ctx}/resources/js/index.js"></script>
	</head>
	<body>
		<div class="container">
			<h2 class="text-center">人物列表</h2>
			<hr>
			<fieldset>
				<form class="form-horizontal" role="search" method="get" action="${ctx}/search">
					<div class="col-sm-3">
						<input autocomplete="off" type="text" class="form-control" name="name" value="${echo.name }" placeholder="昵称(支持模糊检索)">
					</div>
					<button type="submit" title="点击查询" class="btn btn-primary zh-search-button" data-toggle="tooltip"><i class="fa fa-search bigger-110" ></i> 检 索</button>
					<button id="toSaveUserPage" type="button" data-toggle="tooltip" data-placement="left" title="添加人物信息" class="btn btn-success zh-add-button"><i class="fa fa-plus"></i> 新 增</button>
				</form>
			</fieldset>
			</br></br>
			<form name="itemsForm" method="post">
				<table class="table">
					<thead style="text-align: center;">
						<tr>
							<th class="text-center">排名</th>
							<th class="text-center">昵称</th>
							<th class="text-center">性别</th>
							<th class="text-center">年龄</th>
							<th class="text-center">类型</th>
							<th class="text-center">操作</th>
						</tr>
					</thead>
					<tbody class="text-center">
						<c:forEach var="user" items="${users}" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
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
									<button type="button" title="修改人物信息" class="btn btn-xs btn-info toUpdateUserPage" data-toggle="tooltip" value="${user.id}"><i class="fa fa-pencil-square-o bigger-110" ></i> 编 辑</button>
									<button type="button" title="删除人物信息" class="btn btn-xs btn-danger deleteUserInfo" data-toggle="tooltip" value="${user.id}"><i class="fa fa-close bigger-110" ></i> 删 除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>

		<!-- 编辑人物信息 -->
		<div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							编辑人物信息
						</h4>
					</div>
					<div class="modal-body">
						<form id="editUserForm" class="form-horizontal" role="form" method="post" enctype="multipart/form-data">
							<input name="id" hidden>
							<div class="form-group">
								<label for="u_name" class="col-sm-2 control-label">昵称</label>
								<div class="col-sm-4">
									<input class="form-control" id="u_name" name="name" type="text" value="" placeholder="敢问大侠贵姓？">
								</div>
								<label for="u_age" class="col-sm-2 control-label">年龄</label>
								<div class="col-sm-3 input-group input-group-sm zh-groups-input">
									<input class="form-control" id="u_age" name="age" type="number" value="" placeholder="修行几载？">
									<span class="input-group-addon">载</span>
								</div>
							</div>
							<div class="form-group">
								<label for="u_type" class="col-sm-2 control-label">人物类型</label>
								<div class="col-sm-4">
                                    <select id="u_type" name="type" class="form-control">
                                        <option value="">请选择</option>
                                        <c:forEach items="${dictionarys }" var="dictionary">
                                            <option value="${dictionary.code }">${dictionary.name }</option>
                                        </c:forEach>
                                    </select>
								</div>
								<label for="u_man" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-4 btn-group" data-toggle="tooltip" title="不要站错队哦~">
									<button type="button" id="u_man" name="sex_e" class="btn btn-default"><i class="fa fa-mars bigger-110"></i> 男</button>
									<button type="button" id="u_woman" name="sex_e" class="btn btn-default"><i class="fa fa-venus bigger-110"></i> 女</button>
								</div>
								<input id="u_sex" type="hidden" name="sex" value="未知">
							</div>
                            <div class="form-group">
								<label for="u_luckyDay" class="col-sm-2 control-label">幸运日</label>
								<div class="col-sm-4">
									<input class="form-control Wdate zh-date-input" id="u_luckyDay" name="luckyDay" type="text" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" placeholder="最有意义的一天^_^">
								</div>
                            </div>
                            <div class="form-group">
                                <label for="u_portrait" class="col-sm-2 control-label">人物肖像</label>
                                <div id="portrait_div" class="col-sm-10">
                                    <input id="u_portrait" data-toggle="tooltip" type="file" multiple="multiple" name="portraitFile" value="" title="您貌若天仙的肖像^_^">
                                </div>
                            </div>
							<div class="form-group has-success">
								<label class="col-sm-2 control-label" for="inputSuccess">输入成功</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputSuccess">
								</div>
							</div>
							<div class="form-group has-warning">
								<label class="col-sm-2 control-label" for="inputWarning">输入警告</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputWarning">
								</div>
							</div>
							<div class="form-group has-error">
								<label class="col-sm-2 control-label" for="inputError">输入错误</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputError">
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" id="submitUser" class="btn btn-primary">
							提交
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
	</body>
</html>
