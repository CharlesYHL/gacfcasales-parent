$(function() {
	getBigOrg();
});

function getBigOrg() {
	$.ajax({
		type : "GET",
		url : ctx + "/dcsSales/ajax/getBigOrgList",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.length > 0) {
				var optionstring = "<option value='0'>请选择</option>";
				for ( var item in data) {
					console.log(data[item]);
					optionstring += "<option value='" + data[item].BIG_ORG
							+ "'>" + data[item].BIG_ORG_NAME + "</option>";
				}
				$("#bigOrg").html(optionstring);
				$("#bigOrg").selectpicker('refresh');
			}
		},
		error : function(data) {

		}
	});
}

function getSmallOrg() {
	var bigOrg = $("#bigOrg").val();
	$.ajax({
		type : "GET",
		url : ctx + "/dcsSales/ajax/getSmallOrgList?bigOrg=" + bigOrg,
		contentType : "application/json",
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.length > 0) {
				var optionstring = "<option value='0'>请选择</option>";
				for ( var item in data) {
					console.log(data[item]);
					optionstring += "<option value='" + data[item].SMALL_ORG
							+ "'>" + data[item].SMALL_ORG_NAME + "</option>";
				}
				$("#smallOrg").html(optionstring);
				$("#smallOrg").selectpicker('refresh');
				// $("#modelId").selectpicker('refresh');
			}
		},
		error : function(data) {

		}
	});
}

function queryDealer() {
	globe_index = layer.open({
		id : 'queryDealer',
		title : '查询经销商',
		type : 2,
		area : [ '80%', '100%' ],
		fixed : true, // 固定
		maxmin : false,
		content : ctx + '/dcsSales/ajax/toDealerPage'
	});
}

function getProductChild(values) {
	// var params = ;
	// console.log("返回参数:"+JSON.stringify(values));
	var params = JSON.stringify(values);
	// params = params.Substring(0,params.Length-1);
	console.log("=========" + values);
	$("#dealerCode").val(values);
}

function reset() {
	function reset() {
		$('#bigOrg').selectpicker('val', '0');
		$('#smallOrg').selectpicker('val', '0');
		$("#dealerCode").val('');
		$("#dealerName").val('');
		$("#productSalesOrder").val('');
		$("#productNo").val('');
		$("#productName").val('');
		$('#productDate').selectpicker('val', '0');
		$('#brandId').selectpicker('val', '0');
		$('#seriesId').selectpicker('val', '0');
		$('#modelId').selectpicker('val', '0');
		$("#vin").val('');
		$("#licenseNo").val();
		$("#customerName").val();
		$("#createStart").val('');
		$("#createEnd").val('');
		$("#closedStart").val('');
		$("#closedEnd").val('');

	}
}

var vm = new Vue({
	el : '#salesListApp',
	data : {
		q : {
			bigOrg : null,
			smallOrg : null,
			dealerCode : null,
			dealerName : null,
			productSalesOrder : null,
			productNo : null,
			productName : null,
			productDate : null,
			brandId : null,
			seriesId : null,
			modelId : null,
			vin : null,
			licenseNo : null,
			customerName : null,
			createStart : null,
			createEnd : null,
			closedStart : null,
			closedEnd : null

		},
		showList : true,
		title : null,
	},
	methods : {
		query : function() {
			var oTable = new TableInit();
			oTable.Init();
			vm.reload();
		},
		reload : function() {
			vm.showList = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table')
				.bootstrapTable(
						{
							url : ctx + '/dcsSales/ajax/getSalesList',
							method : 'POST',
							toolbar : '#toolbar', // 工具按钮用哪个容器
							dataType : 'json',
							contentType : "application/x-www-form-urlencoded",
							cache : false,
							striped : true, // 是否显示行间隔色
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							pagination : true,
							queryParams : this.queryParams,
							"queryParamsType" : "limit",
							minimumCountColumns : 2,
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pageSize : 10, // 每页的记录行数（*）
							pageList : [ 10, 20, 50, 100 ], // 可供选择的每页的行数（*）
							height : 450,
							uniqueId : "id", // 每一行的唯一标识，一般为主键列
							showRefresh : false, // 是否显示刷新按钮
							showToggle : false, // 是否显示详细视图和列表视图的切换按钮
							showColumns : false,
							responseHandler : this.responseHandler,
							columns : [
									{
										field : '',
										title : '序号',
										align : 'center',
										valign : 'middle',
										formatter : function(value, row, index) {
											return index + 1;
										}
									},
									{
										field : '操作',
										title : '操作',
										align : 'center',
										valign : 'middle',
										width : '120',
										formatter : function(value, row, index) {
											var operate = '<div style="width:120px;">'
											operate += '<button class="btn btn-primary btn-xs" href="#" onclick="detail(\''
													+ row.PRODUCT_SALES_ID
													+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
											return operate;
										}
									},
									{
										field : 'PRODUCT_SALES_ID',
										title : '主键ID',
										align : 'center',
										valign : 'middle',
										visible : false
									},
									{
										field : 'PRODUCT_ID',
										title : '产品ID',
										align : 'center',
										valign : 'middle',
										visible : false
									},{
										field : 'BIG_NAME',
										title : '大区',
										align : 'center',
										valign : 'middle'
									},{
										field : 'SMALL_NAME',
										title : '小区',
										align : 'center',
										valign : 'middle'
									},{
										field : 'DEALER_CODE',
										title : '经销商代码',
										align : 'center',
										valign : 'middle'
									},{
										field : 'DEALER_NAME',
										title : '经销商名称',
										align : 'center',
										valign : 'middle'
									},{
										field : 'PRODUCT_SALES_ORDER',
										title : '销售单编号',
										align : 'center',
										valign : 'middle'
									},{
										field : 'SAP_SALES_ORDER',
										title : 'SAP订单号',
										align : 'center',
										valign : 'middle'
									},
									{
										field : 'ORDER_STATUS',
										title : '单据状态',
										align : 'center',
										valign : 'middle'
									},{
										field : 'PRODUCT_NO',
										title : '产品编号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_NAME',
										title : '产品名称',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DATE',
										title : '产品有效期',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DESCRIBTION',
										title : '产品说明',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'VIN',
										title : 'VIN',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'BILLING_AT',
										title : '开票日期',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'LICENSE_NO',
										title : '车牌号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'OWNER_NO',
										title : '车主编号',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'OWNER_NAME',
										title : '车主姓名',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'OWNER_PHONE',
										title : '车主电话',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'OWNER_MOBILE',
										title : '车主手机',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CUSTOMER_NAME',
										title : '客户姓名',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CUSTOMER_CONTACT',
										title : '客户联系方式',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'BRAND_NAME',
										title : '品牌',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'SERIES_NAME',
										title : '车系',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'MODEL_NAME',
										title : '车型',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'APACKAGE',
										title : '配置',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'YEAR_MODEL',
										title : '年款',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TAKE_EFFECT_START',
										title : '生效开始时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TAKE_EFFECT_END',
										title : '生效结束时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CREATE_NAME',
										title : '创建人',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CREATED_AT',
										title : '创建时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PURCHASE_NUMBER',
										title : '购买数量',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TERMINAL_NON_SALES_PRICE',
										title : '终端不含税销售价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TERMINAL_SALES_PRICE',
										title : '终端含税销售价（6%）',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'ACTUAL_NON_SALES_PRICE',
										title : '实际不含税销售价',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'TOTAL_AMOUNT',
										title : '含税总额（6%）',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CLOSED_NAME',
										title : '结案人',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'CLOSED_AT',
										title : '结案时间',
										align : 'center',
										valign : 'middle'
									} ]
						});
	};

	oTableInit.queryParams = function(params) {
		var param = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			pageindex : this.pageNumber,
			pageSize : this.pageSize,
			BIG_ORG : $("#bigOrg").val(),
			SMALL_ORG : $("#smallOrg").val(),
			DEALER_CODE : $("#dealerCode").val(),
			DEALER_NAME : $("#dealerName").val(),
			PRODUCT_SALES_ORDER : $("#productSalesOrder").val(),
			PRODUCT_NO : $("#productNo").val(),
			PRODUCT_NAME : $("#productName").val(),
			PRODUCT_DATE : $("#productDate").val(),
			BRAND_ID : $("#brandId").val(),
			SERIES_ID : $("#seriesId").val(),
			MODEL_ID : $("#modelId").val(),
			VIN : $("#vin").val(),
			LICENSE_NO : $("#licenseNo").val(),
			CUSTOMER_NAME : $("#customerName").val(),
			CREATED_AT_START : $("#createStart").val(),
			CREATED_AT_END : $("#createEnd").val(),
			CLOSED_AT_START : $("#closedStart").val(),
			CLOSED_AT_END : $("#closedEnd").val()
		}
		return param;
	};

	// 用于server 分页，表格数据量太大的话
	// 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server" 改为
	// sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
	oTableInit.responseHandler = function(res) {
		if (res.code == 200) {
			return {
				"rows" : res.dataListMap,
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
