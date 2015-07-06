<html>
<head>
	<title> name search algorithms</title>

<script language="javascript" src="try1.js">

</script>
</head>
	
<hr><FONT COLOR=BLUE>
<H1>
<center>CHOOSE YOUR SEARCH ALGORITHM
</H1>
</font>
<BR><BR><center>
	<form>
		<INPUT TYPE="radio" NAME="select" id="radio1" VALUE="1" >SOUNDEX ALGORITHM<br></br>
		<INPUT TYPE="radio" NAME="select" id="radio2" VALUE="2" >METAPHONE ALGORITHM<br></br>
		<INPUT TYPE="radio" NAME="select" id="radio3" VALUE="3" >PHONEX ALGORITHM<br></br>
		<INPUT TYPE="radio" NAME="select" id="radio4" VALUE="4" >DAITCH-MOKOTOOF ALGORITHM<br></br></h1>
		<input type="button" name="button1" value="Submit" onclick="goto();">
		
	</form></center>
	<br><br>
<%@ page import="java.net.*" %>
			<%@ page import="java.util.*" %>
			<%@ page import="java.text.*" %>
			<%@ page import="java.io.*" %>
			<%
			try
			{
				BufferedWriter output=new BufferedWriter(new FileWriter("C:/apache-tomcat-5.5.17/webapps/code/log.txt",true));
				BufferedReader input=new BufferedReader(new FileReader("C:/apache-tomcat-5.5.17/webapps/code/log.txt"));
				InetAddress thisIp =InetAddress.getLocalHost();
				Date now=new Date();
				DateFormat df=new SimpleDateFormat("dd.MMM.yyyy hh:mm:ss ");
				String S=String.valueOf(thisIp.getHostAddress()+" "+df.format(now));
				if(input.readLine()!=null)
						S="\n"+S; 
				output.write(S);
				output.close();
			}
			catch(IOException e)
			{
			%>
			<%="caught:"+e%>
			<%
			}
			catch(Exception e)
			{
			%>
			<%="caught:"+e%>
			<%
			}
			%>	
	<center>
	<a href="index.html">Description about algorithms</a><br><br>
	<a href="http://localhost/code/metaphone_servlet">Search Using Default Search</a>
	<BR><BR><BR><hr>
</BODY>
</HTML>