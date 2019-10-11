package com.khrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.khrd.dto.SbProject;
import com.khrd.jdbc.JdbcUtil;

public class SbProjectDAO {
	private static final SbProjectDAO dao = new SbProjectDAO();
	
	public static SbProjectDAO getInstance() {
		return dao;
	}
	
	private SbProjectDAO() {}
	
	public int insertSb(Connection conn, SbProject sb) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into sb_project values(null,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sb.getSbName());
			pstmt.setString(2, sb.getSbContent());
			pstmt.setTimestamp(3, new Timestamp(sb.getSbStart().getTime()));
			pstmt.setTimestamp(4, new Timestamp(sb.getSbStop().getTime()));
			pstmt.setString(5, sb.getSbProgress());
			
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return -1;
	}
	
	public ArrayList<SbProject> selectSbProjectList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from sb_project order by sbNo desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<SbProject> list = new ArrayList<>();
			
			while(rs.next()) {
				SbProject sb = new SbProject(rs.getInt("sbNo"),
								rs.getString("sbName"),
								rs.getString("sbContent"),
								rs.getDate("sbStart"), 
								rs.getDate("sbStop"),
								rs.getString("sbProgress"));
				list.add(sb);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return null;
	}
	
	public SbProject selectByNo(Connection conn, int sbNo) {
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		
		try {
			String sql = "select * from sb_project where sbNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sbNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SbProject sb = new SbProject(rs.getInt("sbNo"),
								rs.getString("sbName"),
								rs.getString("sbContent"),
								rs.getDate("sbStart"), 
								rs.getDate("sbStop"),
								rs.getString("sbProgress"));
				return sb;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		
		return null;
	}
	
	public int deleteSbProject(Connection conn, int sbNo) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from sb_project where sbNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sbNo);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		return -1;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
