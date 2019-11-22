package payServlet;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import payBean.Student;
import payDao.StudentDao;

/**
 * Servlet implementation class indexServlet
 */

public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String yb_userid = session.getAttribute("yb_userid").toString();
		String yb_username = session.getAttribute("yb_realname").toString();
		String yb_collegename = session.getAttribute("yb_collegename").toString();
		
		Student student = new Student();
		student.setYb_userid(yb_userid);
		student.setYb_username(yb_username);
		student.setYb_collegename(yb_collegename);
		
		StudentDao dao = new StudentDao();
		dao.addStudent(student);//添加学生
		
		int collegeNum = dao.getCollegeNum(student);//信息院人数
		int allNum = dao.getAllNum();
		
		request.setAttribute("collegeNum", collegeNum);
		request.setAttribute("allNum", allNum);
		request.setAttribute("college", student.getYb_collegename());
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
