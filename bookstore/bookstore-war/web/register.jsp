<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>
        <div style="color: red; ">
			<struts:property value="message" />
		</div>
        <h4>Registration</h4>

        <s:form action="customer">
            <s:hidden name="action" value="register"></s:hidden>
            <s:textfield name="customer.login_name" label="Account"></s:textfield>
            <s:password name="customer.login_pass" label="Password"></s:password>
            <s:password name="confPass" label="Password Again"></s:password>
            <s:submit value="Register" cssClass="button"></s:submit>
            </s:form>

            
          </body>
   </html>