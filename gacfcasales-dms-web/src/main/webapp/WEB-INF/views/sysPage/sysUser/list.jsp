<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<c:import url="/WEB-INF/views/include/header.jsp">
	<c:param name="styles">
	<style>
	.required{
		color:red;
	}
	</style>
	</c:param>
</c:import>
<div id="rrapp" v-cloak>
	<div class="box box-custom collapsed-box" style="margin-bottom:8px;">
		<div v-show="showList" class="box-header with-border form-inline">
			<div class="input-group input-group-sm" style="margin-right:16px;width:220px;">
				<span class="input-group-addon" style="width:30px;">登录名称</span>
				<input type="text" class="form-control" name="loginName" id="loginName" value="" placeholder="请输入登录名称"/>
			</div>
			<div class="input-group input-group-sm" style="margin-right:8px;">
				 <button id="btn_add" type="button" class="btn btn-success btn-sm" @click="query">
			        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;&nbsp;查询
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
			<%-- <div id="toolbar" class="btn-group">
				<shiro:hasPermission name="/sysUser/ajax/add">
				    <button id="btn_add" type="button" class="btn btn-primary" @click="add">
				        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
				    </button>
			    </shiro:hasPermission>
			</div> --%>
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
							<form class="form-horizontal" name="baseFrom" id="baseFrom">
						<div class="form-group">
						   	<div class="col-sm-2 control-label">登录名称</div>
						   	<div class="col-sm-7">
						      <input type="text" class="form-control" name="loginName" id="loginName" v-model="sysUser.loginName" placeholder="登录名称" maxlength="20"/>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div class="form-group">
						   	<div class="col-sm-2 control-label">姓名</div>
						   	<div class="col-sm-7">
						      <input type="text" class="form-control" name="name" id="name" v-model="sysUser.name" placeholder="姓名" maxlength="20"/>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div v-if="sysUser.id == null" class="form-group">
						   	<div class="col-sm-2 control-label">密码</div>
						   	<div class="col-sm-7">
						      <input type="password" class="form-control" name="password" id="password" v-model="sysUser.password" placeholder="密码" maxlength="32"/>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div v-if="sysUser.id == null" class="form-group">
						   	<div class="col-sm-2 control-label">确认密码</div>
						   	<div class="col-sm-7">
						      <input type="password" class="form-control" name="passwords" id="passwords" v-model="sysUser.passwords" placeholder="确认密码" maxlength="32"/>
						    </div>
						     <div class="col-sm-3 control-label"></div>
						</div>
						<div class="form-group">
						   	<div class="col-sm-2 control-label">性别</div>
						   	<div class="col-sm-7">
						      	<div class="checkbox">
							        <label>
							            <input type="radio" v-model="sysUser.sex" name="sex" value="0">男
							        </label>
							         <label>
							            <input type="radio" v-model="sysUser.sex" name="sex" value="1">女
							        </label>
							    </div>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div class="form-group">
						   	<div class="col-sm-2 control-label">部门</div>
						   	<div class="col-sm-7">
						      <input type="text" class="form-control" v-model="sysUser.deptId" placeholder="部门" maxlength="20"/>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div class="form-group">
						   	<div class="col-sm-2 control-label">电话</div>
						   	<div class="col-sm-7">
						      <input type="text" class="form-control" v-model="sysUser.phone" placeholder="电话" maxlength="20"/>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div class="form-group">
						   	<div class="col-sm-2 control-label">是否启用</div>
						   	<div class="col-sm-7">
						        <div class="checkbox">
							        <label>
							            <input type="radio" v-model="sysUser.status" name="status" value="0">启用
							        </label>
							         <label>
							            <input type="radio" v-model="sysUser.status" name="status" value="1">禁用
							        </label>
							    </div>
						    </div>
						    <div class="col-sm-3 control-label"></div>
						</div>
						<div class="form-group">
							<div class="col-sm-2 control-label"></div> 
							<div class="col-sm-7 text-center">
								<input type="button" class="btn btn-primary" @click="saveOrUpdate" value="确定"/>
								&nbsp;&nbsp;<input type="button" class="btn btn-warning" @click="reload" value="返回"/>
							</div>
						</div>
					</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

 <%@ include file="/WEB-INF/views/include/footer.jsp"%>
<script src="${ctx }/resource/js/sysPage/sysUserList.js"></script>
<script>
$(function(){
	var oTable = new TableInit();
	oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
	    $('#table').bootstrapTable({
	    	url:ctx + '/sysUser/ajax/list',
	        method:'POST',
	        toolbar: '#toolbar',                //工具按钮用哪个容器
	        dataType:'json',
	        contentType: "application/x-www-form-urlencoded",
	        cache: false,
	        striped: true,                              //是否显示行间隔色
	        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	        pagination:true,
	        queryParams : this.queryParams,
	        "queryParamsType" : "limit",
	        minimumCountColumns:2,
	        pageNumber:1,                       //初始化加载第一页，默认第一页
	        pageSize: 10,                       //每页的记录行数（*）
	        pageList: [10, 20, 50, 100],        //可供选择的每页的行数（*）
	        uniqueId: "id",                     //每一行的唯一标识，一般为主键列 
	       // clickToSelect: true,                //是否启用点击选中行
	        showRefresh: true,                  //是否显示刷新按钮
	        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
	        showColumns:true,
//	        cardView: false,                    //是否显示详细视图
//	        detailView: false,                   //是否显示父子表
//	        fixedColumns:true,
//	        fixedNumber:6,
	        responseHandler: this.responseHandler,
	        columns: [
	    	/* {
	    		checkbox: true	
	    	}, */
	        {
	            field: '',
	            title: '序号',
	            align : 'center',
	            valign : 'middle',
	            formatter: function (value, row, index) {
	            	return index+1;
	            }
	        },
	        {
	            field : 'EMPLOYEE_NO',
	            title : '登录名称',
	            align : 'center',
	            valign : 'middle',
	            sortable : true
	        }, {
	            field : 'USER_NAME',
	            title : '用户名',
	            align : 'center',
	            valign : 'middle',
	        }, {
	            field : 'DEALER_CODE',
	            title : '公司编码',
	            align : 'center',
	            valign : 'middle',
	        }, {
	            field : 'LAST_LOG_TIME',
	            title : '最后登录时间',
	            align : 'center',
	            valign : 'middle',
	            formatter: function (value, row, index) {
	            	console.log("返回时间"+getLocalTime(value));
	            	if(value != null && value != ''){
	            		return $.dateFormatter(value,"yyyy-MM-dd HH:mm:ss");
	            	}else{
	            		return "";
	            	}
	            }
	        }, {
	            field : 'CREATED_AT',
	            title : '创建时间',
	            align : 'center',
	            valign : 'middle',
	            formatter: function (value, row, index) {
	            	if(value != null && value != ''){
	            		return $.dateFormatter(value,"yyyy-MM-dd HH:mm:ss");
	            	}else{
	            		return "";
	            	}
	            	
	            }
	        }
	        /* ,{
	            field: '操作',
	            title: '操作',
	            align : 'center',
	            valign : 'middle',
	            width	: '120',
	            formatter: function (value, row, index) {
	            	return '<shiro:hasPermission name="/sysUser/ajax/edit"><div style="width:110px;"><button class="btn btn-primary btn-xs" href="#" onclick="update(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改</button></shiro:hasPermission> '
	            	+ '<shiro:hasPermission name="/sysUser/ajax/delete"><button class="btn btn-danger btn-xs" onclick="del(\'' + row.id + '\')"><i class="glyphicon glyphicon-remove" aria-hidden="true"></i>删除</button></shiro:hasPermission></div>';
	            } 
	        } */]
	    });
    };
    
    oTableInit.queryParams = function (params) {
    	var param = {
    			limit : params.limit, // 页面大小
    			offset : params.offset, // 页码
    			pageindex : this.pageNumber,
    			pageSize : this.pageSize,
    			name:$("#name").val(),
    			loginName:$("#loginName").val(),
    			sex:$("#sex").val()
    	}
    	return param;
    };
    
    //用于server 分页，表格数据量太大的话 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server"  改为 sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
    oTableInit.responseHandler = function(res) { 
    	if (res.code == 200) {
    		return {
    			"rows" : res.dataList,
    			"total" : res.totalCount
    		};
    	} else {
    		return {
    			"rows" : [],
    			"total" : 0
    		};
    	}
    };
    return oTableInit;
};

function getLocalTime(nS) {     
	   return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/,' ');     
	}

</script>
