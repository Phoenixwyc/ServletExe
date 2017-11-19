package cn.seu.edu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Init extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		System.out.println("Count - destroy invoked");
		// 将数据写回
		String nums = (String) this.getServletContext().getAttribute("nums").toString();
		System.out.println("Count - Init invoked" + nums);
		String path = this.getServletContext().getRealPath("record.txt");
		FileWriter file = null;
		BufferedWriter writer = null;
		
		try {
			file = new FileWriter(path);
			writer = new BufferedWriter(file);
			writer.write(nums);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				file.close();
			} catch (IOException e) {
				
			}
		}
	}

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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		// 读取reord.txt中的访问量记录
		System.out.println("Count-init invoked");
		String path = this.getServletContext().getRealPath("record.txt");
		FileReader file = null;
		BufferedReader reader = null;
		try {
			file = new FileReader(path);
			reader = new BufferedReader(file);
			int nums = Integer.parseInt(reader.readLine());
			System.out.println(nums);
			this.getServletContext().setAttribute("nums", nums);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				file.close();
			} catch (IOException e) {
				
			}
		}
		
	}

}
