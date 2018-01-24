<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="vehclApp" v-cloak>
	<input type="text" id="saleOrderId" name="saleOrderId"
		value="${requestScope.salesOrderId}" hidden="hidden" /> <input
		type="text" id="employeeName" name="employeeName"
		value="${requestScope.employeeName}" hidden="hidden" />
	<div v-show="showOperPart">
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
					<div class="box-header with-border form-inline">
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 230px;">
								<span class="input-group-addon" style="width: 40px;">VIN</span>
								<input type="text" class="form-control" name="vin" id="vin"
									value="${requestScope.vin}" placeholder="请输入VIN" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 230px;">
								<span class="input-group-addon" style="width: 40px;">车牌号</span>
								<input type="text" class="form-control" name="license"
									id="license" value="" placeholder="请输入车牌号" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 230px;">
								<span class="input-group-addon" style="width: 40px;">车主</span> <input
									type="text" class="form-control" name="ownerName"
									id="ownerName" value="" placeholder="请输入配件编号" />
							</div>

						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-left: 40%;; margin-right: 8px;">
								<button id="btn_add_product" type="button"
									class="btn btn-primary btn-sm" @click="query">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									查询
								</button>
							</div>
							<div class="input-group input-group-sm">
								<button id="btn_add_product" type="button"
									class="btn btn-primary btn-sm" @click="reset">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;&nbsp;重置
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div v-show="showOperPart" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-body">
			<table id="table" class="table"></table>
		</div>
		<div>
			<div class="input-group input-group-sm" style="margin-left: 48%;">
				<button id="btn_add_product" type="button"
					style="margin-right: 8px;" class="btn btn-primary btn-sm"
					@click="returnSales">
					<span class="glyphicon glyphicon-film" aria-hidden="true"></span>&nbsp;&nbsp;确定
				</button>
				<button id="btn_add_product" type="button"
					class="btn btn-primary btn-sm" @click="goBack">
					<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;返回
				</button>
			</div>
		</div>
		<div style="height: 10px;"></div>
	</div>

</div>

<script src="${ctx}/resource/js/sysPage/dmsSales/vehclist.js"></script>