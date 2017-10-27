

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Main")
public class Main extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String personName;
	private String personPassword;
	private String register;
	private String login;
       
    public Main() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  personName = request.getParameter("personName");
		  personPassword = request.getParameter("personPassword");
		  register = request.getParameter("register");
		  login = request.getParameter("login");
		  if(check(personName, personPassword)){
				    if(login != null)
					  processLogin(request, response);
				    else
				      processRegister(request, response);
				  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private boolean check(String name,String password) {
		if(name==null)
			return false;
		else if (name.isEmpty()) {
			return false;
		}
		if(password==null)
			return false;
		else if (password.isEmpty()) {
			return false;
		}
		return true;
	}
	private void makeCookie(HttpServletResponse response) {
		Cookie aCookie = new Cookie("name", personName); 
		aCookie.setMaxAge(60*60*24*365);
		response.addCookie(aCookie);
		Cookie bCookie = new Cookie("password", personPassword); 
		bCookie.setMaxAge(60*60*24*365);
		response.addCookie(bCookie);
	}
	private void processRegister(HttpServletRequest request, HttpServletResponse response) {
		boolean foundUser = false;
		Cookie[] cookies = request.getCookies(); 
		if (cookies != null && cookies.length > 0) {
		      for(int i=0; i<cookies.length; i++) {
		             Cookie c = cookies[i];
		             if ((c.getName().equals("name")) && (c.getValue().equals(personName))){
		                    foundUser = true; 
		                    break;
		              } 
		      }
	    }
		
		String message;
		if (! foundUser) {
			makeCookie(response);
			message = "You registed successfully";
		}else {
			message = "You have registed before";	
		}
		response.setContentType("text/html"); 
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html>\n" +
					"<head><title>Processing Cookies</title></head>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<h1 alighn\"center\">" + message + "</h1>\n" + "</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	private void processLogin(HttpServletRequest request, HttpServletResponse response) {
		boolean foundUser = false;
		boolean passwordIsRight = false;
		Cookie[] cookies = request.getCookies(); 
		if (cookies != null && cookies.length > 0) {
		      for(int i=0; i<cookies.length; i++) {
		             Cookie c = cookies[i];
		             if ((c.getName().equals("name")) && (c.getValue().equals(personName))){
		                    foundUser = true; 
		              } 
		             if ((c.getName().equals("password")) && (c.getValue().equals(personPassword))){
		                    passwordIsRight = true; 
		              } 
		      }
	    }
		
		String message;
		if (! foundUser) {
			makeCookie(response);
			message = "Please register";
		}else if (! passwordIsRight) {
			message = "Your password is wrong";
		}else {
			message = "You Already Login";	
		}
		response.setContentType("text/html"); 
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<html>\n" +
					"<head><title>Processing Cookies</title></head>\n" + "<BODY BGCOLOR=\"#FDF5E6\">\n" +
					"<h1 alighn\"center\">" + message + "</h1>\n" + "</body></html>");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
}
