package com.promotionEngine.Type;

import java.util.HashMap;

/**
 * @author prashanth s
 *
 */
public enum PromotionMapping {

	A(1), 
	B(2),
	C(3),
	D(3);

	private static HashMap<String, Integer> promotionMapping = new HashMap<String, Integer>();
	private int promotionId;
	
	static {
		for(PromotionMapping mapping : PromotionMapping.values()) {
			promotionMapping.put(mapping.name(), mapping.promotionId);
		}
	}
	
	PromotionMapping(int promotionId) {
		this.promotionId = promotionId;
	}
	
	public int getPromotionId() {
		return promotionId;
	}
	
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	
	public static HashMap<String, Integer> getPromotionMapping(){
		return promotionMapping;
	}
}