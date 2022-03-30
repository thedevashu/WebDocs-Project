<%@page import="com.image.pojo.Image"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	div{
		height: 50px;
		max-width: 50px;
	}
</style>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<div style="text-align: center;">
				<% 
					String msg = (String)request.getAttribute("errormsg");
					if(msg != null){
		
					%>

						<font color="red" > <%=msg %></font>

					<%
					}
				%>
</div>
<div >
	<form action="getImage" method="post">
			Enter Image name:<input type="text" name="name">	
			<button type="submit">Submit</button>
	</form>
	<%
	Image i = (Image) request.getAttribute("image");
	if (i != null) {
	%>
	
	</div>
	<div >
	<%
	Blob image = null;

	byte[] imgData = null;

			image = i.getImage();

			imgData = image.getBytes(1, (int) image.length());


		// display the image

		response.setContentType("image/gif");

		OutputStream o = response.getOutputStream();

		o.write(imgData);

		o.flush();

		o.close();

	
	%>
	<%
	}
	%>
</div>
	

	
</body>
</html>