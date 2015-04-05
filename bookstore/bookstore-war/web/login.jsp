<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login</title>
    </head>
    <body>	
       <div style="color: red; ">
			<struts:property value="message" />
		</div>
        <h4>Login</h4>

        <s:form action="customer">
            <s:hidden name="action" value="login"></s:hidden>
            <s:textfield name="customer.login_name" label="Account"></s:textfield>
            <s:password name="customer.login_pass" label="Password"></s:password>
            <s:submit value="Submit"></s:submit>
        </s:form>

       
    </body>
</html>