package com.ga.doctorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.DoctorDao;
import com.ga.doctorapp.model.Doctor;

@Controller
public class DoctorController {
	

	//CRUD OPERATIONS
	// C -> Create = done
	// R -> Select = done
	// U -> Update = done
	// D -> Delete =  done
	
	@Autowired 
	private Environment env;
	
	// HTTP GET REQUEST - Doctor Add
	@GetMapping("/doctor/add")
	public ModelAndView addDoctor() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/add");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	@Autowired
	private DoctorDao dao;
	
	// HTTP POST REQUEST - Doctor Add
	@PostMapping("/doctor/add")
	public String addDoctor(Doctor doctor) {
		dao.save(doctor);
		
		return "redirect:/doctor/index";
	}
	
	// HTTP GET REQUEST - Doctor Index
	@GetMapping("/doctor/index")
	public ModelAndView getDoctor() {
		var it = dao.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/index");
		mv.addObject("doctors", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Doctor Detail
	@GetMapping("/doctor/detail")
	public ModelAndView doctorDetails(@RequestParam int id) {
		System.out.println(id);
		
		Doctor doctor = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/detail");
		mv.addObject("doctor", doctor);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
		
	}
	
	// HTTP GET REQUEST - Doctor Edit
	@GetMapping("/doctor/edit")
	public ModelAndView editDoctor(@RequestParam int id) {
		Doctor doctor = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/edit");
		mv.addObject("doctor", doctor);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Doctor Delete
	@GetMapping("/doctor/delete")
	public String deleteDoctor(@RequestParam int id) {
		dao.deleteById(id);
		return "redirect:/doctor/index";
	}
	
	
}