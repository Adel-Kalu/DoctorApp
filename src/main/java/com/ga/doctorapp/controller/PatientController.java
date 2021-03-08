package com.ga.doctorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.PatientDao;
import com.ga.doctorapp.dao.DoctorDao;
import com.ga.doctorapp.model.Patient;

@Controller
public class PatientController {
	

	//CRUD OPERATIONS
	// C -> Create = Done
	// R -> Select = Done
	// U -> Update = Done
	// D -> Delete = Done
	
	@Autowired 
	private Environment env;
	
	@Autowired
	private DoctorDao doctordao;
	
	// HTTP GET REQUEST - Patient Add
	@GetMapping("/patient/add")
	public ModelAndView addPatient() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/add");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		var it = doctordao.findAll();
		mv.addObject("doctors", it);
		
		return mv;
	}
	
	@Autowired
	private PatientDao dao;
	
	// HTTP POST REQUEST - Patient Add
	@PostMapping("/patient/add")
	public String addPatient(Patient patient) {
		dao.save(patient);
		
		return "redirect:/patient/index";
	}
	
	// HTTP GET REQUEST - Patient Index
	@GetMapping("/patient/index")
	public ModelAndView getPatient() {
		var it = dao.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/index");
		mv.addObject("patients", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Patient Detail
	@GetMapping("/patient/detail")
	public ModelAndView patientDetails(@RequestParam int id) {
		System.out.println(id);
		
		Patient patient = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/detail");
		mv.addObject("patient", patient);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
		
	}
	
	// HTTP GET REQUEST - Patient Edit
	@GetMapping("/patient/edit")
	public ModelAndView editPatient(@RequestParam int id) {
		Patient patient = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("patient/edit");
		mv.addObject("patient", patient);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		var it = doctordao.findAll();
		mv.addObject("doctors", it);
		
		return mv;
	}
	
	// HTTP GET REQUEST - Patient Delete
	@GetMapping("/patient/delete")
	public String deletePatient(@RequestParam int id) {
		dao.deleteById(id);
		return "redirect:/patient/index";
	}
	
	
}