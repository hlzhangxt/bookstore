<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Success</title>
    </head>
    <body
<div style="color: red; ">
			<struts:property value="message" />
		</div>

		<div align="center">
			<br/>
			<br/>

			<input type="button" class="button" value="View the Cart" onclick="location='<struts:url action="cart" includeParams="none"></struts:url>'" />
			
			<!--input type=button class="button" value="Continue Shopping &gt;&gt;" onclick="location='<struts:url action="category" includeParams="none" />?action=list'" /-->
			
		</div>

    </body>
</html>