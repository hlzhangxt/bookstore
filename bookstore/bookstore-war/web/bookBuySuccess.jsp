<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">

	<tiles:putAttribute name="content">

		<div align="center">
			<br/>
			<br/>

			<input type="button" class="button" value="View the Cart" onclick="location='<struts:url action="cart" includeParams="none"></struts:url>'" />
			
			<input type=button class="button" value="Continue Shopping &gt;&gt;" onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />
			
		</div>

	</tiles:putAttribute>
	
</tiles:insertTemplate>
