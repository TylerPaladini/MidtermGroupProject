<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>

	<div class="container">

		<div class="row">

			<div class="col-5">
				<form action="getLocationsByKeywordSearch.do" method="GET">

					<table>
						<tr>
							<td style="color: blue; font-size: 20px; padding: 0px">B</td>
							<td style="color: orange; font-size: 20px; padding: 0px">Y</td>
							<td style="color: red; font-size: 20px; padding: 0px">O</td>
							<td style="color: green; font-size: 20px; padding: 0px">W</td>

							<th><input type="search" name="keyword" size="30" /></th>
							<th><input type="submit" name="search" value="Search" /></th>

						</tr>
					</table>

				</form>
			</div>
			<div class="col-7"></div>
		</div>

		<div class="row">
			<div class="col-10"></div>
			<div class="col-2">
				<table>
					<tr>
						<th>
							<form action="home.do">
								<th><input type="submit" name="home" value="Home Page" /></th>
							</form>
						</th>
						<c:if test="${empty loggedIn }">
							<th>

								<form action="loginPage.do">
									<input type="Submit" value="Login" />
								</form>
							</th>
							<th>
								<form action="registerPage.do">
									<input type="Submit" value="Register" />
								</form>
							</th>
						</c:if>
						<c:if test="${not empty loggedIn }">
							<th>
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
							</th>
						</c:if>

					</tr>
				</table>
			</div>
		</div>

	</div>



</nav>