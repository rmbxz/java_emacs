<%--  http://localhost:8080/web8/html/myIsError.jsp --%>

<br/> ================= <br/>
         ahmad error
<br/> ================= <br/>


<%@ page isErrorPage="true" %>
<%= "exception = "+ exception  %> 

<br/> ================= <br/>

<%@ page import="java.io.*" %>
<% 
   out.println("my print stack trace <br/>");
   exception.printStackTrace(new PrintWriter(out));
%> 
