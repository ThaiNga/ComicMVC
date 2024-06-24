package org.o7planning.comicmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.comicmvc.bean.TheLoaiBean;
import org.o7planning.comicmvc.bean.TruyenBean;
import org.o7planning.comicmvc.bo.TheLoaiBo;
import org.o7planning.comicmvc.bo.TruyenBo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public ModelAndView Home(Model model, HttpServletRequest request, HttpServletResponse response){
		try {
	
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ModelAndView("helloworld");
	}
    
    @RequestMapping(value = "/comment")
	public @ResponseBody ResponseEntity<Object> userComment(
			@RequestBody String commentContent) {
		try {			
			return new ResponseEntity<Object>(commentContent, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Error", HttpStatus.BAD_REQUEST);
		}
	}
}
