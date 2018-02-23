<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<c:import url="/WEB-INF/views/include/header.jsp">
	<c:param name="styles">
		<link rel="stylesheet"
			href="${ctx}/resource/plugins/ztree/css/metroStyle/metroStyle.css">
		<link rel="stylesheet"
			href="${ctx}/resource/plugins/treegrid/jquery.treegrid.css">
		<link rel="stylesheet"
			href="${ctx}/resource/css/jquery.datetimepicker.css">
		<link rel="stylesheet" href="${ctx }/resource/layui/css/layui.css">
		<link rel="stylesheet"
			href="${ctx}/resource/plugins/toastr/toastr.min.css">
		<link rel="stylesheet" href="${ctx }/resource/css/common.css">
	</c:param>
</c:import>

<!-- <script type="text/javascript">
        toastr.options.positionClass = 'toast-top-center';
 </script> -->

<div id="productApp" v-cloak>
	<!-- <div v-show="showList" class="box box-custom collapsed-box" style="margin-bottom: 8px;">
		<div class="box-header with-border form-inline">
			
		</div>
	</div> -->
	<div v-show="showList" class="dms-search">
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品编号</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="productNo" id="productNo" value="" placeholder="请输入产品编号" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品名称</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="productName" id="productName" value=""
										placeholder="请输入产品名称" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品类别</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="productCategory" id="productCategory" value=""
										placeholder="请输入产品类别" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品属性</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="productProperty" id="productProperty" value=""
										placeholder="请输入产品属性" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否有效</label>
								<div class="col-xs-7">
									<select name="isValid" id="isValid"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品有效期</label>
								<div class="col-xs-7">
									<select name="productDate" id="productDate"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">发布状态</label>
								<div class="col-xs-7">
									<select name="releaseStatus" id="releaseStatus"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">适用车型</label>
								<div class="col-xs-7">
									<input type="text" class="bs-select form-control"
										name="productModel" id="productModel" value=""
										placeholder="请输入适用车型" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">是否可销售</label>
								<div class="col-xs-7">
									<select name="isCSales" id="isCSales"
										class="bs-select form-control"></select>
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-5">
							<div class="form-group">
								<label class="control-label col-xs-3">发布时间</label>
								<div class="col-xs-6 col-sm-8">
									<div class="input-group input-daterange">

										<input id="releaseStart" name="releaseStart" type="text"
											class="form-control" placeholder="请输入开始日期" /> <span
											class="input-group-addon"> - </span> <input id="releaseEnd"
											name="releaseEnd" type="text" class="form-control"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-5">
							<div class="form-group">
								<label class="control-label col-xs-3">销售时间</label>
								<div class="col-xs-6 col-sm-8">
									<div class="input-group input-daterange">
										<input id="salesStart" name="salesStart" type="text"
											class="form-control" placeholder="请输入开始日期" /> <span
											class="input-group-addon"> - </span> <input id="salesEnd"
											name="salesEnd" type="text" class="form-control"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>

						<div class="row ">
							<div class="col-xs-12 ">
								<div class="query-btn">
									<button id="btn_add" type="button"
										class="btn btn-primary btn-sm" @click="query">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										查询
									</button>
									<button id="btn_add" type="button"
										class="btn btn-primary btn-sm" @click="clearInput">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;重置
									</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</form>

	</div>

	<div v-show="showList" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-header">
			<!-- <button id="btn_add" type="button" class="btn btn-primary"
				style="margin-right: 2px;" onclick="addProduct();">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
			</button> -->

			<button id="btn_release" type="button" class="btn btn-primary" data-toggle="confirmation"
				style="margin-right: 2px;" onclick="releaseBatch();">
				<!-- <span class="glyphicon glyphicon-minus" aria-hidden="true"></span> -->
				批量发布
			</button>

			<button id="btn_cancel" type="button" class="btn btn-primary"
				style="margin-right: 2px;" onclick="cancelBatch();">
				<!-- <span class="glyphicon glyphicon-minus" aria-hidden="true"></span> -->
				批量取消
			</button>

			<button id="btn_export" type="button" class="btn btn-primary"
				@click="exportExcel">
				<!-- <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span> -->
				导出
			</button>
		</div>
		<div class="box-body">
			<table id="table" class="table"></table>
		</div>
	</div>




</div>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
<script src="${ctx }/resource/bootstrap/js/vue1.0.26.js"></script>
<script src="${ctx }/resource/bootstrap/js/vue-validator2.1.6.js"></script>
<script src="${ctx}/resource/plugins/treegrid/jquery.treegrid.min.js"></script>
<script
	src="${ctx}/resource/plugins/treegrid/jquery.treegrid.bootstrap3.js"></script>
<script
	src="${ctx}/resource/plugins/treegrid/jquery.treegrid.extension.js"></script>
<script src="${ctx}/resource/plugins/treegrid/tree.table.js"></script>
<script src="${ctx}/resource/plugins/ztree/jquery.ztree.all.min.js"></script>
<script src="${ctx }/resource/plugins/toastr/toastr.min.js"></script>
<script src="${ctx}/resource/js/sysPage/dcsProduct/sysProduct.js"></script>

<!-- 日期控件 -->
<script type="text/javascript"
	src="${ctx}/resource/datepicker/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${ctx}/resource/datepicker/bootstrap-datepicker.zh-CN.js"></script>
<!-- 时间控件 -->
<script type="text/javascript"
	src="${ctx}/resource/datepicker/jquery.datetimepicker.full.min.js"></script>
<script src="${ctx }/resource/layui/layui.all.js"></script>

<script>
	var globe_index;
</script>


<script type="text/javascript">
	toastr.options = {
		closeButton : false,
		debug : false,
		progressBar : true,
		positionClass : "toast-top-center",
		onclick : null,
		showDuration : "300",
		hideDuration : "1000",
		timeOut : "2000",
		extendedTimeOut : "1000",
		showEasing : "swing",
		hideEasing : "linear",
		showMethod : "fadeIn",
		hideMethod : "fadeOut"
	};
</script>
