package cn.seu.edu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateCode extends HttpServlet {

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
	
		// 禁止缓存随机图片
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cace");
		response.setHeader("Pragma", "no-cache");
		
		// 通知客户机发送的文件类型是图片
		response.setHeader("Content-Type", "imag/jpeg");
		
		// 在内存中创建图片
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		
		// 向图片中写数据
		Graphics g = image.getGraphics();
		
		// 设置背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 30);
		
		// 设置数据颜色和字体
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.BOLD, 20));
		
		// 向图片写数据
		String num = makeNum();
		// 将随机生成的验证码保存到session
		request.getSession().setAttribute("checkcode", num);
		g.drawString(num, 0, 20);
		
		// 将图片发送给浏览器
		ImageIO.write(image, "jpg", response.getOutputStream());
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
	
	private String makeNum() {
		Random r = new Random();
		String num = r.nextInt(9999) + "";
		StringBuffer sb = new StringBuffer();
		// 位数不够用0填充
		for (int i = 0; i < 4 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
	}

}
