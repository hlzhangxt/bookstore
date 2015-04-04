<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title><struts:property value="title" /></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="online,book,Store">
		<meta http-equiv="description" content="Online Book Store">
		<struts:head theme="ajax" debug="false" />
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

		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
	
		<table width="100%" style="background: #EEFFEE; border: 1px solid #66FF66; ">
			<tr>
				<td>
					<a href="<struts:url action="category" includeParams="none"></struts:url>">Welcome</a>
				</td>
				<td align="right">
					<struts:if test="%{#session.customer == null}">
						<a href="<struts:url action="customer?action=login" includeParams="none"></struts:url>">Log in</a> | 
						<a href="<struts:url action="customer?action=register" includeParams="none"></struts:url>">Register</a> |
						<a href="<struts:url action="category" includeParams="none"></struts:url>">Enter The Store</a> |
						<a href="<struts:url action="cart" includeParams="none"></struts:url>">My Cart</a>
					</struts:if>
					<struts:else>
						Welcome，<struts:property value="#session.customer.login_name" /> 
						<a href="<struts:url action="customer?action=logout" includeParams="none"></struts:url>">Log out</a> | 
						<a href="<struts:url action="category" includeParams="none"></struts:url>">Enter The Store</a> |
						<a href="<struts:url action="cart" includeParams="none"></struts:url>">My Cart</a>
					</struts:else>
				</td>
			</tr>
		</table>

		<table width="100%" style="margin-top: 5px; ">
			<tr>
				<td valign="top" width="200" style="background: #EEFFEE; border: 1px solid #66FF66; ">
					<struts:tree id="root" theme="ajax" rootNode="rootCategory"
						nodeTitleProperty="name" nodeIdProperty="cate_id"
						childCollectionProperty="subCategories" onclick="location='ss'" />

					<script type="text/javascript">
						document.body.onload = function() {
							var root = dojo.widget.byId('0'); 
							expand(root); 
						}
						function expand(node) {
							node.expand();
							var children = node.children;  
							for(var i=0; i<children.length; i++) {
								var child = children[i];
								expand(child); 
							}
							dojo.event.connect(node, 'onselect', nodeSelected);
						}
						function nodeSelected() {
							var node = dojo.widget.byId('root').selector.selectedNode;
							// alert(node.widgetId + '\r\n' + node.title); 
							location = "<struts:url action="category" includeParams="none" />?parent.cate_id=" + node.widgetId;
						}
					</script>

					<input type=button value="View the Category" onclick="nodeSelected()" class="button" />

				</td>
				<td valign="top" style="padding: 10px; ">
				
					<struts:if test="%{ message != null && message.length() > 0 }">
						<div style="color: red; padding: 10px; background: #FFEEEE; border: 1px solid red; ">
							<struts:property value="message" />
						</div>
					</struts:if>
					
					<tiles:getAsString name="content" />
					
				</td>
			</tr>
		</table>

	</body>
</html>
