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
		<link rel="stylesheet" href="${ctx}/resource/css/common.css">
	</c:param>
</c:import>

<div id="profitListApp" v-cloak>
	<div v-show="showList" class="dms-search">
		<form class="form-horizontal">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">销售单编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control"
										name="productSalesOrder" id="productSalesOrder" value=""
										placeholder="请输入销售单编号" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品编号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productNo"
										id="productNo" value="" placeholder="请输入产品编号" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">产品名称</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="productName"
										id="productName" value="" placeholder="请输入产品名称" />
								</div>
							</div>
						</div>

						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">VIN</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="vin" id="vin"
										value="" placeholder="请输入VIN编号" />
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
								<label class="control-label col-xs-5 ">车牌号</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="licenseNo"
										id="licenseNo" value="" placeholder="请输入车牌号" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
							<div class="form-group">
								<label class="control-label col-xs-5 ">客户姓名</label>
								<div class="col-xs-7">
									<input type="text" class="form-control" name="customerName"
										id="customerName" value="" placeholder="请输入客户姓名" />
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-5">
							<div class="form-group">
								<label class="control-label col-xs-3">创建时间</label>
								<div class="col-xs-6 col-sm-8">
									<div class="input-group input-daterange">

										<input id="createStart" name="createStart" type="text"
											class="form-control" placeholder="请输入开始日期" /> <span
											class="input-group-addon"> - </span> <input id="createEnd"
											name="createEnd" type="text" class="form-control"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-12 col-md-8 col-lg-5">
							<div class="form-group">
								<label class="control-label col-xs-3">结案时间</label>
								<div class="col-xs-6 col-sm-8">
									<div class="input-group input-daterange">

										<input id="closedStart" name="closedStart" type="text"
											class="form-control" placeholder="请输入开始日期" /> <span
											class="input-group-addon"> - </span> <input id="closedEnd"
											name="closedEnd" type="text" class="form-control"
											placeholder="请输入结束日期" />
									</div>

								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 ">
								<div class="query-btn">
									<button id="btn_add" type="button"
										class="btn btn-primary btn-sm" onclick="query()">
										<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
										查询
									</button>
									<button id="btn_add" type="button"
										class="btn btn-primary btn-sm" onclick="resetaa()">
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
			<button id="btn_export" type="button" class="btn btn-primary"
				onclick="exportExcel()">
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
<script src="${ctx}/resource/js/sysPage/dmsProfit/dmsProfitList.js"></script>

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