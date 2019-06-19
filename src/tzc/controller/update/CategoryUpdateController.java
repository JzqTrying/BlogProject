package tzc.controller.update;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Category;
import tzc.dao.CategoryDao;
import tzc.daoImpl.CategoryDaoImpl;

/**
 * Servlet implementation class CategoryUpdateController
 */
@WebServlet("/admin/CategoryUpdate")
public class CategoryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryUpdateController() {
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
		System.out.println("update");
		CategoryDao categoryDao=new CategoryDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Category category=new Category(id,new java.sql.Date(System.currentTimeMillis()));
		String name=request.getParameter("name");
		category.setName(name);
		categoryDao.update(category);
		response.sendRedirect("Category");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
String cName=request.getParameter("name");
		
		if(cName==null||"".equals(cName)) {
			request.setAttribute("error", "分类名称不能为空");
			doGet(request, response);
			return;
		}
		doGet(request, response);
	}

}
