package DataProvider;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
	public static Object[][] getDataForEditField() {
		Object[][] obj = new Object[][]
		{
			{"Omer"}, {"!@#"}
		};
		return obj;
	}
}
