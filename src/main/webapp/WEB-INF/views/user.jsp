<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="row">
	<div class="col">
		<ul class="list-group">
			<li class="list-group-item active">My Profile</li>
			<li class="list-group-item">Approved Articles</li>
			<li
				class="list-group-item d-flex justify-content-between align-items-center">
				Pending Articles <span class="badge badge-primary badge-pill"></span>
			</li>
		</ul>
	</div>
	<div class="col">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">${user.username}</h4>
				<p class="card-text">Registered on ${user.created_at}</p>
				<a href="/new-article" class="btn btn-primary">Post a New Article</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>