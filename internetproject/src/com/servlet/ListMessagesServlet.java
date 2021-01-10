package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessagesDao;
import com.dao.MessagesDaoImp;
import com.entity.Message;

@WebServlet("/ListMessagesServlet")
public class ListMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListMessagesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=(String)request.getSession().getAttribute("username")+"";
		System.out.println(username);
		// TODO Auto-generated method stub
		MessagesDao MessagesDao = new MessagesDaoImp(username);
		//List<User> users = MessagesDao.queryAll();
		
		int totalcount = MessagesDao.countMessages();
		System.out.println(totalcount);
		int pagecount = 5;
		int pageTotal = 0;
		if(totalcount % pagecount == 0){
			pageTotal = totalcount / pagecount;
		}else{
			pageTotal = totalcount / pagecount + 1;
		}
		
		
		int pagenow = 0;
		if(request.getParameter("pagenow") == null){
			pagenow = 1;
		}else{
			pagenow = Integer.parseInt(request.getParameter("pagenow"));
			if(pagenow < 1){
				pagenow = 1;
			}
			if(pagenow > pageTotal){
				pagenow = pageTotal;
			}
		}
		
		List<Message> messages = MessagesDao.queryMessagesByPage(pagenow);
		request.setAttribute("pagenow", pagenow);
		request.setAttribute("messages", messages);
		request.getRequestDispatcher("getmessage.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
