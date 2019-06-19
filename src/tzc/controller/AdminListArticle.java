package tzc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Article;
import tzc.dao.ArticleDao;
import tzc.daoImpl.ArticleDaoImpl;
import tzc.util.Page;
import tzc.util.PageUtil;

/**
 * Servlet implementation class AdminListArticle
 */
@WebServlet("/admin/Article")
public class AdminListArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminListArticle() {
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
		ArticleDao articleDao=new ArticleDaoImpl();
		List<Article> articles = articleDao.getall();
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("/listArticle.jsp").forward(request, response);
		System.out.println("degetart");
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
//		int currentPage = 0;
//		String currentPageStr = request.getParameter("currentPage");
//		if(currentPageStr == null || "".equals(currentPageStr)){
//			currentPage = 1;
//		}else {
//			currentPage = Integer.parseInt(currentPageStr);
//		}
//		ArticleDaoImpl articleDaoImpl=new ArticleDaoImpl();
//		ArticleDao articleDao=articleDaoImpl;
//		Page page = PageUtil.createPage(5, articleDao.findAllCount(), currentPage);
//		List<Article> articles = articleDao.findAllArticles(page);
//		request.setAttribute("articles", articles);
//		request.setAttribute("page", page);
//		ServletContext servletContext = getServletContext();
//		RequestDispatcher dispatcher = servletContext.
//					getRequestDispatcher("/ListArticle.jsp");
//		dispatcher.forward(request, response);
		doGet(request, response);
	}

}
