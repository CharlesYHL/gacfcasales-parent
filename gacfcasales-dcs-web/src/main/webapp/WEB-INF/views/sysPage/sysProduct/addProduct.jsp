<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>

<div id="addProduct" v-cloak>
	<div v-show="showOper">
		<input type="text" value="${requestScope.tmPartInfo.PART_NO }"
			hidden="hidden" />
		<div class="row">
			<div class="col-xs-offset-1 col-xs-10">
				<div class="panel panel-default">
					<!-- <div class="panel-heading">
						<h3 class="panel-title">新增产</h3>
					</div> -->
					<div class="box-header with-border form-inline">
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品编号</span>
								<input type="text" class="form-control" name="productNo"
									id="productNo" value="${requestScope.tmPartInfo.PART_NO }"
									placeholder="请输入产品编号" /> <span class="input-group-btn">
									<button class="btn default btn-sm" onclick="addPart();">
										<i class="fa fa-list-alt"></i>
									</button>
								</span>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品名称</span>
								<input type="text" class="form-control" name="productName"
									disabled="disabled" id="productName"
									value="${requestScope.tmPartInfo.PART_NAME }"
									placeholder="请输入产品编号" />
							</div>

							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品类别</span>
								<input type="text" class="form-control" name="productCategory"
									disabled="disabled" id="productCategory"
									value="${requestScope.tmPartInfo.PART_GROUP_CODE }"
									placeholder="请输入产品类别" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品属性</span>
								<input type="text" class="form-control" name="productProperty"
									disabled="disabled" id="productProperty"
									value="${requestScope.tmPartInfo.PART_PROPERTY }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">产品有效期</span>
								<select name="productDate" id="productDate" class="selectpicker"></select>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">DNP价格</span>
								<input type="text" class="form-control" name="dnpPrice"
									disabled="disabled" id="dnpPrice"
									value="${requestScope.tmPartInfo.CLAIM_PRICE }"
									placeholder="请输入DNP价格" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">MSRP价格</span>
								<input type="text" class="form-control" name="msrpPrice"
									disabled="disabled" id="msrpPrice"
									value="${requestScope.tmPartInfo.LIMIT_PRICE }"
									placeholder="请输入产品属性" />
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 330px;">
								<span class="input-group-addon" style="width: 50px;">销售时间</span>
								<input id="salesStart" name="salesStart" type="text"
									class="form-control" placeholder="请输入开始日期" /> <span
									class="input-group-addon"> - </span> <input id="salesEnd"
									name="salesEnd" type="text" class="form-control"
									placeholder="请输入结束日期" />
							</div>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否FIAT授权</span>
								<select name="isFiat" id="isFiat" class="selectpicker"></select>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否国产JEEP授权</span>
								<select name="isJeep" id="isJeep" class="selectpicker"></select>
							</div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 240px;">
								<span class="input-group-addon" style="width: 50px;">是否CJD授权</span>
								<select name="isCjd" id="isCjd" class="selectpicker"></select>
							</div>

						</div>
						<div style="height: 3px;"></div>
						<div>
							<div class="input-group input-group-sm"
								style="margin-right: 16px; width: 600px;">
								<span class="input-group-addon" style="width: 150px;">产品说明</span>
								<input type="text" class="form-control" name="productDescribtion" style="height:50px;"
									id="productDescribtion"
									value=""
									placeholder="产品说明" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div v-show="showOper" class="box box-custom collapsed-box"
		style="margin-bottom: 0;">
		<div class="box-body">
			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-primary"
					style="margin-right: 10px;" @click="addProductModel();">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
					新增
				</button>

				<button id="btn_export" type="button" class="btn btn-primary"
					@click="exportExcel">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					删除
				</button>
			</div>
			<table id="table" class="table"></table>
		</div>
	</div>

</div>



<script src="${ctx}/resource/js/sysPage/addProduct.js"></script>


