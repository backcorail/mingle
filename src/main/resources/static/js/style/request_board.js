/*
//ajax를 이용한 댓글등록, 수정, 삭제, 목록
	$(function() {
		//목록
		function replyList() {
			$.ajax({
				url:'${pageContext.servletContext.contextPath}/request_boardReply/list',
				data:{no:${vo.boardno}},
				type: "GET",
				success:function(result){
					console.log(result);
					
					var tag = ""; //댓글목록 태그(수정, 삭제)
					
					$(result).each(function(i, rVO) {
						tag += '<div class="comment_view"><div class="info">';
						tag += '<dl><dt>글쓴이　</dt><dd id="comment_author">' + rVO.userid + '</dd></dl>';
						tag += '<dl><dt>작성일　</dt><dd id="comment_date">' + rVO.writedate + '</dd></dl>';
 
						//수정, 삭제버튼은 로그인 아이디와 댓글쓴이의 아이디가 같을때
						//goguma == 'goguma'
						if ('${logId}' == rVO.userid) {
							tag += "<input type='button' value='Edit'/>";
							tag += "<input type='button' value='Del' title='"+rVO.replyno+"'/>";
													
							tag += "<div class = 'comment_output' id = 'comment_content'>" + rVO.content + "</div></div>"; //댓글내용
							
							//수정폼 -> 댓글 글번호, 댓글내용이 폼에 있어야함.
							tag += "<div style = 'display: none'><form method = 'post'>";
							tag += "<input type='hidden' name='replyno' value='"+ rVO.replyno +"'/>";
							tag += "<textarea name='content' style='width: 400px; height: 80px;'>" + rVO.content + "</textarea>";
							tag += "<input type='submit' value='댓글수정하기'/>";
							tag += "</form></div>";
						} else {
							tag += "<div class = 'comment_output' id = 'comment_content'>" + rVO.content + "</div></div>"; //댓글내용
						}
						tag += "</li>";
					});
					
					$("#replyList").html(tag);
				},
				error:function(e){
					console.log(e.responseText);
				}
			});
		}
		//등록
		$("#replyForm").submit(function() {
			//form태그의 action을 중지한다.
			event.preventDefault();
			
			//content 입력확인
			if($("#comment_input").val()=="") {
				alert("댓글을 입력 후, 등록하세요..");
				return false;
			}
			//form의 데이터를 query로 만들기 n=39&content=예쁘네
			var params = $(this).serialize();
					 //= "no" = + $("no").val() + "&content = " + $("#content").val()
				$.ajax({
					url: "/campus/qna_boardReply/write",
					data: params,
					type: "POST",
					success:function(result) {
						console.log(result);
						$("#comment_input").val("");
						replyList();
						//목록 새로 출력
					},
					error:function(e) {
						console.log(e.responseText);
					}
				});
		});
		//수정폼 보여주기
		$(document).on('click','#replyList input[value=Edit]',function() {
			$(this).parent().css('display','none'); //부모숨기기 : 댓글내용
			$(this).parent().next().css('display','block'); //댓글수정
		});
		// 수정(DB)
		$(document).on('submit', '#replyList form', function() {
			event.preventDefault();
			var params = $(this).serialize();
			var url = "${pageContext.servletContext.contextPath}/qna_boardReply/editOk";
			
			$.ajax({
				url: url,
				data: params,
				type: 'POST',
				success:function(result) {
					console.log(result);
					if(result == '0') { // 댓글 수정 실패
						alert("댓글이 수정실패되었습니다.");
					}else {
						replyList(); // 댓글목록 다시 선택
					}
				},
				error:function(error) {
					console.log(error.responseText);
				}
			});
		});
		
		// 댓글삭제
		$(document).on('click', '#replyList input[value=Del]', function() {
			if(confirm("삭제하시겠습니까?")){
				// 삭제할 레코드번호
				var replyno = $(this).attr("title");
				
				$.ajax({
					url: "${pageContext.servletContext.contextPath}/qna_boardReply/delete",
					data: {
						replyno: replyno
					},
					type: "GET",
					success:function(result) {
						replyList(); // 댓글 목록 다시 뿌리기
					},
					error:function(e) {
						console.log(e.responseText);
					}
				});
			}
		});
		// 목록출력 함수 호출
		replyList();
	});
**/