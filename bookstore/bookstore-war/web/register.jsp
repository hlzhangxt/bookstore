<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp">

	<tiles:putAttribute name="content">
	
		<h4>Registration</h4>
  
	  	<struts:form action="user">
	  		<struts:hidden name="action" value="register"></struts:hidden>
	  		<struts:textfield name="customer.login_name" label="Account"></struts:textfield>
	  		<struts:password name="customer.login_pass" label="Password"></struts:password>
	  		<struts:password name="confPass" label="Password Again"></struts:password>
	  		<struts:submit value="Register" cssClass="button"></struts:submit>
	  	</struts:form>
	  	
	</tiles:putAttribute>
	
</tiles:insertTemplate>
