import action.Daitch.DaitchMokotoff;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
/**
* @author	Anusha V
* @author	Narendiran P	
* @author	UmaMaheshwari
* @version	2010.0728
* @since	1.6.20
*/
public final class daimot_servlet extends HttpServlet 
{
	/**
	* Matches the code from the DaitchMokotoff class and compares it with the code obtained from the database and returns the matched names.
	*
	*Input characters are obtained from the user and is encoded using Daitch Mokotoof Algorithm, All the other names present in the database are encoded using the same daitch mokotoof algorithm
	*Both the codes are compared and the matching names are displayed
	*
	*@param	request - obtains the request given by the client
	*@param response - calculates the response and gives the client
	*
	*return hashmap- returns the matched characters from the database in a hashmap, if database connectivity fails throws an exception
	*
	*@exception Exception - All types of exception are caught
	*throws IO exception and Servlet Exception
	*
	*{@link action.Daitch.DaitchMokotoff }
	*/ 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws java.io.IOException, ServletException
	{
		PageContext pageContext = null;
		HttpSession session = null;
		ServletContext application = null;
		ServletConfig config = null;
		Object page = this;
		PageContext _jspx_page_context = null;
		PrintWriter out = response.getWriter();




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
		out.write("\t\t\t\t\t<form onsubmit=\"return formValidator()\" action=\"daimot_servlet\" align=\"center\" method=\"get\">\r\n");
		out.write("\t\t\t\t\t\t\t<b>Daitch Mokooto Algorithm</b><br></br>\r\n");
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
		String fname = request.getParameter("firstname");
		DaitchMokotoff DM = new DaitchMokotoff();
		String key, value,file = "Daitch Mokooto Req ";
		int flag = 0, t = 0;
		try
		{
			BufferedWriter output = new BufferedWriter(new FileWriter("C:/apache-tomcat-5.5.17/webapps/code/log.txt", true));
			if (fname == null)
				output.write(file);
			else
			{
				output.write(fname + " ");

				fname = fname.toUpperCase();
				String firstLetter = String.valueOf(fname.charAt(0)), sl = "", tl = "", fl = "", fil = "", sil = "", sel = "", el = "";

				if (fname.charAt(0) == 'A' || fname.charAt(0) == 'E' || fname.charAt(0) == 'I' || fname.charAt(0) == 'O' || fname.charAt(0) == 'U' || fname.charAt(0) == 'Y')
				{
					t = 5;
					firstLetter = "A";
					sl = "E";
					tl = "I";
					fl = "O";
					fil = "U";
					sil = "Y";
					if (fname.charAt(0) == 'Y')
					{
						fl = "J";
					}
					if (fname.charAt(0) == 'E' || fname.charAt(0) == 'I')
					{
						t = 6;
						sel = "J";
					}
				}
				if (fname.charAt(0) == 'J')
				{
					t = 2;
					sl = "Y";
					tl = "D";
				}

				if (fname.charAt(0) == 'B' || fname.charAt(0) == 'F' || fname.charAt(0) == 'P' || fname.charAt(0) == 'V' || fname.charAt(0) == 'W')
				{
					t = 4;
					firstLetter = "B";
					sl = "F";
					tl = "P";
					fl = "V";
					fil = "W";
				}

				if (fname.charAt(0) == 'D' || fname.charAt(0) == 'R' || fname.charAt(0) == 'S' || fname.charAt(0) == 'T' || fname.charAt(0) == 'Z')
				{
					t = 6;
					firstLetter = "C";
					sl = "J";
					tl = "R";
					fl = "S";
					fil = "T";
					sil = "Z";
					sel = "D";
				}
				if (fname.charAt(0) == 'C' || fname.charAt(0) == 'G' || fname.charAt(0) == 'H' || fname.charAt(0) == 'K' || fname.charAt(0) == 'Q' || fname.charAt(0) == 'X')
				{
					t = 5;
					firstLetter = "C";
					sl = "G";
					tl = "H";
					fl = "K";
					fil = "Q";
					sil = "X";
					if (fname.charAt(0) == 'C')
					{
						t = 7;
						sel = "S";
						el = "Z";
					}
				}
				if (fname.charAt(0) == 'M' || fname.charAt(0) == 'N')
				{
					t = 1;
					firstLetter = "M";
					sl = "N";
				}
				System.out.println(firstLetter);
				System.out.println(sl);
				System.out.println(tl);
				System.out.println(fl);
				System.out.println(fil);
				System.out.println(sil);
				System.out.println(sel);
				System.out.println(el);
				String str = "select * from Names where First_name like ?";
				String str1 = "select * from Names where First_name like ?";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection("jdbc:odbc:inaut", "", "");
				PreparedStatement ps = con.prepareStatement(str), ps1 = con.prepareStatement(str1);
				ps.setString(1, firstLetter + "%");
				ResultSet rs = ps.executeQuery(), rs1;
				String encode = "", inputEncode = "", encode1 = "";

				if (t == 1)
				{
					str = "select * from Names where First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					rs = ps.executeQuery();
				}

				if (t == 2)
				{
					str = "select * from Names where First_name like ? or First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					ps.setString(3, tl + "%");
					rs = ps.executeQuery();
				}

				if (t == 3)
				{
					str = "select * from Names where First_name like ? or First_name like ? or First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					ps.setString(3, tl + "%");
					ps.setString(4, fl + "%");
					rs = ps.executeQuery();
				}
				if (t == 4)
				{
					str = "select * from Names where First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					ps.setString(3, tl + "%");
					ps.setString(4, fl + "%");
					ps.setString(5, fil + "%");
					rs = ps.executeQuery();
				}
				if (t == 5)
				{
					str = "select * from Names where First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					ps.setString(3, tl + "%");
					ps.setString(4, fl + "%");
					ps.setString(5, fil + "%");
					ps.setString(6, sil + "%");
					rs = ps.executeQuery();
				}
				if (t == 6)
				{
					str = "select * from Names where First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					ps.setString(3, tl + "%");
					ps.setString(4, fl + "%");
					ps.setString(5, fil + "%");
					ps.setString(6, sil + "%");
					ps.setString(7, sel + "%");
					rs = ps.executeQuery();
				}
				if (t == 7)
				{
					str = "select * from Names where First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ? or First_name like ?";
					ps = con.prepareStatement(str);
					ps.setString(1, firstLetter + "%");
					ps.setString(2, sl + "%");
					ps.setString(3, tl + "%");
					ps.setString(4, fl + "%");
					ps.setString(5, fil + "%");
					ps.setString(6, sil + "%");
					ps.setString(7, sel + "%");
					ps.setString(8, el + "%");
					rs = ps.executeQuery();
				}

				HashMap<String, String> hm = new HashMap<String, String>();
				while (rs.next())
				{
					String name = rs.getString("FIRST_NAME");
					encode = DM.dmCode(name);
					hm.put(name, encode);
					//System.out.println(name+":"+encode);
				}
				ps.close();
				inputEncode = DM.dmCode(fname);
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
					encode1 = value;
					flag = 0;
					while (encode1.length() > 0)
					{
						String inputEncode1 = inputEncode;
						String encode2 = encode1.substring(0, 6);
						while (inputEncode1.length() > 0)
						{
							String inputEncode2 = inputEncode1.substring(0, 6);
							if (encode2.equals(inputEncode2))
							{
								flag = 1;
							}
							inputEncode1 = inputEncode1.substring(6);
						}
						encode1 = encode1.substring(6);
					}
					if (flag == 1)
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
							//System.out.println(firstName);
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