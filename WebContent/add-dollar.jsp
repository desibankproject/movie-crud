<!DOCTYPE html>
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
<header style="background-color: #062f6d;height:30px;">
</header>
<div class="container">
  <h2>Movie Page!</h2>
  <a href="showMovies"><img src="img/dollar.jpg" class="img-thumbnail" style="height: 200px;">Dollar Page</a>
  	<br/>
  		<span style="color: red';font-size: 18px;">${message}</span>
  	 	<br/> 	<br/> 
  	<form action="addDollar" method="post">
			Select Dollar :
			<select name="dollar"  class="form-control" style="width: 50%;display: inline;">
					<option>10</option>
						<option>20</option>
						<option>50</option>
							<option>100</option>
					<option>200</option>
						<option>300</option>
			</select>
			$
			<br/> 		<br/> 
			<button type="submit" class="btn btn-primary">Add Dollar</button>
	</form>
	<hr/>
	
	<h2>Fetching data from session</h2>
		 	<br/> 
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>SNO </th>
        <th>Dollar</th>
    </thead>
    <tbody>
    <%
    //request.setAttribute("pdata", movies);
   ArrayList<Integer> dollarList= (ArrayList<Integer>)session.getAttribute("sbags");
   if(dollarList==null){
	   dollarList=new ArrayList<Integer>();
   }
   int count=1;
    for(Integer t : dollarList) {
    	 %>
      <tr>
        <td><%=count++%></td>
      <td><%=t %></td>
      </tr>
     <% } %>
    </tbody>
  </table>
</div>

</body>
</html>
