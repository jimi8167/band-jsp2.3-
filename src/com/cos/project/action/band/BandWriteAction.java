package com.cos.project.action.band;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;

public class BandWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis =req.getRequestDispatcher("/pages/examples/profile.jsp");//기존의 req, resp위에 덮어씌움
		dis.forward(req, resp);

	}

}
