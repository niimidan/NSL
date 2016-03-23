	<%@ taglib prefix="s" uri="/struts-tags" %>
	<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="text-center container">
       <h1><s:text name="welcome.title" /></h1>
       <p>Sign-up is free and allows you to search through registered team/player profiles.</p>
       <p><a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/" role="button">Learn more &raquo;</a></p>
     </div>	
    <hr>
   <!-- <div class="container-narrow"> -->
   <div class="text-center container">
   	<s:text name="registration.blurb" />
		<form action="registerPlayer">
			<div>
				<button class="btn btn-success btn-vlg" type="submit">Player</button>
				<button class="btn btn-primary btn-vlg" type="submit" name="registerTeam">Team</button>
			</div>
		</form>
		
		
		<table class="table table-striped table-hover">
		  <thead>
		    <tr>
		      <th>#</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Email</th>
		    </tr>
		  </thead>
		  <tbody>
			<s:iterator value="userList">
				<tr align="left">
					<th scope="row" ><s:property value="id"/></th>
					<td><s:property value="first"/></td>
					<td><s:property value="last"/></td>
					<td><s:property value="email"/></td>
				</tr>	
			</s:iterator>
		</tbody>
		</table>
		
		<nav>
		  <ul class="pagination">
		    <li>
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		
   </div> <!-- /container -->