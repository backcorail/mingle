$(function() {
	let selfile = null;
	// 이미지파일 수정
	$('#btn-more-reply').click(function(event) {
		console.log("버튼 클릭됨. 현재 값: ", $(this).val());

		// 현재 페이지의 글 개수 확인
		var currentItemCount = $(".div-track").length;

		// 글 개수가 9의 배수가 아니면 더 이상 불러올 내용이 없음
		if (currentItemCount % 9 !== 0) {
			alert("더 이상 불러올 내용이 없습니다.");
		} else {
			// 더 많은 글을 불러오는 함수 실행
			moremyreply();
		}
	});

	function moremyreply() {
		const boardLastIndex = {
			requestno: $("#requestno").val(),
			styleno: $("#styleno").val()
		};
		$.ajax({
			url: '/mingle/mypage/myreply/add', // 실제 URL로 변경 필요
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
					<div class="div-reply-content-area">
						<div class="div-reply-content Inika-Regular-20">${actInfo.contents}</div>
					</div>
					<div class="div-board-date-area">
						<div class="div-board-date Inika-Regular-20">${actInfo.writeDate}</div>
					</div>
				</div>`;
				}).join('');

				// hidden input 필드의 값을 업데이트
				$("#requestno").val(response.lastmap['리퀘스트']);
				$("#styleno").val(response.lastmap['스타일']);

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