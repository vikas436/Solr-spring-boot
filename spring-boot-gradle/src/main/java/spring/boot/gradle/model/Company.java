package spring.boot.gradle.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "company")
public class Company {
    
    @Id
    @Field("id")
    @Indexed(name = "id", type = "string")
    private String id;
 
    @Field("name")
    @Indexed(name = "name", type = "string")
    private String name;
 
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
