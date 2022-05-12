package com.promotionEngine.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.promotionEngine.Type.PromotionMapping;
import com.promotionEngine.Type.PromotionsParser;
import com.promotionEngine.Type.SkuUnitPrice;
import com.promotionEngine.client.PromotionEngine;
import com.promotionEngine.objects.Order;
import com.promotionEngine.objects.Promotion;

/**
 * @author prashanth s
 *
 */
public class PromotionEngineService implements PromotionEngine {

	/**
	 *
	 */
	@Override
	public int calculateTotal(List<Order> orders) {
		HashMap<String, Order> ordersMap = new HashMap<String, Order>();
		for (Order order : orders) {
			ordersMap.put(order.getSkuId(), order);
		}
		HashMap<Integer, Promotion> promotions = PromotionsParser.getPromotions();
		HashMap<String, Integer> promotionMapping = PromotionMapping.getPromotionMapping();
		HashSet<String> skipOrders = new HashSet<String>();
		int total = 0;
		for (Order order : orders) {
			// check if promotion is applicable for orderID
			String orderId = order.getSkuId();
			if (!skipOrders.contains(orderId)) {
				if (null != promotionMapping.get(orderId)) {
					int promotionId = promotionMapping.get(orderId);
					Promotion promotion = promotions.get(promotionId);
					List<String> skuIds = promotion.getSkuIds();
					int orderedQuantity = order.getQuantity();
					int offerQuantity = promotion.getQuantity();
					int offerAmount = promotion.getOfferAmount();
					int multiplier = orderedQuantity / offerQuantity;
					// processing for more than one skuid
					int skuSize = skuIds.size();
					if (skuSize > 1) {
						int count = 0;
						for (String skuId : skuIds) {
							if (ordersMap.get(skuId) != null) {
								count++;
							}
						}
						if (skuSize == count) {
							skipOrders.addAll(skuIds);
							total = applyPromotion(total, multiplier, offerAmount, orderedQuantity, offerQuantity,
									orderId);
						} else {
							int skuPrice = SkuUnitPrice.getUnitPriceByName(orderId);
							total += skuPrice;
						}
					} else {
						total = applyPromotion(total, multiplier, offerAmount, orderedQuantity, offerQuantity, orderId);
					}
				}
			}
		}
		return total;
	}

	/**
	 * @param total
	 * @param multiplier
	 * @param offerAmount
	 * @param orderedQuantity
	 * @param offerQuantity
	 * @param orderId
	 * @return
	 */
	private int applyPromotion(int total, int multiplier, int offerAmount, int orderedQuantity, int offerQuantity,
			String orderId) {
		total += multiplier * offerAmount;
		int remainderQuantity = orderedQuantity - (multiplier * offerQuantity);
		int skuPrice = SkuUnitPrice.getUnitPriceByName(orderId);
		total += remainderQuantity * skuPrice;
		return total;
	}
}
