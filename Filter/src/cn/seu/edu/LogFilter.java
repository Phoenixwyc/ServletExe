package cn.seu.edu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{

	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resposne,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 获取servletcontext对象，记录日志
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		context.log("开始过滤");
		System.out.println("begore the log filter!");
		// 转换成HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// 记录日志
		System.out.println("log filter 以及拦截用户请求的地址" + req.getServletPath());
		context.log("log filter 以及拦截用户请求的地址" + req.getServletPath());
		try {
			// filter只负责链式处理，实际请求依然转发到目的地址
			chain.doFilter(request, resposne);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after the log filter");
		long after = System.currentTimeMillis();
		context.log("过滤结束");
		context.log(" 请求定位到 " + req.getRequestURI() + " 共计耗时 " + (after - before));
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("begin do the log filter");
		this.config = config;
	}
	
	
}
