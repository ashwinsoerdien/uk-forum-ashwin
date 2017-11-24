<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="card">
	<h4 class="card-header">The Latest Articles</h4>
	<c:forEach items="${allArticles}" var="article">
		<div class="card">
		<div class="card-body">
			<h4 class="card-title">${article.title}</h4>
			<p class="card-text">${article.content}</p>
			<small>Posted by ${article.user.username} on <fmt:formatDate
 					pattern="dd MMM yyyy" value="${article.updated_at}" /> at <fmt:formatDate 
 					pattern="hh:mm a" value="${article.updated_at}" /></small> 
 			<p><a href="/article/${article.id}" class="btn btn-link">See more..</a></p>
		</div>
		</div>
	</c:forEach>
</div>

<a href="/newarticle" class="btn btn-primary">Post your own Article</a>

<%@ include file="common/footer.jspf"%>