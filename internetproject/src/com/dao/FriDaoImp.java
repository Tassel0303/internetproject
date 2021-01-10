package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Friend;
import com.utils.JdbcUtils;


public class FriDaoImp implements FriDao{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String search;
	
	public FriDaoImp(String search) {
		this.search=search;
	}
	
	public FriDaoImp() {
		
	}
	
	
	@Override
	public boolean save(Friend friend) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into friends(name,sex,phone,email,qq,job,location,postcode) values(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, friend.getName());
			pstmt.setObject(2, friend.getSex());
			pstmt.setObject(3, friend.getPhone());
			pstmt.setObject(4, friend.getEmail());
			pstmt.setObject(5, friend.getQQ());
			pstmt.setObject(6, friend.getJob());
			pstmt.setObject(7, friend.getLocation());
			pstmt.setObject(8, friend.getPostcode());

			if(pstmt.executeUpdate() > 0) {
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return flag;
		
	}

	@Override
	public List<Friend> queryAll() {
		// TODO Auto-generated method stub
		List<Friend> friends = new ArrayList<Friend>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from friends";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String qq = rs.getString("qq");
				String job = rs.getString("job");
				String location = rs.getString("location");
				String postcode = rs.getString("postcode");

				Friend friend = new Friend(id, name,sex,phone,email,qq,job,location,postcode);
				friends.add(friend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return friends; 
	}
	public List<Friend> queryFind() {
		// TODO Auto-generated method stub
		List<Friend> friends = new ArrayList<Friend>();
		try {
			conn = JdbcUtils.getConnection();
			String sql =String.format( "select * from friends where name='%s'", this.search);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String qq = rs.getString("qq");
				String job = rs.getString("job");
				String location = rs.getString("location");
				String postcode = rs.getString("postcode");

				Friend friend = new Friend(id, name,sex,phone,email,qq,job,location,postcode);
				friends.add(friend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return friends; 
	}

	@Override
	public List<Friend> queryFriByPage(int pageNow) {
		// TODO Auto-generated method stub
		
		int pageCount = 5;
		
		List<Friend> friends = new ArrayList<Friend>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from friends limit ?, ?";
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setObject(1, (pageNow-1)*pageCount);
			pstmt.setObject(2, pageCount);
			
			rs = pstmt.executeQuery();
			System.out.println("sdfdsfsfsfsfdsfffffffff");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String qq = rs.getString("qq");
				String job = rs.getString("job");
				String location = rs.getString("location");
				String postcode = rs.getString("postcode");

				Friend friend = new Friend(id, name, sex,phone,email,qq,job,location,postcode);
				friends.add(friend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return friends; 
	}

	@Override
	public int countFriends() {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from friends";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return count; 
	}

	

}
