$(function() {
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

	let selfile = null;
	// 이미지파일 수정
	$('#btn-more-board').click(function(event) {
		console.log("버튼 클릭됨. 현재 값: ", $(this).val());

		// 현재 페이지의 글 개수 확인
		var currentItemCount = $(".div-track").length;

		// 글 개수가 9의 배수가 아니면 더 이상 불러올 내용이 없음
		if (currentItemCount % 9 !== 0) {
			alert("더 이상 불러올 내용이 없습니다.");
		} else {
			// 더 많은 글을 불러오는 함수 실행
			moremyboard();
		}
	});

	function moremyboard() {
		const boardLastIndex = {
			requestno: $("#requestno").val(),
			styleno: $("#styleno").val(),
			resellno: $("#resellno").val(),
		};
		$.ajax({
			url: '/mingle/mypage/myboard/add', // 실제 URL로 변경 필요
			type: 'GET',
			data: boardLastIndex,
			success: function(response) {
				console.log(response);
				// map을 사용하여 각 actInfo를 HTML 태그로 변환
				var newHtml = response.actInfos.map(function(actInfo) {
					return `
                <div class="div-track">
                    <div class="div-board-cate-area">
                        <div class="div-board-cate Inika-bold-18">${actInfo.type}</div>
                    </div>
                    <div class="div-board-title-area">
                        <a href="http://localhost:9998/mingle/resell/board?no=${actInfo.no}">
                        <div class="div-board-title Inika-Regular-16-l2">${actInfo.title}</div>
                        </a>
                    </div>
                    <div class="div-board-date-area">
                        <div class="div-board-date Inika-Regular-20">${actInfo.writeDate}</div>
                    </div>
                </div>`;
				}).join('');

				// hidden input 필드의 값을 업데이트
				$("#requestno").val(response.lastmap['리퀘스트']);
				$("#styleno").val(response.lastmap['스타일']);
				$("#resellno").val(response.lastmap['리셀']);

				// 생성된 HTML 태그를 페이지에 추가
				var itemListArea = $(".div-item-list-area");
				itemListArea.append(newHtml);
				itemListArea = $(".div-item-list-area");
				itemListArea.animate({
					scrollTop: itemListArea[0].scrollHeight
				}, 1000); // 1000은 이동에 걸리는 시간(밀리초)입니다.

			},
			error: function(xhr, status, error) {
				// 에러 처리
				console.error("데이터 전송 실패: ", error);
			}
		});
	}// 정보수정 put 요청
});// 제이쿼리