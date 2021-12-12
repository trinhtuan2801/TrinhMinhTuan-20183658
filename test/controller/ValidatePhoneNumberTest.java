package controller;

import static org.junit.Assert.assertEquals;

import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ValidatePhoneNumberTest {

	private PlaceOrderController placeOrderController;

	@BeforeEach
	void setUp() throws Exception {
		placeOrderController = new PlaceOrderController();
	}
	@ParameterizedTest
	@CsvSource({
			"true, 0123456789",
			"false, 01234",
			"false, a0123456789",
			"false, 1023456789"
	})
	@Test
	public void test() {
		boolean isValid = placeOrderController.validatePhoneNumber("0123456789");
		assertEquals(true, isValid);
	}

}
