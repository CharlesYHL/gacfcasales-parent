$(function() {
	var oTable = new TableInit();
	oTable.Init();
});

/*
 * function returnSales() {
 * 
 * var selected = $('#table').bootstrapTable('getSelections');
 * console.log(selected.length); }
 */

var vm = new Vue({
	el : '#vehclApp',
	data : {
		q : {
			vin : null,
			license : null,
			ownerName : null

		},
		showOperPart : true,
		title : null,
	},
	methods : {
		query : function() {

			var oTable = new TableInit();
			oTable.Init();

			vm.reload();
		},
		goBack : function() {
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index)
		},
		returnSales : function() {
			var selected = $('#table').bootstrapTable('getSelections');
			console.log(selected.length);

			var params = {
				VIN : selected[0].VIN,
				LICENSE : selected[0].LICENSE,
				BRAND : selected[0].BRAND,
				BRAND_ID : selected[0].BRAND_ID,
				BRAND_NAME : selected[0].BRAND_NAME,
				SERIES : selected[0].SERIES,
				SERIES_ID : selected[0].SERIES_ID,
				SERIES_NAME : selected[0].SERIES_NAME,
				MODEL : selected[0].MODEL,
				MODEL_ID : selected[0].MODEL_ID,
				MODEL_NAME : selected[0].MODEL_NAME,
				APACKAGE : selected[0].APACKAGE,
				APACKAGE_ID : selected[0].APACKAGE_ID,
				APACKAGE_NAME : selected[0].APACKAGE_NAME,
				YEAR_MODEL : selected[0].YEAR_MODEL,
				INVOICE_DATE : selected[0].INVOICE_DATE,
				OWNER_NO : selected[0].OWNER_NO,
				OWNER_NAME : selected[0].OWNER_NAME,
				PHONE : selected[0].PHONE,
				MOBILE : selected[0].MOBILE
			};
			console.log(params);

			/*
			 * window.location.href = ctx +
			 * '/dmsSales/ajax/fromVehclistToAddSales?VIN=' + selected[0].VIN +
			 * '&BRAND_ID=' + selected[0].BRAND_ID + '&BRAND_NAME=' +
			 * selected[0].BRAND_NAME + '&SERIES_ID=' + selected[0].SERIES_ID +
			 * '&SERIES_NAME=' + selected[0].SERIES_NAME + '&MODEL_ID=' +
			 * selected[0].MODEL_ID + '&MODEL_NAME=' + selected[0].MODEL_NAME +
			 * '&APACKAGE_ID=' + selected[0].APACKAGE_ID + '&APACKAGE_NAME=' +
			 * selected[0].APACKAGE_NAME + '&YEAR_MODEL=' +
			 * selected[0].YEAR_MODEL + '&INVOICE_DATE=' +
			 * selected[0].INVOICE_DATE + '&OWNER_NO=' + selected[0].OWNER_NO +
			 * '&OWNER_NAME=' + selected[0].OWNER_NAME + '&PHONE=' +
			 * selected[0].PHONE + '&MOBILE=' + selected[0].MOBILE + '&BRAND=' +
			 * selected[0].BRAND + '&SERIES=' + selected[0].SERIES + '&MODEL=' +
			 * selected[0].MODEL + '&APACKAGE=' + selected[0].APACKAGE
			 */// top.getChildValues(params);
			parent.getChildValues(params);
			// parent.document.getElementById("ownerMobile").contentWindow.value
			// = params.MOBILE;
			var index1 = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index1);
			/*
			 * window.location.href = ctx+
			 * '/dmsSales/ajax/fromVehclistToAddSales?VIN=' +selected[0].VIN
			 */

		},
		reset : function() {
			$("#vin").val('');
			$("#license").val('');
			$("#ownerName").val('');
			vm.reload();
		},
		reload : function() {
			vm.showOperPart = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table').bootstrapTable({
			url : ctx + '/dmsSales/ajax/getVehicleList',
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
			pageSize : 5, // 每页的记录行数（*）
			pageList : [ 5, 10, 20, 50, 100 ], // 可供选择的每页的行数（*）
			height : 280,
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showRefresh : false, // 是否显示刷新按钮
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			showColumns : false,
			responseHandler : this.responseHandler,

			columns : [ {
				field : '',
				title : '序号',
				align : 'center',
				valign : 'middle',
				formatter : function(value, row, index) {
					return index + 1;
				}
			}, {
				radio : true,
				sortable : false
			}, {
				field : 'VIN',
				title : 'VIN',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'BRAND_ID',
				title : 'BRAND_ID',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'LICENSE',
				title : 'LICENSE',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'BRAND',
				title : 'BRAND',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'BRAND_NAME',
				title : '品牌',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'SERIES_ID',
				title : 'SERIES_ID',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'SERIES',
				title : 'SERIES',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'SERIES_NAME',
				title : '车系',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'MODEL_ID',
				title : 'MODEL_ID',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'MODEL',
				title : 'MODEL',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'MODEL_NAME',
				title : '车型',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'APACKAGE_ID',
				title : 'APACKAGE_ID',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'APACKAGE',
				title : 'APACKAGE',
				align : 'center',
				valign : 'middle',
				visible : false
			}, {
				field : 'APACKAGE_NAME',
				title : '配置',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'YEAR_MODEL',
				title : '年款',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'INVOICE_DATE',
				title : '开票日期',
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
				field : 'PHONE',
				title : '车主电话',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'MOBILE',
				title : '车主手机',
				align : 'center',
				valign : 'middle'
			}

			]
		});
	};
	oTableInit.queryParams = function(params) {
		var param = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			pageindex : this.pageNumber,
			pageSize : this.pageSize,
			VIN : $("#vin").val(),
			LICENSE : $("#license").val(),
			OWNER_NAME : $("#ownerName").val()
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
