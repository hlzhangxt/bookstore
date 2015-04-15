<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="struts"%>
<html>
    <head>
       <link rel="stylesheet" type="text/css" href="style.css">
        <title>Welcome</title>
        
        
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
       
     <script type="text/javascript">
       function Redirect (url) {
       var ua        = navigator.userAgent.toLowerCase(),
        isIE      = ua.indexOf('msie') !== -1,
        version   = parseInt(ua.substr(4, 2), 10);

    // Internet Explorer 8 and lower
      if (isIE && version < 9) {
        var link = document.createElement('a');
        link.href = url;
        document.body.appendChild(link);
        link.click();
     }

    // All other browsers
      else { window.location.href = url; }
     }    
     
     Redirect("category.action?action=root");
     
     </script>>    
        
        
        
        
    </head>
    <!--body>

<div style="color: red; ">
			<struts:property value="message" />
</div>

        <div align="center">
            <br/>
            <br/>

            <input type="button" class="button" value="View The Cart" onclick="location = '<struts:url action="cart" includeParams="none"></struts:url>'" />

                <!--input type=button class="button" value="Enter The Store &gt;&gt;" onclick="location = '<struts:url action="category" includeParams="none" />?action=list'" /-->

        </div>
            
            <!--script type="text/javascript">
                window.location.reload();
            </script-->
                
                

    </body-->
</html>