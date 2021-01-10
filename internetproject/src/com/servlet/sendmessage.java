package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.MessagesDao;
import com.dao.MessagesDaoImp;
import com.entity.Message;

/**
 * Servlet implementation class SendmessageServlet
 */
@WebServlet("/sendmessage.jhtml")
public class sendmessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendmessage() {
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
		
		
		String sender=(String)request.getSession().getAttribute("username");
		String content = request.getParameter("content");
		String receiver = request.getParameter("reciver");	
		Message messages = new Message(receiver,content,sender,0);
		MessagesDao messagesdao = new MessagesDaoImp();
		if(messagesdao.save(messages)){	
			PrintWriter out=response.getWriter();
			out.print("<script language='javascript'>"
			+"alert('send successfully');window.location.href='sendmessage.jsp';"
			+"</script>");		
		}
	}
}
