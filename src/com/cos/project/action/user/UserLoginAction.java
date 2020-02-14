package com.cos.project.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;

public class UserLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("도착 ");
		//페이지 이동 
				RequestDispatcher dis =req.getRequestDispatcher("/pages/examples/login.jsp");//기존의 req, resp위에 덮어씌움
				dis.forward(req, resp);
				
				
				
	}

}
