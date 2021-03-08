<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}doctor/add" method="post">

	<div class="form-group">
		<label>Doctor's Name </label> <input type="text" name="name" class="form-control">
	</div>

	<div class="form-group">
		<label>Specialty </label> <input type="text" name="specialty" class="form-control">
	</div>

	<div class="form-group">
		<label>picture </label> <input type="text" name="picture"  class="form-control">
	</div>

	<button type="submit" class="btn btn-primary">Submit</button>

</form>