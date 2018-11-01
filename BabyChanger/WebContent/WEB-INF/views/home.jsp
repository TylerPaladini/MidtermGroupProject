<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Te igitur in puppi deturbat</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Amatic+SC">

<style>
body, html {
	height: 100%
}

body, h1, h2, h3, h4, h5, h6 {
	font-family: "Amatic SC", sans-serif
}

.menu {
	display: none
}

.bgimg {
	background-repeat: no-repeat;
	background-size: cover;
	background-image:
		url("https://media.giphy.com/media/tJ4oUTsMHbqAZyqsBo/giphy.gif");
	min-height: 90%;
}
</style>
<body>
<%@ include file="newNav.jsp"%>

	<%-- <!-- Navbar (sit on top) -->
	<div class="w3-top w3-hide-small">
		<div class="w3-bar w3-xlarge w3-black w3-opacity w3-hover-opacity-off"
			id="myNavbar">
			<a href="home.do" class="w3-bar-item w3-button">HOME</a>

			<c:if test="${empty loggedIn }">
				<a href="loginPage.do" class="w3-bar-item w3-button">Login</a>
				<a href="registerPage.do" class="w3-bar-item w3-button">Register</a>

			</c:if>

			<c:if test="${not empty loggedIn }">
				<c:if test="${loggedIn.admin }">
				<a href="profileAdmin.do" class="w3-bar-item w3-button">Admin Profile</a>
				</c:if>
				
				<c:if test="${!loggedIn.admin }">
				<a href="profileUser.do" class="w3-bar-item w3-button">User Profile</a>
				</c:if>

				<a href="logout.do" class="w3-bar-item w3-button">Logout</a>
			</c:if>	
		</div>
	</div> --%>

	<!-- Header with image -->
	<header class="bgimg w3-display-container w3-grayscale-min" id="home">
		<div class="w3-display-bottomleft w3-padding">
			<span class="w3-tag w3-xlarge">Open 24/7 because babies don't
				sleep on your time</span>
		</div>
		<div class="w3-display-middle w3-center">
			<span class="w3-text-white w3-hide-small" style="font-size: 100px">BABY
				CHANGER</span>
			<!--     <span class="w3-text-white w3-hide-large w3-hide-medium" style="font-size:60px"><b>thin<br>CRUST PIZZA</b></span>
 -->
			<!--     <p><a href="#menu" class="w3-button w3-xxlarge w3-black">Let me see the menu</a></p> -->

			<form action="getLocationsByKeywordSearch.do" method="GET">
				<input type="search" name="keyword" size="50" /> <input
					type="submit" name="search" value="Search" />
			</form>
			<br>

			<form action="searchOpenLocations.do">
				<input type="Submit" value="Open Locations" />
			</form>

			<c:if test="${not empty loggedIn}">
				<form action="userAddsAddressLocationRestroom.do">
					<input type="Submit" value="Add Location" />
				</form>
			</c:if>
		</div>
	</header>

	<!-- Menu Container -->
	<div class="w3-container w3-black w3-padding-64 w3-xxlarge" id="menu">
		<div class="w3-content">

			<h1 class="w3-center w3-jumbo" style="margin-bottom: 64px">THE
				TEAM</h1>
			<div class="w3-row w3-center w3-border w3-border-dark-grey">
				<a href="javascript:void(0)" onclick="openMenu(event, 'Pizza');"
					id="myLink">
					<div class="w3-col s4 tablink w3-padding-large w3-hover-red">MEET</div>
				</a>
				<!--  <a href="javascript:void(0)" onclick="openMenu(event, 'Pasta');"> -->
				<div class="w3-col s4 tablink w3-padding-large w3-hover-red">OUR</div>
				</a>
				<!--      <a href="javascript:void(0)" onclick="openMenu(event, 'Starter');"> -->
				<div class="w3-col s4 tablink w3-padding-large w3-hover-red">TEAM</div>
				</a>
			</div>

			<div id="Pizza" class="w3-container menu w3-padding-32 w3-white">
				<h1>
					<b>Zach Lamb, SCRUM MASTER</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="https://vignette.wikia.nocookie.net/marvelcentral/images/9/97/Tony-Stark.jpg/revision/latest?cb=20130429010603"
						height=150 width=150></span>
				</h1>
				<p class="w3-text-grey">The best of us, chosen by the
					powers that be to lead our motley crue.</p>
				<hr>

				<h1>
					<b>Joshua Ciccone-Okodo, Tech God</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="https://cdn1.thr.com/sites/default/files/imagecache/scale_crop_768_433/2011/04/thor-gallery-1-2011-a-l.jpg"
						height=150 width=250></span>
				</h1>
				<p class="w3-text-grey">Josh is the strong, silent type. Leading
					by coding.</p>
				<hr>

				<h1>
					<b>Tyler Paladini, Enforcer</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="https://cdn.vox-cdn.com/thumbor/qYKuikX8VynuXPGDXNcQ7F67CMo=/0x0:1025x657/1820x1213/filters:focal(405x159:569x323):format(webp)/cdn.vox-cdn.com/uploads/chorus_image/image/54719431/judgedredd.0.jpg"
						height=150 width=250></span>
				</h1>
				<p class="w3-text-grey">Tyler is the law!</p>
				<hr>

				<h1>
					<b>Rob Thompson, DBA</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="https://carboncostume.com/wordpress/wp-content/uploads/2013/03/miltonwaddams.jpg"
						height=150 width=250></span>
				</h1>
				<p class="w3-text-grey">Rob loves the command line.</p>
				<hr>
			</div>

		</div>
	</div>

	<!-- About Container -->
	<div class="w3-container w3-padding-64 w3-red w3-grayscale w3-xlarge"
		id="about">
		<div class="w3-content">
			<h1 class="w3-center w3-jumbo" style="margin-bottom: 64px">About</h1>
			<p>Baby Changer was born of a cross crounty road trip. The story
				goes that Zach and Gretchen were...</p>


		</div>
	</div>

	<!-- Contact -->
	<div
		class="w3-container w3-padding-64 w3-blue-grey w3-grayscale-min w3-xlarge">
		<div class="w3-content">
			<h1 class="w3-center w3-jumbo" style="margin-bottom: 64px">Contact</h1>
			<p>Find us at some address at some place or call us at
				05050515-122330</p>
			<p class="w3-xxlarge">Information is not warranted. It's
				crowdsourced, what do you expect?</p>
			<form action="/action_page.php" target="_blank">
				<p>
					<span class="w3-tag">Send us a message below! 
				</p>
				<p>
					<input class="w3-input w3-padding-16 w3-border" type="text"
						placeholder="Name" required name="Name">
				</p>
				<p>
					<input class="w3-input w3-padding-16 w3-border" type="text"
						placeholder="Message \ How can we help?" required name="Message">
				</p>
				<p>
					<button class="w3-button w3-light-grey w3-block" type="submit">SEND
						MESSAGE</button>
				</p>
			</form>
		</div>
	</div>

	<!-- Footer -->
	<footer class="w3-center w3-black w3-padding-48 w3-xxlarge">
		<p>
			Powered by <a href="https://www.w3schools.com/w3css/default.asp"
				title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a>
		</p>
	</footer>

	<script>
		// Tabbed Menu
		function openMenu(evt, menuName) {
			var i, x, tablinks;
			x = document.getElementsByClassName("menu");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < x.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" w3-red", "");
			}
			document.getElementById(menuName).style.display = "block";
			evt.currentTarget.firstElementChild.className += " w3-red";
		}
		document.getElementById("myLink").click();
	</script>

</body>
</html>


