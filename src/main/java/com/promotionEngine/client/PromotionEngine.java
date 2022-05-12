package com.promotionEngine.client;

import java.util.List;

import com.promotionEngine.objects.Order;

/**
 * @author prashanth s
 *
 */
public interface PromotionEngine {
	
	public int calculateTotal(List<Order> orders);
}
