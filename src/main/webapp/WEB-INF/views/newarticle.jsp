<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Write your Article</h1>
	<c:url var="newArticleUrl" value="/newarticle" />
	<form:form method="post" modelAttribute="article" action="${newArticleUrl}">
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
		<input value="Submit article" type="submit" class="btn btn-primary" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>