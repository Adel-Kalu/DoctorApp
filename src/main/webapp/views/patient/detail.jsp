<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

Date: ${patient.date} <br>
patient Name: ${patient.patientName} <br><br>
reason For Appointment: ${patient.reasonForAppointment} <br><br>


<div> Appointment:  </div>
<c:forEach items="${patient.getDoctors()}" var="doctor">
	<div> Doctor's Name: ${doctor.name}</div>
	<div> Doctor's Email Address: ${doctor.specialty} </div>
	<hr>
</c:forEach>