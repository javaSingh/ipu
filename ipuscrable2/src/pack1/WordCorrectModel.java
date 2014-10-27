// we are working with two database here
// do if you change the connections you need to change the tables also




// TAKE CARE!!!!!





package pack1;
import java.sql.*;

import javax.servlet.ServletContext;
public class WordCorrectModel
{
	
	String s3;
	Connection con;
	Statement st;
	PreparedStatement pst;
	String errorString="";
	
	public WordCorrectModel()
	{
		
		try{
			
			
			//this works for mysql of cloudbees.
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_test432","b49635eb3ae2d2","64701f54");

			//Connection con=DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_test432","b49635eb3ae2d2","64701f54");
		//	st=con.createStatement();
			
			
			
		//this works of local oracle	
			
	//	Class.forName("oracle.jdbc.driver.OracleDriver");
	//	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");
		st=con.createStatement();
		}
		catch(Throwable e)
		{
			errorString=" "+e;
			s3="Error!!!. Error in constructior. "+e;
			errorString=" "+e;
		}
	}

	
	/*
	public String[] getWord(int x)
	{
		char[] wordarr;
		int i,j=1;
		String str[]={"str[0] initial"," str[1] initial"};
		String word="initial0";
		ResultSet rs;
		//ServletContext ctx=setServletContext();
		try{
		//cloudbees table
		pst=con.prepareStatement("select * from testtabl1 where id=?");
			//loacal oracle db.
			//pst=con.prepareStatement("select* from listdict where id=?");
			pst.setInt(1,x);
			rs=pst.executeQuery();
		rs.next();
		word=rs.getString(2);
		str[0]=word;//index 0 carries word
//		wordarr=word.toCharArray();
	str[1]=insertionsort(word);//index 1 carries randow word
		/*for(i=0;i<word.length()-1;i++)
		{
			char temp;
			temp=wordarr[i];
			wordarr[i]=wordarr[++i];
			wordarr[i]=temp;
			
		}*/
		//str[1]=new String(wordarr);
		/*}
		catch(Throwable e){
			str[0]="error "+e+"  word is  "+word;
		}		
	return str;
	}
	*/
	
	
		
	public String insertionsort(String x)
	{
		int j,i,index=0;
	
		char wordarr[],temp;

		String str="initial";
	//x="baced";
		wordarr=x.toCharArray();	
	
		for(i=1;i<x.length();i++)
		{
		temp=wordarr[i];
		for(j=i-1;(j>=0);j--)
		{	if(wordarr[j]>temp)
			wordarr[j+1]=wordarr[j];
		else
			break;
		
		}
		wordarr[j+1]=temp;
		}
		str=new String(wordarr);	
		return str;//+" "+x.length();
	}
	

	public String crosswordfx(String word)
	{
		int count=0;
		String s="no such word found";
		ResultSet rs;
		try {
		pst=con.prepareStatement("select * from testtable1 where name like ?");
			//pst=con.prepareStatement("select * from listdict where AARDVARK like ?");
		 
		pst.setString(1,word);
		rs=pst.executeQuery();
		while(rs.next())
		{
			count++;
			if(s.equals("no such word found"))
				s="";
			s=s+" "+rs.getString(2);
			
		}
		st.close();
		con.close();
	}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			s=s+e;
		}
		return s;//+"  tis si working fine";
		
	}

	public String correctWordfx(String word)
	{
	int count = 0;
	s3="";
int i;
int count1[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
int count2[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
for(i=1;i<27;i++)
{
count1[i]=0;
count2[i]=0;
}
Boolean wordfound=false,nxtwrd,mtow;
nxtwrd=true;
mtow=false;
String s1,s2="";
s1=word;
char[] arr1low,arr2low;
arr1low=(s1.toLowerCase()).toCharArray();

for(i=0;i<(s1.length());i++)
{

switch(arr1low[i])
{
case'a' : count1[1]++;
break;
case'b' : count1[2]++;
break;
case 'c' : count1[3]++;
break;
case 'd' : count1[4]++;
break;
case 'e' : count1[5]++;
break;
case 'f' : count1[6]++;
break;
case 'g' : count1[7]++;
break;
case 'h' : count1[8]++;
break;
case 'i' : count1[9]++;
break;
case 'j' : count1[10]++;
break;
case 'k' : count1[11]++;
break;
case 'l' : count1[12]++;
break;
case 'm' : count1[13]++;
break;
case 'n' : count1[14]++;
break;
case 'o' : count1[15]++;
break;
case 'p' : count1[16]++;
break;
case 'q' : count1[17]++;
break;
case 'r' : count1[18]++;
break;
case 's' : count1[19]++;
break;
case 't' : count1[20]++;
break;
case 'u' : count1[21]++;
break;
case 'v' : count1[22]++;
break;
case 'w' : count1[23]++;
break;
case 'x' :  count1[24]++;
break;
case 'y' : count1[25]++;
break;
case 'z' : count1[26]++;
break;
}
}			


//int count=1;
//s3="initialised ";
	try
	{
//s3=s3+" 1 ";
			
		ResultSet rs=st.executeQuery("select * from cb_test432.testtable1");
		//ResultSet rs=st.executeQuery("select * from listdict");
		
			
		//	s3=s3+" 2 ";
		
			
			wordfound=false;
			while(rs.next())
			{
				count++;
				s2=rs.getString(2);
				nxtwrd=true;
//count++;
				for(i=1;i<27;i++)
				{
				count2[i]=0;
				}
				arr2low=(s2.toLowerCase()).toCharArray();
			    if((s1.length())!=(s2.length()))
			    {
			    	continue;
			    	
			    }

//s3=s3+" 3 ";
			    for(i=0;i<(s2.length());i++)
			    {
switch(arr2low[i])
{
case 'a' : count2[1]++;
break;
case 'b' : count2[2]++;
break;
case 'c' : count2[3]++;
break;
case 'd' : count2[4]++;
break;
case 'e' : count2[5]++;
break;
case 'f' : count2[6]++;
break;
case 'g' : count2[7]++;
break;
case 'h' : count2[8]++;
break;
case 'i' : count2[9]++;
break;
case 'j' : count2[10]++;
break;
case 'k' : count2[11]++;
break;
case 'l' : count2[12]++;
break;
case 'm' : count2[13]++;
break;
case 'n' : count2[14]++;
break;
case 'o' : count2[15]++;
break;
case 'p' : count2[16]++;
break;
case 'q' : count2[17]++;
break;
case 'r' : count2[18]++;
break;
case 's' : count2[19]++;
break;
case 't' : count2[20]++;
break;
case 'u' : count2[21]++;
break;
case 'v' : count2[22]++;
break;
case 'w' : count2[23]++;
break;
case 'x' : count2[24]++;
break;
case 'y' : count2[25]++;
break;
case 'z' : count2[26]++;
break;
}
}
//s3=s3+" 4 ";
				for(i=1;i<27;i++)
				{
					nxtwrd=true;
					if(count1[i]!=count2[i])
					{
						//the present has not matched and we need to search the next word.
						nxtwrd=false;
						break;
					}
				}
				
	//			s3=s3+" 5 ";
				if(nxtwrd)
			    {
				wordfound=true;
			    mtow=true;
				s3=s3+" "+s2;
				}
				//s3=s3+" 6 ";
			//}
			
		}//WHILE ENDS HERE........
	
	
			st.close();
			con.close();
	}//TRY ENDS HERE........
	
		catch(Throwable e)
		{//so strange.....this will give us the result as well an error.
			//s3="this is from the catch block error";
			//uncomment any of the comments shown below and you will c that you have an error,wiht the answers
		//s3=s3+" there is an error........."+e;
		//s3=s3+" "+e+" there is an error . Count is "+count;
		}
	if(!wordfound)
		s3="no such word found";
	return s3;//+" error string is "+errorString+" and the count is : "+count;
}


}