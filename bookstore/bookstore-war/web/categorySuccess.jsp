<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Success Category Management</title>
        
        <script language="Javascript">
    setTimeout("parent.location.reload();",2000);
</script>
        
    </head>
    <body>
        <div style="color: red; ">
            <struts:property value="message" />
        </div>
        <!--div align="center">
            <br />
            <br />
            <input type=button class=button
                   onclick="location = '<struts:url action="category" />?action=add&parent.cate_id=<struts:property value="parent.cate_id" />'"
                   value="Add More" />

            <input type="button" value="View The Cart" class=button
                   onclick="location = '<struts:url action="cart" includeParams="none"></struts:url>'" />

                   <!--input type=button value="Enter The Store &gt;&gt;" class=button
                          onclick="location = '<struts:url action="category" includeParams="none" />?action=list'" /-->

        </div-->

        
        
        
    </body>
</html>
