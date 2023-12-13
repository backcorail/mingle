var commentText = ''


/*슬라이드 기능*/
var slides = document.querySelectorAll('.slide');
var slideShow = document.querySelector('.slide-show');
var totalSlides = slides.length;
var slideWidth = slides[0].clientWidth;
var currentIndex = 0;

document.getElementById('prevBtn').addEventListener('click', function() {
  currentIndex = (currentIndex > 0) ? currentIndex - 1 : totalSlides - 1;
  updateSlidePosition();
});

document.getElementById('nextBtn').addEventListener('click', function() {
  currentIndex = (currentIndex < totalSlides - 1) ? currentIndex + 1 : 0;
  updateSlidePosition();
});

function updateSlidePosition() {
  slideShow.style.transform = 'translateX(' + (-slideWidth * currentIndex) + 'px)';
}

/*슬라이드 아래 점 표시*/ 

var pagination = document.querySelector('.pagination');

// 점 만들기
for (var i = 0; i < totalSlides; i++) {
  var dot = document.createElement('div');
  dot.classList.add('dot');
  dot.addEventListener('click', function(dotIndex) {
    return function() {
      currentIndex = dotIndex;
      updateSlidePosition();
    };
  }(i));
  pagination.appendChild(dot);
}

function updateSlidePosition() {
  slideShow.style.transform = 'translateX(' + (-slideWidth * currentIndex) + 'px)';
  
  // 점 업데이트
  var dots = document.querySelectorAll('.dot');
  for (var i = 0; i < dots.length; i++) {
    dots[i].classList.remove('active');
  }
  dots[currentIndex].classList.add('active');
}



// 태그 쪽

/*슬라이드 기능*/
var slides2 = document.querySelectorAll('.tag-slide');
var slideShow2 = document.querySelector('.tag-slide-show');
var totalSlides2 = slides2.length;
var slideWidth2 = slides2[0].clientWidth;
var currentIndex2 = 0;

document.getElementById('tag-prevBtn').addEventListener('click', function() {
  currentIndex2 = (currentIndex2 > 0) ? currentIndex2 - 1 : totalSlides2 - 1;
  updateSlidePosition2();
});

document.getElementById('tag-nextBtn').addEventListener('click', function() {
  currentIndex2 = (currentIndex2 < totalSlides2 - 1) ? currentIndex2 + 1 : 0;
  updateSlidePosition2();
});

function updateSlidePosition2() {
  slideShow2.style.transform = 'translateX(' + (-slideWidth2 * currentIndex2) + 'px)';
}





// 댓글

document.getElementById('reply_btn').addEventListener('click', function() {
    // 댓글 내용을 가져오기
    commentText = document.getElementById('commentInput').value;

    // 새 댓글 생성
    var newComment = document.createElement('div');
    newComment.className = 'comment';
    
    // 새 프로필 사진 생성하고 설정
    var newProfilePic = document.createElement('img');
    newProfilePic.className = 'profile-pic';
    newProfilePic.src = document.getElementById('test').value;// 프로필 사진 경로입니다.
    newProfilePic.alt = 'User Profile Pic';
    newComment.appendChild(newProfilePic);

    // 새 유저 아이디 생성하고 설정
    var newusernic = document.createElement('span');
    newusernic.className = 'usernic';
    newusernic.textContent = document.getElementById('test2').value;
    newComment.appendChild(newusernic);
	
    // 새 댓글 텍스트 생성하고 설정
    var newCommentText = document.createElement('p');
    newCommentText.className = 'comment-text';
    newCommentText.textContent = commentText;
    newComment.appendChild(newCommentText);
    
    // 댓글 보이기
    newComment.style.display = 'block';

    // 댓글을 커멘트박스에 추가
    document.getElementById('comments_box').appendChild(newComment);

    // 댓글내용 초기화
    document.getElementById('commentInput').value = '';
});




// 댓글 db 저장



document.getElementById('reply_btn').addEventListener('click', function() {
    // 댓글 내용과 사용자 ID를 가져옵니다.
    // commentText = document.getElementById('commentInput').value;
    console.log(document.getElementById('commentInput').value);
    var useridText = document.querySelector('#test3').value;
    var stylenoText = 'a'; // 글작성 완성 후 작성
    console.log(document.querySelector('#test3'));
	console.log('확인'+commentText);
	console.log('확인'+useridText);
    // 서버에 POST 요청을 보냅니다.
    fetch('/mingle/style/products_data', { // 
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            userid: useridText,
            comment: commentText,
            styleno : stylenoText
        })
    })
    .then((response)=>{
		// console.log(response.json());
		console.log(response.json());
	})
    .then(data => {
        console.log('Success:', data);
        console.log(JSON.parse(data));
    })
    .catch((error) => {
        console.error('Error:', error);
    });

    // 댓글 내용을 초기화합니다.
    document.getElementById('commentInput').value = '';
    
    location.reload();
});








