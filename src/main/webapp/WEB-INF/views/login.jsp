<%@page import="org.hibernate.jpa.criteria.predicate.IsEmptyPredicate"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<form method="POST" action="/login" class="form-signin">
  <div class="form-group">
    <label for="username">Username</label>
    <input type="text" class="form-control" name="username" id="username" aria-describedby="emailHelp" placeholder="Username">
  </div>
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" name="password" id="password" placeholder="Password">
  </div>
  <div class="form-check">
    <label class="form-check-label">
      <input type="checkbox" class="form-check-input">
      Check me out
    </label>
  </div>
  <button type="submit" class="btn btn-primary">Log in</button>
</form>
<%@ include file="common/footer.jspf"%>