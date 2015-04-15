<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Book</title>
    </head>
    <body
        <div style="color: red; ">
            <struts:property value="message" />
        </div>
        <div align="center">
            <br/>
            <br/>

            <input type="button" class=button
                   value="Add More"
                   onclick="location = '<struts:url action="book" includeParams="none"></struts:url>?action=add&category.cate_id=<struts:property value="category.cate_id" />'" />

                   <input type="button" class=button
                          value="View <struts:property value="category.cate_name" /> List"
                   onclick="location = '<struts:url action="category" includeParams="none"></struts:url>?parent.cate_id=<struts:property value="category.cate_id" />'" />

                   <input type=button class="button" value="Enter The Store &gt;&gt;" onclick="location = '<struts:url action="category" includeParams="none" />?action=list'" />

        </div>

    </body>
</html>
