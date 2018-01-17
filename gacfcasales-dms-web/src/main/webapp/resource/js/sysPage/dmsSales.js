$(function() {
	getBrand();

	// 产品有效期
	jQuery("#productDate").append("<option value='0'>请选择</option>");
	jQuery("#productDate").append("<option value='12'>12个月</option>");
	jQuery("#productDate").append("<option value='24'>24个月</option>");
	jQuery("#productDate").append("<option value='36'>36个月</option>");
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

});

function getBrand() {
	$.ajax({
		type : "GET",
		url : ctx + "/dmsSales/ajax/getBrandList",
		contentType : "application/json",
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.length > 0) {
				var optionstring = "<option value='0'>请选择</option>";
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
		success : function(data) {
			if (data.length > 0) {
				var optionstring = "<option value='0'>请选择</option>";
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
		success : function(data) {
			if (data.length > 0) {
				var optionstring = "<option value='0'>请选择</option>";
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


function addSales(){
	globe_index = layer.open({
		id: 'addSales',
		title : '新增销售订单',
		type : 2,
		area : [ '80%', '100%' ],
		fixed : true, // 固定
		maxmin : false,
		content : ctx + '/dmsSales/ajax/toAddSales'
	});
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
			/*var oTable = new TableInit();
			oTable.Init();*/
			vm.reload();
		},
		reload : function() {
			vm.showList = true;
			$('#table').bootstrapTable('refresh');
		}
	}
});