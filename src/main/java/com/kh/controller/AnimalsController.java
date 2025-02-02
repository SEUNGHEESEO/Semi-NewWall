package com.kh.controller;

import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.Dto.lostAnimal.LostAnimalDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("*.lost")
public class AnimalsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}
	
	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String url = requestURI.substring(ctxPath.length());
		System.out.println(requestURI);
		System.out.println(ctxPath);
		System.out.println(url);
		try {
			
			if(url.equals("/lostAnimal.lost")) {
				String directory = request.getServletContext().getRealPath("/upload");
				int maxSize = 1024*1024*100;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String encoding = "UTF-8";
				try {
					MultipartRequest multi =
							new MultipartRequest(request, directory, maxSize, encoding,
									new DefaultFileRenamePolicy());
					String lostName = multi.getParameter("lostName");
					int lostAge = Integer.parseInt(multi.getParameter("lostAge"));
					String lostKind = multi.getParameter("lostKind");
					String lostGender = multi.getParameter("lostGender");
					String lostDate = multi.getParameter("lostDate");
					String lostContent = multi.getParameter("lostContent");
					String lostAddr = multi.getParameter("addResult");
					String lostCategory = multi.getParameter("lostCategory");
					System.out.println(lostAddr);
					System.out.println(lostGender);
					System.out.println(lostDate);
					System.out.println(lostCategory);
					Enumeration files = multi.getFileNames();
					String str = (String)files.nextElement();
					String lostFileRealName = multi.getFilesystemName(str); //실제에 서버에 업로드가된 네임
					System.out.println(lostFileRealName);
					LostAnimalDto dto = new LostAnimalDto();
					dto.setLostName(lostName);
					dto.setLostAge(lostAge);
					dto.setLostKind(lostKind);
					dto.setLostGender(lostGender);
					dto.setLostDate(lostDate);
					dto.setLostContent(lostContent);
					dto.setLostCategory(lostCategory);
					dto.setLostAddr(lostAddr);
					dto.setFileRealName(lostFileRealName);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
