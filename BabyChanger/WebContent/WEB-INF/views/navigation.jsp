<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>

	<div class="container">

		<div class="row">

			<div class="col-5">
				<form action="getLocationsByKeywordSearch.do" method="GET">


					
						<div style="color: orange; font-size: 20px; padding: 0px">B</div>
						<div style="color: orange; font-size: 20px; padding: 0px">Y</div>
						<div style="color: red; font-size: 20px; padding: 0px">O</div>
						<div style="color: green; font-size: 20px; padding: 0px">W</div>
					<input type="search" name="keyword" size="30" /> 
					<input type="submit" name="search" value="Search" />

				</form>
			</div>
			<div class="col-7"></div>
		</div>

		<div class="row">
			<div class="col-10"></div>
			<div class="col-2">

				<c:if test="${empty loggedIn }">


					<form action="loginPage.do">
						<input type="Submit" value="Login" />
					</form>

					<form action="registerPage.do">
						<input type="Submit" value="Register" />
					</form>

				</c:if>
				<c:if test="${not empty loggedIn }">
					<c:if test="${loggedIn.admin }">
						<form action="profileAdmin.do">
							<input type="Submit" value="Admin Profile" />
						</form>
					</c:if>
					<c:if test="${!loggedIn.admin }">
						<form action="profileUser.do">
							<input type="Submit" value="User Profile" />
						</form>
					</c:if>

					<form action="logout.do">
						<input type="Submit" value="Log Out" />
					</form>
				</c:if>

			</div>
		</div>

	</div>



</nav>