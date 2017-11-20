<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<table class="table">
	<thead>
		<tr>
			<th scope="col">Username</th>
			<th scope="col">Registered on</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<th scope="row">${user.username}</th>
				<td><fmt:formatDate pattern="dd MMM yyyy hh:mm a"
						value="${user.created_at}" /></td>
				<td><a href="/update-user?id=${user.id}" class="btn btn-info">Update</a>
					<a href="/delete-user?id=${user.id}" class="btn btn-danger">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="common/footer.jspf"%>