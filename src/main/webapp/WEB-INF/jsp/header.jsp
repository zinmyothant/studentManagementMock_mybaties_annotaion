
<div id="header">
	<div id="title">
		<a href="/studentManagementMock/welcome">Student Registration Assignment</a>
	</div>
	<div id="menuLoginTime">
		<table>
			<tr>
				<td>User</td>
				<td>: ${id} ${name}</td>
			</tr>
			<tr>
				<td>Current Date</td>
				<td>:<%=new java.util.Date()%></td>
			</tr>
		</table>
	</div>
	<form action="/studentManagementMock/logout">
		<input id="btn_logout" class="button" type="submit" value="Logout">
	</form>
</div>
