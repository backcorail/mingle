// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example

document.addEventListener("DOMContentLoaded", function() {
	
	// userCount 데이터 읽기
	var countUsersElement = document.getElementById('countUsersData');
	var countUsers = parseInt(countUsersElement.dataset.countUsers);
	console.log("Count Users: ", countUsers);
	
	// genderCount 데이터 읽기
    var genderDataElement = document.getElementById('countUsersGender');
    var maleCount = parseInt(genderDataElement.dataset.maleCount);
    var femaleCount = parseInt(genderDataElement.dataset.femaleCount);

	// 유저수 차트 구성
	var ctx = document.getElementById("membersCharts");
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
			}],
		},
		options: {
			scales: {
				xAxes: [{
					time: {
						unit: 'date'
					},
					gridLines: {
						display: false
					},
					ticks: {
						maxTicksLimit: 7
					}
				}],
				yAxes: [{
					ticks: {
						min: 0,
						max: 10,
						maxTicksLimit: 5
					},
					gridLines: {
						color: "rgba(0, 0, 0, .125)",
					}
				}],
			},
			legend: {
				display: false
			}
		}
	});
	
	// 성별 차트 구성
    var ctx = document.getElementById("GenderCharts");
	console.log(document.getElementById("GenderCharts"))
	var myPieChart = new Chart(ctx, {
  		type: 'pie',
  		data: {
    		labels: ["남성", "여성"],
    		datasets: [{
      		data: [maleCount, femaleCount],
      		backgroundColor: ['#007bff', '#dc3545']
    }],
  },
});
});