
//유효성 검사
function validateForm() {
    var title = document.getElementById("subject").value;
    var content = document.getElementById("content").value;

    if (!title) {
        alert("제목을 입력하세요.");
        return false;
    }

    if (!content) {
        alert("내용을 입력하세요.");
        return false;
    }

    if (content.length < 30) {
        alert("내용은 최소 30자 이상이어야 합니다.");
        return false;
    }

    return true;
}
///////////////////////////////////////////////////



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