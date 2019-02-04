package spring.boot.gradle.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.MulticoreSolrClientFactory;
@Configuration
@EnableSolrRepositories(
  basePackages = "spring.boot.gradle.repository",
  namedQueriesLocation = "classpath:solr-named-queries.properties",
  multicoreSupport = true)
@ComponentScan
public class SolrConfig {

	private final String solrHost = "http://localhost:8983/solr";
	
	@Bean
	public MulticoreSolrClientFactory solrServerFactoryBean() {
       HttpSolrClient
               factory = new HttpSolrClient(solrHost);
       MulticoreSolrClientFactory multicoreSolrClientFactory = new MulticoreSolrClientFactory(factory);
       return multicoreSolrClientFactory;
    }

   @Bean
   public SolrTemplate solrTemplate() throws Exception {
       return new SolrTemplate(solrServerFactoryBean());
   }
	   
//    @Bean
//    public SolrClient solrClient() {
//        return new HttpSolrClient("");
//    }
// 
//    @Bean
//    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
//        return new SolrTemplate(client);
//    }
}
