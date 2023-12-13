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

    
    // Members Charts AJAX 요청 및 차트 초기화
    $.ajax({
        url: '/mingle/admintest/members_charts',
        type: 'GET',
        success: function(data) {
            var totalUsersContent = $(data).find('#total_users').html();
            $('#members_Charts_container').html(totalUsersContent);

            var countUsersElement = document.getElementById('countUsersData');
            if (countUsersElement) {
                var countUsers = parseInt(countUsersElement.dataset.countUsers);

                if (document.getElementById("membersCharts")) {
                    var ctx = document.getElementById("membersCharts").getContext('2d');
                    var myLineChart = new Chart(ctx, {
                        type: 'line',
                        data: {
                            labels: ["Users"],
                            datasets: [{
                                label: "Total Users",
                                data: [countUsers],
                                lineTension: 0.3,
                                backgroundColor: "rgba(2,117,216,0.2)",
                                borderColor: "rgba(2,117,216,1)",
                                pointRadius: 5,
                                pointBackgroundColor: "rgba(2,117,216,1)",
                                pointBorderColor: "rgba(255,255,255,0.8)",
                                pointHoverRadius: 5,
                                pointHoverBackgroundColor: "rgba(2,117,216,1)",
                                pointHitRadius: 50,
                                pointBorderWidth: 2,
                            }]
                        },
                        options: {
                            scales: {
                                xAxes: [{ time: { unit: 'date' }, gridLines: { display: false }, ticks: { maxTicksLimit: 7 } }],
                                yAxes: [{ ticks: { min: 0, max: 10, maxTicksLimit: 5 }, gridLines: { color: "rgba(0, 0, 0, .125)" } }],
                            },
                            legend: { display: false }
                        }
                    });

                    myLineChart.update();
                }
            } else {
                console.error("Cannot find #countUsersData element");
            }
        },
        error: function(xhr, status, error) {
            console.error("Error: " + status + " - " + error);
        }
    });
});
