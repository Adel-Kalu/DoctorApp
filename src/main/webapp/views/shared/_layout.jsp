<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor APP</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"><link rel="stylesheet" href="../css/myStyles.css">
<link rel="stylesheet" href="css/myStyles.css">
</head>
<body>
<h2>${Welcome}</h2>

<a href="${appName}">Home</a>

<a href="${appName}doctor/add">Add Doctor</a>
<a href="${appName}doctor/index">Doctors</a>

<a href="${appName}appointment/add">Add Appointment</a>
<a href="${appName}appointment/index">Appointments</a>

<hr>

</body>
</html>