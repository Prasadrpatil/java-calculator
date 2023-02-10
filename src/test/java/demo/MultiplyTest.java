package demo;

import static org.junit.Assert.assertEquals;





public class MultiplyTest {

	@org.junit.Test
	public void testSubract() {
	int a=30;
	int b=20;
	int c=doSubtract(a,b);
	assertEquals(10,c);
	}

	@org.junit.Test
	public void testSubtract2() {
	int a=50;
	int b=20;
	int c=doSubtract(a,b);
	assertEquals(30,c);
	}


	public int doSubtract(int a, int b) {
	return a-b;
	}

}
