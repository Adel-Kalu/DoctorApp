<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}patient/add" method="post">

	<div class="form-group">
		<label>Date </label> <input type="date" name="date" value="${patient.date}" class="form-control">
	</div>

	<div class="form-group">
		<label>Patient Name </label> <input type="text" name="patientName" value="${patient.patientName}" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Reason For Appointment </label> <input type="text" name="reasonForAppointment" value="${patient.reasonForAppointment}" class="form-control">
	</div>


	<div class="form-group">
		<label>Doctor</label>
		<select name="doctors" class="form-control" multiple="multiple">
			<c:forEach items="${doctors}" var="doctor">
				<option value="${doctor.id}"> ${doctor.name} </option>
			</c:forEach>	
		</select>
	</div>
	
	<input type="hidden" name="id" value="${patient.id}">

	<button type="submit" class="btn btn-primary">Submit</button>

</form>