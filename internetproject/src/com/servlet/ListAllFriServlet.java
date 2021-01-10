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
@WebServlet("/ListAllFriServlet")
public class ListAllFriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllFriServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FriDao friDao = new FriDaoImp();
		//List<User> users = userDao.queryAll();
		System.out.println("ListAllUsersServlet");
		
		int totalCount = friDao.countFriends();
		int pageCount = 5;
		int pageTotal = 0;
		if(totalCount % pageCount == 0){
			pageTotal = totalCount / pageCount;
		}else{
			pageTotal = totalCount / pageCount + 1;
		}
		
		
		int pageNow = 0;
		if(request.getParameter("pageNow") == null){
			pageNow = 1;
		}else{
			pageNow = Integer.parseInt(request.getParameter("pageNow"));
			if(pageNow < 1){
				pageNow = 1;
			}
			if(pageNow > pageTotal){
				pageNow = pageTotal;
			}
		}
		
		List<Friend> friends = friDao.queryFriByPage(pageNow);
		request.setAttribute("pageNow", pageNow);
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
