package tzc.controller.add;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Areply;
import tzc.bean.User;
import tzc.dao.AreplyDao;
import tzc.daoImpl.AreplyDaoImpl;

/**
 * Servlet implementation class AreplyAddController
 */
@WebServlet("/admin/AreplyAdd")
public class AreplyAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreplyAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Areply arelpy=new Areply();
		arelpy.setCreateDate(new Date(System.currentTimeMillis()));
		int aid = Integer.parseInt(request.getParameter("aid"));
		arelpy.setAid(aid);
		arelpy.setContent(request.getParameter("content"));
		arelpy.setUsername("admin");
//		User user=(User)request.getSession().getAttribute("username");
//		arelpy.setUsername(user.getUsername());
		AreplyDao areplyDao=new AreplyDaoImpl();
		areplyDao.addAreply(arelpy);
		response.sendRedirect("ArticleGet?id="+aid);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
