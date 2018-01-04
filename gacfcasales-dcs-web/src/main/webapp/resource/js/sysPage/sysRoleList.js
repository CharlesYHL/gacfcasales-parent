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
		sysRole:{
			resourceIds:null,
			id:null,
			name:null,
            description:null,
            seq:null,
            status:null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.sysRole.id = null;
			vm.sysRole.name = null;
			vm.sysRole.description = null;
			vm.sysRole.seq = null;
			vm.sysRole.status = null;
			vm.getMenuTree(null);
		},
		update: function (roleId) {
			if(roleId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getMenuTree(roleId);
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
		getRole: function(roleId){
            $.post(ctx + "/sysRole/ajax/selectResourceByRoleId/"+roleId, function(r){
            	vm.sysRole = r;
                
                //勾选角色所拥有的菜单
    			var menuIds = vm.sysRole.resourceIds;
    			for(var i=0; i<menuIds.length; i++) {
    				var node = menu_ztree.getNodeByParam("id", menuIds[i]);
    				menu_ztree.checkNode(node, true, false);
    			}
    		},'json');
		},
		saveOrUpdate: function () {
			//获取选择的菜单
			var nodes = menu_ztree.getCheckedNodes(true);
			var resourceIds = new Array();
			for(var i=0; i<nodes.length; i++) {
				resourceIds.push(nodes[i].id);
			}
			vm.sysRole.resourceIds = resourceIds;

			var url = vm.sysRole.id == null ? "/sysRole/ajax/save" : "/sysRole/ajax/update";
			$.ajax({
				type: "POST",
			    url: ctx + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.sysRole),
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
		getMenuTree: function(roleId) {
			//加载菜单树
			 $.post(ctx + "/sysResource/ajax/list", function(r){
				 for (var i = 0; i < r.dataList.length; i++) {
						delete r.dataList[i].icon;
					}
				menu_ztree = $.fn.zTree.init($("#menuTree"), menu_setting, r.dataList);
				//展开所有节点
				menu_ztree.expandAll(true);
				if(roleId != null){
					vm.getRole(roleId);
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
	    	url:ctx + '/sysRole/ajax/list',
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
	            field : 'name',
	            title : '角色名称',
	            align : 'center',
	            valign : 'middle'
	        }, {
	            field : 'description',
	            title : '描述',
	            align : 'center',
	            valign : 'middle'
	        }, {
	            field : 'status',
	            title : '状态',
	            align : 'center',
	            valign : 'middle',
	            formatter: function (value, row, index) {
	            	 if(0 == value){
	            		return '<span class="label label-success label-xs">启用</span>';
	            	}else if(1 == value){
	            		return '<span class="label label-danger label-xs">关闭</span>';
	            	}
	            }
	        }, {
	            field: '操作',
	            title: '操作',
	            align : 'center',
	            valign : 'middle',
	            width	: '120',
	            formatter: function (value, row, index) {
	            	return '<div style="width:110px;"><button class="btn btn-primary btn-xs" href="#" onclick="update(\'' + row.id + '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i>修改</button> '
	            	+ '<button class="btn btn-danger btn-xs" onclick="del(\'' + row.id + '\')"><i class="glyphicon glyphicon-remove" aria-hidden="true"></i>删除</button></div>';
	            } 
	        }]
	    });
    };
    
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
function update(roleId){
	vm.update(roleId);
}

function del(roleId){
	vm.del(roleId);
}

