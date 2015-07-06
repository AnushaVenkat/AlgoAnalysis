package action.phone;
/**
* @author	Anusha V
* @author	Narendiran P	
* @author	UmaMaheshwari
* @version	2010.0728
* @si
public class Phonex
{
	public String name,fname,encode="";
	char code[] = new char[4];
	char flag;
	int temp = 0;
	
	/**
	* Encoding the words using Phonex algorithm
	*
	*Input characters are obtained from the user and is encoded using Phonex Algorithm and the codes are passed on to the servlet pages for comparison and retrival.
	*
	*@param name - letters from the user is obtained 
	*
	*
	*return encode- returns the code that is used to match the code in the database
	*
	*@exception Exception - All types of exception are caught
	*
	*
	*/ 

	public String preProcess(String name)
	{
		try
		{
			int length = name.length();
			for (int i = (length - 1); i != 0; i--)
			{
				if (name.charAt(i) == 'S')
				{
					name = name.substring(0, i);
				}
				else
				{
					break;
				}
			}
			
			for(int i = 0,temp1=0;i!=name.length();i++)
			{
				if (name.charAt(i) == 'K')
				{
					temp1 = 1;
				}
				else if (name.charAt(i) == 'N')
				{
					name = name.substring(i, name.length());
					break;
				}
				else
				{
					break;
				}
			}

			for (int i = 0, temp1 = 0; i != name.length(); i++)
			{
				if (name.charAt(i) == 'W')
				{
					temp1=1;
				}
				else if (name.charAt(i) == 'R')
				{
					name = name.substring(i, name.length());
					break;
				}
				else
				{
					break;
				}
			}

			for (int i = 0, temp1 = 0; i != name.length(); i++)
			{
				if (name.charAt(i) == 'P')
				{
					temp1 = 1;
				}
				else if (name.charAt(i) == 'H')
				{
					name = name.substring(i, name.length());
					if (temp1 == 1)
					{
							name = name.replaceFirst("H", "F");						
					}
					break;
				}
				else
				{
					break;
				}
			}
			int i = 0;
			while (i != name.length())
			{
				if (name.charAt(i) == 'H')
					name = name.substring(i+1, name.length());
				else
					break;
			}
			
			
			if (name.charAt(0) == 'E')
				name = name.replaceFirst("E", "A");
			
			if (name.charAt(0) == 'I')
				name = name.replaceFirst("I", "A");
			
			if (name.charAt(0) == 'O')
				name = name.replaceFirst("O", "A");
			
			if (name.charAt(0) == 'U')
				name = name.replaceFirst("U", "A");
			
			if (name.charAt(0) == 'Y')
				name = name.replaceFirst("Y", "A");

			
			if (name.charAt(0) == 'P')
				name = name.replaceFirst("P", "B");

			
			if (name.charAt(0) == 'V')
				name = name.replaceFirst("V", "F");

			
			if (name.charAt(0) == 'K')
				name = name.replaceFirst("K", "C");
			
			if (name.charAt(0) == 'Q')
				name = name.replaceFirst("Q", "C");

			
			if (name.charAt(0) == 'J')
				name = name.replaceFirst("J", "G");

			if (name.charAt(0) == 'Z')
				name = name.replaceFirst("Z", "S");

			

		}
		catch (Exception e)
		{
			System.out.println("caught"+e);
		}
		return name;
	}

	public String phonex(String name1)
	{
		int j = 0;
		int temp = 0;
		name = name1.toUpperCase();
		name=preProcess(name);
		char t = name.charAt(0);
		if ((name.charAt(0) == 'D' || name.charAt(0) == 'T') && (name.charAt(1) == 'C'))
		{
			name = name.substring(1, name.length());
			temp = 1;
		}
		else if ((name.charAt(0) == 'L' || name.charAt(0) == 'R') && (name.charAt(1) == 'A' || name.charAt(1) == 'E' || name.charAt(1) == 'I' || name.charAt(1) == 'O' || name.charAt(1) == 'U'))
		{
			name = name.substring(1, name.length());
			temp = 1;
		}

		else if ((name.charAt(0) == 'M' || name.charAt(0) == 'N') && (name.charAt(1) == 'D' || name.charAt(1) == 'G'))
		{
			name = name.substring(1, name.length());
			temp = 1;
		}

		
		name = name.replaceAll("DC", "AC");

		name = name.replaceAll("TC", "AC");
		
		if (name.contains("LA") || name.contains("LE") || name.contains("LI") || name.contains("LO") || name.contains("LU"))
		{
			name = name.replaceAll("LA", "AA");
			name = name.replaceAll("LE", "AE");
			name = name.replaceAll("LI", "AI");
			name = name.replaceAll("LO", "AO");
			name = name.replaceAll("LU", "AU");
		}

		if (name.contains("RA") || name.contains("RE") || name.contains("RI") || name.contains("RO") || name.contains("RU"))
		{
			name = name.replaceAll("RA", "AA");
			name = name.replaceAll("RE", "AE");
			name = name.replaceAll("RI", "AI");
			name = name.replaceAll("RO", "AO");
			name = name.replaceAll("RU", "AU");
		}

		if (name.contains("MD") || name.contains("MG") || name.contains("ND") || name.contains("NG"))
		{
			
			name = name.replaceAll("MD", "M");
			name = name.replaceAll("MG", "M");

			name = name.replaceAll("ND", "N");
			name = name.replaceAll("NG", "N");

		}

		while (name.charAt(name.length() - 1) == 'L' || name.charAt(name.length() - 1) == 'R')
		{
			name = name.substring(0, name.length() - 1);
		}

		if (temp == 1)
		{
			name = t + name;
		}

		for (int i = 0; i != name.length(); i++)
		{
			if (i == 0)
			{
				code[j] = name.charAt(i);
				j++;
				if (name.charAt(i) == 'B' || name.charAt(i) == 'F' || name.charAt(i) == 'P' || name.charAt(i) == 'V')
				{
					flag = '1';
				}
				else if (name.charAt(i) == 'C' || name.charAt(i) == 'G' || name.charAt(i) == 'J' || name.charAt(i) == 'K' || name.charAt(i) == 'Q' || name.charAt(i) == 'S' || name.charAt(i) == 'X' || name.charAt(i) == 'Z')
				{
					flag = '2';
				}
				else if (name.charAt(i) == 'D' || name.charAt(i) == 'T')
				{
					flag = '3';
				}
				else if (name.charAt(i) == 'L')
				{
					flag = '4';
				}
				else if (name.charAt(i) == 'M' || name.charAt(i) == 'N')
				{
					flag = '5';
				}
				else if (name.charAt(i) == 'R')
				{
					flag = '6';
				}
			}
			else
			{
				if (name.charAt(i) == 'A' || name.charAt(i) == 'E' || name.charAt(i) == 'I' || name.charAt(i) == 'O' || name.charAt(i) == 'U')
				{
					temp = 1;
					continue;
				}
				else if (name.charAt(i) == 'H' || name.charAt(i) == 'W')
				{
					temp = 0;
					continue;
				}
				else if (name.charAt(i) == 'Y')
				{
					temp = 0;
					continue;
				}
				else
				{
					if (name.charAt(i) == 'B' || name.charAt(i) == 'F' || name.charAt(i) == 'P' || name.charAt(i) == 'V')
					{

						if ((temp == 1 || code[j - 1] != '1') && j <= 3 && (i != 1 || flag != '1'))
						{
							code[j] = '1';
							j++;
						}
						else
							continue;
					}

					else if (name.charAt(i) == 'C' || name.charAt(i) == 'G' || name.charAt(i) == 'J' || name.charAt(i) == 'K' || name.charAt(i) == 'Q' || name.charAt(i) == 'S' || name.charAt(i) == 'X' || name.charAt(i) == 'Z')
					{
						if ((temp == 1 || code[j - 1] != '2') && j <= 3 && (i != 1 || flag != '2'))
						{
							code[j] = '2';
							j++;
						}
						else
							continue;
					}


					else if (name.charAt(i) == 'D' || name.charAt(i) == 'T')
					{
						
					
							if ((temp == 1 || code[j - 1] != '3') && j <= 3 && (i != 1 || flag != '3'))
							{
								code[j] = '3';
								j++;
							}
							else
								continue;
						
					}

					else if (name.charAt(i) == 'L')
					{
						if ((temp == 1 || code[j - 1] != '4') && j <= 3 && (i != 1 || flag != '4'))
						{
							code[j] = '4';
							j++;
						}
						else
							continue;
					}

					else if (name.charAt(i) == 'M' || name.charAt(i) == 'N')
					{
						if ((temp == 1 || code[j - 1] != '5') && j <= 3 && (i != 1 || flag != '5'))
						{
							code[j] = '5';
							j++;
						}
						else
							continue;
					}


					else if (name.charAt(i) == 'R')
					{
						if ((temp == 1 || code[j - 1] != '6') && j <= 3 && (i != 1 || flag != '1'))
						{
							code[j] = '6';
							j++;
						}
						else
							continue;
					}
					temp = 0;
				}
			}
		}

		while (j < 4)
		{
			code[j] = '0';
			j++;
		}
		encode = String.valueOf(code);
		return encode;

	}

	

}