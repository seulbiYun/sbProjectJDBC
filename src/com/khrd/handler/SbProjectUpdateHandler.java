package com.khrd.handler;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.SbProjectDAO;
import com.khrd.dto.SbProject;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JdbcUtil;

public class SbProjectUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			String sNo = request.getParameter("sbNo");
			int sbNo = Integer.parseInt(sNo);
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				SbProjectDAO dao = SbProjectDAO.getInstance();
				SbProject sb = dao.selectByNo(conn, sbNo);
				
				request.setAttribute("sb", sb);
				
				return "/WEB-INF/view/sbProjectUpdateForm.jsp";
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn);
			}
			
			
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
			String sNo = request.getParameter("sbNo");
			int sbNo = Integer.parseInt(sNo);
			String sbName = request.getParameter("sbName");
			String sbContent = request.getParameter("sbContent");
			
			String sbStart = request.getParameter("sbStart");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd");
			Date StartDate = sdf.parse(sbStart);
			
			String sbStop = request.getParameter("sbStop");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyy-mm-dd");
			Date StopDate = sdf2.parse(sbStop);
			
			String sbProgress = request.getParameter("sbProgress");
			
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				SbProjectDAO dao = SbProjectDAO.getInstance();
				
				SbProject sb = new SbProject(sbNo, sbName, sbContent, StartDate, StopDate, sbProgress);
				dao.updateSbProject(conn, sb);
				
				return "list.do";
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(conn);
			}
		}
		return null;
	}

}
