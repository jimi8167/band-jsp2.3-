package com.cos.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.project.db.DBUtill;
import com.cos.project.model.Band;
import com.cos.project.model.BandUserVM;
import com.cos.project.model.User;

public class UserDao {

	private UserDao() {

	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public int save(String userName, String email, String password) {
		Connection conn = DBUtill.getConnection();
		PreparedStatement pstmt = null;
		final String SQL = "insert into user(username, email, password) values(?,?,?)";

		try {
			pstmt=conn.prepareStatement(SQL);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			System.out.println("inserting ");

			int result = pstmt.executeUpdate();
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.commit();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}return -1;

	}

	public User login(String email, String password) {
		// TODO Auto-generated method stub
		Connection conn=DBUtill.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="SELECT * FROM user WHERE email=? and password=?";
		
		try {
		pstmt=conn.prepareStatement(SQL);
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		User user=null;
		if (rs.next()) {
			int userId=rs.getInt("userId");
			String userName=rs.getString("username");
			user = User.builder().userId(userId).userName(userName).email(email).build();
		}
		return user;
		
		
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	public List<BandUserVM>  findbyUserId(int userId) {
		List<BandUserVM> buVMs=new ArrayList<>();
				Connection conn=DBUtill.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				
				final String SQL="select b.id,b.userId, b.bandName, b.bandInfo,u.userId, u.username\r\n" + 
						"from band b inner join user u on b.userId=u.userId\r\n" + 
						"where u.userId=?";
				try {
					pstmt=conn.prepareStatement(SQL);
					
					pstmt.setInt(1, userId);
					rs=pstmt.executeQuery();
					BandUserVM buVM=null;
					if (rs.next()) {
						int id=rs.getInt("b.id");
						String bandName=rs.getString("b.bandName");
						String bandInfo=rs.getString("b.bandInfo");
						
						String username=rs.getString("u.username");
						
						
						Band band=Band.builder().id(id).userId(userId).bandName(bandName).bandInfo(bandInfo).build();
						User user =User.builder().userId(userId).userName(username).build();
						buVM =new BandUserVM(band, user);
						buVMs.add(buVM);
						System.out.println("도도도ㅗ올오로내로내야");
						
					}return buVMs;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					try {
						pstmt.close();
						conn.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return null;
	}

	public String findUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUserName(String email) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Connection conn=DBUtill.getConnection();
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				final String SQL="SELECT username FROM user WHERE email=? ";
				
				try {
				pstmt=conn.prepareStatement(SQL);
				pstmt.setString(1, email);
				
				rs=pstmt.executeQuery();
				User user=null;
				if (rs.next()) {
					int userId=rs.getInt("userId");
					String userName=rs.getString("username");
					user = User.builder().userId(userId).userName(userName).email(email).build();
				}
				return user;
				
				
					
				} catch (Exception e) {
					// TODO: handle exception
					
					e.printStackTrace();
				}
				finally {
					try {
						pstmt.close();
						rs.close();
						conn.close();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				
				
				return null;
	}
}
