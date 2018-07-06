package com.niit.grocerystore.Frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.grocerystore.Dao.UserDao;
import com.niit.grocerystore.model.User;

@Controller
public class LoginController {
	
	@Autowired
	User user;
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false)String error,
			@RequestParam(value="logout",required=false)String logout,Model model) {
		if(error!=null)
			model.addAttribute("error","invalid User name or password");
		
		if(logout!=null)
			model.addAttribute("logout","login successfull");
		return "login";
	}
	
    @RequestMapping(value="/j_spring_security_check")
    public String processRegistration(@RequestParam("j_username")String umail,@RequestParam("j_password") String upwd,
    		Model model,HttpSession session)
    {
    	System.out.println("djhsk");
    	User u=userDao.isvalid(umail,upwd);
        	if(u==null)
    	    {
    	      System.out.println("dsaddda");
    	      model.addAttribute("msg", "Invalid username and password");
    	      return "redirect:/";
            }
           else
            {
    	     session.setAttribute("user",u);
    	     session.setAttribute("name",u.getUserName());
    	     session.setAttribute("items",u.getCart().getCtTotalitem());
           	return "redirect:/";
            }
    }
    @RequestMapping(value="/j_spring_security_logout")
    public String logout(HttpServletRequest request,HttpSession session,Model model)
    {
    	session.invalidate();
    	session=request.getSession(true);
    	model.addAttribute("logout","logout successfull");
    	return "redirect:/";
    }
}
