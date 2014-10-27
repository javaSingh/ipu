package com;
//the table we have used here is -
// studentnavneet
import java.sql.*;
public class Database
{
Connection con;
ResultSet rs;
PreparedStatement st;
String errorString="";

public Database()
{
try
{


			
		//this works for mysql of cloudbees.
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://us-cdbr-cb-east-01.cleardb.net:3306/cb_test432","b49635eb3ae2d2","64701f54");		
		
		
		
		//this works for local oracle db.
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","star");


}catch(Exception e){
	errorString=" "+e;
}
}



public String dataCheck(String s1,String s2)
{
	//return con+" ";
	
//check variables
//int k=5;//this will be used to count while loop
int i=12;//
String userid;
userid=s1;//this will ensure that his id is shown in a case sensitive manner.
s1=s1.toLowerCase();
s2=s2.toLowerCase();
try{
st=con.prepareStatement("select * from studentnavneet where userpass=?");
st.setString(1,s2);
rs=st.executeQuery();
while(rs.next())
{
//will count the loops
//k++;
if(s1.equals(rs.getString(2)))
i=1;
//ie there is a match
}
st.close();
con.close();
}
catch(Exception e)
{
return "An error has happened";//+" this is from catch "+e+" this si from errorString: "+errorString;
}
//what will happen when no match is found??
//will null be sent or e.toString()??
if(i==1)
{
return userid;//+" "+errorString;//user id is returned to be set to session
}
else
return "there is no match";
}


public String dataEntryNew(String[] userdata)

{
	try {
		st=con.prepareStatement("select * from studentnavneet where userid=?");
	
	st.setString(1,userdata[1]);
	rs=st.executeQuery();
	while(rs.next())
	{
		return "not new";
	}
	st=con.prepareStatement("insert into studentnavneet values(?,?,?,null,null,null,null,null,null)");
	//st=con.prepareStatement("update studentnavneet set name=?,userid=?,userpass=?");
	st.setString(1, userdata[0]);
	st.setString(2, userdata[1]);
	st.setString(3, userdata[2]);
	st.executeUpdate();
	st.close();
	con.close();
	}
 catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	//return ""+e;
	return "inside catch";
}
	return "successful";
	
	
}

public String getPassword(String name,String userid)
{
	String errorString="";
	String userpassword="no such user";
try{
st=con.prepareStatement("select * from studentnavneet where name=? and userid=?");
//st=con.prepareStatement("select * from studentnavneet where uniqueid=?");
st.setString(1,name);
st.setString(2,userid);
rs=st.executeQuery();
while(rs.next())
{
userpassword=rs.getString(3);
}
st.close();
con.close();

}catch(Exception e)
{ 
	return "error with database";// "+e;

//return s;
}
return userpassword;
}




/*
public String[] getData(int uniqueid)
{
String[] dataString;
dataString=new String[9];
dataString[0]="vcode does not exist";
try{
st=con.prepareStatement("select * from studentnavneet where uniqueid=?");
//st=con.prepareStatement("select * from studentnavneet where uniqueid=?");
st.setInt(1,uniqueid);
rs=st.executeQuery();
while(rs.next())
{
for(int i=0;i<9;i++)
{
dataString[i]=rs.getString(i+1);
}
}
}catch(Exception e)
{ 
String[] s={"this is catch block"};
return s;
}
return dataString;
}
*/

/*
public String dataEntry(String[] s, int uniqueid)
{
String[] dataString;
String userid;
dataString=getData(uniqueid);

if(s[1]==dataString[1]) 
{
return "notnew";//this id and password already exist. try new one.
}
else if(dataString[0]=="this is catch block")
{
return "error has occoured at the getData Method";
}
//dataString[0]==null implies that the vcode does not exists
//dataString[1]!=null || dataString[2]!=null means that a valid vcode is been
//used by an ivalid person
else if (dataString[0]=="vcode does not exist" || dataString[1]!=null || dataString[2]!=null)
{
return "someone's using someone's else VCode.";//or the code does not exists at all.
}
else
{
try{
st=con.prepareStatement("update studentnavneet set name=?,userid=?,userpass=?,address=?,phonenum=?,physics=?,chemistry=?,maths=? where uniqueid=?");
st.setString(1,(s[0].toLowerCase()));
st.setString(2,(s[1].toLowerCase()));
st.setString(3,(s[2].toLowerCase()));
st.setString(4,null);
st.setString(5,(s[3].toLowerCase()));
st.setString(6,"not available");
st.setString(7,"not available");
st.setString(8,"not available");
st.setInt(9,uniqueid);
st.executeUpdate();
}
catch(Exception e){return (e.toString())+"error in adding to the database";}
return "successful";
}
}
public int getNewUniqueid()
{
String errorString=null;
int uniqueid=785;
try{
st=con.prepareStatement("select uniqueid from studentnavneet");
rs=st.executeQuery();
while(rs.next())
{uniqueid=rs.getInt(1);}
}
catch(Exception e){return 9111;}//ie table is inaccessible
uniqueid++;//the user will get a user id one more than the last id in the table
errorString=uniqueidEntry((new String[5]),uniqueid);
if(errorString=="successful")
return uniqueid;
else
//error in uniqueidentry
return 0;
}
public String uniqueidEntry(String[] s, int uniqueid)
{
try{
st=con.prepareStatement("insert into studentnavneet values(?,?,?,?,?,?,?,?,?)");
st.setString(1,s[0]);
st.setString(2,s[1]);
st.setString(3,s[2]);
st.setString(4,null);
st.setString(5,s[3]);
st.setString(6,"not available");
st.setString(7,"not available");
st.setString(8,"not available");
st.setInt(9,uniqueid);
st.executeUpdate();
}catch(Exception e){return "error in uniqeidentry";}
return "successful";
}







public int getuniqueid(String s1, String s2)
{
int uniqueid=0;
try{
st=con.prepareStatement("select uniqueid from studentnavneet where userid=?");
st.setString(1,s1);
rs=st.executeQuery();
while(rs.next())
{
uniqueid=rs.getInt(1);
}
}
catch(Exception e){return 9111;}//ie table is inaccessible

if(uniqueid==0)
return 0;
else 
return uniqueid;

}*/







}