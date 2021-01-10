package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FriDao;
import com.dao.FriDaoImp;
import com.entity.Friend;

/**
 * Servlet implementation class ListAllUsersServlet
 */
@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String search=request.getParameter("search");
		
		System.out.println(search);
		
		
		FriDao friDao = new FriDaoImp(search);
		//List<User> users = userDao.queryAll();
		System.out.println("ListAllUsersServlet");
		
		
		List<Friend> friends = friDao.queryFind();
		request.setAttribute("friends", friends);
		request.getRequestDispatcher("find.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
