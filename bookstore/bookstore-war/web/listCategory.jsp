<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<!--%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%-->
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>	
<tiles:insertTemplate template="/template.jsp" flush="true">
    <tiles:putAttribute name="content">

        <h4>
            Current Category：
            <struts:property value="parent.cate_name" />
        </h4>

        <input type=button class=button onclick="location = '<struts:url action="category" includeParams="none" />?action=add&parent.cate_id=<struts:property value="parent.cate_id" />'" value="Add Category" />

        <struts:if test="parent != null">
            <input type=button class=button onclick="location = '<struts:url action="book" includeParams="none" />?action=add&category.cate_id=<struts:property value="parent.cate_id" />'" value="Add Book" />
            <input type=button class=button onclick="if (!confirm('Are you sure to delete it？'))
                            return;
                        location = '<struts:url action="category" includeParams="none" />?action=delete&parent.cate_id=<struts:property value="parent.cate_id" />';" value="Delete The Category" />
        </struts:if>
        <br/>
        <br/>

        <table class="table">
            <tr>
                <th>ID</th>
                <th>Category</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            <struts:iterator value="bookList">
                <tr>
                    <td><struts:property value="id"/> </td>
                    <td><a href="<struts:url action="category" includeParams="none" />?parent.cate_id=<struts:property value="category.cate_id"/>"><struts:property value="category.cate_name"/></a></td>
                    <td><struts:property value="name"/> </td>
                    <td>￥<struts:property value="price"/> </td>
                    <td><a href="<struts:url action="book?action=buy" includeParams="none" />&book.book_id=<struts:property value="book_id"/>">Buy</a> </td>
                </tr>
            </struts:iterator>
        </table>

    </tiles:putAttribute>
</tiles:insertTemplate>