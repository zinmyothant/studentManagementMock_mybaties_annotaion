<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(USR002)User Register</title>
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
				<h3>User Register</h3>
				<label id="errormsg"> ${err} </label><br />
				<br />
				<br /> <label style="color: blue;">${msg}</label>
				<form:form name="registerForm" action="setupadduser" method="post" modelAttribute="user">
					<table class="tableForm">
						<tr>
							<td class="tblSingleLabel">User ID *</td>
							<td class="tblSingleInput"><form:input type="text" id="txtUserId"
								class="txt_popup" path="id" />
								<form:errors path="id" style="color:red"></form:errors>
								</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">User Name</td>
							<td class="tblSingleInput"><form:input type="text"
								class="txtlong_popup" id="txtUserName" path="name"
								value="${bean.name}" />
									<form:errors path="name" style="color:red"></form:errors>
						
								</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Password *</td>
							<td class="tblSingleInput"><form:input type="password"
								class="txtlong_popup" id="txtUserName" path="password" />
									<form:errors path="password" style="color:red"></form:errors>
						
								</td>
						</tr>
						<tr>
							<td class="tblSingleLabel">Confirm Password *</td>
							<td class="tblSingleInput"><form:input type="password"
								class="txtlong_popup" id="txtUserName" path="confirm" />
									<form:errors path="confirm" style="color:red"></form:errors>
						
								</td>
						</tr>

					</table>
					<br /> <input type="submit" value="Register" class="button" />
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