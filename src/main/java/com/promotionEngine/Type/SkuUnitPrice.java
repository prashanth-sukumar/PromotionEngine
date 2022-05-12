package com.promotionEngine.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * @author prashanth s
 *
 */
public enum SkuUnitPrice {

	A(50), B(30), C(20), D(15);

	private static Map<String, Integer> unitPriceMap = new HashMap<String, Integer>();
	private int unitPrice;

	static {
		for (SkuUnitPrice unitPrice : SkuUnitPrice.values()) {
			unitPriceMap.put(unitPrice.name(), unitPrice.getUnitPrice());
		}
	}

	SkuUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public static Integer getUnitPriceByName(String name) {
		return unitPriceMap.get(name);
	}
}