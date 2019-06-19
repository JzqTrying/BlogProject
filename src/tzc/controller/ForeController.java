package tzc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Blog;
import tzc.bean.Category;
import tzc.dao.BlogDao;
import tzc.dao.CategoryDao;
import tzc.daoImpl.ArticleDaoImpl;
import tzc.daoImpl.BlogDaoImpl;
import tzc.daoImpl.CategoryDaoImpl;

/**
 * Servlet implementation class ForeController
 */
@WebServlet("/admin/Fore")
public class ForeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForeController() {
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
		for(Category c:categorys) {
			int cid=c.getId();
			c.setArticles(new ArticleDaoImpl().selectByCid(cid));
		}
		BlogDao blogDao=new BlogDaoImpl();
		List<Blog> blogs=blogDao.getAll();
		request.setAttribute("blogs", blogs);
		request.getRequestDispatcher("/fore.jsp").forward(request, response);
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
