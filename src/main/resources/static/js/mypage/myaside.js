/*mypage main*/
const mymain = document.querySelector(".div-my-page");
/*마이페이지*/
const edit_user = document.querySelector(".div-edit-user");
/*쇼핑벙보*/
const buy_data = document.querySelector(".div-buy-data");
const sell_data = document.querySelector(".div-sell-data");
const my_basket = document.querySelector(".div-my-basket");
/*내활동*/
const myboard = document.querySelector(".div-myboard");
const myreply = document.querySelector(".div-myreply");
const favo = document.querySelector(".div-favo");
const scrap = document.querySelector(".div-scrap");

/*mypage main*/
mymain.onclick = function() { console.log("mymain clicked!");
    location.href="/mingle/mypage/mymain" };
/*마이페이지*/
edit_user.onclick = function() { console.log("edit_user clicked!");
    location.href="/mingle/mypage/myedit" };

/*쇼핑벙보*/
buy_data.onclick = function() {   console.log("buy_data clicked!");
	location.href="/mingle/mypage/mybuylist" };
sell_data.onclick = function() {   console.log("sell_data clicked!");
	location.href="/mingle/mypage/myselllist"	};
my_basket.onclick = function() { console.log("my_basket clicked!");
	location.href="/mingle/mypage/mybasket"	};

/*내활동*/
myboard.onclick = function() {console.log("myboard clicked!");
	location.href="/mingle/mypage/myboard"	};
myreply.onclick = function() {console.log("myreply clicked!");
	location.href="/mingle/mypage/myreply"	};
favo.onclick = function() {console.log("favo clicked!");
	location.href="/mingle/mypage/myfavo" };
scrap.onclick = function() {console.log("scrap clicked!");
	location.href="/mingle/mypage/myscrap" };