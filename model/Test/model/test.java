package model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class test {

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
	public void testGetWidth() {
		Level myLevelTester = null;
		try {
			myLevelTester = new Level(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (myLevelTester.getWidth() != 28) { 
			fail("Pour Level==1, Widht ne vaut pas 28");
		}
	}
	
	@Test
	public void testGetHeight() {
		Level myLevelTester = null;
		try {
			myLevelTester = new Level(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (myLevelTester.getHeight()==10) {
			fail("Pour Level==1, Height ne vaut pas 12");
		}
	}
}
