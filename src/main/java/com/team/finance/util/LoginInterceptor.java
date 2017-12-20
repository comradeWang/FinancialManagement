package com.team.finance.util;

import com.team.finance.login.controller.loginController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录拦截器 , 判断用户登录状态，未登录跳转首页
 */
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 在controller执行之后的DispatcherServlet之后执行 Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		System.out.println("************IntegralInterceptor postHandle executed**********");
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handlerMethod) throws Exception {
		// TODO Auto-generated method stub
		
		// 获得在下面代码中要用的request,response,session对象
					HttpServletRequest servletRequest = (HttpServletRequest) request;
					HttpServletResponse servletResponse = (HttpServletResponse) response;
					if(!(handlerMethod instanceof HandlerMethod)){
						return true;
					}
					HandlerMethod servletHandlerMethod = (HandlerMethod) handlerMethod;
					HttpSession session = servletRequest.getSession();

					// 从session里登录Id
					Long empId=null;
					Map<String, Object> sessionUser = (Map<String, Object>) session.getAttribute("sessionUser");
					if(null!=sessionUser){
						empId = (Long)sessionUser.get("sessionUserLoginId");
					}


					Class<?> object=servletHandlerMethod.getBean().getClass();
					String methodName=servletHandlerMethod.getMethod().getName();
					
					if(object.equals(loginController.class)
					   || methodName.equals("userLogin") 
					   || methodName.equals("addUser")) 
					{
						return true;
			        }
					
					// 判断如果没有取到员工信息,就跳转到登陆页面
					if (empId == null || "".equals(empId)) {
			                //拦截controller, 取消Ajax 拦截
						    //ajax session 过期处理
			                //1:判断是否是ajax请求
			                if (servletRequest.getHeader("x-requested-with") != null
			                        && "XMLHttpRequest".equalsIgnoreCase(servletRequest.getHeader("x-requested-with"))) {
			                    //向http头添加 状态 sessionstatus
			                	servletResponse.setHeader("sessionstatus","timeout");
			                    //向http头添加登录的url
			                	servletResponse.addHeader("loginPath", "/EstablishSpace/");
			                	// 发送 HTTP 403 错误以触发前端 AJAX Error 事件。
			                	servletResponse.sendError(403);
			                    return false;
			                }
						// 跳转到登陆页面
						//servletResponse.sendRedirect(servletRequest.getContextPath()+"/view/login/login");
						//servletResponse.sendRedirect(servletRequest.getContextPath()+"/view/login/login");
//						request
//								.getRequestDispatcher("/WEB-INF/view_core/view_page/production/login/login.jsp")
//								.forward(request, response);
						// 如果是浏览器常规请求，则直接跳转。
						servletResponse.sendRedirect(servletRequest.getContextPath() + "/");
						return false;
					} 
		return true;
	}



}
