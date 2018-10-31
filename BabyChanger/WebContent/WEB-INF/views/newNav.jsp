<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav>

	<div class="container">

		<div class="row">

			<div class="col-4">
				<form action="getLocationsByKeywordSearch.do" method="GET">
					<input type="search" name="keyword" size="30" /> <input
						type="submit" name="search" value="Search" />

				</form>
			</div>
			<div class="col-6"></div>
			<div class="col-2">
			
				

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