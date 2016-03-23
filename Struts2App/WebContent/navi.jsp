<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><s:text name="start.title" /></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
		 <s:form class="navbar-form navbar-right" action="register" theme="dano">	
			<s:textfield name="email" placeholder="Email" class="form-control" />
			<s:password name="password" placeholder="Password" class="form-control" />
			<s:submit type="submit" class="btn btn-success" value="Sign in" />
			<s:submit type="submit" class="btn btn-primary" name="registerButton" value="Register" />	
		 </s:form>
        </div><!--/.navbar-collapse -->
      </div>
    </nav>