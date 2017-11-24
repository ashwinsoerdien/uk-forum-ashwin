<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="card">
  <div class="card-body">
  	<h4 class="card-title">${article.title}</h4>
    <h6 class="card-subtitle mb-2 text-muted">Posted by ${article.user.username} on <fmt:formatDate
					pattern="dd MMM, yyyy hh:mm a zzz" value="${article.updated_at}" /></h6>
	<p class="card-text">${article.content}</p>
	<a href="/newcomment/article/${article.id}" class="btn btn-primary">Add your comment</a>
	<sec:authorize var="loggedIn" access="isAuthenticated()" />
	<c:choose>
		<c:when test="${loggedIn}">
			<sec:authentication var="loggedInUser" property="principal" />
			<c:choose>
				<c:when test="${loggedInUser.username == article.user.username}" >
					<a href="/editarticle?id=${article.id}" class="btn btn-info">Edit article</a>
    					<a href="/deletearticle?id=${article.id}" class="btn btn-danger">Delete article</a>
				</c:when>
			</c:choose>
		</c:when>
			<c:otherwise>
			</c:otherwise>
	</c:choose>
  </div>
</div>
<h4 class="comments">Comments</h4>
<table class="table table-sm table-striped table-bordered">
	<tbody>
		<c:forEach items="${article.comments}" var="comment">
			<tr>
				<td scope="row">
					<p>${comment.content}</p>
					<small>Posted by ${comment.user.username} on <fmt:formatDate pattern="dd MMM yyyy hh:mm a zzz" value="${comment.created_at}" /></small>				
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="common/footer.jspf"%>