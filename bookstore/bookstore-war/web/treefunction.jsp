<%-- 
    Document   : treefunction
    Created on : 2015-4-15, 2015-4-15 22:11:39
    Author     : Administrator
--%>

  <!--script language="JavaScript" type="text/javascript"-->
                   //    alert('test');
                       autoexpand();  
                      function autoexpand(){
                         var node = dojo.widget.byId('0')
                         
                         
                         expand(node);
                         
                         var s = dojo.widget.byId('root').selector;
                           
                         dojo.event.connect(s, 'select', 'nodeSelected');        
                        }
                        
                        function expand(node) {
                            node.expand();
                            var children = node.children;
                            for (var i = 0; i < children.length; i++) {
                                var child = children[i];
                                expand(child);
                            }
                            
                       //   dojo.event.connect(node, 'onselect', nodeSelected);
                         
                        }
                        function nodeSelected(node) {
                           // var node = dojo.widget.byId('root').selector.selectedNode;
                           
                            document.getElementById("content").src = "<struts:url action="category" includeParams="none" />?parent.cate_id=" + node.source.widgetId;
                        }
                      
                        
                        
    <!--/script--> 
