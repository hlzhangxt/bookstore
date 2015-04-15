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

        <h4>Current Category：
            <a
                href="<struts:url action="category" includeParams="none" />?parent.cate_id=<struts:property value="category.cate_id" />">
                <struts:property value="book.category.cate_name" />
            </a>
        </h4>

        <struts:form action="book">
            <struts:hidden name="action" value="buy"></struts:hidden>
            <struts:hidden name="book.book_id"></struts:hidden>
            <struts:textfield name="book.book_name" label="Book Name" readonly="true"></struts:textfield>
            <struts:textfield name="book.book_price" label="Book Price" readonly="true"></struts:textfield>
            <struts:textfield name="count" label="Count"></struts:textfield>
            <struts:submit value="Submit" cssClass="button"></struts:submit>
        </struts:form>

    </body>
</html>