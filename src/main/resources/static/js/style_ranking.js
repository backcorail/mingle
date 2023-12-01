// 더보기 (순서 오류로 jsp에 직접 넣음)
document.getElementById('moreview1').addEventListener('click', function() {
	var boardListNowHidden = this.parentElement.getElementsByClassName('board_list_now_hidden')[0];
	if (boardListNowHidden.style.display == 'none' || boardListNowHidden.style.display == '') {
		boardListNowHidden.style.display = 'flex';
		this.textContent = '접기';
	} else {
		boardListNowHidden.style.display = 'none';
		this.textContent = '더보기';
	}
});
