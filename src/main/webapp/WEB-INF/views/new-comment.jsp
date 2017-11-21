<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Post your Article</h1>
	<form:form method="post" modelAttribute="article">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="title">Title</form:label>
			<form:input path="title" type="text" class="form-control"
				required="required" />
			<form:errors path="title" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="content">Content</form:label>
			<form:textarea path="content" type="text" class="form-control" required="required" />
			<form:errors path="content" cssClass="text-warning" />
		</fieldset>
		<input value="Register" type="submit" class="btn btn-primary" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>