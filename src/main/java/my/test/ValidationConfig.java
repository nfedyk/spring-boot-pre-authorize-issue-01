package my.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ValidationConfig extends RepositoryRestConfigurerAdapter {
	
	@Autowired
    private TestRecordRepository testRecordRepository;  
	
	@Bean
	public TestRecordValidator testRecordValidator() {
		return new TestRecordValidator(testRecordRepository);
	}
	
    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
    	
    	TestRecordValidator testRecordValidatorLocal = testRecordValidator();
    	
    	validatingListener.addValidator("beforeCreate", testRecordValidatorLocal);
    	validatingListener.addValidator("beforeSave", testRecordValidatorLocal);
    }
	
}