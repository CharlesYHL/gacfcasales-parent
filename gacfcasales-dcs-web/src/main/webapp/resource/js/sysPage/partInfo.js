$(function() {
	// 是否有效
	jQuery("#partStatus").append("<option value='0'>请选择</option>");
	jQuery("#partStatus").append("<option value='12781001'>是</option>");
	jQuery("#partStatus").append("<option value='12781002'>否</option>");

	jQuery("#partGroupCode").append("<option value='0'>请选择</option>");
	jQuery("#partGroupCode").append("<option value='11361009'>常规零部件</option>");
	jQuery("#partGroupCode").append("<option value='11361010'>第三方</option>");
	jQuery("#partGroupCode").append("<option value='11361008'>底盘号相关</option>");
	jQuery("#partGroupCode").append("<option value='11361005'>养护品</option>");
	jQuery("#partGroupCode").append("<option value='11361011'>电瓶</option>");
	jQuery("#partGroupCode").append("<option value='11361007'>用品</option>");

	jQuery("#partProperty").append("<option value='0'>请选择</option>");
	jQuery("#partProperty").append("<option value='80021001'>A属性</option>");
	jQuery("#partProperty").append("<option value='80021002'>B属性</option>");
	jQuery("#partProperty").append("<option value='80021003'>C属性</option>");

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

	console.log("partInfo init...");
	var oTable = new TableInitPart();
	oTable.Init();
});

var vm = new Vue({
	el : '#partInfoApp',
	data : {
		q : {
			partNo : null,
			partName : null

		},
		showOperPart : true,
		title : null,
		tmPartInfo : {
			PART_NO : null,
			PART_NAME : null

		}
	},
	methods : {
		query_part : function() {
			vm.reload();
		},
		clear_part : function() {
			$("#partNo").val('');
			$("#partName").val('');
			$('#partStatus').selectpicker('val', '0');
			$('#partProperty').selectpicker('val', '0');
			$('#partGroupCode').selectpicker('val', '0');
		},
		goBack : function(){
			console.log("返回");
			var index = parent.layer.getFrameIndex(window.name);
			console.log(index);
			parent.layer.close(index);
		},
		return_part : function() {
			// 获取选中的数据
			var selected = $('#table').bootstrapTable('getSelections');
			if (selected.length == 1) {
				console.log(selected[0].PART_NO);
				/* return selected[0].PART_NO; */
				var params = {
					PART_NO : selected[0].PART_NO,
					PART_NAME : selected[0].PART_NAME,
					PART_GROUP_CODE : selected[0].PART_GROUP_CODE,
					PART_PROPERTY : selected[0].PART_PROPERTY,
					CLAIM_PRICE : selected[0].CLAIM_PRICE,
					LIMIT_PRICE : selected[0].LIMIT_PRICE,
					IS_SJV : selected[0].IS_SJV,
					IS_MOP : selected[0].IS_MOP,
					IS_C_SALE : selected[0].IS_C_SALE,
					PART_STATUS : selected[0].PART_STATUS
				};

				window.location.href = ctx+ '/sysProduct/ajax/toProduct?PART_NO='
				+selected[0].PART_NO + '&PART_NAME='
				+selected[0].PART_NAME + '&PART_GROUP_CODE='
				+selected[0].PART_GROUP_CODE + '&PART_PROPERTY='
				+selected[0].PART_PROPERTY + '&CLAIM_PRICE='
				+selected[0].CLAIM_PRICE + '&LIMIT_PRICE='
				+selected[0].LIMIT_PRICE + '&IS_SJV='
				+selected[0].IS_SJV + '&IS_MOP='
				+selected[0].IS_MOP + '&IS_C_SALE='
				+selected[0].IS_C_SALE + '&PART_STATUS='
				+selected[0].PART_STATUS;
				
				/*var index = parent.layer.getFrameIndex(window.name); 
				parent.layer.close(index)*/
				
			} else {
				console("请选择一条数据");
				return false;
			}

		},
		reload : function() {
			vm.showOperPart = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});

var TableInitPart = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#table').bootstrapTable({
			url : ctx + '/sysProduct/ajax/getPartList',
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
				field : 'PART_NO',
				title : '配件编号',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'PART_NAME',
				title : '配件名称',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'PART_GROUP_CODE',
				title : '配件类别',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'PART_PROPERTY',
				title : '配件属性',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'CLAIM_PRICE',
				title : 'DNP价格',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'LIMIT_PRICE',
				title : 'MSRP价格',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'IS_SJV',
				title : '是否SJV',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'IS_MOP',
				title : '是否MOP',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'IS_C_SALE',
				title : '是否可销售',
				align : 'center',
				valign : 'middle'
			}, {
				field : 'PART_STATUS',
				title : '是否停用',
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
			PART_NO : $("#partNo").val(),
			PART_NAME : $("#partName").val(),
			PART_STATUS : $("#partStatus").val(),
			PART_PROPERTY : $("#partProperty").val(),
			PART_GROUP_CODE : $("#partGroupCode").val(),
			releaseStart : $("#releaseStart").val(),
			releaseEnd : $("#releaseEnd").val()
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