import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import action.phone.Phonex;


public final class phonex_servlet extends HttpServlet
{

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
		      out.write("\t\t\t\t\t<form onsubmit=\"return formValidator()\" action=\"phonex_servlet\" align=\"center\" method=\"get\">\r\n");
		      out.write("\t\t\t\t\t\t\t<b>Phonex Algorithm</b><br></br>\r\n");
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

							String inputEncode, key, value, file = "Phonex Req ";
							int t=0;
							Phonex P = new Phonex();
							
							try
							{
								BufferedWriter output = new BufferedWriter(new FileWriter("C:/apache-tomcat-5.5.17/webapps/code/log.txt", true));
								if (fname == null)
									output.write(file);
								else
								{
									output.write(fname + " ");
											fname=fname.toUpperCase();
											String secondLetter="",thirdLetter="",firstLetter=String.valueOf(fname.charAt(0));
											if((fname.charAt(0)=='K')&&(fname.charAt(1)=='N'))
											{
														t=1;
														secondLetter=String.valueOf(fname.charAt(1));
											}
											else if((fname.charAt(0)=='W')&&(fname.charAt(1)=='R'))
											{
														t=1;
														secondLetter=String.valueOf(fname.charAt(1));
											}
											else if((fname.charAt(0)=='P')&&(fname.charAt(1)=='H'))
											{
														t=1;
														secondLetter=String.valueOf('F');
											}
											else if(fname.charAt(0)=='H')
											{
														if(fname.charAt(1)=='A'||fname.charAt(1)=='E'||fname.charAt(1)=='I'||fname.charAt(1)=='O'||fname.charAt(1)=='U'||fname.charAt(1)=='Y')
														{
																t=2;
														}
														else
														{
																t=1;
																secondLetter=String.valueOf(fname.charAt(1));
														}
											}
											else if(fname.charAt(0)=='A'||fname.charAt(0)=='E'||fname.charAt(0)=='I'||fname.charAt(0)=='O'||fname.charAt(0)=='U'||fname.charAt(0)=='Y')
											{
														t=2;
											}
											else if(fname.charAt(0)=='P')
											{
														t=1;
														secondLetter=String.valueOf('B');
											}
											else if(fname.charAt(0)=='B')
											{
														t=1;
														secondLetter=String.valueOf('P');
											}
											else if(fname.charAt(0)=='V')
											{
														t=1;
														secondLetter=String.valueOf('F');
											}
											else if(fname.charAt(0)=='F')
											{
														t=1;
														secondLetter=String.valueOf('V');
											}
											else if(fname.charAt(0)=='J')
											{
														t=1;
														secondLetter=String.valueOf('G');
											}
											else if(fname.charAt(0)=='G')
											{
														t=1;
														secondLetter=String.valueOf('J');
											}
											else if(fname.charAt(0)=='Z')
											{
														t=1;
														secondLetter=String.valueOf('S');
											}
											else if(fname.charAt(0)=='S')
											{
														t=1;
														secondLetter=String.valueOf('Z');
											}
											else if(fname.charAt(0)=='K')
											{
														t=3;
														secondLetter=String.valueOf('C');
														thirdLetter=String.valueOf('Q');
											}
											else if(fname.charAt(0)=='Q')
											{
														t=3;
														secondLetter=String.valueOf('C');
														thirdLetter=String.valueOf('K');
											}
											else if(fname.charAt(0)=='C')
											{
														t=3;
														secondLetter=String.valueOf('K');
														thirdLetter=String.valueOf('Q');
											}
											else if(fname.charAt(0)=='N')
											{
														t=1;
														secondLetter=String.valueOf('K');
											}
											else if(fname.charAt(0)=='R')
											{
														t=1;
														secondLetter=String.valueOf('W');
											}
											else if(fname.charAt(0)=='F')
											{
														t=1;
														secondLetter=String.valueOf("PH");
											}
							
											String str="select * from Names where First_name like ?  or First_name like 'h%'";
											String str1="select * from Names where First_name like ?";
											String encode="";
											Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
											Connection con=DriverManager.getConnection("jdbc:odbc:inaut","","");
											PreparedStatement ps=con.prepareStatement(str),ps1=con.prepareStatement(str1);
											ps.setString(1,firstLetter+"%");
											ResultSet rs=ps.executeQuery(),rs1;
											if(t==1)
											{
														str="select * from Names where First_name like ? or First_name like ? or First_name like 'h%'";
														ps=con.prepareStatement(str);
														ps.setString(1,firstLetter+"%");
														ps.setString(2,secondLetter+"%");
														rs=ps.executeQuery();
											}
											else if(t==2)
											{
														str="select * from Names where First_name like ? or First_name like 'a%' or First_name like 'e%' or First_name like 'i%' or First_name like 'o%' or First_name like 'u%' or First_name like 'h%'";
														ps=con.prepareStatement(str);
														ps.setString(1,firstLetter+"%");
														rs=ps.executeQuery();
											}
											else if(t==3)
											{
														str="select * from Names where First_name like ? or First_name like ? or First_name like ?  or First_name like 'h%'";
														ps=con.prepareStatement(str);
														ps.setString(1,firstLetter+"%");
														ps.setString(2,secondLetter+"%");
														ps.setString(3,thirdLetter+"%");
														rs=ps.executeQuery();
											}
									HashMap<String,String> hm=new HashMap<String,String>();
									while (rs.next())
									{
									String name = rs.getString("FIRST_NAME");
									encode=P.phonex(name);
									hm.put(name,encode);
									}
									ps.close();

									inputEncode=P.phonex(fname);
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
							out.write("\t\t\t\t\t<a href=\"http://localhost/code/action/try.jsp\">Home Page</a></center>\r\n");
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
