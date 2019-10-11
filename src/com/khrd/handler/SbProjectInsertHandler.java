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

public class SbProjectInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/sbProjectInsertForm.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
			
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
				conn.setAutoCommit(false);
				SbProjectDAO dao = SbProjectDAO.getInstance();
				SbProject sb = new SbProject(0, sbName, sbContent, StartDate, StopDate, sbProgress);
				
				dao.insertSb(conn, sb);
				conn.commit();
				
				response.sendRedirect(request.getContextPath() + "/list.do");
				
				return null;
			}catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}finally {
				JdbcUtil.close(conn);
			}
			
		}
		return null;
	}

}
