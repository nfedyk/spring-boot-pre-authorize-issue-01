package my.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("test")
public class TestRecord {
	
	@Id String uuid;
	
	public String firstname;
}
