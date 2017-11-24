<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<h4 class="comments">Manage Articles</h4>
<table class="table table-striped">
		<thead>
			<tr>
				<th>Title</th>
				<th>Writer</th>
				<th>Posted on</th>
				<th>Approval Status</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allArticles}" var="article">
				<tr>
					<td>${article.title}</td>
					<td>${article.user.username}</td>
					<td>
						<fmt:formatDate pattern="dd MMM yyyy hh:mm a zzz"
							value="${article.created_at}" />
					</td>
					<td>
						<c:set var="status" scope="session" value="${article.approved}" />				
						<c:choose>  
						    <c:when test="${status == true}">  
						       Approved
						    </c:when>  
						    <c:when test="${status == false}">
						      Rejected 
						    </c:when>  
						    <c:otherwise>  
						       Unknown Status 
						    </c:otherwise>  
						</c:choose>
					</td>
					<td>
						<c:set var="status" scope="session" value="${article.approved}" />				
						<c:choose>  
						    <c:when test="${status == true}">  
						       <a href="/rejectarticle?id=${article.id}" class="btn btn-danger">Reject</a>
						    </c:when>  
						    <c:when test="${status == false}">
						      <a href="/approvearticle?id=${article.id}" class="btn btn-success">Approve</a>
						    </c:when>  
						    <c:otherwise>  
						       Unknown Status 
						    </c:otherwise>  
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<%@ include file="common/footer.jspf"%>