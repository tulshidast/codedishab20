package seleniumpractices;

import org.testng.annotations.Test;

public class TestNgGroups {

	@Test(groups = { "sanity" })
	public void testA() {
		System.out.println("Test case A");
	}

	@Test(groups = { "smoke" })
	public void testB() {
		System.out.println("Test case B");
	}

	@Test(groups = { "regression" })
	public void testC() {
		System.out.println("Test case C");
	}

	@Test(groups = { "shortChecks" })
	public void testD() {
		System.out.println("Test case D");
	}

	@Test(groups = { "shortChecks", "regression" })
	public void testE() {
		System.out.println("Test case E");
	}

}
