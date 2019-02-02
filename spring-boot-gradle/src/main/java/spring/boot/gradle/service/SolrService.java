package spring.boot.gradle.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetQuery;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.stereotype.Service;

import spring.boot.gradle.model.Company;
import spring.boot.gradle.repository.SolrRepository;

@Service
public class SolrService {
	
	@Autowired
	private SolrTemplate solrTemplate;
	
	@Autowired
	private SolrRepository solrRepository;
	
	public void solrInsert() {
		List<Company> list = new ArrayList<Company>();
		for(Long i=0L;i<5;i++) {
			Company cmp = new Company();
			cmp.setId(i.toString());
			cmp.setName("Radhe-krsna"+i);
			list.add(cmp);
		}
		solrRepository.save(list);
		System.out.println("Solr data saved successfully...!!!");
	}
	
	public Object solrGetByName(String name) {
		return solrRepository.findByName(name);
	}

	public Object findByCustomName(String name) {
		return solrRepository.findByNamedQuery(name, new PageRequest(0, 10));
	}
	
	public Object getSolrDataByCriteria(String id, String name) {
//		System.out.println("Criteria query id: "+ id+ " name: "+ name);
//		
		return solrTemplate.queryForPage(new SimpleQuery(new SimpleStringCriteria("name:" + name)).setPageRequest(new PageRequest(0, 10)),
				Company.class);
//		
		
//		Criteria conditions = Criteria.where("name").is(name);
//		Criteria conditions =new Criteria();
//		if(name != null) 
//			conditions = (conditions == null) ? new Criteria("name").is(name) : conditions.or(new Criteria("name").is(name));
			
//		Query query = new SimpleQuery(conditions);
//		System.out.println("QUERY BEFORE=>>> "+query.getRequestHandler());
//		FacetQuery search = new SimpleFacetQuery(new Criteria("name").is(name), new PageRequest(0, 10));
//		Query search = new SimpleQuery(new Criteria("name").is(name));
//		search.setPageRequest(new PageRequest(0, 10));
//		System.out.println("QUERY:=>  "+search.getCriteria()+" >>>" +search.ge);
//		Page<Company> resultPage = solrTemplate.query(search, Company.class);
//		return solrTemplate.queryForPage(search, Company.class);
//		return resultPage;
//		return null;
	}
}
