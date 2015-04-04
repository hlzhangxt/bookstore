<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
	
<tiles:insertTemplate template="/template.jsp" flush="true">
	<tiles:putAttribute name="content">
		
		<h4>My Cart(Paid)</h4>
		
		<table class="table">
			<tr>
				<th>ID</th>
				<th>Category</th>
                                <th>Name</th>
				<th>Price</th>
				<th>Count</th>
				<th>Total</th>
			</tr>
			<struts:set name="bookCount" value="0"></struts:set>
			<struts:set name="priceCount" value="0"></struts:set>
			<struts:iterator value="cart.cartItems">
				<struts:set name="bookCount" value="#request.bookCount + count"></struts:set>
				<struts:set name="priceCount" value="#request.priceCount + count * price"></struts:set>
				<%-- 
				--%>
				<tr>
					<td align="center"><struts:property value="id"/> </td>
					<td><struts:property value="bookCategoryName"/></td>
					<td><struts:property value="bookName"/> </td>
					<td align="center">$<struts:property value="price"/> </td>
					<td align="center"><struts:property value="count"/> </td>
					<td align="center">$<struts:property value="count * price"/> </td>
				</tr>
			</struts:iterator>
			<tr>
				<th>Total</th>
				<th colspan="3">&nbsp;</th>
				<th>${ petCount }</th>
				<th>$${ priceCount }</th>
			</tr>
		</table>
		
		<div align=center>
			<br /><br />
			<input type=button class=button value="Pay" onclick="if(!confirm('Are you sure to pay？'))	return; location='<struts:url action="cart" includeParams="none" />?action=pay'" disabled="true" />
			<input type=button class=button value="Continue Shopping &gt;&gt;" onclick="location='<struts:url action="category" includeParams="none" />?action=list'" />
		</div>

	</tiles:putAttribute>
</tiles:insertTemplate>
