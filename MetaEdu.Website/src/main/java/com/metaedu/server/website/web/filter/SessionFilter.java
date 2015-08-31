package com.metaedu.server.website.web.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

/** Session 登录过滤器
 * @author Sam
 * @version 1.0
 * @since 2015.07.13
 */
public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String[] notFilter = new String[] {
			"/test", // 所有的测试页
			"/import", // 所有的导入操作页（暂时）
			"/login.htm", // 登录验证
			"/institutionInfos.htm", // 机构摘要信息
			"/complex/uploadfile.htm", // 客户端上传课堂用文件
			"/complex/filefoxcallback.htm", // 文件管理服务回调
			"/lesson/record", // 所有的录像相关页（暂时）
			"/lesson/test", // 课堂压力测试页（暂时）
			"/default.htm" // 首页
		};
		String uri = request.getRequestURI();
		//System.out.println(request.getRequestURI());
		boolean doFilter = true;
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				doFilter = false; // 如果是不过滤的 URI，则不进行过滤
				break;
			}
		}
		if (doFilter) { // 如果需要执行过滤
			Object summary = request.getSession().getAttribute("summary");
			if (summary == null) { // 如果没有登录信息
				response.sendRedirect("/#nologin"); // 重定向到首页
			} else { // 如果有登录信息
				filterChain.doFilter(request, response);
			}
		} else filterChain.doFilter(request, response); // 无需过滤则直接放行
		
	}

}
