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

public class BandDao {
	
	private BandDao() {}
	private static BandDao instance=new BandDao();
	

	public static BandDao getInstance() {
		// TODO Auto-generated method stub
		return instance;
		
	}
	
	public int save(String bandName, String bandInfo, int userId) {

		// 1.Stream 연결
		Connection conn = DBUtill.getConnection();
		PreparedStatement pstmt = null;

		// 2. 메세지 (쿼리) 전송 클래스 ( 규약에 맞게)
		final String SQL = "insert into band (bandName, bandInfo, userId) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			// 3.sql문 완성하기
			pstmt.setString(1, bandName);
			pstmt.setString(2, bandInfo);
			pstmt.setInt(3, userId);
			
			// 4.sql문 전송 send 프로토콜에 따라 다르게 보내야하기 떄무네 dql select --결과를 달라고 dpl (write할 거임 /
			// return 필요업음 )insert
			// pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			System.out.println(result);

			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				pstmt.close();
				/* conn.commit(); */
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return -1;

	}

	public List<Band> findAll() {
		// TODO Auto-generated method stub
		List<Band> bands=new ArrayList<>();
		
		Connection conn=DBUtill.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL = "select * from band Order by id DESC";
		try {
			pstmt =conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				int userId = rs.getInt("userId");
				String bandName = rs.getString("bandName");
				String bandInfo = rs.getString("bandInfo");
				String boardTitle = rs.getString("boardTitle");
				String boardContent = rs.getString("boardContent");
				String eventTitle = rs.getString("eventTitle");
				String eventContent = rs.getString("eventContent");
				
				System.out.println(id);
				Band band=Band.builder().id(id).userId(userId).bandName(bandName).boardTitle(boardTitle).boardContent(boardContent).eventTitle(eventTitle).eventContent(eventContent).bandInfo(bandInfo).build();
				bands.add(band);
				System.out.println(bandName);
			}
			return bands;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
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

	public BandUserVM findById(int id) {
		// TODO Auto-generated method stub
		Connection conn=DBUtill.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		final String SQL="select b.id,b.userId, b.bandName, b.bandInfo,u.userId, u.username\r\n" + 
				"from band b inner join user u on b.userId=u.userId\r\n" + 
				"where b.id=? ";
		try {
			pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			BandUserVM buVM=null;
			if (rs.next()) {
				String bandName=rs.getString("b.bandName");
				String bandInfo=rs.getString("b.bandInfo");
				int userId=rs.getInt("b.userId");
				String username=rs.getString("u.username");
				
				Band band=Band.builder().id(id).userId(userId).bandName(bandName).bandInfo(bandInfo).build();
				User user =User.builder().userId(userId).userName(username).build();
				buVM =new BandUserVM(band, user);
				
			}return buVM;
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

	public List<Band> findbyUserId(int userId) {
		List<Band> bands=new ArrayList<>();
		Connection conn=DBUtill.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		final String SQL="select b.id,b.userId, b.bandName, b.bandInfo,u.userId, u.username\r\n" + 
				"from band b inner join user u on b.userId=u.userId\r\n" + 
				"where u.userId=? Order by id DESC";
		try {
			pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();
			BandUserVM buVM=null;
			while (rs.next()) {
				int id=rs.getInt("b.id");
				String bandName=rs.getString("b.bandName");
				String bandInfo=rs.getString("b.bandInfo");
				String username=rs.getString("u.username");
				
				
				Band band=Band.builder().id(id).userId(userId).bandName(bandName).bandInfo(bandInfo).build();
				//User user =User.builder().userId(userId).userName(username).build();
				//buVM =new BandUserVM(band, user);
				bands.add(band);
				System.out.println(bands);
				
			}return bands;
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
	
}
