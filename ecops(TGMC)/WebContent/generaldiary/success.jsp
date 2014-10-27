<%@taglib uri="/WEB-INF/clientsidexsl.tld" prefix ="csxsl" %>
<csxsl:xml-stylesheet stylesheet="/elites/generaldiary/generaldiary.xsl" stylesheetWD="/elites/generaldiary/generaldiary.xsl">
</csxsl:xml-stylesheet>
<% String to_print="";
 to_print=(String)request.getAttribute("str");
 try{
 out.print("<y>"+" "+to_print+" "+"</y>");}
 catch(Exception e){
 System.out.print("in catch");
 }
 %>