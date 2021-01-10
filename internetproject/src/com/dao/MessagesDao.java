package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.Message;


public interface MessagesDao {

	public boolean save(Message messages) ;
	public List<Message> queryAll();
	public List<Message> queryMessagesByPage(int pageNow);
	public int countMessages();
}
