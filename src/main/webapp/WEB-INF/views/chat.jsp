<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<head>
    <title>Chat Room</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<div id="root">
	<div id="chatRoom">
		<div id="chatHeader">
			<div id="partnerProfile">
				<div id="profileImg_container">
					<img id="partnerImg" src="" alt="">
					<c:choose>
						<c:when test="${empty authUser }">
							<div class="loginStatus" id="loginStatus_F"></div>
						</c:when>
						<c:otherwise>
							<div class="loginStatus" id="loginStatus_Y"></div>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="partnerNick">${authUser.userVO.user_nick}</div>
			</div>
			<div id="X_close" onclick="showChatlist()"><img src="/mingle/img/home/icon_more.png"/></div>
		</div>
		<div id="chatContent"></div>
		<form id="chatBottom">
			<textarea id="messageInput" placeholder="Type your message here..." oninput="toggleSendButton()"></textarea>
			<button id="sendButton" onclick="sendMessage()" disabled>SEND</button>
			<!-- <input id="sendButton" type="submit" value="SEND"/> -->
		</form>
	</div>
	<div id="chatList" style="display: none;">
		<div id="header_list">
			<div id="title_list">Messages</div>
			<div id="chatOut" onclick="closeChat()">out ></div>
		</div>
		<div id="content_list">
			<!--
			<div class="RoomContent">
				<div id="Room_profile">
					<div id="roomImg_container">
						<img id="roomImg" src="${!empty authUser.userVO.user_img ? authUser.userVO.user_img : '/mingle/img/user/profileEX.png'}" alt="">
						<c:choose>
							<c:when test="${empty authUser }">
								<div class="loginStatus_2" id="roomLoginStatus_F"></div>
							</c:when>
							<c:otherwise>
								<div class="loginStatus_2" id="roomLoginStatus_Y"></div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div id="middle_RoomContent">
					<div id="roomTilte">${authUser.userVO.user_nick}</div>
					<div id="roomLastChat">그럼 12:30 압구정로데오역 3번출구에서 뵙겠습니다.</div>
				</div>
				<div id="roomChatTime">오전 12:30</div>
			</div>
			-->
		</div>
	</div>
</div>
<script type="text/javascript">
	var stompClient = null;
	var userId = "${authUser.userVO.user_id}";

	// 웹소켓 연결 함수
	function connect() {
	    var socket = new SockJS('${pageContext.request.contextPath}/chat');
	    stompClient = Stomp.over(socket);
	    stompClient.connect({}, function(frame) {
	        console.log('Connected: ' + frame);
	        stompClient.subscribe('/topic/messages', function(messageOutput) {
	            showMessage(JSON.parse(messageOutput.body));
	        });
	    });
	}
	
	// 메시지 전송 함수
	function sendMessage() {
	    var input = document.getElementById('messageInput');
	    var message = {
	        message: input.value.trim(),  // 여기에서 속성명을 서버와 일치시킴
	        user_id: userId               // 여기에서 속성명을 서버와 일치시킴
	    };
	    if (message.message) {
	        stompClient.send("/app/chat", {}, JSON.stringify(message));
	        input.value = '';
	        toggleSendButton();
	    }
	}

	// 저장된 메시지 불러오기
	function loadMessages() {
	    $.ajax({
	        type: 'GET',
	        url: '${pageContext.request.contextPath}/load-messages',
	        success: function(messages) {
	            messages.forEach(function(message) {
	                showMessage(message);
	            });
	        }
	    });
	}
	function loadRoom(){
		$.ajax({
	        type: 'GET',
	        url: '${pageContext.request.contextPath}/load-room',
	        data: {
	            userId: userId
	        },
	        success: function(result) {
	        	var tag = "";
	        	console.log(result);
	        	$(result.rooms).each(function(i, roomVO){
	        		tag += '<div class="RoomContent" onclick="showRoom('+roomVO.room_no+')"><div id="Room_profile"><div id="roomImg_container">';
	        		tag += '<img id="roomImg" src="${pageContext.request.contextPath}/uploadfile/'+roomVO.item_file_name+'"/><div class="loginStatus_2" id="roomLoginStatus_F"></div>';
	        		tag += '</div></div>';
	        		tag += '<div id="middle_RoomContent"><div id="roomTilte">'+roomVO.item_name+'</div><div id="roomLastChat">'+roomVO.item_name+'</div></div>';
	        		tag += '<div id="roomChatTime">오전 12:30</div></div></div>';
	        	});
	        	$('#content_list').html(tag)
		    },
		    error: function(error) {
		        console.error("룸리스트 생성 실패", error);
		    }
	    });
	}
	// 룸 데이터 불러오기
	function showRoom(room_no){
	    $.ajax({
	        type: "GET",
	        url: "/mingle/showChat/" + room_no,
	        success: function(result) {
	            console.log("룸데이터 로딩 성공!!!:", result);  // 전체 result 객체 출력
	            if (result.cvo && Array.isArray(result.cvo)) {  // cvo가 배열인지 확인
	                const partner = result.cvo.map(item => item.user_id)
	                                          .filter(userId => userId !== '${authUser.userVO.user_id}');
	                console.log("Partner IDs:", partner);  // 파트너 ID를 콘솔에 출력
	                showChatroom(partner);
	            } else {
	                console.log("cvo 배열이 비어 있거나 유효하지 않습니다.");
	            }
	        },
	        error: function(error) {
	            console.error("룸로딩 실패", error);
	        }
	    });
	}
	// 룸 데이터 불러오기
	function showRoom(room_no){
	    $.ajax({
	        type: "GET",
	        url: "/mingle/showChat/" + room_no,
	        success: function(result) {
	            console.log("룸데이터 로딩 성공!!!:", result);  // 전체 result 객체 출력
	            if (result.cvo && Array.isArray(result.cvo)) {  // cvo가 배열인지 확인
	                const partner = result.cvo.map(item => item.user_id)
	                                          .filter(userId => userId !== '${authUser.userVO.user_id}');
	                console.log("Partner IDs:", partner);  // 파트너 ID를 콘솔에 출력
	                showChatroom(partner);
	            } else {
	                console.log("cvo 배열이 비어 있거나 유효하지 않습니다.");
	            }
	        },
	        error: function(error) {
	            console.error("룸로딩 실패", error);
	        }
	    });
	}
	function addRoomContent(room_no, room_name) {
        var roomContentHtml = `
            <div class="RoomContent">
                <p>Room No: ${room_no}</p>
                <p>Room Name: ${room_name}</p>
            </div>
        `;
        $("#content_list").append(roomContentHtml);
    }

	// 메시지 출력 함수
	function showMessage(message) {
	    var messages = document.getElementById('chatContent');
	    var messageElement = document.createElement('div');
	    messageElement.className = 'message ' + (message.user_id === userId ? 'my_chat' : 'partner_chat');
	    
	    messageElement.innerText = message.message;
	    messages.appendChild(messageElement);

	    messages.scrollTop = messages.scrollHeight;
	}

	// 전송 버튼 활성화/비활성화 함수
	function toggleSendButton() {
	    var input = document.getElementById('messageInput');
	    var sendButton = document.getElementById('sendButton');
	    sendButton.disabled = !input.value.trim();
	}

	// DOMContentLoaded 이벤트 리스너
	document.addEventListener('DOMContentLoaded', function() {
		if(userId!=null){
			//connect();
		    loadMessages();  // 페이지 로드 시 저장된 메시지 불러오기
		    var input = document.getElementById('messageInput');
		    input.addEventListener('input', toggleSendButton);
		}
	});

</script>