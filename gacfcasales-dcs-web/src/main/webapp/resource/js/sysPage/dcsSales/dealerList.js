$(function() {
	getBigOrg();

	var oTable = new TableInit();
	oTable.Init();

});

function getBigOrg() {
	$.ajax({
		type : "GET",
		url : ctx + "/dcsSales/ajax/getBigOrgList",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		async:true,
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
		async:true,
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

var vm = new Vue(
		{
			el : '#dealerListApp',
			data : {
				q : {
					dealerCode : null,
					dealerShortname : null,
					dealerName : null,
					bigOrg : null,
					smallOrg : null

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
						DEALER_CODE : selected[0].DEALER_CODE,
						DEALER_SHORTNAME : selected[0].DEALER_SHORTNAME,
						DEALER_NAME : selected[0].DEALER_NAME,
						BIG_ORG : selected[0].BIG_ORG,
						SMALL_ORG : selected[0].SMALL_ORG,
						STATUS : selected[0].STATUS
					};
					var values = "";
					for(var item in selected){
						values += selected[item].DEALER_CODE+",";
						//values=
					}
					console.log(values);
					parent.getProductChild(values);
					var index1 = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index1);

				},
				reset : function() {
					$("#dealerCode").val('');
					$("#dealerShortname").val('');
					$("#dealerName").val('');
					$('#bigOrg').selectpicker('val', '0');
					$('#smallOrg').selectpicker('val', '0');
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
			url : ctx + '/dcsSales/ajax/getDealerAll',
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
			pageSize : 1000, // 每页的记录行数（*）
			pageList : [ 1000,2000 ], // 可供选择的每页的行数（*）
			height : 400,
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
				checkbox : true
			}, {
				field : 'DEALER_CODE',
				title : '经销商代码',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'DEALER_SHORTNAME',
				title : '经销商简称',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'DEALER_NAME',
				title : '经销商名称',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'BIG_ORG',
				title : '大区',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'SMALL_ORG',
				title : '小区',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'STATUS',
				title : '状态',
				align : 'center',
				valign : 'middle',
				formatter : function(value, row, index) {
					var a = "";
					if (value == "10011001") {
						a = "有效";
					} else {
						a = "无效";
					}
					return a;
				}
			} ]
		});
	};
	oTableInit.queryParams = function(params) {
		var param = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			pageindex : this.pageNumber,
			pageSize : this.pageSize,
			dealerCode : $("#dealerCode").val(),
			dealerShortname : $("#dealerShortname").val(),
			dealerName : $("#dealerName").val(),
			bigOrg : $("#bigOrg").val(),
			smallOrg : $("#smallOrg").val()
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
