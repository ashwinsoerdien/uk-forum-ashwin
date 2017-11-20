<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
<div class="card">
  <div class="card-body">
  <h4 class="card-title">${article.title}</h4>
  <hr />
    <small>Posted by ${article.user.username} on <fmt:formatDate
					pattern="dd MMM yyyy" value="${article.updated_at}" /> at <fmt:formatDate
					pattern="hh:mm a" value="${article.updated_at}" /></small>
    <p class="card-text">${article.content}</p>
    <a href="#" class="btn btn-primary">Add a comment</a>
  </div>
</div>
</div>
<%@ include file="common/footer.jspf"%>