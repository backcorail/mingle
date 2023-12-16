<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Dashboard - SB Admin</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="/mingle/css/admin/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="/mingle/admintest">Mingle</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->
		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
<!-- 			<div class="input-group">
				<input class="form-control" type="text" placeholder="Search for..."
					aria-label="Search for..." aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="button">
					<i class="fas fa-search"></i>
				</button>
			</div> -->
		</form>
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
<!-- 					<li><a class="dropdown-item" href="#!">Settings</a></li>
					<li><a class="dropdown-item" href="#!">Activity Log</a></li>
					<li><hr class="dropdown-divider" /></li> -->
					<li><a class="dropdown-item" href="/mingle/myadmin/logout">Logout</a></li>
				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="/mingle/admintest">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Dashboard
						</a>
						<!-- Members 메뉴 -->
						<div class="sb-sidenav-menu-heading">Interface</div>
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseMembers" aria-expanded="false"
							aria-controls="collapseMembers">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Members
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<!-- Members 하위 메뉴 -->
						<div class="collapse" id="collapseMembers"
							aria-labelledby="headingMembers"
							data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/mingle/admintest/members_data">Members Data</a>
								<a class="nav-link" href="/mingle/admintest/members_charts">Members Charts</a>
								<!-- 더 많은 하위 메뉴 항목들 추가 가능 -->
							</nav>
						</div>
						<!-- Products 메뉴 -->
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseProducts" aria-expanded="false"
							aria-controls="collapseProducts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Products
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<!-- Products 하위 메뉴 -->
						<div class="collapse" id="collapseProducts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/mingle/admintest/products_data">Products Data</a>
							</nav>
						</div>
						<!-- Transactions 메뉴 -->
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseTransactions" aria-expanded="false"
							aria-controls="collapseTransactions">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Transactions
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<!-- Transactions 하위 메뉴 -->
						<div class="collapse" id="collapseTransactions"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/mingle/admintest/transactions_data">Transactions Data</a>
								<a class="nav-link" href="/mingle/admintest/transactions_charts">Transactions Charts</a>
							</nav>
						</div>
						<!-- Posts 메뉴 -->
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapsePosts" aria-expanded="false"
							aria-controls="collapsePosts">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Posts
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<!-- Posts 하위 메뉴 -->
						<div class="collapse" id="collapsePosts"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/mingle/admintest/posts_data">Posts Data</a>
							</nav>
						</div>
						<!-- Recommend 메뉴 -->
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseRecommend" aria-expanded="false"
							aria-controls="collapseRecommend">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Recommend
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<!-- Recommend 하위 메뉴 -->
						<div class="collapse" id="collapseRecommend"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/mingle/admintest/layout_static">Recommend Write</a>
							</nav>
						</div>
						<!-- Server 메뉴
						<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
							data-bs-target="#collapseServer" aria-expanded="false"
							aria-controls="collapseServer">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Server
							<div class="sb-sidenav-collapse-arrow">
								<i class="fas fa-angle-down"></i>
							</div>
						</a>
						<!-- Recommend 하위 메뉴
						<div class="collapse" id="collapseServer"
							aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
							<nav class="sb-sidenav-menu-nested nav">
								<a class="nav-link" href="/mingle/admintest/layout_static">Server Data</a>
								<a class="nav-link" href="/mingle/admintest/layout_static">Server settings</a>
							</nav>
						</div> -->
					</div>
				</div>
<!-- 				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div> -->
			</nav>
		</div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Members Charts</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="/mingle/admintest">Dashboard</a></li>
                            <li class="breadcrumb-item active">Members Charts</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                총 회원 수를 확인할 수 있습니다.
                                변동이 있을 시 반영되고 업데이트 날짜가 갱신됩니다.
                            </div>
                        </div>
                        <div id="total_users">
	                        <div class="card mb-4">
	                            <div class="card-header">
	                                <i class="fas fa-chart-area me-1"></i>
	                                Total Users
	                            </div>
	                            <!-- userCount 데이터 저장 -->
	                            <div id="countUsersData" data-count-users="${userCount}"></div>
	                            <div class="card-body"><canvas id="membersCharts" width="100%" height="30"></canvas></div>
	                            <div class="card-footer small text-muted">Updated ${currentDateTime}</div>
	                    </div>
	                        </div>
	                        <div class="row">
	                            <div class="col-lg-6">
	                                <div class="card mb-4">
	                                    <div class="card-header">
	                                        <i class="fas fa-chart-bar me-1"></i>
	                                        Bar Chart Example
	                                    </div>
	                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="50"></canvas></div>
	                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
	                                </div>
	                            </div>
	                            <div class="col-lg-6">
	                                <div class="card mb-4">
	                                    <div class="card-header">
	                                        <i class="fas fa-chart-pie me-1"></i>
	                                        Pie Chart Example
	                                    </div>
	                                    <div class="card-body"><canvas id="myPieChart" width="100%" height="50"></canvas></div>
	                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </main>
	            </div>
	        </div>
	        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
	        <script src="/mingle/js/admin/scripts.js"></script>
	        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
			<script src="/mingle/js/admin/members_charts.js"></script>
	        <script src="/mingle/js/admin/chart-bar-demo.js"></script>
	        <script src="/mingle/js/admin/chart-pie-demo.js"></script>
	    </body>
	</html>
