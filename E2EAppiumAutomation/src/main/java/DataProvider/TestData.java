package DataProvider;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
	public static Object[][] getDataForEditField() {
		Object[][] obj = new Object[][]
		{
			{"Omer", "Argentina", "Male"}, {"TestUser", "Aruba", "Female"}
		};
		return obj;
	}
	
	@DataProvider(name="TillCheckout")
	public static Object[][] getDataForTheShoes() {
		Object[][] obj = new Object[][] {
			{"Omer", "Argentina", "Male", "Jordan 6 Rings"}
		};
		return obj;
		
	}
}
