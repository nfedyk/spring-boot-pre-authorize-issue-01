package my.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

@KeySpace("test")
public class TestRecord {
	
	@Id String uuid;
	
	public String firstname;
	public String lastname;
	
	public String toString() {
		return "UUID: "+uuid +
				" Firstname:" + firstname +
				" Lastname: " + lastname +
				" ID:" + getClass().getName() + '@' + Integer.toHexString(hashCode());
	}
}
