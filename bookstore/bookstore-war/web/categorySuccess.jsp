<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>

<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">


		<div align="center">
			<br />
			<br />
			<input type=button class=button
				onclick="location='<struts:url action="category" />?action=add&parent.cate_id=<struts:property value="parent.cate_id" />'"
				value="Add More" />

			<input type="button" value="View The Cart" class=button
				onclick="location='<struts:url action="cart" includeParams="none"></struts:url>'" />

			<input type=button value="Enter The Store &gt;&gt;" class=button
				onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />

		</div>

	</tiles:putAttribute>
</tiles:insertTemplate>
