$(function() {
	uIreset();
	let selfile = null;
	// 이미지파일 수정
	$('#btn-more-buy').click(function(event) {
		console.log("버튼 클릭됨. 현재 값: ", $(this).val());

		// 현재 페이지의 글 개수 확인
		var currentItemCount = $(".div-eye-items-box").length;

		// 글 개수가 9의 배수가 아니면 더 이상 불러올 내용이 없음
		if (currentItemCount % 12 !== 0) {
			alert("더 이상 불러올 내용이 없습니다.");
		} else {
			// 더 많은 글을 불러오는 함수 실행
			moremysell();
		}
	});

	function uIreset() {
	$('.div-eye-item-script p').removeAttr('style'); // 인라인 스타일 제거
	$('.div-eye-item-script p span').removeAttr('style'); // 인라인 스타일 제거
	$('.div-eye-item-script').css('font-size', '10px'); // 인라인 스타일 재정의

	$('.div-eye-item-script').css('font-size', '12px'); // 여기서 '12px'는 원하는 글자 크기로 변경하세요
	$('.div-eye-item-script p').css({
		'font-size': '8px',
		'overflow': 'hidden',         // 내용이 넘칠 경우 숨깁니다.
		'height': '10px',             // 높이를 설정합니다.
		'margin': '0',
		'padding': '0',
		'display': 'block',           // 블록 레벨 요소로 만듭니다.
		'text-overflow': 'ellipsis',  // 말줄임표를 적용합니다.
		'white-space': 'nowrap'       // 텍스트가 줄 바꿈 없이 한 줄로 표시되도록 합니다.
	});
	$('.div-eye-item-script p span').css({
		'font-size': '8px',
		'overflow': 'hidden',
		'height': '10px',
		'margin': '0',
		'padding': '0',
		'display': 'block',         // 블록 레벨 요소로 만듭니다
		'text-overflow': 'ellipsis', // 말줄임표를 적용합니다
		'white-space': 'nowrap'      // 텍스트가 줄 바꿈 없이 한 줄로 표시되도록 합니다
	});
	}


	function moremysell() {
		const boardLastIndex = {
			resellno: $("#resellno").val(),
		};

		$.ajax({
			url: '/mingle/mypage/mybuylist/add', // 실제 URL로 변경 필요
			type: 'GET',
			data: boardLastIndex,
			success: function(response) {
				console.log(response);

				var newHtml = response.actInfos.map(function(actInfo) {
					return `
                    <div class="div-eye-items-box">
                        <div class="div-eye-item">
                            <img src="/mingle/uploadfile/${actInfo.img}" alt="" class="div-eye-itme">
                            <div class="div-eye-item-title Inika-bold-18" >${actInfo.title}</div>
                            <div class="div-eye-item-script Inika-Regular-16">${actInfo.contents}</div>
                        </div>
                    </div>`;
				}).join('');

				// hidden input 필드의 값을 업데이트
				$("#resellno").val(response.lastmap['리셀']);

				// 생성된 HTML 태그를 페이지에 추가
				$(".div-item-list-area").append(newHtml);
				uIreset();
				
				// 부드러운 스크롤 이동
				$(".div-item-list-area").animate({
					scrollTop: $(".div-item-list-area")[0].scrollHeight
				}, 1000); // 1000은 이동에 걸리는 시간(밀리초)입니다.
			},
			error: function(xhr, status, error) {
				console.error("데이터 전송 실패: ", error);
			}
		});
	}// 정보수정 put 요청
});// 제이쿼리