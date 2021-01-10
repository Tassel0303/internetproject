package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.entity.User;
import com.utils.JdbcUtils;


public class UserDaoImp implements UserDao{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public boolean login(String username, String password)  {
		// TODO Auto-generated method stub
		boolean flag = false;//���λ��Ĭ��Ϊfalse
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where name = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, username);
			pstmt.setObject(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flag = true; //���������ǿգ�˵�����û�ƥ�䣨�û���������ȷ��
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return flag; //���ر��
	}

	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into users(name, password, email, phone,postcode) values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, user.getName());
			pstmt.setObject(2, user.getPassword());
			pstmt.setObject(3, user.getEmail());
			pstmt.setObject(4, user.getPhone());
			pstmt.setObject(5, user.getPostcode());
			
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
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String postcode = rs.getString("postcode");

				User user = new User(id, name, password, email,phone,postcode);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return users; 
	}

	@Override
	public List<User> queryUserByPage(int pageNow) {
		// TODO Auto-generated method stub
		
		int pageCount = 5;
		
		List<User> users = new ArrayList<User>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from users limit ?, ?";
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setObject(1, (pageNow-1)*pageCount);
			pstmt.setObject(2, pageCount);
			
			rs = pstmt.executeQuery();
			System.out.println("sdfdsfsfsfsfdsfffffffff");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String postcode = rs.getString("postcode");

				User user = new User(id, name, password, email,phone,postcode);
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(conn, pstmt, rs);
		}
		
		return users; 
	}

	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select count(*) from users";
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
