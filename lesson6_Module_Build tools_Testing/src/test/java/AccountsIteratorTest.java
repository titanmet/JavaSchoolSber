import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountsIteratorTest {
    private AccountsIterator iterator;
    List<AccountsImpl> accounts = Arrays.asList(
            new AccountsImpl("user", "12345", "Alex", "Baldwin", "8928903451223", "Los-Angeles"),
            new AccountsImpl("user1", "12345", "Den", "Moll", "8928234451293", "Rostov"),
            new AccountsImpl("user2", "12345", "Sam", "Serious", "8928567451269", "Denver"));

    @Mock
    List<AccountsImpl> mockedList = new ArrayList<>();

    @Before
    public void start() {
        iterator = new AccountsIterator(accounts);
    }

    @Test
    public void AccountIterTest() {
        assertEquals(accounts.size(), 3);
    }

    @Test
    public void hasNext() {
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }

    @Test
    public void next() {
        AccountsImpl acc = iterator.next();
        assertEquals(accounts.get(0), acc);
    }

    @Test
    public void testList() {
        mockedList.add(new AccountsImpl("user", "12345", "Alex", "Baldwin", "8928903451223", "Los-Angeles"));
        mockedList.add(new AccountsImpl("user1", "12345", "Den", "Moll", "8928234451293", "Rostov"));
        mockedList.add(new AccountsImpl("user2", "12345", "Sam", "Serious", "8928567451269", "Denver"));

        verify(mockedList, never()).add(new AccountsImpl("user2", "12345", "Sam", "Serious", "8928567451269", "Denver"));
        verify(mockedList, atLeast(3)).add(anyObject());
    }
}