document.addEventListener('keydown', function(event) {
  // CSS 변수 값 가져오기
  console.log("키 이벤트 발생");
  // 변수 값으로 변경
  let defaultSize = parseFloat(getComputedStyle(document.documentElement).getPropertyValue('--default-size'));
  // font 값으로 변경
  let htmlElement = document.documentElement;
  let currentFontSize = parseFloat(getComputedStyle(htmlElement).fontSize);

  // Ctrl + 화살표 위/아래 (값 증가 또는 감소)
  if (event.ctrlKey && (event.key === 'ArrowUp' || event.key === 'ArrowDown')) {
    // 화살표 위이면 증가, 화살표 아래이면 감소
    if (event.key === 'ArrowUp') {
      defaultSize += 0.05;
      currentFontSize += 1;
    } else {
      defaultSize -= 0.05;
      currentFontSize -= 1;
    }

    // CSS 변수 업데이트
    document.documentElement.style.setProperty('--default-size', defaultSize.toString());
    // CSS 폰트 업데이트
    htmlElement.style.fontSize = currentFontSize + 'px';
  }

  // Ctrl + Enter (현재 값 알림)
  if (event.ctrlKey && event.key === 'Enter') {
    alert(`현재 --default-size 값: ${defaultSize.toFixed(2)} \n 현재 font-size 값: ${currentFontSize}px`);
  }
});