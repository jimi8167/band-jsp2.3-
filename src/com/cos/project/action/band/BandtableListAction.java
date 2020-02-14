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
//import com.cos.project.dao.UserDao;
import com.cos.project.model.BandUserVM;
import com.cos.project.util.Script;

public class BandtableListAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (req.getParameter("userId")==null|| 
				req.getParameter("userId").equals("")) {
				Script.back(resp, "로그인 하세요.");
				return;
			}
		
			int userId=Integer.parseInt(req.getParameter("userId"));
		BandDao bandDao=BandDao.getInstance();
		UserDao userDao=UserDao.getInstance();
		List<Band> bands= bandDao.findbyUserId(userId);
		//List<BandUserVM> buVMs=bandDao.findbyUserId(userId);
		
		req.setAttribute("bands", bands);
		RequestDispatcher dis = req.getRequestDispatcher("/pages/tables/jsgrid.jsp");
		dis.forward(req, resp);
		
		
	}

}
