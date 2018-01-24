<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>厂端-延保系统</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${ctx }/resource/bootstrap/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${ctx }/resource/bootstrap/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<link rel="stylesheet"
	href="${ctx }/resource/AdminLTE-2.3.11/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="${ctx }/resource/AdminLTE-2.3.11/css/skins/_all-skins.min.css">

<link rel="stylesheet" href="${ctx }/resource/layui/css/layui.css">
<link rel="stylesheet"
	href="${ctx }/resource/plugins/bootstrap-table/bootstrap-table.min.css">
<link rel="stylesheet"
	href="${ctx }/resource/plugins/bootstrap-table/fixed-column/bootstarp-table-fixed-column.css">
<link rel="stylesheet"
	href="${ctx }/resource/plugins/bootstrap-select/css/bootstrap-select.min.css">
<link rel="stylesheet" href="${ctx }/resource/css/common.css">

${param.styles }
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<header class="main-header">
			<a href="${ctx }/" class="logo"> <span class="logo-mini"><b>厂端</b></span>
				<!-- logo for regular state and mobile devices --> <span
				class="logo-lg"><b>延保系统</b></span>
			</a>
			<nav class="navbar navbar-static-top" role="navigation">
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<div style="float: left; color: #fff; padding: 15px 10px;">欢迎
				</div>
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="${ctx }/resource/AdminLTE-2.3.11/img/user2-160x160.jpg"
								class="user-image" alt="User Image "> <span
								class="hidden-xs">${sessionScope.userName } <%-- <shiro:user><shiro:principal /></shiro:user> --%></span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="${ctx }/resource/AdminLTE-2.3.11/img/user2-160x160.jpg"
									class="img-circle" alt="User Image">
									<p>
										用户名：${sessionScope.userName }
										<%-- <shiro:user><shiro:principal/></shiro:user> --%>
									</p></li>
								<li class="user-footer">
									<!-- <div class="pull-left"><a href="#" class="btn btn-default btn-flat">个人资料</a></div> -->
									<div class="pull-right">
										<a href="${ctx }/loginout" class="btn btn-default btn-flat">退出登录</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>
		<aside class="main-sidebar">
			<section class="sidebar">
				<ul class="sidebar-menu">
				</ul>
			</section>
		</aside>
		<div class="content-wrapper">
			<section class="content-header">
				<div class="row">
					<ol class="breadcrumb" id="nav_title"
						style="position: static; float: none;">
						<li class="active"><i class="fa fa-home"
							style="font-size: 20px; position: relative; top: 2px; left: -3px;"></i>
							&nbsp; 首页</li>
						<li id="navParentTitle" class="active"></li>
						<li id="navCurrentTitle" class="active"></li>
					</ol>
				</div>
			</section>
			<section class="content"
				style="background: #eee; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;">