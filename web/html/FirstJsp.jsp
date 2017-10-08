<%--  http://localhost:8080/web8/html/addJsp.jsp --%>
<%--  http://localhost:8080/web8/html/FirstJsp.jsp --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:useBean id= "cust"
	     scope="session" 
	     class="webServlet.test.CustomerBean"  />


<% 
cust.setName(request.getParameter("name"));
cust.setEmail(request.getParameter("email"));
cust.setPhone(request.getParameter("phone"));
%> 


<%--  
<jsp:setProperty name="cust" property="*" />

<jsp:setProperty name="cust" property="name"  />
<jsp:setProperty name="cust" property="email" />
<jsp:setProperty name="cust" property="phone" />

--%>
 
name::: => <jsp:getProperty name="cust" property="name" /> <br/>
email::: => <jsp:getProperty name="cust" property="email" /> <br/>
phone::: => <jsp:getProperty name="cust" property="phone" /> <br/>


<br/> ====same phone======<br/>
      ${cust.phone}                  <br/>   
      ${sessionScope.cust.phone}     <br/>
      <jsp:getProperty name="cust" property="phone" /> <br/>
<br/> ====same phone======<br/>


from parameters <br/>

${param.name}  <br/>
${param.email}  <br/>
${param.phone}  <br/>


<br/> ====================<br/>

<%-- attribute scope order   --%>
<%-- search order for  attribute page,request,session,application attribute   --%>
<c:set var="myScope"  scope="page"   value="myScope_page"/>
<c:set var="myScope"  scope="request"   value="myScope_request"/>
<c:set var="myScope"  scope="session"   value="myScope_session"/>
<c:set var="myScope"  scope="application"   value="myScope_application"/>

<%-- search order for  attribute page,request,session,application attribute   --%>
${myScope} <br/>
${myScope} <br/>
${myScope} <br/>
${myScope} <br/>


<br/> ====================<br/>


<br/>
<%-- examples form  http://www.java2s.com/Code/Java/JSTL/JSTLSetVariablesScope.htm   --%>

<c:set var="name"  scope="page"   value="a1"/>
<c:set var="age"  scope="request"   value="b2"/>
<c:set var="gender"  scope="session"   value="male"/>
<c:set var="address"  scope="application"   value="jordan"/>

name = ${pageScope.name} <br/>
age = ${requestScope.age} <br/>
gender = ${sessionScope.gender} <br/>
address = ${applicationScope.address} <br/>
<br/> ====================<br/>
<c:out value= "${pageScope.name}"  /> <br/>
<c:out value= "${requestScope.age}"  /> <br/>
<c:out value= "${sessionScope.gender}"  /> <br/>
<c:out value= "${applicationScope.address}"  /> <br/>
<br/> ====================<br/>

<%=  
"<a href="+ response.encodeURL("SecondJsp.jsp")  + ">second jsp</a>"
%>
<br/>

<a href=<c:url value='SecondJsp.jsp' />>second jsp</a>
<a href=<c:url value='SecondJsp.jsp' />> soso </a> 


<%  pageContext.getAttribute("attribute"); %> 

<br/> ====================<br/>




<%--  
start comment

 directive 

<%@ page import="java.util.*" %>
<%@ page contentType="MIME-Type" %>
<%@ page isThreadSafe="true" %>
<%@ page session="true" %>
<%@ page buffer="8kb" %>
<%@ page autoflush="true" %>
<%@ page extends="package.class" %>
<%@ page info="message" %>
<%@ page isErrorPage="false" %>
<%@ page errorPage="url" %>

<%@ include file="url" %>

 Actions 

<jsp:useBean id= "beanName"
	     scope="scope"
             class= "package.className"
             type=
/>

<jsp:setProperty name="bean" property="property" />

<jsp:getProperty name="bean" property="property" />


 el expression 

${pageScope} 
${requestScope} 
${sessionScope.attribute.first} 
${applicationScope} 
${param.name} 
${paramValues}  
${header} 
${headerValues} 
${cookie.name.value} 
${initParam} 
${pageContext} 


 jsp-jstl 

<c:if test=”${not empty errorMsgs}”>
</c:if>
<c:out value= "${scope}"  />

<c:set var="name"  scope="scope"   value="value"/>
<c:set target="map bean"  scope="scope"  property="bean property"  value="value"/>

<form action=’<c:url value=”play.do” />’ method="POST">

    <c:forEach var=”message” items=”${errorMsgs}”>
	<li>${message}</li>
    </c:forEach>

    end of comment
    --%>

    <br/> ====================<br/>

    request query string = <%= 	request.getQueryString() %> 

    <br/> ====================<br/>
    <%!  int count =0;   %>
    <%=  "count= "+ (count++)   %>

    <br/> ====================<br/>

    <%--  
    directive 

    <%@ page import="java.util.*" %>
    <%@ page contentType="MIME-Type" %>
    <%@ page isThreadSafe="true" %>
    <%@ page session="true" %>
    <%@ page buffer="8kb" %>
    <%@ page autoflush="true" %>
    <%@ page extends="package.class" %>
    <%@ page info="message" %>
    <%@ page isErrorPage="false" %>
    <%@ page errorPage="url" %>

    <%@ include file="url" %>



    <%@ page import="java.util.*" %> more than once 
    <%@ page contentType="text/html" %>  as default
    <%@ page pageEncoding="ISO-8859-1"%> as default
    <%@ page session="false" %>  dont use session in this page 
    <%@ page isELIgnored="true" %>  stop using EL ${} at this page
    <%@ page buffer="8kb" %> must have 8kb, then send it to client
    <%@ page buffer="none" %> send data directly to client, so the client will see the page line by line as generated 
    <%@ page autoflush="true" %> as default delete full  buffer, 
    <%@ page autoflush="false" %> dont  delete full  buffer, cant use it with buffer=none 
    <%@ page info="message hiiiii" %>     public String getServletInfo(){return "copyright 2007-1010";} 
    <%@ page errorPage="url" %> go to url when exception occur, 
    <%@ page isErrorPage="true" %> this page exception page
    

    --%>
    <br/> =======jsp:include============= <br/>
    <%-- output at runtime many servlet, autochange , it is include RequestDispatcher   --%>
    <jsp:include  page="include_01.jsp" />

    <br/> ======@include============== <br/>
    <%-- copy/paste merge  at translattion time(generate servlet) include code inside  servlet, not autochange    --%>
    <%@ include file="include_02.jsp" %>

    <br/> ==================== <br/>
