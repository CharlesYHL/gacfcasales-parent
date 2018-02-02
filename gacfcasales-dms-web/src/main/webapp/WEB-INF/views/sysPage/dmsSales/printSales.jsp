<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/base.jsp"%>
<%-- <script type="text/javascript" src="${ctx }/resource/plugins/jQuery/jquery-2.2.3.js"></script>  --%>
<script type="text/javascript"
	src="${ctx }/resource/bootstrap/js/printThis.js"></script>
<link href="${ctx}/resource/css/printSales.css" rel="stylesheet"type="text/css" media="print"/>  
 <style type="text/css">
.bckcontent {
	/* font-size: 36px;
	color: #ff0000; */
	background: #e8e8e8;
}
</style> 

<div id="printSalesApp" v-cloak>
	<div v-show="showList">
		<div class="row">
			<div class="col-xs-offset-1 col-xs-11">
				<div id="printSales" class="panel panel-default">
					<div style="text-align: center; margin-top: 2%;">
						<span style="font-size: 25px;">道路救援延长服务确认单</span>
					</div>
					<div style="text-align: center; margin-left: 40%;">
						<span id="printTime"></span>
					</div>
					<div style="height: 30px;"></div>
					<div class="box-header with-border form-inline">
						<div id="khxx" class="bckcontent" >
							 <span style="font-size: 18px; font-weight: 500;">&nbsp;&nbsp;&nbsp;客户信息</span>
							<!-- <table><tr><td style="width:100%;background-color: #e8e8e8" >客户信息222</td></tr></table> -->
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px;">客户姓名</span> <span>:</span>
								<input type="text" class="form-control" name="customerName"
									id="customerName" disabled="disabled"
									style="width: 15%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.CUSTOMER_NAME}" /> <span
									style="width: 5%; font-size: 16px;">客户联系方式</span> <span>:</span>
								<input type="text" class="form-control" name="customerContact"
									id="customerContact" disabled="disabled"
									style="width: 18%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.CUSTOMER_CONTACT}" />


								<span style="width: 5%; font-size: 16px;">客户与车辆关系</span> <span>:</span>
								<input type="text" class="form-control" name="customerVehicle"
									id="customerVehicle" disabled="disabled"
									style="width: 15%; background-color: white; border: 0px; font-size: 16px;"
									value="车主" />

							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px;">车主姓名</span> <span>:</span>
								<input type="text" class="form-control" name="ownerName"
									id="ownerName" disabled="disabled"
									style="width: 15%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.OWNER_NAME}" /> <span
									style="width: 5%; font-size: 16px;">车主电话</span> <span>:</span>
								<input type="text" class="form-control" name="ownerPhone"
									id="ownerPhone" disabled="disabled"
									style="width: 21.5%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.OWNER_PHONE}" /> <span
									style="width: 5%; font-size: 16px;">VIN</span> <span>:</span> <input
									type="text" class="form-control" name="vin" id="vin"
									disabled="disabled"
									style="width: 30%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.VIN}" />

							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px;">品牌</span> <span>:</span>
								<input type="text" class="form-control" name="brandName"
									id="brandName" disabled="disabled"
									style="width: 20%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.BRAND_NAME}" /> <span
									style="width: 5%; font-size: 16px;">车系</span> <span>:</span> <input
									type="text" class="form-control" name="seriesName"
									id="seriesName" disabled="disabled"
									style="width: 24%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.SERIES_NAME}" /> <span
									style="width: 5%; font-size: 16px;">车型</span> <span>:</span> <input
									type="text" class="form-control" name="modelName"
									id="modelName" disabled="disabled"
									style="width: 30%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.MODEL_NAME}" />

							</div>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px;">年款</span> <span>:</span>
								<input type="text" class="form-control" name="yearModel"
									id="yearModel" disabled="disabled"
									style="width: 20%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.YEAR_MODEL}" /> <span
									style="width: 5%; font-size: 16px;">车牌号</span> <span>:</span> <input
									type="text" class="form-control" name="licenseNo"
									id="licenseNo" disabled="disabled"
									style="width: 15%; background-color: white; border: 0px; font-size: 16px;"
									value="${requestScope.ttOpiExtendedSales.LICENSE_NO}" />

							</div>
						</div>
						<div style="height: 30px;"></div>
						<div style="background: #e8e8e8;">
							<span style="font-size: 18px; font-weight: 500;">&nbsp;&nbsp;&nbsp;产品信息</span>
						</div>
						<div style="height: 3px;"></div>

						<div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务产品编号</span>
								<span>:</span> <input type="text" class="form-control"
									name="productNo" id="productNo" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.PRODUCT_NO}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务产品名称</span>
								<span>:</span> <input type="text" class="form-control"
									name="productName" id="productName" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.PRODUCT_NAME}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务产品购买数量</span>
								<span>:</span> <input type="text" class="form-control"
									name="purchaseNumber" id="purchaseNumber" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.PURCHASE_NUMBER}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务产品含税总价</span>
								<span>:</span> <input type="text" class="form-control"
									name="totalAmount" id="totalAmount" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.TOTAL_AMOUNT}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务保障期限</span>
								<span>:</span> <input type="text" class="form-control"
									name="productNate" id="productNate" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.PRODUCT_DATE}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">购买日期</span>
								<span>:</span> <input type="text" class="form-control"
									name="createdAt" id="createdAt" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.CREATED_AT}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务生效日期</span>
								<span>:</span> <input type="text" class="form-control"
									name="takeEffectStart" id="takeEffectStart" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.TAKE_EFFECT_START}" />
							</div>
							<div style="margin-left: 5%">
								<span style="width: 5%; font-size: 16px; font-weight: 550;">服务结束日期</span>
								<span>:</span> <input type="text" class="form-control"
									name="takeEffectEnd" id="takeEffectEnd" disabled="disabled"
									style="width: 25%; background-color: white; border: 0px; font-size: 16px; font-weight: 550;"
									value="${requestScope.ttOpiExtendedSales.TAKE_EFFECT_END}" />
							</div>
						</div>

						<div style="height: 30px;"></div>
						<div style="background: #e8e8e8;">
							<span style="font-size: 18px; font-weight: 500;">&nbsp;&nbsp;&nbsp;特别约定</span>
						</div>
						<div style="height: 3px;"></div>
						<div>
							<div style="margin-left: 5%">
								<span style="font-size: 15px;">声明:服务提供方已将具体的服务保障内容向本人做了明确说明，本人已充分理解；以上填写的内容均属实，同意以此作为订立服务约定的依据。</span>
							</div>
							<!-- <div style="margin-left: 5%">
								<span style="font-size: 15px;"></span>
							</div> -->

							<div style="margin-left: 5%">
								<div>
									<span style="font-size: 15px;">产品说明:</span>
								</div>
							</div>
							<div style="margin-left: 5%">
								<div>
									<span style="font-size: 15px;">1、道路救援延长服务产品12个月</span>
								</div>
							</div>
							<div style="margin-left: 5%">
								<div>
									<span style="font-size: 15px;">2、道路救援延长服务产品24个月</span>
								</div>
							</div>
							<div style="margin-left: 5%">
								<div>
									<span style="font-size: 15px;">3、道路救援延长服务产品36个月</span>
								</div>
							</div>

						</div>


						<div style="height: 100px;"></div>
						<div>
							<div style="margin-left: 15%; float: left">
								<div>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;客户&nbsp;&nbsp;签名/盖章:</span>
								</div>
								<div style="height: 30px;"></div>
								<span>..... 年 ..... 月 ..... 日</span>
							</div>
							<div style="margin-left: 65%">
								<div>
									<span>&nbsp;&nbsp;&nbsp;&nbsp;经销商&nbsp;&nbsp;签名/盖章:</span>
								</div>
								<div style="height: 30px;"></div>
								<span>..... 年 .....月 ..... 日</span>
							</div>
						</div>



					</div>
				</div>
				<div class="panel panel-default">
					<div></div>
					<div style="height: 10px;"></div>
					<div>

						<div class="input-group input-group-sm"
							style="margin-left: 43%; margin-right: 8px; float: left">
							<button id="btn_print" type="button"
								class="btn btn-primary btn-sm">
								<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
								打印
							</button>
						</div>
						<div class="input-group input-group-sm">
							<button id="btn_reset" type="button"
								class="btn btn-primary btn-sm" onclick="reset()">
								<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>&nbsp;&nbsp;返回
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<script src="${ctx}/resource/js/sysPage/dmsSales/printSales.js"></script>


<script type="text/javascript">
	$("#btn_print").click(function(event) {
		console.log("======================");
		/* Act on the event */
		var tt = $("#printSales").printThis({
			debug : false,
			importCSS : false,
			importStyle : false,
			printContainer : true,
			// loadCSS:  "${ctx}/resource/css/common.css",  
			pageTitle : "道路救援延长服务确认单",
			removeInline : false,
			printDelay : 333,
			header : null,
			formValues : false
		});
		/* if (opt.importStyle){
			$("style").each(function() {
				khxx
			}
		} */
		console.log(tt);
	});
</script>