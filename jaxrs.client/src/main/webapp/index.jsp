<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JAX-RS Client Servlet URL</title>
</head>
<body>
	<h2>Connect timeout</h2>
	<form action="connect" method="get">
		<label for="name">Connect timeout(ms):</label> 
		<input type="text" id="connect_timeout" name="timeout" value="10000" size="10"></br> 
		<label for="name">Target Host(IP):</label>
		<input type="text" id="connect_host" name="host" value="10.10.10.10" size="20"></br>
		<label for="name">Target Port:</label> 
		<input type="text" id="connect_port" name="port" value="9080" size="20"></br>
		<input type="submit" id="connect_submit" name="submit" value="submit">
	</form>
	<h2>Receive timeout</h2>
	<form action="receive" method="get">
		<label for="name">Receive(Read) timeout(ms):</label> 
		<input type="text" id="receive_timeout" name="timeout" value="10000" size="10"></br> 
		<label for="name">Sleep time(ms):</label>
		<input type="text" id="receive_sleep" name="sleep" value="20000" size="10"></br>
		<input type="submit" id="recieve_submit" name="submit" value="submit">
	</form>
	<h2>Simple JAX-RS client</h2>
	<a href="get">Simple JAX-RS client servlet (JaxrsClientServlet class)</a>
</body>
</html>
