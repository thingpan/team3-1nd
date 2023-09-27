package com.game.team1.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.game.team1.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;


@WebFilter(value ={"/","/tmpl/**"})
@Slf4j
@Component

public class AuthFilter extends GenericFilterBean {

	private List<String> execludeUrls =new ArrayList<>();
	{
		execludeUrls.add("/tmpl/user-info/login");
        execludeUrls.add("/tmpl/user-info/insert");
		execludeUrls.add("/");
        execludeUrls.add("/login");
        execludeUrls.add("/insert");
		execludeUrls.add("/user-infos"); 
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(request instanceof HttpServletRequest req && response instanceof HttpServletResponse res) {
			String uri =req.getRequestURI();
			if(!execludeUrls.contains(uri)) {
				HttpSession session =req.getSession();
				UserInfoVO user=(UserInfoVO) session.getAttribute("user");
				if(user==null) {
					res.sendRedirect("/tmpl/user-info/login");
					return;
				}
			}
		}
        chain.doFilter(request, response);
	}

}
