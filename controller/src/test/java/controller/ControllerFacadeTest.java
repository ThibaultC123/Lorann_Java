package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Level;
import model.ModelFacade;
import view.ViewFacade;
import controller.ControllerFacade;

public class ControllerFacadeTest {
	
	private ControllerFacade controllerFacade;
	private ViewFacade view;
	private ModelFacade model; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		view = new ViewFacade(new Level(1));
		model = new ModelFacade(0);
		controllerFacade = (new ControllerFacade(view, model));
	}

	@After
	public void tearDown() throws Exception {
	}

	/* @Test
	public void testPlay() {
		fail("Not yet implemented");
	}
	@Test
	public void testMobKillChecker() {
		fail("Not yet implemented");
	}
	@Test
	public void testPowerMechanism() {
		fail("Not yet implemented");
	}
	@Test
	public void testPowerKillChecker() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetOrderPerformer() {
		fail("Not yet implemented");
	}
	@Test
	public void testOrderPerformer() {
		fail("Not yet implemented");
	}
	*/ 
	@Test
	public void testGetView() {
		assertEquals(view, controllerFacade.getView());
		
//		if (myControllerTester.getView() != view) { 
//			fail("getView() ne retourne pas la bonne valeur...");
//		}
	}
}