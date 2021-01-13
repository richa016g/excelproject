import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MainClass{

	public static void main (String... args) {
		junit.textui.TestRunner.run (suite());
	}
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(MainClass.class);
	}
	
	@Test public void testCopy() {
        assertEquals("Size", 12, 13);
	}
}