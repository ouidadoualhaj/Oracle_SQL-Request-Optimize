package org.fstt.oracle.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fstt.oracle.dao.RequestRepository;
import org.fstt.oracle.entitie.Request;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Controller
public class RequestController {

	@Autowired
	private RequestRepository requestRepository;
	

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	    //afficher toutes les requtes avec leurs plans d'execution
		@GetMapping("/requests")
		public String getRequests(Model model) {
		    List<Map<String, Object>> results = jdbcTemplate.queryForList(" SELECT id_request,content, EXPLAIN(content) as plan_execution FROM request");
		    model.addAttribute("requests", results);
		    return "requests";
		}
		
		//afficher planExecution de la requete selon son id
		@GetMapping("/planExecution/{id}")
		public String getRequestPlan(@PathVariable("id_request") int id, Model model) {
		    List<Map<String, Object>> results = jdbcTemplate.queryForList("SHOW EXPLAIN FOR (SELECT content FROM request WHERE id_request = ?)", id);
		    model.addAttribute("plan", results);
		    return "planExecution";
		}
			
		
	    //ajouter une requete
		@GetMapping(path = "/request/new")
		private String createRequestForm(Model model) {
			Request request=new Request();
			model.addAttribute("request",request);
			return "CreateRequest";
		}
		
		@PostMapping(path="/request/create")
		private String createRequest(@ModelAttribute("request")Request r) {
			requestRepository.save(r);
			return "redirect:/planExecution";
		}
		

		//supprimer un requete
		@GetMapping(path = "/deleteRequest")
		private String delete(int id, String motCle, String page, String size) {
			requestRepository.deleteById(id);
				return "redirect:/requests?page=" + page + "&motCle=" + motCle + "&size=" + size;
		}
		
		
		//modifier une Requete
		@GetMapping("/requests/edit/{id}")
		public String editRequestForm(@PathVariable int id, Model model) {
			model.addAttribute("request", requestRepository.findById(id).get());
			return "update_request";
		}

		@PostMapping("/requests/{id}")
		public String updateRequest(@PathVariable int id,@ModelAttribute("request") Request request,Model model) {
			
			// get request from database by id
			Request existingRequest = requestRepository.findById(id).get();
			existingRequest.setId_request(id);
			existingRequest.setContent(request.getContent());

			// save updated request object
			requestRepository.save(existingRequest);
			return "redirect:/requests";		
		}
}