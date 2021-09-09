import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountsImplTest {
    @Mock
    private AccountsImpl mockedAccountsImpl;

    @Mock
    List<String> mockedList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testList() {
        mockedList.add("One");
        mockedList.add("Two");
        mockedList.add("Two");

        verify(mockedList).add("One");
        verify(mockedList, times(2)).add("Two");
        verify(mockedList, never()).add("Three");
        verify(mockedList, atLeast(3)).add(anyString());
    }

    @Test
    public void testToString() {
    }

    @Test
    public void registration() {
    }

    @Test
    public void authorization() {
    }

    @Test
    public void input() {
    }

    @Test
    public void exit() {
    }
}