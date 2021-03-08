<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

Doctor's Name: ${doctor.name} <br>
Specialty: ${doctor.specialty} <br>
Picture: <img src="${doctor.picture}"> <br><br>


<table>
	<c:forEach items="${doctor.getPatients()}" var="patient">
		<tr>
			<td> Title: ${patient.date} </td>
		</tr>
		<tr>
			<td> Description: ${patient.patientName} </td>
		</tr>
		<tr>
			<td> Description: ${patient.reasonForAppointment} </td>
		</tr>
			
	</c:forEach>
</table>