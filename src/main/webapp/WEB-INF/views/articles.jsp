<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="card">
	<h4 class="card-header">Articles <a href="/downloadCSV" class="btn btn-primary">Download CSV Report</a></h4>		
	<c:forEach items="${allArticles}" var="article">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">${article.title}</h4>
				<small>Posted by ${article.user.username} on <fmt:formatDate pattern="dd MMM yyyy" value="${article.updated_at}" /> at 
				<fmt:formatDate pattern="hh:mm a" value="${article.updated_at}" /></small>
				<p class="card-text">${article.content}</p>				
				<p><a href="/article/${article.id}" class="btn btn-link">See comments for this article</a></p>
			</div>
		</div>
	</c:forEach>
</div>
<%@ include file="common/footer.jspf"%>