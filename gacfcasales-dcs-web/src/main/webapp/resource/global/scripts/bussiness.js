/**
 * 配件模块相关功能
 */
var dmsPart = function() {
	var showOutPrice = function(priceType, container) {
		var price = "";
		// 销售价
		if (priceType == "13111001") {
			price = $("#salesPrice", container).val();
		}
		// 建议销售价
		if (priceType == "13111002") {
			price = $("#adviceSalePrice", container).val();
		}
		// 索赔价
		if (priceType == "13111003") {
			price = $("#claimPrice", container).val();
		}
		// 销售限价
		if (priceType == "13111004") {
			price = $("#limitPrice", container).val();
		}
		// 成本单价
		if (priceType == "13111005") {
			price = $("#costPrice", container).val();
		}
		$("#price", container).val(price);
		var priceTie = $("#priceTieShow", container).val();
		result = parseFloat(price) * parseFloat(priceTie);
		if (isNaN(result)) {
			result = price;
		}
		return result;
	};

	var initElementReadOnly = function(container) {
		// 文本输入框
		var inputArray = $(
				'input[type!="hidden"],textarea,select,a:not([data-goback],[data-dismiss],[data-toggle="tab"],.expand)',
				container);
		inputArray.each(function(index, item) {
			setElementReadOnly(item);
		});
	};
	
	//让某标志的元素显示为禁用,这个可以是一个类标志，可以是标签，也可以是id
	var initContextReadOnly = function(container,element){
		var objArray = $(element,container);
		objArray.each(function(index,item){
			setElementReadOnly(item);
		})
	}
	
	var setElementReadOnly = function(element) {
		var obj = element;
		var isExcludeReadOnly = $(obj).attr("data-isExcludeReadOnly");
		// 如果是排除的元素，则不执行隐藏
		if (isExcludeReadOnly && isExcludeReadOnly == "true") {
			return;
		}
		// 移除required 属性
		if ($(obj).hasClass("required")) {
			$(obj).attr("data-removeClass", "required");
			$(obj).removeClass("required");
		}
		if ($(obj).is('select')) {
			if ($(obj).hasClass("bs-select")) {
				$(obj).attr("disabled", "disabled");
				$(obj).closest("div.bs-select").addClass("disabled");
				$("button", $(obj).closest("div.bs-select")).addClass(
						"disabled");
				$(obj).closest("div.bs-select").removeClass("required");
				//$("span.bs-caret", $(obj).closest("div.bs-select")).hide();
			} else {
				$(obj).attr("disabled", "disabled");
			}
		} else if ($(obj).attr("type") == "checkbox") {
			$(obj).attr("disabled", "disabled");

		} else if ($(obj).attr("type") == "radio") {
			$(obj).attr("disabled", "disabled");

		} else if ($(obj).attr("type") == "text"
				|| $(obj).attr("type") == "hidden" || $(obj).is('textarea')) {
			if ($(obj).hasClass("ionRangeSlider")) {
				$(obj).data("ionRangeSlider").appendDisableMask();
			} else {
				$(obj).attr("disabled", "disabled");
				var objParentGroup = $(obj).parent("div.input-group");
				$(":not(input,textarea,span.input-group-addon)",
						$(obj).parent()).attr("disabled", "disabled");
			}
		} else if ($(obj).is('a')) {
			$(obj).attr("disabled", "disabled");
		} else if ($(obj).attr("type") == "file") {
			if($(obj).closest("div.file-input").size()>0){
				$("div.input-group-btn",$(obj).closest("div.file-input")).hide();
			}else{
				$(obj).attr("disabled","disabled");
			}
		}
	};

	//刷新移库页面的按钮
	var fushPageBtn = function(type,container){
		switch(type){
			case "init":
			$("#addBtn",container).removeAttr("disabled");
			$(".transferNo",container).removeAttr("disabled");
			$("#transferNo",container).val("");
			$("#transferDate",container).val("");
			break;
			case "addBtn":
			$("#saveBtn",container).removeAttr("disabled");
			$("#batchPartBtn",container).removeAttr("disabled");
			$("#cancelBtn",container).removeAttr("disabled");
			$("#addPartBtn",container).removeAttr("disabled");
			$("#transferNo",container).val("");
			break;
			case "addPartBtn":
				$("#saveBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#addPartBtn",container).removeAttr("disabled");
				break;
			case "cancelBtn":
			$(".transferNo",container).removeAttr("disabled");
			$(".transferDate",container).removeAttr("disabled");
			$("#addBtn",container).removeAttr("disabled");
			$("#batchSign",container).val("");
			break;
			case "editBtn":
				$("#saveBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#addPartBtn",container).removeAttr("disabled");
				break;
			case "searchBtn":
				$("#outStorgeBtn",container).removeAttr("disabled");
				$("#addPartBtn",container).removeAttr("disabled");
				$("#batchPartBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#cancellationBtn",container).removeAttr("disabled");
			break;
			case "batchBtn":
				$("#batchPartBtn",container).attr("disabled","true");
				$("#addPartBtn",container).attr("disabled","true");
				$("#saveBtn",container).removeAttr("disabled");
				break;
			case "saveBtn":
				$("#outStorgeBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#addPartBtn",container).removeAttr("disabled");
				$("#cancellationBtn",container).removeAttr("disabled");
				break;
			case "outStorageBtn":
				$("#addBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#printBtn",container).removeAttr("disabled");
				break;
			case "resetType":
				$(".transferNo",container).attr("disabled","true");
				$(".transferDate",container).attr("disabled","true");
				$("#addBtn",container).attr("disabled","true");
				$("#outStorgeBtn",container).attr("disabled","true");
				$("#addPartBtn",container).attr("disabled","true");
				$("#saveBtn",container).attr("disabled","true");
				$("#cancelBtn",container).attr("disabled","true");
				$("#cancellationBtn",container).attr("disabled","true");
				$("#printBtn",container).attr("disabled","true");
				$("#batchPartBtn",container).attr("disabled","true");
				$("#delJsonStr",container).val("");
				break;
		}
	}

	//刷新配件报损页面的按钮
	var fushPageBtn1 = function(type,container){
		switch(type){
			case "init":
				$(".lossNo",container).removeAttr("disabled");
				$("#addBtn",container).removeAttr("disabled");
			break;
			case "addBtn":
				$("#saveBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$(".inventoryNo",container).removeAttr("disabled");
				$("#addPartBtn",container).removeAttr("disabled");
				$("#lossNo",container).val("");
			break;
			case "editBtn":
				$("#addPartBtn",container).removeAttr("disabled");
				$("#saveBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				break;
			case "searchBtn":
				if($.trim($("#inventoryNo",container).val()) != ""){
					$("#outStorgeBtn",container).removeAttr("disabled");
					$("#cancelBtn",container).removeAttr("disabled");
				}else{
					$("#addPartBtn",container).removeAttr("disabled");
					$("#outStorgeBtn",container).removeAttr("disabled");
					$("#cancelBtn",container).removeAttr("disabled");
					$("#cancellationBtn",container).removeAttr("disabled");
				}
			break;
			case "inventoryBtn":
				$("#saveBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				break;
			case "saveBtn":
				$("#outStorgeBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#cancellationBtn",container).removeAttr("disabled");
				break;
			case "outStorageBtn":
				$("#addBtn",container).removeAttr("disabled");
				$("#cancelBtn",container).removeAttr("disabled");
				$("#printBtn",container).removeAttr("disabled");
				break;
			case "resetType":
				initContextReadOnly(container,$("#handler",container));
				$(".lossNo",container).attr("disabled","true");
				$(".inventoryNo",container).attr("disabled","true");
				$(".lossDate",container).attr("disabled","true");
				$("#addBtn",container).attr("disabled","true");
				$("#outStorgeBtn",container).attr("disabled","true");
				$("#addPartBtn",container).attr("disabled","true");
				$("#saveBtn",container).attr("disabled","true");
				$("#cancelBtn",container).attr("disabled","true");
				$("#cancellationBtn",container).attr("disabled","true");
				$("#printBtn",container).attr("disabled","true");
				$("#batchPartBtn",container).attr("disabled","true");
				$("#delJsonStr",container).val("");
				break;
		}
	}
	
	var removeElementsReadOnly = function(container, filterFunction) {
		// 文本输入框
		var inputArray = $(
				'input[type!="hidden"],textarea,select,a:not([data-goback],[data-dismiss],[data-toggle="tab"],.expand)',
				container);
		// 设置过滤函数
		if (filterFunction) {
			inputArray = inputArray.filter(filterFunction);
		}
		// 循环过滤
		inputArray.each(function(index, item) {
			removeElementReadOnly(item);
		});
	};
	var removeElementReadOnly = function(element) {
		var obj = element;
		var isExcludeReadOnly = $(obj).attr("data-isExcludeReadOnly");
		// 如果是排除的元素，则不执行隐藏
		if (isExcludeReadOnly && isExcludeReadOnly == "true") {
			return;
		}
		// 移除required 属性
		// 移除required 属性
		if ($(obj).attr("data-removeClass")) {
			$(obj).addClass($(obj).attr("data-removeClass"));
			$(obj).removeAttr("data-removeClass");
		}
		if ($(obj).is('select')) {
			if ($(obj).hasClass("bs-select")) {
				$(obj).removeAttr("disabled");
				$(obj).closest("div.bs-select").removeClass("disabled");
				$("button", $(obj).closest("div.bs-select")).removeClass("disabled");
						
			} else {
				$(obj).removeAttr("disabled");
			}
		} else if ($(obj).attr("type") == "checkbox") {
			$(obj).removeAttr("disabled");

		} else if ($(obj).attr("type") == "radio") {
			$(obj).removeAttr("disabled");

		} else if ($(obj).attr("type") == "text"
				|| $(obj).attr("type") == "hidden" || $(obj).is('textarea')) {
			$(obj).removeAttr("disabled");
			// 隐藏按钮
			$(":not(input)", $(obj).parent()).removeAttr("disabled");

		} else if ($(obj).is('a')) {
			$(obj).removeAttr("disabled");
		} else if ($(obj).attr("type") == "file") {
			if($(obj).closest("div.file-input").size()>0){
				$("div.input-group-btn",$(obj).closest("div.file-input")).show();
			}else{
				$(obj).removeAttr("disabled");
			}
		}
	}

	return {
		sample : function(priceType, container) {
			return showOutPrice(priceType, container);
		},
		initElementReadOnly : function(container) {
			return initElementReadOnly(container);
		},
		removeElementsReadOnly : function(container, filterFunction) {
			return removeElementsReadOnly(container, filterFunction);
		},
		fushPageBtn:function(type,container){
					return fushPageBtn(type,container);
				},
		fushPageBtn1:function(type,container){
					return fushPageBtn1(type,container);
				},
		initContextReadOnly:function(container,element){
			initContextReadOnly(container,element);
		}


	};
}();

/**
 * 维修模块相关功能
 */
var dmsRepair = function() {
	
	var fcdsLABOUR = {};

	var fcdsOEM = {};
	
	//选择维修项目加载事件
	var chooseLabourOnLoad = function(vin,container){
		var ModelLabourCode = queryModelCode(vin,container);
		var oemtag = queryOEM(vin);
//		aForm.FIsWar := IsWar;
//      MainFrame.IsWar := IsWar;
//      aForm.FMilage := aMilage;
//      aForm.FSalesDate := aSalesDate;
//      aForm.MainFrame.Milage := aMilage;
//      aForm.MainFrame.SalesDate := aSalesDate;
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/basedata/queryByLinsence/queryIsRestrict",
			type : 'GET',
			async : false,
			sucessCallBack : function(data) {
				fcdsLABOUR = data;
			}
		});
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/basedata/queryByLinsence/queryOEMTAG",
			data : {
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(data) {
				fcdsOEM = data;
			}
		});
		if((fcdsLABOUR.IS_RESTRICT == '12781002'&&dmsCommon.getSystemParamInfo("9008", "9008") == '12781001')||dmsCommon.getSystemParamInfo("9008", "9008") == '12781002'){
			if(dmsCommon.getSystemParamInfo("9088", "9088").indexOf($("#series",getElementContext()).val())==-1){
				$("#add",container).attr("disabled","disabled");
				if(fcdsOEM.BRAND == 'QT'){
					if(fcdsLABOUR.IS_OTHER=="12781001"){
						$("#fmodelGroup",container).attr("disabled","disabled");
						$("#fdownTag",container).attr("disabled","disabled");
						$("#downTag",container).setDmsValue("12781001");
					}
				}else{
					$("#fmodelGroup",container).attr("disabled","disabled");
					$("#fdownTag",container).attr("disabled","disabled");
					$("#downTag",container).setDmsValue("12781001");
				}
			}
		}
	}
	
	function checkHGAdd(){
		var flag = false;
		if(($("#model",getElementContext()).val()=='SEBRING')||($("#model",getElementContext()).val()=='CARAVAN')||($("#model",getElementContext()).val()=='SEBRING')){
			flag = true;
		}
		return flag;
	}
	
	//条件查询车辆库存信息
	var queryOEM = function(vin){
		var ret = "";
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()['repair']
					+ "/order/repair/queryOEM",
			data : {
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(data) {
				if(!isEmpty(data)){
					ret = data[0];
				}
			}
		});
		return ret;
	}
	
	//查询维修项目车型组
	var queryModelCode = function(vin,container){
		var ret = "";
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()['repair']
					+ "/order/repair/queryModelCode",
			data : {
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(data) {
				if(!isEmpty(data)){
					ret = data[0].MODEL_LABOUR_CODE;
				}
			}
		});	
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()['repair']
					+ "/order/repair/queryVehicleforactivity",
			data : {
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(data) {
				if(!isEmpty(data.MODEL_YEAR)&&data.MODEL_YEAR!="-"){
					$("#modelYear",container).setDmsValue(data.MODEL_YEAR);
				}
			}
		});
		return ret;
	}
	
	
	// 索赔类工单必须维修项目的故障原因必须填写，并且维修材料必须关联到维修项目
	var checkClaimOrder = function(container, repairItem) {
		var flag = true;
		var roType = $("#roType", container).val();
		if (roType == '12531004') {// 索赔
			if (IsValueExist(repairItem, "DOWN_TAG", "12781002")
					|| IsValueExist(repairItem, "DOWN_TAG", "")) {
				dmsCommon.tip({
					status : "warning",
					msg : "该VIN在总部不存在，请核对输入的17位VIN码是否正确！"
				});
				flag = false;
			}
			$.each(repairItem, function(i, j) {
				if ($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!="D"&&!isStringNull($("input[id=rowKey"+i+"]",$("#dms_table",container)).val())&&isStringNull($("input[id=TROUBLE_CAUSE"+i+"]",$("#dms_table",container)).val())) {
					dmsCommon.tip({
						status : "warning",
						msg : "工单类型为索赔时，维修项目["+$("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val()+"]明细中的故障原因必须填写"
					});
					flag = false;
					return false;
				}
//				if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!="D"&&$("select[id=CHARGE_PARTITION_CODE"+i+"]",$("#dms_table",container)).val()!="S"){
//					dmsCommon.tip({
//						status : "warning",
//						msg : "维修项目明细中的收费区分必须为[OEM索赔]"
//					});
//					flag = false;
//					return false;
//				}
			});
		}
		return flag;
	}

	/**
	 * 判断值是否存在 item 数据/JSON数据 field 字段 val 值
	 */
	var IsValueExist = function(item, field, val) {
		var flag = false;
		$.each(item, function(i, j) {
			if (j.field == val) {
				flag = true;
			}
		});
		return flag;
	}

	// 未结算索赔工单查询页面 加载维修类型下拉框
	var initRepairType1 = function(container) {
		var selectData = new Array();
		selectData.push({
			id : "SCBY",
			name : "首次保养"
		});
		selectData.push({
			id : "BXIU",
			name : "保修"
		});
		selectData.push({
			id : "SHYX",
			name : "善意维修"
		});
		selectData.push({
			id : "SBWS",
			name : "三包维修"
		});
		selectData.push({
			id : "YXYX",
			name : "营销活动"
		});
		selectData.push({
			id : "FUWU",
			name : "服务活动"
		});
		selectData.push({
			id : "SQWX",
			name : "PDI检查"
		});
		dmsDict.refreshSelectByData($("#repairTypeCode", container),
				selectData, "id", "name");
	}
	// 未结算索赔工单查询页面 加载日期类型
	var initQueryDateType = function(container) {
		var selectData = new Array();
		selectData.push({
			id : "RO_CREATE_DATE",
			name : "工单开单日期"
		});
		selectData.push({
			id : "FOR_BALANCE_TIME",
			name : "提交结算日期"
		});
		selectData.push({
			id : "COMPLETE_TIME",
			name : "竣工日期"
		});
		selectData.push({
			id : "DELIVERY_DATE",
			name : "交车日期"
		});
		selectData.push({
			id : "BALANCE_CLOSE_TIME",
			name : "关单日期"
		});
		selectData.push({
			id : "BALANCE_TIME",
			name : "结算时间"
		});
		selectData.push({
			id : "PRINT_RO_TIME",
			name : "工单打印时间"
		});
		selectData.push({
			id : "PRINT_BALANCE_TIME",
			name : "结算单打印时间"
		});
		dmsDict.refreshSelectByData($("#queryDateType", container), selectData,
				"id", "name");
	}

	var CheckRepairLabourCodeList = function(repairLabourCode, repairItem, repairPart,container) {
		if(repairItem!=null){
			$.each(repairItem,
					function(i, j) {
				if (!isStringNull($("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val())&&($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=="A"||$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=="U")
						&& $("input[id=NEEDLESS_REPAIR"+i+"]",$("#dms_table",container)).val() != '10571001') {
					// 委外的项目不可选择
					if (!$("input[name='CONSIGN_EXTERIOR"+i+"']").is(":checked")) {
						var child = {'LABOUR_CODE':0,'LABOUR_NAME':'','NEEDLESS_REPAIR':0};
						child.LABOUR_CODE = $("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
						child.LABOUR_NAME = $("input[id=LABOUR_NAME"+i+"]",$("#dms_table",container)).val();
						child.NEEDLESS_REPAIR = $("input[name='NEEDLESS_REPAIR"+i+"']",$("#dms_table",container)).is(":checked");
						repairLabourCode.push(child);
					}
				}
			});
		}
		if(repairPart!=null){
			$.each(repairPart, function(i, j) {
				var flag = false;
				$.each(repairLabourCode, function(k, l) {
					if (j.LABOUR_CODE == l.LABOUR_CODE) {
						flag = true;
					}
				});
				if (!flag) {
					j.LABOUR_CODE = '';
					j.LABOUR_NAME = '';
				}
			});
		}
	}

	var iniInfo = [];// 预警信息JSON数据

	/**
	 * 是否授权经销商
	 */
	var queryEntityTriple = function(){
		var triple = "";
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
			+ "/order/repair/queryEntityTriple",
			type : 'GET',
			async : false,
			sucessCallBack : function(data) {
				triple = data;
			}
		});		
		return triple;
	}
	
	/**
	 * 保存按钮校验
	 */
	var checkSave = function(obj, container) {
		var resultAll = false;
		if (isStringNull($("#checkFlag", container).val())
				|| $("#checkFlag", container).val() == '') {
			var activityItem = new Array();// 服务活动判断
			var repairItem = $("#dms_table", container).dmsTable()
					.getRowDataByIndex();
			var repairPart = $("#dms_part", container).dmsTable()
					.getRowDataByIndex();
			var repairItemCount = $("#dms_table", container).dmsTable()
					.getTableRows();
			var repairPartCount = $("#dms_part", container).dmsTable()
					.getTableRows();
			var addItem = $("#dms_subjoinItem", container).dmsTable()
					.getRowDataByIndex();
			var repairLabourCode = [];
			if(!checkItemCode(container, repairItem, repairPart, addItem)){
				return false;
			}
			if(!checkClaimOrder(container, repairItem)){
				return false;
			}
			//2017年10月23日 16:40:48
			//新加校验预交车时间是否完整
			if(!isStringNull($("#estimateBeginTime",container).val())&&$("#estimateBeginTime",container).val().length==16){
			}else{
				dmsCommon.tip({
					status : "warning",
					msg : "预开工时间格式不正确,时间需要精确到分钟！"
				});
				return false;
			}
			if(!isStringNull($("#endTimeSupposed",container).val())&&$("#endTimeSupposed",container).val().length==16){
			}else{
				dmsCommon.tip({
					status : "warning",
					msg : "预交车时间格式不正确,时间需要精确到分钟！"
				});
				return false;
			}
			if(parseFloat($("#inMileage",container).val())<parseFloat($("#lastRepairMileage",container).val())){
				dmsCommon.tip({
					status : "warning",
					msg : "进厂里程小于上次维修里程！"
				});
			}
			CheckRepairLabourCodeList(repairLabourCode, repairItem, repairPart,container);
			if ($("#ownerNo", container).val() == "888888888888") {
				if ($("#repairType", container).val() != "SQWX") {
					dmsCommon.tip({
						status : "warning",
						msg : "售前维修的车辆，开单时维修类型只能选择PDI检查！"
					});
					return false;
				}
			}
			// 下次保养里程应不能小于进厂行驶里程、出厂行驶里程不能小于进厂行驶里程
			var xcbylc = parseFloat($("#nextMaintainMileage",container).val());
			var jcxslc = parseFloat($("#inMileage",container).val());
			var ccxslc = parseFloat($("#outMileage",container).val());
			if(xcbylc<jcxslc){
				dmsCommon.tip({
					status : "warning",
					msg : "下次保养里程不能小于进厂里程！"
				});
				return false;
			}
			if(jcxslc>ccxslc){
				dmsCommon.tip({
					status : "warning",
					msg : "出厂里程不能小于进厂里程！"
				});
				return false;
			}
			// 校验维修类型为必填
			var index = dmsCommon.getSystemParamInfo("9006", "9006");// 前台开关查询
			$.each(repairItem, function(i, j) {
				if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='A'||$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='U'){
					if (isStringNull($("input[id=LABOUR_NAME"+i+"]",$("#dms_table",container)).val())) {
						if ($("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val() == 'G9999999') {
							dmsCommon.tip({
								status : "warning",
								msg : "通用项目名称不能为空！"
							});
							return false;
						}
					}
					if (index == '12781001') {
						if (isStringNull($("input[id=REPAIR_TYPE_CODE"+i+"]",$("#dms_table",container)).val())) {
							dmsCommon.tip({
								status : "warning",
								msg : "维修项目 维修类型为必填"
							});
							return false;
						}
					}
				}
			});
			index = dmsCommon.getSystemParamInfo("1100", "1100");// 前台开关查询
			if(index == '12781001'&&$("#roType",container).val()=='12531004'){
				if(!checkRepairType($("#repairType",container).val())){
					dmsCommon.tip({
						status : "warning",
						msg : "工单类型为索赔时，工单维修类型只能选择索赔类型的！"
					});
					return false;
				}
			}
			// 检验交车规范
			// 因开关关闭,不做0.0
			index = dmsCommon.getSystemParamInfo("1160", "1160");// 前台开关查询
			if (index == '12781001') {
				// 检验派工规范
				if(!checkPaiGongGuiFan(repairItem)){
					return false;
				}
				// 检验中断规范
				//CheckZhongDuanGuiFan(returnResult);
			}
			// ****************************************************************************
			// 索赔单，故障发生日期，必填
			if ($("#roType", container).val() != "12531004") {
				if (dmsCommon.getSystemParamInfo("8089", "8089") == '12781001') {
					if (isStringNull($("#troubleOccurDate", container).val())) {
						dmsCommon.tip({
							status : "warning",
							msg : "索赔工单 故障发生日期必填"
						});
						return false;
					}
				}
			}
			// 索赔单服务活动控制
			if (dmsCommon.getSystemParamInfo("3340", "3340") == '12781001'
					&& $("#roType", container).val() != "12531004") {
				var oemaActivityCount = 0;
				var activityCount = 0;
				var activityCount = CountActivity(repairItem, repairPart); // 活动数量
				var oemaActivityCount = CountOemActivity(repairItem, repairPart);// 下发活动数量
				// 只能选择一个下发活动
				if (oemaActivityCount > 1) {
					dmsCommon.tip({
						status : "warning",
						msg : "索赔单不允许选择多个下发活动"
					});
					return false;
				} else if (oemaActivityCount == 1) {
					// 不能有其他项目和配件
					if (HaveOtherItem(repairItem) && HaveOtherPart(repairPart)) {
						dmsCommon.tip({
							status : "warning",
							msg : "索赔单选择了下发活动不允许添加其他项目和配件"
						});
						return false;
					}
					// 不能选择非下发的活动
					if (activityCount > oemaActivityCount) {
						dmsCommon.tip({
							status : "warning",
							msg : "索赔单不允许添加非下发的服务活动"
						});
						return false;
					}
				}
			}
			var aLabourCode = "";
			var aModelLabourCode = "";
			if(isEmpty(fcdsLABOUR)){
				dmsCommon.ajaxRestRequest({
					url : dmsCommon.getDmsPath()["repair"]
					+ "/basedata/queryByLinsence/queryIsRestrict",
					type : 'GET',
					async : false,
					sucessCallBack : function(data) {
						fcdsLABOUR = data;
					}
				});
			}
			if(isEmpty(fcdsOEM)){
				dmsCommon.ajaxRestRequest({
					url : dmsCommon.getDmsPath()["repair"]
				+ "/basedata/queryByLinsence/queryOEMTAG",
					data : {
						'vin' : $("#vin", container).val()
					},
					sucessCallBack : function(data) {
						fcdsOEM = data;
					}
				});
			}
			if (fcdsLABOUR.IS_RESTRICT == '12781002'
					&& dmsCommon.getSystemParamInfo("9008", "9008") == '12781001'
					&& new Date(new String($("#createDate", container).val()))
							.getTime() > new Date(new String(dmsCommon
							.getSystemParamInfo("9018", "9018"))).getTime()) {
				if (fcdsOEM.BRAND == 'QT') {
					if (fcdsLABOUR.IS_OTHER == '12781001') {
						$.each(repairItem, function(i, j) {
							if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='A'||$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='U'){
								if(isStringNull($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val())){
									
									if(!isStringNull(aLabourCode)){
										if(!isStringNull($("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
											aLabourCode = aLabourCode + ',' + $("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
										}
									}else{
										if(!isStringNull($("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
											aLabourCode = $("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
										}
									}
									if(!isStringNull(aModelLabourCode)){
										if(!isStringNull($("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
											aModelLabourCode = aModelLabourCode + ',' + $("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
										}
									}else{
										if(!isStringNull($("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
											aModelLabourCode = $("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
										}
									}
									
									
								}
							}
						});
						dmsCommon.ajaxRestRequest({
							url : dmsCommon.getDmsPath()["repair"] + "/basedata/queryByLinsence/queryLabourCode",
							type : 'GET',
							data : {
								'labourCode' : aLabourCode,
								'modelLabourCode' : aModelLabourCode
							},
							async : false,
							sucessCallBack : function(data) {
								if(!isEmptySpecial(repairItem,"rowKey")){
									if (data == '12781002') {
										dmsCommon.tip({
											status : "warning",
											msg : "品牌授权车辆只允许选择下发的标准维修项目！"
										});
										resultAll = true;
									}
								}
							}
						});
						if(resultAll){
							return false;
						}
					}
				} else {
					$.each(repairItem, function(i, j) {
						if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='A'||$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='U'){
							if(isStringNull($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val())){
								if(!isStringNull(aLabourCode)){
									if(!isStringNull($("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
										aLabourCode = aLabourCode + ',' + $("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
									}
								}else{
									if(!isStringNull($("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
										aLabourCode = $("input[id=LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
									}
								}
								if(!isStringNull(aModelLabourCode)){
									if(!isStringNull($("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
										aModelLabourCode = aModelLabourCode + ',' + $("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
									}
								}else{
									if(!isStringNull($("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val())){
										aModelLabourCode = $("input[id=MODEL_LABOUR_CODE"+i+"]",$("#dms_table",container)).val();
									}
								}
							}
						}
					});
					dmsCommon.ajaxRestRequest({
						url : dmsCommon.getDmsPath()["repair"]
								+ "/basedata/queryByLinsence/queryLabourCode",
						type : 'GET',
						data : {
							'labourCode' : aLabourCode,
							'modelLabourCode' : aModelLabourCode
						},
						async : false,
						sucessCallBack : function(data) {
							if(!isEmptySpecial(repairItem,"rowKey")){
								if (data == '12781002') {
									dmsCommon.tip({
										status : "warning",
										msg : "品牌授权车辆只允许选择下发的标准维修项目！"
									});
									resultAll = true;
								}
							}
						}
					});
					if(resultAll){
						return false;
					}
				}
			}
			if (dmsCommon.getSystemParamInfo("1085", "1085") == '12781001'&&$("#roType",container).val()=='12531004') {
				if(!checkPartIsNeedRepairItem(container)){
					dmsCommon.tip({
						status : "warning",
						msg : "配件与维修项目没有关联!"
					});
					return false;
				}
			}
			// 计算预计下次保养日期
			if (dmsCommon.getSystemParamInfo("1074", "1074") == '12781001') {
//				nextMaintain(data.MILEAGE,container);
			}
			// 如果本地存在工单号则为编辑工单，执行UpdateRepairOrder，如果没，执行新增工单AddRepairOrder；
			// 工单服务活动必填检验逻辑
			var aModel = '';
			var brand = '';
			var series = '';
			var configCode = '';
			var salesdate = '';
			var mileage = '';
			var i = 0;
			var j = 0;
			var k = 0;
			var listActCod = GetActivityCodes2(repairItem, repairPart, addItem,container);//查询本工单勾选的服务活动
			// 新增开关：是否必选下发服务活动
			if (dmsCommon.getSystemParamInfo("3421", "3421") == '12781001') {
				if (!isStringNull($("#model", container).val()))
					aModel = $("#model", container).val();
				if (!isStringNull($("#brand", container).val()))
					brand = $("#brand", container).val();
				if (!isStringNull($("#series", container).val()))
					series = $("#series", container).val();
				if (!isStringNull($("#config", container).val()))
					configCode = $("#config", container).val();
				if (!isStringNull($("#salesDate", container).val()))
					salesdate = $("#salesDate", container).val();
				if (!isStringNull($("#FToTalChangeMileage", container).val()))
					i = parseInt($("#FToTalChangeMileage", container).val());
				if (!isStringNull($("#inMileage", container).val()))
					i = i + parseInt($("#inMileage", container).val());
				mileage = new String(i);
				activityItem = GetAllEnterableActivityInfo(
						$("#roNo", container).val(), $("#license", container)
								.val(), $("#vin", container).val(), aModel,
						brand, series, salesdate, mileage, $("#cardTypeCode",
								container).val(), configCode, listActCod);
				if (!activityItem) {
					return false;
				}
			}
			SetModifyNum(repairItem, repairItemCount, repairPart,
					repairPartCount, container);
		}
		if (CheckTripleInfo(getElementContext())) {
			/*
			 * { 0 代表 不需要预警。 1 代表 当前经销商是授权经销商。 2 代表 当前经销商不是授权经销商。 3 代表
			 * 当前车辆不属于三包车辆。 }
			 */
			switch (parseInt(GetTripleInfoFromDCS($("#vin", getElementContext()).val(),
					repairPart))) {
			case 0:
				$("#schemeStatus", getElementContext()).setDmsValue("22021006");// 方案状态“未达预警”
				break;
			case 1:
				if (isStringNull($("#checkFlag", getElementContext()).val())
						|| $("#checkFlag", getElementContext()).val() == '') {// 表示第一次进方法,需要校验权限
					// 如果当前用户没有授权权限，那么需要获取到别人的权限
					if (!dmsCommon.getBusinessPurview("10470000")) {
						$("#3BaoFlag", getElementContext()).setDmsValue("3bao");
						// 获取别的用户的权限。如果获取不成功，那么就不能保存
						$("#discountAuthorizeBtn", getElementContext()).click();
						return false;
					}
				}
				$("#checkFlag", getElementContext()).setDmsValue("");
				$("#schemeStatus", getElementContext()).setDmsValue("22021005");// 方案状态“授权维修”
				break;
			case 2:
				// 当前经销商不是授权经销商，要生成方案时，当前DMS的提示不友好，需修改为"该车已经达到警戒标准，请联系厂方解锁"
				if (isStringNull($("#checkFlag", getElementContext()).val())
						|| $("#checkFlag", getElementContext()).val() == '') {// 表示第一次进方法,需要校验权限
					obj.confirm('该车已经达到警戒标准，请联系厂方解锁！', function(confirmObj) {
					}, function(confirmObj) {
						return false;
					});
					$("#clOpinion", getElementContext()).click();
					return false;
				}
				$("#checkFlag", getElementContext()).setDmsValue("");
				$("#schemeStatus", getElementContext()).setDmsValue("22021001");// 方案状态“待审核”
				break;
			default:
				$("#schemeStatus", getElementContext()).setDmsValue("0");
				break;
			}
			return true;
		} else {
			$("#schemeStatus", getElementContext()).setDmsValue("0");
			return true;
		}
	}
	
	//校验收费区分能不能为OEM索赔
	function checkItemCode(container, labour, part, addItem){
		var flag = true;
		//判断配件名称是否为空
		$.each($("input[id^=PART_NAME]",$("#dms_part",container)),function(i,j){
			var it = $(j).closest('input').attr('id').split('PART_NAME')[1];//获取下标
			if(isStringNull($(j).val())){
				dmsCommon.tip({
					status : "warning",
					msg : "配件代码为["+$("input[id=PART_NO"+it+"]",$("#dms_part",container)).val()+"]的配件名称为空!"
				});
				flag = false;
				return false;
			}
		});
		if($("#roType",container).val()=='12531001'){//自费
			$.each(labour,function(i,j){
				if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!="D"&&$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!=""&&($("select[id=CHARGE_PARTITION_CODE"+i+"]",$("#dms_table",container)).val()=="S"||$("select[id=CHARGE_PARTITION_CODE"+i+"]",$("#dms_table",container)).attr('data-value')=="S")){
					if($("select[id=CHARGE_PARTITION_CODE"+i+"]",$("#dms_table",container)).val()=="S"){
						dmsCommon.tip({
							status : "warning",
							msg : "维修项目明细中的收费区分不能为[OEM索赔]"
						});
						flag = false;
						return false;
					}
				}
			});
			$.each($("select[id^=CHARGE_PARTITION_CODE]",$("#dms_part",container)),function(i,j){
				var it = $(j).closest('select').attr('id').split('CHARGE_PARTITION_CODE')[1];//获取下标
				if($("input[id=rowKey"+it+"]",$("#dms_part",container)).val()!="D"&&$("input[id=rowKey"+it+"]",$("#dms_part",container)).val()!=""&&($("select[id=CHARGE_PARTITION_CODE"+it+"]",$("#dms_part",container)).val()=="S"||$("select[id=CHARGE_PARTITION_CODE"+it+"]",$("#dms_part",container)).attr('data-value')=="S")){
					if($("select[id=CHARGE_PARTITION_CODE"+it+"]",$("#dms_part",container)).val()=="S"){
						dmsCommon.tip({
							status : "warning",
							msg : "维修材料明细中的收费区分不能为[OEM索赔]"
						});
						flag = false;
						return false;
					}
				}
			});
			$.each($("select[id^=CHARGE_PARTITION_CODE]",$("#dms_subjoinItem",container)),function(i,j){
				var it = $(j).closest('select').attr('id').split('CHARGE_PARTITION_CODE')[1];//获取下标
				if($("input[id=rowKey"+it+"]",$("#dms_subjoinItem",container)).val()!="D"&&$("input[id=rowKey"+it+"]",$("#dms_subjoinItem",container)).val()!=""&&($("select[id=CHARGE_PARTITION_CODE"+it+"]",$("#dms_subjoinItem",container)).val()=="S"||$("select[id=CHARGE_PARTITION_CODE"+it+"]",$("#dms_subjoinItem",container)).attr('data-value')=="S")){
					if($("select[id=CHARGE_PARTITION_CODE"+it+"]",$("#dms_subjoinItem",container)).val()=="S"){
						dmsCommon.tip({
							status : "warning",
							msg : "附加项目明细中的收费区分不能为[OEM索赔]"
						});
						flag = false;
						return false;
					}
				}
			});
		}else if($("#roType",container).val()=='12531004'){//索赔
			$.each(labour,function(i,j){
				if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!="D"&&$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!=""&&checkSFQF('dms_table',i,container)){
					dmsCommon.tip({
						status : "warning",
						msg : "维修项目明细中的收费区分必须为[OEM索赔]"
					});
					flag = false;
					return false;
				}
			});
//			$.each(part,function(i,j){
//				if($("input[id=rowKey"+i+"]",$("#dms_part",container)).val()!="D"&&$("input[id=rowKey"+i+"]",$("#dms_part",container)).val()!=""&&checkSFQF('dms_part',i,container)&&isStringNull($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_part",container)).val())){
//					dmsCommon.tip({
//						status : "warning",
//						msg : "维修材料明细中的收费区分必须为[OEM索赔]"
//					});
//					flag = false;
//					return false;
//				}
//			});
			$.each($("select[id^=CHARGE_PARTITION_CODE]",$("#dms_part",container)),function(i,j){
				var it = $(j).closest('select').attr('id').split('CHARGE_PARTITION_CODE')[1];//获取下标
				if($("input[id=rowKey"+it+"]",$("#dms_part",container)).val()!="D"&&$("input[id=rowKey"+it+"]",$("#dms_part",container)).val()!=""&&checkSFQF('dms_part',it,container)){
					dmsCommon.tip({
						status : "warning",
						msg : "维修材料明细中的收费区分必须为[OEM索赔]"
					});
					flag = false;
					return false;
				}
			});
			$.each($("select[id^=CHARGE_PARTITION_CODE]",$("#dms_subjoinItem",container)),function(i,j){
				var it = $(j).closest('select').attr('id').split('CHARGE_PARTITION_CODE')[1];//获取下标
				if($("input[id=rowKey"+it+"]",$("#dms_subjoinItem",container)).val()!="D"&&$("input[id=rowKey"+it+"]",$("#dms_subjoinItem",container)).val()!=""&&checkSFQF('dms_subjoinItem',it,container)){
					dmsCommon.tip({
						status : "warning",
						msg : "附加项目明细中的收费区分必须为[OEM索赔]"
					});
					flag = false;
					return false;
				}
			});
//			$.each(addItem,function(i,j){
//				if($("input[id=rowKey"+i+"]",$("#dms_subjoinItem",container)).val()!="D"&&$("input[id=rowKey"+i+"]",$("#dms_subjoinItem",container)).val()!=""&&checkSFQF('dms_subjoinItem',i,container)&&isStringNull($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_subjoinItem",container)).val())){
//					dmsCommon.tip({
//						status : "warning",
//						msg : "附加项目明细中的收费区分必须为[OEM索赔]"
//					});
//					flag = false;
//					return false;
//				}
//			});
		}
		return flag;
	}
	
	//校验收费区分
	function checkSFQF(tab,i,container){
		var flag = true;
		if($("select[id=CHARGE_PARTITION_CODE"+i+"]",$("#"+tab,container)).attr('data-value')=="S"){
			flag = false;
		}
		if($("select[id=CHARGE_PARTITION_CODE"+i+"]",$("#"+tab,container)).val()=="S"){
			flag = false;
		}
		return flag;
	}
	
	function checkPartIsNeedRepairItem(container){
		var flag = true;
		$.each($("tbody",$("#dms_part",container)).find('tr'),function(i,j){
			if(isStringNull($(j).find("select[id^=LABOUR_CODE]").val())){
				flag = false;
			}
		});
		var t = $("#dms_part",container).dmsTable().getRowDataByIndex();//维修材料
		if(isEmpty(t)){
			flag = true;
		}
		var tt = $("#dms_table",container).dmsTable().getRowDataByIndex();//维修项目
		if(isEmpty(tt)){
			flag = true;
		}
		return flag;
	}
	
	function checkRepairType(value){
		var flag = false;
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/checkRepairType",
			type : 'GET',
			data : {
				'code' : value
			},
			async : false,
			sucessCallBack : function(data) {
				if(data=='0'){
					flag = true;
				}
			},
			errorCallBack : function(data) {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
		return flag;
	}
	
	/**
	 * 保存回调
	 * @param container
	 * @returns
	 */
	function btnSaveCallBack(container){
		$("#save", container).attr('disabled', 'disabled');
		// 出险单相关
		occurInsuranceAbout($("#insuranceNo", container).val(), $(
				"#occurInsuranceNo", container).val(), $("#vin", container)
				.val(), $("#roNo", container).val());
		if (!isStringNull($("#IActivityRo", container).val())
				&& !isStringNull($("#roNo", container).val())) {
			activityResult($("#vin", container).val(), $("#roNo", container)
					.val());
		}
		if (!isStringNull($("#roNo", container).val())
				&& !isStringNull($("#insuranceNo", container).val())
				&& !isStringNull($("#occurInsuranceNo", container).val())) {
			var insuranceNo = $("#insuranceNo", container).val();
			if (insuranceNo.length > 194)
				insuranceNo = insuranceNo.substr(0, 194);
			dmsCommon.ajaxRestRequest({
				url : dmsCommon.getDmsPath()["repair"]
						+ "/order/repair/saveSettlementOldpart",
				type : 'GET',
				data : {
					'roNo' : $("#roNo", container).val(),
					'occurInsuranceNo' : insuranceNo
				},
				async : false,
				sucessCallBack : function(data) {
				},
				errorCallBack : function(data) {
					dmsCommon.tip({
						status : "error",
						msg : "查询失败!"
					});
				}
			});
		}
	}

	// 为空判断
	function isEmpty(value) {
		return (Array.isArray(value) && value.length === 0)
				|| (Object.prototype.isPrototypeOf(value) && Object.keys(value).length === 0);
	}
	
	// 为空判断   (带新增或修改标志版[维修项目必须下发])
	function isEmptySpecial(value,rowKey,container) {
		var res = true;
		var flag = (Array.isArray(value) && value.length === 0) || (Object.prototype.isPrototypeOf(value) && Object.keys(value).length === 0);
		if(!flag){
			$.each(value,function(i,j){
				if($("input[id="+rowKey+i+"]",$("#dms_table",container)).val()=="A"||$("input[id="+rowKey+i+"]",$("#dms_table",container)).val()=="U"){
					if($("input[id=DOWN_TAG"+i+"]",$("#dms_table",container)).val()!='12781001'&&isStringNull($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val())){
						res = false;
					}
				}
			});
		}
		return res;
	}

	// 工单号回车事件
	var roNoKeyUp = function(obj, container) {
		$("#roNoQueryBtn", container).click();
	}
	
	//新建按钮事件
	var NewRepairOrder = function(container){

		//客户经理默认本人
		
		SetDefaultPara(container);
	}
	
	var SetDefaultPara = function(container){
//		var xhr = null;
//	    var res = "";
//	    if(window.XMLHttpRequest){
//	      xhr = new window.XMLHttpRequest();
//	    }else{ // ie
//	      xhr = new ActiveObject("Microsoft")
//	    }
//	    // 通过get的方式请求当前文件
//	    xhr.open("get","/");
//	    xhr.send(null);
//	    // 监听请求状态变化
	    var CurDateTime = null;
//	    xhr.onreadystatechange = function(){}
		$.ajax({type:"GET",async:false,url:"/",complete:function(x){
			CurDateTime = new Date(x.getResponseHeader("Date"));
		 }});
		$("#estimateBeginTime",container).setDmsValue(CurDateTime.getTime());
		$("#endTimeSupposed",container).setDmsValue(CurDateTime.getTime());
		if(dmsCommon.getSystemParamInfo("1160", "1160")=='12781001'){
			if(!isStringNull(dmsCommon.getSystemParamInfo("8037", "8037"))&&parseInt(dmsCommon.getSystemParamInfo("8037", "8037"))>0){
				$("#estimateBeginTime",container).setDmsValue(CurDateTime.getTime()+parseInt(dmsCommon.getSystemParamInfo("8037", "8037"))*60*1000);
			}
		}
		$("#createDate",container).setDmsValue(CurDateTime.getTime());
		//$("#endTimeSupposed",container).setDmsValue(CurDateTime.getTime());
		//$("#license",container).setDmsValue(dmsCommon.getSystemParamInfo("1002", "1002"));
		$("#roStatus",container).setDmsValue('12551001');
		$("#completeTag",container).setDmsValue('12781002');
		$("#isCustomerInAsc",container).setDmsValue('12781001');
		//初始化页面显示。
		//工单类型  维修工单
		$("#roType",container).setDmsValue('12531001');
		
		$("#checkIsTrace0",container).prop('checked','checked');
		$("#traceTime",container).setDmsValue('11251004');//默认全天
		
		//一些为否的默认值：
		//是否洗车、是否路试、是否质检  IS_SEASON_CHECK
		if(dmsCommon.getSystemParamInfo("1782", "1782")=='12781001'){
			$("#checkIsTake0",container).prop('checked','checked');
		}
		if(dmsCommon.getSystemParamInfo("1067", "1067")=='12781001'){
			$("#checkIsWash0",container).prop('checked','checked');
		}
		if(dmsCommon.getSystemParamInfo("1068", "1068")=='12781001'){
			$("#checkIsRoad0",container).prop('checked','checked');
		}
		if(dmsCommon.getSystemParamInfo("1069", "1069")=='12781001'){
			$("#checkIsQuality0",container).prop('checked','checked');
		}
		$("#checkIsFactory0",container).prop('checked','checked');
		
		//如果当前操作人是服专，那 当前默认服专为自己
		findServiceAdvisor($("#empNo",container).val(),container);
		//工时单价 跟随维修类型变化、及时更新。
		var repairItem = $("#dms_table",container).dmsTable().getRowDataByIndex();
		$.each(repairItem,function(i,j){
			$("#dms_table",container).dmsTable().updateRowByIndex(j.index,{LABOUR_PRICE:dmsDict.getSelectedOptionData($("#labourPrice",container)).LABOUR_PRICE});
		});
		console.log(dmsCommon.getSystemParamInfo("1069", "1069"));
		//维修类型
		$("repairType",container).setDmsValue(dmsCommon.getSystemParamInfo("1007", "1007"));
		if(dmsCommon.getSystemParamInfo("1011", "1011")=='12911001'){
			ChangeLabourPrice(false,container);
		}else{
			ChangeLabourPrice(true,container);
		}
	}
	
	/**
	 * {** 维修类型或者车型变化 导致工时单价的变化  主要是根据基本参数中 维修工时单价根据 。。。
新增一点： 维修类型变化时获取当前维修类型是否是保险的字段值，赋给全局变量 FIsInsure
主要用于保存时校验：如果是保险的类型，提示输入保险公司}
	 */
	var ChangeLabourPrice = function(isModel,container){
		//赋维修车型组。
		var repairItem = $("#dms_table",container).dmsTable().getRowDataByIndex();
		$.each(repairItem,function(i,j){
			if(!isStringNull($("#model").val())){
				var labourCode = findModelLabourCodeByModel2($("#model").val());
				$("#dms_table",container).dmsTable().updateRowByIndex(j.index,{MODEL_LABOUR_CODE:labourCode});
			}
		});
		//工单载入是否计算
		if($("#FIsLoadIngRO",container).val()=='true') return ;
		var sLabourPrice = dmsCommon.getSystemParamInfo("1011", "1011");
		var tmpLabourPrice = ""
		if(!isStringNull(sLabourPrice)){
			//如果是根据维修类型。
			if(sLabourPrice=='12911001'&&!isModel){
				if(!isStringNull($("#repairType",container).val())){
					tmpLabourPrice = findLabourPriceByRepairTypeCode($("#repairType",container).val());
					
				}
			}else if(sLabourPrice=='12911002'){//根据车型
				if(!isStringNull($("#model",container).val())){
					tmpLabourPrice = findLabourPriceByModelCode($("#brand",container).val(),$("#series",container).val(),$("#model",container).val());
				}
			}
			if(!isStringNull(tmpLabourPrice)){
				//维修工时列表中能够找到该值。
				var str = $("#test option").map(function(){return $(this).val();}).get().join(",");//工时单价下拉框所有value
				var reg = new RegExp(tmpLabourPrice);
				if (reg.test(str)) {
					$("#labourPrice",container).setDmsValue(tmpLabourPrice);
				}
			}
		}
		//获取维修类型的是否保险字段；  //是否保险
		$("#insure", container).setDmsValue(findIsInsuranceByRepairTypeCode($("#repairType",container).val()));
	}
	
	/**
	 * 根据维修类型查询是否保险
	 */
	var findIsInsuranceByRepairTypeCode = function(code){
		var result = '';
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/findIsInsuranceByRepairTypeCode",
			type : 'GET',
			data : {
				'code' : code
			},
			async : false,
			sucessCallBack : function(data) {
				result = data;
			},
			errorCallBack : function() {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
		return result;
	}
	
	/**
	 * 根据维修类型查询工时单价
	 */
	var findLabourPriceByRepairTypeCode = function(code){
		var result = "";
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/findLabourPriceByRepairTypeCode",
			type : 'GET',
			data : {
				'code' : code
			},
			async : false,
			sucessCallBack : function(data) {
				result = data;
			},
			errorCallBack : function() {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
		return result;
	}
	
	/**
	 * 根据车型代码查询工时单价
	 */
	var findLabourPriceByModelCode = function(brand,series,model){
		var result = '';
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/findLabourPriceByModelCode",
			type : 'GET',
			data :{ 'brand' : brand,'series' : series,'model' : model},
			async : false,
			sucessCallBack : function(data) {
				result = data;
			},
			errorCallBack : function() {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
		return result;
	}
	
	/**
	 * 判断是否服务专员
	 */
	var findServiceAdvisor = function(name,container){
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/findServiceAdvisor",
			type : 'GET',
			data : {
				'name' : name
			},
			async : false,
			sucessCallBack : function(data) {
				console.log(data)
				console.log('12---------------------------------------------------')
				if(data=='1'){//表示是
					console.log('13---------------------------------------------------')
					//$("#serviceAdvisor",container).setDmsValue("{[userInfo.employeeNo]}");
					//$("#serviceAdvisor",container).setDmsValue('{[userInfo.employeeNo]}');
					console.log('14---------------------------------------------------')
				}
			},
			errorCallBack : function() {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
	}

	// vin号回车事件
	// VIN号直接回车，只有是新建车辆的时候VIN号才可以编辑，其他时候都是点击？选择VIN号。
	// 回车的时候执行DE，去OEM查询车辆信息。
	var vinKeyUp = function(obj, container) {
		if (isStringNull($("#vin", container).attr("disabled"))
				|| $("#vin", container).attr("disabled") != "disabled") {
			// 从本地查找车辆信息。如果没有通过DE调用OEM的车辆信息。
			dmsCommon.ajaxRestRequest({
				url : dmsCommon.getDmsPath()["repair"]
						+ "/order/repair/queryVinByVin",
				type : 'GET',
				data : {
					'vin' : $("#vin", container).val()
				},
				async : false,
				sucessCallBack : function(data) {
					if (data.length == 1) {
						// 接受返回的车辆信息。 need to do DE 设置afcds的字段。否则不能获取到字段值。
						setVehicleInfo(data, false, true, false,container);
					}
				},
				errorCallBack : function() {
					dmsCommon.tip({
						status : "error",
						msg : "查询失败!"
					});
				}
			});
		}
	}

	function activityResult(vin, roNo) {
		var result = [];
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/queryActivityResult",
			type : 'GET',
			data : {
				'vin' : vin,
				'activityRo' : roNo
			},
			async : false,
			sucessCallBack : function(data) {
				result.push(data);
			},
			errorCallBack : function(data) {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
		return result;
	}

	// 工单保存成功后，如果该工单关联了出险信息，则将工单号 保存到所关联的出险信息中,并将出险单的跟踪状态更新为‘已来厂’
	// 另外还要将该出险单的处理状态更新为‘维修中’
	function occurInsuranceAbout(no1, no2, vin, roNo) {
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/occurInsuranceAbout",
			type : 'GET',
			data : {
				'no1' : no1,
				'no2' : no2,
				'vin' : vin,
				'roNo' : roNo
			},
			async : false,
			sucessCallBack : function(data) {
			},
			errorCallBack : function(data) {
				dmsCommon.tip({
					status : "error",
					msg : "查询失败!"
				});
			}
		});
	}

	/*
	 * 功能说明： b）满足三包条件之后，需要开发一个同步接口来到DCS系统中查询三包预警。对返回的预警结果进行如下判断：
	 * b1）如果返回的预警结果达到三包预警级别，那么判断当前经销商是否授权。 如果当前经销商是授权，那么判断当前用户是否有授权开单？
	 * b1a)如果有权限，那么直接保存当前工单（方案状态为"授权维修"）。
	 * b1b)如果没有权限，那么弹出授权窗口。登录已有此权限的用户，来获取到此权限。 成功得到权限之后，可以直接保存当前工单（方案状态为"授权维修"）。
	 * 如果当前经销商是没有授权，那么进行如下判断是否要生成预警方案？ b11）如果不生成方案，那么不保存，继续编辑。
	 * b12）如果生成方案，那么保存工单（方案状态为"等待审核"），同时上报工单以及其明细信息。 返回函数值： 0 代表 不需要预警。 1 代表
	 * 当前经销商是授权经销商。 2 代表 当前经销商不是授权经销商。 3 代表 当前车辆不属于三包车辆。
	 */
	function GetTripleInfoFromDCS(vin, repairPart) {
		var result = '';
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/getTripleInfo",
			type : 'GET',
			data : {
				'vin' : vin,
				'activityCode' : findActivityCode(repairPart),
				'partNo' : findPartNo(repairPart)
			},
			async : false,
			sucessCallBack : function(data) {
				if (!isEmpty(data.ttTripleInfo)&&data.ttTripleInfo!=undefined) {
					iniInfo = data.ttTripleInfo;
					$("#pre3BaoWarm").click();//三包预警配件
				}
				result = data.tripleResult;
			}
		});
		return result;
	}

	/*
	 * 弹出预警信息表格初始化
	 */
	function initPre3BaoWarm(srca) {
		new Datatable().initLocale({
			src : srca,
			data : iniInfo,
			sortName : "PART_CODE",
			sortOrder : "asc",
			autoHeight : false,
			undefinedText : "",
			columns : [ {
				field : "PART_CODE",
				title : "零件编码"
			}, {
				field : "ptmum",
				title : "零件次数"
			}, {
				field : "WARN_ITEM_NAME",
				title : "项目"
			}, {
				field : "warntimes",
				title : "项目次数/总天数"
			}, {
				field : "WARN_STANDARD",
				title : "预警次数"
			}, {
				field : "LEGAL_STANDARD",
				title : "法定标准"
			}, {
				field : "YELLOW_STANDARD",
				title : "黄色标准"
			}, {
				field : "ORANGE_STANDARD",
				title : "橙色标准"
			}, {
				field : "RED_STANDARD",
				title : "红色标准"
			} ]
		});
	}

	function findActivityCode(repairPart) {
		var code = "";
		$.each(repairPart, function(i, j) {
			code = code + "," + j.ACTIVITY_CODE;
		});
		return code;
	}

	function findPartNo(repairPart) {
		var code = "";
		$.each(repairPart, function(i, j) {
			code = code + "," + j.PART_NO;
		});
		return code;
	}

	var CheckTripleInfo = function(container) {
		var flag = true;
		if (!checkBrandIsOem(container)) {
			flag = false;
		}
		if (isStringNull($("#salesDate", container).val())) {
			flag = false;
		}
		// 1、三包预警开关
		// 2、是否索赔工单
		if (dmsCommon.getSystemParamInfo("1180", "1180") == '12781002'
				|| $("#roType", container).val() != "12531004") {
			flag = false;
		}
		// 几种维修类型 不做三包预警 首次保养 常规保养 定期保养
		var repairType = $("#repairType", container).val();
		if (repairType == 'SCBY' || repairType == 'CGBY'
				|| repairType == 'DQBY') {
			flag = false;
		}
		// 进厂里程和当前日期是否在三包期内
		if (!checkRule(container)) {
			flag = false;
		}
		return flag;
	}
	var checkRule = function(container) {
		var v_fDateDis = 0;
		var v_fMiliageDis = 0.0;
		var deDate = $("#salesDate", container).val();
		var afMilage = $("#inMileage", container).val();
		var v_sCurr = new Date();
		if (!isStringNull(dmsCommon.getSystemParamInfo("1903", "1903"))) {
			v_fDateDis = parseInt(dmsCommon.getSystemParamInfo("1903", "1903"));
		} else {
			v_fDateDis = 2;
		}
		if (!isStringNull(dmsCommon.getSystemParamInfo("1904", "1904"))) {
			v_fMiliageDis = parseInt(dmsCommon.getSystemParamInfo("1904",
					"1904"));
		} else {
			v_fMiliageDis = 50000;
		}
		var ddate = new Date(deDate);
		var dyear = ddate.getFullYear();
		ddate.setFullYear(dyear + v_fDateDis);
		if ((new Date(deDate).getTime() <= v_sCurr.getTime())
				&& (v_sCurr.getTime() <= ddate.getTime())
				&& (afMilage <= v_fMiliageDis)) {
			return true;
		} else {
			return false;
		}
	}

	var checkBrandIsOem = function(container) {
		// 非OEM品牌不校验三包规则
		var text = dmsDict.getSelectedOptionData($("#brand", container)).OEM_TAG;
		if (text == '12781001') {
			return true;
		} else {
			return false;
		}
	}

	//设置修改次数
	var SetModifyNum = function(repairItem, repairItemCount, repairPart,
			repairPartCount, container) {
		// 查询维修项目和维修配件是否发生了值的改变
		if (parseInt(repairItemCount) != parseInt(repairItem.length)
				|| parseInt(repairPartCount) != parseInt(repairPart.length)) {
			if (!isStringNull($("#printRoTime", container).val())) {
				$("#modifyNum", container).setDmsValue(
						parseInt($("#modifyNum", container).val()) + 1);
				return;
			}
		}
		// 判断维修项目和维修配件
		if (checkItemIsModify(repairItem,"dms_table",container) || checkItemIsModify(repairPart,"dms_part",container)) {
			$("#modifyNum", container).setDmsValue(
					parseInt($("#modifyNum", container).val()) + 1);
			return;
		}
	}

	// 工单判断表格字段是否发生变化
	var checkItemIsModify = function(item,tab,container) {
		var result = false;
		var flags = new Array();
		flags.push("A");
		flags.push("U");
		$.each(item, function(i, j) {
			if (flags.indexOf($("input[id=rowKey"+i+"]",$("#"+tab,container)).val()) > 0) {// 表示做了修改
				result = true;
			}
		});
		return result;
	}

	// 工单保存获取必须参加还没参加的所有服务活动编号
	var GetAllEnterableActivityInfo = function(aRoNo, aLicense, aVin, aModel,
			brand, series, salesdate, mileage, cardTypeCode, configCode, listActCod) {
		var infoItem = new Array();// 获取可参加的服务活动数组(field只有一个活动编号)
		var couldItem = new Array();// 获取还未参加的必须参加的服务活动数组(field只有一个活动编号)
		var Enterable = new Array();// 可参加的服务活动
		var isable = null;// 已经参加的服务活动
		var flag = false;
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/order/repair/getAllEnterableActivityInfo",
			type : 'GET',
			data : {
				'aRoNo' : aRoNo,
				'aLicense' : aLicense,
				'aVin' : aVin,
				'aModel' : aModel,
				'brand' : brand,
				'series' : series,
				'salesdate' : salesdate,
				'mileage' : mileage,
				'cardTypeCode' : cardTypeCode,
				'configCode' : configCode
			},
			async : false,
			sucessCallBack : function(data) {
				if (data != null) {
					Enterable = data;
				}
			},
			errorCallBack : function() {
				if(aVin.length!=17){
					dmsCommon.tip({
						status : "error",
						msg : "VIN号不满足17位,请重新选择!"
					});
				}else{
					dmsCommon.tip({
						status : "error",
						msg : "服务活动查询失败!"
					});
				}
				flag = true;
			}
		});
		if(flag){
			return false;
		}
		// 查询参加的活动,null表示没有参加活动
		 dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"] +"/order/repair/PreActivityWarn",
			type : 'GET',
		 	data : {
		 		'vin' : aVin,
		 		'activityCodes' : listActCod
		 	}, 
		 	async : false,
		 	sucessCallBack : function(data) {
		 		if(!isEmpty(data)){
		 			isable = data;
		 		}
		 	}
		 });
		 
		if (Enterable != null) {
			$.each(Enterable, function(i, j) {
				// 活动性质必填,下发
				if (j.ACTIVITY_PROPERTY == '11961001'
						&& j.DOWN_TAG == '12781001') {
					infoItem.push(j.ACTIVITY_CODE);
				}
			});
			infoItem = filterArray(infoItem);
		}
		if (!isStringNull(isable)) {
			if (!isStringNull(listActCod) && listActCod.split(',').indexOf(isable) == -1) {// 表示没有参加此项服务活动
				listActCod=listActCod + ',' + isable;
			}else if(isStringNull(listActCod)){
				listActCod=listActCod + ',' + isable;
			}
			//提示已经参加了这个活动
			dmsCommon.tip({ status : "warning", msg : "该车辆已经参与过此服务活动【"+isable+"】，不允许重复参加!" });
			return false;
		}
		if(isStringNull(listActCod)){
			couldItem = infoItem.slice();
		}else{
			for(var tx = 0; tx<infoItem.length; tx++){
				if(listActCod.split(',').indexOf(infoItem[tx]) == -1){
					couldItem.push(infoItem[tx]);
				}
			}
		}
		if(couldItem.length>0){
			var choose = false;
			if (!isStringNull(listActCod)&&listActCod.split(',').length > 0) {
				for (var i = 0; i < couldItem.length; i++) {
					if (listActCod.split(',').indexOf(couldItem[i]) == -1) {// 表示未参加此服务活动
						choose = true;
					}
				}
				if (choose) {
					dmsCommon.tip({
						status : "warning",
						msg : "该车辆存在必选的服务活动，请点击【服务活动】选择！"
					});
					return false;
				}
			} else {
				dmsCommon.tip({
					status : "warning",
					msg : "该车辆存在必选的服务活动，请点击【服务活动】选择！"
				});
				return false;
			}
		}
		return true;
	}

	// 删除数组指定元素
	function removeByValue(arr, val) {
		for (var i = 0; i < arr.length; i++) {
			if (arr[i] == val) {
				arr.splice(i, 1);
				break;
			}
		}
	}

	// 去除数组重复项
	function filterArray(receiveArray) {
		var arrResult = new Array(); // 定义一个返回结果数组.
		for (var i = 0; i < receiveArray.length; ++i) {
			if (check(arrResult, receiveArray[i]) == -1) {
				// 在这里做i元素与所有判断相同与否
				arrResult.push(receiveArray[i]);
				// 添加该元素到新数组。如果if内判断为false（即已添加过），
				// 则不添加。
			}
		}
		return arrResult;
	}

	function check(receiveArray, checkItem) {
		var index = -1; // 函数返回值用于布尔判断
		for (var i = 0; i < receiveArray.length; ++i) {
			if (receiveArray[i] == checkItem) {
				index = i;
				break;
			}
		}
		return index;
	}

	var GetActivityCodes2 = function(repairItem, repairPart, addItem,container) {
		var item = '';
		// 维修项目
		$.each(repairItem, function(i, j) {
			if (!isStringNull($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val())&&$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()!="D"&&!isStringNull($("input[id=rowKey"+i+"]",$("#dms_table",container)).val())) {
				var reg = new RegExp($("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val());
				if (!reg.test(item)) {
					if(!isStringNull(item)){
						item = item + "," + $("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val();
					}else{
						item = $("input[id=ACTIVITY_CODE"+i+"]",$("#dms_table",container)).val();
					}
				}
			}
		});
		// 维修配件
		$.each(repairPart, function(i, j) {
			if (!isStringNull(j.ACTIVITY_CODE)) {
				var reg = new RegExp(j.ACTIVITY_CODE);
				if (!reg.test(item)) {
					if(!isStringNull(item)){
						item = item + "," + j.ACTIVITY_CODE;
					}else{
						item = j.ACTIVITY_CODE;
					}
				}
			}
		});
		$.each(addItem, function(i, j) {
			if (!isStringNull(j.ACTIVITY_CODE)) {
				var reg = new RegExp(j.ACTIVITY_CODE);
				if (!reg.test(item)) {
					if(!isStringNull(item)){
						item = item + "," + j.ACTIVITY_CODE;
					}else{
						item = j.ACTIVITY_CODE;
					}
				}
			}
		});
		return item;
	}

	var HaveOtherItem = function(repairItem, repairPart) {
		$.each(repairItem, function(i, j) {
			if(j.rowKey=='A'||j.rowKey=='U'){
				if (isStringNull(j.ACTIVITY_CODE)) {
					return true;
				}
			}
		});
		return false;
	}

	var HaveOtherPart = function(repairPart) {
		$.each(repairItem, function(i, j) {
			if (isStringNull(j.ACTIVITY_CODE)) {
				return true;
			}
		});
		return false;
	}

	var CountActivity = function(repairItem, repairPart) {
		var item = GetActivityCodes(repairItem, repairPart);
		var arr = item.split(',');
		var count = arr.length;
		return count;
	}

	var CountOemActivity = function(repairItem, repairPart) {
		var item = GetActivityCodes(repairItem, repairPart);
		var count = 0;
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()[""] + "",
			type : 'GET',
			data : {
				'activityCode' : item
			},
			async : false,
			sucessCallBack : function(data) {
				count = data;
			}
		});
	}

	var GetActivityCodes = function(repairItem, repairPart) {
		var item = '';
		// 维修项目
		$.each(repairItem, function(i, j) {
			if($("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='A'||$("input[id=rowKey"+i+"]",$("#dms_table",container)).val()=='U'){
				if (!isStringNull(j.ACTIVITY_CODE)) {
					var reg = new RegExp(j.ACTIVITY_CODE);
					if (!reg.test(item)) {
						item = item + "," + j.ACTIVITY_CODE;
					}
				}
			}
		});
		// 维修配件
		$.each(repairPart, function(i, j) {
			if(j.rowKey=='A'||j.rowKey=='U'){
				if (!isStringNull(j.ACTIVITY_CODE)) {
					var reg = new RegExp(j.ACTIVITY_CODE);
					if (!reg.test(item)) {
						item = item + "," + j.ACTIVITY_CODE;
					}
				}
			}
		});
		return item;
	}

	var CheckZhongDuanGuiFan = function(returnResult) {

	}

	var checkPaiGongGuiFan = function(repairItem) {
		return CheckLabourPaiGong(repairItem);
	}

	var CheckLabourPaiGong = function(repairItem) {
		var AllWorkTimes = 0;
		var assignHour = 0;
		var minHour = 0;
		var maxHour = 0;
		$.each(repairItem,
				function(i, j) {
			if(j.rowKey=='A'||j.rowKey=='U'){
				// 维修项目派工最大、最小比率
				AllWorkTimes = AllWorkTimes
				+ parseFloat(j.ASSIGN_LABOUR_HOUR);
				if (!isStringNull(dmsCommon.getSystemParamInfo("8040",
				"8040"))
				&& !isStringNull(dmsCommon.getSystemParamInfo(
						"8041", "8041"))
						&& parseFloat(dmsCommon.getSystemParamInfo("8041",
						"8041")) > 0
						&& parseFloat(dmsCommon.getSystemParamInfo("8040",
						"8040")) > 0) {
					assignHour = j.ASSIGN_LABOUR_HOUR;
					minHour = parseFloat(j.OEM_LABOUR_HOUR)
					* parseFloat(dmsCommon.getSystemParamInfo(
							"8040", "8040"));
					maxHour = parseFloat(j.OEM_LABOUR_HOUR)
					* parseFloat(dmsCommon.getSystemParamInfo(
							"8041", "8041"));
					// 解决浮点计算不精确的问题
					if (assignHour - minHour <= -0.01) {
						dmsCommon.tip({
							status : "warning",
							msg : "维修项目 " + j.LABOUR_CODE + " 派工工时低于下限"
						});
						return false;
					} else if (assignHour - maxHour >= 0.01) {
						dmsCommon.tip({
							status : "warning",
							msg : "维修项目 " + j.LABOUR_CODE + " 派工工时超过上限"
						});
						return false;
					}
				}
			}
			
				});
		return true;
	}

	// 加载维修类型下拉框
	var initRepairType = function(orderType, container) {
		var index = dmsCommon.getSystemParamInfo("1413", "1413");// 前台开关查询
		var selectData = new Array();
		if (parseInt(index) == 12781001) {
			if (!isStringNull($("#ownerNo", container).val())
					&& ($("#ownerNo", container).val() == '888888888888'
						|| $("#ownerNo", container).val() == '999999999999')) {
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531004) {// 索赔
				selectData.push({
					id : "SCBY",
					name : "首次保养"
				});
				selectData.push({
					id : "BXIU",
					name : "保修"
				});
				selectData.push({
					id : "SHYX",
					name : "善意维修"
				});
				selectData.push({
					id : "SBWS",
					name : "三包维修"
				});
				selectData.push({
					id : "YXYX",
					name : "营销活动"
				});
				selectData.push({
					id : "FUWU",
					name : "服务活动"
				});
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531001) {// 自费
				selectData.push({
					id : "CGBY",
					name : "常规保养"
				});
				selectData.push({
					id : "PTWX",
					name : "普通维修"
				});
				selectData.push({
					id : "NBXL",
					name : "内部修理"
				});
				selectData.push({
					id : "NFWX",
					name : "内部返工维修"
				});
				selectData.push({
					id : "WFWX",
					name : "外部返工维修"
				});
				selectData.push({
					id : "BJPQ",
					name : "钣金喷漆"
				});
				selectData.push({
					id : "XCZH",
					name : "精品装潢"
				});
				selectData.push({
					id : "ZDHD",
					name : "自店活动"
				});
				selectData.push({
					id : "QITA",
					name : "其他"
				});
			}
		} else {
			if (!isStringNull($("#ownerNo", container).val())
					&& ($("#ownerNo", container).val() == '888888888888'
						|| $("#ownerNo", container).val() == '999999999999')) {
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531004) {// 索赔
				selectData.push({
					id : "PTWX",
					name : "普通维修"
				});
				selectData.push({
					id : "BJWX",
					name : "钣金维修"
				});
				selectData.push({
					id : "PQWX",
					name : "喷漆维修"
				});
				selectData.push({
					id : "SCBY",
					name : "首次保养"
				});
				selectData.push({
					id : "XCZH",
					name : "精品装潢"
				});
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			}
		}
		dmsDict.refreshSelectByData($("#repairType", container), selectData,
				"id", "name");
	}
	
	// 加载维修类型下拉框
	var initRepairType3 = function(orderType) {
		var index = dmsCommon.getSystemParamInfo("1413", "1413");// 前台开关查询
		var selectData = new Array();
		if (parseInt(index) == 12781001) {
			if (!isStringNull($("#ownerNo", getElementContext()).val())
					&& ($("#ownerNo", getElementContext()).val() == '888888888888'
						|| $("#ownerNo", getElementContext()).val() == '999999999999')) {
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531004) {// 索赔
				selectData.push({
					id : "SCBY",
					name : "首次保养"
				});
				selectData.push({
					id : "BXIU",
					name : "保修"
				});
				selectData.push({
					id : "SHYX",
					name : "善意维修"
				});
				selectData.push({
					id : "SBWS",
					name : "三包维修"
				});
				selectData.push({
					id : "YXYX",
					name : "营销活动"
				});
				selectData.push({
					id : "FUWU",
					name : "服务活动"
				});
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531001) {// 自费
				selectData.push({
					id : "CGBY",
					name : "常规保养"
				});
				selectData.push({
					id : "PTWX",
					name : "普通维修"
				});
				selectData.push({
					id : "NBXL",
					name : "内部修理"
				});
				selectData.push({
					id : "NFWX",
					name : "内部返工维修"
				});
				selectData.push({
					id : "WFWX",
					name : "外部返工维修"
				});
				selectData.push({
					id : "BJPQ",
					name : "钣金喷漆"
				});
				selectData.push({
					id : "XCZH",
					name : "精品装潢"
				});
				selectData.push({
					id : "ZDHD",
					name : "自店活动"
				});
				selectData.push({
					id : "QITA",
					name : "其他"
				});
			}
		} else {
			if (!isStringNull($("#ownerNo", getElementContext()).val())
					&& ($("#ownerNo", getElementContext()).val() == '888888888888'
						|| $("#ownerNo", getElementContext()).val() == '999999999999')) {
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531004) {// 索赔
				selectData.push({
					id : "PTWX",
					name : "普通维修"
				});
				selectData.push({
					id : "BJWX",
					name : "钣金维修"
				});
				selectData.push({
					id : "PQWX",
					name : "喷漆维修"
				});
				selectData.push({
					id : "SCBY",
					name : "首次保养"
				});
				selectData.push({
					id : "XCZH",
					name : "精品装潢"
				});
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			}
		}
		dmsDict.refreshSelectByData($("#repairType", getElementContext()), selectData,
				"id", "name");
	}
	
	var initRepairType0 = function(orderType, container){
		var index = dmsCommon.getSystemParamInfo("1413", "1413");// 前台开关查询
		var selectData = new Array();
		if (parseInt(index) == 12781001) {
			if (!isStringNull($("#ownerNo", container).val())
					&& $("#ownerNo", container).val() == '888888888888') {
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531004) {// 索赔
				selectData.push({
					id : "SCBY",
					name : "首次保养"
				});
				selectData.push({
					id : "BXIU",
					name : "保修"
				});
				selectData.push({
					id : "SHYX",
					name : "善意维修"
				});
				selectData.push({
					id : "SBWS",
					name : "三包维修"
				});
				selectData.push({
					id : "YXYX",
					name : "营销活动"
				});
				selectData.push({
					id : "FUWU",
					name : "服务活动"
				});
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531001) {// 自费
				selectData.push({
					id : "CGBY",
					name : "常规保养"
				});
				selectData.push({
					id : "PTWX",
					name : "普通维修"
				});
				selectData.push({
					id : "NBXL",
					name : "内部修理"
				});
				selectData.push({
					id : "NFWX",
					name : "内部返工维修"
				});
				selectData.push({
					id : "WFWX",
					name : "外部返工维修"
				});
				selectData.push({
					id : "BJPQ",
					name : "钣金喷漆"
				});
				selectData.push({
					id : "XCZH",
					name : "精品装潢"
				});
				selectData.push({
					id : "ZDHD",
					name : "自店活动"
				});
				selectData.push({
					id : "QITA",
					name : "其他"
				});
			}
		} else {
			if (!isStringNull($("#ownerNo", container).val())
					&& $("#ownerNo", container).val() == '888888888888') {
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			} else if (!isStringNull(orderType)
					&& parseInt(orderType) == 12531004) {// 索赔
				selectData.push({
					id : "PTWX",
					name : "普通维修"
				});
				selectData.push({
					id : "BJWX",
					name : "钣金维修"
				});
				selectData.push({
					id : "PQWX",
					name : "喷漆维修"
				});
				selectData.push({
					id : "SCBY",
					name : "首次保养"
				});
				selectData.push({
					id : "XCZH",
					name : "精品装潢"
				});
				selectData.push({
					id : "SQWX",
					name : "PDI检查"
				});
			}
		}
		dmsDict.refreshSelectByData($("select[id^='REPAIR_TYPE_CODE']", $("#dms_table tr",getElementContext())), selectData,
				"id", "name");
	}
	
	var discountModeItem = new Array();//用来储存授权用户的优惠折扣
	
	/**
	 * 将授权用户的优惠折扣集合通过登录校验后直接返回给前台.
	 * 这样就不用再写个请求到后台去查询.
	 */
	var findDiscountModeItem = function(item){
		discountModeItem = item;
	}
	
	/**
	 * 获取优惠折扣集合
	 */
	var getDiscountModeItem = function(){
		return discountModeItem;
	}
	
	/**
	 * 折扣率
	 * src   表格的id
	 * rate  折扣率控件的id
	 * container container   
	 */
	var chooseRate = function(src,rate,container){
		if(parseFloat($("#"+rate,container).val())>1||parseFloat($("#"+rate,container).val())<0){
			dmsCommon.tip({status : "warning",msg : "折扣率为0.00-1.00之间的数值,请重新输入!"});
			$("#"+rate,container).setDmsValue($("#rates",container).val());
		}else{
			$("#rates",container).setDmsValue($("#"+rate,container).val());
			if($("#discountMode",container).val()!="Y"){//表示不是授权过来的
				if(src=='dms_table'&&dmsCommon.getBusinessPurview("5").LABOUR_AMOUNT_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_part'&&dmsCommon.getBusinessPurview("5").REPAIR_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_subjoinItem'&&dmsCommon.getBusinessPurview("5").ADD_ITEM_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_sales'&&dmsCommon.getBusinessPurview("5").SALES_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else{
					chooseRateAbout(src,rate,container);
				}
			}else{//表示此时有优惠折扣授权
				if(src=='dms_table'&&discountModeItem.LABOUR_AMOUNT_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_part'&&discountModeItem.REPAIR_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_subjoinItem'&&discountModeItem.ADD_ITEM_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_sales'&&discountModeItem.SALES_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else{
					chooseRateAbout(src,rate,container);
				}
			}
		}
	}
	
	//此方法用来修改折扣率
	var chooseRateAbout = function(src,rate,container){
		var item = $("#"+src, container).dmsTable().getRowDataByIndex();
		var flag = true;
		$.each(item,function(i,j){
			if($("input[data-index="+i+"]",container).is(":checked")&&$("#DISCOUNT"+i,$("#"+src, container)).attr('disabled')!='disabled'){
				if($("input[id='rowKey"+i+"']",$("#"+src,container)).val()=='S'){//表示从数据库查询的数据,需要修改状态
					$("input[id=rowKey"+i+"]",$("#"+src,container)).val("U");
				}
				if($("#DISCOUNT"+i,$("#"+src, container)).attr('readonly')=='readonly'){
				}else{
					$("#DISCOUNT"+i,$("#"+src, container)).setDmsValue($("#"+rate,container).val());
					if(src=='dms_table'){
						var labourAmount = Number($("input[id='STD_LABOUR_HOUR"+i+"']",$("#"+src, container)).val()) * Number($("input[id='LABOUR_PRICE"+i+"']",$("#"+src, container)).val());
						var receiveAmount = Number($("input[id='STD_LABOUR_HOUR"+i+"']",$("#"+src, container)).val()) * Number($("input[id='LABOUR_PRICE"+i+"']",$("#"+src, container)).val()) * Number($("input[id='DISCOUNT"+i+"']",$("#"+src, container)).val());
						$("#"+src, container).dmsTable().updateRowByIndex(i,{DISCOUNT_AMOUNT:labourAmount-receiveAmount,RECEIVE_AMOUNT:receiveAmount});
					}else if(src=='dms_part'){
						var labourAmount = Number($("input[id='PART_QUANTITY"+i+"']",$("#dms_part",container)).val()) * Number($("input[id='PART_SALES_PRICE"+i+"']",$("#dms_part",container)).val());
						var receiveAmount = Number($("input[id='PART_QUANTITY"+i+"']",$("#dms_part",container)).val()) * Number($("input[id='PART_SALES_PRICE"+i+"']",$("#dms_part",container)).val()) * Number($("input[id='DISCOUNT"+i+"']",$("#dms_part",container)).val());
						$("#dms_part",container).dmsTable().updateRowByIndex(i,{DISCOUNT_AMOUNT:labourAmount-receiveAmount,RECEIVE_AMOUNT:receiveAmount});
					}else if(src=='dms_subjoinItem'){
						var labourAmount = Number($("input[id='ADD_ITEM_PRICE"+i+"']",$("#dms_subjoinItem",container)).val());
						var receiveAmount = Number($("input[id='ADD_ITEM_PRICE"+i+"']",$("#dms_subjoinItem",container)).val()) * Number($("input[id='DISCOUNT"+i+"']",$("#dms_subjoinItem",container)).val());
						$("#dms_subjoinItem",container).dmsTable().updateRowByIndex(i,{DISCOUNT_AMOUNT:labourAmount-receiveAmount,ADD_ITEM_AMOUNT:receiveAmount});
					}
				}
			}
			flag = false;
		});
		if(flag){
			dmsCommon.tip({status : "warning",msg : "请选择需要刷新的列!"});			
		}
	}
	
	var chooseRate2 = function(src,rate,container){
		if(parseFloat($("#"+rate,container).val())>1||parseFloat($("#"+rate,container).val())<0){
			dmsCommon.tip({status : "warning",msg : "折扣率为0.00-1.00之间的数值,请重新输入!"});	
			$("#"+rate,container).setDmsValue($("#rates",container).val());
		}else{
			$("#rates",container).setDmsValue($("#"+rate,container).val());
			if($("#discountMode",container).val()!="Y"){//表示不是授权过来的
				if(src=='dms_table'&&dmsCommon.getBusinessPurview("5").LABOUR_AMOUNT_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_part'&&dmsCommon.getBusinessPurview("5").REPAIR_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_subjoinItem'&&dmsCommon.getBusinessPurview("5").ADD_ITEM_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_sales'&&dmsCommon.getBusinessPurview("5").SALES_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else{
					chooseRateAbout2(src,rate,container);
				}
			}else{
				if(src=='dms_table'&&discountModeItem.LABOUR_AMOUNT_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_part'&&discountModeItem.REPAIR_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_subjoinItem'&&discountModeItem.ADD_ITEM_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else if(src=='dms_sales'&&discountModeItem.SALES_PART_DISCOUNT>parseFloat($("#"+rate,container).val())){
					dmsCommon.tip({status : "warning",msg : "该字段超出最小范围!"});
				}else{
					chooseRateAbout2(src,rate,container);
				}
			}
		}
	}
	
	var chooseRateAbout2 = function(src,rate,container){
		var item = $("#"+src, container).dmsTable().getRowDataByIndex();
		var flag = true;
		$.each(item,function(i,j){
			if($("input[data-index]",$("#"+src,container).find("tr").eq(i+1)).is(":checked")){
				if($("input[id^='DISCOUNT']:eq(1)",$("#"+src, container).find("tr").eq(i+1)).attr('disabled')!='disabled'){
					if($("input[id^='rowKey']",$("#"+src,container).find("tr").eq(i+1)).val()=='S'){//表示从数据库查询的数据,需要修改状态
						$("input[id^='rowKey']",$("#"+src,container).find("tr").eq(i+1)).val("U");
					}
					if($("input[id^='DISCOUNT']:eq(1)",$("#"+src, container).find("tr").eq(i+1)).attr('readonly')=='readonly'){
					}else{
						$("input[id^='DISCOUNT']:eq(1)",$("#"+src, container).find("tr").eq(i+1)).setDmsValue($("#"+rate,container).val());
						if(src=='dms_table'){
							var labourAmount = Number($("input[id^='STD_LABOUR_HOUR']",$("#"+src, container).find("tr").eq(i+1)).val()) * Number($("input[id^='LABOUR_PRICE']",$("#"+src, container).find("tr").eq(i+1)).val());
							var receiveAmount = Number($("input[id^='STD_LABOUR_HOUR']",$("#"+src, container).find("tr").eq(i+1)).val()) * Number($("input[id^='LABOUR_PRICE']",$("#"+src, container).find("tr").eq(i+1)).val()) * Number($("input[id^='DISCOUNT']:eq(1)",$("#"+src, container).find("tr").eq(i+1)).val());
							$("#"+src, container).dmsTable().updateRowByIndex(i,{DISCOUNT_AMOUNT:labourAmount-receiveAmount,RECEIVE_AMOUNT:receiveAmount});
						}else if(src=='dms_part'){
							var labourAmount = Number($("input[id='PART_QUANTITY"+i+"']",$("#dms_part",container)).val()) * Number($("input[id='PART_SALES_PRICE"+i+"']",$("#dms_part",container)).val());
							var receiveAmount = Number($("input[id='PART_QUANTITY"+i+"']",$("#dms_part",container)).val()) * Number($("input[id='PART_SALES_PRICE"+i+"']",$("#dms_part",container)).val()) * Number($("input[id^='DISCOUNT']:eq(1)",$("#"+src, container).find("tr").eq(i+1)).val());
							$("#dms_part",container).dmsTable().updateRowByIndex(i,{DISCOUNT_AMOUNT:labourAmount-receiveAmount,RECEIVE_AMOUNT:receiveAmount});
						}else if(src=='dms_subjoinItem'){
							var labourAmount = Number($("input[id='ADD_ITEM_PRICE"+i+"']",$("#dms_subjoinItem",container)).val());
							var receiveAmount = Number($("input[id='ADD_ITEM_PRICE"+i+"']",$("#dms_subjoinItem",container)).val()) * Number($("input[id^='DISCOUNT']:eq(1)",$("#"+src, container).find("tr").eq(i+1)).val());
							$("#dms_subjoinItem",container).dmsTable().updateRowByIndex(i,{DISCOUNT_AMOUNT:labourAmount-receiveAmount,ADD_ITEM_AMOUNT:receiveAmount});
						}
					}
				}
				flag = false;
			}
		});
		if(flag){
			dmsCommon.tip({status : "warning",msg : "请选择需要刷新的列!"});			
		}
	
	}

	
	/**
	 * 收费类别刷新
	 * src1 收费类别的表格
	 * src2 需要刷新的表格
	 */
	var chooseChangeType = function(src1,src2,container){
		var t1 = $("#"+src1, container).dmsTable().getFirstSelection();
		var item = $("#"+src2, getElementContext()).dmsTable().getRowDataByIndex();
		var flag = true;
		$.each(item,function(i,j){
			if($("input[data-index='"+i+"']",$("#"+src2, getElementContext())).is(":checked")){
				if($("input[id='rowKey"+i+"']",$("#"+src2,getElementContext())).val()=='S'){//表示从数据库查询的数据,需要修改状态
					$("input[id=rowKey"+i+"]",$("#"+src2,getElementContext())).val("U");
				}
				$("select[name='MANAGE_SORT_CODE"+i+"']",$("#"+src2, getElementContext())).setDmsValue(t1.MANAGE_SORT_CODE);
				flag = false;
			}
		});
		if(flag){
			dmsCommon.tip({status : "warning",msg : "请选择需要刷新的列!"});			
		}else{
			$("a[data-dismiss='modal']",container).click();
		}
	}
	
	var chooseChangeType2 = function(src1,src2,container){
		var t1 = $("#"+src1, container).dmsTable().getFirstSelection();
		var item = $("#"+src2, getElementContext()).dmsTable().getRowDataByIndex();
		var flag = true;
		$.each(item,function(i,j){
			if($("input[data-index]",$("#"+src2, getElementContext()).find("tr").eq(i+1)).is(':checked')){
				if($("input[id^='rowKey']",$("#"+src2,getElementContext()).find("tr").eq(i+1)).val()=='S'){//表示从数据库查询的数据,需要修改状态
					$("input[id^='rowKey']",$("#"+src2,getElementContext()).find("tr").eq(i+1)).val("U");
				}
				$("select[name^='MANAGE_SORT_CODE']",$("#"+src2,getElementContext()).find("tr").eq(i+1)).setDmsValue(t1.MANAGE_SORT_CODE);
				flag = false;
			}
		});
		if(flag){
			dmsCommon.tip({status : "warning",msg : "请选择需要刷新的列!"});			
		}else{
			$("a[data-dismiss='modal']",container).click();
		}
	}

	// 加载维修项目下拉框数据
	var initLabourData = function() {
		var getTableRows = $("#labourList", getElementContext()).dmsTable()
				.getTableRows();
		var repairPro = $("#labourList", getElementContext()).dmsTable()
				.getRowDataByIndex();
		var selectData = new Array();
		for (var i = 0; i < getTableRows; i++) {
			selectData.push({
				id : repairPro[i].labourCode,
				name : repairPro[i].labourName
			});
		}
		return selectData;
	};
	// 费用结算为查询到数据不可编辑
	var addDisabled = function(container) {
		$(".disDiv a", container).attr("disabled", "disabled");
		// $("#remark",container).setElementReadOnly();
		$("#remark", container).attr("disabled", "disabled");
		$("#discountModeCode", container).setElementReadOnly();
		return "";
	};

	// 费用结算查询到数据后可编辑
	var removeDisabled = function() {
		//
		$(".disDiv a", getElementContext()).removeAttr("disabled");
		$("#remark", getElementContext()).removeAttr("disabled");
		$("#discountModeCode", getElementContext()).removeElementReadOnly();
	};
	// 计算维修材料费
	var calRepairPartAmount = function(curPartAmount) {
		// 计算材料费
		var oldDisRepairPartAmount = $("#disRepairPartAmount",
				getElementContext()).val(); // 折后维修材料费（上次总和）
		var oldRepairPartAmount = $("#repairPartAmount", getElementContext())
				.val();// 维修材料费 （上次总和）
		// var partAmount=parseFloat($("#salesAmountShow",container).val());
		// //金额
		var partAmount = parseFloat(curPartAmount);
		if (oldDisRepairPartAmount == null || oldDisRepairPartAmount == "") {
			oldDisRepairPartAmount = 0;
		}
		if (oldRepairPartAmount == null || oldRepairPartAmount == "") {
			oldRepairPartAmount = 0;
		}
		var disRepairPartAmount = parseFloat(oldDisRepairPartAmount)
				+ partAmount;
		var repairPartAmount = parseFloat(oldRepairPartAmount) + partAmount;

		var map = {
			dis_repair_part_amount : disRepairPartAmount.toFixed(2),
			repair_part_amount : repairPartAmount.toFixed(2)
		};
		$("div[data-partAmount='true']", getElementContext()).initHtmlContent(
				map, false);
	};
	var appendRowInRolabour = function(repairPro, workOrderType, selectData,
			receiveMoney, i, labourPrice) {
		var workOrderRepairProFlag = true;
		var workOrderRepairPro = {};
		if ("12121003" == workOrderType) {
			workOrderRepairPro.chargePartitionName = "S";
			workOrderRepairProFlag = false;
		}
		workOrderRepairPro.assignLabourHour = repairPro[i].ASSIGN_LABOUR_HOUR;
		workOrderRepairPro.repairType = repairPro[i].REPAIR_TYPE_CODE;
		workOrderRepairPro.labourName = repairPro[i].LABOUR_NAME;
		workOrderRepairPro.labourCode = repairPro[i].LABOUR_CODE;
		workOrderRepairPro.stdHour = repairPro[i].STD_LABOUR_HOUR;
		workOrderRepairPro.workType = repairPro[i].WORKER_TYPE_CODE;
		workOrderRepairPro.modeGroup = repairPro[i].MODEL_LABOUR_CODE;
		workOrderRepairPro.localLabourCode = repairPro[i].LOCAL_LABOUR_CODE;
		workOrderRepairPro.localLabourName = repairPro[i].LOCAL_LABOUR_NAME;
		workOrderRepairPro.workHourSinglePrice = labourPrice;
		workOrderRepairPro.discountRate = discountMode;
		var workHourPriceF = parseFloat(repairPro[i].STD_LABOUR_HOUR)
				* parseFloat(labourPrice);
		workOrderRepairPro.workHourPrice = workHourPriceF; // 工时费
		selectData.push({
			id : repairPro[i].LABOUR_CODE,
			name : repairPro[i].LABOUR_NAME
		});
		var discountMoneyF = workHourPriceF
				* (parseFloat(1) - parseFloat(discountMode));
		workOrderRepairPro.discountMoney = discountMoneyF.toFixed(2);// 优惠金额
		if (workOrderRepairProFlag) {
			var receiveMoneyF = workHourPriceF - discountMoneyF
			receiveMoney = receiveMoneyF.toFixed(2);
			workOrderRepairPro.receiveMoney = receiveMoney;
		} else {
			workOrderRepairPro.receiveMoney = receiveMoney.toFixed(2);
		}

		var appRowTr = $("#labourList", getElementContext()).dmsTable()
				.appendRow(workOrderRepairPro);
		var tableRow = $("#labourList", getElementContext()).dmsTable()
				.getTableRows();
		if ("12121003" == workOrderType) {

		} else {
			var roTypeSet = $("#roTypeSet", getElementContext()).val();
			if (roTypeSet == '10131001') {
				dmsDict.refreshSelectByFunction($(
						"select[id^=chargePartitionName]", appRowTr), function(
						selectObj) {
					$(selectObj).find("option[value='S']").remove();
				});
			}
		}
		$("select[id^=chargePartitionName]", appRowTr).bindChange(
				function(obj) {

					var index = $(obj).attr("id").substr(
							$(obj).attr("id").length - 1);
					if ($(obj).val() == "S" || $(obj).val() == "Z") {
						$("input[name^=receiveMoney]", $(obj).closest("tr"))
								.valChange(0);
						$(
								"span",
								$("input[name^=receiveMoney]",
										$(obj).closest("tr")).parent("td"))
								.text(0);
					}
				});

		// 赠送索赔下拉框
		if (workOrderRepairPro.chargePartitionName == "S") {
			$("#chargePartitionName" + (tableRow - 1), getElementContext())
					.attr("disabled", true);
		} else {
			$("#chargePartitionName" + (tableRow - 1), getElementContext())
					.removeAttr("disabled");
			$("#chargePartitionName" + (tableRow - 1) + " option[value='S']",
					getElementContext()).remove();
		}
		if (discountMode > 0) {
			var minRate = $("#minRate", container).val();
			$("#discountRate" + (tableRow - 1), getElementContext()).attr(
					"min", minRate);
		}
	};
	/**
	 * 结算（结算圆整方式） param val 值 settlementType 结算圆整方式 （四舍五入、只入不舍、只舍不如） precision
	 * 结算精度 （元、角、分）
	 */
	var settlementPre = function(val) {
		var settlementType = $("#settlementTypeHidden", getElementContext())
				.val();
		var precision = $("#accuracy", getElementContext()).val();
		var resultVal = "";
		val = parseFloat(val);
		if (precision == "10121001") { // 元
			if (settlementType == "10141001") { // 四舍五入 （整数）
				resultVal = parseFloat(val).toFixed(0);
			} else if (settlementType == "10141002") { // 只舍不如 (整数)
				resultVal = parseInt(val);
			} else if (settlementType == "10141003") { // 只入不舍 (保留整数位)
				resultVal = Math.ceil(val);
			}
		} else if (precision == "10121002") { // 角
			if (settlementType == "10141001") { // 四舍五入
				resultVal = val.toFixed(1);
			} else if (settlementType == "10141002") { // 只舍不如
				var tag = '.';
				var str = val + "";
				if (str.indexOf(tag) == -1) {
					resultVal = val.toFixed(1);
				} else {
					resultVal = parseFloat(str.substring(0, str
							.lastIndexOf('.') + 2));
				}
			} else if (settlementType == "10141003") { // 只入不舍

				var bb = val + "";
				var dian = bb.indexOf('.');
				if (dian == -1) {
					resultVal = val.toFixed(1);
				} else {
					var cc = bb.substring(dian + 1, bb.length);
					if (cc.length >= 2) {
						bb = bb.substring(0, dian + 2);
						resultVal = parseFloat(bb) + parseFloat(0.1);
					} else {
						resultVal = val.toFixed(1);
					}
				}
			}
		} else if (precision == "10121003") { // 分
			resultVal = val.toFixed(2);
		}
		return resultVal;
	};
	var countDisAmount = function() {
		var tab = $("#labourList tbody");
		var rows = $("tr", tab).length;
		var labourAmount = 0;
		var disLabourAmount = 0;
		var workHourPriceTrueNum = $("#labourList", getElementContext())
				.dmsTable().getVisiableCellNumber(10);
		var receiveMoneyTrueNum = $("#labourList", getElementContext())
				.dmsTable().getVisiableCellNumber(13);
		for (var i = 0; i < rows; i++) {
			labourAmount = parseFloat(labourAmount)
					+ parseFloat($(
							"tr:eq(" + i + ") td:eq(" + workHourPriceTrueNum
									+ ") input[id^=workHourPrice]", tab).val());
			disLabourAmount = parseFloat(disLabourAmount)
					+ parseFloat($(
							"tr:eq(" + i + ") td:eq(" + receiveMoneyTrueNum
									+ ") input[id^=receiveMoney]", tab).val());
		}
		var map = {
			labour_amount : labourAmount.toFixed(2),
			dis_labour_amount : disLabourAmount.toFixed(2)
		};
		$("div[data-repairAmount='true']", getElementContext())
				.initHtmlContent(map, false);
	};

	/**
	 * 根据品牌车型组代码查询车型代码集合
	 */
	var findModelLabourCodeAndModelCode = function() {
		var items = [];
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["repair"]
					+ "/basedata/repairProject/findModelForInput",
			type : 'GET',
			async : false,
			sucessCallBack : function(data) {
				items = data;
			}
		});
		return items;
	}

	/**
	 * 通过车型代码查询品牌车型组代码 code : 车型代码
	 */
	var findModelLabourCodeByModel = function(code, container) {
		var reg = new RegExp(code);
		$.each(findModelLabourCodeAndModelCode(), function(name, value) {
			if (reg.test(value)) {
				$("#modelLabourCode", container).val(name);
			}
		});
	}
	
	var findModelLabourCodeByModel2 = function(code) {
		var ret = "";
		var reg = new RegExp(code);
		$.each(findModelLabourCodeAndModelCode(), function(name, value) {
			if (reg.test(value)&&(code!="QT")) {
				ret = name;
			}
		});
		return ret;
	}
	
	/**
	 * 选择车牌号后按钮可编辑
	 */
	var btnStatusChangeForLicense = function(container){
//		$("#license",container).attr("readonly","readonly");//车牌号输入框
//		$("#licenseBtn",container).attr("disabled","disabled");//车牌号按钮
//		$("#fsalesDate",container).attr("disabled","disabled");//开票日期
//		$("#labourAddBtn",container).removeAttr('disabled');//维修项目新增
//		$("#partAddBtn",container).removeAttr('disabled');//维修项目新增
//		$("#accessoryAddBtn",container).removeAttr('disabled');//维修项目新增
//		$("#flabourPrice",container).removeAttr('disabled');//工时单价
//		$("#fendTimeSupposed",container).removeAttr('disabled');//预交车时间
//		$("#frepairType",container).removeAttr('disabled');//维修类型
//		$("#inMileage",container).removeAttr('readonly');//进厂行驶里程
//		$("#outMileage",container).removeAttr('readonly');//出厂行驶里程
//		$("#nextMaintainMileage",container).removeAttr('readonly');//下次保养里程
//		$("#nextMaintainDate",container).removeAttr('readonly');//预计下次保养日期
//		$("#FChangeMileage",container).removeAttr('readonly');//换表里程
//		$("#deliverer",container).removeAttr('readonly');//送修人姓名
//		$("#fdelivvererGender",container).removeAttr('disabled');//送修人性别
//		$("#fcolors",container).removeAttr('disabled');//颜色
//		$("#flicenseDate",container).removeAttr('disabled');//上牌日期
//		$("#freCommendCustomer",container).removeAttr('disabled');//推荐单位
//		$("#freCommendEmp",container).removeAttr('disabled');//推荐人
//		$("#foilLevel",container).removeAttr('disabled');//进厂油位
//		$("#ftroubleOccurDate",container).removeAttr('disabled');//故障发生日期
//		$("#remark1",container).removeAttr('readonly');//备注1
//		$("#remark",container).removeAttr('readonly');//备注
//		$("#delivererPhone",container).removeAttr('readonly');//送修人电话
//		$("#delivererMobile",container).removeAttr('readonly');//送修人手机
//		$("#ftraceTime",container).removeAttr('disabled');//三日电访时间
//		$("#memCustomerDesc",container).removeAttr('readonly');//送修问题
//		$("#troubleDesc",container).removeAttr('readonly');//检查结果	
	}
	
	/**
	 * 设置估价信息
	 */
	var setAmount = function(){
		var repairItem = $("#dms_table", getElementContext()).dmsTable()
			.getRowDataByIndex();
		var repairPart = $("#dms_part", getElementContext()).dmsTable()
			.getRowDataByIndex();
		var addItem = $("#dms_subjoinItem", getElementContext()).dmsTable()
			.getRowDataByIndex();
		var gsf = 0.00;
		var wxclf = 0.00;
		var xsclf = 0.00;
		var fjxmf = 0.00;
		var flglf = 0.00;
		var wxje = 0.00;
		if(repairItem!=null){
			$.each(repairItem,function(i,j){
				gsf += parseFloat(nullToZero(j.LABOUR_AMOUNT));
			});
		}
		if(repairPart!=null){
			$.each(repairPart,function(i,j){
				wxclf += parseFloat(nullToZero(j.RECEIVE_AMOUNT));
			});
		}
		if(addItem!=null){
			$.each(addItem,function(i,j){
				fjxmf += parseFloat(nullToZero(j.ADD_ITEM_AMOUNT));
			});
		}
		wxje = gsf+wxclf+xsclf+fjxmf+flglf;
		$("#labourAmount",getElementContext()).setDmsValue(gsf);
		$("#repairPartAmount",getElementContext()).setDmsValue(wxclf);
		$("#salePartAmount",getElementContext()).setDmsValue(xsclf);
		$("#addItemAmount",getElementContext()).setDmsValue(fjxmf);
	}

	/**
	 * 车牌号回车事件
	 */
	var licenseKeyUp = function(obj, container, license, vin) {
	    var CurDateTime = null;
		$.ajax({type:"GET",async:false,url:"/",complete:function(x){
			CurDateTime = new Date(x.getResponseHeader("Date"));
		 }});
		dmsCommon
		.ajaxRestRequest({
			url : dmsCommon.getDmsPath()['repair']
					+ "/basedata/queryByLinsence/license3",
			data : {
				'license' : license,
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(datas) {
				if(datas.length<=1){
					var data = {};
					if(datas.length==1){
						data = datas[0];
					}
					var roType = $("#roType", container).val();// 工单类型
					/*
					 * var FTempMILEAGE =
					 * $("#inMileage",getElementContext()).val();
					 */
					// 车主不是4S站 在本店库存表里能找到，没有做过购车费用开票 则不能做维修开单
					if (!isStringNull(data.OWNER_NO)
							&& data.OWNER_NO != '888888888888'
							&& data.OWNER_NO != '999999999999'
							&& !isStringNull(data.VIN)
							&& CheckVehicleInvoice(data.VIN)) {
						dmsCommon.tip({
							status : "warning",
							msg : "此车辆还没有做实销上报，不能开工单！"
						});
						return;
					}
					if (!isStringNull(data.VIN)
							&& CheckIsHaveAduitingOrder(data.VIN)) {
						dmsCommon.tip({
							status : "info",
							msg : "此车辆已存在“待审核”的索赔工单，不能再开索赔工单！"
						});
						if (parseInt(roType) == 12531004) {// 表示索赔工单类型
							return;
						}
					}
					if (parseInt($("#FIsNewVehicle", container).val()) == 1) {// 表示从VIN页面点击新增的车辆
						// 新建车辆也需要查看监控信息：车辆监控、预约单等信息 根据车牌号查询
						// 打开监控信息页面 if not MonitorVehicleRemind(fcdsVehicle)
						// then 3528
						$("#searchMonitor",container).click();								
					}
					if (datas.length > 0) {// 表示能查到数据
						$("#FIsLoadVehicle", container).setDmsValue("true");
						// 设置该车的换表里程和累计换表里程，方便计算
						var FChangeMileage = 0;
						var FToTalChangeMileage = data.TOTAL_CHANGE_MILEAGE;
						var fLastMaintenancedate = data.LAST_MAINTENANCE_DATE;
						var fLastRepairDate = data.LAST_MAINTAIN_DATE;
						var fLastRepairMileage = data.LAST_MAINTAIN_MILEAGE;
						var flastMaintenanceMileage = data.LAST_MAINTENANCE_MILEAGE;
						var fModifySaledate = false;
						if (parseInt(nullToZero(data.IS_SELF_COMPANY)) == 12781001
								&& data.SALES_DATE != null
								&& data.SALES_DATE != '') {
							fModifySaledate = true;
						}
						// 选择VIN号后，
						// 如果车牌号不为空 而且不是新建的车辆，那么去查询是否存在该车辆的在修工单。
						var aVinTmp = data.VIN;
						if (!isStringNull(aVinTmp)) {
							if (QueryROByLicense(aVinTmp)) {
								new Modal({
								    title: '操作提示',
								    content: '此车牌存在在修车辆，是否继续新建工单？',
								    width: 400,
								    onOk: function(){
										setVehicleInfo(data,
												false, false,
												false,container);
										// 根据车牌号查询工单的监控信息。
										$("#searchMonitor",container).click();
										if (datas.length > 0) {
											if (!isStringNull(data.TRACE_TIME)) {
												$("#traceTime",
														container)
														.setDmsValue(
																data.TRACE_TIME);
											} else if (data.IS_TRACE=='12781001'
													&& data.TRACE_TIME == "0") {
												$("#traceTime",
														container)
														.setDmsValue(
																11251004);
											}
										} else {
											if (data.IS_TRACE=='12781001'
													&& data.TRACE_TIME == "0") {
												$("#traceTime",
														container)
														.setDmsValue(
																11251004);
											}
										}
										var tt = dmsCommon
												.getSystemParamInfo(
														"1063",
														"1063");// 预交车时间为当前时间延迟xx小时
										var ttt = parseFloat(tt) * 60 * 1000;
										var tttt = Number(CurDateTime
												.getTime())
												+ Number(ttt);
										$("#endTimeSupposed",
												container)
												.setDmsValue(
														dateByType(
																tttt,
																"yyyy-MM-dd hh:mm:ss"));// 预交车时间
										nextMaintain(data.MILEAGE,container);// 计算预计下次保修

										btnStatusChangeForLicense(container);														
										
										$("#licenseSign",container).setDmsValue(CurDateTime);
									},
								    onCancel:function(){
										return;
										}
								 }).open();
								// 如果存在在修车辆，提示“此车牌存在在修车辆，是否继续新建工单？”
//								obj
//										.confirm(
//												'此车牌存在在修车辆，是否继续新建工单？',
//												function(confirmObj) {}, function(confirmObj) {});
							}else{
								setVehicleInfo(data,
										false, false,
										false,container);
								// 根据车牌号查询工单的监控信息。
								$("#searchMonitor",container).click();
								if (datas.length > 0) {
									if (!isStringNull(data.TRACE_TIME)) {
										$("#traceTime",
												container)
												.setDmsValue(
														data.TRACE_TIME);
									} else if (data.IS_TRACE=='12781001'
											&& data.TRACE_TIME == "0") {
										$("#traceTime",
												container)
												.setDmsValue(
														11251004);
									}
								} else {
									if (data.IS_TRACE=='12781001'
											&& data.TRACE_TIME == "0") {
										$("#traceTime",
												container)
												.setDmsValue(
														11251004);
									}
								}
								var tt = dmsCommon
								.getSystemParamInfo(
										"1063",
								"1063");// 预交车时间为当前时间延迟xx小时
								var ttt = parseFloat(tt) * 60 * 1000;
								var tttt = Number(CurDateTime
								.getTime())
								+ Number(ttt);
								$("#endTimeSupposed",
									container)
									.setDmsValue(
											dateByType(
													tttt,
													"yyyy-MM-dd hh:mm:ss"));// 预交车时间
								nextMaintain(data.MILEAGE,container);// 计算预计下次保修
								btnStatusChangeForLicense(container);	
								$("#licenseSign",container).setDmsValue(CurDateTime);
							}
						}
					} else {// 表示没查到数据
						// 针对跨店维修的车辆-召回活动，监控信息也要显示
						var defaultValue = dmsCommon.getSystemParamInfo(
								"3415", "3415");// 维修工单支持同步车主车辆
						if (parseInt(defaultValue) == 12781001) {
							obj
									.confirm(
											'该车辆信息不存在，是否需要同步总部信息?',
											function(confirmObj) {
												if (!isStringNull(license)
														&& license.length != 17) {
													dmsCommon
															.tip({
																status : "error",
																msg : "请在车牌号一栏输入准确的17位VIN码，按回车键从总部获取该车主车辆信息！"
															});
													return;
												}else{
													
													// SEDMS023
													// 根据license
													// 后台调用接口
													dmsCommon
													.ajaxRestRequest({
														url : dmsCommon
														.getDmsPath()['repair']
													+ "/order/repair/SEDMS023",
													data : {
														'license' : license
													},
													async : false,
													sucessCallBack : function(
															data2) {
														if (!isEmpty(data2)) {
															$(
																	"#FIsLoadVehicle",
																	container)
																	.setDmsValue(
																	"true");
															$(
																	"#lastMaintenancedate",
																	container)
																	.setDmsValue(
																			data2.LAST_MAINTENANCE_DATE);
															$(
																	"#FToTalChangeMileage",
																	container)
																	.setDmsValue(
																			data2.TOTAL_CHANGE_MILEAGE);
															$(
																	"#totalChangeMileage",
																	container)
																	.setDmsValue(
																			data2.TOTAL_CHANGE_MILEAGE);
															$(
																	"#lastRepairDate",
																	container)
																	.setDmsValue(
																			data2.LAST_MAINTAIN_DATE);
															$(
																	"#lastRepairMileage",
																	container)
																	.setDmsValue(
																			data2.LAST_MAINTAIN_MILEAGE);
															$(
																	"#lastMaintenanceMileage",
																	container)
																	.setDmsValue(
																			data2.LAST_MAINTENANCE_MILEAGE);
															/*
															 * if(parseInt(data2.IS_SELF_COMPANY)==12781001&&!isStringNull(data2.SALES_DATE)){ }
															 */
															// 选择VIN号后，
															// 如果车牌号不为空
															// 而且不是新建的车辆，那么去查询是否存在该车辆的在修工单。
															if (!isStringNull(data2.VIN)) {
																if (QueryROByLicense(aVinTmp)) {
																	// 如果存在在修车辆，提示“此车牌存在在修车辆，是否继续新建工单？”
																	obj
																	.confirm(
																			'此车牌存在在修车辆，是否继续新建工单？',
																			function(confirmObj) {
																				setVehicleInfo(data2,
																						false, false,
																						false,container);
																				// 如果该车有会员卡，则更换图标
																				QueryMemberCardExist(data2.VIN)
																				// 根据车牌号查询工单的监控信息。
																				$("#searchMonitor",container).click();
																				if (datas.length > 0) {
																					if (!isStringNull(data2.TRACE_TIME)) {
																						$("#traceTime",
																								container)
																								.setDmsValue(
																										data2.TRACE_TIME);
																					} else if (data2.IS_TRACE=='12781001'
																						&& data2.TRACE_TIME == "0") {
																						$("#traceTime",
																								container)
																								.setDmsValue(
																										11251004);
																					}
																				} else {
																					if (data2.IS_TRACE=='12781001'
																						&& data2.TRACE_TIME == "0") {
																						$("#traceTime",
																								container)
																								.setDmsValue(
																										11251004);
																					}
																				}
																				var tt = dmsCommon
																				.getSystemParamInfo(
																						"1063",
																				"1063");// 预交车时间为当前时间延迟xx小时
																				var ttt = parseFloat(tt) * 60 * 1000;
																				var tttt = Number(CurDateTime
																				.getTime())
																				+ Number(ttt);
																								$("#endTimeSupposed",
																										container)
																										.setDmsValue(
																												dateByType(
																														tttt,
																														"yyyy-MM-dd hh:mm:ss"));// 预交车时间
																				nextMaintain(data.MILEAGE,container);// 计算预计下次保修
																				
																				btnStatusChangeForLicense(container);														
																				
																				$("#licenseSign",container).setDmsValue(CurDateTime);
																			}, function(confirmObj) {
																				return;
																			});
																}else{
																	// 如果该车有会员卡，则更换图标
																	QueryMemberCardExist(data2.VIN)
																	setVehicleInfo(data2,
																			false, false,
																			false,container);
																	// 根据车牌号查询工单的监控信息。
																	$("#searchMonitor",container).click();
																	if (datas.length > 0) {
																		if (!isStringNull(data2.TRACE_TIME)) {
																			$("#traceTime",
																					container)
																					.setDmsValue(
																							data2.TRACE_TIME);
																		} else if (data2.IS_TRACE=='12781001'
																			&& data2.TRACE_TIME == "0") {
																			$("#traceTime",
																					container)
																					.setDmsValue(
																							11251004);
																		}
																	} else {
																		if (data2.IS_TRACE=='12781001'
																			&& data2.TRACE_TIME == "0") {
																			$("#traceTime",
																					container)
																					.setDmsValue(
																							11251004);
																		}
																	}
																	var tt = dmsCommon
																	.getSystemParamInfo(
																			"1063",
																	"1063");// 预交车时间为当前时间延迟xx小时
																	var ttt = parseFloat(tt) * 60 * 1000;
																	var tttt = Number(CurDateTime
																	.getTime())
																	+ Number(ttt);
																$("#endTimeSupposed",
																		container)
																		.setDmsValue(
																				dateByType(
																						tttt,
																						"yyyy-MM-dd hh:mm:ss"));// 预交车时间
																	nextMaintain(data.MILEAGE,container);// 计算预计下次保修
																	btnStatusChangeForLicense(container);	
																	$("#licenseSign",container).setDmsValue(CurDateTime);
																}
															}
														} else {
															dmsCommon
															.tip({
																status : "warning",
																msg : "该VIN在总部不存在，请核对输入的17位VIN码是否正确！"
															});
															return;
														}
														if (datas.length > 0) {
															if (!isStringNull(data2.TRACE_TIME)) {
																$("#traceTime",
																		container)
																		.setDmsValue(
																				data2.TRACE_TIME);
															} else if (data2.IS_TRACE=='12781001' && data2.TRACE_TIME == "0") {
																$("#traceTime",
																		container)
																		.setDmsValue(
																				11251004);
															}
														} else {
															if (data2.IS_TRACE=='12781001'
																&& data2.TRACE_TIME == "0") {
																$("#traceTime",
																		container)
																		.setDmsValue(
																				11251004);
															}
														}
														var tt = dmsCommon
														.getSystemParamInfo(
																"1063",
														"1063");// 预交车时间为当前时间延迟xx小时
														var ttt = parseFloat(tt) * 60 * 1000;
														var tttt = Number(CurDateTime
														.getTime())
														+ Number(ttt);
													$("#endTimeSupposed",
															container)
															.setDmsValue(
																	dateByType(
																			tttt,
																			"yyyy-MM-dd hh:mm:ss"));// 预交车时间
														nextMaintain(data.MILEAGE,container);// 计算预计下次保修
														
														btnStatusChangeForLicense(container);
														
														$("#licenseSign",container).setDmsValue(CurDateTime);
														
														
													}
													});
													
												}
												},
											function(confirmObj) {
												$("#licenseSign",container).setDmsValue("cancel");
											});
						}
					}
				}else{
					$("#licenseBtn",container).click();
				}
			}
		});
	}

	/**
	 * 预计下次保养日期,下次保养里程计算相关方法
	 */
	var nextMaintain = function(mileage,container) {
		var index = dmsCommon.getSystemParamInfo("1123", "1123");// 前台开关查询
		// 如果参数设置不计算则不处理.
		if (parseInt(index) == 12781002) {
			return;
		} else {
			var strTemp = '';// 给remark2赋值
			var sysdate = new Date();// 当前时间
			var i = 0;// 开关,预计下次保养日期距本工单最长天数
			var j = 0;// 开关,定期保养里程间隔
			i = dmsCommon.getSystemParamInfo("1064", "1064");// 前台开关查询
			j = dmsCommon.getSystemParamInfo("1072", "1072");// 前台开关查询
			// 日平均行驶里程
			$("#averageMileage", container).val(0);
			if ($("#FIsLoadVehicle", container).val() == 'true') {
				dmsCommon.ajaxRestRequest({
					url : dmsCommon.getDmsPath()['repair']
							+ "/order/repair/queryVehicleforactivity",
					data : {
						'vin' : $("#vin", container).val()
					},
					async : false,
					sucessCallBack : function(data) {
						$("#lastMaintenanceDate", container).setDmsValue(
								data.LAST_MAINTENANCE_DATE);
						$("#lastRepairDate", container).setDmsValue(
								data.LAST_MAINTAIN_DATE);
						$("#lastRepairMileage", container).setDmsValue(
								data.LAST_MAINTAIN_MILEAGE);
						$("#lastMaintenanceMileage", container).setDmsValue(
								data.LAST_MAINTENANCE_MILEAGE);
						$("#averageMileage", container).setDmsValue(
								data.DAILY_AVERAGE_MILEAGE);
					}
				});
			}
			// 本工单是保养类型的
			// 本次是保养，上次保养日期就用当前日期
			var IsHaveMAINTAIN = false;
			var repairPartRow = $("#dms_part", container).dmsTable()
					.getRowDataByIndex();
			var partNo = '';
			$.each(repairPartRow, function(name, value) {
				partNo += "'" + value.PART_NO + "',";
			});
			dmsCommon.ajaxRestRequest({
				url : dmsCommon.getDmsPath()['repair']
						+ "/order/repair/getIsMaintenance",
				data : {
					'partNo' : partNo.substr(0, partNo.length - 1)
				},
				async : false,
				sucessCallBack : function(data) {
					console.log(JSON.stringify(data))
					if (data == '1') {
						IsHaveMAINTAIN = true;
					}
				}
			});
			if (IsHaveMAINTAIN) {
				// $("#lastMaintainDate", container).val(sysdate.getTime());
			} else {
				// 如果有上次保养日期就用上次保养日期
				if ($("#lastMaintenanceDate", container).val() != null
						|| $("#lastMaintenanceDate", container).val() != '') {
					//$("#lastMaintainDate", container).val($("#lastMaintenanceDate", container).val());// 车辆表的上次保养日期;
				} else {
					// 如果销售日期为空或销售日期+预计下次保养日期距本工单最长天数<当前日期就用当前日期作为上次保养日期
					if (($("#salesDate", container).val() == "" || $(
							"#salesDate", container).val() == null)
							|| (Number(new Date($("#salesDate", container).val()).getTime()) + parseInt(i) * 86400000) < sysdate
									.getTime()) {
						//$("#lastMaintainDate", container).setDmsValue(sysdate.getTime());// 车辆表的上次保养日期;
						$("#lastMaintenanceMileage", container).setDmsValue(
								$("#outMileage", container).val());
					} else {
						//$("#lastMaintainDate", container).setDmsValue(new Date($("#salesDate", container).val()).getTime());
					}
				}
			}
			if (($("#averageMileage", container).val() == 0)
					&& $("#lastMaintainDate", container).val() != ''
					&& (sysdate.getTime() > Number(nullToZero($("#lastMaintainDate",container).val())))) {
				// 没有日平均行程里程，用（出厂行驶里程－上次维修里程）/（当前日期－上次维修日期）
				$("#averageMileage", container).setDmsValue((parseInt(nullToZero($("#outMileage", container).val())) - parseInt(nullToZero($("#lastRepairMileage", container).val()))) / (Number(sysdate.getTime()) - Number($("#lastMaintainDate", container).val())));
			}
			if (($("#averageMileage", container).val() == 0)
					&& $("#lastMaintainDate", container).val() == ''
					&& $("#salesDate", container).val() != ''
					&& (sysdate.getTime() > Number(nullToZero(new Date($("#salesDate", container).val()).getTime())))) {
				$("#averageMileage", container).val(
						parseInt(nullToZero($("#outMileage", container).val())) / (sysdate.getTime() - Number(nullToZero($("#salesDate",container).val()))));
			}
			strTemp += '日均里程:' + nullToZero($("#averageMileage", container).val());
			strTemp += '间隔:' + j + '天数:' + i;
			strTemp += '上保里程:' + nullToZero($("#lastMaintenanceMileage", container).val())
					+ '上保期' + nullToZero($("#lastMaintainDate", container).val());
			strTemp += '上维里程:' + nullToZero($("#lastRepairMileage", container).val())
					+ '上维期' + nullToZero($("#lastRepairDate", container).val()) + '出里'
					+ nullToZero($("#outMileage", container).val());
			if (nullToZero($("#averageMileage", container).val()) > 0) {
				$("#nextMaintainMileage", container).val(
						parseInt(j)
								+ parseInt(nullToZero($("#lastMaintenanceMileage",container).val())));
				if (IsHaveMAINTAIN) {
					$("#nextMaintainMileage", container).val(
							parseInt(j)
									+ parseInt(nullToZero($("#outMileage", container).val())));
				}
				if (parseInt(nullToZero($("#nextMaintainMileage", container).val())) < parseInt(nullToZero($("#outMileage", container).val()))) {
					$("#nextMaintainMileage", container).setDmsValue(nullToZero($("#outMileage", container).val()));
				}
				// （定期保养里程间隔/日平均行程里程）> 预计下次保养日期距本工单最长天数
				if ((parseInt(j) / parseInt(nullToZero($("#averageMileage", container).val()))) > parseInt(i)) {
					$("#nextMaintainDate", container).setDmsValue(
							Number(nullToZero($("#lastMaintainDate", container).val()))
									+ parseInt(i) * 86400000);
				} else {
					$("#nextMaintainDate", container)
							.setDmsValue(
									Number(nullToZero($("#lastMaintainDate", container).val()))
											+ (parseInt(j) / parseInt(nullToZero($("#averageMileage",container).val())))
											* 86400000);
				}
				// 如果预计下次维修里程小于当前日期，则以当前日期为预计下次保养里程
				if (Number(nullToZero($("#nextMaintainDate", container).val())) < sysdate
						.getTime()) {
					$("#nextMaintainDate", container).setDmsValue(sysdate.getTime());
				}
				strTemp += '下保里：'
						+ Math.round((parseInt(nullToZero($("#nextMaintainMileage",container).val())) / 100) * 100);
				strTemp += '下保期：'
						+ dateByType(Number($("#nextMaintainDate", container).val()),"yyyy-MM-dd hh:mm:ss");
				$("#nextMaintainMileage", container)
						.val(
								(parseInt(nullToZero($("#nextMaintainMileage", container).val())) / 100) * 100);
				$("#nextMaintainDate", container)
						.val(
								dateByType(Number($("#nextMaintainDate", container).val()), "yyyy-MM-dd hh:mm:ss"));
				$("#remark2", container).val(strTemp);
			} else {
				// 无日平均行程里程应该用上次保养日期+预计下次保养日期距本工单最长天数
				$("#nextMaintainMileage", container).val(
						parseInt(j)
								+ parseInt(nullToZero($("#lastRepairMileage", container).val())));
				if (IsHaveMAINTAIN) {
					$("#nextMaintainMileage", container).val(
							parseInt(j)
									+ parseInt(nullToZero($("#outMileage", container).val())));
				}
				if (parseInt(nullToZero($("#nextMaintainMileage", container).val())) < parseInt(nullToZero($("#outMileage", container).val()))) {
					$("#nextMaintainMileage", container).setDmsValue(
							parseInt(nullToZero($("#outMileage", container).val())));
				}
				$("#nextMaintainDate", container).setDmsValue(
						Number(nullToZero($("#lastMaintainDate", container).val()))
								+ Number(i));
				strTemp += '下保里：'
						+ Math.round((parseInt(nullToZero($("#nextMaintainMileage",container).val())) / 100) * 100);
				$("#nextMaintainMileage", container)
						.setDmsValue(
								(parseInt(nullToZero($("#nextMaintainMileage", container).val())) / 100) * 100);
				if ($("#nextMaintainDate", container).val() != ''
						&& Number(nullToZero($("#nextMaintainDate", container).val())) > sysdate
								.getTime()) {
					strTemp += '下保期：'
							+ dateByType(Number($("#nextMaintainDate", container).val()), "yyyy-MM-dd hh:mm:ss");
					$("#nextMaintainDate", container).setDmsValue(
							dateByType(Number($("#nextMaintainDate", container).val()),
									"yyyy-MM-dd hh:mm:ss"));
				} else {
					strTemp += '下保期：' + dateByType(sysdate.getTime(), "yyyy-MM-dd hh:mm:ss");
					$("#nextMaintainDate", container).setDmsValue(
							dateByType(sysdate.getTime(), "yyyy-MM-dd hh:mm:ss"));
				}
				$("#remark2", container).val(strTemp);
			}
			//将日期的毫秒数转化成时间
			//$("#lastMaintainDate").setDmsValue(dateByType(Number($("#lastMaintainDate").val()),"yyyy-MM-dd hh:mm:ss"));
			var t = new Date($("#createDate", container).val());
			var ii = parseFloat(i) * 24 * 60 * 60 * 1000;
			var iii = Number(t.getTime()) + Number(ii);
			//下次保养日期
			$("#nextMaintainDate", container).setDmsValue(dateByType(iii,"yyyy-MM-dd"));
			
			//下次保养里程 mileage
//			$("#inMileage",container).setDmsValue(mileage);
//			$("#outMileage",container).setDmsValue(mileage);
			$("#nextMaintainMileage", container).setDmsValue(
 		    		(parseFloat((isStringNull(mileage) ? 0 : mileage))
 		    		+parseFloat(isStringNull(dmsCommon.getSystemParamInfo("1072","1072")) ? 0 : dmsCommon.getSystemParamInfo("1072","1072"))).toFixed(2)		
 		    );
		}
	}

	// 根据车牌号查询是否存在在修工单，如果存在返回True，不存在返回False
	var QueryROByLicense = function(vin) {// QUERY_REPAIR_ORDER_EXISTS
		// 只查在修工单
		var roStatus = 12551001;
		var flag = false;
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()['repair']
					+ "/order/repair/queryRepairOrderExists",
			data : {
				'vin' : vin,
				'roStatus' : roStatus
			},
			async : false,
			sucessCallBack : function(data) {
				if(!isEmpty(data)){
					flag = true;
				}
			}
		});
		return flag;
	}

	// 品牌，车系，车型，VIN，发动机号，
	// 车主编号，车主性质，车主，
	// 送修人，送修人性别，送修人电话区号，送修人电话，送修人手机，
	// 累计换表里程，进厂行驶里程，是否换表，换表里程，
	// 上次维修日期，责任技师，业务接待，保险公司，
	// 上次行驶里程，颜色，下次保养里程，
	// 预计下次保养日期（车主车辆信息中预计下次保养日期大于当前系统日期则显示预计下次保养日期、下次保养里程）
	// 销售日期，上牌日期，日平均行驶里程
	var setVehicleInfo = function(data, isVehicle, isVinEnter, isDeData, container) {
		isVehicle = false;
		isVinEnter = false;
		isDeData = false;
		if (data != null) {
			// 车牌号，品牌，VIN，发动机号，车系，车型，车身颜色，销售日期
			if (!isStringNull(data.LICENSE) && !isVinEnter) {// 点击VIN号是不返回车牌号。
				$("#license", container).setDmsValue(data.LICENSE);
			} else if (!isStringNull(data.LICENSE) && isVinEnter) {
				// 无牌照可以更新。可以直接在工单处更新车辆的信息。 (条件：牌照号为无牌照，且首次进厂）
				if (data.LICENSE != '无牌照'
						|| (!isStringNull(data.LAST_MAINTAIN_DATE) && !isStringNull(data.LAST_MAINTAIN_DATE))) {
					$("#license", container).setDmsValue(data.LICENSE);
				}
			}
			$("#brand", container).setDmsValue(data.BRAND);
			$("#vin", container).setDmsValue(data.VIN);
			$("#modelYear", container).setDmsValue(data.MODEL_YEAR);
			$("#engineNo", container).setDmsValue(data.ENGINE_NO);
			$("#series", container).setDmsValue(data.SERIES);
			$("#model", container).setDmsValue(data.MODEL);
			if (!isStringNull(data.APACKAGE)) {
				$("#config", container).setDmsValue(data.APACKAGE);
			}
			$("#color", container).setDmsValue(data.COLOR);
			$("#salesDate", container).setDmsValue(data.SALES_DATE);
			// 车主编号，车主性质，车主，送修人姓名，送修人性别，送修人电话，送修人手机，上牌日期，
			if (!isVehicle) {
				if (!isStringNull(data.OWNER_NO)) {
					$("#ownerNo", container).setDmsValue(data.OWNER_NO);
				}
				if (!isStringNull(data.OWNER_PROPERTY)) {
					$("#ownerProperty", container).setDmsValue(
							data.OWNER_PROPERTY);
				}
				if (!isStringNull(data.OWNER_NAME)) {
					$("#ownerName", container).setDmsValue(data.OWNER_NAME);
				}
			}
			if (!isStringNull(data.DELIVERER)) {
				$("#deliverer", container).setDmsValue(data.DELIVERER);
			}
			if (!isStringNull(data.DELIVERER_GENDER)) {
				$("#delivvererGender", container).setDmsValue(
						data.DELIVERER_GENDER);
			}
			if (!isStringNull(data.DELIVERER_PHONE)) {
				$("#delivererPhone", container).setDmsValue(
						data.DELIVERER_PHONE);
			}
			if (!isStringNull(data.DELIVERER_MOBILE)) {
				$("#delivererMobile", container).setDmsValue(
						data.DELIVERER_MOBILE);
			}
			if (data.DELIVERER == ''
					&& parseInt(data.OWNER_PROPERTY) == 11901002) {
				if (!isStringNull(data.OWNER_NAME)) {
					$("#ownerName", container).setDmsValue(data.OWNER_NAME);
				}
				if (!isStringNull(data.GENDER)) {
					$("#delivvererGender", container).setDmsValue(data.GENDER);
				}
				if (!isStringNull(data.PHONE)) {
					$("#delivererPhone", container).setDmsValue(data.PHONE);
				}
				if (!isStringNull(data.MOBILE)) {
					$("#delivererMobile", container).setDmsValue(data.MOBILE);
				}
			}
			if (!isStringNull(data.LICENSE_DATE)) {
				$("#licenseDate", container).setDmsValue(data.LICENSE_DATE);
			}
			if (!isStringNull(data.WRT_BEGIN_DATE)) {
				$("#wrtBeginDate", container).setDmsValue(data.WRT_BEGIN_DATE);// 保险开始日期
			}

			// 进厂表上里程，出厂行驶里程，累计换表里程，上次换表日期，上次维修日期
			// 出厂行驶里程默认等于进厂表上里程。进厂表上里程从车辆的行驶里程
			var value1 = dmsCommon.getSystemParamInfo("1180", "1180");// 前台开关查询
			if (parseInt(value1) == 12781001) {
				if (!isStringNull(data.MILEAGE)) {
					if (parseFloat(data.MILEAGE) > parseFloat($("#inMileage")
							.val())) {
						$("#inMileage", container).setDmsValue(data.MILEAGE);
						$("#outMileage", container).setDmsValue(data.MILEAGE);
					}
				}
			}
			if (!isStringNull(data.TOTAL_CHANGE_MILEAGE)) {
				$("#FToTalChangeMileage", container).setDmsValue(
						data.TOTAL_CHANGE_MILEAGE);// 累计换表里程
				$("#totalChangeMileage", container).setDmsValue(
						data.TOTAL_CHANGE_MILEAGE);// 累计换表里程
			}
			if (!isStringNull(data.CHANGE_DATE)) {
				$("#changeDate", container).setDmsValue(data.CHANGE_DATE);// 保险开始日期
			}
			if (!isStringNull(data.LAST_MAINTAIN_DATE)) {
				$("#lastMaintainDate", container).setDmsValue(
						dateByType(data.LAST_MAINTAIN_DATE,"yyyy-MM-dd hh:mm:ss"));// 上次维修日期
			}
			// 上次维修里程 上端更新的时候 没有处理到此出导致 计算日平均行使里程 有问题
			if (isDeData) {
				if (!isStringNull(data.MILEAGE)) {
					$("#lastMaintainMileage", container).setDmsValue(
							data.MILEAGE);// 保险开始日期
				}
			}else if(!isStringNull(data.LAST_MAINTAIN_MILEAGE)){
				$("#lastMaintainMileage", container).setDmsValue(
						data.LAST_MAINTAIN_MILEAGE);// 保险开始日期
			}
			// 指定技师
			if (!isStringNull(data.CHIEF_TECHNICIAN)) {
				$("#chiefTechnician", container).setDmsValue(
						data.CHIEF_TECHNICIAN);
			}
			// 如果没有载入服务专员。获取当前员工的操作员
			if (isStringNull($("#serviceAdvisor", container).val())) {

			}
			// 三日电访时间 如果车主信息中没有，那么默认为全天
			if (!isStringNull(data.IS_TRACE)) {
				$("#isTrace", container).setDmsValue(data.IS_TRACE);// 三日电访前复选框
			}
			if (parseInt($("#isTrace", container).val()) == 12781001) {
				if (!isStringNull(data.TRACE_TIME.trim())) {
					$("#TRACE_TIME", container).setDmsValue(data.TRACE_TIME);
				}
			} else {
				$("#TRACE_TIME", container).setDmsValue("");
			}
			
			// 下次保养里程、下次保养日期
			if (!isStringNull($("#nextMaintainDate", container).val())
					&& !isStringNull(data.NEXT_MAINTAIN_DATE)) {
				$("#nextMaintainDate", container).setDmsValue(
						data.NEXT_MAINTAIN_DATE);
			}
			if (!isStringNull($("#nextMaintainMileage", container).val())
					&& !isStringNull(data.NEXT_MAINTAIN_MILEAGE)) {
				$("#nextMaintainMileage", container).setDmsValue(
						data.NEXT_MAINTAIN_MILEAGE);
			}
			// 保险公司
			if (!isStringNull($("#insurationCode", container).val())
					&& !isStringNull(data.INSURATION_CODE)) {
				if (HaveInsuration($("#repairType", contianer).val())) {
					var value = findIsInsuranceByRepairTypeCode($("#repairType",container).val());
					$("#insure", container).removeAttr("disabled");
					if (parseInt(value) != 12781001) {// 是否保险字段
						$("#insure", container).setDmsValue("");
					}
				}
			}
			// 会员编号
			if (!isStringNull($("#memberNo", container).val())
					&& !isStringNull(data.MEMBER_NO)) {
				$("#memberNo", container).setDmsValue(data.MEMBER_NO);
			}
			if (!isStringNull($("#productCode", container).val())
					&& !isStringNull(data.PRODUCT_CODE)) {
				$("#productCode", container).setDmsValue(data.PRODUCT_CODE);
			}
			// 如果不存在product_code,查询上端车辆信息更新product_code
			if (isStringNull(data.PRODUCT_CODE)) {
				return;
			}
			if (data != null) {
				var fOemTag = false;
				if (!isStringNull($("#brand", container).val())
						&& parseInt(dmsDict.getSelectedOptionData($("#brand",
								container)).OEM_TAG) == 12781001) {
					fOemTag = true;
				}
				if (fOemTag
						&& isStringNull(data.PRODUCT_CODE)
						&& parseInt(dmsCommon
								.getSystemParamInfo("1801", "1801")) == 12781001) {
					// 更新本地车辆信息
					GetVehicle($("#vin", container).val());
				}
			}
		}
	}

	/**
	 * 选择工单时确定按钮,查询工单明细 selectItem 选中的那一行
	 */
	var chooseRoNoInfo = function(roNo,container) {
		dmsCommon
				.ajaxRestRequest({
					url : dmsCommon.getDmsPath()['repair']
							+ "/order/repair/findOrderDetails",
					data : {
						'roNo' : roNo
					},
					async : false,
					sucessCallBack : function(data) {
						if (!isEmpty(data)) {
							//data.LAST_MAINTAIN_DATE = dateByType(data.LAST_MAINTAIN_DATE,"yyyy-MM-dd hh:mm:ss");
							CheckBy1278(data.IS_CUSTOMER_IN_ASC,"checkIsFactory",getElementContext());
							CheckBy1278(data.IS_SEASON_CHECK,"checkIsQuality",getElementContext());
							CheckBy1278(data.IS_TAKE_PART_OLD,"checkIsTake",getElementContext());
							CheckBy1278(data.IS_ABANDON_ACTIVITY,"checkIsGiveUp",getElementContext());
							CheckBy1278(data.IS_WASH,"checkIsWash",getElementContext());
							CheckBy1278(data.NEED_ROAD_TEST,"checkIsRoad",getElementContext());
							CheckBy1278(data.IS_TRACE,"checkIsTrace",getElementContext());
							if(data.IS_TRACE=='12781002'){
								$("#traceTime").removeClass("required");
								$("#noTraceReason").addClass("required");
							}
							CheckBy1278(data.IS_CHANGE_ODOGRAPH,"isChangeOdograph",getElementContext());
							CheckBy1278(data.IS_ACTIVITY,"checkIsActivity",getElementContext());
							$("div[data-selectRepairOrder='true']",
									getElementContext()).initHtmlContent(data);
							//初始化维修类型下拉框
							initRepairType3($("select[name='roType']",getElementContext()).val());
							$("select[name='labourPrice']",getElementContext()).setDmsValue(data.LABOUR_PRICE);
							if(dmsCommon.getBusinessPurview("10200000")){//可以修改车辆行驶里程
								$("#inMileage",getElementContext()).attr('readonly','readonly');
								$("#outMileage",getElementContext()).attr('readonly','readonly');
							}else{//不可以修改车辆行驶里程
								$("#inMileage",getElementContext()).removeAttr('readonly');
								$("#outMileage",getElementContext()).removeAttr('readonly');
							}
//							//带出工单有监控信息弹出
//							$("#monitorBtn",container).click();
						}
					}
				});
	}
	
	/**
	 * 数据从1278状态转化成复选框选择
	 */
	var CheckBy1278 = function(val,src,container){
		if(!isStringNull(val)&&val=='12781001'){
			$("input[name='"+src+"']",container).prop('checked',true);
		}
	}

	// DCDSG0238 根据vin号查询车辆信息
	var GetVehicle = function(vin) {
		dmsCommon
				.ajaxRestRequest({// 查询接口
					url : dmsCommon.getDmsPath()['repair']
							+ "/order/repair/DCDSGO238",
					data : {
						'vin' : vin
					},
					async : false,
					sucessCallBack : function(data) {
						if (data != null) {
							$("#productCode", container).setDmsValue(
									item.PRODUCT_CODE);
						}
					}
				});
	}

	var HaveInsuration = function(repairType) {
		// 判断维修类型下拉框是否包含repairType,是返回true
		var ret = false;
		$("#repairType option").each(function() {
			if (repairType == $(this).text()) {
				ret = true;
			}
		});
		return ret;
	}

	// 查询非4S站的车辆,在库存存在并且未开票的车
	var CheckVehicleInvoice = function(vin) {// QUERY_NO_INVOICE_VEHICLE
		var bool = false;
		var FIsOpenTriplePack = dmsCommon.getSystemParamInfo("1180", "1180");
		if(FIsOpenTriplePack=="12781001"){
//			dmsCommon.ajaxRestRequest({
//				url : dmsCommon.getDmsPath()['repair']
//			+ "/order/repair/checkVehicleInvoice",
//			data : {
//				'vin' : vin
//			},
//			async : false,
//			sucessCallBack : function(data) {
//				console.log(data)
//				if(!isEmpty(data)){
//					bool = true;
//				}
//			}
//			});
		}
		return bool;
	}

	// 查询车辆方案状态为”等待审核“的工单
	var CheckIsHaveAduitingOrder = function(vin) {// QUERY_ADUITING_REPAIR_ORDER
		var bool = false;
		var FIsOpenTriplePack = dmsCommon.getSystemParamInfo("1180", "1180");
		if(FIsOpenTriplePack=="12781001"){
			dmsCommon.ajaxRestRequest({
				url : dmsCommon.getDmsPath()['repair']
			+ "/order/repair/checkIsHaveAduitingOrder",
			data : {
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(data) {
				if(!isEmpty(data)){
					bool = true;
				}
			}
			});
		}
		return bool;
	}

	// 如果该车有会员卡，则更换图标
	var QueryMemberCardExist = function(vin) {// QUERY_MEMBER_CARD_BY_VIN
		var result = false;
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()['repair']
					+ "/order/repair/queryMemberCardExist",
			data : {
				'vin' : vin
			},
			async : false,
			sucessCallBack : function(data) {
				$("#cardTypeCode").setDmsValue(data.CARD_TYPE_NAME);
				flag = (!isEmpty(data));
			}
		});
		return flag;
	}

	var nullToZero = function(flag) {
		return flag == null || flag == "" ? 0 : flag;
	}

	var dateByType = function(date, fmt) {
		var time = new Date(date);
		var o = {
	        "M+": time.getMonth() + 1, //月份 
	        "d+": time.getDate(), //日 
	        "h+": time.getHours(), //小时 
	        "m+": time.getMinutes(), //分 
	        "s+": time.getSeconds(), //秒 
	        "q+": Math.floor((time.getMonth() + 3) / 3), //季度 
	        "S": time.getMilliseconds() //毫秒 
	    };
		if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (time.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		return fmt;
	}
	
	//当工单类型发生改变时(索赔).需要改变收费区分为OEM索赔
	var initChargePartitionCode = function(container){
		if($("select[name='roType']",container).val()==12531004){
			$.each($('table tbody tr'),function(i,j){
				if(!isStringNull($(j).find("input[id^='ACTIVITY_CODE']").val())||!isStringNull($(j).find("input[id^='PART_MAINTAIN_PACKAGE_CODE']").val())){
				}else{
					$(j).find("select[id^='CHARGE_PARTITION_CODE']").setDmsValue('S');
					if($(j).find("input[id^='rowKey']").val()!="D"&&!isStringNull($(j).find("input[id^='rowKey']").val())){
						if($(j).find("input[id^='rowKey']").val()!="A"){
							$(j).find("input[id^='rowKey']").setDmsValue("U");
						}
						var tabName = $(j).closest('table').attr('id');//表格名称
						var it = $(j).find("input[id^='rowKey']").attr('id').split('rowKey')[1];//获取下标
						$(j).find("input[id='DISCOUNT"+it+"']").setDmsValue(1);
						$(j).find("input[id='DISCOUNT"+it+"']").attr("disabled","disabled");
						if(tabName=='dms_table'){
							$("#dms_table",container).dmsTable().updateRowByIndex(it,{DISCOUNT_AMOUNT:0,RECEIVE_AMOUNT:0});
						}else if(tabName=='dms_part'){
							$("#dms_part",container).dmsTable().updateRowByIndex(it,{DISCOUNT_AMOUNT:0,RECEIVE_AMOUNT:0});
						}else if(tabName=='dms_subjoinItem'){
							$("#dms_subjoinItem",container).dmsTable().updateRowByIndex(it,{DISCOUNT_AMOUNT:0,ADD_ITEM_AMOUNT:0});
						}
					}
				}
			});
			$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_table",container)).attr('disabled','disabled');
			$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_part",container)).attr('disabled','disabled');
			$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_subjoinItem",container)).attr('disabled','disabled');
			$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_sales",container)).attr('disabled','disabled');
		}else{
			var flag = dmsCommon.getBusinessPurview("10110000");
			$.each($('table tbody tr'),function(i,j){
				if(!isStringNull($(j).find("input[id^='ACTIVITY_CODE']").val())||!isStringNull($(j).find("input[id^='PART_MAINTAIN_PACKAGE_CODE']").val())){
				}else{
					$(j).find("select[id^='CHARGE_PARTITION_CODE']").setDmsValue('');
					if($(j).find("input[id^='rowKey']").val()!="D"&&!isStringNull($(j).find("input[id^='rowKey']").val())){
						if($(j).find("input[id^='rowKey']").val()!="A"){
							$(j).find("input[id^='rowKey']").setDmsValue("U");
						}
						var tabName = $(j).closest('table').attr('id');//表格名称
						var it = $(j).find("input[id^='rowKey']").attr('id').split('rowKey')[1];//获取下标
						$(j).find("input[id='DISCOUNT"+it+"']").removeAttr("disabled");
						if(tabName=='dms_table'){
							var labourAmount = Number($(j).find("input[id^='LABOUR_AMOUNT']").val());
							var receiveAmount = Number($(j).find("input[id^='LABOUR_AMOUNT']").val()) * Number($(j).find("input[id='DISCOUNT"+it+"']").val());
							$("#dms_table",container).dmsTable().updateRowByIndex(it,{DISCOUNT_AMOUNT:labourAmount.toFixed(2)-receiveAmount.toFixed(2),RECEIVE_AMOUNT:receiveAmount.toFixed(2)});
						}else if(tabName=='dms_part'){
							var labourAmount = Number($(j).find("input[id^='PART_QUANTITY']").val()) * Number($(j).find("input[id^='PART_SALES_PRICE']").val());
							var receiveAmount = Number($(j).find("input[id^='PART_QUANTITY']").val()) * Number($(j).find("input[id^='PART_SALES_PRICE']").val()) * Number($(j).find("input[id='DISCOUNT"+it+"']").val());
							$("#dms_part",container).dmsTable().updateRowByIndex(it,{DISCOUNT_AMOUNT:labourAmount.toFixed(2)-receiveAmount.toFixed(2),RECEIVE_AMOUNT:receiveAmount.toFixed(2)});
						}else if(tabName=='dms_subjoinItem'){
							var labourAmount = Number($(j).find("input[id^='ADD_ITEM_PRICE']").val());
							var receiveAmount = Number($(j).find("input[id^='ADD_ITEM_PRICE']").val()) * Number($(j).find("input[id='DISCOUNT"+it+"']").val());
							$("#dms_subjoinItem",container).dmsTable().updateRowByIndex(it,{DISCOUNT_AMOUNT:labourAmount.toFixed(2)-receiveAmount.toFixed(2),ADD_ITEM_AMOUNT:receiveAmount.toFixed(2)});
						}
					}
				}
			});
			if(flag){
				debugger
				$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_table",container)).removeAttr('disabled');
				$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_part",container)).removeAttr('disabled');
				$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_subjoinItem",container)).removeAttr('disabled');
				$("select[id^='CHARGE_PARTITION_CODE']",$("#dms_sales",container)).removeAttr('disabled');
			}
		}
	}
	
	/**
	 * 计算表格金额方法
	 */
	var calculateAmount = function(table,field1,field2,container){
		var repairItem = $("#"+table,container).dmsTable().getRowDataByIndex();
		var gsf = 0;//工时费
		if(!isEmpty(repairItem)){
			$.each($("tbody",$("#"+table,container)).not('tr[style^="display: none"]').find('tr'),function(i,j){
				if($(j).find("input[id^=rowKey]").val()!='D'&&!isStringNull($(j).find("input[id^=rowKey]").val())){
					gsf += parseFloat($(j).find("input[id^="+field1+"]").val());
				}
			})
		}
		$("#"+field2,container).setDmsValue(gsf.toFixed(2));
		$("#estimateAmount",container).setDmsValue($("#totalAmount",container).val());
	}
	
	var calculateAmount2 = function(table,field1,field2){
		var repairItem = $("#"+table,getElementContext()).dmsTable().getRowDataByIndex();
		var gsf = 0;//工时费
		if(!isEmpty(repairItem)){
			$.each($("tbody",$("#"+table,getElementContext())).not('tr[style^="display: none"]').find('tr'),function(i,j){//筛选出非隐藏的行
				if($(j).find("input[id^=rowKey]").val()!='D'&&!isStringNull($(j).find("input[id^=rowKey]").val())){
					gsf += parseFloat($(j).find("input[id^="+field1+"]").val());
				}
			})
		}
		$("#"+field2,getElementContext()).setDmsValue(gsf.toFixed(2));
		$("#estimateAmount",getElementContext()).setDmsValue($("#totalAmount",getElementContext()).val());
	}

	return {
		initLabourData : function() {
			return initLabourData();
		},
		addDisabled : function(container) {
			return addDisabled(container);
		},
		removeDisabled : function() {
			removeDisabled();
		},
		calRepairPartAmount : function(curPartAmount) {
			calRepairPartAmount(curPartAmount);
		},
		appendRowInRolabour : function(repairPro, workOrderType, selectData,
				receiveMoney, i, labourPrice) {
			appendRowInRolabour(repairPro, workOrderType, selectData,
					receiveMoney, i, labourPrice);
		},
		settlementPre : function(val) {
			return settlementPre(val);
		},
		countDisAmount : function() {
			return countDisAmount();
		},
		findModelLabourCodeAndModelCode : function() {
			return findModelLabourCodeAndModelCode();
		},
		findModelLabourCodeByModel : function(code, container) {
			findModelLabourCodeByModel(code, container);
		},
		licenseKeyUp : function(obj, container, license, vin) {
			licenseKeyUp(obj, container, license, vin);
		},
		nextMaintain : function(flag,container) {
			nextMaintain(flag,container);
		},
		chooseRoNoInfo : function(roNo) {
			chooseRoNoInfo(roNo);
		},
		initRepairType : function(orderType) {
			initRepairType(orderType);
		},
		checkSave : function(container, returnResult) {
			return checkSave(container, returnResult);
		},
		queryEntityTriple : function() {
			return queryEntityTriple();
		},
		initRepairType1 : function(container) {
			initRepairType1(container);
		},
		initQueryDateType : function(container) {
			initQueryDateType(container);
		},
		initPre3BaoWarm : function(srca) {
			initPre3BaoWarm(srca);
		},
		roNoKeyUp : function(obj, container) {
			roNoKeyUp(obj, container);
		},
		vinKeyUp : function(obj, container) {
			vinKeyUp(obj, container);
		},
		NewRepairOrder : function(container){
			NewRepairOrder(container);
		},
		chooseRate : function(src,rate,container){
			chooseRate(src,rate,container);
		},
		chooseRate2 : function(src,rate,container){
			chooseRate2(src,rate,container);
		},
		findDiscountModeItem : function(item){
			findDiscountModeItem(item);
		},
		getDiscountModeItem : function(){
			return getDiscountModeItem();
		},
		initRepairType0 : function(orderType, container){
			initRepairType0(orderType, container);
		},
		chooseChangeType : function(src1,src2,container){
			chooseChangeType(src1,src2,container);
		},
		chooseChangeType2 : function(src1,src2,container){
			chooseChangeType2(src1,src2,container);
		},
		btnSaveCallBack : function(container){
			btnSaveCallBack(container);
		},
		setAmount : function(){
			setAmount();
		},
		findLabourPriceByRepairTypeCode : function(code){
			return findLabourPriceByRepairTypeCode(code);
		},
		findModelLabourCodeByModel2 : function(code) {
			return findModelLabourCodeByModel2(code);
		},
		isEmpty : function(val) {
			return isEmpty(val);
		},
		calculateAmount : function(table,field1,field2,container){
			calculateAmount(table,field1,field2,container);
		},
		calculateAmount2 : function(table,field1,field2){
			calculateAmount2(table,field1,field2);
		},
		initChargePartitionCode : function(container){
			initChargePartitionCode(container);
		},
		chooseLabourOnLoad : function(vin,container){
			chooseLabourOnLoad(vin,container);
		},
		getCurDateTime : function(){
			return getCurDateTime();
		}
	};

}();

/**
 * 客户模块模块相关功能
 */
var dmsCustomer = function() {

}();

/**
 * 管理模块相关功能
 */
var dmsManager = function() {
	var sample = function() {

	};

	return {
		sample : function() {
			sample();
		}
	};
}();

/**
 * 零售模块相关功能
 */
var dmsRetail = function() {
	var saleDatabindChange = function(tableObject, container) {
		var tab = $("#soDecrodateList tbody", container);
		var tab2 = $("#soDecrodatePartList tbody", container);
		var tab3 = $("#soServicesList tbody", container);
		$("select[id^=accountMode]", tab2).each(
				function() {
					if ($(this).val() == "14061003"
							|| $(this).val() == "14061004") {
						$("input[id^=discount]", $(this).closest("tr")).attr(
								"disabled", "true");
					} else {
						$("input[id^=discount]", $(this).closest("tr"))
								.removeAttr("disabled");
					}
				});
		/** *装潢材料***** */
		// 改变折扣率重置结算方式
		var calDecrodateDiscount = function(obj) {
			var inputValue = $(obj).val();
			if (inputValue == 0 || inputValue == "") {

			} else {
				// $("select[id^=accountMode]",$(obj).closest("tr")).setDmsValue("");
			}
		}
		// 通过下拉框数据实时变更左侧数值
		var calDecrodatePartItemAmount = function(obj) {
			var selectValue = $(obj).val();
			if (selectValue == "14061003" || selectValue == "14061004") {
				$("input[id^=discount]", $(obj).closest("tr")).valChange("0");
				/*
				 * $("input[id^=afterDiscountAmountPartList]",$(obj).closest("tr")).valChange("0");
				 * $("input[id^=afterDiscountAmountPartList]",$(obj).closest("tr")).parents("td").find("span").valChange("0");
				 */
				$("input[id^=discount]", $(obj).closest("tr")).attr("disabled",
						"true");
			} else {
				$("input[id^=discount]", $(obj).closest("tr")).valChange(1);
				$("input[id^=discount]", $(obj).closest("tr")).removeAttr(
						"disabled");
			}
			// dmsRetail.moneyCalculate(container);
		}
		// 填写序列号数值表格变成1并且不可编辑
		var calDecrodatePartItem = function(obj) {
			var inputValue = $(obj).val();
			if (inputValue == "" || inputValue == undefined) {
				$("input[id^=partQuantity]", $(obj).closest("tr")).valChange(
						"1");
				$("input[id^=partQuantity]", $(obj).closest("tr")).removeAttr(
						"disabled");
			} else {
				$("input[id^=partQuantity]", $(obj).closest("tr")).valChange(
						"1");
				$("input[id^=partQuantity]", $(obj).closest("tr")).attr(
						"disabled", "true");
			}
		}
		// 绑定select事件-- 结算方式
		$("select[id^=accountMode]", tab2).bindChange(function(obj) {
			// 计算服务项目实收金额
			calDecrodatePartItemAmount(obj);
		});

		$("input[id^=partSequence]", tab2).bindChange(function(obj) {
			// 计算服务项目实收金额
			calDecrodatePartItem(obj);
		});

		$("input[id^=discount]", tab2).bindChange(function(obj) {
			// 计算服务项目实收金额
			calDecrodateDiscount(obj);
		});

		/** *装潢项目***** */
		// 通过下拉框数据实时变更左侧数值
		var calDecrodateAmount = function(obj) {
			var selectValue = $(obj).val();
			if (selectValue == "14061003" || selectValue == "14061004") {
				$("input[id^=discount]", $(obj).closest("tr")).valChange("0");
			}
		}
		// 填写序列号数值表格变成1并且不可编辑
		var calDecrodateItem = function(obj) {
			$("input[id^=partQuantity]", $(obj).closest("tr")).valChange("1");
			$("input[id^=partQuantity]", $(obj).closest("tr")).attr("disabled",
					"true");
		}
		// 改变加价率重置select值
		var calDecrodateDiscount2 = function(obj) {
			var inputValue = $(obj).val();
			if (inputValue == 0 || inputValue == "") {

			} else {
				$("select[id^=accountMode]", $(obj).closest("tr")).setDmsValue(
						"");
			}
		}

		var calServiceItemAmountList = function(obj) {
			var inputValue = $(obj).val();
			if (inputValue == 0 || inputValue == "") {

			} else {
				$("select[id^=accountMode]", $(obj).closest("tr")).setDmsValue(
						"14061002");
			}
			dmsRetail.moneyCalculate(container);
		}

		// 通过下拉框数据实时变更左侧数值
		var calServiceItemAmount = function(obj) {
			var selectValue = $(obj).val();
			if (selectValue == "14061003" || selectValue == "14061004") {
				$("input[id^=afterDiscountAmountServicesList]",
						$(obj).closest("tr")).valChange("0");
			}
			dmsRetail.moneyCalculate(container);
		}
		// 绑定select事件-- 结算方式
		$("select[id^=accountModeList]", tab3).bindChange(function(obj) {
			// 计算服务项目实收金额
			calServiceItemAmount(obj);
		});

		$("input[id^=afterDiscountAmountServicesList]", tab3).bindChange(
				function(obj) {
					// 计算服务项目实收金额
					calServiceItemAmountList(obj);
				});

	}
	var moneyCalculate = function(container) {
		var tab = $("#soDecrodateList tbody", container);
		var tab2 = $("#soDecrodatePartList tbody", container);
		var tab3 = $("#soServicesList tbody", container);
		var rows = $("tr", tab).length;
		var rows2 = $("tr", tab2).length;
		var rows3 = $("tr", tab3).length;
		var afterDiscountAmount = parseFloat(0);
		var afterDiscountAmountPartList = parseFloat(0);
		var afterDiscountAmountServicesList = parseFloat(0);
		var partSalesAmount = parseFloat(0);
		var directivePrice = parseFloat(0);
		var DiscountAmountPrice = parseFloat(0);
		var sumDiscountAmountPrice = parseFloat(0);
		var sumPresentPrice = parseFloat(0);
		var sumAfterDiscountAmount = parseFloat(0);
		var sumAfterDiscountAmountPartList = parseFloat(0);
		var sumAfterDiscountAmountServicesList = parseFloat(0);
		var sumPartSalesAmount = parseFloat(0);
		var sumDirectivePrice = parseFloat(0);
		var sumPartPresentAmount = parseFloat(0);

		// 装潢项目计算
		if (rows > 0) {
			for (var i = 0; i < rows; i++) {
				afterDiscountAmount = $(
						"tr:eq(" + i
								+ ") td:eq(7) input[id^=afterDiscountAmount]",
						tab).val();// 装潢项目实收金额
				if (afterDiscountAmount == ""
						|| afterDiscountAmount == undefined) {
					var afterDiscountAmount = parseFloat(0);
					sumAfterDiscountAmount = parseFloat(sumAfterDiscountAmount)
							+ parseFloat(afterDiscountAmount);// 装潢项目实收金额总和
				} else {
					sumAfterDiscountAmount = parseFloat(sumAfterDiscountAmount)
							+ parseFloat(afterDiscountAmount);// 装潢项目实收金额总和
				}
			}
		} else {
			var sumAfterDiscountAmount = parseFloat(0);
		}
		// console.log("状态状态状态很好"+sumAfterDiscountAmount+"价格:");

		// 装潢材料
		if (rows2 > 0) {
			for (var i = 0; i < rows2; i++) {
				afterDiscountAmountPartList = $(
						"tr:eq("
								+ i
								+ ") td:eq(11) input[id^=afterDiscountAmountPartList]",
						tab2).val();// 装潢材料实收金额
				partSalesPrice = $(
						"tr:eq(" + i + ") td:eq(7) input[id^=partSalesPrice]",
						tab2).val();// 装潢材料销售价格
				partQuantity = $(
						"tr:eq(" + i + ") td:eq(8) input[id^=partQuantity]",
						tab2).val();// 装潢材料销售数量
				partSalesAmount = $(
						"tr:eq(" + i + ") td:eq(9) input[id^=partSalesAmount]",
						tab2).val();// 装潢材料销售金额
				// discount2= $("tr:eq("+i+") td:eq(10)
				// input[id^=discount]",tab2).val();//折扣率
				accountMode = $(
						"tr:eq(" + i + ") td:eq(12) select[id^=accountMode]",
						tab2).val();// 结算方式
				if (typeof (afterDiscountAmountPartList) == "undefined"
						|| afterDiscountAmountPartList == '') {
					afterDiscountAmountPartList = parseFloat(0).toFixed(2);
				}

				if (typeof (partSalesPrice) == "undefined"
						|| partSalesPrice == '') {
					partSalesPrice = parseFloat(0).toFixed(2);
				}

				if (typeof (partQuantity) == "undefined" || partQuantity == '') {
					partQuantity = parseFloat(0).toFixed(2);
				}

				/*
				 * if(accountMode !="14061003"&&accountMode !="14061004"){
				 * afterDiscountAmountPartList=(partSalesPrice*partQuantity*discount2).toFixed(2)
				 * $("tr:eq("+i+") td:eq(11)
				 * input[id^=afterDiscountAmountPartList]",tab2).valChange(afterDiscountAmountPartList);
				 * $("tr:eq("+i+") td:eq(11)
				 * span",tab2).valChange(afterDiscountAmountPartList); }
				 */
				if (typeof (partSalesAmount) == "undefined"
						|| partSalesAmount == '') {
					partSalesAmount = parseFloat(partSalesPrice)
							* parseFloat(partQuantity);
					var item = $("tr:eq(" + i + ") td:eq(9)>span", tab2);
					var digits = $(item).attr("data-autoValueDigits");
					if (digits) {
						partSalesAmount = partSalesAmount
								.toFixed(parseInt(digits));
					}
					$(item).valChange(partSalesAmount);
					// 如果item 不是input 属性
					if (!$(item).is(":input")) {
						$("input", $(item).parent()).valChange(partSalesAmount);
					}
				}

				if (accountMode == "14061004") {
					sumPartPresentAmount = parseFloat(sumPartPresentAmount)
							+ parseFloat(partSalesAmount);// 状态为赠送时的金额总和(销售金额)
				}
				if (partSalesAmount == "" || partSalesAmount == undefined) {
					var afterDiscountAmountPartList = parseFloat(0);
					var partSalesAmount = parseFloat(0);
					sumPartSalesAmount = parseFloat(sumPartSalesAmount)
							+ parseFloat(partSalesAmount);// 销售金额总和
					sumAfterDiscountAmountPartList = parseFloat(sumAfterDiscountAmountPartList)
							+ parseFloat(afterDiscountAmountPartList); // 装潢材料实收金额总和
				} else {
					sumPartSalesAmount = parseFloat(sumPartSalesAmount)
							+ parseFloat(partSalesAmount);// 销售金额总和
					sumAfterDiscountAmountPartList = parseFloat(sumAfterDiscountAmountPartList)
							+ parseFloat(afterDiscountAmountPartList); // 装潢材料实收金额总和
				}

			}
		} else {
			var afterDiscountAmountPartList = parseFloat(0);
			var partSalesAmount = parseFloat(0);
			var DiscountAmountPrice = parseFloat(0);
			var sumDiscountAmountPrice = parseFloat(0);
			var sumPartSalesAmount = parseFloat(0);
			var sumAfterDiscountAmountPartList = parseFloat(0);
		}

		// 服务项目
		if (rows3 > 0) {
			for (var i = 0; i < rows3; i++) {
				afterDiscountAmountServicesList = $(
						"tr:eq("
								+ i
								+ ") td:eq(6) input[id^=afterDiscountAmountServicesList]",
						tab3).val();// 服务项目实收金额
				directivePrice = $(
						"tr:eq(" + i + ") td:eq(5) input[id^=directivePrice]",
						tab3).val();
				accountModeList = $(
						"tr:eq(" + i + ") td:eq(7) select[id^=accountModeList]",
						tab3).val();
				if (accountModeList == "14061004") {
					sumDirectivePrice = parseFloat(sumDirectivePrice)
							+ parseFloat(directivePrice);
				}
				if (afterDiscountAmountServicesList == ""
						|| afterDiscountAmountServicesList == undefined) {
					var afterDiscountAmountServicesList = parseFloat(0);
					sumAfterDiscountAmountServicesList = parseFloat(sumAfterDiscountAmountServicesList)
							+ parseFloat(afterDiscountAmountServicesList);// 服务项目实收金额总和
				} else {
					sumAfterDiscountAmountServicesList = parseFloat(sumAfterDiscountAmountServicesList)
							+ parseFloat(afterDiscountAmountServicesList);// 服务项目实收金额总和
				}
			}
		} else {
			var afterDiscountAmountServicesList = parseFloat(0);
			var presentPrice = parseFloat(0);
			var directivePrice = parseFloat(0);
			var presentPrice = parseFloat(0);
			var sumPresentPrice = parseFloat(0);
			var sumAfterDiscountAmountServicesList = parseFloat(0);
		}

		if (sumAfterDiscountAmount == ""
				&& sumAfterDiscountAmountPartList != "") {
			$("#upholsterSum", container).setDmsValue(
					parseFloat(sumAfterDiscountAmountPartList).toFixed(2));
		} else if (sumAfterDiscountAmountPartList == ""
				&& sumAfterDiscountAmount != "") {
			$("#upholsterSum", container).setDmsValue(
					parseFloat(sumAfterDiscountAmount).toFixed(2));
		} else if (sumAfterDiscountAmountPartList == ""
				&& sumAfterDiscountAmount == "") {
			$("#upholsterSum", container).setDmsValue(parseFloat(0));
		} else {
			$("#upholsterSum", container)
					.setDmsValue(
							(parseFloat(sumAfterDiscountAmount) + parseFloat(sumAfterDiscountAmountPartList))
									.toFixed(2));// 装潢金额总和

		}
		// 计算赠送金额
		if (accountModeList == "14061004" && accountMode != "14061004") {
			$("#presentSum", container).setDmsValue(
					parseFloat(sumDirectivePrice).toFixed(2));
		} else if (accountMode == "14061004" && accountModeList != "14061004") {
			$("#presentSum", container).setDmsValue(
					parseFloat(sumPartPresentAmount).toFixed(2));
		} else if (accountModeList == "" && accountMode == "") {
			$("#presentSum", container).setDmsValue(parseFloat(0));
		} else {
			$("#presentSum", container)
					.setDmsValue(
							(parseFloat(sumDirectivePrice) + parseFloat(sumPartPresentAmount))
									.toFixed(2));// 赠送金额总和
		}

		$("#serviceSum", container).setDmsValue(
				parseFloat(sumAfterDiscountAmountServicesList).toFixed(2));// 服务项目金额总和

	};

	return {
		moneyCalculate : function(container) {
			moneyCalculate(container);
		},
		saleDatabindChange : function(tableObject, container) {
			saleDatabindChange(tableObject, container);
		}
	};
}();

/**
 * 车辆模块相关功能
 */
var dmsVehicle = function() {
	var sample = function(container) {

	};

	return {
		sample : function() {
			sample();
		}
	};
}();

var dmsHomePageReport = function() {
	var homePageReport = function(container, url) {
		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["report"] + "/homePage/statistical",
			type : 'GET',
			sucessCallBack : function(data) {
				if ($.trim(data) != "null") {
					$("#complaincounts", container).html(
							'<span data-counter="counterup"  data-value='
									+ data.complainNum + '></span>个');
					$("#repairCar", container).html(
							'<span data-counter="counterup"  data-value='
									+ data.repairNum + '></span>台');
					$("#saleCar", container).html(
							'<span data-counter="counterup"  data-value='
									+ data.saleNum + '></span>台');
					$("#conversionRate", container).html(
							'<span data-counter="counterup"  data-value='
									+ data.conversionRate + '></span>%');
				}
				var trs = [];
				var graphs = [];
				dataProvider(data.saleStai, trs, graphs);
				/*
				 * console.log(JSON.stringify(trs));
				 * console.log(JSON.stringify(graphs));
				 */
				Dashboard.initAmChart5(graphs, trs);
				App.init();

			}
		});

		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["report"]
					+ "/homePage/statistical/repairs",
			type : 'GET',
			sucessCallBack : function(data) {
				Dashboard.initCharts(data);
			}
		});

		dmsCommon.ajaxRestRequest({
			url : dmsCommon.getDmsPath()["report"]
					+ "/homePage/statistical/repairs/summation",
			type : 'GET',
			sucessCallBack : function(data) {
				if ($.trim(data) != "null" && $.trim(data) != "") {
					$("#car_num", container).append(
							' <h3>' + data[0].car_num + '台</h3>');
					$("#cars_num", container).append(
							' <h3>' + data[0].cars_num + '台</h3>');
					$("#productionValue", container).append(
							' <h3>' + data[0].DIS_AMOUNT + '万元</h3>');
				}

			}
		});
	};
	var dataProvider = function(list, trs, graphs) {
		var brand_code = {
			"index" : 0
		};
		$
				.each(
						list,
						function(n, ListValue) {
							var json = {};
							var brandCode = '';
							$
									.each(
											ListValue,
											function(i, value) {
												brandCode = list[n][i].BRAND_CODE;
												if (brand_code[list[n][i].BRAND_NAME] != list[n][i].BRAND_NAME
														|| brand_code[list[n][i].BRAND_NAME] == null) {
													var jsonG = {};
													brand_code[''
															+ list[n][i].BRAND_NAME
															+ ''] = list[n][i].BRAND_NAME
													brand_code['index'] = brand_code['index'] + 1;
													brand_code[''
															+ list[n][i].BRAND_CODE
															+ ''] = brand_code['index'];

													jsonG['balloonText'] = '[[title]] of [[category]]:[[value]]';
													jsonG['fillAlphas'] = brand_code['index'];
													jsonG['id'] = 'AmGraph-'
															+ brand_code[''
																	+ list[n][i].BRAND_CODE
																	+ ''] + '';
													jsonG['type'] = 'column';
													jsonG['title'] = list[n][i].BRAND_NAME == null ? "未知品牌"
															: list[n][i].BRAND_NAME;
													jsonG['valueField'] = 'column-'
															+ brand_code[''
																	+ list[n][i].BRAND_CODE
																	+ ''] + '';
													graphs.push(jsonG);

												}
												json['category'] = list[n][i].EMPLOYEE_NAME;
												json['column-'
														+ brand_code[brandCode]
														+ ''] = list[n][i].SAL_NUM
												// console.log("杜卡迪:"+JSON.stringify(brand_code[brandCode]));
											});
							trs.push(json);
						});

	};

	_toFixed = function(val, d) {
		var s = val + "";
		if (!d)
			d = 0;
		if (s.indexOf(".") == -1)
			s += ".";
		s += new Array(d + 1).join("0");
		if (new RegExp("^(-|\\+)?(\\d+(\\.\\d{0," + (d + 1) + "})?)\\d*$")
				.test(s)) {
			var s = "0" + RegExp.$2, pm = RegExp.$1, a = RegExp.$3.length, b = true;
			if (a == d + 2) {
				a = s.match(/\d/g);
				if (parseInt(a[a.length - 1]) > 4) {
					for (var i = a.length - 2; i >= 0; i--) {
						a[i] = parseInt(a[i]) + 1;
						if (a[i] == 10) {
							a[i] = 0;
							b = i != 1;
						} else
							break;
					}
				}
				s = a.join("").replace(
						new RegExp("(\\d+)(\\d{" + d + "})\\d$"), "$1.$2");
			}
			if (b)
				s = s.substr(1);
			return (pm + s).replace(/\.$/, "");
		}
		return val + "";
	};

	var setRound = function(val) {
		var settlementType = dmsCommon.getSystemParamInfo("8011", "8011");
		var precision = dmsCommon.getSystemParamInfo("1009", "1009");
		var resultVal = "";
		val = parseFloat(val);
		resultVal = val;
		if (precision == "12921001") { // 元
			if (settlementType == "12931001") { // 四舍五入 （整数）
				resultVal = parseFloat(val).toFixed(0);
			} else if (settlementType == "12931002") { // 只舍不如 (整数)
				resultVal = parseInt(val);
			} else if (settlementType == "12931003") { // 只入不舍 (保留整数位)
				resultVal = Math.ceil(val);
			}
		} else if (precision == "12921002") { // 角
			if (settlementType == "12931001") { // 四舍五入
				resultVal = _toFixed(val, 1);
			} else if (settlementType == "12931002") { // 只舍不如
				var tag = '.';
				var str = val + "";
				if (str.indexOf(tag) == -1) {
					resultVal = val.toFixed(1);
				} else {
					resultVal = parseFloat(str.substring(0, str
							.lastIndexOf('.') + 2));
				}
			} else if (settlementType == "12931003") { // 只入不舍

				var bb = val + "";
				var dian = bb.indexOf('.');
				if (dian == -1) {
					resultVal = val.toFixed(1);
				} else {
					var cc = bb.substring(dian + 1, bb.length);
					if (cc.length >= 2) {
						/*
						 * bb=bb.substring(0,dian+2);
						 * resultVal=parseFloat(bb)+parseFloat(0.1);
						 */
						resultVal = (bb.toString().match(/^\d+(?:\.\d{0,1})?/));
					} else {
						resultVal = val.toFixed(1);
					}
				}
			}
		} else if (precision == "12921003") { // 分
			resultVal = val.toFixed(2);
		}

		return resultVal;
	};

	return {
		homePageReport : function(container, url) {
			homePageReport(container, url);
		},
		setRound : function(val) {
			return setRound(val);
		}
	};
}();
