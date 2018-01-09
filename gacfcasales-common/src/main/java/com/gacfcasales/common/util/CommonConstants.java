package com.gacfcasales.common.util;

/**
 * @author Charles
 * @Title: CommonConstants
 * @Package 
 * @Description: TODO
 * @date 2017/9/28 15:29
 */
public class CommonConstants {
	public final static String IOS_8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	public final static String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
	public final static String SIMPLE_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";
	public final static String FULL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String ACCURATE_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
	public final static String SIMPLE_DATE_MONTH_FORMAT = "yyyy-MM";
	public final static String SIMPLE_MONTH_FORMAT = "MM/dd";

	/**
	 * 不进行任何格式操作，没有千位符，小数点不自动补全
	 */
	public final static String Excel_NUMBER_FORMAT_SAMPLE = "#";

	public final static String Excel_NUMBER_FORMAT_SAMPLE_ROUND2 = "0.00";
	// 设置百分比样式
	public final static String Excel_NUMBER_FORMAT_SAMPLE_PERCENT = "0.00%";

	// 错误信息列表最大行数
	public static final Integer IMPORT_MAX_ERRORS_ROWS = 30;

	// 订单号初始化
	public static final Integer INIT_ORDER_NO = 1;
	// 订单号位数
	public static final int SYSTEM_ORDER_NO_NUMBER = 4;
	// 订单号位数随机一位
	public static final int SYSTEM_ORDER_NO_NUMBER_THREE = 3;
	// 订单号位数
		public static final int SYSTEM_ORDER_NO_NUMBERS = 6;
	/**
	 * 跟踪回访类型
	 */
	public static final String DICT_DCRC_TRACE_TYPE = "1411"; // 跟踪回访
	public static final String DICT_DCRC_TRACE_TYPE_LOSS_VEHICLE_ALARM = "14111005"; // 客户流失报警
	/**
	 * 数据存储分区标识
	 */
	public static int D_KEY = 0;
	/**
	 * 配件库存隔离开关 8575
	 */
	public static final String DEFAULT_PARA_PART_STOCK_DELETE = "8575";
	// 意向级别
	public static final String DICT_INTENT_LEVEL = "1310"; // 意向级别
	public static final String DICT_INTENT_LEVEL_H = "13101001"; // H级
	public static final String DICT_INTENT_LEVEL_A = "13101002"; // A级
	public static final String DICT_INTENT_LEVEL_B = "13101003"; // B级
	public static final String DICT_INTENT_LEVEL_C = "13101004"; // C级
	public static final String DICT_INTENT_LEVEL_N = "13101005"; // N级
	public static final String DICT_INTENT_LEVEL_FO = "13101006"; // F0级
	public static final String DICT_INTENT_LEVEL_F = "13101007"; // F级
	public static final String DICT_INTENT_LEVEL_O = "13101008"; // O级
	public static final String DICT_INTENT_LEVEL_D = "13101009"; // D级
	/**
	 * 配件订单项状态
	 */
	public static final String DICT_PORS_ITEM_TYPE = "1347"; // 配件订单状态类别
	public static final String DICT_PORS_ITEM_REPORT = "13471001"; // 已上报
	public static final String DICT_PORS_ITEM_RECEIVE = "13471002"; // 已接收
	public static final String DICT_PORS_ITEM_DEALING = "13471003"; // 处理中
	public static final String DICT_PORS_ITEM_FINISH = "13471004"; // 已完成
	public static final String DICT_PORS_ITEM_CANCEL = "13471005"; // 已取消

	/**
	 * 产品配件订单类型
	 */
	public static final String DICT_DMS_PART_ORDER_TYPE = "1248"; // 产品订单类型
	public static final String DICT_DMS_PART_ORDER_TYPE_CG = "12481001"; // 常规(库存)
	public static final String DICT_DMS_PART_ORDER_TYPE_JJ = "12481002"; // 紧急(客户)
	public static final String DICT_DMS_PART_ORDER_TYPE_BX = "12481003"; // 保修
	public static final String DICT_DMS_PART_ORDER_TYPE_QY = "12481004"; // 紧急汽运
	public static final String DICT_DMS_PART_ORDER_TYPE_EO = "12481005"; // EO
	public static final String DICT_DMS_PART_ORDER_TYPE_SO = "12481006"; // SO
	public static final String DICT_DMS_PART_ORDER_TYPE_VOR = "12481007"; // VOR
	public static final String DICT_DMS_PART_ORDER_TYPE_WO = "12481008"; // WO
	public static final String DICT_DMS_PART_ORDER_TYPE_TO = "12481009"; // TO
	public static final String DICT_DMS_PART_ORDER_TYPE_E_CODE = "12481010"; // ECODE
	public static final String DICT_DMS_PART_ORDER_TYPE_S_CODE = "12481011"; // SCODE
	public static final String DICT_DMS_PART_ORDER_TYPE_FO = "12481012"; // FO
	/**
	 * 单据状态（采购入库单）
	 */
	public static final String DICT_ORDER_STATUS = "1500"; // 单据状态
	public static final String DICT_ORDER_STATUS_NOT_REPORT = "15001001"; // 未上报
	public static final String DICT_ORDER_STATUS_AUDITING = "15001005"; // 审核中
	public static final String DICT_ORDER_STATUS_REJECT = "15001010"; // 驳回
	public static final String DICT_ORDER_STATUS_PASS = "15001015"; // 审核通过

	/**
	 * 微信预约状态
	 */
	public static final String DICT_MICROMSG_BOOKING_STATUS = "1249";
	public static final String DICT_MICROMSG_BOOKING_STATUS_PRE_SUCCESS = "12491001"; // 预约成功
	public static final String DICT_MICROMSG_BOOKING_STATUS_SRV_OVER = "12491002"; // 服务完成
	public static final String DICT_MICROMSG_BOOKING_STATUS_PRE_CANCEL = "12491003"; // 已取消
	public static final String DICT_MICROMSG_BOOKING_STATUS_SRV_EXPIRE = "12491004"; // 已过期

	// 车厂公共数据默认Dealer_code
	public static final String PUBLIC_DEALER_CODE = "-1";

	// 默认经销商代码字段名称
	public static final String PUBLIC_DEALER_CODE_NAME = "DEALER_CODE";
	// 默认经销商代码字段名称
	public static final String PUBLIC_ORGANIZATION_NAME = "ORGANIZATION_ID";

	// 价格调整单单据号前缀
	public static final String PRICE_ADJUSTMENT_PREFIX = "PT";

	// 调拨出库单号前缀
	public static final String PART_ALLOCATE_OUT_PREFIX = "SB";

	// 采购入库单号前缀
	public static final String PART_BUY_IN_PREFIX = "SG";

	// 销售出库单号前缀
	public static final String PART_SALES_OUT_PREFIX = "SO";

	// 配件报损单号前缀
	public static final String PART_LOSS_NO = "SF";
	// 内部领用单号前缀
	public static final String PART_INNER_NO = "SA";
	// 调拨入库单号前缀
	public static final String PART_ALLOCATE_IN_PREFIX = "SH";
	// 配件报溢单号前缀
	public static final String PART_Profit_PREFIX = "SK";

	// 车主编码前缀
	public static final String OWNER_PREFIX = "OW";
	// 客户投诉 TS
	public static final String COMPLAINTNO_PREFIX = "TS";

	// 客户编码前缀
	public static final String CUSTOMER_PREFIX = "CO";
	// 潜客编码前缀
	public static final String POTENTIAL_CUSTOMER_PREFIX = "PU";
	// 销售单号前缀
	public static final String SO_NO_PREFIX = "SO";
	// 整车出库单号前缀
	public static final String SD_NO = "VD";
	// 配件销售报价单号前缀
	public static final String SALES_QUOTE = "CA";
	// 配件销售单号前缀
	public static final String SALES_PART = "SO";
		
	
	/**
	 * 付款单据的付款业务类型
	 */
	public static final String DICT_PAY_BUSINESS_TYPE = "1405";
	public static final String DICT_PAY_BUSINESS_TYPE_VEHICLE_STOCK_IN = "14051001";// 整车采购入库
	public static final String DICT_PAY_BUSINESS_TYPE_VEHICLE_ALLOCATE_IN = "14051002";// 整车调拨入库
	public static final String DICT_PAY_BUSINESS_TYPE_PART_STOCK_IN = "14051003";// 配件采购入库
	public static final String DICT_PAY_BUSINESS_TYPE_PART_ALLOCATE_IN = "14051004";// 配件调拨入库
	/**
	 * 配件订单状态
	 */
	public static final String DICT_PORS_TYPE = "1361"; // 配件订单状态类别
	public static final String DICT_PORS_NOT_REPORT = "13611001"; // 未上报
	public static final String DICT_PORS_REPORT = "13611002"; // 已上报
	public static final String DICT_PORS_RECEIVED = "13611003"; // 已接收
	public static final String DICT_PORS_REFUSE = "13611007"; // 已拒绝
	public static final String DICT_PORS_REJECT = "13611006"; // 已驳回
	public static final String DICT_PORS_PASSED = "13611005"; // 已通过
	public static final String DICT_PORS_DEALING = "13611011"; // 处理中
	public static final String DICT_PORS_CANCEL = "13611012"; // 取消
	public static final String DICT_PORS_FINISH = "13611013"; // 已完成

	
	/**
	  * 入库业务类型
	  */
		 public static final String  DICT_STOCK_IN_TYPE = "1307"; //车辆入库业务类型
		 public static final String  DICT_STOCK_IN_TYPE_DEALER_BUY = "13071001"; //经销商自购
		 public static final String  DICT_STOCK_IN_TYPE_BUY_NEW_VEHICLE = "13071002"; //新车采购入库
		 public static final String  DICT_STOCK_IN_TYPE_ALLOCATION = "13071003"; //调拨入库
		 public static final String  DICT_STOCK_IN_TYPE_ENTRUST_DELIVERY = "13071004"; //受托交车入库
		 public static final String  DICT_STOCK_IN_TYPE_SALE_UNTREAD = "13071005"; //销售退回入库
		 public static final String  DICT_STOCK_IN_TYPE_SEC_SALE_UNTREAD = "13071006"; //二网销售退回入库
	/**
	 * 销售单号
	 */
	public static final String SRV_XSDH = "SO";
	/**
	 * with ur
	 */
	public static final String WITH_UR = "  WITH UR  ";

	// 减免单号前缀
	public static final String DERATE_NO = "BD";

	// 预约单号前缀
	public static final String BO_NO = "YO";

	/**
	 * 4S默认车主编号
	 */
	public static final String DEALER_DEFAULT_OWNER_NO = "888888888888";
	/**
	 * 售后无牌照
	 */
	public static final String CON_LICENSE_NULL = "无牌照";

	/**
	 * 监控车总数量
	 */
	public static final String DEFAULT_MONITOR_CAR_TOTAL = "3332";

	/**
	 * 客户生日当天N倍积分
	 */
	public static final int DEFAULT_IS_PRESENT_NTIMES_CREDIT = 3310;

	/**
	 * 客户生日当天赠送积分
	 */
	public static final int DEFAULT_IS_PRESENT_CREDIT = 3308;

	/**
	 * 配件销售积分基数
	 */
	public static final int DEFAULT_PARA_PART_SALE_CREDIT_BASE = 1102;

	/**
	 * 配件维修积分基数
	 */
	public static final int DEFAULT_PARA_PART_REPAIR_CREDIT_BASE = 1103;

	/**
	 * 预收款积分基数
	 */
	public static final int DEFAULT_PARA_PRE_GET_MONEY_CREDIT_BASE = 1101;

	/**
	 * 工时费积分基数
	 */
	public static final int DEFAULT_PARA_WORK_HOUR_CREDIR_BASE = 1104;

	/**
	 * 预约成功积分赠送
	 */
	public static final int DEFAULT_PARA_BOOKING_SUCCESS_CREDIT_BASE = 1107;

	/**
	 * 回访成功积分赠送
	 */
	public static final int DEFAULT_PARA_RECALL_SUCCESS_CREDIT_PRESENT = 1108;

	/**
	 * 准时进厂积分赠送
	 */
	public static final int DEFAULT_PARA_IN_FACTORY_ONTIME_CREDIT_SEND = 1109;

	/**
	 * 延时进厂积分赠送
	 */
	public static final int DEFAULT_PARA_OUTTIME_CREDIT_SEND = 1110;

	/**
	 * 积分兑换维修费
	 */
	public static final int DEFAULT_PARA_CREDIT_CHANGE_REPAIR = 1111;

	/**
	 * 积分兑换礼品
	 */
	public static final int DEFAULT_PARA_CREDIT_CHANGE_GIFTS = 1112;

	/**
	 * 批量建卡维修费兑换积分
	 */
	public static final int DEFAULT_PARA_CONS_CARD_REPAIR_CHANGE_CREDIT = 1113;
	/**
	 * 会员卡是否自动升级
	 */
	public static final int DEFAULT_PARA_CONS_IS_CARD_AUTO_UPGRADE = 1114;

	/**
	 * 非预约进场赠送积分系数
	 */
	public static final int DEFAULT_PARA_NOT_BOOKING_CREDIT_SEND = 1150;

	/**
	 * 收款使用储值是否产生积分
	 */
	public static final int DEFAULT_USE_STORE_IS_CREATE_CREDIT = 1135;

	/**
	 * 收款时使用余款是否产生积分
	 */
	public static final int DEFAULT_USE_AMOUNT_IS_CREATE_CREDIT = 1136;

	/**
	 * 维修积分是否优先项目维修类型
	 */
	public static final int DEFAULT_CREDIT_ROUND_TYPE = 1166;

	/**
	 * 首保回厂积分赠送
	 */
	public static final int DEFAULT_PARA_FIRST_GURANTEE_BACK = 3306;

	/**
	 * 维修积分是否优先项目维修类型
	 */
	public static final int DEFAULT_IS_PRIORITY_LABOUR_REPAIR_TYPE = 1165;

	/**
	 * 本公司投保理赔积分系数
	 */
	public static final int DEFAULT_INSURANCE_CREDIT_COEFFIVIENT = 1162;
	/**
	 * 非本公司投保理赔积分系数
	 */
	public static final int DEFAULT_OTHER_INSURANCE_CREDIT_COEFFIVIENT = 1163;
	
	/**
	 * 财务接口开关的ITEM_CODE
	 */
	public static  String FINANCE_ITEM_CODE = "8901";   
	
	/**
	 * 维修税率的ITEM_CODE
	 */
	public static  String REPAIR_CESS_ITEM_CODE = "1003";  
	
	/**
	 * 生成凭证的xml文件路径
	 */
	public static String FINANCE_FILE_SAVE_PATH="D:\\InfoDMSFileSpace\\FINANCE\\SEND\\";
	
	/**
	 * 生成回执的xml文件路径
	 */
	public static String FINANCE_RETURN_FILE_SAVE_PATH="D:\\InfoDMSFileSpace\\FINANCE\\RETURN\\";
	
	/**
	 * 汇率
	 */
	public static  String EX_CHANGE_RATE = "1.00";  
	
	/**
	 * nc系统,回执成功状态
	 */
	public static  String NC_SUCCESS_STATUS = "1"; 

	/**
	 * u8系统,回执成功状态
	 */
	public static  String U8_SUCCESS_STATUS = "0"; 

	/**
	 * 有效状态
	 */
	public static final String DICT_VALIDS_TYPE = "1001"; // 有效状态类别
	public static final String DICT_VALIDS_VALID = "10011001"; // 有效
	public static final String DICT_VALIDS_INVALID = "10011002"; // 无效

	// 组织层级
	public static Integer DUTY_TYPE = 1043;

	public static Integer DUTY_TYPE_COMPANY = 10431001; // 公司

	public static Integer DUTY_TYPE_DEPT = 10431002; // 部门

	public static Integer DUTY_TYPE_LARGEREGION = 10431003; // 大区

	public static Integer DUTY_TYPE_SMALLREGION = 10431004; // 小区

	public static Integer DUTY_TYPE_DEALER = 10431005; // 经销商

	/**
	 * 配件缺料结案状态
	 */
	public static final String DICT_PART_SHORT_CLOSE_STATUS_TYPE = "1286"; // 配件缺料结案状态
	public static final String DICT_PART_SHORT_CLOSE_STATUS_TYPE_END_A_CASE = "12861001"; // 已结案
	public static final String DICT_PART_SHORT_CLOSE_STATUS_TYPE_NOT_END_A_CASE = "12861002"; // 未结案

	/**
	 * 出入库类型
	 */
	public static final String DICT_IN_OUT_TYPE = "1215"; // 出入库类型类别
	public static final String DICT_IN_OUT_TYPE_PART_LEND = "12151011"; // 借出登记
	public static final String DICT_IN_OUT_TYPE_OTHER_OUT_STOCK = "12151017"; // 其他出库
	public static final String DICT_IN_OUT_TYPE_OTHER_IN_STOCK = "12151016"; // 其他入库
	public static final String DICT_IN_OUT_TYPE_HAND_BACK = "12151015"; // 采购退货
	public static final String DICT_IN_OUT_TYPE_PART_LOSS = "12151014"; // 配件报损
	public static final String DICT_IN_OUT_TYPE_PART_MOVE_OUT = "12151013"; // 配件移库出库
	public static final String DICT_IN_OUT_TYPE_BORROW_RETURN = "12151012"; // 借进归还
	public static final String DICT_IN_OUT_TYPE_ALLOCATE_OUT = "12151010"; // 调拨出库
	public static final String DICT_IN_OUT_TYPE_WORKSHOP_BORROW = "12151008"; // 车间借料
	public static final String DICT_IN_OUT_TYPE_REPAIR_DISPENSE_PART = "12151006"; // 维修发料
	public static final String DICT_IN_OUT_TYPE_LEND_RETURN = "12151004"; // 借出归还
	public static final String DICT_IN_OUT_TYPE_PART_BORROW = "12151003"; // 借进登记
	public static final String DICT_IN_OUT_TYPE_PART_SALE = "12151007"; // 配件销售
	public static final String DICT_IN_OUT_TYPE_INNER = "12151009"; // 内部领用
	public static final String DICT_IN_OUT_TYPE_IN_STOCK = "12151001"; // 采购入库
	public static final String DICT_IN_OUT_TYPE_PART_PROFIT = "12151005"; // 配件报溢
	public static final String DICT_IN_OUT_TYPE_INDENT_UNTREAD = "12151018"; // 订货退回
	public static final String DICT_IN_OUT_TYPE_COST_PRICE_IN_STOCK = "12151019"; // 成本价调整入库
	public static final String DICT_IN_OUT_TYPE_COST_PRICE_OUT_STOCK = "12151020"; // 成本价调整出库
	public static final String DICT_IN_OUT_TYPE_DISPENSE_PRICE_IN_STOCK = "12151021"; // 发料价格调整入库
	public static final String DICT_IN_OUT_TYPE_DISPENSE_PRICE_OUT_STOCK = "12151022"; // 发料价格调整出库
	public static final String DICT_IN_OUT_TYPE_PART_MOVE_IN = "12151023"; // 配件移库入库
	public static final String DICT_IN_OUT_TYPE_PART_BOOKPART = "12151024"; // 配件预留
	public static final String DICT_IN_OUT_TYPE_DECK_UPHOLSTER = "12151025"; // 装饰装潢出库

	/**
	 * 库存状态
	 */
	public static final String DICT_STORAGE_STATUS = "1304"; // 整车库存状态
	public static final String DICT_STORAGE_STATUS_MOVE_OUT = "13041001"; // 出库
	public static final String DICT_STORAGE_STATUS_IN_STORAGE = "13041002"; // 在库
	public static final String DICT_STORAGE_STATUS_ON_WAY = "13041003"; // 在途
	public static final String DICT_STORAGE_STATUS_LEND_TO = "13041004"; // 借出

	/**
	 * 
	 */
	public static final String MANAGE_SORT_CLAIM_TAG = "S";

	/**
	 * 车辆出库业务类型
	 */
	public static final String DICT_STOCK_OUT_TYPE = "1324"; // 车辆出库业务类型
	public static final String DICT_STOCK_OUT_TYPE_SALE = "13241001"; // 销售出库
	public static final String DICT_STOCK_OUT_TYPE_ALLOCATION = "13241002"; // 调拨出库
	public static final String DICT_STOCK_OUT_TYPE_DELIVERY = "13241003"; // 受托交车出库
	public static final String DICT_STOCK_OUT_TYPE_UNTREAD = "13241004"; // 采购退回出库
	public static final String DICT_STOCK_OUT_TYPE_OTHER = "13241005"; // 其它类型出库
	public static final String DICT_STOCK_OUT_TYPE_SEC_SALE = "13241006"; // 二网销售类型出库

	/**
	 * 配件类别
	 */
	public static final String DICT_PART_CLASS_TYPE = "1136"; // 配件类别
	public static final String DICT_PART_CLASS_IN_COMMON_USE = "11361001"; // 常用
	public static final String DICT_PART_CLASS_DAMAGEABLE = "11361002"; // 易损
	public static final String DICT_PART_CLASS_BASE = "11361003"; // 基础
	public static final String DICT_PART_CLASS_OVER = "11361004"; // 辅料
	public static final String DICT_PART_CLASS_MAINTAIN_PRODUCT = "11361005"; // 养护品
	public static final String DICT_PART_CLASS_REFINE_PRODUCT = "11361006"; // 厂家精品
	public static final String DICT_PART_CLASS_SUPPLIES = "11361007"; // 用品
	public static final String DICT_PART_CLASS_CHASSIS_NUMBER = "11361008"; // 底盘号相关
	public static final String DICT_PART_CLASS_CONVENTIONAL_PART = "11361009"; // 常规零部件
	public static final String DICT_PART_CLASS_THE_THIRD = "11361010"; // 第三方
	public static final String DICT_PART_CLASS_BATTERY = "11361011"; // 电瓶
	/**
	 * 操作日志类型
	 */
	public static final String DICT_ASCLOG_TYPE = "1206"; // 操作日志类型类别
	public static final String DICT_ASCLOG_SYSTEM_MANAGE = "12061001"; // 系统管理
	public static final String DICT_ASCLOG_CLIENT_MANAGE = "12061008"; // 客户管理
	public static final String DICT_ASCLOG_TOOL_MANAGE = "12061007"; // 工具管理
	public static final String DICT_ASCLOG_OPERATION_RECEIVE = "12061002"; // 业务接待
	public static final String DICT_ASCLOG_WORKSHOP_MANAGE = "12061003"; // 车间管理
	public static final String DICT_ASCLOG_BALANCE_MANAGE = "12061004"; // 结算管理
	public static final String DICT_ASCLOG_CLAIM_MANAGE = "12061006"; // 索赔管理
	public static final String DICT_ASCLOG_PART_MANAGE = "12061005"; // 配件管理
	public static final String DICT_SEND_INFO = "12061009"; // INFOX失败消息
	public static final String DICT_SEND_SUCCEED = "12061010"; // INFOX成功消息
	public static final String DICT_ASCLOG_VEHICLE_MANAGE = "12061012"; // 整车管理
	public static final String DICT_ASCLOG_MEMBER_MANAGE = "12061011"; // 会员管理
	public static final String DICT_ASCLOG_DERIVATIVE_BUSINESS = "12061013"; // 衍生业务
	public static final String DICT_ASCLOG_MARKET_ACTIVITY = "12061014"; // 市场活动
	public static final String DICT_BALANCE_SEND_SUCCEED = "12061015"; // 结算单INFOX成功消息
	public static final String DICT_BALANCE_SEND_FAIL = "12061016"; // 结算单INFOX失败消息
	/**
	 * 服务活动类别
	 */
	public static final String DICT_ACTIVITY_KIND_TYPE = "2003"; // 服务活动类别
	public static final String DICT_ACTIVITY_KIND_RRT = "20031001"; // 'RRT快速反应'
	public static final String DICT_ACTIVITY_KIND_TSB = "20031002"; // 'TSB技术通报'
	public static final String DICT_ACTIVITY_KIND_CSN = "20031003"; // 'CSN满意度改进'
	public static final String DICT_ACTIVITY_KIND_RETURN = "20031004"; // 'Recall召回活动'
	public static final String DICT_ACTIVITY_KIND_WX = "20031005"; // '免费维修'
	public static final String DICT_ACTIVITY_KIND_JC = "20031006"; // '免费检查'
	public static final String DICT_ACTIVITY_KIND_FSA = "20031007";// '维修套餐'
	public static final String DICT_ACTIVITY_KIND_PS = "20031008";// '配件活动'

	/**
	 * //菲亚特配件提报方式
	 */
	public static final String DICT_FIAT_PART_REPORT_WAY = "8003";
	public static final String DICT_FIAT_PART_REPORT_WAY_NORMAL = "80031001"; // 常规零部件
	public static final String DICT_FIAT_PART_REPORT_WAY_FY = "80031002"; // 菲跃零部件

	/**
	 * 后台主机厂
	 */
	public static final String DICT_DEFAULT_TOTAL_FACTORY = "00000000";

	/**
	 * DE通用常量
	 */
	public static final String DE_APP_NAME = "00001000"; // 待定
	public static final String DE_ADAPTER = "InfoxAdapter"; // DE ADAPTER
															// (MQ:MQAdapter
															// INFOX:infox)
	public static final String DE_OEM_CODE = "GMS000000"; // DE中使用的OEM代码
	public static final String DE_GROUP_CODE = "GROUP";
	public static final String DE_UNTI_CODE = "UNIT";
	public static final String DE_FACTORY_CODE = "FACTORY";
	public static final String DE_SUB_FACTORY_CODE = "SUBFACTORY";
	public static final String DE_OPTER = "1"; // de程序处理数据时 createby ,updateby
	public static final Long DE_CREATE_UPDATE_BY = 1L; // 接口传来的数据，CREATE_BY,UPDATE_BY

	public static final String DE_GROUP_ENTITY_CODE = "11111111";
	/**
	 * 缓存开关是否打开
	 */
	public static final int DEFAULT_CACHE_IS_OPEN = 1314;
	/**
	 * 活动发布状态
	 */
	public static final String DICT_ACTIVITY_RELEASE_TAG_TYPE = "1289"; // 活动发布状态类别
	public static final String DICT_ACTIVITY_RELEASE_TAG_NOT_RELEASE = "12891001"; // 未发布
	public static final String DICT_ACTIVITY_RELEASE_TAG_RELEASED = "12891002"; // 已发布
	public static final String DICT_ACTIVITY_RELEASE_TAG_CANCEL = "12891003"; // 已取消

	/**
	 * 服务活动类型
	 */
	public static final String DICT_ACTIVITY_TYPE = "1184"; // 服务活动类型类别
	public static final String DICT_ACTIVITY_TYPE_RECALL = "11841001"; // 召回活动
	public static final String DICT_ACTIVITY_TYPE_SERVICE = "11841002"; // 服务活动
	public static final String DICT_ACTIVITY_TYPE_MAINTAIN = "11841003"; // 市场活动
	public static final String DICT_ACTIVITY_TYPE_LOCAL = "11849999"; // 本地定义活动

	/**
	 * 客户来源
	 */
	public static final String DICT_CUS_SOURCE = "1311"; // 客户来源
	public static final String DICT_CUS_SOURCE_EXHI_HALL = "13111001"; // 展厅
	public static final String DICT_CUS_SOURCE_AD_ACTIVITY = "13111002"; // 广告活动
	public static final String DICT_CUS_SOURCE_MARKET_ACTIVITY = "13111003"; // 市场活动
	public static final String DICT_CUS_SOURCE_TENURE_CUSTOMER = "13111004"; // 保有客户
	public static final String DICT_CUS_SOURCE_FRIEND = "13111005"; // 朋友
	public static final String DICT_CUS_SOURCE_ADDI_PURCHASE = "13111006"; // 续购
	public static final String DICT_CUS_SOURCE_OTHER = "13111007"; // 其他
	public static final String DICT_CUS_SOURCE_PHONE_VISITER = "13111008"; // 陌生拜访（含电话销售）
	public static final String DICT_CUS_SOURCE_ORG_CODE = "13111014"; // 代理商/代销网点/经纪人
	public static final String DICT_CUS_SOURCE_PHONE_CUSTOMER = "13111015"; // 来电顾客
	public static final String DICT_CUS_SOURCE_INTERNET = "13111012"; // 网络/电子商务
	public static final String DICT_CUS_SOURCE_BY_WAY = "13111013"; // 路过
	public static final String DICT_CUS_SOURCE_CALL_CENTER = "13111101"; // CAPSA
	// CALL
	// CENTER
	public static final String DICT_CUS_SOURCE_DS_WEBSITE = "13111102"; // DS
	// WEBSITE
	public static final String DICT_CUS_SOURCE_BY_DCC = "13111016"; // DCC转入
	public static final String DICT_CUS_SOURCE_BY_SHOW = "13111017"; // 车展
	public static final String DICT_CUS_SOURCE_BY_EXPERIENCE_DAY = "13111018"; // 体验日
	public static final String DICT_CUS_SOURCE_BY_CARAVAN = "13111019"; // 大篷车
	public static final String DICT_CUS_SOURCE_BY_WEB = "13111021"; // 电商客户

	/**
	 * 工单状态
	 */
	public static final String DICT_RO_STATUS_TYPE = "1255"; // 工单状态类别
	public static final String DICT_RO_STATUS_TYPE_ON_REPAIR = "12551001"; // 在修
	public static final String DICT_RO_STATUS_TYPE_FOR_BALANCE = "12551005"; // 已提交结算
	public static final String DICT_RO_STATUS_TYPE_BALANCED = "12551010"; // 已结算

	/**
	 * 工单类型
	 */
	public static final String DICT_RPT_TYPE = "1253"; // 工单类型类别
	public static final String DICT_RPT_REPAIR = "12531001"; // 维修
	public static final String DICT_RPT_RETURN = "12531003"; // 返工
	public static final String DICT_RPT_CLAIM = "12531004"; // 索赔
	public static final String DICT_RPT_SALE = "12531002"; // 销售

	/**
	 * 保有车辆客户类型
	 */
	public static final String DICT_CUS_TYPE = "1054";// 保有车辆客户类型
	public static final String DICT_CUS_TYPE_ORDINARY = "10541001"; // 普通潜客

	public static final String DICT_SCHEME_STATUS = "2202";// 三包方案状态
	public static final String DICT_SCHEME_STATUS_ADUITING = "22021001"; // 待审核
	public static final String DICT_SCHEME_STATUS_ADJUST = "22021002"; // 方案调整
	public static final String DICT_SCHEME_STATUS_REJUST = "22021003"; // 拒绝维修
	public static final String DICT_SCHEME_STATUS_SUCCESS = "22021004"; // 审核通过
	public static final String DICT_SCHEME_STATUS_ACCREDIT = "22021005"; // 授权维修
	public static final String DICT_SCHEME_STATUS_NOT_WARN = "22021006"; // 未达预警

	// 下面是从DMS系统移植过来的
	/**
	 * 成本调整单号
	 */
	public static final String SRV_CBTZDH = "CA";

	/**
	 * 工单领退料 发料单号
	 */
	public static final String SRV_FLDH = "PD";

	/**
	 * 业务接待 客户接待 维修工单号
	 */
	public static final String SRV_WXGDH = "RO";
	
	/**
	 * 业务接待 配件预约单号
	 */
	public static final String SRV_PJYYH = "PB";

	/**
	 * 描述： 工具作废主键类型
	 */
	public static String SRV_GJZF = "TD";

	/**
	 * 描述： 借用报失主键类型
	 */
	public static String SRV_JYBS = "TD";

	/**
	 * 工具归还
	 */
	public static final String SRV_GJGH = "TC";

	/**
	 * 结算单号
	 */
	public static final String SRV_JSD = "BO";

	/**
	 * 描述： 工具借用主键类型
	 */
	public static String SRV_GJJY = "SC";

	/**
	 * 描述： 工具购入主键类型
	 */
	public static String SRV_GJGR = "TA";

	/**
	 * 售前维修
	 */
	public static final String REPAIR_TYPE_SQWX = "SQWX";

	/**
	 * 估价单号
	 */
	public static final String SRV_GJDH = "EO";

	/**
	 * 收款单号
	 */
	public static final String SRV_SKDH = "BA";

	/**
	 * 借出登记单号
	 */
	public static final String SRV_JCDJDH = "SC";

	/**
	 * //菲亚特配件提报方式
	 */
	// ** 菲亚特订货状态
	public static final String DICT_ORDER_GOODS_STATUS = "4005"; // 菲亚特订货状态
	public static final String DICT_ORDER_GOODS_STATUS_NO = "40051001"; // 未订货
	public static final String DICT_ORDER_GOODS_STATUS_YES = "40051002"; // 已订货
	public static final String DICT_ORDER_GOODS_STATUS_MAKE_YES = "40051003"; // 强制完成

	/**
	 * 借进归还单号
	 */
	public static final String SRV_JJGHDH = "SD";

	/**
	 * 借进登记单号
	 */
	public static final String SRV_JJDJDH = "SI";

	/**
	 * 配件预留单号
	 */
	public static final String SRV_PJYLDH = "YL";

	/**
	 * 借出归还单
	 */
	public static final String SRV_JCGHDH = "SJ";

	/**
	 * 配件盘点单
	 */
	public static final String SRV_PJPDDH = "SL";

	/**
	 * 配件移库单号
	 */
	public static final String SRV_PJYKDH = "PR";

	/**
	 * 配件税率
	 */

	public static int DEFAULT_PARA_PART_RATE = 2034;

	/**
	 * 是否使用批次
	 */

	public static int DEFAULT_PARA_BATCH_SATAUS = 2035;

	/**
	 * 是否结清派工
	 */
	public static final int DEFAULT_IS_ACCOUNT_ASSIGN = 3020;

	/**
	 * 是否使用交车功能
	 */

	public static int DEFAULT_PARA_SUBMIT_CAR = 1022;

	/**
	 * 收款时是否需要输入会员卡密码
	 */
	public static final String DEFAULT_IS_NEED_CHECK_CARD_PASSWORD = "1028";

	/**
	 * 维修类型-新车装潢
	 */
	public static final String REPAIR_TYPE_UPHOLSTER = "XCZH";

	/**
	 * 订单编号
	 */
	public static final String SRV_DDBH = "PO";

	/**
	 * 客户管理 车主车辆管理 车主编号
	 */
	public static final String SRV_CZBH = "OW";

	/**
	 * BO订单编号
	 */
	public static final String SRV_BO = "PK";

	/**
	 * BO订单编号
	 */
	public static final String SRV_PJQS = "PS";

	/**
	 * 活动编号
	 */
	public static final String SRV_HDBH = "CP";

	/**
	 * 车辆移库单号
	 */
	public static final String SAL_CLYKDH = "TO";

	/**
	 * 整车库存-验收入库单
	 */
	public static final String SAL_ZZKC_LKD = "VE";

	/**
	 * 整车库存-借出归还单
	 */
	public static final String SAL_ZZKC_GHD = "VL";

	/**
	 * 整车销售单号
	 */
	public static final String SAL_ZZXSDH = "SN";

	/**
	 * 二网订单编号
	 */
	public static final String SAL_SE_ORDER = "SE";

	/**
	 * 广告计划
	 */
	public static final String SAL_GGJH = "AD";

	/**
	 * 配件索赔申请单号
	 */
	public static final String SRV_PJSPDH = "PC";

	/**
	 * 返利编号
	 */
	public static final String SAL_XSFLBH = "BN";

	/**
	 * 索赔申请单号
	 */
	public static final String SRV_SPSQDH = "WO";

	/**
	 * 批售审批单号
	 */
	public static final String SRV_PSSPDH = "WS";

	/**
	 * 客户管理 车主车辆管理 集团车主编号
	 */
	public static final String SRV_JTCZBH = "GN";

	/**
	 * 客户管理 车主车辆管理 工厂车主编号
	 */
	public static final String SRV_GCCZBH = "FN";

	/**
	 * 客户管理 车主车辆管理 车辆信息变更申请单编号
	 */
	public static final String SRV_CLXXBGSQD = "VO";

	/**
	 * 预收款单
	 */
	public static final String SRV_YSKDH = "PA";

	/**
	 * 客户管理 CRM 客服任务单号
	 */
	public static final String CRM_KFRWBH = "CR";

	/**
	 * 会员管理 会员申请管理 会员申请单号
	 */
	public static final String MEM_HYSQDH = "MA";

	/**
	 * 会员管理 会员资料管理 会员信息编号
	 */
	public static final String MEM_HYXXBH = "MN";

	/**
	 * 会员管理 会员退款申请单号
	 */
	public static final String MEM_HYTKBH = "MR";

	/**
	 * 会员管理 会员预约申请单
	 */
	public static final String MEM_YYSQD = "DB";

	/**
	 * 保修 保修申请单号
	 */
	public static final String CLAIM_BXSQD = "BX";

	/**
	 * 货运单 注册号码(货运单标号)
	 */
	public static final String REGEDIT_DO = "DO";

	/**
	 * 会员卡类型
	 */
	public static final String CARD_TYPE = "CT";
	/**
	 * 会员积分明细编号
	 */
	public static final String CREDIT_DETAIL = "AP";
	/**
	 * 会员编号
	 */
	public static final String MEMBER_NO = "ME";

	/**
	 * 会员卡号
	 */
	public static final String MEMBER_CARD_CODE = "MC";
	/**
	 * 礼品兑换单号
	 */
	public static final String GIFT_CHANGE_CODE = "GC";
	/**
	 * 会员储值明细编号
	 */
	public static final String MEMBER_STORE_DETAIL_NO = "CZ";
	/**
	 * 出险单号
	 */
	public static final String SRV_CX = "CX";
	/**
	 * 投保单号
	 */
	public static final String INSURE_CODE = "IC";
	/**
	 * 回访管理
	 */
	public static final String VISIT_MANAGE_CODE = "VM";
	/**
	 * 减免单号
	 */
	public static final String SRV_JMDH = "BD";

	/**
	 * 车主性质
	 */
	public static final String DICT_OWNER_PROPERTY_TYPE = "1190"; // 车主性质类别
	public static final String DICT_OWNER_PROPERTY_COMPANY = "11901001"; // 公司
	public static final String DICT_OWNER_PROPERTY_PERSONAL = "11901002"; // 个人

	/**
	 * 积分规则编码
	 */
	public static final String VIP_POINT_RULES = "VP";
	/**
	 * 质损单号
	 */
	public static final String MAR_MESSAGE_NO = "ZS";

	/**
	 * 意向销售单号
	 */
	public static final String INTENT_SO_NO = "YX";

	/**
	 * 
	 */
	public static final String QNNR_CODE = "MQ";

	/**
	 * 二手车销售客户编号
	 */
	public static final String SC_KHBH = "EC";

	/**
	 * 二手车评估单号
	 */
	public static final String SC_PGDH = "EP";

	/**
	 * 二手车收购协议单号
	 */
	public static final String SC_SGXYDH = "EG";

	/**
	 * 二手车出库单号
	 */
	public static final String SC_CKDH = "EK";

	/**
	 * 二手车入库单号
	 */
	public static final String SC_RKDH = "EI";

	/**
	 * 二手车调价单号
	 */
	public static final String SC_TJDH = "ET";

	/**
	 * 二手车销售订单号
	 */
	public static final String SC_XSDH = "ES";

	/**
	 * 二手车移库单号
	 */
	public static final String SC_YKDH = "ER";

	/**
	 * 二手车收购客户编号
	 */
	public static final String SC_SGKHDH = "EF";

	/**
	 * 二手车收购合同编号
	 */
	public static final String SC_PURNO = "PN";

	/**
	 * 二手车销售合同编号
	 */
	public static final String SC_SALNO = "LN";

	/**
	 * 接车单
	 */
	public static final String SRV_JCDH = "RC";
	/**
	 * 贷款单号
	 */
	public static final String MORT_NO = "MT";
	/**
	 * 返利规则编码
	 */
	public static final String MORT_FLGZ = "MS";

	/**
	 * 金融票据登记单号
	 */
	public static final String BILL_NO = "BL";

	/**
	 * 预付款单号
	 */
	public static final String PRE_PAY_NO = "YP";
	/**
	 * 付款单号
	 */
	public static final String PAY_MONEY_NO = "PM";

	/**
	 * 整车采购单 add by lq
	 */
	public static final String BUY_VECHICLE_NO = "ZC";

	/**
	 * 延保返利规则编码
	 */
	public static final String EW_FLGZ = "EW";
	/**
	 * 延保索赔申请单代码
	 */
	public static final String EA_SP = "EA";

	/**
	 * 延保登记单代码
	 */
	public static final String EA_YB = "YB";

	/**
	 * 延保收款单号
	 */
	public static final String EB_YBSK = "EB";
	/**
	 * 个人延保奖金上报单号
	 */
	public static final String EB_JJSB = "EU";

	/**
	 * 调拨申请单号
	 */
	public static final String EB_AAO = "AO";

	// add by Bill Tang 2013-01-21 start
	/**
	 * 销售线索编号
	 */
	public static final String SCU_CULE_NO = "CL";

	/**
	 * 大客户组织架构申请编号
	 */
	public static final String APPLY_ORG_NO = "ZO";

	/**
	 * 到货索赔单编号
	 */
	public static final String SP_PC = "SP";

	/**
	 * 默认批次名字
	 */
	public static final String defaultBatchName = "InfoBatch";

	/**
	 * 福特移库时 删除标记 D_KEY 设置为 4
	 */
	public static final int DEFAULT_PARA_PART_DELETE_KEY = 4;

	/**
	 * 预约提前进厂时间_分钟前
	 */

	public static int DEFAULT_PARA_BOOKING_COME_BEFORE = 1047;

	/**
	 * 预约延迟进厂_分钟后
	 */

	public static int DEFAULT_PARA_BOOKING_COME_AFTER = 1048;
	/**
	 * 配件报损单号
	 */
	public static final String SRV_PJBSDH = "SF";

	/**
	 * 辅料管理费积分基数
	 */
	public static final int DEFAULT_PARA_MANAGE_COST_CREDIT_BASE = 1106;
	/**
	 * 附加项目积分基数
	 */
	public static final int DEFAULT_PARA_ATTACH_CREDIT_BASE = 1105;
	public static final String DICT_IN_OUT_TYPE_ALLOCATE_IN = "12151002"; // 调拨入库
	/**
	 * 销售订单类型
	 */
	public static final String DICT_SO_TYPE = "1300"; // 销售订单类型
	public static final String DICT_SO_TYPE_GENERAL = "13001001"; // 一般销售订单
	public static final String DICT_SO_TYPE_ALLOCATION = "13001002"; // 车辆调拨
	public static final String DICT_SO_TYPE_ENTRUST_DELIVERY = "13001003"; // 受托交车
	public static final String DICT_SO_TYPE_SERVICE = "13001004"; // 服务销售
	public static final String DICT_SO_TYPE_RERURN = "13001005";// 销售退回
	/**
	 * 卡状态
	 */
	public static final String DICT_CARD_STATUS = "5005"; // 卡状态
	public static final String DICT_CARD_STATUS_NOT_ACTIVE = "50051001"; // 未激活
	public static final String DICT_CARD_STATUS_NORMAL = "50051002"; // 正常
	public static final String DICT_CARD_STATUS_FREEZE = "50051003"; // 冻结
	public static final String DICT_CARD_STATUS_NON_USE = "50051004"; // 停用
	public static final String DICT_CARD_STATUS_INVALID = "50051005"; // 作废
	/**
	 * 业务描述：系统管理常量类
	 */
	public static final String SESSION_USERID = "user_id";
	public static final String SESSION_ENTITYCODE = "entity_code";
	public static final String SESSION_EMPNO = "emp_no";
	public static final String SESSION_EMPNAME = "emp_name";
	public static final String SESSION_ORGCODE = "org_code";
	public static final String SESSION_ISPAD = "is_pad";
	/**
	 * 销售订单状态
	 */
	public static final String DICT_SO_STATUS = "1301"; // 销售订单状态
	public static final String DICT_SO_STATUS_NOT_AUDIT = "13011010"; // 未提交审核
	public static final String DICT_SO_STATUS_MANAGER_AUDITING = "13011015"; // 经理审核中
	public static final String DICT_SO_STATUS_ACCOUNTANT_AUDITING = "13011020"; // 财务审核中
	public static final String DICT_SO_STATUS_DELIVERY_CONFIRMING = "13011025"; // 交车确认中
	public static final String DICT_SO_STATUS_HAVE_CONFIRMED = "13011030"; // 已交车确认
	public static final String DICT_SO_STATUS_HAVE_OUT_STOCK = "13011035"; // 已完成
	public static final String DICT_SO_STATUS_MANAGER_REJECT = "13011040"; // 经理驳回
	public static final String DICT_SO_STATUS_ACCOUNTANT_REJECT = "13011045"; // 财务驳回
	public static final String DICT_SO_STATUS_SYSTEM_REJECT = "13011050"; // 系统驳回
	public static final String DICT_SO_STATUS_HAVE_CANCEL = "13011055"; // 已取消
	public static final String DICT_SO_STATUS_HAVE_UNTREAD = "13011060"; // 已退回
	public static final String DICT_SO_STATUS_WAIT_UNTREAT_IN_STOCK = "13011065"; // 等待退回入库
	public static final String DICT_SO_STATUS_UNTREAT_HAVE_IN_STOCK = "13011070"; // 退回已入库
	public static final String DICT_SO_STATUS_CLOSED = "13011075";// 已关单

	/**
	 * 服务项目类型
	 */
	public static final String DICT_SERVICE_TYPE = "1313"; // 服务项目类型
	public static final String DICT_SERVICE_TYPE_INSURANCE = "13131001"; // 保险
	public static final String DICT_SERVICE_TYPE_BUY_TAX = "13131002"; // 购税
	public static final String DICT_SERVICE_TYPE_HANG_LICENSE = "13131003"; // 上牌
	public static final String DICT_SERVICE_TYPE_CREDIT = "13131004"; // 信贷
	public static final String DICT_SERVICE_TYPE_OTHER = "13131005"; // 其他
	/**
	 * 配车状态
	 */
	public static final String DICT_DISPATCHED_STATUS = "1305"; // 整车库存配车状态
	public static final String DICT_DISPATCHED_STATUS_NOT_DISPATCHED = "13051001"; // 未配车
	public static final String DICT_DISPATCHED_STATUS_HAVE_DISPATCHED = "13051002"; // 已配车
	public static final String DICT_DISPATCHED_STATUS_DELIVERY_CONFIRM = "13051003"; // 交车确认
	public static final String DICT_DISPATCHED_STATUS_HAVE_DELIVER = "13051004"; // 已交车

	/**
	 * 整车库存操作类型
	 */
	public static final String DICT_VEHICLE_STORAGE_TYPE = "1320"; // 减免费用类型
	public static final String DICT_VEHICLE_STORAGE_TYPE_BUY = "13201001"; // 新车采购入库
	public static final String DICT_VEHICLE_STORAGE_TYPE_IN = "13201002"; // 受托交车入库
	public static final String DICT_VEHICLE_STORAGE_TYPE_ALLOCATE_IN = "13201003"; // 调拨入库
	public static final String DICT_VEHICLE_STORAGE_TYPE_RETURN_IN = "13201004"; // 销售退回入库
	public static final String DICT_VEHICLE_STORAGE_TYPE_SALE_OUT = "13201005"; // 销售出库
	public static final String DICT_VEHICLE_STORAGE_TYPE_ALLOCATE_OUT = "13201006"; // 调拨出库
	public static final String DICT_VEHICLE_STORAGE_TYPE_RETURN_OUT = "13201007"; // 采购退回出库
	public static final String DICT_VEHICLE_STORAGE_TYPE_OTHER_OUT = "13201008"; // 其它类型出库
	public static final String DICT_VEHICLE_STORAGE_TYPE_MOVE_STOCK = "13201009"; // 移库
	public static final String DICT_VEHICLE_STORAGE_TYPE_MOVE_POSITION = "13201010"; // 移位
	public static final String DICT_VEHICLE_STORAGE_TYPE_LEND = "13201011"; // 借出
	public static final String DICT_VEHICLE_STORAGE_TYPE_RETURN = "13201012"; // 归还
	public static final String DICT_VEHICLE_STORAGE_TYPE_CHANGE_PRICE = "13201013"; // 调价
	public static final String DICT_VEHICLE_STORAGE_TYPE_CHANGE_PROPERTY = "13201014"; // 修改库存属性
	public static final String DICT_VEHICLE_STORAGE_TYPE_OUT = "13201015"; // 受托交车出库
	public static final String DICT_VEHICLE_STORAGE_TYPE_BUY_SELF = "13201016";// 自购入库

	/**
	 * 预约单状态
	 */
	public static final String DICT_BOS_TYPE = "1254"; // 预约单状态类别
	public static final String DICT_BOS_NOT_ENTER = "12541001"; // 未进厂
	public static final String DICT_BOS_DELAY_ENTER = "12541003"; // 延迟进厂
	public static final String DICT_BOS_ADVANCE_ENTER = "12541004"; // 提前进厂
	public static final String DICT_BOS_ENTER_ON_TIME = "12541005"; // 准时进厂
	public static final String DICT_BOS_CANCEL_ENTER = "12541002"; // 取消进厂

	/**
	 * 来访方式
	 */
	public static final String DICT_VISIT_TYPE = "1309"; // 来访方式
	public static final String DICT_VISIT_TYPE_BY_CALL = "13091001"; // 来电
	public static final String DICT_VISIT_TYPE_IN_BODY = "13091002"; // 来店
	public static final String DICT_VISIT_TYPE_SPECIAL_OUT = "13091004";// 特定外拓
	public static final String DICT_VISIT_TYPE_STRANGE_VISIT = "13091003";// 陌生拜访
	public static final String DICT_VISIT_TYPE_OTHER = "13091005";// 其它
	public static final String DICT_VISIT_TYPE_INVITE = "13091006";// 邀约

	/**
	 * 使用状态
	 */
	public static final String DICT_IN_USE_TYPE = "1210"; // 使用状态类别
	public static final String DICT_IN_USE_START = "12101001"; // 启用
	public static final String DICT_IN_USE_STOP = "12101002"; // 停用
	/**
	 * 是否
	 */
	public static final String DICT_IS_TYPE = "1278"; // 是否类别
	public static final String DICT_IS_YES = "12781001"; // 是
	public static final String DICT_IS_NO = "12781002"; // 否
	public static final String DICT_CUS_TYPE_REPLACE = "10541002"; // 置换意向潜客

	// 文件上传文件分隔符
	public static final String FILEUPLOADID_SPLIT_STR = ",;";
	// 文件上传文件分隔符---已经存在文件与新上传文件
	public static final String FILEUPLOADID_SPLIT_STR_TYPE = "##@";
	/**
	 * 会员状态
	 */
	public static final String DICT_MEMBER_STATUS = "5004"; // 会员状态
	public static final String DICT_MEMBER_STATUS_NORMAL = "50041001"; // 正常
	public static final String DICT_MEMBER_STATUS_QUIT = "50041002"; // 退会
	/**
	 * 预收款客户类型
	 */
	public static final String DICT_PRE_PAY_CUSTOMER_TYPE_TYPE = "1370"; // 预收款客户类型类别
	public static final String DICT_PRE_PAY_CUSTOMER_TYPE_OWNER = "13701001"; // 车主
	public static final String DICT_PRE_PAY_CUSTOMER_TYPE_CUSTOMER = "13701002"; // 业务往来客户
	public static final String DICT_PRE_PAY_CUSTOMER_TYPE_POTENTIAL_CUSTOMER = "13701003";// 潜在客户类型
	public static final String DICT_PRE_PAY_CUSTOMER_TYPE_INSURANCE = "13701004";// 保险公司

	/**
	 * @author yujiangheng 事务类型
	 */
	public static final String DICT_BUSINESS_TYPE = "1588"; // 事务类型
	public static final String DICT_BUSINESS_TYPE_PART_STOCK = "15880001"; // 采购入库
	public static final String DICT_BUSINESS_TYPE_BALANCE_ACCOUNTS = "15880002"; // 维修结算
	public static final String DICT_BUSINESS_TYPE_RECEIVE_MONEY = "15880003"; // 收款
	public static final String DICT_BUSINESS_TYPE_REPAIR_PART = "15880004"; // 维修领料
	public static final String DICT_BUSINESS_TYPE_CANCEL_BALANCE_ACCOUNTS = "15880005"; // 取消结算
	public static final String DICT_BUSINESS_TYPE_PART_PROFIT = "15880006"; // 配件报溢
	public static final String DICT_BUSINESS_TYPE_PART_LOSS = "15880007"; // 配件报损
	public static final String DICT_BUSINESS_TYPE_VEHICLE_STOCK_OUT_BY = "15880008"; // 车辆出库
	public static final String DICT_BUSINESS_TYPE_SO_INVOICE = "15880009"; // 开票登记
	public static final String DICT_BUSINESS_TYPE_STOCK_ENTRY_IN = "15880010"; // 整车入库
	public static final String DICT_BUSINESS_TYPE_PART_BUY_IS_PAYOFF = "15880011"; // 财务应付账款管理
	public static final String DICT_BUSINESS_TYPE_PART_ALLOCATE_IN = "15880012"; // 调拨入库
	public static final String DICT_BUSINESS_TYPE_PART_BORROW = "15880013"; // 借进登记
	public static final String DICT_BUSINESS_TYPE_PART_BORROW_RETURN = "15880014"; // 借出归还
	public static final String DICT_BUSINESS_TYPE_PART_SALES = "15880015"; // 配件销售
	public static final String DICT_BUSINESS_TYPE_PART_INNER = "15880016"; // 内部领用
	public static final String DICT_BUSINESS_TYPE_PART_ALLOCATE_OUT = "15880017"; // 调拨出库
	public static final String DICT_BUSINESS_TYPE_STOCK_LEND = "15880018"; // 借出登记
	public static final String DICT_BUSINESS_TYPE_PART_LEND_RETURN = "15880019"; // 借进归还
	public static final String DICT_BUSINESS_TYPE_STOCK_TRANSFER = "15880020"; // 配件移库
	public static final String DICT_BUSINESS_TYPE_BALANCE_SERVERTIME = "15880021"; // 结算收款
	public static final String DICT_BUSINESS_TYPE_UPHOLSTER_OUT = "15880022"; // 装饰装潢领料

	/**
	 * 非OEM配件不允许出OEM仓库
	 */
	public static final String DEFAULT_PARA_OEM_PART_OUT_CHECK = "8572";
	/**
	 * 非OEM配件不允许入OEM仓库
	 */
	public static final String DEFAULT_PARA_OEM_PART_IN_CHECK = "8573";
	// 自建配件代码前缀
	public static final String PART_CODE_PREFIX = "DLR";

	public static final Integer INTERVAL_DAY = 3;// 间隔天数
	
	/**
	 * 延时处理操作
	 */
	public static final String delay_igorn = "ignore";    //取消
	public static final String delay_delayed = "delayed"; //延时处理

	/**
	 * 召回活动开关是否打开
	 */
	public static final int ZHAOHUI_SERVICE_IS_OPEN = 9009;
	/**
	 * 召回活动子开关是否打开
	 */
	public static final int ZHAOHUI_SERVICE_ITEM_IS_OPEN = 9010;

	/**
	 * 是否集团会员
	 */
	public static final int DEFAULT_IS_GROUP_MEMBER = 1891;

	/**
	 * 反结算是否退还会员卡储值
	 */
	public static final int DEFAULT_IS_RETUEN_STORE_AMOUNT_BACK = 1154;

	/**
	 * 反结算是否退还会员卡积分
	 */
	public static final int DEFAULT_IS_RETUEN_CREDIT_AMOUNT_BACK = 1153;

	/**
	 * 是否可以使用配件报溢页面
	 */
	public static final String DEFAULT_SHOW_PARA_OVERFLOW = "1666";

	public static final int DEFAULT_PARA_IS_LIMIT_PART_PRICE = 8571;
	/**
	 * 未生成
	 */
	public static final String DICT_EXEC_STATUS_NOT_EXEC = "16980001";
	/**
     * 是否开启配件限价功能
     */
    public static final String PART_LIMIT_PRICE_IS_OPEN="3432" ;
	//
	
}
