<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Category</title>
    </head>
    <body

                <div style="color: red; ">
			<struts:property value="message" />
		</div>
		<h4>
			Add Category 
			
		</h4>
                	
		<struts:form action="category">
			<struts:hidden name="action" value="add"></struts:hidden>
			<struts:hidden name="parent.cate_id"></struts:hidden>
			<struts:if test="%{ parent != null }">
				<struts:label name="parent.cate_name" label="Parent Category"></struts:label>
			</struts:if>
			<struts:textfield name="category.cate_name" label="Category Name"></struts:textfield>
			<struts:submit value="Add" cssClass="button"></struts:submit>
		</struts:form>
						
   </body>
</html>