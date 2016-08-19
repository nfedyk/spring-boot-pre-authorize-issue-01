package my.test;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TestRecordValidator implements Validator {

	private TestRecordRepository testRecordRepository = null;

	public TestRecordValidator(TestRecordRepository testRecordRepository) {
		this.testRecordRepository  = testRecordRepository;
		
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return TestRecord.class.equals(clazz);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void doChecks( TestRecord passedRecord ) {
		try {	
				
			TestRecord fetchedByFirstname = testRecordRepository.findByFirstname(passedRecord.getFirstname());
			if (fetchedByFirstname != null )
				System.out.println("Validator->Fetched by firstname " + fetchedByFirstname.toString());
			
			TestRecord fetchedByLastname = testRecordRepository.findByLastname(passedRecord.getLastname());
			if (fetchedByLastname != null )
				System.out.println("Validator->Fetched by lastname " + fetchedByLastname.toString());
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		TestRecord passedRecord = (TestRecord) target;

		System.out.println("Validator->Entity passed " + passedRecord.toString());
		
		if ( passedRecord.getUuid() != null ) {
			// get by id
			TestRecord fetchedOneRecord = testRecordRepository.findOne(passedRecord.getUuid());
			if (fetchedOneRecord != null )	
				System.out.println("Validator->Fetched by uuid " + fetchedOneRecord.toString());
		}

		
		doChecks(passedRecord);
	}

}
