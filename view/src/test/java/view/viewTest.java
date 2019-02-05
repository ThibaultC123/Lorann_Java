package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.UserOrder;

public class viewTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	
	@Test
	public void testkeyCodeToUserOrderUP(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_UP),UserOrder.UP);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_Z),UserOrder.UP);
	}
	@Test
	public void testkeyCodeToUserOrderDOWN(){
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_DOWN),UserOrder.DOWN);
		assertEquals(ViewFacade.keyCodeToUserOrder(KeyEvent.VK_S),UserOrder.DOWN);
	}
}