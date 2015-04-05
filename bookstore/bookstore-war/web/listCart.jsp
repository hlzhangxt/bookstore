<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>My Cart</title>

        <style>
            body, table, th, td { font-size: 12px;  }
            .table {
                border: 1px solid #000000; 
                border-collapse: collapse; 
                width: 100%; 
            }
            .table th {
                border: 1px solid #000000; 
                border-collapse: collapse; 
                background: #EEEEEE;
            }
            .table td {
                border: 1px solid #000000; 
                border-collapse: collapse; 
            }
            .button {
                color:#fff;
                font-weight:bold;
                font-size: 11px; 
                text-align:center;
                padding:.17em 0 .2em .17em;
                border-style:solid;
                border-width:1px;
                border-color:#9cf #159 #159 #9cf;
                background:#69c url(images/bg-btn-blue.gif) repeat-x;
            }
        </style>



    </head>
    <body>
        <div style="color: red; ">
            <struts:property value="message" />
        </div>
        <h4>My Cart</h4>

        <table class="table" style="margin-top: 10px; border: 1px solid #660F66; border-spacing: 5px;">
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Name</th>
                <th>Price</th>
                <th>Count</th>
                <th>Total</th>
                <th>Time</th>
            </tr>
            <struts:set name="bookCount" value="0"></struts:set>
            <struts:set name="priceCount" value="0"></struts:set>
            <struts:iterator value="cart.cartItems">
                <struts:set name="bookCount" value="#request.bookCount + count"></struts:set>
                <struts:set name="priceCount" value="#request.priceCount + count * book_price"></struts:set>
                <%-- 
                --%>
                <tr>
                    <td align="center"><struts:property value="item_id"/> </td>
                    <td><struts:property value="cate_name"/></td>
                    <td><struts:property value="book_name"/> </td>
                    <td align="center">$<struts:property value="book_price"/> </td>
                    <td align="center"><struts:property value="count"/> </td>
                    <td align="center">$<struts:property value="count * book_price"/> </td>
                    <td align="center"><struts:property value="item_date"/> </td>
                </tr>
            </struts:iterator>
            <tr>
                <th>Total</th>
                <th colspan="3">&nbsp;</th>
                <th>${ petCount }</th>
                <th>$${ priceCount }</th>
                <th>&nbsp;</th>
            </tr>
        </table>

        <div align=center>
            <br /><br />
            <input type=button class=button value="Pay" onclick="if (!confirm('Are you sure to pay now？'))
                        return;
                    location = '<struts:url action="cart" includeParams="none" />?action=pay'" />
            <input type=button class=button value="Continue Shopping &gt;&gt;" onclick="location = '<struts:url action="category" includeParams="none" />?action=list'" />
        </div>

    </body>
</html>