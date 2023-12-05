/* 그 유효성 검사 */
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

    if (content.length < 10) {
        alert("내용은 최소 10자 이상이어야 합니다.");
        return false;
    }

    return true;
}