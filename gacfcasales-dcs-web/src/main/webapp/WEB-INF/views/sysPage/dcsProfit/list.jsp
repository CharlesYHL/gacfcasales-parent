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
	</c:param>
</c:import>

<div id="profitListApp" v-cloak>

	<div v-show="showList" class="box box-custom collapsed-box"
		style="margin-bottom: 8px;">
		<div class="box-header with-border form-inline">
			<div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">大区</span> <select
						name="bigOrg" id="bigOrg" class="selectpicker"
						onchange="getSmallOrg()"></select>
				</div>

				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">小区</span> <select
						name="smallOrg" id="smallOrg" class="selectpicker"></select>
				</div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">经销商</span> <input
						type="text" class="form-control" name="dealerCode" id="dealerCode"
						disabled="disabled" placeholder="请输入经销商代码" /> <span
						class="input-group-btn">
						<button class="btn default btn-sm" onclick="queryDealer()">
							<i class="glyphicon glyphicon-list-alt"></i>
						</button>
					</span>
				</div>
			</div>
			<div style="height: 3px;"></div>
			<div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">经销商名称</span> <input
						type="text" class="form-control" name="dealerName" id="dealerName"
						value="" placeholder="请输入经销商名称" />
				</div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">销售单编号</span> <input
						type="text" class="form-control" name="productSalesOrder"
						id="productSalesOrder" value="" placeholder="请输入销售单编号" />
				</div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">产品编号</span> <input
						type="text" class="form-control" name="productNo" id="productNo"
						value="" placeholder="请输入销售单编号" />
				</div>

			</div>
			<div style="height: 3px;"></div>
			<div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">产品名称</span> <input
						type="text" class="form-control" name="productName"
						id="productName" value="" placeholder="请输入产品名称" />
				</div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">VIN</span> <input
						type="text" class="form-control" name="vin" id="vin" value=""
						placeholder="请输入VIN编号" />
				</div>
				<div class="input-group input-group-sm"
					style="margin-right: 16px; width: 320px;">
					<span class="input-group-addon" style="width: 60px;">产品有效期</span> <select
						name="productDate" id="productDate" class="selectpicker"></select>
				</div>
				
			</div>
			<div>
				<div>
					<div class="input-group input-group-sm"
						style="margin-right: 16px; width: 320px;">
						<span class="input-group-addon" style="width: 60px;">车牌号</span> <input
							type="text" class="form-control" name="licenseNo" id="licenseNo"
							value="" placeholder="请输入车牌号" />
					</div>
					<div class="input-group input-group-sm"
						style="margin-right: 16px; width: 320px;">
						<span class="input-group-addon" style="width: 60px;">客户姓名</span> <input
							type="text" class="form-control" name="customerName"
							id="customerName" value="" placeholder="请输入客户姓名" />
					</div>
					<div class="input-group input-group-sm"
						style="margin-right: 16px; width: 320px;">
						<span class="input-group-addon" style="width: 60px;">创建时间</span> <input
							id="createStart" name="createStart" type="text"
							class="form-control" placeholder="请输入创建开始日期" /> <span
							class="input-group-addon"> - </span> <input id="createEnd"
							name="createEnd" type="text" class="form-control"
							placeholder="请输入创建结束日期" />
					</div>
				</div>
				<div style="height: 3px;"></div>
				<div>
					<div class="input-group input-group-sm"
						style="margin-right: 16px; width: 320px;">
						<span class="input-group-addon" style="width: 60px;">结案时间</span> <input
							id="closedStart" name="closedStart" type="text"
							class="form-control" placeholder="请输入创建结案日期" /> <span
							class="input-group-addon"> - </span> <input id="closedEnd"
							name="closedEnd" type="text" class="form-control"
							placeholder="请输入结案结束日期" />
					</div>
				</div>
				<div style="height: 3px;"></div>
				<div>
					<div class="input-group input-group-sm"
						style="margin-left: 40%;; margin-right: 8px;">
						<button id="btn_add" type="button" class="btn btn-primary btn-sm"
							onclick="query()">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
							查询
						</button>
					</div>
					<div class="input-group input-group-sm">
						<button id="btn_add" type="button" class="btn btn-primary btn-sm"
							onclick="reset()">
							<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;重置
						</button>
					</div>
				</div>
			</div>

		</div>
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
<script src="${ctx}/resource/js/sysPage/dcsProfit/dcsProfitList.js"></script>

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