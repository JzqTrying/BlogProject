package tzc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.bean.User;
import tzc.dao.UserDao;
import tzc.daoImpl.UserDaoImpl;

public class AdminRegisterController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		User user=new User();
		UserDao userdao=new UserDaoImpl();
		if(password.equals(repassword)) {
			user.setUsername(username);
			user.setPassword(password);
			userdao.addUser(user);
			request.setAttribute("success", "账号注册成功");
		}else {
			request.setAttribute("error", "两次密码输入不同");
		}
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}
}
