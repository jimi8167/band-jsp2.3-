package com.cos.project.action.user;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.dao.UserDao;
import com.cos.project.util.Script;

public class UserResgisterProcAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=req.getParameter("userName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		System.out.println("userName:"+userName);
		System.out.println("password:"+password);
		System.out.println("email:"+email);
		
		UserDao userDao=UserDao.getInstance();
		int result=userDao.save(userName, email, password);
		
		if (result==1) {
			
			RequestDispatcher dis=req.getRequestDispatcher("/pages/examples/login.jsp");
			dis.forward(req, resp);
			System.out.println("회원가입 성공");
		}else {
			Script.back(resp,"회원가입 실패");
		}
		
		

	}

}
