package payDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import payUtil.DBUtil;
import payBean.Student;

public class StudentDao {
	DBUtil util = new DBUtil();
	//addStudent
	public boolean addStudent(Student student) {
		String sql = "insert into student(yb_userid,yb_username,yb_collegename) values(?,?,?)";
		try {
			Connection conn = util.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,student.getYb_userid());
			pst.setString(2,student.getYb_username());
			pst.setString(3, student.getYb_collegename());
			
			int count = pst.executeUpdate();
			pst.close();
			conn.close();
			System.out.println("add Over!");
			return count > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//collegeNum
	public int getCollegeNum(Student student) {
		String sql = "select count(distinct yb_username) from student where yb_collegename=?";
		int count = 0;
		try {
			Connection conn = util.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, student.getYb_collegename());
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				count = res.getInt(1);
			}
			res.close();
			pst.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	//allNum
	public int getAllNum() {
		String sql = "select count(id) from student";
		int count = 0;
		try {
			Connection conn = util.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet res = pst.executeQuery();
			if(res.next()) {
				count = res.getInt(1);
			}
			res.close();
			pst.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
