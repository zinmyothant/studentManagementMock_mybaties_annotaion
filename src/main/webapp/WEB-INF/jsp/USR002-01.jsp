<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Update</title>

<script type="text/javascript">
	window.onload = function() {
		menu();

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
				<h3>User Update</h3>
				<label id="errormsg"> ${err} </label> <label style="color: blue;">${msg}</label>
				<br />
				<br />
				<br />
		<form:form name="registerForm" action="/studentManagementMock/userupdate" method="post" modelAttribute="user">
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel">User ID *</td>
							<td class="tblSingleInput"><form:input path="id"/></td>
						</tr>
						<tr>
							<td class="tblSingleLabel">User Name</td>
							<td class="tblSingleInput">
							<form:input type="text" path="name"/>
							</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput">
							<form:input type="password" path="password" />
							</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm *</td>
							<td class="tblSingleInput">
							<form:input type="password" path="confirm" />
							</td>
						</tr>
					</table>
					<br /> <input type="submit" value="Update" class="button" />
				</form:form>
		
				<br />
				<br />
				<br />
			</div>
		</div>

	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>