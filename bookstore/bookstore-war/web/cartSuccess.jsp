<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>My Cart(Paid)</title>
    </head>
    <body>
<div style="color: red; ">
			<struts:property value="message" />
		</div>
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
                    <td align="center"><struts:property value="item_id"/> </td>
                    <td><struts:property value="cate_name"/></td>
                    <td><struts:property value="book_name"/> </td>
                    <td align="center">$<struts:property value="book_price"/> </td>
                    <td align="center"><struts:property value="count"/> </td>
                    <td align="center">$<struts:property value="count * book_price"/> </td>
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
            <input type=button class=button value="Pay" onclick="if (!confirm('Are you sure to pay？'))
                        return;
                    location = '<struts:url action="cart" includeParams="none" />?action=pay'" disabled="true" />
            <input type=button class=button value="Continue Shopping &gt;&gt;" onclick="location = '<struts:url action="category" includeParams="none" />?action=list'" />
        </div>

    </body>
</html>
