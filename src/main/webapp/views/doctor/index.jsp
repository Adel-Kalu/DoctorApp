<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<table class="table table-striped">

	<tr>
		<th>Doctor Name</th>
		<th>Specialty</th>
		<th>Picture</th>
		<th>Actions</th>
	</tr>

	<c:forEach items="${doctors}" var="doctor">
		<tr>
			<td><a href="${appName}doctor/detail?id=${doctor.id}">${doctor.name}</a></td>
			<td>${doctor.specialty}</td>
			<td>${doctor.picture}</td>

			<td><a href="${appName}doctor/edit?id=${doctor.id}">Edit</a> | <a
				href="${appName}doctor/delete?id=${doctor.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>