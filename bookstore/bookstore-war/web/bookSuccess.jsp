<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">

	<tiles:putAttribute name="content">

		<div align="center">
			<br/>
			<br/>
			
			<input type="button" class=button
				value="Add More"
				onclick="location='<struts:url action="book" includeParams="none"></struts:url>?action=add&category.cate_id=<struts:property value="category.cate_id" />'" />
			
			<input type="button" class=button
				value="View <struts:property value="category.cate_name" /> List"
				onclick="location='<struts:url action="category" includeParams="none"></struts:url>?parent.cate_id=<struts:property value="category.cate_id" />'" />

			<input type=button class="button" value="Enter The Store &gt;&gt;" onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />
			
		</div>

	</tiles:putAttribute>
	
</tiles:insertTemplate>
