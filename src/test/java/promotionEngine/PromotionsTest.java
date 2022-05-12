package promotionEngine;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.promotionEngine.objects.Order;
import com.promotionEngine.services.PromotionEngineService;

/**
 * @author prashanth s
 *
 */
public class PromotionsTest {

	@Test
	public void testPromotionScenarioA() {
		List<Order> orders = getScenarioAOrders();
		PromotionEngineService pe = new PromotionEngineService();
		int expectedTotal = 100;
		int actualTotal = pe.calculateTotal(orders);
		assertEquals(expectedTotal, actualTotal);
	}

	@Test
	public void testPromotionScenarioB() {
		List<Order> orders = getScenarioBOrders();
		PromotionEngineService pe = new PromotionEngineService();
		int expectedTotal = 370;
		int actualTotal = pe.calculateTotal(orders);
		assertEquals(expectedTotal, actualTotal);
	}

	@Test
	public void testPromotionScenarioC() {
		List<Order> orders = getScenarioCOrders();
		PromotionEngineService pe = new PromotionEngineService();
		int expectedTotal = 280;
		int actualTotal = pe.calculateTotal(orders);
		assertEquals(expectedTotal, actualTotal);
	}

	private List<Order> getScenarioAOrders() {
		Order o1 = new Order();
		o1.setQuantity(1);
		o1.setSkuId("A");
		Order o2 = new Order();
		o2.setQuantity(1);
		o2.setSkuId("B");
		Order o3 = new Order();
		o3.setQuantity(1);
		o3.setSkuId("C");
		return Arrays.asList(o1, o2, o3);
	}

	private List<Order> getScenarioBOrders() {
		Order o1 = new Order();
		o1.setQuantity(5);
		o1.setSkuId("A");
		Order o2 = new Order();
		o2.setQuantity(5);
		o2.setSkuId("B");
		Order o3 = new Order();
		o3.setQuantity(1);
		o3.setSkuId("C");
		return Arrays.asList(o1, o2, o3);
	}

	private List<Order> getScenarioCOrders() {
		Order o1 = new Order();
		o1.setQuantity(3);
		o1.setSkuId("A");
		Order o2 = new Order();
		o2.setQuantity(5);
		o2.setSkuId("B");
		Order o3 = new Order();
		o3.setQuantity(1);
		o3.setSkuId("C");
		Order o4 = new Order();
		o4.setQuantity(1);
		o4.setSkuId("D");
		return Arrays.asList(o1, o2, o3, o4);
	}
}
