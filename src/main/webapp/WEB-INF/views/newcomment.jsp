<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Add your comment</h1>
	<c:url var="newCommentUrl" value="/newcomment/article/${articleId}" />
	<form:form method="post" modelAttribute="comment" action="${newCommentUrl}">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="content">Content</form:label>
			<form:textarea path="content" class="form-control" required="required" />
 			<form:errors path="content" cssClass="text-warning" />
		</fieldset>
		<input value="Submit comment" type="submit" class="btn btn-primary" />
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>