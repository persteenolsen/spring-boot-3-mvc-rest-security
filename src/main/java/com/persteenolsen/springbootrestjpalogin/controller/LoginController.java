package com.persteenolsen.springbootrestjpalogin.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 
@Controller
public class LoginController
{
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
         @RequestParam(value = "logout", required = false) String logout, Model model) {

              String errorMessge = null;
                   if(error != null) {
                      errorMessge = "You entered a wrong username or password!";
                    }
                    if(logout != null) {
                       errorMessge = "You have been logged out successfully!";
                    }
                    model.addAttribute("errorMessge", errorMessge);
                    return "login";
                    }
                          
         @RequestMapping(value="/logout", method = RequestMethod.GET)
         public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
             Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                 if (auth != null){   
                     new SecurityContextLogoutHandler().logout(request, response, auth);
                 }
                 return "redirect:/login?logout=true";
             }
  }