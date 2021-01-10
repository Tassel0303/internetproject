package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.entity.Friend;


public interface FriDao {
	public boolean save(Friend friend) ;
	public List<Friend> queryAll();
	public List<Friend> queryFind();
	public List<Friend> queryFriByPage(int pageNow);
	public int countFriends();
}