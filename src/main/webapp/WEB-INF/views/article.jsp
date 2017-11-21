<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="card">
  <div class="card-body">
  	<h4 class="card-title">${article.title}</h4>
    <h6 class="card-subtitle mb-2 text-muted">Posted by ${article.user.username} on <fmt:formatDate
					pattern="dd MMM, yyyy hh:mm a zzz" value="${article.updated_at}" /></h6>
	<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi non erat eu lectus tincidunt viverra. Aliquam luctus tempus metus, vel iaculis orci. Sed arcu sapien, viverra et elementum vitae, pulvinar aliquet justo. Quisque scelerisque vehicula sem, id malesuada dui consequat in. Nam porttitor dictum urna, quis pharetra sem mattis ut. Cras finibus, nulla eu lacinia lobortis, tellus orci finibus erat, vel sodales dolor neque et nisl. Fusce et mollis mi, sit amet auctor nisl. In quis lacus in felis viverra commodo vel pretium metus. Mauris vestibulum varius tincidunt. Maecenas pulvinar viverra suscipit.</p>
  	<a href="/new-comment/article/${article.id}" class="btn btn-primary">Add your comment</a>
    <a href="/delete-article" class="btn btn-danger">Delete this article</a>
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