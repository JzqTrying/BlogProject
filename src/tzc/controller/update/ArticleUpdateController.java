package tzc.controller.update;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Article;
import tzc.dao.ArticleDao;
import tzc.daoImpl.ArticleDaoImpl;

/**
 * Servlet implementation class ArticleUpdateController
 */
@WebServlet("/admin/ArticleUpdate")
public class ArticleUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleUpdateController() {
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
		request.setCharacterEncoding("UTF-8");
		ArticleDao articleDao=new ArticleDaoImpl();
		int id = Integer.parseInt(request.getParameter("id"));
		Article article=new Article();
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int cid = Integer.parseInt(request.getParameter("cid"));
		int count = Integer.parseInt(request.getParameter("count"));
		article.setId(id);
		article.setTitle(title);
		article.setCid(cid);
		article.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
		article.setCount(count);
		article.setContent(content);
		articleDao.update(article);
		response.sendRedirect("Article");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
String cName=request.getParameter("title");
int cid = Integer.parseInt(request.getParameter("cid"));
int count = Integer.parseInt(request.getParameter("count"));	
String content=request.getParameter("content");
		if(cName==null||"".equals(cName)||"".equals(cid)||"".equals(count)||content==null||"".equals(content)) {
			request.setAttribute("error", "输入不能为空");
			doGet(request, response);
			return;
		}
		doGet(request, response);
	}

}
