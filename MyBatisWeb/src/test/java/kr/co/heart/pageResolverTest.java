package kr.co.heart;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import kr.co.heart.domain.pageResolver;

public class pageResolverTest {
	@Test
	public void test() {
		pageResolver pr = new pageResolver(250, 1);
		pr.print();
		System.out.println("pr =" + pr);
		
		assertTrue(pr.getBeginPage() == 1 );
		assertTrue(pr.getEndPage() == 10);
	}
	
	
	@Test
	public void test2() {
		pageResolver pr = new pageResolver(250, 11);
		pr.print();
		System.out.println("pr =" + pr);
		
		assertTrue(pr.getBeginPage() == 11 );
		assertTrue(pr.getEndPage() == 20);
	}
	
	
	@Test
	public void test3() {
		pageResolver pr = new pageResolver(255, 25);
		pr.print();
		System.out.println("pr =" + pr);
		
		assertTrue(pr.getBeginPage() == 21);
		assertTrue(pr.getEndPage() == 26 );
	}
}
