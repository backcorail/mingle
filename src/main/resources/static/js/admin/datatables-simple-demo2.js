$(document).ready(function() {
    // Products Data AJAX 요청
    $.ajax({
        url: '/mingle/admintest/products_data',
        type: 'GET',
        success: function(data) {
            var productsListContent = $(data).find('#products_list').html();
            $('#products_data_container').html(productsListContent);

            const datatablesSimple = document.getElementById('datatablesSimple');
            if (datatablesSimple) {
                new simpleDatatables.DataTable(datatablesSimple);
            }
        },
        error: function(xhr, status, error) {
            console.error("Error: " + status + " - " + error);
        }
    });

    // Members Charts AJAX 요청
    $.ajax({
        url: '/mingle/admintest/members_charts',
        type: 'GET',
        success: function(data) {
            $('#members_Charts_container').html($(data).find('#total_users').html());
        },
        error: function(xhr, status, error) {
            console.error("Error: " + status + " - " + error);
        }
    });
});
