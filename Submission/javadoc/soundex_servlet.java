import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import action.Sound.Soundex;
/**
* @author	Anusha V
* @author	Narendiran P	
* @author	UmaMaheshwari
* @version	2010.0728
* @since	1.6.20
*/   
public final class soundex_servlet extends HttpServlet 
{
	/**
	* Matches the code from the Soundex class and compares it with the code obtained from the database and returns the matched names.
	*
	*Input characters are obtained from the user and is encoded using Soundex Algorithm, All the other names present in the database are encoded using the same Soundex algorithm
	*Both the codes are compared and the matching names are displayed
	*
	*@param	request - obtains the request given by the client
	*@param response - calculates the response and gives the client
	*
	*@return hashmap- returns the matched characters from the database in a hashmap, if database connectivity fails throws an exception
	*
	*@exception Exception - All types of exception are caught
	*throws IO exception and Servlet Exception
	*
	*{@link action.Sound.Soundex } extends the Soundex class and HttpServlet class
	*/ 
	
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws java.io.IOException, ServletException 
		{
		    PageContext pageContext = null;
		    HttpSession session = null;
		    ServletContext application = null;
		    ServletConfig config = null;
		    Object page = this;
		    PageContext _jspx_page_context = null;
		    PrintWriter out=response.getWriter();

    			
      

			      out.write("<html>\r\n");
			      out.write("\t\t<head>\r\n");
			      out.write("\t\t\t\t<title>\r\n");
			      out.write("\t\t\t\t\t\tChoose Algo\r\n");
			      out.write("\t\t\t\t</title>\r\n");
			      out.write("\t\t</head>\r\n");
			      out.write("\r\n");
			      out.write("\t\t<body bgcolor=\"lightblue\" forecolor=\"lightblue\">\r\n");
			      out.write("\t\t\t\t<script language=\"javascript\" src=\"sound1.js\">\r\n");
			      out.write("\r\n");
			      out.write("\t\t\t\t</script>\r\n");
			      out.write("\t\t\t\t\t<br></br>\r\n");
			      out.write("\t\t\t\t\t<center>\r\n");
			      out.write("\t\t\t\t\t<form onsubmit=\"return formValidator()\" action=\"soundex_servlet\" align=\"center\" method=\"get\">\r\n");
			      out.write("\t\t\t\t\t\t\t<b>Sound-Ex Algorithm</b><br></br>\r\n");
			      out.write("\t\t\t\t\t\t\t\tName: <input type=\"text\" id=\"firstname\" name=\"firstname\" /><br />\r\n");
			      out.write("\t\t\t\t\t\t\t\t\t\t\t<br/>\r\n");
			      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type='submit' value='Show' />\r\n");
			      out.write("\t\t\t\t\t</form>\r\n");
			      out.write("\t\t\t\t\t\r\n");
			      out.write("\t\t\t\t\t\r\n");
			      out.write("\t\t\t\t\t\r\n");
			      out.write("\t\t\t\t\t\t\t\r\n");
			      out.write("\t\t\t\t\t\t\t\r\n");
			      out.write("\t\t\t\t\t");
				String fname=request.getParameter("firstname");
				String inputEncode, key, value, file = "Sound-Ex Req ";
				Soundex S = new Soundex();
				fname = fname.toUpperCase();
				try
				{
					BufferedWriter output = new BufferedWriter(new FileWriter("C:/apache-tomcat-5.5.17/webapps/code/log.txt", true));
					if (fname == null)
						output.write(file);
					else
					{
						output.write(fname + " ");
						fname = fname.toUpperCase();
						String firstLetter = String.valueOf(fname.charAt(0));
						String str = "select * from Names where First_name like ?";
						String str1 = "select * from Names where First_name like ?";
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						Connection con = DriverManager.getConnection("jdbc:odbc:inaut", "", "");
						PreparedStatement ps = con.prepareStatement(str), ps1 = con.prepareStatement(str1);
						ps.setString(1, firstLetter + "%");
						ResultSet rs = ps.executeQuery(), rs1;
						String encode;
						HashMap<String, String> hm = new HashMap<String, String>();
						while (rs.next())
						{
							String name = rs.getString("FIRST_NAME");
							encode = S.soundEx(name);
							hm.put(name, encode);
						}
						ps.close();

						inputEncode = S.soundEx(fname);
						Set set = hm.entrySet();
						Iterator i = set.iterator();

						out.write("\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\tMATCHING NAMES FOR ");
						out.print(fname);
						out.write("\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t<br></br>\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t<table border=\"1\">\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th>ID</th>\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th>FIRST_NAME</th>\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th>LAST_NAME</th>\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<th>AGE</th>\r\n");
						out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
						out.write("\t\t\t\t\t");

						while (i.hasNext())
						{
							Map.Entry me = (Map.Entry)i.next();
							key = String.valueOf(me.getKey());
							value = String.valueOf(me.getValue());
							if (value.equals(inputEncode))
							{
								ps1.setString(1, key);
								rs1 = ps1.executeQuery();
								while (rs1.next())
								{
									int id = rs1.getInt("ID");
									String firstName = rs1.getString("FIRST_NAME");
									String lastName = rs1.getString("LAST_NAME");
									int age = rs1.getInt("AGE");

									out.write("\r\n");
									out.write("\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
									out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
									out.print(id);
									out.write("</td>\r\n");
									out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
									out.print(firstName);
									out.write("</td>\r\n");
									out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
									out.print(lastName);
									out.write("</td>\r\n");
									out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>");
									out.print(age);
									out.write("</td>\r\n");
									out.write("\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
									out.write("\t\t\t\t\t");

								}

								out.write("\r\n");
								out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
								out.write("\t\t\t\t\t");

							}
						}

						out.write("\r\n");
						out.write("\t\t\t\t\t\t\t\t</table>\r\n");
						out.write("\t\t\t\t\t");
						ps1.close();
						con.close();
					}
					output.close();
				}

				catch (Exception e)
				{
					out.write("\r\n");
					out.write("\t\t\t\t\t");
					out.print("caught" + e);
					out.write("Please Try after sometime");
					//out.write("\t\t\t\t\t<a href=\"http://localhost/code/action/try.jsp\">Home Page</a></center>\r\n");
					out.write("\r\n");
					out.write("\t\t\t\t\t");

				}	
						      out.write("\r\n");
						      out.write("\t\t\t\t\t\t<a href=\"http://localhost/code/action/try.jsp\">Home Page</a></center>\r\n");
						      out.write("\t\t\t\t</body>\r\n");		
						      out.write("</html>\r\n");
						      out.write("\r\n");
						      out.write("\r\n");
				       
			     
  }
}
