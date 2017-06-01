import org.junit.Test;
import static org.junit.Assert.*;
import exercise.Ex2;
public class Ex2Test {
	@Test
	public void testTri3()
	{
		assertEquals(Ex2.triangle(3), 6);
	}
	@Test
	public void testTri4()
	{
		assertEquals(Ex2.triangle(4), 10);
	}
	@Test
	public void testTri1()
	{
		assertEquals(Ex2.triangle(1), 1);
	}
	@Test
	public void testLazy1()
	{
		assertEquals(Ex2.lazy(1), 2);
	}
	@Test
	public void testLazy2()
	{
		assertEquals(Ex2.lazy(2), 4);
	}
	@Test
	public void testLazy3()
	{
		assertEquals(Ex2.lazy(3), 7);
	}
}