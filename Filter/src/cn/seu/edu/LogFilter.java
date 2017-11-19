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
		// ��ȡservletcontext���󣬼�¼��־
		ServletContext context = this.config.getServletContext();
		long before = System.currentTimeMillis();
		context.log("��ʼ����");
		System.out.println("begore the log filter!");
		// ת����HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		// ��¼��־
		System.out.println("log filter �Լ������û�����ĵ�ַ" + req.getServletPath());
		context.log("log filter �Լ������û�����ĵ�ַ" + req.getServletPath());
		try {
			// filterֻ������ʽ����ʵ��������Ȼת����Ŀ�ĵ�ַ
			chain.doFilter(request, resposne);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after the log filter");
		long after = System.currentTimeMillis();
		context.log("���˽���");
		context.log(" ����λ�� " + req.getRequestURI() + " ���ƺ�ʱ " + (after - before));
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("begin do the log filter");
		this.config = config;
	}
	
	
}
