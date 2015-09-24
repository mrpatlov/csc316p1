package lists;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListOfMessagesTest {
	ListOfMessages testList;
	Message testMessage;

	@Before
	public void setUp() throws Exception {
		testList = new ListOfMessages();
		testList.insert(1, 1, "String 1");
		
		testMessage = new Message(1, "String 1");
	}

	@Test
	public void testInsert() {
		assertEquals(testList.peek(),1);
		testList.insert(1, 2, "String 2");
		testList.insert(5, 4, "String 3");
		testList.insert(3, 1, "String 1");
		testList.insert(3, 3, "String 3");
		testList.insert(3, 2, "String 2");
		testList.insert(5, 2, "String 2");
		testList.insert(5, 1, "String 1");
		testList.pop();
		assertEquals(testList.peek(),3);
		testList.pop();
		assertEquals(testList.peek(),5);
	}
	
	@Test
	public void testPeek() {
		assertEquals(testList.peek(),1);
		testList.pop();
		assertEquals(testList.peek(),-1);
	}
	
	@Test
	public void testPop() {
		assertEquals(testList.pop(),testMessage);
		assertEquals(testList.pop(),null);		
	}
}
