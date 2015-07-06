package action.Daitch;
public class DaitchMokotoff
{
	public String name, encode;
	char code[] = new char[6],code1[] = new char[6],code2[] = new char[6],code3[] = new char[6],code4[] = new char[6],code5[] = new char[6],code6[] = new char[6],code7[] = new char[6];
	int j=0,flag=1;
	public void doubleCode(char a,char b,int c)
	{
		j = c;
		if (flag == 1)
		{
			System.arraycopy(code, 0, code1, 0, 6);
			code[j] = a;
			code1[j] = b;
			flag = flag * 2;
		}
		else if (flag == 2)
		{
			System.arraycopy(code, 0, code2, 0, 6);
			System.arraycopy(code1, 0, code3, 0, 6);
			code[j] = a;
			code1[j] = a;
			code2[j] = b;
			code3[j] = b;
			flag = flag * 2;
		}
		else if (flag == 4)
		{
			System.arraycopy(code, 0, code4, 0, 6);
			System.arraycopy(code1, 0, code5, 0, 6);
			System.arraycopy(code2, 0, code6, 0, 6);
			System.arraycopy(code3, 0, code7, 0, 6);
			code[j] = a;
			code1[j] = a;
			code2[j] = a;
			code3[j] = a;
			code4[j] = b;
			code5[j] = b;
			code6[j] = b;
			code7[j] = b;
			flag = flag * 2;
		}
		j++;
	}
	
	public void singleCode(char a, int c)
	{
		j = c;
		if (flag == 1)
		{
			code[j] = a;
		}
		else if (flag == 2)
		{
			code[j] = a;
			code1[j] = a;
		}
		else if (flag == 4)
		{
			code[j] = a;
			code1[j] = a;
			code2[j] = a;
			code3[j] = a;
		}
		else if (flag == 8)
		{
			code[j] = a;
			code1[j] = a;
			code2[j] = a;
			code3[j] = a;
			code4[j] = a;
			code5[j] = a;
			code6[j] = a;
			code7[j] = a;
		}
		j++;
	}
	public String dmCode(String inputname)
	{
		int len=inputname.length();
		char[] remdup=new char[len];
		int l=0;
		int k;
		j = 0;
		flag = 1;
		for(k=0; k<len;k++)
		{
			if(len-(k+1)>0)
			{
				if(inputname.charAt(k)==inputname.charAt(k+1))
				{
					continue;
				}
				else
				{
					remdup[l]=inputname.charAt(k);
					l++;
				}
			}
		}
		remdup[l]=inputname.charAt(k-1);
		inputname=String.valueOf(remdup);
		name=inputname.toUpperCase();
		int i=0;
		while(i<len && j<6)
		{
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='A' &&( name.charAt(i+1)=='I' || name.charAt(i+1)=='U' || name.charAt(i+1)=='J' || name.charAt(i+1)=='Y'))
					{
						singleCode('0', j);//singleCode('0',j);
						i=i+2;
						continue;
					}
			}
			if(len-(i+2)>0)
			{
				if(i!=0 && name.charAt(i)=='A' &&( name.charAt(i+1)=='I'|| name.charAt(i+1)=='J' || name.charAt(i+1)=='Y') && (name.charAt(i+2)=='A'|| name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
				if(i!=0 && name.charAt(i)=='A' && name.charAt(i+1)=='U' && (name.charAt(i+2)=='A'|| name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('7', j);
					i=i+2;
					continue;
				}
			}
			if(i==0 && name.charAt(i)=='A')
			{
				singleCode('0', j);
				i++;
				continue;
			}
			if( name.charAt(i)=='B')
			{
				singleCode('7', j);
				i++;
				continue;
			}
			if(len-(i+2)>0)
			{
				if(i==0 && name.charAt(i)=='C' && name.charAt(i+1)=='H' && name.charAt(i+2)=='S')
				{
					singleCode('5', j);
					i=i+3;
					continue;
				}
				if(i!=0 && name.charAt(i)=='C' && name.charAt(i+1)=='H' && name.charAt(i+2)=='S')
				{
					singleCode('5', j);
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='C' && (name.charAt(i+1)=='H'||name.charAt(i+1)=='K'))
				{
					doubleCode('5','4',j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if( name.charAt(i)=='C' &&(name.charAt(i+1)=='S' || name.charAt(i+1)=='Z'))
				{
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if ( name.charAt(i)=='C' &&(name.charAt(i+1)=='S' || name.charAt(i+1)=='Z') &&(name.charAt(i+2)=='S' || name.charAt(i+2)=='Z'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(name.charAt(i)=='C')
			{
				doubleCode('5', '4', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='D' && name.charAt(i+1)=='R' && (name.charAt(i+1)=='S' || name.charAt(i+1)=='Z'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
				if (name.charAt(i)=='D' && (name.charAt(i+1)=='S' || name.charAt(i+1)=='Z'))
				{
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='D' && name.charAt(i+1)=='S' && (name.charAt(i+2)=='H' ||name.charAt(i+2)=='Z'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
				if(name.charAt(i)=='D' && name.charAt(i+1)=='Z' && (name.charAt(i+2)=='H' ||name.charAt(i+2)=='S'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='D' && name.charAt(i+1)=='T')
				{
					singleCode('3', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='D')			
			{
				singleCode('3', j);
				i++;
				continue;
			}

			if(len-(i+1)>0)

			{	
				if(i==0 && name.charAt(i)=='E' && (name.charAt(i+1)=='I' || name.charAt(i+1)=='Y' || name.charAt(i+1)=='J'))
				{
					singleCode('0', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)	
			{
				if(i!=0 && name.charAt(i)=='E' && (name.charAt(i+1)=='I' || name.charAt(i+1)=='Y' || name.charAt(i+1)=='J') && (name.charAt(i+2)=='A' || name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='E' && name.charAt(i+1)=='U')
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(i!=0 && name.charAt(i)=='E' && name.charAt(i+1)=='U' && (name.charAt(i-1)=='A' || name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
			}
			if(i==0 && name.charAt(i)=='E')
			{
				singleCode('0', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='F' && name.charAt(i+1)=='B')
				{
					singleCode('7', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='F') 
			{
				singleCode('7', j);
				i++;
				continue;
			}
			if(name.charAt(i)=='G')
			{
				singleCode('5', j);
				i++;
				continue;
			} 
			if(i==0 && name.charAt(i)=='H')
			{
				singleCode('5', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(i!=0 && name.charAt(i)=='H' &&(name.charAt(i+1)=='A' || name.charAt(i+1)=='E' || name.charAt(i+1)=='I' || name.charAt(i+1)=='O' || name.charAt(i+1)=='U'))
				{
					singleCode('5', j);
					i++;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='I' && (name.charAt(i+1)=='A' || name.charAt(i+1)=='E' || name.charAt(i+1)=='O' || name.charAt(i+1)=='U'))
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
			}
			if(i==0 && name.charAt(i)=='I')
			{
				singleCode('0', j);
				i++;
				continue;
			}
			if(name.charAt(i)=='J')
			{
				doubleCode('1', '4', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='K' && name.charAt(i+1)=='S')
				{
					singleCode('5', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='K' && name.charAt(i+1)=='S' && (name.charAt(i+2)=='A' || name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('5', j);
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(i!=0 && name.charAt(i)=='K' && name.charAt(i+1)=='S')
				{
					singleCode('5', j);
					singleCode('4', j);
					i=i+2;
					continue;
				}
				if( name.charAt(i)=='K' && name.charAt(i+1)=='H')
				{
					singleCode('5', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='K')			
			{
				singleCode('5', j);
				i++;
				continue;
			}
			if (name.charAt(i)=='L')
			{
				singleCode('8', j);
				i++;
				continue;
			}
			if(len-(i+2)>0)
			{
				if(i!=0 && name.charAt(i)=='M' && name.charAt(i+1)=='N' && (name.charAt(i+2)=='A' || name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('6', j);
					singleCode('6', j);
					i=i+2;
					continue;
				}
				if(i!=0 && name.charAt(i)=='N' && name.charAt(i+1)=='M' && (name.charAt(i+2)=='A' || name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('6', j);
					singleCode('6', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(i!=0 && name.charAt(i)=='M' && name.charAt(i+1)=='N')
				{
					singleCode('6', j);
					singleCode('6', j);
					i=i+2;
					continue;
				}
				if(i!=0 && name.charAt(i)=='N' && name.charAt(i+1)=='M')
				{
					singleCode('6', j);
					singleCode('6', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='M' || name.charAt(i)=='N')
			{
				singleCode('6', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='O' &&( name.charAt(i+1)=='I' || name.charAt(i+1)=='J' || name.charAt(i+1)=='Y'))
				{
					singleCode('0', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(i!=0 && name.charAt(i)=='O' &&( name.charAt(i+1)=='I'|| name.charAt(i+1)=='J' || name.charAt(i+1)=='Y') && (name.charAt(i+2)=='A'|| name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
			}
			if(i==0 && name.charAt(i)=='O')
			{
				singleCode('0', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='P' && (name.charAt(i+1)=='F' || name.charAt(i+1)=='H'))
				{
					singleCode('7', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='P')
			{
				singleCode('7', j);
				i++;
				continue;
			}
			if(name.charAt(i)=='Q')
			{
				singleCode('5', j);
				i++;
				continue;
			}
			if (len - (i + 1) > 0)
			{
				if (name.charAt(i) == 'R' && (name.charAt(i + 1) == 'Z' || name.charAt(i + 1) == 'S'))
				{
					doubleCode('9', '4', j);
					i = i + 2;
					continue;
				}
			}
			if(name.charAt(i)=='R')
			{
				singleCode('9', j);
				i++;
				continue;
			}
			if(len-(i+6)>0)
			{
				if( name.charAt(i)=='S' && name.charAt(i+1)=='C' && name.charAt(i+2)=='H' && name.charAt(i+3)=='T' && name.charAt(i+4)=='S' && name.charAt(i+5)=='C' && name.charAt(i+6)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+7;
					}
					else
					{
						singleCode('4', j);
						i=i+7;
					}
					continue;
				}
			}
			if(len-(i+5)>0)
			{
				if( name.charAt(i)=='S' && name.charAt(i+1)=='C' && name.charAt(i+2)=='H' && name.charAt(i+3)=='T' && (name.charAt(i+4)=='S' || name.charAt(i+4)=='C') && name.charAt(i+5)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+6;
					}
					else
					{
						singleCode('4', j);
						i=i+6;
					}
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='C' && name.charAt(i+2)=='H')
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(len-(i+4)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='H' && name.charAt(i+2)=='T' && (name.charAt(i+3)=='C' || name.charAt(i+3)=='S') && name.charAt(i+4)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+5;
					}
					else
					{
						singleCode('4', j);
						i=i+5;
					}
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='H' && name.charAt(i+2)=='C' && name.charAt(i+3)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+4;
					}
					else
					{
						singleCode('4', j);
						i=i+4;
					}
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='H' && name.charAt(i+2)=='T')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+3;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+3;
					}
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='C' && name.charAt(i+2)=='H' &&( name.charAt(i+3)=='T' || name.charAt(i+3)=='D'))
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+3;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+3;
					}
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='H')
				{
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='T' && name.charAt(i+2)=='C' && name.charAt(i+3)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+4;
					}
					else
					{
						singleCode('4', j);
						i=i+4;
					}
					continue;
				}
			}
			if(len-(i+4)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='T' && name.charAt(i+2)=='S' && name.charAt(i+3)=='C' && name.charAt(i+4)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+5;
					}
					else
					{
						singleCode('4', j);
						i=i+5;
					}
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='C')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+2;
					}
					else
					{
						singleCode('4', j);
						i=i+2;
					}
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='T' && name.charAt(i+2)=='R' &&( name.charAt(i+3)=='Z' || name.charAt(i+3)=='S'))
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+4;
					}
					else
					{
						singleCode('4', j);
						i=i+4;
					}
					continue;
				}
		
				if(name.charAt(i)=='S' && name.charAt(i+1)=='T' && name.charAt(i+2)=='S' && name.charAt(i+3)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+4;
					}
					else
					{
						singleCode('4', j);
						i=i+4;
					}
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='T')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+2;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+2;
					}
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='Z' && name.charAt(i+2)=='C' && (name.charAt(i+3)=='Z' || name.charAt(i+3)=='S'))
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+4;
					}
					else
					{
						singleCode('4', j);
						i=i+4;
					}
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='Z' && (name.charAt(i+2)=='T' || name.charAt(i+2)=='D'))
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+3;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+3;
					}
					continue;
				}
			
				if(name.charAt(i)=='S' && name.charAt(i+1)=='H' && name.charAt(i+2)=='D')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+3;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+3;
					}	
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='S' && name.charAt(i+1)=='D')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+2;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+2;
					}
					continue;
				}
				if(name.charAt(i)=='S' && name.charAt(i+1)=='Z')
				{
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='S')
			{
				singleCode('4', j);
				i++;
				continue;
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='T' && (name.charAt(i+1)=='C' || name.charAt(i+1)=='S') && name.charAt(i+2)=='H')
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
				if(name.charAt(i)=='T' && name.charAt(i+1)=='T' && name.charAt(i+2)=='C' && name.charAt(i+3)=='H')
				{
					singleCode('4', j);
					i=i+4;
					continue;
				}
			}
			if(len-(i+4)>0)
			{
				if(name.charAt(i)=='T' && (name.charAt(i+1)=='T' || name.charAt(i+1)=='S')  &&name.charAt(i+2)=='S' &&  name.charAt(i+3)=='C' && name.charAt(i+4)=='H')
				{
					singleCode('4', j);
					i=i+5;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='T' && name.charAt(i+1)=='H')
				{
					singleCode('3', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='T' && name.charAt(i+1)=='R' && (name.charAt(i+2)=='Z'|| name.charAt(i+2)=='S'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
				if(name.charAt(i)=='T' && name.charAt(i+1)=='S' && name.charAt(i+2)=='H')
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='T' &&( name.charAt(i+1)=='S' || name.charAt(i+1)=='C' || name.charAt(i+1)=='Z'))
				{
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='T' && name.charAt(i+1)=='T' &&( name.charAt(i+2)=='S' || name.charAt(i+2)=='Z'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='T' && name.charAt(i+1)=='T' &&name.charAt(i+2)=='S' && name.charAt(i+3)=='Z')
				{
					singleCode('4', j);
					i=i+4;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='T' &&( name.charAt(i+1)=='S' ||name.charAt(i+1)=='Z') && (name.charAt(i+2)=='Z' || name.charAt(i+2)=='S'))
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(name.charAt(i)=='T')
			{
				singleCode('3', j);
				i++;
				continue;
			}
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='U' &&( name.charAt(i+1)=='I' || name.charAt(i+1)=='J' || name.charAt(i+1)=='Y'))
				{
					singleCode('0', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(i!=0 && name.charAt(i)=='U' &&( name.charAt(i+1)=='I'|| name.charAt(i+1)=='J' || name.charAt(i+1)=='Y') && (name.charAt(i+2)=='A'|| name.charAt(i+2)=='E' || name.charAt(i+2)=='I' || name.charAt(i+2)=='O' || name.charAt(i+2)=='U'))
				{
					singleCode('1', j);
					i=i+2;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(i==0 && name.charAt(i)=='U' && name.charAt(i+1)=='E')
				{
					singleCode('0', j);
					i=i+2;
					continue;
				}
			}
			if(i==0 && name.charAt(i)=='U')
			{
				singleCode('0', j);
				i++;
				continue;
			}
			if(name.charAt(i)=='V' || name.charAt(i)=='W')
			{
				singleCode('7', j);
				i++;
				continue;
			}
			if(name.charAt(i)=='X')
			{
				if(i==0)
				{
					singleCode('5', j);
					i++;
				}
				else
				{
					singleCode('5', j);
					singleCode('4', j);
					i++;
				}
				continue;
			}
			if(i==0 && name.charAt(i)=='Y')
			{
				singleCode('1', j);
				i++;
				continue;
			}
			if(len-(i+4)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='H' && name.charAt(i+2)=='D' && name.charAt(i+3)=='Z' && name.charAt(i+4)=='H')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+5;
					}	
					else
					{
						singleCode('4', j);
						i=i+5;
					}
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='D'&& name.charAt(i+2)=='Z')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+3;
					}
					else
					{
						singleCode('4', j);
						i=i+3;
					}
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='D'&& name.charAt(i+2)=='Z' && name.charAt(i+3)=='Z')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+4;
					}
					else
					{
						singleCode('4', j);
						i=i+4;
					}
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='H'&& name.charAt(i+2)=='D')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+3;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+3;
					}
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='D')
				{
					if(i==0)
					{
						singleCode('2', j);
						i=i+2;
					}
					else
					{
						singleCode('4', j);
						singleCode('3', j);
						i=i+2;
					}
					continue;
				}
			}
			if(len-(i+3)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='S' && name.charAt(i+2)=='C' && name.charAt(i+3)=='H')
				{
					singleCode('4', j);
					i=i+4;
					continue;
				}
			}
			if(len-(i+2)>0)
			{
				if(name.charAt(i)=='Z' && name.charAt(i+1)=='S' && name.charAt(i+2)=='H')
				{
					singleCode('4', j);
					i=i+3;
					continue;
				}
			}
			if(len-(i+1)>0)
			{
				if(name.charAt(i)=='Z' && (name.charAt(i+1)=='S' || name.charAt(i+1)=='H'))
				{
					singleCode('4', j);
					i=i+2;
					continue;
				}
			}
			if(name.charAt(i)=='Z')
			{
				singleCode('4', j);
				i++;
			}
			i++;
		}
		while (j < 6)
		{
			if (flag == 1)
			{
				code[j] = '0';
			}
			else if (flag == 2)
			{
				code[j] = '0';
				code1[j] = '0';
			}
			else if (flag == 4)
			{
				code[j] = '0';
				code1[j] = '0';
				code2[j] = '0';
				code3[j] = '0';
			}
			else if (flag == 8)
			{
				code[j] = '0';
				code1[j] = '0';
				code2[j] = '0';
				code3[j] = '0';
				code4[j] = '0';
				code5[j] = '0';
				code6[j] = '0';
				code7[j] = '0';
			}
			j++;
		}
		if (flag == 1)
		{
			encode = String.valueOf(code);
		}
		else if (flag == 2)
		{
			encode = String.valueOf(code)+String.valueOf(code1);
		}
		else if (flag == 4)
		{
			encode = String.valueOf(code) + String.valueOf(code1) + String.valueOf(code2) + String.valueOf(code3);
		}
		else if (flag == 8)
		{
			encode = String.valueOf(code) + String.valueOf(code1) + String.valueOf(code2) + String.valueOf(code3) + String.valueOf(code4) + String.valueOf(code5) + String.valueOf(code6) + String.valueOf(code7);
		}

		return encode;
	}
}
		
