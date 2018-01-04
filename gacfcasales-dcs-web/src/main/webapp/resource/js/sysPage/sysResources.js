
$(function(){
	var oTable = new TableInit();
	oTable.Init();
});

var setting = {
	 view: {  
         selectedMulti: false        //禁止多点选中  
     },  
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "pid"
        },
        key: {
            url:"nourl"
        }
    },
    callback: {  
        onClick: function(treeId, treeNode) {  
        	 var node = ztree.getSelectedNodes();
             //选择上级菜单
             vm.sysResource.pid = node[0].id;
             vm.sysResource.parentName = node[0].name;
        }  
    }
};
var ztree;

var vm = new Vue({
    el:'#app',
    data:{
        showList: true,
        title: null,
        sysResource:{
        	level : 2,
        	name : null,
            parentName : null,
            url : null,
            pid : null,
            orderNum : null,
            icon : null
        }
    },
    methods: {
    	query: function(){
    		vm.reload();
    	},
    	clearInput:function(){
    		$("#name").val('');
    		vm.reload();
    	},
        getMenu: function(){
            //加载菜单树
            $.post(ctx + "/sysResource/ajax/list", function(r){
            	for (var i = 0; i < r.dataList.length; i++) {
					delete r.dataList[i].icon;
				}
                ztree = $.fn.zTree.init($("#menuTree"), setting, r.dataList);
                var node = ztree.getNodeByParam("id", vm.sysResource.pid);
                ztree.selectNode(node);
                ztree.expandAll(true); 
                vm.sysResource.parentName = node.name;
            },'json')
            
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.sysResource = {parentName:null,pid:"b7be87c6f51d4693abd207490939d5bf",level:2,orderNum:0};
            vm.getMenu();
            
            //重置表单验证信息
            resetFrom();
            //开启表单验证
            validateFrom();
        },
        update: function (id) {
        	if(id == null){
        		return ;
        	}
            $.post(ctx + "/sysResource/ajax/getResourceById/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.sysResource = r;
                vm.getMenu();
              //重置表单验证信息
                resetFrom();
              //开启表单验证
                validateFrom();
            },'json');
        },
        del: function (id) {
        	if(id == null){
        		return ;
        	}
            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: ctx + "/sysResource/ajax/delete",
                    data: "id=" + id,
                    success: function(r){
                        if(r.code === 200){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.message);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
        	var self = this;
        	if($("#baseFrom").valid()) {
            	var url = vm.sysResource.id == null ? "/sysResource/ajax/save" : "/sysResource/ajax/update";
            	$.ajax({
            		type: "POST",
            		url: ctx + url,
            		contentType: "application/json",
            		data: JSON.stringify(vm.sysResource),
            		dataType : "json",
            		success : function(r){
            			if(r.code === 200){
            				alert('操作成功',function(){
            					vm.reload();
            				});
            			}else{
            				alert(r.message);
            			}
            		}
            	});
        	}
        },
        reload: function () {
            vm.showList = true;
            $('#table').bootstrapTable('refresh');
        }
    }
});

function getResourceId () {
    var selected = $('#table').bootstrapTable('getSelections');
    if (selected.length == 1) {
        return selected[0].id;
    } else {
    	alert("请选择一条记录");
    	return false;
    }
}


function validateFrom(){
	$('#baseFrom').validate({
		rules : {
			name : {
				required : true,
				maxlength : 20,
				remote: {
                    type: "post", 
                	//请求方式
                    url: ctx+"/sysResource/ajax/existsSysResourceName",       //发送请求的url地址
                    data: {
                        id : function() {
                          return vm.sysResource.id ? vm.sysResource.id : "";
                        },
                        name : function(){
                        	return vm.sysResource.name;
                        }
                      },
                    dataType: "json",        //发送的数据类型
                    dataFilter: function(data, type) { //返回结果
                        if (data == "200")
                            return true;
                        else
                            return false;
                    }
				}
			},
			url : {
				required : true,
			}
		},
		messages:{
			name : {
				required :"<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;菜单名称不能为空",
				maxlength : "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;菜单名称长度不超过20个字符",
				remote: "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;菜单名称已存在"
			},
			url : {
				required :"<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;URL不能为空",
				maxlength : "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;URL长度不超过32个字符"
			}
		},
		success: function(label) {
			label.parents(".form-group").addClass("has-success");
		}
	});

}
function resetFrom(){
	$('#baseFrom>.form-group').each(function(){
		$(this).removeClass("has-error");
		$(this).removeClass("has-success");
		$(this).find("span").remove();
	});
}


function update(id){
	vm.update(id);
};

function del(id){
	vm.del(id);
};

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
	    $('#table').bootstrapTable({
	    	url:ctx + '/sysResource/ajax/list',
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
	    		radio: true	
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
	            title : '名称',
	            align : 'center',
	            valign : 'middle'
	        }, {
	            field : 'url',
	            title : '菜单URL',
	            align : 'center',
	            valign : 'middle',
	            formatter: function (value, row, index) {
	            	if(null != value && "" != value){
	            		return '<div style="text-align:left;padding-left:20px;">'+value+'</div>';
	            	}else{
	            		return "";
	            	}
	            }
	        },{
	            field : 'level',
	            title : '类型',
	            align : 'center',
	            valign : 'middle',
	            formatter: function (value, row, index) {
	            	if(1 == value){
	            		return '<span class="label label-primary label-xs">目录</span>';
	            	}else if(2 == value){
	            		return '<span class="label label-success label-xs">菜单</span>';
	            	}else if(3 == value){
	            		return '<span class="label label-info label-xs">按钮</span>';
	            	}
	            }
	        }, {
	            field : 'parentName',
	            title : '上级菜单',
	            align : 'center',
	            valign : 'middle'
	        }, {
	            field : 'icon',
	            title : '图标',
	            align : 'center',
	            valign : 'middle',
	        }, {
	        	
	            field : 'isMenu',
	            title : '是否目录',
	            align : 'center',
	            valign : 'middle'
	        },  {
	            field : 'orderNum',
	            title : '排序',
	            align : 'center',
	            valign : 'middle'
	        },{
	            field: '操作',
	            title: '操作',
	            align : 'center',
	            valign : 'middle',
	            width	: '120',
	            formatter: function (value, row, index) {
	            	if(row.id==="b7be87c6f51d4693abd207490939d5bf"){
	            		return "";
	            	}
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