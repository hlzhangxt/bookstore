<%-- 
    Document   : Hello
    Created on : 2015-4-4, 11:23:59
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <s:if test="%{ message != null && message.length() > 0 }">
            <div style="color: red; padding: 10px; background: #FFEEEE; border: 1px solid red; ">
                <s:property value="message" />
            </div>
        </s:if>
    </body>
</html>
