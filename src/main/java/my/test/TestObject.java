package my.test;

public class TestObject implements TestI {

	@Override
	public void doSomething(Object o) {
		System.out.println("testObject INVOKED: " + o);
	}

}
