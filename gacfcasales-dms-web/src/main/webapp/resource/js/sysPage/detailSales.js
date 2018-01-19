$(function(){
	var rbrandId = $("#rbrandId").val();
	var rbrandCode = $("#rbrandCode").val();
	var rbrandName = $("#rbrandName").val();
	var rseriesId = $("#rseriesId").val();
	var rseriesCode = $("#rseriesCode").val();
	var rseriesName = $("#rseriesName").val();
	var rmodelId = $("#rmodelId").val();
	var rmodelName = $("#rmodelName").val();
	var rmodelCode = $("#rmodelCode").val();
	var rapackageId = $("#rapackageId").val();
	var rapackage = $("#rapackage").val();
	var rapackageName = $("#rbrandName").val();
	
	
	if(rbrandId != ''){
		$("#brandId").append("<option selected='selected' value='"+rbrandId+"'>"+rbrandName+"</option>");
	}
	if(rseriesId != ''){
		$("#seriesId").append("<option selected='selected' value='"+rseriesId+"'>"+rseriesName+"</option>");
	}
	if(rmodelId != ''){
		$("#modelId").append("<option selected='selected' value='"+rmodelId+"'>"+rmodelName+"</option>");
	}
	if(rapackageId != ''){
		$("#apackage").append("<option selected='selected' value='"+rapackageId+"'>"+rapackageName+"</option>");
	}
	
});