<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<title>Te igitur in puppi deturbat</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/body.css">
<link rel="stylesheet" href="css/dancingbaby.css">

<body>
	<%@ include file="newNav.jsp"%>

	<!-- Header with image -->
	<header class="bgimg w3-display-container w3-grayscale-min" id="home">
		<div class="w3-display-bottomleft w3-padding">
			<span class="w3-tag w3-xlarge">Open 24/7 because babies don't
				poo on your time</span>
		</div>
		<div class="w3-display-middle w3-center">
			<span class="w3-text-white w3-hide-small" style="font-size: 100px">BABY
				CHANGER</span>

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
				<a href="javascript:void(0)" onclick="openMenu(event, 'Peeps');"
					id="myLink">
					<div class="w3-col s12 tablink w3-padding-large w3-hover-red">SKILL DISTILLERY TEAM: Steel Assault</div>

					<!-- <div class="w3-col s4 tablink w3-padding-large w3-hover-red">OUR</div>

 					<div class="w3-col s4 tablink w3-padding-large w3-hover-red">TEAM</div> -->
				</a>
			</div>

			<div id="Peeps" class="w3-container menu w3-padding-32 w3-white">
				<h1>
					<b>Zach Lamb, SCRUM MASTER</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="img/tony.jpg"
						height=100 width=100></span>
				</h1>
				<p class="w3-text-grey">The best of us, chosen by the powers
					that be to lead our motley crue.</p>
				<hr>

				<h1>
					<b>Joshua Ciccone-Okodo, Tech God</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round">
						<img alt=""
						src="img/heimdall.jpg"
						height=125 width=150></span>
				</h1>
				<p class="w3-text-grey">Josh is the strong, silent type. Leading
					by coding.</p>
				<hr>

				<h1>
					<b>Tyler Paladini, Assistant to the Regional Manager</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="img/dwight.jpg"
						height=100 width=125></span>
				</h1>
				<p class="w3-text-grey">Tyler loves troubleshooting.</p>
				<hr>

				<h1>
					<b>Rob Thompson, DBA</b> <span
						class="w3-right w3-tag w3-dark-grey w3-round"><img alt=""
						src="img/milton.jpg"
						height=100 width=125></span>
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
				goes that Zach and Gretchen, venturous souls they are, embarked upon a road trip through our great country, two diaper age children in tow. 
				<BR>This trip, as fate would have it though neither knew it, would lead to the developement of this very application.<BR>
				Gretchen observed at one point in this fateful journey about the overall unfairness to moms that there was a serious lack of changing tables in men's 
				bathrooms. <BR>
				Zach likely agreed, as he was changing his child from a makeshift changing "table". <BR>
				What followed revolutionized the finding of restrooms with changing tables. <BR></p>


		</div>
	</div>

	<!-- Contact -->
	<div
		class="w3-container w3-padding-64 w3-blue-grey w3-grayscale-min w3-xlarge">
		<div class="w3-content">
			<h1 class="w3-center w3-jumbo" style="margin-bottom: 64px">Contact</h1>
			<p>Find us at 7400 E Orchard St, Greenwood Village, CO 80111! Call us at <A HREF="tel:303-302-5234">303-302-5234! </A> </p>
			<p class="w3-xxlarge">Information is not warranted. It's
				crowdsourced, what do you expect?</p>
			<form action="/action_page.php" target="_blank">
				<p>
					<A HREF="mailto:rob@10thHuman.com,lamb.zachary@gmail.com,tylerpaladini@yahoo.com,joshokodo@gmail.com?&subject=Your website is awesome!"><span class="w3-tag">Click here to send
							us a message!</span></A>
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
		<p>
			Modified by Steel Assault!</a>
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


