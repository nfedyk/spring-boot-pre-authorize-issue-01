package my.test;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(collectionResourceRel = "testrecords", path = "testrecords")
public interface TestRecordRepository extends PagingAndSortingRepository<TestRecord, String> {
 
	@PreAuthorize("hasPermission(#x,'READ')")
	public List<TestRecord> findByFirstname(@P("x") @Param("fn") String firstname);
}