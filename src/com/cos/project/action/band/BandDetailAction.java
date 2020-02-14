package com.cos.project.action.band;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.project.action.Action;
import com.cos.project.dao.BandDao;
import com.cos.project.model.BandUserVM;
import com.cos.project.util.Script;

public class BandDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (req.getParameter("id")==null|| 
				req.getParameter("id").equals("")) {
				Script.back(resp, "잘못된 접근");
				return;
			}
			int id=Integer.parseInt(req.getParameter("id"));
			BandDao boardDao=BandDao.getInstance();
			
			BandUserVM buVM=boardDao.findById(id);
			
			System.out.println("BoardDetailAction : userId : "+buVM.getBand().getUserId());
			System.out.println("BoardDetailAction : userId : "+buVM.getUser().getUserId());
			
			if(buVM != null) {
				req.setAttribute("buVM", buVM);
				RequestDispatcher dis = req.getRequestDispatcher("/pages/examples/profile2.jsp");
				dis.forward(req, resp);
			}else {
				Script.back(resp, "없음 ");
			}
	}

}
