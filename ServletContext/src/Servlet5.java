import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet5 extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		// ��ȡ�ļ���ע�����·����webĿ¼�µ��ļ�
		InputStream stream = this.getServletContext().getResourceAsStream("dninfo.properties");
		// ����properties����
		Properties properties = new Properties();
		// �����ļ�
		properties.load(stream);
		
		out.println("name: " + properties.getProperty("username") + "<br/>");
		out.println("password: " + properties.getProperty("password") + "<br/>");
		String path = this.getServletContext().getRealPath("dninfo.properties");
		out.println("�ļ�����·���� " + path + "<br/>");
		
		// ������ҵ���SRCĿ¼�µ��ļ�����Ҫʹ���������
		ClassLoader loader = Servlet5.class.getClassLoader();
		InputStream src_stream = loader.getResourceAsStream("dninfo_src.properties");
		Properties pp = new Properties();
		pp.load(src_stream);
		out.println("name_src: " + pp.getProperty("username") + "<br/>");
		out.println("password_src: " + pp.getProperty("password") + "<br/>");
		File file = new File("dninfo.properties");
		out.println("SRC�ļ�����·���� " + file.getAbsolutePath() + "<br/>");
		
		
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
