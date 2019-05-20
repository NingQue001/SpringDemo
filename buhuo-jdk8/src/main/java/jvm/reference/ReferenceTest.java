package jvm.reference;

import static org.junit.Assert.*;

import org.junit.Test;


public class ReferenceTest {
	@Test
	public void strongReferenceTest() {
		Object reference = new Object();
		
		Object strongReference = reference;
		
//		assertSame(reference, strongReference);
		assertEquals(reference, strongReference);
//		System.out.println(strongReference == null);
//		assertNull(strongReference);
		reference = null;
		System.gc();
		
		assertNotNull(strongReference);
//		System.out.println(reference == null);
	}
}
