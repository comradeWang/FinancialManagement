package com.team.finance.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet Filter implementation class LoginFilter
 */

@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			// 获得在下面代码中要用的request,response,session对象
			HttpServletRequest servletRequest = (HttpServletRequest) request;
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			HttpSession session = servletRequest.getSession();

			// 获得用户请求的URI
			String path = servletRequest.getRequestURI();
			//System.out.println(path);
			
			
			// 从session里登录Id
			Long empId=null;
			Map<String, Object> sessionUser = (Map<String, Object>) session.getAttribute("sessionUser");
			if(null!=sessionUser){
				empId = (Long)sessionUser.get("sessionUserLoginId");
			}
			
			
			/*创建类Constants.java，里面写的是无需过滤的页面
			for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
			
				if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
					chain.doFilter(servletRequest, servletResponse);
					return;
				}
			}*/
			   
			// 登陆页面无需过滤
			if(path.endsWith("/EstablishSpace/") || path.endsWith("userLogin") || path.indexOf("/common") > 0 || path.indexOf(".js") > 0 
					|| path.endsWith("addUser") || path.endsWith("view/login/register")) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
			
			// 判断如果没有取到员工信息,就跳转到登陆页面
			if (empId == null || "".equals(empId)) {
	                //ajax session 过期处理
	                //1:判断是否是ajax请求
	                if (servletRequest.getHeader("x-requested-with") != null 
	                        && "XMLHttpRequest".equalsIgnoreCase(servletRequest.getHeader("x-requested-with"))) {   
	                    //向http头添加 状态 sessionstatus
	                	servletResponse.setHeader("sessionstatus","timeout");
	                	servletResponse.setStatus(403);
	                    //向http头添加登录的url
	                	servletResponse.addHeader("loginPath", "/EstablishSpace/");
	                   
	                    return ;
	                }
				// 跳转到登陆页面
				servletResponse.sendRedirect("/EstablishSpace/");
			} else {
				// 已经登陆,继续此次请求
				chain.doFilter(request, response);
			}
}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
