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
<title>Index Page</title>
</head>
<body>

	To fetch uploaded image click here : <a href="home">Fetch Image</a>
	
	<br/>
	
	Upload new Image:
	<form action="addImage" method="post" enctype="multipart/form-data">
		
			Enter Image name: <input type="text" name="name">
			<br>
			Upload Image : <input type="file" id="customFile" name="file" accept="image/png, image/jpeg"/>	
			<br>
			<button type="submit">Submit</button>
		
	</form>

	
</body>
</html>