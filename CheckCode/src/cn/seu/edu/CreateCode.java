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
	
		// ��ֹ�������ͼƬ
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cace");
		response.setHeader("Pragma", "no-cache");
		
		// ֪ͨ�ͻ������͵��ļ�������ͼƬ
		response.setHeader("Content-Type", "imag/jpeg");
		
		// ���ڴ��д���ͼƬ
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		
		// ��ͼƬ��д����
		Graphics g = image.getGraphics();
		
		// ���ñ���ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 30);
		
		// ����������ɫ������
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.BOLD, 20));
		
		// ��ͼƬд����
		String num = makeNum();
		// ��������ɵ���֤�뱣�浽session
		request.getSession().setAttribute("checkcode", num);
		g.drawString(num, 0, 20);
		
		// ��ͼƬ���͸������
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
		// λ��������0���
		for (int i = 0; i < 4 - num.length(); i++) {
			sb.append("0");
		}
		num = sb.toString() + num;
		return num;
	}

}
