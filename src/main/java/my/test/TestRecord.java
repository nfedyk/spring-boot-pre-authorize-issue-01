package my.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestRecord {
	
	@Id
	@GeneratedValue
	private String uuid;
	
	private String firstname;
	private String lastname;
	
	public String toString() {
		return "UUID: "+uuid +
				" Firstname:" + firstname +
				" Lastname: " + lastname +
				" ID:" + getClass().getName() + '@' + Integer.toHexString(hashCode());
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
