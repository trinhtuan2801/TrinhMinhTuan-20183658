package controller;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertEquals;

class ValidateNameTest {

	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	@ParameterizedTest
	@CsvSource({
			"true, Tuan",
			"false, 123Tuan",
			"false,  ",
			"false, null",
	})
	@Test
	public void test() {
		boolean isValid = placeOrderController.validateName("0123456789");
		assertEquals(true, isValid);
	}

}
