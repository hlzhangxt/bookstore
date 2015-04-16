<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Category</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <!--style>
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
		</style-->
        
        
    </head>
    <body>
        <div style="color: red; ">
            <struts:property value="message" />
        </div>
        <h4>
            Current Category：
            <struts:property value="parent.cate_name" />
        </h4>
        <struts:if test="%{#session.customer.login_name == 'admin'}">
        <input type=button class=button onclick="location = '<struts:url action="category" includeParams="none" />?action=add&parent.cate_id=<struts:property value="parent.cate_id" />'" value="Add Category" />

        <struts:if test="parent != null">
            <input type=button class=button onclick="location = '<struts:url action="book" includeParams="none" />?action=add&category.cate_id=<struts:property value="parent.cate_id" />'" value="Add Book" />
            <!--input type=button class=button onclick="if (!confirm('Are you sure to delete it？'))
                    return;
                location = '<struts:url action="category" includeParams="none" />?action=delete&parent.cate_id=<struts:property value="parent.cate_id" />';" value="Delete The Category" /-->
        </struts:if>
        </struts:if>
        <br/>
        <br/>

        <table class="table" style="margin-top: 10px; border: 1px solid #660F66; border-spacing: 5px;">
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            <struts:iterator value="bookList">
                <tr>
                    <td><struts:property value="book_id"/> </td>
                    <td><a href="<struts:url action="category" includeParams="none" />?parent.cate_id=<struts:property value="category.cate_id"/>"><struts:property value="category.cate_name"/></a></td>
                    <td><struts:property value="book_name"/> </td>
                    <td>$<struts:property value="book_price"/> </td>
                    
                    <td><struts:if test="%{#session.customer.login_name != 'admin'}"><a href="<struts:url action="book" includeParams="none" />?action=buy&book.book_id=<struts:property value="book_id"/>">Buy</a> </struts:if></td>
                    
                </tr>
            </struts:iterator>
        </table>

    

</body>
</html>