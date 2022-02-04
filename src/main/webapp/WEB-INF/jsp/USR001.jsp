<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR001) User Search</title>

<script type="text/javascript">
	window.onload = function() {
		menu();
	}
	function checkDelete() {
		var c = confirm("Are you sure you want to delete!");
		if (c) {
			document.getElementById("deleteuser").submit();
		}

	}
</script>
</head>
<body class="main_body">
<jsp:include page="link.jsp" />
	<jsp:include page="header.jsp" />

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>User Search</h3>
					<form:form action="/studentManagementMock/setupusersearch" modelAttribute="user" method="post">
						<table class="tableForm">
							<tr>
								<td class="tblLabel"><label>User ID</label></td>
								<td class="tblInputNormal"><form:input type="text"
									id="txtUserId" class="txt" path="id" /></td>

								<td class="tblLabel">User Name</td>
								<td class="tblInputNormal"><form:input type="text"
									id="txtUserName" class="txt" path="name" />€€</td>

							</tr>
						</table>

						<br /> <input type="submit" value="Search" class="button" />
					</form:form>
					<a href="/studentManagementMock/useradd"> <input type="button" value="Add"
						class="button" id="userInsert" />
					</a>
					<a href="/studentManagementMock/userreset"> <input type="button" value="Reset" class="button" /></a> <br /> <br />
					<div id="errormsg">
						<label id="message">${err}</label>
					</div>
					<label style="color: blue;">${msg}</label>
				</div>

				<br />
				<br />
				<br />
				<div id="list">

					<table class="resultTable">
						<c:if test="${userlist!=null}">
							<tr class="tblHeader">
								<th width="1%">Delete</th>
								<th width="1%">Update</th>
								<th width="12%">User ID</th>
								<th width="24%">User Name</th>

							</tr>
						</c:if>
						<c:forEach items="${userlist}" var="list">
							<tr>
								<td>
								<a href="userdelete/${list.id}"> Delete 
								</a></td>
							
							
								<td><a href="userupdate/${list.id}"> Update
								</a></td>

								<td>${list.id}</td>
								<td>${list.name}</td>
							</tr>
						</c:forEach>
					</table>

				</div>

			</div>
		</div>

	</div>
	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
	</div>
</body>
</html>