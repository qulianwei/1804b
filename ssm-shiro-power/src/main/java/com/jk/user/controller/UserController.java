package com.jk.user.controller;



import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.security.jacc.WebUserDataPermission;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.jk.role.model.UserRole;
import com.jk.user.model.User;
import com.jk.user.service.IUserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	//明白了getLogger(class)的参数用途:追踪产生此日志的类.
	private static final Logger logger=Logger.getLogger(UserController.class);
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request,Model model){
		logger.info("======用户进入了UserController的/login.html");
		String msg;
		//最常见的用户名/密码的认证机制;同时,由于它实现了RememberMeAuthenticationToken接口，我们可以通过令牌设置“记住我”的功能
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getPassword());
		token.setRememberMe(true);
		//获取subjec对象
		Subject subject=SecurityUtils.getSubject();
		
		try {
			//  使用用户令牌登录
			subject.login(token);
			// 使用验证方法 验证是否登录
			if (subject.isAuthenticated()) {
				request.getSession().setAttribute("user", user);
				SavedRequest savedRequest = WebUtils.getSavedRequest(request);
				// 获取保存的URL
				if (savedRequest==null || savedRequest.getRequestUrl()==null) {
					return "view/mainPage";
				}else{
					return "forword:"+savedRequest.getRequestUrl();
				}
			}else{
				return "index";
			}
		//错误的凭证
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误";
            model.addAttribute("message", msg);
            System.out.println(msg);
        //登录失败次数过多
		}catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
            model.addAttribute("message", msg);
            System.out.println(msg);
		}catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("message", msg);
            System.out.println(msg);
		}catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("message", msg);
            System.out.println(msg);
		}catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("message", msg);
            System.out.println(msg);
		}catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            model.addAttribute("message", msg);
            System.out.println(msg);
		}catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            model.addAttribute("message", msg);
            System.out.println(msg);
		}
		
		
		return "index";
	}
	
	@RequestMapping(value="queryUserList")
	@ResponseBody
	public List<User> queryUserList(HttpServletRequest request){
		User loginUser = (User) request.getSession().getAttribute("user");
		List<User> map=userService.queryUserList(loginUser.getUserName());
		return map;
	}
	
	//跳转路径并把用户id和用户所拥有的角色带回去
	@RequestMapping("toRolePage")
	public String toRolePage(String userId,ModelMap model){
		model.addAttribute("userId", userId);
		List<UserRole> list=userService.queryRoleByUserId(userId);
		Object userRole = JSONArray.toJSON(list);
		model.addAttribute("userRole", userRole);
		return "view/rolePage";
	}
	
	//通过用户id查树
	@RequestMapping("findTree")
	@ResponseBody
	public List<LinkedHashMap<String,Object>> findTree(String userName){
		List<LinkedHashMap<String,Object>> list= userService.findTree(userName);
		return list;
	}
	
	@RequestMapping("toMain")
	public String toMain(){
		return "view/main";
	}

}
