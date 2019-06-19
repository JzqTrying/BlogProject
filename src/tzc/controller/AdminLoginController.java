package tzc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.Blog;
import tzc.bean.Category;
import tzc.bean.User;
import tzc.dao.BlogDao;
import tzc.dao.CategoryDao;
import tzc.dao.UserDao;
import tzc.daoImpl.ArticleDaoImpl;
import tzc.daoImpl.BlogDaoImpl;
import tzc.daoImpl.CategoryDaoImpl;
import tzc.daoImpl.UserDaoImpl;


public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		System.out.println("doGet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("doPost");
		UserDao userdao=new UserDaoImpl();
		boolean valid=userdao.isValid(username, password);
		if (valid) {
			
			User user=new User(username,password);
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("fore.jsp").forward(request, response);
			return;
		}
		else {
			request.setAttribute("error", "用户名或密码错误");
			doGet(request, response);
		}
	}
}
