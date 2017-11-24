<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<c:url var="loginUrl" value="/login" />
<form action="${loginUrl}" method="post" class="form-signin">
	<c:if test="${param.error != null}">
		<div class="alert alert-danger">
			<p>Invalid username and password.</p>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<p>You have been logged out successfully.</p>
		</div>
	</c:if>
	<div class="form-group">
		<label for="username">Username</label> 
		<input type="text" class="form-control" name="username" id="username"
			aria-describedby="emailHelp" placeholder="Username">
	</div>
	<div class="form-group">
		<label for="password">Password</label>
		<input type="password" class="form-control" name="password" id="password"
			placeholder="Password">
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<button type="submit" class="btn btn-primary">Log in</button>
</form>
<%@ include file="common/footer.jspf"%>