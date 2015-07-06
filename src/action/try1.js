function goto() 
	{
		if (document.getElementById('radio1').checked)
		{   
			location = "http://localhost/code/soundex_servlet";   
			//window.open('http://localhost/code/soundex_servlet')   
			//document.write("select is" + select);
		}
		if (document.getElementById('radio2').checked)
		{ 
			 
			location = "http://localhost/code/metaphone_servlet";   
			//window.open('http://localhost/code/metaphone_servlet')   
			//document.write("select is" + select);
	
		}
		if (document.getElementById('radio3').checked)
		{   
			location = "http://localhost/code/phonex_servlet";   
			//window.open('http://localhost/code/phonex_servlet')  
			//document.write("select is" + select);
	
		}
		if (document.getElementById('radio4').checked)
		{   
			
			location = "http://localhost/code/daimot_servlet";   
			//window.open('http://localhost/soundex.jsp')   
			//document.write("select is" + select);
	
		}
	}