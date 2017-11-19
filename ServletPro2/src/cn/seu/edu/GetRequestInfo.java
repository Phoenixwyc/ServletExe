package cn.seu.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetRequestInfo extends HttpServlet {

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
		out.println("HttpServletRequest:<br/>");
		String authType = request.getAuthType();
		out.print("authType : " + authType + "<br/>");
		String contextPath = request.getContentType();
		out.print("contextPath : " + contextPath + "<br/>");
		String method = request.getMethod();
		out.print("method : " + method + "<br/>");
		String pathInfo = request.getPathInfo();
		out.print("pathInfo : " + pathInfo + "<br/>");
		String pathTranslated = request.getPathTranslated();
		out.print("pathTranslated : " + pathTranslated + "<br/>");
		String queryString = request.getQueryString();
		out.print("queryString : " + queryString + "<br/>");
		String remoteUser = request.getRemoteUser();
		out.print("remoteUser : " + remoteUser + "<br/>");
		String requestSessionId = request.getRequestedSessionId();
		out.print("requestSessionId : " + requestSessionId + "<br/>");
		String requestURI = request.getRequestURI();
		out.print("requestURI : " + requestURI + "<br/>");
		String requestURL = request.getRequestURL().toString();
		out.print("requestURL : " + requestURL + "<br/>");
		String servletPath = request.getServletPath();
		out.print("servletPath : " + servletPath + "<br/>");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String header = request.getHeader(headerName);
			out.println("Enumeration -"+ headerName + " : " + header + "<br/>");
		}
		out.println("ServletRequest");
		
		
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
