package tzc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Category;
import tzc.dao.CategoryDao;
import tzc.daoImpl.CategoryDaoImpl;

/**
 * Servlet implementation class AdminCategoryController
 */
@WebServlet("/admin/Category")
public class AdminCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCategoryController() {
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
		CategoryDao categoryDao=new CategoryDaoImpl();
		List<Category> categorys=categoryDao.getAll();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/category.jsp").forward(request, response);
		System.out.println("dogetcate");
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
		CategoryDao categoryDao=new CategoryDaoImpl();
		categoryDao.add(new Category(cName,new java.sql.Date(System.currentTimeMillis())));
		doGet(request, response);
	}

}
