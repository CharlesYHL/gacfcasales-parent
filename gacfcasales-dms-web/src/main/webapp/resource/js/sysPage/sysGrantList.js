$(function(){
	var oTable = new TableInit();
	oTable.Init();
});


//菜单树
var menu_ztree;
var menu_setting = {
	data: {
		simpleData: {
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId: 0
		},
		key: {
			url:"nourl"
		}
	},
	check:{
		enable:true,
		nocheckInherit:true
	}
};

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			name: null
		},
		showList: true,
		title:null,
		sysUserRole:{
			id:null,
			userId:null,
			userName:null,
			roleId:null,
			reoleName:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		update: function (userId,roleId) {
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getUser(userId);
            vm.getRoleUl(roleId);
		},
		del: function (roleId) {
			if(roleId == null){
				return ;
			}
			confirm('确定要删除选中的记录？', function(){
				$.post(ctx + "/sysRole/ajax/delete/"+roleId,function(r){
						if(r.code == 200){
							alert('操作成功', function(){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					},'json');
			});
		},
		getUser: function(userId){
            $.post(ctx + "/sysRole/ajax/selectSysUserRoleByObj/"+userId, function(r){
            	vm.sysUserRole = r;
    		},'json');
		},
		saveOrUpdate: function () {
			var roleId = $("#roleUl li").find("input:checked").val();
			if(roleId == null){
				return ;
			}
			var url = vm.sysUserRole.id == null ? "/sysRole/ajax/grantSave" : "/sysRole/ajax/grantUpdate";
			vm.sysUserRole.roleId = roleId;
			$.ajax({
				type: "POST",
			    url: ctx + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysUserRole),
			    dataType: "json",
				cache: false,
			    success: function(r){
			    	if(r.code === 200){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		getRoleUl: function() {
			//清空权限列表
			$("#roleUl").empty();
			//重新加载权限列表
			 $.post(ctx + "/sysRole/ajax/list", function(r){
				for (var i = 0; i < r.dataList.length; i++) {
					$("#roleUl").append("<li><input type='radio' name='roleList' "+(vm.sysUserRole.roleId == r.dataList[i].id ? 'checked=checked':'')+" value="+r.dataList[i].id+">"+r.dataList[i].name+"</li>");
				}
			},'json');
	    },
	    reload: function () {
	    	vm.showList = true;
	    	$('#table').bootstrapTable('refresh'); 
		}
	}
});


var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
	    $('#table').bootstrapTable({
	    	url:ctx + '/sysRole/ajax/grantList',
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
	        showRefresh: true,                  //是否显示刷新按钮
	        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
	        showColumns:true,
	        responseHandler: this.responseHandler,
	        columns: [
	    	{
	    		checkbox: true	
	    	},
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
	            field : 'userName',
	            title : '用户名称',
	            align : 'center',
	            valign : 'middle'
	        }, {
	            field : 'roleName',
	            title : '角色名称',
	            align : 'center',
	            valign : 'middle'
	        }, {
	            field : 'userId',
	            title : '用户ID',
	            align : 'center',
	            valign : 'middle',
	            visible : false
	        }, {
	            field : 'userCode',
	            title : '用户代码',
	            align : 'center',
	            valign : 'middle',
	            visible : false
	        },{
	            field: '操作',
	            title: '操作',
	            align : 'center',
	            valign : 'middle',
	            width	: '120',
	            formatter: function (value, row, index) {
	            	return '<div style="width:110px;"><button class="btn btn-primary btn-xs" href="#" onclick="update(\'' + row.userId + '\',\'' + row.roleId + '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>授权</button> '
	            	+ '</div>';
	            } 
	        }]
	    });
    };
    //<button class="btn btn-danger btn-xs" onclick="del(\'' + row.userId + '\',\'' + row.roleId + '\')"><i class="glyphicon glyphicon-remove" aria-hidden="true"></i>删除</button>
    oTableInit.queryParams = function (params) {
    	var param = {
    			limit : params.limit, // 页面大小
    			offset : params.offset, // 页码
    			pageindex : this.pageNumber,
    			pageSize : this.pageSize,
    			name:$("#name").val()
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
function update(userId,roleId){
	vm.update(userId,roleId);
}

function del(userId,roleId){
	vm.del(userId,roleId);
}

