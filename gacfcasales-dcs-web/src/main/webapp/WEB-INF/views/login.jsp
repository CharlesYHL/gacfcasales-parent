<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <title>广汽菲克</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    <link rel="stylesheet" href="${ctx }/resource/bootstrap/css/bootstrap.min.css">

    <link rel="stylesheet" href="${ctx }/resource/bootstrap/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

    <link rel="stylesheet" href="${ctx }/resource/AdminLTE-2.3.11/css/AdminLTE.min.css">
    <link rel="stylesheet" href="${ctx }/resource/AdminLTE-2.3.11/css/skins/_all-skins.min.css">
   <style type="text/css">
  		.login-page {
  			background: #6e81bc;
  			height: 100%; 
  			background: url(./resource/images/login_bg.jpg) no-repeat center center; 
  			background-size: 100% 100%;
  		}  
  	</style>
<body class="container-fluid">
 	<div class="row">
 		<div class="col-md-offset-3 col-md-6 col-xs-12" >
		    <div class="box box-custom collapsed-box" style="margin-top:160px;">
		    	<div  class="box-header with-border form-inline">
			    	<div class="page-header text-center" style="padding:4px; margin:0px 0px 10px 0px;">
					    <h2 style="padding:0; margin:0px;">道路救援延长服务销售</h2>
					</div> 
					<div class="row text-center" style="margin-top:20px;height:26px;margin-bottom:10px;">
							<div class="form-group has-feedback" >
								<span id="errors" class="label  label-warning" style="display:none;">
									<i class="glyphicon glyphicon-remove-sign"></i>&nbsp;&nbsp;&nbsp;&nbsp;
									<span id="errorMsg"></span>
								</span>
							</div>
					</div>
					<div class="row col-md-12 col-xs-12">
						<div class="text-center" style="margin-bottom:20px;">
							<div class="form-group has-feedback">
								<label class="control-label" for="name">公司代码：</label>
							    <input type="text" id="dealerCode" class=" form-control" placeholder="请输入公司代码">
						        <span class="glyphicon glyphicon-user form-control-feedback"></span>
						 	</div>
					 	</div>
				 	</div>
				 	<div class="row col-md-12 col-xs-12">
						<div class="text-center" style="margin-bottom:20px;">
							<div class="form-group has-feedback">
								<label class="control-label" for="name">登录用户：</label>
							    <input type="text" id="username" class=" form-control" placeholder="请输入登录名称">
						        <span class="glyphicon glyphicon-user form-control-feedback"></span>
						 	</div>
					 	</div>
				 	</div>
				 	<div class="row col-md-12 col-xs-12">
				 		<div class="text-center" style="margin-bottom:20px;">
						  	<div class="form-group has-feedback">
						  		<label for="name">登录密码：</label>
						        <input type="password" id="password" class="form-control" placeholder="请输入登录密码">
						        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
						  	</div>
					  	</div>
				  	</div>
				  	<div class="row">
				      	<div class="text-center">
				      		<button id="btnLogin" class="btn btn-custom btn-primary" style="width:120px;">登 录</button>
				      	</div>
				   	</div>
				</div>
			</div>
		</div>
	</div>
<div class="row login-page" style="height:580px;margin-top:-260px;">
</div>
<script type="text/javascript">var ctx = '${ctx}'</script>
<script src="${ctx }/resource/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${ctx }/resource/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx }/resource/AdminLTE-2.3.11/js/app.js"></script>
<script src="${ctx }/resource/layui/layui.all.js"></script>
<script>
$(function() {
		$('#btnLogin').click(function() {
			if($.trim($('#dealerCode').val()).length == 0){
				$("#errors").show();
				$("#errorMsg").text("公司代码不能为空！");
				return false;
			}
			if($.trim($('#username').val()).length == 0){
				$("#errors").show();
				$("#errorMsg").text("用户名不能为空！");
				return false;
			}
			if($.trim($('#password').val()).length == 0){
				$("#errors").show();
				$("#errorMsg").text("密码不能为空！");
				return false;
			}
			$.post('${ctx}/login', {
				userName: $('#username').val(),
				password: $('#password').val(),
				dealerCode: $('#dealerCode').val()
			}, function(data) {
				if(data.code==200) {
					window.location = ctx+"/index";
				}else {
					$("#errors").show();
					$("#errorMsg").text(data.message);
					$('#password').focus();
				}
			}, 'json');
		});
		$('#dealerCode').blur(function(){
			if($('#dealerCode').val().length == 0){
				$("#errors").show();
				$("#errorMsg").text("公司代码不能为空！");
			}else{
				$("#errors").hide();
			}
		});
		$('#username').blur(function(){
			if($('#username').val().length == 0){
				$("#errors").show();
				$("#errorMsg").text("用户名不能为空！");
			}else{
				$("#errors").hide();
			}
		});
		$('#password').blur(function(){
			if($('#password').val().length == 0){
				$("#errors").show();
				$("#errorMsg").text("密码不能为空！");
			}else{
				$("#errors").hide();
			}
		});
});
</script>
</body>
</html>