<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Your Todos are</caption>

		<thead>
			<tr>
				<th>Description</th>
				<th>Date</th>
				<th>Completed</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${todo.targetDate}" /></td>
					<td>${todo.done}</td>
					<td><a type="button" class="btn btn-primary"
						href="update-todo?id=${todo.id}">Edit</a> <a type="button"
						class="btn btn-warning" href="delete-todo?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="container">
	<a type="button" class="btn btn-success" href="add-todo">Add</a>
</div>
<%@ include file="common/footer.jspf"%>