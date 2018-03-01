$(function() {
	getBrand();

	// 产品有效期
	jQuery("#productDate").append("<option value='0'>请选择</option>");
	jQuery("#productDate").append("<option value='12'>12个月</option>");
	jQuery("#productDate").append("<option value='24'>24个月</option>");
	/*jQuery("#productDate").append("<option value='36'>36个月</option>");*/
	// 单据状态
	jQuery("#orderStatus").append("<option value='0'>请选择</option>");
	jQuery("#orderStatus").append("<option value='55011001'>已保存</option>");
	jQuery("#orderStatus").append("<option value='55011002'>已结案</option>");
	jQuery("#orderStatus").append("<option value='55011003'>扣款失败</option>");
	jQuery("#orderStatus").append("<option value='55011004'>已作废</option>");

	// 设置日期控件
	$('#createStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#createEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	$('#closedStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#closedEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	$("#createAt").val(getNowDate());

	var oTable = new TableInit();
	oTable.Init();

});

function getBrand() {
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getBrandList",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			if (data.length > 0) {
				/*var optionstring = "<option value='0'>请选择</option>";*/
				var optionstring;
				for ( var item in data) {
					console.log(data[item]);
					optionstring += "<option value='" + data[item].BRAND_ID
							+ "'>" + data[item].BRAND_NAME + "</option>";
				}
				$("#brandId").html(optionstring);
				$("#brandId").selectpicker('refresh');
			}
		},
		error : function(data) {

		}
	});
}

function getSeries() {
	var groupId = $("#brandId").val();
	$("#modelId").empty();
	$("#modelId").selectpicker('refresh');
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSeriesList?groupId=" + groupId,
		contentType : "application/json",
		data : JSON.stringify(vm.sysUser),
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			if (data.length > 0) {
				/*var optionstring = "<option value='0'>请选择</option>";*/
				var optionstring;
				for ( var item in data) {
					console.log(data[item]);
					optionstring += "<option value='" + data[item].SERIES_ID
							+ "'>" + data[item].SERIES_NAME + "</option>";
				}
				$("#seriesId").html(optionstring);
				$("#seriesId").selectpicker('refresh');
				// $("#modelId").selectpicker('refresh');
			}
		},
		error : function(data) {

		}
	});
}

function getModel() {
	var groupId = $("#seriesId").val();
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getModelList?groupId=" + groupId,
		contentType : "application/json",
		data : JSON.stringify(vm.sysUser),
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			if (data.length > 0) {
				/*var optionstring = "<option value='0'>请选择</option>";*/
				var optionstring;
				for ( var item in data) {
					console.log(data[item]);
					optionstring += "<option value='" + data[item].MODEL_ID
							+ "'>" + data[item].MODEL_NAME + "</option>";
				}
				$("#modelId").html(optionstring);
				$("#modelId").selectpicker('refresh');
			}
		},
		error : function(data) {

		}
	});
}

function addSales() {
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);

			if (data.code != 401) {
				globe_index = layer.open({
					id : 'addSales',
					title : '新增销售订单',
					type : 2,
					area : [ '80%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/dmsSales/ajax/toAddSales'
				});
			}

		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});
	/*
	 * globe_index = layer.open({ id : 'addSales', title : '新增销售订单', type : 2,
	 * area : [ '80%', '100%' ], fixed : true, // 固定 maxmin : false, content :
	 * ctx + '/dmsSales/ajax/toAddSales' });
	 */
}

// 获得当前日期
function getNowDate() {
	var d = new Date();
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	var day = d.getDate();
	if (month < 10) {
		month = '0' + (d.getMonth() + 1);
	}
	if (day < 10) {
		day = '0' + d.getDate();
	}
	var str = year + '-' + month + '-' + day;
	console.log("nowDate====" + str);
	return str;
}

function resetASC() {
	$("#salesNo").val('');
	$("#productNo").val('');
	$("#productName").val('');
	$('#productDate').val('0');
	// getBrand();
	$("#brandId").val('0');
	$("#brandId").selectpicker('refresh');

	$("#seriesId").empty();
	$("#seriesId").selectpicker('refresh');

	$("#modelId").empty();
	$("#modelId").selectpicker('refresh');

	$("#vin").val('');
	$("#licenseNo").val('');
	$("#customerName").val('');
	$('#orderStatus').val('0');
	$("#createStart").val('');
	$("#createEnd").val('');
	$("#closedStart").val('');
	$("#closedEnd").val('');
	vm.reload();
}

var vm = new Vue({
	el : '#dmsSalesApp',
	data : {
		q : {
			salesNo : null,
			productNo : null,
			productName : null,
			productDate : null,
			brandId : null,
			seriesId : null,
			modelId : null,
			vin : null,
			licenseNo : null,
			customerName : null,
			orderStatus : null,
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
							url : ctx + '/dmsSales/ajax/getSalesList',
							method : 'POST',
							toolbar : '#toolbar', // 工具按钮用哪个容器
							dataType : 'json',
							contentType : "application/x-www-form-urlencoded",
							cache : false,
							striped : true, // 是否显示行间隔色
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
							pagination : true,
							sortable: true,                     //是否启用排序
			                sortOrder: "desc",                   //排序方式
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
										checkbox : true
									},
									{
										field : '操作',
										title : '操作',
										align : 'center',
										valign : 'middle',
										width : '150',
										formatter : function(value, row, index) {
											var operate = '<div style="width:150px;">'
											if (row.ORDER_STATUS == '已结案') {
												operate += '<button class="btn btn-primary btn-xs" disabled="disabled" title="编辑" href="#" onclick="edit(\''
														+ row.PRODUCT_SALES_ID
														+ '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="明细" href="#" onclick="detail(\''
														+ row.PRODUCT_SALES_ID
														+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="作废" disabled="disabled"  href="#" onclick="invalid(\''
														+ row.PRODUCT_SALES_ID+','+row.PRODUCT_SALES_ORDER
														+ '\')"><i class="glyphicon glyphicon-remove" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="提交" disabled="disabled"  href="#" onclick="submitSAP(\''
														+ row.PRODUCT_SALES_ORDER
														+ '\')"><i class="glyphicon glyphicon-upload" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="打印"  href="#" onclick="printOrder(\''
														+ row.PRODUCT_SALES_ORDER
														+ '\')"><i class="glyphicon glyphicon-print" aria-hidden="true"></i></button> '
											}
											
											if(row.ORDER_STATUS == "已作废"){
												operate += '<button class="btn btn-primary btn-xs" disabled="disabled" title="编辑" href="#" onclick="edit(\''
													+ row.PRODUCT_SALES_ID
													+ '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></button> '
											operate += '<button class="btn btn-primary btn-xs" title="明细" href="#" onclick="detail(\''
													+ row.PRODUCT_SALES_ID
													+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
											operate += '<button class="btn btn-primary btn-xs" title="作废" disabled="disabled"  href="#" onclick="invalid(\''
													+ row.PRODUCT_SALES_ID+','+row.PRODUCT_SALES_ORDER
													+ '\')"><i class="glyphicon glyphicon-remove" aria-hidden="true"></i></button> '
											operate += '<button class="btn btn-primary btn-xs" title="提交" disabled="disabled"  href="#" onclick="submitSAP(\''
													+ row.PRODUCT_SALES_ORDER
													+ '\')"><i class="glyphicon glyphicon-upload" aria-hidden="true"></i></button> '
											operate += '<button class="btn btn-primary btn-xs" title="打印" disabled="disabled" href="#" onclick="printOrder(\''
													+ row.PRODUCT_SALES_ORDER
													+ '\')"><i class="glyphicon glyphicon-print" aria-hidden="true"></i></button> '
											}
											
											if (row.ORDER_STATUS == '已保存'
													|| row.ORDER_STATUS == "扣款失败") {
												operate += '<button class="btn btn-primary btn-xs" href="#" title="编辑" onclick="edit(\''
														+ row.PRODUCT_SALES_ID
														+ '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="明细" href="#" onclick="detail(\''
														+ row.PRODUCT_SALES_ID
														+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="作废" href="#" onclick="invalid(\''
														+ row.PRODUCT_SALES_ID+','+row.PRODUCT_SALES_ORDER
														+ '\')"><i class="glyphicon glyphicon-remove" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="提交"  href="#" onclick="submitSAP(\''
														+ row.PRODUCT_SALES_ORDER
														+ '\')"><i class="glyphicon glyphicon-upload" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="打印" disabled="disabled"  href="#" onclick="printOrder(\''
														+ row.PRODUCT_SALES_ORDER
														+ '\')"><i class="glyphicon glyphicon-print" aria-hidden="true"></i></button> '
											}
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
									},
									{
										field : 'ORDER_STATUS',
										title : '单据状态',
										align : 'center',
										valign : 'middle',
										sortable: true,
										formatter : function(value, row, index) {
											var a = "";
											if (value == "扣款失败"
													|| value == "已作废") {
												a = '<span style="color:#F00">'
														+ value + '</span>';
											} else {
												a = value;
											}
											return a;
										}
									}, {
										field : 'PRODUCT_SALES_ORDER',
										title : '销售单编号',
										align : 'center',
										sortable: true,
										valign : 'middle'
									}, {
										field : 'SAP_SALES_ORDER',
										title : 'SAP订单号',
										align : 'center',
										sortable: true,
										valign : 'middle'
									}, {
										field : 'PRODUCT_NO',
										title : '产品编号',
										align : 'center',
										sortable: true,
										valign : 'middle'
									}, {
										field : 'PRODUCT_NAME',
										title : '产品名称',
										align : 'center',
										sortable: true,
										valign : 'middle'
									}, {
										field : 'PRODUCT_DESCRIBTION',
										title : '特别约定',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DATE',
										title : '产品有效期',
										sortable: true,
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
									}, {
										field : 'INVALID_NAME',
										title : '作废人',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'INVALID_AT',
										title : '作废时间',
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
			PRODUCT_SALES_ORDER : $("#salesNo").val(),
			PRODUCT_NO : $("#productNo").val(),
			PRODUCT_NAME : $("#productName").val(),
			PRODUCT_DATE : $("#productDate").val(),
			BRAND_ID : JSON.stringify($("#brandId").val()),
			SERIES_ID : JSON.stringify($("#seriesId").val()),
			MODEL_ID : JSON.stringify($("#modelId").val()),
			VIN : $("#vin").val(),
			LICENSE_NO : $("#licenseNo").val(),
			CUSTOMER_NAME : $("#customerName").val(),
			ORDER_STATUS : $("#orderStatus").val(),
			CREATED_AT_START : $("#createStart").val(),
			CREATED_AT_END : $("#createEnd").val(),
			CLOSED_AT_START : $("#closedStart").val(),
			CLOSED_AT_END : $("#closedEnd").val(),
			sort: params.sort,      //排序列名  
            sortOrder: params.order //排位命令（desc，asc） 
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

function query() {
	vm.reload();
}

function exportExcel() {
	/*
	 * var param = { PRODUCT_SALES_ORDER : $("#salesNo").val(), PRODUCT_NO :
	 * $("#productNo").val(), PRODUCT_NAME : $("#productName").val(),
	 * PRODUCT_DATE : $("#productDate").val(), BRAND_ID : $("#brandId").val(),
	 * SERIES_ID : $("#seriesId").val(), MODEL_ID : $("#modelId").val(), VIN :
	 * $("#vin").val(), LICENSE_NO : $("#licenseNo").val(), CUSTOMER_NAME :
	 * $("#customerName").val(), ORDER_STATUS : $("#orderStatus").val(),
	 * CREATED_AT_START : $("#createStart").val(), CREATED_AT_END :
	 * $("#createEnd").val(), CLOSED_AT_START : $("#closedStart").val(),
	 * CLOSED_AT_END : $("#closedEnd").val() };
	 */

	var PRODUCT_SALES_ORDER = $("#salesNo").val();
	var PRODUCT_NO = $("#productNo").val();
	var PRODUCT_NAME = $("#productName").val();
	var PRODUCT_DATE = $("#productDate").val();
	var BRAND_ID = $("#brandId").val();
	var SERIES_ID = $("#seriesId").val();
	var MODEL_ID = $("#modelId").val();
	var VIN = $("#vin").val();
	var LICENSE_NO = $("#licenseNo").val();
	var CUSTOMER_NAME = $("#customerName").val();
	var ORDER_STATUS = $("#orderStatus").val();
	var CREATED_AT_START = $("#createStart").val();
	var CREATED_AT_END = $("#createEnd").val();
	var CLOSED_AT_START = $("#closedStart").val();
	var CLOSED_AT_END = $("#closedEnd").val();

	window.location.href = ctx
			+ '/dmsSales/ajax/exportSalesExcel?PRODUCT_SALES_ORDER='
			+ encodeURI(encodeURI(PRODUCT_SALES_ORDER)) + '&PRODUCT_NO='
			+ encodeURI(encodeURI(PRODUCT_NO)) + '&PRODUCT_NAME='
			+ encodeURI(encodeURI(PRODUCT_NAME)) + '&PRODUCT_DATE='
			+ encodeURI(encodeURI(PRODUCT_DATE)) + '&BRAND_ID='
			+ encodeURI(encodeURI(BRAND_ID)) + '&SERIES_ID='
			+ encodeURI(encodeURI(SERIES_ID)) + '&MODEL_ID='
			+ encodeURI(encodeURI(MODEL_ID)) + '&VIN='
			+ encodeURI(encodeURI(VIN)) + '&LICENSE_NO='
			+ encodeURI(encodeURI(LICENSE_NO)) + '&CUSTOMER_NAME='
			+ encodeURI(encodeURI(CUSTOMER_NAME)) + '&ORDER_STATUS='
			+ encodeURI(encodeURI(ORDER_STATUS)) + '&CREATED_AT_START='
			+ encodeURI(encodeURI(CREATED_AT_START)) + '&CREATED_AT_END='
			+ encodeURI(encodeURI(CREATED_AT_END)) + '&CLOSED_AT_START='
			+ encodeURI(encodeURI(CLOSED_AT_START)) + '&CLOSED_AT_END='
			+ encodeURI(encodeURI(CLOSED_AT_END))
}

function detail(productSalesId) {
	console.log("进入明细页面" + productSalesId);
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);

			if (data.code != 401) {
				globe_index = layer.open({
					title : '销售单明细',
					type : 2,
					area : [ '80%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx
							+ '/dmsSales/ajax/toSalesDetail?productSalesId='
							+ productSalesId
				});
			}

		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});

}

function edit(productSalesId) {
	console.log("进入编辑页面" + productSalesId);

	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);

			if (data.code != 401) {
				globe_index = layer.open({
					title : '销售单编辑',
					type : 2,
					area : [ '80%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx
							+ '/dmsSales/ajax/toSalesEdit?productSalesId='
							+ productSalesId
				});
			}

		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});

}

function invalid(productSalesId) {
	console.log("进入作废功能" + productSalesId);
	 var str_before = productSalesId.split(',')[0];  
	 var str_after = productSalesId.split(',')[1];
	 console.log('前：'+str_before+' - 后：'+str_after);  
	 
	layer.confirm('请确认是否作废销售单号:'+str_after+'？', {
		btn : [ '确定', '取消' ],closeBtn: 0
	// 按钮
	}, function(index) {
		$.ajax({
			type : "GET",
			url : ctx + "/dmsSales/ajax/invalidSales?productSalesId="
					+ str_before,
			contentType : "application/json",
			dataType : "json",
			cache : false,
			async : true,
			success : function(data) {
				console.log("返回参数:" + data);
				if (data == 0) {
					toastr.success("作废成功");
					// alert("作废成功!");
					layer.close(index);
					vm.reload();
				} else {
					toastr.error("作废失败");
					layer.close(index);
					// alert("作废失败!");
				}
			},
			error : function(data) {
				console.log(data);
			}
		});

		/*
		 * layer.msg('的确很重要', { icon : 1 });
		 */
	}, function() {
		/*
		 * layer.msg('也可以这样', { time : 20000, // 20s后自动关闭 btn : [ '明白了', '知道了' ]
		 * });
		 */
	});

}

function submitSAP(productSalesOrder) {
	layer.confirm('销售单据一旦提交，不可作废，请确认是否提交:'+productSalesOrder+'？', {
		btn : [ '确定', '取消' ],closeBtn: 0
	// 按钮
	}, function(index) {
		$.ajax({
			type : "GET",
			url : ctx + "/dmsSales/ajax/submitSales?productSalesOrder="
					+ productSalesOrder,
			contentType : "application/json",
			dataType : "json",
			cache : false,
			async : true,
			success : function(data) {
				console.log("返回参数:" + data);
				if (data.code == 0) {
					toastr.success("扣款成功");
					// alert("扣款成功!");
					$("#btn_print").attr("disabled", false);
					$("#btn_submit").attr("disabled", true)
					$("#btn_save").attr("disabled", true);
					layer.close(index);
					vm.reload();
				} else {
					toastr.error("扣款失败,原因:"+data.message+"!");
					layer.close(index);
				}
			},
			error : function(data) {
				console.log(data);
			}
		});
	}, function() {

	});
}

function printOrder(productSalesOrder) {
	
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getSessionSign",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async : true,
		success : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
			if(data.code != 401){
				//var productSalesOrder = $("#salesOrder").val();
				console.log("进入打印页面" + productSalesOrder);
				globe_index = layer.open({
					title : '销售单打印',
					type : 2,
					area : [ '70%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/dmsSales/ajax/toSalesPrint?productSalesOrder='
							+ productSalesOrder
				});
			}
		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});
	
	/*layer.confirm('是否确认打印？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function(index) {
		
	}, function() {

	});*/
}



function getStr(string,str){  
    var str_before = string.split(str)[0];  
    var str_after = string.split(str)[1];  
    console.log('前：'+str_before+' - 后：'+str_after);  
}  

