$(document).ready(function() {
    $.ajax({
        url: '/mingle/admintest/products_data', // 서버의 매핑 주소
        type: 'GET',
        success: function(data) {
            // 가져온 데이터에서 <main> 태그 내부의 내용만 추출하여 삽입
            var productsListContent = $(data).find('#products_list').html();
            $('#products_data_container').html(productsListContent);

            // Simple-DataTables 초기화 (불러온 데이터 안에 테이블이 있다면)
            const datatablesSimple = document.getElementById('datatablesSimple');
            if (datatablesSimple) {
                new simpleDatatables.DataTable(datatablesSimple);
            }
        },
        error: function(xhr, status, error) {
            console.error("Error: " + status + " - " + error);
        }
    });
});
