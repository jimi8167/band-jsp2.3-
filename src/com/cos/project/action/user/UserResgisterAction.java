package com.cos.project.action.user;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;

public class UserResgisterAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("3.UserRegisterAction");
		RequestDispatcher dis= req.getRequestDispatcher("/pages/examples/register.jsp");
														 //AdminLTE/pages/examples/register.jsp
		dis.forward(req, resp);

	}

}
