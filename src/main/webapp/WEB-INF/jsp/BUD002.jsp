
<%@page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>(BUD002)Student Register</title>

	<script type="text/javascript">
	window.onload = function() {
		menu();
	}
</script>
<jsp:include page="link.jsp" />
</head>
<body class="main_body">

	<jsp:include page="header.jsp" />

	<div id="container">
		<div id="left_menu">
			<!-- menu html code exist the menu function of general.js -->
		</div>
		<div id="main_contents">
			<div id="contents">
				<div class="search_form">
					<h3>Student Register</h3>
					<label id="errormsg"> ${err} </label> <label style="color: blue;">${msg}</label>
					<br /> <br /> <br />
					<form:form action="/studentManagementMock/setupaddstudent"
						method="post" modelAttribute="student">
						<table class="tableForm">
							<tr>
								<td class="tblSingleLabel">Student No *</td>
								<td class="tblSingleInput"><form:input type="text"
										path="studentId" class="txtlong" /> <form:errors
										path="studentId" style="color:red"></form:errors></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Student Name *</td>
								<td class="tblSingleInput"><form:input type="text"
										path="studentName" class="txtlong" /> <form:errors
										path="studentName" style="color:red"></form:errors></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Class Name *</td>
								<td class="tblSingleInput"><form:select id="expenseType"
										class="normal_sel" path="className" >

										<form:option value="NONE" label="Select" />
										<c:forEach var="list" items="${clist}">
										<form:option value="${list.name}"/>
				
										</c:forEach>
																
									</form:select> <form:errors path="className" style="color:red"></form:errors>

								</td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Register Date</td>
								<td><form:input path="register" type="datetime-local" /> <form:errors
										path="register" style="color:red"></form:errors></td>
							</tr>
							<tr>
								<td class="tblSingleLabel">Status *</td>
								<td class="tblSingleInput"><form:select id="expenseType"
										class="normal_sel" path="status">
										<form:option value=""></form:option>

										<form:option value="Attending">Attending</form:option>
										<form:option value="Passed">Passed</form:option>
										<form:option value="Failed">Failed</form:option>

									</form:select> <form:errors path="status" style="color:red"></form:errors></td>
							</tr>


						</table>
						<br />
						<div id="btnGroup">
							<input type="submit" value="Register" class="button" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="footer">
		<span>Copyright &#169; ACE Inspiration 2016</span>
	</div>
</body>
</html>