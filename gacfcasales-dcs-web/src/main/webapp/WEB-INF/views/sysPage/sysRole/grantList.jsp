<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:import url="/WEB-INF/views/include/header.jsp">
	<c:param name="styles">
		<link rel="stylesheet" href="${ctx}/resource/plugins/ztree/css/metroStyle/metroStyle.css">
		<link rel="stylesheet" href="${ctx}/resource/plugins/treegrid/jquery.treegrid.css">
	</c:param>
</c:import>
<div id="rrapp" v-cloak>
	<div class="box box-custom collapsed-box" style="margin-bottom:8px;">
		<div v-show="showList" class="box-header with-border form-inline">
			<div class="input-group input-group-sm" style="margin-right:20px;width:220px;">
				<span class="input-group-addon" style="width:30px;">用户名称</span>
				<input type="text" class="form-control" name="name" id="name" value="" placeholder="请输入用户名称"/>
			</div>
			<div class="input-group input-group-sm" style="margin-right:20px;width:220px;">
				 <button id="btn_add" type="button" class="btn btn-primary btn-sm" @click="query">
			        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询
			    </button>
			</div>
		</div>
	</div>
	
	<div v-show="showList"  class="box box-custom collapsed-box" style="margin-bottom:0;">
		<div class="box-body">
			<table id="table" class="table"></table>
		</div>
	</div>
	
	<div v-show="!showList">
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								{{title}}
							</h3>
						</div>
						<div class="panel-body">
							<form class="form-horizontal">
						<div class="form-group">
						   	<div class="col-sm-2 control-label">用户名称</div>
						   	<div class="col-sm-10">
						      <input type="text" class="form-control" v-model="sysUserRole.userName" placeholder="角色名称" readonly="readonly"/>
						    </div>
						</div>
						<div class="row">
							<div class="form-group col-sm-12">
								<strong class="col-sm-2 control-label">角色名称</strong>
								<div class="col-sm-10">
								  <ul id="roleUl"></ul>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-2 control-label"></div> 
							<input type="button" class="btn btn-primary" @click="saveOrUpdate" value="确定"/>
							&nbsp;&nbsp;<input type="button" class="btn btn-warning" @click="reload" value="返回"/>
						</div>
					</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

</div>

 <%@ include file="/WEB-INF/views/include/footer.jsp"%>
 <script src="${ctx }/resource/bootstrap/js/vue.min.js"></script>
 <script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.min.js"></script>
<script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script src="${ctx}/resource/plugins/treegrid/tree.table.js"></script>
<script src="${ctx}/resource/plugins/ztree/jquery.ztree.all.min.js"></script>
<script src="${ctx }/resource/js/sysPage/sysGrantList.js"></script>

