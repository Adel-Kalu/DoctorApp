package com.ga.doctorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.AppointmentDao;
import com.ga.doctorapp.dao.DoctorDao;
import com.ga.doctorapp.model.Appointment;

@Controller
public class AppointmentController {
	

	//CRUD OPERATIONS
	// C -> Create = Done
	// R -> Select = Done
	// U -> Update = Done
	// D -> Delete = Done
	
	@Autowired 
	private Environment env;
	
	@Autowired
	private DoctorDao doctordao;
	
	// HTTP GET REQUEST - Appointment Add
	@GetMapping("/appointment/add")
	public ModelAndView addAppointment() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/add");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		var it = doctordao.findAll();
		mv.addObject("doctors", it);
		
		return mv;
	}
	
	@Autowired
	private AppointmentDao dao;
	
	// HTTP POST REQUEST - Appointment Add
	@PostMapping("/appointment/add")
	public String addAppointment(Appointment appointment) {
		dao.save(appointment);
		
		return "redirect:/appointment/index";
	}
	
	// HTTP GET REQUEST - Appointment Index
	@GetMapping("/appointment/index")
	public ModelAndView getAppointment() {
		var it = dao.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/index");
		mv.addObject("appointments", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Appointment Detail
	@GetMapping("/appointment/detail")
	public ModelAndView appointmentDetails(@RequestParam int id) {
		System.out.println(id);
		
		Appointment appointment = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/detail");
		mv.addObject("appointment", appointment);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
		
	}
	
	// HTTP GET REQUEST - Appointment Edit
	@GetMapping("/appointment/edit")
	public ModelAndView editAppointment(@RequestParam int id) {
		Appointment appointment = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/edit");
		mv.addObject("appointment", appointment);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		var it = doctordao.findAll();
		mv.addObject("doctors", it);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Appointment Delete
	@GetMapping("/appointment/delete")
	public String deleteAppointment(@RequestParam int id) {
		dao.deleteById(id);
		return "redirect:/appointment/index";
	}
	
	
}