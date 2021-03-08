<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<table class="table table-striped">

	<tr>
		<th>Date</th>
		<th>Patient Name</th>
		<th>Reason For Appointment</th>
		<th>Actions</th>
	</tr>

	<c:forEach items="${appointments}" var="appointment">
		<tr>
			<td><a href="${appName}appointment/detail?id=${appointment.id}">${appointment.date}</a></td>
			<td>${appointment.patientName}</td>
			<td>${appointment.reasonForAppointment}</td>

			<td><a href="${appName}appointment/edit?id=${appointment.id}">Edit</a> | <a
				href="${appName}appointment/delete?id=${appointment.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>