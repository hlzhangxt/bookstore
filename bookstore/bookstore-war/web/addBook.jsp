<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">

		<h4>
		Current Category：
		<a href="<struts:url action="category" includeParams="none" />?parent.id=<struts:property value="category.cate_id" />"><struts:property value="category.cate_name" /></a>
		</h4>
		
		<div style="color: red; ">
			<struts:property value="message" />
		</div>
	
		<struts:form action="book">
			<struts:hidden name="action" value="add"></struts:hidden>
			<struts:hidden name="category.cate_id"></struts:hidden>
			<struts:label name="category.cate_name" label="Category" disabled="true"></struts:label>
			<struts:textfield name="book.book_name" label="Book Name"></struts:textfield>
			<struts:textfield name="book.book_price" label="Book Price"></struts:textfield>
			<struts:submit value="Submit" cssClass="button"></struts:submit>
		</struts:form>
					
	</tiles:putAttribute>
</tiles:insertTemplate>