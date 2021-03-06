<!DOCTYPE html>
<%@page import="oppo.Movie"%>
<%@page import="java.util.ArrayList"%>
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

<%@include file="header.jsp" %>

<div class="container">
	  <h2>Movie Data!  =>>EL =Expression Language</h2>
  <img src="img/movie.jpg" class="img-thumbnail" style="height: 100px;">
  <br/>
   Email :  <b>${initParam.email}</b>
  	<br/>
  	
  	Message :  <b>${applicationScope.message}</b>
  	<br/> 	
  	 	  	MName :  <b>${applicationScope.mname}</b>
  	<br/> 		<br/> 	

		      <form action="filterMovie" method="get">
			  	 		Language :
						<select name="language"  class="form-control" style="width: 50%;background-color: buttonface;display: inline;margin-right: 30px;">
						<option>Select</option>
						<option>All</option>
								<option>English</option>
								<option>Hindi</option>
									<option>Russian</option>
						</select>
					<button type="submit" class="btn btn-primary">Filter</button>
		</form>

  	 	<br/> 
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Title </th>
        <th>Year</th>
        <th>Director</th>
        <th>Language</th>
        <th>Review</th>
           <th>Poster</th>
      </tr>
    </thead>
    <tbody>
    <%
    //request.setAttribute("pdata", movies);
   ArrayList<Movie> supriyaList= (ArrayList<Movie>)request.getAttribute("pdata");
    for(Movie mt : supriyaList) {
    	 %>
      <tr>
        <td><%=mt.getTitle() %></td>
      <td><%=mt.getYear() %></td>
        <td><%=mt.getDirector() %></td>
        <td><%=mt.getLanguage() %></td>
           <td><%=mt.getStory() %></td>
           <td>
         <%--   <img src="<%=mt.getPoster() %>" style="height: 150px;" class="img-thumbnail" > --%>
         
          <img src="loadImage?mid=<%=mt.getMid() %>" style="height: 150px;" class="img-thumbnail" >
            <a href="deleteMovie?mid=<%=mt.getMid() %>"> <img src="img/delete.jfif" class="img-thumbnail" style="height: 100px;"></a>
           </td>
      </tr>
     <% } %>
    </tbody>
  </table>
    <br/>
   
  <a href="umovie.htm"><button type="button" class="btn btn-danger">Add Record!</button></a>

</div>
</body>
</html>