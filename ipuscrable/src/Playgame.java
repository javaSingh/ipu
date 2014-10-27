//an equivalent jsp is used instead of this.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import pack1.WordCorrectModel;

/**
 * Servlet implementation class Playgame
 */
public class Playgame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Playgame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
			{
		// TODO Auto-generated method stub

	PrintWriter out=response.getWriter();
	out.println("<html><body>");
	out.println("hello . this is from servlet. thank u....since the database is not working well i've hard coded the value....so please bear with me a for a while");
	ServletContext application=getServletContext();
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		String arr[],word,userword,randomword;
		//the user comes for the first time or
		//or the user has entered the right word and need to have another word to play
		//the user has entered the wrong word

		if(request.getParameter("word")==null||request.getParameter("word")=="")
		{

			
		//if previous word was right or
		//the user has come for the first time
		//we need to provide user with a new random word here.
		if(application.getAttribute("randomword")==null)
		{
		/*WordCorrectModel wcm;
		Random random;
		wcm=new WordCorrectModel();
		random=new Random();
		//this loop will give us word of length <= 5.
		// keep repeating until we get words having less len <=5
		do
		{
		int x=random.nextInt(50000);
		arr=wcm.getWord(x);
		}while(arr[0].length()>5);
		word=arr[0];
		
			randomword=arr[1];
		*/word="singh";
		randomword="gnsih";

		//forget the array now.
		//application.setAttribute("userword",)
		application.setAttribute("word",word);
		application.setAttribute("randomword",randomword);
		//display the randomword for the user;
		out.println("tell the correct word of "+randomword);
		}


		//the user has entered wrong word previously
		//ie getAttribute(randomword)!=null
		else
		{
		//display-"you have entered the wrong word. try again."
		out.println("you entered the wrong word........");
		//display the word from the attribute(randomword). 
		//i.e the same word which the user entered in correctly previously
		out.println("tell the correct word of "+application.getAttribute("randomword"));
		}
		
		out.println("<form action='playgame'>Here ::<input type='text' placeholder='enter word' name='word'></input><input type='submit' value='i am done'></input></form><form action='playgame1.jsp'>	HElp meEEEE!!!!!<input type='submit' value='Please, go to next word'></input></form>");
		

		
		
				//the user has entered a word previously and it need to be checked here
		//we check the word (correct word)with the user entered word
		}







		else
		{
		//out.println("you entered "+request.getParameter("word"));
		//if the user has entered the right word
		if((application.getAttribute("word")).equals((String)request.getParameter("word")))
		{
		//set all attribute as null;
		application.setAttribute("word",null);
		application.setAttribute("randomword",null);
		out.println("you have entered the correct word");
		
		out.println("<a href='playgame.jsp'>Play More......</a>");
		
		}
		//the user entered word is wrong
		else
		{
		//out.println(" the correct word is "+application.getAttribute("word"));
		//keep the attributes intact and resend to this page
		out.println("you entered the worng word");
		
		out.println("<a href='playgame.jsp'>.....go back</a>");
		
		response.sendRedirect("playgame");
		}
		}
		out.println("</body></html>");

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
