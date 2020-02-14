package com.cos.project.action.user;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.project.action.Action;
import com.cos.project.dao.UserDao;
import com.cos.project.model.User;
import com.cos.project.util.Script;

public class UserLoginProcAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("email")==null
				||req.getParameter("password")==null
				) {//||req.getParameter("rememberMe")==null 이건 값이 없을 수도 있기 때문에
			//required넣었기 때문에  post방식 말고 이상하게 접근한거 아닌 거임 
			req.getHeader("referer");//너 어디서부터 왔니 이전 주소가 안나오거나, 커맨드창, 최초접근일 것임 을 발견할 수 있음 
			resp.sendRedirect("/");
			return;//response가 두번되면 안되기 때문에 계속 내려가면 안됨
			
		}
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		String rememberMe=Optional.ofNullable(req.getParameter("rememberME")).orElse("off");
		
		System.out.println("email : "+email);
		System.out.println("password : "+password);
		System.out.println("rememberMe : "+rememberMe);
		
		UserDao userDao=UserDao.getInstance();
		User user=userDao.login(email, password);
		User username=userDao.findUserName(email);
		
		if (rememberMe.equals("on")) {
			Cookie cookie=new Cookie("userEmailCookie",email);
			cookie.setMaxAge(60*60*24*7);//일주일 보관
			resp.addCookie(cookie);
		}else {
			Cookie cookie=new Cookie("userEmailCookie", "");
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		if (user!=null) {
			HttpSession session= req.getSession();
			session.setAttribute("user",user);
			RequestDispatcher dis=req.getRequestDispatcher("/");//pages/layout/top-nav-sidebar.jsp
			dis.forward(req, resp);
			
		}else {
			Script.back(resp, "로그인 실패");
		}

	}

}
