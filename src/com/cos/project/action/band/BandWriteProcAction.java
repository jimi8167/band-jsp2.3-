package com.cos.project.action.band;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.dao.BandDao;
import com.cos.project.model.Band;
import com.cos.project.model.User;
import com.cos.project.util.Script;

public class BandWriteProcAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("bandName").equals("") || req.getParameter("bandInfo").equals("")
				|| req.getParameter("bandName") == null || req.getParameter("bandInfo") == null) {
			Script.back(resp, "잘못된 접근입니다.");
			return;
		}

		String bandName = req.getParameter("bandName");
		String bandInfo = req.getParameter("bandInfo");
		
		
		User user = (User) req.getSession().getAttribute("user");
		System.out.println("bandName:" + bandName);
		System.out.println("bandInfo:" + bandInfo);
		

		BandDao bandDao = BandDao.getInstance();
		int result = bandDao.save(bandName, bandInfo, user.getUserId());
		System.out.println(result);
		
		if (result == 1) {
			RequestDispatcher dis = req.getRequestDispatcher("/");
			dis.forward(req, resp);

			System.out.println("밴드만들기 성공");
		} else {
			Script.back(resp, "밴드이름과 소개를 적어주세요.");
		}

	}

}
