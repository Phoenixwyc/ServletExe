package cn.seu.edu.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet3 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		response.setHeader("Content-Disposition", "attachment;filename=spring-framework-4.0.1.RELEASE.zip");
		// 打开文件
		String path = this.getServletContext().getRealPath("spring-framework-4.0.1.RELEASE.zip");
		// 创建文件输入流
		FileInputStream fis = new FileInputStream(path);
		// 缓冲数组
		byte[] buffer = new byte[1024];
		int len = 0;
		OutputStream os = response.getOutputStream();
		//循环读取
		while((len = fis.read(buffer)) > 0) {
			os.write(buffer, 0, len);
		}
		os.close();
		fis.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
