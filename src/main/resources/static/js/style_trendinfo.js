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