package elasticsearch.example.demo.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Component
@Slf4j
public class ESClient 
{
	@Value("${spring.elastic.host}")
	private String elasticHost;
	
	@Value("${spring.elastic.port}")
	private int elasticPort;
	
	@Value("${spring.elastic.http}")
	private String elasticHttpType;
	
	@Bean
	public RestHighLevelClient getRestHighClient() 
	{
		log.info("elastic host and port ========== {} - {} ", elasticHost, elasticPort);
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(new HttpHost(elasticHost, elasticPort, elasticHttpType)));
		
		return client;
	}
	
	public RestClient getLowLevelClient() {
		RestClient restClient = RestClient.builder(
			    new HttpHost(elasticHost, elasticPort, "http")).build();
		
		return restClient;
	}
}
