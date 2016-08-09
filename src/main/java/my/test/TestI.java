package my.test;

import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;

public interface TestI {
	
	@PreAuthorize("hasPermission(#x, 'READ')")
	public void doSomething(@P("x") Object o);
}
