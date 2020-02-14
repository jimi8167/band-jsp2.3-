package com.cos.project.action.band;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.dao.BandDao;
import com.cos.project.model.BandUserVM;
import com.cos.project.model.User;
import com.cos.project.util.Script;

public class BandbandPageAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("id") == null || req.getParameter("id").equals("")) {
			Script.back(resp, "잘못된 접근입니다.");
			return;

		}
		int id = Integer.parseInt(req.getParameter("id"));
		
		BandDao bandDao = BandDao.getInstance();

		BandUserVM buVM = bandDao.findById(id);

		if (buVM != null) {
			req.setAttribute("buVM", buVM);

			RequestDispatcher dis = req.getRequestDispatcher("/pages/examples/profile2.jsp");
			dis.forward(req, resp);

		} else {
			Script.back(resp, "해당 게시물이 없습니다.");
		}

	}

}
