package spring.boot.gradle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.boot.gradle.service.SolrService;

@RestController
public class SpringController {
	
	@Autowired
	private SolrService solrService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String firstController() {
		return "welcome to gradle controller";
	}
	
	@RequestMapping(value = "/solr/find/{name}", method = RequestMethod.GET)
	public Object findByName(@PathVariable(name = "name", required = true) String name) {
		System.out.println("finding by name : " + name + " in solr");
		return solrService.solrGetByName(name);
	}
	
	@RequestMapping(value = "/solr/find/pageable/{name}", method = RequestMethod.GET)
	public Object findByCustomName(@PathVariable(name = "name", required = true) String name) {
		System.out.println("finding by name : " + name + " in solr with pageable");
		return solrService.findByCustomName(name);
	}
	
	@RequestMapping(value = "/solr/insert", method = RequestMethod.GET)
	public String solrInsert() {
		solrService.solrInsert();
		return "saved successfully";
	}
	
	@RequestMapping(value = "/solr/search/{id}/{name}", method = RequestMethod.GET)
	public String solrSearchByCriteria(@PathVariable(name = "id", required = true) String id,
			@PathVariable(name = "name", required = true) String name) {
		solrService.getSolrDataByCriteria(id, name);
		return "saved successfully";
	}	
}
