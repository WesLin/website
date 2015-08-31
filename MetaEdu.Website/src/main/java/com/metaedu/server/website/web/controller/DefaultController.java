package com.metaedu.server.website.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.metaweb.InstitutionSummary;
import com.metaedu.server.business.metaweb.UserSummary;
import com.metaedu.server.business.user.User;
import com.metaedu.server.website.web.form.LoginInfo;
import com.metaedu.server.website.web.manager.CacheManager;


/** 首页 Controller
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.14
 */
@Controller
public class DefaultController {

	/** 测试输出
	 * @return
	 */
	@RequestMapping("/default")
	public ModelAndView defalult(HttpServletRequest request) {
		ModelAndView curModel = new ModelAndView("default");
		return curModel;
	}
	
	/** 用户登录
	 * @param refInfo
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(LoginInfo refInfo, HttpServletRequest request, HttpSession session) {
		ModelAndView curRtn = new ModelAndView("result");
		User curUser = DataFactory.getUserData().getUserByLoginInfo(false, refInfo.getInstitutionId(), refInfo.getAccount(), refInfo.getPassword());
		if (curUser != null) {
			// 设置 session 值
			UserSummary curUS = DataFactory.getMetaWebData().getUserSummary(refInfo.getInstitutionId(), refInfo.getAccount());
			session.setAttribute("summary", curUS); // 写入摘要信息
			curRtn.addObject("result", "true");
		} else {
			curRtn.addObject("result", "false");
		}
		return curRtn;
	}
	
	/** 获取简称相关机构摘要集合
	 * @param refName
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/institutionInfos")
	public ModelAndView institutionInfos(@RequestParam("institutionName") String refName, HttpServletRequest request) {
		ModelAndView curRtn = new ModelAndView("result");
		List<InstitutionSummary> curSums = CacheManager.getInstance().getInstitutionSummary("%" + refName + "%");
		if (curSums.size() == 0) { // 如果是无效数据
			curRtn.addObject("result", "[]"); // 返回空集合
		} else {
			Gson curGson = new Gson();
			curRtn.addObject("result", curGson.toJson(curSums));
		}
		return curRtn;
	}
	
	
	
	
	
}
