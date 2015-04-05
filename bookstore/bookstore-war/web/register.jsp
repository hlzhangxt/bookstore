<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Registration</title>
    </head>
    <body>		
        <h4>Registration</h4>

        <form action="customer">
            <input type="hidden" name="action" value="register"></input>
            <input type="text" name="customer.login_name" label="Account"></input>
            <input type="password" name="customer.login_pass" label="Password"></input>
            <input type="password" name="customer.confPass" label="Password Again"></input>
            <input type="submit" value="Register" cssClass="button"></input>
            <form>

                </body>
                </html>