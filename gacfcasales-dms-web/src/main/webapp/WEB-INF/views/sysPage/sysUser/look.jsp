<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

<div class="box box-custom collapsed-box" style="margin-bottom:8px;">
	<div class="box-header with-border form-inline">
		<div class="input-group input-group-sm" style="margin-right:20px;width:220px;">
			<span class="input-group-addon" style="width:30px;">部门</span>
			<input type="text" class="form-control" style="" name="loginName" id="loginName" value="" placeholder="请输入部门名称或部门编号"/>
		</div>
	</div>
</div>

<div class="box box-custom collapsed-box" style="margin-bottom:0;">
	<div class="box-body">
		<table id="table"></table>
	</div>
</div>

 <%@ include file="/WEB-INF/views/include/footer.jsp"%>
<script src="${ctx }/resource/js/sysPage/sysUserLookList.js"></script>

