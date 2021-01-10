package com.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.entity.User;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/regist.jhtml")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		
		
		
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String postcode = request.getParameter("postcode");
		System.out.println(name+password);
	
		User user = new User(name, password, email, phone, postcode);
		
		UserDao userdao = new UserDaoImp();
		if(userdao.save(user)){
			//request.getSession().setAttribute("u",user);
 			//request.getSession().setAttribute("u",postcode);
 			//request.getSession().setAttribute("u",email);
  			//request.getSession().setAttribute("u",phone);
			response.sendRedirect("regsuc.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
		
		
	}

}
