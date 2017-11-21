<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Register with UK Forum</h1>
	<form:form method="post" modelAttribute="user">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="username">Username</form:label>
			<form:input path="username" type="text" class="form-control"
				required="required" />
			<form:errors path="username" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="password">Password</form:label>
			<form:input path="password" type="password" class="form-control"
				required="required" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		<input value="Register" type="submit" class="btn btn-primary" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>