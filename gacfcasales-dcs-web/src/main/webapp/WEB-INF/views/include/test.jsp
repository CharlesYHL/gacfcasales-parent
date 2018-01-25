<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<!--         <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" /> -->
        <link href="${ctx }/resource/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
        <!-- END GLOBAL MANDATORY STYLES -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
         <link href="${ctx }/resource/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-timepicker/css/bootstrap-timepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/morris/morris.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/fullcalendar/fullcalendar.min.css" rel="stylesheet" type="text/css" />
        
        <link href="${ctx }/resource/global/plugins/boostrap-table/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/boostrap-table/bootstrap-table-fixed-columns.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/bootstrap-fileinput/bootstrap-fileinput.min.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/ion.rangeslider/css/ion.rangeSlider.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/plugins/ion.rangeslider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet" type="text/css" />
		<link href="${ctx }/resource/global/plugins/jstree/css/style.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
        <link href="${ctx }/resource/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
        <!-- BEGIN THEME LAYOUT STYLES -->
		<!-- 自定义样式 -->
        <link href="${ctx }/resource/layouts/layout/css/layout.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/layouts/layout/css/themes/grey.css" rel="stylesheet" type="text/css" id="style_color" />
        <link href="${ctx }/resource/layouts/layout/css/custom.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/layouts/layout/css/gcustom.css" rel="stylesheet" type="text/css" />
        <link href="${ctx }/resource/layouts/layout/css/fixcustom.css" rel="stylesheet" type="text/css" />
        <!-- 自定义样式 -->
        <link rel="shortcut icon" href="favicon.ico" /> 
        
        </head>
    <!-- END HEAD -->

        <!-- BEGIN CORE PLUGINS -->
        <script src="${ctx }/resource/global/plugins/jquery.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery.cookie.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery.PrintArea.js?1=1" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
       	 <script src="${ctx }/resource/global/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
        <!-- END CORE PLUGINS -->
        <!-- BEGIN PAGE LEVEL PLUGINS -->
        <script src="${ctx }/resource/global/plugins/moment.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/format-number.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jshashtable-3.0.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery.numberformatter-1.2.4.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-daterangepicker/daterangepicker.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-timepicker/js/bootstrap-timepicker.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/morris/morris.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/morris/raphael-min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/counterup/jquery.waypoints.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/counterup/jquery.counterup.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/amcharts.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/serial.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/pie.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/radar.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/themes/light.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/themes/patterns.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amcharts/themes/chalk.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/amcharts/amstockcharts/amstock.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/fullcalendar/fullcalendar.min.js" type="text/javascript"></script>
        <!-- PLOT CHAT ，考虑后续CHAT的选型 -->
        <script src="${ctx }/resource/global/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery-easypiechart/jquery.easypiechart.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery.sparkline.min.js" type="text/javascript"></script>

 		<script src="${ctx }/resource/global/plugins/boostrap-table/bootstrap-table.js" type="text/javascript"></script>
 		<SCRIPT SRC="${ctx }/resource/global/plugins/boostrap-table/bootstrap-table-fixed-columns.js" TYPE="TEXT/JAVASCRIPT"></SCRIPT>
 		<script src="${ctx }/resource/global/scripts/datatable_bt.js?Version=5" type="text/javascript"></script>
 		<script src="${ctx }/resource/global/plugins/bootstrap-confirmation/bootstrap-confirmation.js" type="text/javascript"></script>
 		<script src="${ctx }/resource/global/plugins/bootstrap-toastr/toastr.min.js" type="text/javascript"></script>
 		<script src="${ctx }/resource/global/plugins/bootstrap-select/js/bootstrap-select.js" type="text/javascript"></script>
 		<script src="${ctx }/resource/global/plugins/bootstrap-fileinput/bootstrap-fileinput.js" type="text/javascript"></script>
 		<script src="${ctx }/resource/global/plugins/jquery-pinyin/jQuery.Hz2Py-min.js" type="text/javascript"></script>
 		<script src="${ctx }/resource/global/plugins/ion.rangeslider/js/ion.rangeSlider.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jstree/js/jstree.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/jquery-validation/js/additional-methods.js" type="text/javascript"></script>
 		 <!-- DMS 相关JS 信息 start -->
 		<script src="${ctx }/resource/global/scripts/validate.js" type="text/javascript"></script>
		<script src="${ctx }/resource/global/scripts/pageCommon.js?Version=24" type="text/javascript"></script>
        <script src="${ctx }/resource/layouts/global/scripts/quick-sidebar.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/app.js" type="text/javascript"></script>
        <script src="${ctx }/resource/pages/scripts/dashboard.js" type="text/javascript"></script>
        <script src="${ctx }/resource/layouts/layout/scripts/layout.js?version=5" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/dict.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/index.js?Version=3" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/bussiness.js?version=5" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/gfk_bussiness.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/repairOrder_fn.js" type="text/javascript"></script>
        
        <!-- 富文本编辑器 相关JS信息 -->
        <script src="${ctx }/resource/uEditor/ueditor.config.js" type="text/javascript"></script>
        <script src="${ctx }/resource/uEditor/ueditor.all.js" type="text/javascript"></script>
        <script src="${ctx }/resource/uEditor/lang/zh-cn/zh-cn.js" type="text/javascript"></script>
        
        <!-- ztree 树形菜单 相关JS信息 -->
        <script src="${ctx }/resource/ztree/jquery.ztree.core.js" type="text/javascript"></script>
        <script src="${ctx }/resource/ztree/jquery.ztree.excheck.js" type="text/javascript"></script>
        <script src="${ctx }/resource/ztree/jquery.ztree.exedit.js" type="text/javascript"></script>
        
       <%--  <!-- 图片插件 -->
        <script src="${ctx }/resource/picPlay/js/viewer.min.js" type="text/javascript"></script>
        
        <script src="${ctx }/resource/SweetAlert/js/dialog.js"></script> --%>
        <!-- 多页签 -->
        <script src="${ctx }/resource/global/plugins/bootstrap-tabdrop/js/bootstrap-tabdrop.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-contextmenu/bootstrap-contextmenu.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/plugins/bootstrap-tagsinput/bootstrap-tagsinput.min.js" type="text/javascript"></script>
        <!-- i18n -->
        <script src="${ctx }/resource/global/plugins/jquery.i18n.properties.min.js" type="text/javascript"></script>
        <script src="${ctx }/resource/global/scripts/i18n_properties.js" type="text/javascript"></script>
         <!-- 弹出框 -->
        <!--<script src="${ctx }/resource/SweetAlert/js/sweetalert2.min.js"></script> -->
        
		<!-- DMS 相关JS 信息 end -->