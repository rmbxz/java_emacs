<%--  http://localhost:8080/web8/html/myError.jsp --%>


<!-- this is override of   <error-page> in web.xml -->
<%@ page errorPage="myIsError.jsp" %>

<%
int x = Integer.parseInt(request.getParameter("n1"));  
int y = Integer.parseInt(request.getParameter("n2"));  
int z= x/y;    
 %> 

<br/> ================= <br/>

good number and good division

<br/> ================= <br/>
