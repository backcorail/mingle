var dataCheck = function(){
	if(document.getElementById("subject").value==""){
		alert("제목을 입력하세요...");
		return false;
	}
	if(document.getElementById("content").value.length == 0){
		alert("내용을 입력하세요...");
		return false;
	}
	if(!($('input:radio[name=request_type]').is(':checked'))){
		alert("글종류를 선택하세요...");
		return false;
	}
	let fileCount = 0;
	$("input[name=filename]").each(function(){
		if($(this).val()!=""){
			fileCount++;
		}
	});
	return true;
}