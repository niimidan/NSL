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
		
		<table>
			<s:iterator value="userList">
				<tr>
					<td><s:property value="first"/></td>
					<td><s:property value="last"/></td>
					<td><s:property value="email"/></td>
					<td><s:property value="id"/></td>
				</tr>	
			</s:iterator>
		</table>
   </div> <!-- /container -->