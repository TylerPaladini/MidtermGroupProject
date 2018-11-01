<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>

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
					<a href="profileAdmin.do" class="w3-bar-item w3-button">Admin
						Profile</a>
				</c:if>

				<c:if test="${!loggedIn.admin }">
					<a href="profileUser.do" class="w3-bar-item w3-button">User
						Profile</a>
				</c:if>

				<a href="logout.do" class="w3-bar-item w3-button">Logout</a>
			</c:if>
		</div>
	</div>
</nav>