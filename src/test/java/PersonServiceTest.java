import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class PersonServiceTest {

    private PersonDao     mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        //ģ��PersonDao����
        mockDao = mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService = new PersonService(mockDao);
    }

    @Test
    public void testUpdate() throws Exception {
        boolean result = personService.update(1, "new name");
        assertTrue("must true", result);
        //��֤�Ƿ�ִ�й�һ��getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //��֤�Ƿ�ִ�й�һ��update
        verify(mockDao, times(1)).update(isA(Person.class));
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = personService.update(2, "new name");
        assertFalse("must true", result);
        //��֤�Ƿ�ִ�й�һ��getPerson(1)
        verify(mockDao, times(1)).getPerson(eq(1));
        //��֤�Ƿ�ִ�й�һ��update
        verify(mockDao, never()).update(isA(Person.class));
    }
}