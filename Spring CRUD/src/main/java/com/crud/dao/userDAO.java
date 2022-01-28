
package com.crud.dao;  
import java.sql.*;  
import java.util.ArrayList;  
import com.crud.bean.user;  
import com.crud.common.JDBCUtil;
public class userDAO {  

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	private final String USER_INSERT = "insert into jspcrud (title, writer, content) values (?,?,?)";
	private final String USER_UPDATE = "update jspcrud set title=?, writer=?, content=? where seq=?";
	private final String USER_DELETE = "delete from jspcrud where seq=?";
	private final String USER_GET = "select * from jspcrud where seq=?";
	private final String USER_LIST = "select * from jspcrud order by seq desc";

	public int insertUser(user vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	public int updateUser(user vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	};
	
	public void deleteUser(user vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, Integer.toString(vo.getSeq()));
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	};
	
	public ArrayList<user> getUserList() {
		ArrayList<user> list = null;
		conn = JDBCUtil.getConnection();
		try {
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			list = new ArrayList<user>();
			user vo = new user();
			while(rs.next()) {
				vo = new user();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				list.add(vo);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	};
	
	public user getUser(int seq) {
		user vo = null;
		try {
			vo = new user();
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			rs = stmt.executeQuery();
			rs.next();
			
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			return vo;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	};
}




