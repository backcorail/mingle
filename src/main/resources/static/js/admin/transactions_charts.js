// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

document.addEventListener("DOMContentLoaded", function() {
    // boardListData에서 지역별 데이터를 집계
    var countMap = boardListData.reduce(function(acc, resell) {
        var addr = resell.resell_addr;
        acc[addr] = (acc[addr] || 0) + 1;
        return acc;
    }, {});

    var labels = Object.keys(countMap);
    var data = Object.values(countMap);

    var ctx = document.getElementById("countAreaChart");
    var myPieChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                data: data,
                backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
            }],
        },
    });
});