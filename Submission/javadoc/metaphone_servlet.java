import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.Comparator;
import java.io.*;
import action.meta.Metaphone;
/**
* @author	Anusha V
* @author	Narendiran P	
* @author	UmaMaheshwari
* @version	2010.0728
* @since	1.6.20
*/   
public final class metaphone_servlet extends HttpServlet 
{
	/**
	* Matches the code from the Metaphone class and compares it with the code obtained from the database and returns the matched names.
	*
	*Input characters are obtained from the user and is encoded using Metaphone Algorithm, All the other names present in the database are encoded using the same metaphone algorithm
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
	*{@link action.meta.Metaphone } extends the Metaphone class and HttpServlet class
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
		      out.write("\t\t\t\t\t<form onsubmit=\"return formValidator()\" action=\"metaphone_servlet\" align=\"center\" method=\"get\">\r\n");
		      out.write("\t\t\t\t\t\t\t<b>Metaphone Algorithm</b><br></br>\r\n");
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
			String inputEncode, key, value, file = "MetaphoneReq "; ;
			int t=0;
			Metaphone M = new Metaphone();
			try
			{
				BufferedWriter output = new BufferedWriter(new FileWriter("C:/apache-tomcat-5.5.17/webapps/code/log.txt", true));
				if (fname == null)
					output.write(file);
				else
				{
					output.write(fname + " ");
							fname=fname.toUpperCase();
							String secondLetter="",thirdLetter="",fourthLetter="",firstLetter=String.valueOf(fname.charAt(0));
							if (fname.charAt(0) == 'C')
							{
									t = 1;
									if (fname.charAt(1) == 'I' || fname.charAt(1) == 'E' || fname.charAt(1) == 'Y')
									{
										secondLetter = String.valueOf('S');
										if (fname.charAt(1) == 'I' && fname.charAt(2) == 'A')
										{
											t = 2;
											secondLetter = String.valueOf('T');
											thirdLetter = String.valueOf('S');
										}
									}
									else
									{
										if (fname.charAt(1) == 'H')
										{
											if (fname.charAt(2) == 'A' || fname.charAt(2) == 'E' || fname.charAt(2) == 'I' || fname.charAt(2) == 'O' || fname.charAt(2) == 'U')
											{
												t=3; 
												secondLetter = String.valueOf('K');
												thirdLetter=String.valueOf('G');
												fourthLetter=String.valueOf('Q');
											}
											else
											{
												t = 2;
												secondLetter = String.valueOf('T');
												thirdLetter = String.valueOf('S');
											}		
										}
										else
										{
											t=3;
											secondLetter=String.valueOf('K');
											thirdLetter=String.valueOf('G');
											fourthLetter=String.valueOf('Q');
										}
									}
								}
								else if (fname.charAt(0) == 'D')
										{
												t = 1;
												if (fname.charAt(1) == 'G' && (fname.charAt(2) == 'E' || fname.charAt(2) == 'I' || fname.charAt(2) == 'Y'))
														secondLetter = String.valueOf('J');
												else
														secondLetter = String.valueOf('T');
										}

										else if (fname.charAt(0) == 'G')
										{
												t = 1;
												if (fname.charAt(1) == 'H' && (fname.charAt(2) == 'A' || fname.charAt(2) == 'E' || fname.charAt(2) == 'I' || fname.charAt(2) == 'O' || fname.charAt(2) == 'U'))
												{
														for (int i = 3; i != fname.length(); i++)
														{
																if (fname.charAt(i) == 'A' || fname.charAt(i) == 'E' || fname.charAt(i) == 'I' || fname.charAt(i) == 'O' || fname.charAt(i) == 'U')
																continue;
																else
																{
																		secondLetter = String.valueOf(fname.charAt(i));
																		break;
																}
														}
												}
												else if (fname.charAt(1) == 'N')
														secondLetter = String.valueOf('N');
												else if (fname.charAt(1) == 'E' || fname.charAt(1) == 'I' || fname.charAt(1) == 'Y')
														secondLetter = String.valueOf('J');
												else
												{
														t=3;
														secondLetter=String.valueOf('K');
														thirdLetter=String.valueOf('C');
														fourthLetter=String.valueOf('Q');
												}
										}

										else if (fname.charAt(0) == 'H' || fname.charAt(0) == 'W' || fname.charAt(0) == 'Y')
										{
												if (!(fname.charAt(1) == 'A' || fname.charAt(1) == 'E' || fname.charAt(1) == 'I' || fname.charAt(1) == 'O' || fname.charAt(1) == 'U'))
												{
														t = 1;
														secondLetter = String.valueOf(fname.charAt(1));
												}
										}
										else if (fname.charAt(0) == 'P')
										{
												if (fname.charAt(1) == 'H')
												{
														t = 1;
														secondLetter = String.valueOf('F');
												}
												else if (fname.charAt(1) == 'M')
												{
														t = 1;
														secondLetter = String.valueOf('M');
												}
										}

										else if (fname.charAt(0) == 'Q')
										{
												t = 3;
												secondLetter = String.valueOf('K');
												thirdLetter=String.valueOf('G');
												fourthLetter=String.valueOf('C');
										}

										else if (fname.charAt(0) == 'S')
										{
												if (fname.charAt(1) == 'H')
												{
														t = 2;
														secondLetter = String.valueOf('T');
														thirdLetter = String.valueOf('C');
												}
												else
												{
														if (fname.charAt(1) == 'I')
														{
																if (fname.charAt(2) == 'O' || fname.charAt(2) == 'A')
																{
																		t = 2;
																		secondLetter = String.valueOf('T');
																		thirdLetter = String.valueOf('C');
																}
																else
																{
																		t=3;
																		secondLetter=String.valueOf('X');
																		thirdLetter=String.valueOf('Z');
																		fourthLetter=String.valueOf('C');
																}
														}
														else
														{
																t = 3;
																secondLetter = String.valueOf('X');
																thirdLetter = String.valueOf('Z');
																fourthLetter = String.valueOf('C');
														}
												}
										}

										else if (fname.charAt(0) == 'T')
										{
												if (fname.charAt(1) == 'C' && fname.charAt(2) == 'H')
												{
														t = 2;
														secondLetter = String.valueOf('S');
														thirdLetter = String.valueOf('C');
												}
												else
												{
														if (fname.charAt(1) == 'I')
														{	
																if (fname.charAt(2) == 'O' || fname.charAt(2) == 'A')
																{
																		t = 2;
																		secondLetter = String.valueOf('S');
																		thirdLetter = String.valueOf('C');
																}
																else
																{
																		t=1;
																		secondLetter=String.valueOf('D');
																}
														}
														else
														{
																t = 1;
																secondLetter = String.valueOf('D');
														}
												}
										}
										else if (fname.charAt(0) == 'Z' || fname.charAt(0) == 'X')
										{
												t = 3;
												secondLetter=String.valueOf('S');
												fourthLetter=String.valueOf('C');
												if(fname.charAt(0)=='Z')		
														thirdLetter=String.valueOf('X');
												
												if(fname.charAt(0)=='X')
														thirdLetter=String.valueOf('Z');
										}
										else if (fname.charAt(0) == 'K')
										{
												if (fname.charAt(1) == 'N')
												{
														t = 1;
														secondLetter = String.valueOf('N');
												}
												else
												{
														t = 3;
														secondLetter = String.valueOf('C');
														thirdLetter = String.valueOf('G');
														fourthLetter = String.valueOf('Q');
												}
										}
										else if (fname.charAt(0) == 'A' && fname.charAt(1) == 'E')
										{
												t = 1;
												secondLetter = String.valueOf('E');
										}
										else if (fname.charAt(0) == 'W')
										{
												if (fname.charAt(1) == 'R')
												{
														t = 1;
														secondLetter = String.valueOf('R');
												}
												else if (fname.charAt(1) == 'H')
												{
														t = 1;
														secondLetter = String.valueOf('W');
												}
										}

										else if (fname.charAt(0) == 'J')
										{
												t = 2;
												secondLetter = String.valueOf('D');
												thirdLetter = String.valueOf('G');
										}

										else if (fname.charAt(0) == 'F')
										{
												t = 2;
												secondLetter = String.valueOf("PH");
												thirdLetter = String.valueOf('V');
										}

										else if (fname.charAt(0) == 'V')
										{
												t = 1;
												secondLetter = String.valueOf("F");
										}

										else if (fname.charAt(0) == 'N')
										{
												t = 2;
												secondLetter = String.valueOf('K');
												thirdLetter = String.valueOf('G');
										}

										else if (fname.charAt(0) == 'M')
										{
												t = 1;
												secondLetter = String.valueOf("P");
										}
										else if (fname.charAt(0) == 'E')
										{
												t = 1;
												secondLetter = String.valueOf("A");
										}
										else if (fname.charAt(0) == 'R')
										{
												t = 1;
												secondLetter = String.valueOf("W");
										}
			
							
											String str="select * from Names where First_name like ?";
											String str1="select * from Names where First_name like ?";
											String encode="";
											Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
											Connection con=DriverManager.getConnection("jdbc:odbc:inaut","","");
											PreparedStatement ps=con.prepareStatement(str),ps1=con.prepareStatement(str1);
											ps.setString(1,firstLetter+"%");
											ResultSet rs=ps.executeQuery(),rs1;
											
											if (t == 1)
											{
														str = "select * from Names where First_name like ? or First_name like ?";
														ps = con.prepareStatement(str);
														ps.setString(1, firstLetter + "%");
														ps.setString(2, secondLetter + "%");
														rs = ps.executeQuery();
											}

											if (t == 2)
											{
														str = "select * from Names where First_name like ? or First_name like ? or First_name like ?";
														ps = con.prepareStatement(str);
														ps.setString(1, firstLetter + "%");
														ps.setString(2, secondLetter + "%");
														ps.setString(3, thirdLetter + "%");
														rs = ps.executeQuery();
											}

											if (t == 3)
											{
														str = "select * from Names where First_name like ? or First_name like ? or First_name like ? or First_name like ?";
														ps = con.prepareStatement(str);
														ps.setString(1, firstLetter + "%");
														ps.setString(2, secondLetter + "%");
														ps.setString(3, thirdLetter + "%");
														ps.setString(4, fourthLetter + "%");
														rs = ps.executeQuery();
											}			
							
									HashMap<String,String> hm=new HashMap<String,String>();
									while (rs.next())
									{
									String name = rs.getString("FIRST_NAME");
									encode=M.metaphone(name);
									hm.put(name,encode);
									}
									ps.close();

									inputEncode=M.metaphone(fname);
									Set set = hm.entrySet();
									Iterator i = set.iterator();
									
      									out.write("\r\n");
      									out.write("\t\t\t\t\t\t\t\t\t\t\tMATCHING NAMES FOR <b>");
      									out.print(fname);
      									out.write("</b>\r\n");
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
																ps1.setString(1,key);
																rs1=ps1.executeQuery();
																	while(rs1.next())
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
						catch(Exception e)
						{
					
     							 	out.write("\r\n");
      							 	out.write("\t\t\t\t\t");
      								out.print("caught"+e);
								out.write("Please Try after sometime");
								//out.write("\t\t\t\t\t<a href=\"http://localhost/code/action/try.jsp\">Home Page</a></center>\r\n");
      								out.write("\r\n");
      								out.write("\t\t\t\t\t");

						}
							
					
      						out.write("\r\n");
      						out.write("\t\t\t\t\t\t\r\n");
      						out.write("\t\t\t\t\t<a href=\"http://localhost/code/action/try.jsp\">Home Page</a></center>\r\n");
      						out.write("\t\t\t\t</body>\r\n");
						out.write("</html>\r\n");
      						out.write("\r\n");
      						out.write("\r\n");
     
  }
}
