package com.cos.project.action.band;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.dao.BandDao;
import com.cos.project.dao.UserDao;
import com.cos.project.model.Band;
import com.cos.project.model.BandUserVM;

public class BandListAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BandDao bandDao=BandDao.getInstance();
		List<Band> bands=bandDao.findAll();
		
		
		req.setAttribute("bands", bands);
		
		RequestDispatcher dis=req.getRequestDispatcher("/band/list.jsp");
		dis.forward(req, resp);
		
		
	}

}
