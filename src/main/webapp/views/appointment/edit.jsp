<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}appointment/add" method="post">

	<div class="form-group">
		<label>Date </label> <input type="date" name="date" value="${appointment.date}" class="form-control">
	</div>

	<div class="form-group">
		<label>Appointment Patient Name </label> <input type="text" name="patientName" value="${appointment.patientName}" class="form-control">
	</div>
	
	<div class="form-group">
		<label>Reason For Appointment </label> <input type="text" name="reasonForAppointment" value="${appointment.reasonForAppointment}" class="form-control">
	</div>


	<div class="form-group">
		<label>Doctor</label>
		<select name="doctor" class="form-control">
			<c:forEach items="${doctors}" var="doctor">
				<option value="${doctor.id}"
				
				<c:if test="${appointment.doctor.id == doctor.id}"> 
				selected="selected"
				</c:if>
				
				> ${doctor.name} </option>
			</c:forEach>	
		</select>
	</div>
	
	<input type="hidden" name="id" value="${appointment.id}">

	<button type="submit" class="btn btn-primary">Submit</button>

</form>