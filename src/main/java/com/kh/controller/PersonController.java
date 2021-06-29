package com.kh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.test.dto.PersonDTO;
import com.test.dao.PersonDAO;



@WebServlet("*.msg")
public class PersonController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		
		String url = requestURI.substring(ctxPath.length());
		System.out.println(url);
		try {
			PersonDAO dao = PersonDAO.getInstance();
			
			if(url.contentEquals("/inputform.msg")) {

				response.sendRedirect("inputForm.jsp");

			}else if(url.contentEquals("/inputproc.msg")) {
				
				String name = request.getParameter("p_name");
				String contact = request.getParameter("p_contact");
		
				int result = dao.insert(name, contact);
				request.setAttribute("result", result);
				
				RequestDispatcher rd = request.getRequestDispatcher("outputproc.msg");
				rd.forward(request, response);
				
			}else if(url.contentEquals("/outputproc.msg")) {
				List<PersonDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);
			}else if(url.contentEquals("/deleteproc.msg")) {
				
				int id = Integer.parseInt(request.getParameter("delid"));
				dao.delete(id);
				response.sendRedirect("deletelist.msg");
			}else if(url.contentEquals("/deletelist.msg")) {

				List<PersonDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("deleteForm.jsp").forward(request, response);

			}else if(url.contentEquals("/modifyproc.msg")) {

				int id = Integer.parseInt(request.getParameter("modiId"));
				String name = request.getParameter("modiName");
				String contact = request.getParameter("modiContact");
				dao.update(new PersonDTO(id, name, contact, null));			
				
				response.sendRedirect("modifylist.msg");

			}else if(url.contentEquals("/modifylist.msg")) {

				List<PersonDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("modifyForm.jsp").forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}

		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}