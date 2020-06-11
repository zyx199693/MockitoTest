import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class Demo {

	@Test
	public void test() {
		List mock = mock(List.class);
		when(mock.get(0)).thenReturn(1);
		System.out.println(mock.get(0));
		System.out.println(mock.size());
//		assertEquals(1,mock.get(0));
//		fail("ипн╢й╣ож");
	}
}
