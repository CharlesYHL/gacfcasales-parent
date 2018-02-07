$(function() {
	// 是否有效
	jQuery("#isValid").append("<option value='0'>请选择</option>");
	jQuery("#isValid").append("<option value='12781001'>是</option>");
	jQuery("#isValid").append("<option value='12781002'>否</option>");

	// 产品有效期
	jQuery("#productDate").append("<option value='0'>请选择</option>");
	jQuery("#productDate").append("<option value='12'>12个月</option>");
	jQuery("#productDate").append("<option value='24'>24个月</option>");
	jQuery("#productDate").append("<option value='36'>36个月</option>");

	// 发布状态
	jQuery("#releaseStatus").append("<option value='0'>请选择</option>");
	jQuery("#releaseStatus").append("<option value='54011001'>未发布</option>");
	jQuery("#releaseStatus").append("<option value='54011002'>已发布</option>");
	jQuery("#releaseStatus").append("<option value='54011003'>已取消</option>");

	// 是否可销售
	jQuery("#isCSales").append("<option value='0'>请选择</option>");
	jQuery("#isCSales").append("<option value='12781001'>是</option>");
	jQuery("#isCSales").append("<option value='12781002'>否</option>");

	// 设置日期控件
	$('#releaseStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#releaseEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	$('#salesStart').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});
	$('#salesEnd').datetimepicker({
		lang : "ch",
		timepicker : false,
		format : 'Y-m-d'
	});

	var oTable = new TableInit();
	oTable.Init();
});
/* 弹出的层级 */

function addProduct() {
	$.ajax({
		type : "GET",
		url : ctx + "/sysProduct/ajax/getSessionSign",
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
					title : '新增产品',
					type : 2,
					area : [ '90%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/sysProduct/ajax/addProduct'
				});
			}
		},
		error : function(data) {
			console.log(data);
			console.log(data.code);
			console.log(data.message);
		}
	});

};

var vm = new Vue({
	el : '#productApp',
	data : {
		q : {
			productNo : null,
			productName : null,
			productCategory : null,
			productProperty : null,
			IS_VALID : null,
			productDate : null,
			releaseStatus : null,
			productModel : null,
			isCSales : null,
			releaseStart : null,
			releaseEnd : null,
			salesStart : null,
			salesEnd : null

		},
		showList : true,
		showOper : false,
		showOperPart : false,
		title : null,
		tiOpiExtendedDCS : {
			PRODUCT_ID : null,
			PRODUCT_NO : null,
			PRODUCT_NAME : null,
			PRODUCT_PROPERTY : null,
			PRODUCT_CATEGORY : null,
			DNP_PRICE : null,
			MSRP_PRICE : null,
			SINGLE_DISCOUNT : null,
			IS_VALID : null,
			CREATED_BY : null,
			CREATED_AT : null,
			UPDATED_BY : null,
			UPDATED_AT : null,
			IS_C_SALE : null,
			PRODUCT_DATE : null,
			PRODUCT_MODEL : null,
			SALES_DATE : null,
			RELEASE_DATE : null,
			RELEASE_STATUS : null,
			STOP_DATE : null,
			PRODUCT_FAIT : null,
			PRODUCT_JEEP : null,
			PRODUCT_CJD : null,
			PRODUCT_DESCRIBTION : null,
			NON_TAX_COST_PRICE : null,
			TAX_COST_PRICE : null,
			TERMINAL_NON_SALES_PRICE : null,
			TERMINAL_SALES_PRICE : null,
			releaseStart : null,
			releaseEnd : null,
			salesStart : null,
			salesEnd : null
		}
	},
	methods : {
		query : function() {
			var oTable = new TableInit();
			oTable.Init();
			vm.reload();
		},
		clearInput : function() {
			$("#productNo").val('');
			$("#productName").val('');
			$("#productCategory").val('');
			$("#productProperty").val('');
			$('#isValid').val('0');
			$('#productDate').val('0');
			$('#releaseStatus').val('0')
			$('#isCSales').val('0');
			// $('#isValid').selectpicker('val', '0');
			// $('#productDate').selectpicker('val', '0');
			// $('#releaseStatus').selectpicker('val', '0');
			$("#productModel").val('');
			// $('#isCSales').selectpicker('val', '0');
			$("#releaseStart").val('');
			$("#releaseEnd").val('');
			$("#salesStart").val('');
			$("#salesEnd").val('');
			vm.reload();
		},
		addProduct : function() {
			$.ajax({
				type : "GET",
				url : ctx + "/sysProduct/ajax/getSessionSign",
				contentType : "application/json",
				dataType : "json",
				cache : false,
				async : true,
				success : function(data) {
					console.log(data);
					console.log(data.code);
					console.log(data.message);
					if (data.code != 401) {
						index = layer.open({
							title : '新增产品',
							type : 2,
							area : [ '90%', '100%' ],
							fixed : true, // 不固定
							maxmin : false,
							content : ctx + '/sysProduct/ajax/addProduct'
						});
					}
				},
				error : function(data) {
					console.log(data);
					console.log(data.code);
					console.log(data.message);
				}
			});

			// parent.layer.close(index);
		},
		addPart : function() {
			showOperPart();
			vm.title = "查询配件";
			var addPartNo = $("#addPartNo").val();
			$("#partNo").val(addPartNo);
		},
		clear_part : function() {
			$("#partNo").val('');
			$("#partName").val('');
		},
		query_part : function() {
			new TableInitPart().Init();
			// vm.part_reload();
		},
		return_part : function() {
			vm.add_reload();
		},
		exportExcel : function() {
			var param = {
				PRODUCT_NO : $("#productNo").val(),
				PRODUCT_NAME : $("#productName").val(),
				PRODUCT_CATEGORY : $("#productCategory").val(),
				PRODUCT_PROPERTY : $("#productProperty").val(),
				IS_VALID : $("#isValid").val(),
				PRODUCT_DATE : $("#productDate").val(),
				RELEASE_STATUS : $("#releaseStatus").val(),
				PRODUCT_MODEL : $("#productModel").val(),
				IS_C_SALE : $("#isCSales").val(),
				releaseStart : $("#releaseStart").val(),
				releaseEnd : $("#releaseEnd").val(),
				salesStart : $("#salesStart").val(),
				salesEnd : $("#salesEnd").val()
			};

			var PRODUCT_NO = $("#productNo").val();
			var PRODUCT_NAME = $("#productName").val();
			var PRODUCT_CATEGORY = $("#productCategory").val();
			var PRODUCT_PROPERTY = $("#productProperty").val();
			var IS_VALID = $("#isValid").val();
			var PRODUCT_DATE = $("#productDate").val();
			var RELEASE_STATUS = $("#releaseStatus").val();
			var PRODUCT_MODEL = $("#productModel").val();
			var IS_C_SALE = $("#isCSales").val();
			var releaseStart = $("#releaseStart").val();
			var releaseEnd = $("#releaseEnd").val();
			var salesStart = $("#salesStart").val();
			var salesEnd = $("#salesEnd").val();

			/*
			 * $.get(,function(data){ console.log(data); });
			 */
			// window.location.href = ctx+ '/sysProduct/ajax/productExcel';
			window.location.href = ctx
					+ '/sysProduct/ajax/productExcel_bak?PRODUCT_NO='
					+ encodeURI(encodeURI(PRODUCT_NO)) + '&PRODUCT_NAME='
					+ encodeURI(encodeURI(PRODUCT_NAME)) + '&PRODUCT_CATEGORY='
					+ encodeURI(encodeURI(PRODUCT_CATEGORY))
					+ '&PRODUCT_PROPERTY='
					+ encodeURI(encodeURI(PRODUCT_PROPERTY)) + '&IS_VALID='
					+ encodeURI(encodeURI(IS_VALID)) + '&PRODUCT_DATE='
					+ encodeURI(encodeURI(PRODUCT_DATE)) + '&RELEASE_STATUS='
					+ encodeURI(encodeURI(RELEASE_STATUS)) + '&PRODUCT_MODEL='
					+ encodeURI(encodeURI(PRODUCT_MODEL)) + '&IS_C_SALE='
					+ encodeURI(encodeURI(IS_C_SALE)) + '&releaseStart='
					+ encodeURI(encodeURI(releaseStart)) + '&releaseEnd='
					+ encodeURI(encodeURI(releaseEnd)) + '&salesStart='
					+ encodeURI(encodeURI(salesStart)) + '&salesEnd='
					+ encodeURI(encodeURI(salesEnd));

		},
		reload : function() {
			vm.showList = true;
			/*
			 * vm.showOper = false; vm.showOperPart = false;
			 */
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
							url : ctx + '/sysProduct/ajax/getProductList',
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
										checkbox : true
									},
									{
										field : '操作',
										title : '操作',
										align : 'center',
										valign : 'middle',
										width : '120',
										formatter : function(value, row, index) {
											var operate = '<div style="width:120px;">'

											if (row.RELEASE_STATUS == '未发布') {
												operate += '<button class="btn btn-primary btn-xs" title="编辑" href="#" onclick="edit(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="明细" href="#" onclick="detail(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="发布" href="#" onclick="release(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-minus" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="取消发布" disabled="disabled" style="border-color:#dd4b39;background-color:#dd4b39;" href="#" onclick="cancel(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-minus" aria-hidden="true"></i></button> '
											}
											if (row.RELEASE_STATUS == '已发布') {
												operate += '<button class="btn btn-primary btn-xs" title="编辑" disabled="disabled" href="#" onclick="edit(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="明细" href="#" onclick="detail(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="发布" disabled="disabled" href="#" onclick="release(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-minus" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="取消发布" style="border-color:#dd4b39;background-color:#dd4b39" href="#" onclick="cancel(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-minus" aria-hidden="true"></i></button> '
											}

											if (row.RELEASE_STATUS == '已取消') {
												operate += '<button class="btn btn-primary btn-xs" title="编辑" style="" href="#" onclick="edit(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-pencil" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="明细" href="#" onclick="detail(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-list-alt" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="发布" style=""href="#" onclick="release(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-minus" aria-hidden="true"></i></button> '
												operate += '<button class="btn btn-primary btn-xs" title="取消发布" disabled="disabled" style="border-color:#dd4b39;background-color:#dd4b39;" href="#" onclick="cancel(\''
														+ row.PRODUCT_ID
														+ '\')"><i class="glyphicon glyphicon-minus" aria-hidden="true"></i></button> '
											}

											operate += '</div>';
											return operate;
										}
									}, {
										field : 'PRODUCT_ID',
										title : '产品ID',
										align : 'center',
										valign : 'middle',
										visible : false
									}, {
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
										field : 'PRODUCT_CATEGORY',
										title : '产品类别',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_PROPERTY',
										title : '产品属性',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'DNP_PRICE',
										title : 'DNP价格',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'MSRP_PRICE',
										title : 'MSRP价格',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'RELEASE_STATUS',
										title : '发布状态',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'RELEASE_DATE',
										title : '发布时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'STOP_DATE',
										title : '停用时间',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'IS_VALID',
										title : '是否有效',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'IS_C_SALE',
										title : '是否可销售',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_DATE',
										title : '产品有效期',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'PRODUCT_MODEL',
										title : '适用车型',
										align : 'center',
										valign : 'middle'
									}, {
										field : 'SALES_DATE_ALL',
										title : '销售时间',
										align : 'center',
										valign : 'middle'
									}, ]
						});
	};

	oTableInit.queryParams = function(params) {
		var param = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			pageindex : this.pageNumber,
			pageSize : this.pageSize,
			PRODUCT_NO : $("#productNo").val(),
			PRODUCT_NAME : $("#productName").val(),
			PRODUCT_CATEGORY : $("#productCategory").val(),
			PRODUCT_PROPERTY : $("#productProperty").val(),
			IS_VALID : $("#isValid").val(),
			PRODUCT_DATE : $("#productDate").val(),
			RELEASE_STATUS : $("#releaseStatus").val(),
			PRODUCT_MODEL : $("#productModel").val(),
			IS_C_SALE : $("#isCSales").val(),
			releaseStart : $("#releaseStart").val(),
			releaseEnd : $("#releaseEnd").val(),
			salesStart : $("#salesStart").val(),
			salesEnd : $("#salesEnd").val()
		}
		return param;
	};

	// 用于server 分页，表格数据量太大的话
	// 不想一次查询所有数据，可以使用server分页查询，数据量小的话可以直接把sidePagination: "server" 改为
	// sidePagination: "client" ，同时去掉responseHandler: responseHandler就可以了，
	oTableInit.responseHandler = function(res) {
		if (res.code == 200) {
			return {
				"rows" : res.dataList,
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

function resetFrom() {
	$('#baseFrom>.form-group ').each(function() {
		$(this).removeClass("has-error");
		$(this).removeClass("has-success");
		$(this).find(".col-sm-3 span").remove();
	});
}

function release(productId) {
	console.log("发布动作======" + productId);
	layer.confirm('是否确定发布？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function(index) {
		$.get(ctx + "/sysProduct/ajax/releaseProduct?productId=" + productId,
				function(data) {
					// $("div").html(result);
					if (data == '0') {
						toastr.success('发布成功');
						// alert("发布成功!");
						layer.close(index);
						vm.reload();
					} else {
						toastr.error('发布失败');
						layer.close(index);
						// alert("发布失败!");
					}
				});
	}, function() {

	});
}
function cancel(productId) {
	console.log("取消动作======" + productId);
	layer.confirm('是否确定取消发布？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function(index) {
		$.get(ctx + "/sysProduct/ajax/cancelProduct?productId=" + productId,
				function(data) {
					// $("div").html(result);
					if (data == '0') {
						toastr.success('取消发布成功');
						layer.close(index);
						// alert("取消发布成功!");
						vm.reload();
					} else {
						layer.close(index);
						toastr.error('取消发布失败');
						// alert("取消发布失败!");
					}
				});
	}, function() {

	});

}

function releaseBatch() {
	var selected = $('#table').bootstrapTable('getSelections');
	console.log(selected.length);
	for ( var item in selected) {
		console.log(selected[item].PRODUCT_ID);
	}
	if (selected.length > 0) {
		layer.confirm('是否确定批量批量发布？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function(index) {
			$.ajax({
				type : "POST",
				url : ctx + "/sysProduct/ajax/releaseBatch",
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify({
					"listMap" : selected
				}),
				cache : false,
				async : true,
				success : function(data) {
					console.log("返回参数:" + data);
					if (data == 0) {
						toastr.success('批量发布成功');
						layer.close(index);
						// alert("批量发布成功!");
						vm.reload();
					} else {
						toastr.error('批量发布失败');
						layer.close(index);
						// alert("批量发布失败!");
					}
				},
				error : function(data) {
					console.log(data);
				}
			});
		}, function() {

		});
	} else {
		toastr.warning("请选择一件产品");
		// alert("请选择一件产品!");
	}

}
function cancelBatch() {
	var selected = $('#table').bootstrapTable('getSelections');
	console.log(selected.length);
	for ( var item in selected) {
		console.log(selected[item].PRODUCT_ID);
	}
	if (selected.length > 0) {
		layer.confirm('是否确定批量取消发布？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function(index) {
			$.ajax({
				type : "POST",
				url : ctx + "/sysProduct/ajax/cancelBatch",
				contentType : "application/json",
				dataType : "json",
				data : JSON.stringify({
					"listMap" : selected
				}),
				cache : false,
				async : true,
				success : function(data) {
					console.log("返回参数:" + data);
					if (data == 0) {
						toastr.success("批量取消成功");
						layer.close(index);
						// alert("批量取消成功!");
						vm.reload();
					} else {
						toastr.error("批量取消失败");
						layer.close(index);
						// alert("批量取消失败!");
					}
				},
				error : function(data) {
					console.log(data);
				}
			});
		}, function() {

		});

	} else {
		toastr.warning('请选择一件产品');
		// alert("请选择一件产品!");
	}

}

function edit(productId) {
	console.log("编辑动作======" + productId);
	$.ajax({
		type : "GET",
		url : ctx + "/sysProduct/ajax/getSessionSign",
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
					title : '产品编辑',
					type : 2,
					area : [ '80%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/sysProduct/ajax/toEditProduct?productId='
							+ productId
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

function detail(productId) {
	console.log("明细动作======" + productId);
	$.ajax({
		type : "GET",
		url : ctx + "/sysProduct/ajax/getSessionSign",
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
					title : '产品明细',
					type : 2,
					area : [ '80%', '100%' ],
					fixed : true, // 固定
					maxmin : false,
					content : ctx + '/sysProduct/ajax/detailProduct?productId='
							+ productId
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
