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
		out.println("�û�����<input type='text' name='username'/></br>");
		out.println("�ܡ��룺<input type='password' name='password'/></br>");
		out.println("�Ա�:<input type='radio' name='sex' value='��'/>��<input type='radio' name='sex' value='Ů'/>Ů<br/>");
		out.println("�Ա�:<input type='checkbox' name='hobby' value='����'>����<input type='checkbox' name='hobby' value='����'>����</checkbox><br/>");
		out.println("���ڳ���<select name='city'><option value='����'>����</option><option value='�Ͼ�'>�Ͼ�</option></select><br/>");
		out.println("��Ľ���<textarea cols='20' rows='15' name='intro'>�������</textarea><br/>");
		out.println("�ύ��Ƭ<input type='file' name='photo'/>");
		out.println("<input type='submit' value='ȷ��'/></br>");
		//hidden��1����ϣ���û��������ݣ�2����ϣ��Ӱ����棬ͬʱҵ���߼���Ҫ������
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
