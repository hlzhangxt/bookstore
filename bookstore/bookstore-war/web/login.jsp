<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp">

	<tiles:putAttribute name="content">
	
		<h4>Login</h4>
  
	  	<struts:form action="customer">
	  		<struts:hidden name="action" value="login"></struts:hidden>
	  		<struts:textfield name="customer.login_name" label="Account"></struts:textfield>
	  		<struts:password name="customer.login_pass" label="Password"></struts:password>
	  		<struts:submit value="Submit" cssClass="button"></struts:submit>
	  	</struts:form>
	  	
	</tiles:putAttribute>
	
</tiles:insertTemplate>
