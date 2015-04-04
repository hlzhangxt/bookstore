<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles"
	prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">

		<h4>Current Category：
		<a
			href="<struts:url action="category" includeParams="none" />?parent.cate_id=<struts:property value="category.cate_id" />"><struts:property
				value="category.cate_name" />
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

	</tiles:putAttribute>
</tiles:insertTemplate>
