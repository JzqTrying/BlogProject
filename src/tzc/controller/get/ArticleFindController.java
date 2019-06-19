package tzc.controller.get;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Areply;
import tzc.bean.Article;
import tzc.bean.Blog;
import tzc.bean.Category;
import tzc.dao.AreplyDao;
import tzc.dao.ArticleDao;
import tzc.dao.BlogDao;
import tzc.dao.CategoryDao;
import tzc.daoImpl.AreplyDaoImpl;
import tzc.daoImpl.ArticleDaoImpl;
import tzc.daoImpl.BlogDaoImpl;
import tzc.daoImpl.CategoryDaoImpl;
import tzc.util.Page;
import tzc.util.PageUtil;

/**
 * Servlet implementation class ArticleFindController
 */
@WebServlet("/admin/ArticleFind")
public class ArticleFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleFindController() {
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
		String title=request.getParameter("title");
		Article article=articleDao.findArticleByTitle(title);
		
		int currentPage = 0;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr == null || "".equals(currentPageStr)){
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(currentPageStr);
		}
		request.setAttribute("article", article);
		AreplyDao areplyDao=new AreplyDaoImpl();
		Page page = PageUtil.createPage(5, areplyDao.findAllCountByAid(article.getId()), currentPage);
		request.setAttribute("page", page);
		List<Areply> areplys=areplyDao.findAreplyByAid(article.getId(), page);		
		request.setAttribute("ar", areplys);
		request.getRequestDispatcher("/article.jsp").forward(request, response);
		
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
