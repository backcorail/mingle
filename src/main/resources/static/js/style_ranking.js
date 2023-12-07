


// 더보기 (순서 오류로 jsp에 직접 넣음)
$('#moreview1').on('click', function() {
    var boardListNowHidden = $(this).parent().find('.board_list_now_hidden').first();
    if (boardListNowHidden.css('display') == 'none' || boardListNowHidden.css('display') == '') {
        boardListNowHidden.css('display', 'flex');
        $(this).text('접기');
    } else {
        boardListNowHidden.css('display', 'none');
        $(this).text('더보기');
    }
});


