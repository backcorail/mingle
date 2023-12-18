/* 그 유효성 검사 */
function validateForm() {
    var title = document.getElementById("style_subject").value;
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

/* 현재 날짜 */
let today = new Date();

let year = today.getFullYear(); // 년도
let month = today.getMonth() + 1;  // 월
let date = today.getDate();  // 날짜
let hours = today.getHours(); // 시
let minutes = today.getMinutes();  // 분

var nowDate = year+"-"+month+"-"+date+" "+hours+":"+minutes;
console.log(nowDate);
document.getElementById("datetime").innerText = nowDate;