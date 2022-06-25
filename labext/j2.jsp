<html>
<body>
<%
String str1 = request.getParameter("name");
String str2 = request.getParameter("age");
String str3 = request.getParameter("add");
String str4 = request.getParameter("list");
if(str3 != null){
Cookie c1 = new Cookie(str1, str2);
response.addCookie(c1);
}
else if(str4 != null){
Cookie clientCookies[] = request.getCookies();
for( int i = 0; i < clientCookies.length; i++){
out.print("<b>" + clientCookies[i].getName() + " : " + clientCookies[i].getValue() +
"</b><br>");
}
}
%>
</body>
</html>