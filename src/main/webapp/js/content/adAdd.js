$(function() {
	common.showMessage($("#message").val());
	$("#mainForm").validate({
		rules : {
			"title" : "required",
			"link" : "required",
			"weight" : {
				required : true,
				digits : true,
				maxlength : 5
			}
		},
		messages : {
			"title" : "请输入标题！",
		}
	});
});

function add() {
	if(check()) {
		$("#mainForm").submit();
	}
}

function check() {
	// TODO 需要添加表单验证
	return true;
}

function goback() {
	location.href = $('#basePath').val() + '/ad';
}