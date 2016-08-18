package my.test;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "testrecords", path = "testrecords")
public interface TestRecordRepository extends PagingAndSortingRepository<TestRecord, String> {
 
	public TestRecord findByFirstname(String firstname);
	public TestRecord findByLastname(String lastname);
	public TestRecord findByUuid(String uuid);
}