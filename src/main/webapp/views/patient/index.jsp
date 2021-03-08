<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<table class="table table-striped">

	<tr>
		<th>Date</th>
		<th>Patient Name</th>
		<th>Reason For Appointment</th>
		<th>Actions</th>
	</tr>

	<c:forEach items="${patients}" var="patient">
		<tr>
			<td><a href="${appName}patient/detail?id=${patient.id}">${patient.date}</a></td>
			<td>${patient.patientName}</td>
			<td>${patient.reasonForAppointment}</td>

			<td><a href="${appName}patient/edit?id=${patient.id}">Edit</a> | <a
				href="${appName}patient/delete?id=${patient.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>