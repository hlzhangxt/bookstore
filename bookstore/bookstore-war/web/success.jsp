<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
    <head>
       
        <title>Success</title>
    </head>
    <body>

<div style="color: red; ">
			<struts:property value="message" />
		</div>

        <div align="center">
            <br/>
            <br/>

            <input type="button" class="button" value="View The Cart" onclick="location = '<struts:url action="cart" includeParams="none"></struts:url>'" />

                <input type=button class="button" value="Enter The Store &gt;&gt;" onclick="location = '<struts:url action="category" includeParams="none" />?action=list'" />

        </div>

    </body>
</html>