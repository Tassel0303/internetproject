package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.jhtml")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("test");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");		
		
		System.out.println(name + password);
	
		UserDao dao = new UserDaoImp();
		
		if(dao.login(name, password)){
			request.getSession().setAttribute("u", name);
			//response.sendRedirect("welcome.jsp");
			request.getSession().setAttribute("username",name);
			System.out.print(name);
			request.getRequestDispatcher("welcome.jsp").forward(request,response);
			//response.sendRedirect("welcome.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	}
}
