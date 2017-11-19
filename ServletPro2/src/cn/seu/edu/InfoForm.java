package cn.seu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoForm extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<form action='/ServletPro2/Regester' method=post>");
		out.println("用户名：<input type='text' name='username'/></br>");
		out.println("密　码：<input type='password' name='password'/></br>");
		out.println("性别:<input type='radio' name='sex' value='男'/>男<input type='radio' name='sex' value='女'/>女<br/>");
		out.println("性别:<input type='checkbox' name='hobby' value='音乐'>音乐<input type='checkbox' name='hobby' value='旅游'>旅游</checkbox><br/>");
		out.println("所在城市<select name='city'><option value='北京'>北京</option><option value='南京'>南京</option></select><br/>");
		out.println("你的介绍<textarea cols='20' rows='15' name='intro'>输入介绍</textarea><br/>");
		out.println("提交照片<input type='file' name='photo'/>");
		out.println("<input type='submit' value='确认'/></br>");
		//hidden，1、不希望用户看到数据；2、不希望影响界面，同时业务逻辑需要的数据
		out.println("<input type='hidden' value='aaa' name='hiden1'/>");
		out.println("</form>");
		
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
