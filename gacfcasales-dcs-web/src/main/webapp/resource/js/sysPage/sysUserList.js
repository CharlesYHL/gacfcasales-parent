$(function(){
	var oTable = new TableInit();
	oTable.Init();
});


var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			name: null
		},
		showList: true,
		title:null,
		sysUser:{
			id : null,
			loginName : null,
			name : null,
			password : null,
			passwords :null,
			sex : null,
			phone : null,
			deptId : null,
			status : null
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增用户";
			vm.sysUser.id= null;
			vm.sysUser.loginName = null;
			vm.sysUser.name = null;
			vm.sysUser.password = null;
			vm.sysUser.passwords = null;
			vm.sysUser.sex = "0";
			vm.sysUser.phone = null;
			vm.sysUser.deptId = null;
			vm.sysUser.status = "0";
			//重置表单，防止点返回后再次进入验证信息还存在
			resetFrom();
			//验证表单，开启验证功能
			validateFrom();
		},
		update: function (userId) {
			if(userId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "编辑用户";
            $.post(ctx + "/sysUser/ajax/getUserById/"+userId,function(r){
            	vm.sysUser = r.dataMap.sysUser;
            	vm.sysUser.passwords = null;
        		vm.sysUser.password = null;
            	resetFrom();
            	//验证表单，开启验证功能
            	validateFrom();
            },'json');
		},
		del: function (userId) {
			if(userId == null){
				return ;
			}
			confirm('确定要删除选中的记录？', function(){
				$.post(ctx + "/sysUser/ajax/delete/"+userId,function(r){
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
		clearInput :function(){
			$("#loginName").val('');
			vm.reload();
		},
		saveOrUpdate: function () {
			//验证通过后方能提交表单
			if($("#baseFrom").valid()) {
				var url = vm.sysUser.id == null ? "/sysUser/ajax/save" : "/sysUser/ajax/update";
				$.ajax({
					type: "POST",
				    url: ctx + url,
	                contentType: "application/json",
				    data: JSON.stringify(vm.sysUser),
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
			}
		},
	    reload: function () {
	    	vm.showList = true;
	    	$('#table').bootstrapTable('refresh'); 
		}
	}
});

function validateFrom(){
	$('#baseFrom').validate({
		rules : {
			loginName : {
				required : true,
				maxlength : 20,
				remote: {
                    type: "post", 
                	//请求方式
                    url: ctx+"/sysUser/ajax/existsLoginName",       //发送请求的url地址
                    data: {
                        id : function() {
                          return vm.sysUser.id ? vm.sysUser.id : "";
                        },
                        loginName : function(){
                        	return vm.sysUser.loginName;
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
			name : {
				required : true,
			},
			password : {
				required : true,
				maxlength : 32
			},
			passwords : {
				required : true,
				equalTo : "#password"
			},
			
		},
		messages:{
			loginName : {
				required :"<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;登录名不能为空",
				maxlength : "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;登录名长度不超过20个字符",
				remote: "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;登录名已存在"
			},
			name : {
				required :"<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;用户名不能为空",
				maxlength : "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;用户名长度不超过20个字符"
			},
			password : {
				required :"<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;密码不能为空",
				maxlength : "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;密码长度不超过32个字符"
			},
			passwords : {
				required :"<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;确认密码不能为空",
				equalTo : "<i class='glyphicon glyphicon-remove-circle'></i>&nbsp;&nbsp;两次密码不一致"
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

function update(userId){
	vm.update(userId);
};

function del(userId){
	vm.del(userId);
}; 
