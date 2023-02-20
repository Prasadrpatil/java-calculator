package demo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddTest {

@Test
public void testSum() {
int a=30;
int b=20;
int c=doSum(a,b);
assertEquals(50,c);
}

@Test
public void testSum2() {
int a=50;
int b=20;
int c=doSum(a,b);
assertEquals(70,c);
}


public int doSum(int a, int b) {
return a+b;
}

}
AWS_SECRET_KEY=JhG7#s9Y@eVt2u
AWS_PUBLIC_KEY=xuL4$w6Z#rTf8s
