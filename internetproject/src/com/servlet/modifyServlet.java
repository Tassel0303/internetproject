package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.entity.User;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/modifyServlet")
public class modifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("u", "working");
		request.getRequestDispatcher("modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add add user");
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password2");
		String tel = request.getParameter("phone");
		String postcode = request.getParameter("postcode");
		System.out.println(username+email+password+tel+postcode);
		User user = new User(username, password, email, tel, postcode);
		
		UserDao userdao = new UserDaoImp();
		if(userdao.save(user)){
			request.setAttribute("u", "working");
		}
		request.getRequestDispatcher("person.jsp").forward(request, response);
	}

}
