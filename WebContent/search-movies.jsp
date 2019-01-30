<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Home Page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body >
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <h2>Movie Page!</h2>
  <a href="showMovies"><img src="img/movie.jpg" class="img-thumbnail" style="height: 100px;">Show Movies</a>
  	<br/> 	<br/> 	<br/> 
  	<form action="searchMovie" method="get">
			Title :
			<input type="text" name="title" class="form-control" style="width: 50%;display: inline;margin-right: 30px;"> 	
			<button type="submit" class="btn btn-primary">Search Movie</button>
			<button type="Reset" class="btn btn-danger">Clear</button>
	</form>
	<hr/>
	  <p style="font-weight: bold;color: red;">Movie Search Result(s)</p>            
  
  
  <c:forEach items="${searchResults}" var="movie">
    <table class="table table-bordered">
    	<tr>
    		<td>
    		
    		  <table class="table table-bordered">
    <tbody>
     <tr>
        <td>Title</td>
        <td>${movie.title}</td>
      </tr>
      <tr>
        <td>Director</td>
       <td>${movie.director}</td>
      </tr>
      <tr>
        <td>Year</td>
         <td>${movie.year}</td>
      </tr>
      <tr>
        <td>Language</td>
          <td>${movie.language}</td>
      </tr>
      <tr>
        <td>Review</td>
          <td>${movie.story}</td>
      </tr>
    </tbody>
  </table>
    		</td>
    		
    	<td style="width: 30%;">
    	
    	  <table class="table table-borderless">
    <tbody>
     <tr>
        <td>
        <img src="loadImage?mid=${movie.mid}" style="height: 200px;" class="img-thumbnail" >
        </td>
      </tr>
    </tbody>
  </table>
    		</td>
    		
    	</tr>
    
    </table>
</c:forEach>
	
	
</div>

</body>
</html>
