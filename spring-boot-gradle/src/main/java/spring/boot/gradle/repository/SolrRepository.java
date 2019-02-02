package spring.boot.gradle.repository;

import java.util.List;

import spring.boot.gradle.model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolrRepository  extends SolrCrudRepository<Company, String> {
 
    public List<Company> findByName(String name);
 
    @Query("id:*?0* OR name:*?0*")
    public Page<Company> findByCustomQuery(String searchTerm, Pageable pageable);
 
    @Query(name = "Company.findByNamedQuery")
    public Page<Company> findByNamedQuery(String searchTerm, Pageable pageable);
 
}