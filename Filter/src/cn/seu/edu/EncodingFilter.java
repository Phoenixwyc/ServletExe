package cn.seu.edu;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encoding;
	private Map<String, String> params = new HashMap<String, String>();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("end do the endoding fileter");
		params = null;
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("before encoding " + encoding + " filter!");
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);
		chain.doFilter(request, response);
		System.out.println("after encoding " + encoding + " filter!");
		System.out.println("---------------------------------------");
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("begin do the encoding filter");
		encoding = config.getInitParameter("encoding");
		for (Enumeration<String> e = config.getInitParameterNames(); e.hasMoreElements();) {
			String key = (String) e.nextElement();
			String value = config.getInitParameter(key);
			params.put(key, value);
		}
	}
	
}
