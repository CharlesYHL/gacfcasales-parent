<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:import url="/WEB-INF/views/include/header.jsp">
	<c:param name="styles">
		<link rel="stylesheet" href="${ctx}/resource/plugins/ztree/css/metroStyle/metroStyle.css">
		<link rel="stylesheet" href="${ctx}/resource/plugins/treegrid/jquery.treegrid.css">
	</c:param>
</c:import>
<div id="app" v-cloak>
	<div v-show="showList" class="box box-custom collapsed-box" style="margin-bottom:8px;">
		<div  class="box-header with-border form-inline">
			<div class="input-group input-group-sm" style="margin-right:16px;width:220px;">
				<span class="input-group-addon" style="width:30px;">资源名称</span>
				<input type="text" class="form-control" name="name" id="name" value="" placeholder="请输入资源名称"/>
			</div>
			<div class="input-group input-group-sm" style="margin-right:8px;">
				 <button id="btn_add" type="button" class="btn btn-primary btn-sm" @click="query">
			        <span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询
			    </button>
			</div>
			<div class="input-group input-group-sm">
				<button id="btn_add" type="button" class="btn btn-primary btn-sm" @click="clearInput">
			        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;清空
			    </button>
			</div>
		</div>
	</div>
	
	<div v-show="showList"  class="box box-custom collapsed-box" style="margin-bottom:0;">
		<div class="box-body">
			<div id="toolbar" class="btn-group">
			    <button id="btn_add" type="button" class="btn btn-primary" @click="add">
			        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
			    </button>
			</div>
			<table id="table" class="table"></table>
		</div>
	</div>
	
	<div v-show="!showList">
		<div class="row">
		<div class="col-xs-12">
			<div class="col-xs-3">
				<!-- 选择菜单 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							选择上级菜单
						</h3>
					</div>
					<div class="panel-body">
						<ul id="menuTree" class="ztree"></ul>
					</div>
				</div>
			</div>
			<div class="col-xs-9">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">{{title}}</h3>
					</div>
					<div class="panel-body">
						<form id="baseFrom" class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-2 control-label">类型</div>
								<label class="radio-inline">
									<input type="radio" name="level" value="1" v-model="sysResource.level"/> 目录
								</label>
								<label class="radio-inline">
									<input type="radio" name="level" value="2" v-model="sysResource.level"/> 菜单
								</label>
								<label class="radio-inline">
									<input type="radio" name="level" value="3" v-model="sysResource.level"/> 按钮
								</label>
							</div>
							<div class="form-group">
								<div class="col-sm-2 control-label">菜单名称</div>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="name" v-model="sysResource.name"  placeholder="菜单名称或按钮名称" maxlength="20"/>
								</div>
								<div class="col-sm-3 control-label"></div>
							</div>
							<div v-if="sysResource.level != 1" class="form-group">
								<div class="col-sm-2 control-label">菜单URL</div>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="url" v-model="sysResource.url" placeholder="菜单URL"/>
								</div>
								<div class="col-sm-3 control-label"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-2 control-label">上级菜单</div>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="parentName" v-model="sysResource.parentName" readonly="readonly" placeholder="菜单管理"/>
								</div>
								<div class="col-sm-3 control-label"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-2 control-label">排序号</div>
								<div class="col-sm-7">
									<input type="number" class="form-control" name="orderNum" v-model="sysResource.orderNum" placeholder="排序号"/>
								</div>
								<div class="col-sm-3 control-label"></div>
							</div>
							<div v-if="sysResource.level == 1" class="form-group">
								<div class="col-sm-2 control-label">图标</div>
								<div class="col-sm-7">
									<input type="text" class="form-control" name="icon" v-model="sysResource.icon" placeholder="菜单图标"/>
									<code style="margin-top:4px;display: block;">获取图标：http://v3.bootcss.com/components/</code>
								</div>
								<div class="col-sm-3 control-label"></div>
							</div>
							<div class="form-group">
								<div class="col-sm-2 control-label"></div>
								<input type="button" class="btn btn-primary" @click="saveOrUpdate" value="确定"/>
								&nbsp;&nbsp;<input type="button" class="btn btn-warning" @click="reload" value="返 回"/>
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
<script src="${ctx }/resource/bootstrap/js/vue1.0.26.js"></script>
<script src="${ctx }/resource/bootstrap/js/vue-validator2.1.6.js"></script>
<script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.min.js"></script>
<script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script src="${ctx}/resource/plugins/treegrid/tree.table.js"></script>
<script src="${ctx}/resource/plugins/ztree/jquery.ztree.all.min.js"></script>
<script src="${ctx }/resource/js/sysPage/sysResources.js"></script>
