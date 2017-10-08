<%--     http://localhost:8080/web8/html/thirdJsp.jsp     --%>


<br/> ================= <br/> 
     this is third jsp, no way to see this because all page will forward
<br/> ================= <br/> 

<%
String destination ;
if(Math.random() > 0.5){
    destination = "include_01.jsp";
  }else{
    destination = "include_02.jsp";    
  }
%>

<br/> befoer forward <br/>
<br/> befoer forward <br/>
<br/> befoer forward <br/>

<jsp:forward  page="<%= destination %>" />

<br/> after  forward <br/>
<br/> after  forward <br/>
<br/> after  forward <br/>
