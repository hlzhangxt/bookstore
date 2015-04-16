<%-- 
    Document   : tree
    Created on : 2015-4-15, 2015-4-15 21:00:24
    Author     : Administrator
--%>

<!--%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--%@ taglib prefix="struts" uri="/struts-tags"%-->
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head><script type="text/javascript" src="treefucntion.jsp"> </script> </head>
    
<body>    

         
             

             


<sx:tree id="root" rootNode="rootCategoryEO"
                                 nodeTitleProperty="cate_name" nodeIdProperty="cate_id"
                                 childCollectionProperty="subCategories">
</sx:tree>
    
    
</body>
</html>