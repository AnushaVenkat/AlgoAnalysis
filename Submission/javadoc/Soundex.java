package action.Sound;
/**
* @author	Anusha V
* @author	Narendiran P	
* @author	UmaMaheshwari
* @version	2010.0728
* @since	1.6.20
*/
public class Soundex
{
	public String name, encode="";
	char code[] = new char[4];
	char flag;
	int temp = 0;
	/**
	* Encoding the words using Soundex Algorithm
	*
	*Input characters are obtained from the user and is encoded using Soundex Algorithm and the codes are passed on to the servlet pages for comparison and retrival.
	*
	*
	*@param	name - letters from the user is obtained 
	*
	*
	*return encode- returns the code that is used to match the code in the database
	*
	*@exception Exception - All types of exception are caught
	*
	*
	*/ 
	public String soundEx(String name)
	{
		this.name = name;
		name=name.toUpperCase();
		int j = 0;
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