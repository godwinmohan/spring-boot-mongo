package springbootmongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {

	@Value("${spring.data.mongodb.database}")
    private String database;

	@Value("${spring.data.mongodb.host}")
	private String host;

	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(host), database);
	}

	public @Bean MongoTemplate mongoTemplate() throws Exception {

		MappingMongoConverter converter = new MappingMongoConverter
				(new DefaultDbRefResolver(mongoDbFactory()),
				new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));

		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

		return mongoTemplate;

	}
}
