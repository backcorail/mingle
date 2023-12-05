// 이미지 업로드
function getImageFiles(e) {
  const uploadFiles = [];
  const files = e.currentTarget.files;
  const imagePreview = document.querySelector('.swiper-wrapper');
  const docFrag = new DocumentFragment();
  $(".swiper-wrapper").text("");
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
  const li = document.createElement('div');
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
var swiper = new Swiper(".mySwiper", {
  cssMode: true,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  pagination: {
    el: ".swiper-pagination",
  },
  mousewheel: true,
  keyboard: true,
});


// 태그 쪽
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