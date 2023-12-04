// 이미지 업로드
function getImageFiles(e) {
  const uploadFiles = [];
  const files = e.currentTarget.files;
  const imagePreview = document.querySelector('.image_preview');
  const docFrag = new DocumentFragment();
  $(".image_preview").text("");
  if ([...files].length >= 7) {
    alert('이미지는 최대 6개 까지 업로드가 가능합니다.');
    return;
  }

  // 파일 타입 검사
  [...files].forEach(file => {
    if (!file.type.match("image/.*")) {
      alert('이미지 파일만 업로드가 가능합니다.');
      return
    }

    // 파일 갯수 검사
    if ([...files].length < 7) {
      uploadFiles.push(file);
      const reader = new FileReader();
      reader.onload = (e) => {
        const preview = createElement(e, file);
        imagePreview.appendChild(preview);
      };
      reader.readAsDataURL(file);
    }
  });
}

function createElement(e, file) {
  const li = document.createElement('li');
  const img = document.createElement('img');
  li.setAttribute('class', 'swiper-slide');
  img.setAttribute('src', e.target.result);
  img.setAttribute('data-file', file.name);
  img.setAttribute('class', 'uploadImg');
  li.appendChild(img);

  return li;
}

const realUpload = document.querySelector('.real-upload');
const upload = document.querySelector('.upload');

upload.addEventListener('click', () => realUpload.click());
realUpload.addEventListener('change', getImageFiles);


/*슬라이더*/
/*슬라이드 기능*/
var slides = document.querySelectorAll('.uploadImg');
var slideShow = document.querySelector('.image_preview');
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