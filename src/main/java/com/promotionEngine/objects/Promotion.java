package com.promotionEngine.objects;

import java.util.List;

/**
 * @author prashanth s
 *
 */
public class Promotion {
	
	private int promotionId;
	private List<String> skuIds;
	private int quantity;
	private int offerAmount;
	
	/**
	 * @return the promotionId
	 */
	public int getPromotionId() {
		return promotionId;
	}
	
	/**
	 * @param promotionId the promotionId to set
	 */
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	
	/**
	 * @return the skuIds
	 */
	public List<String> getSkuIds() {
		return skuIds;
	}
	
	/**
	 * @param skuIds the skuIds to set
	 */
	public void setSkuIds(List<String> skuIds) {
		this.skuIds = skuIds;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the offerAmount
	 */
	public int getOfferAmount() {
		return offerAmount;
	}
	
	/**
	 * @param offerAmount the offerAmount to set
	 */
	public void setOfferAmount(int offerAmount) {
		this.offerAmount = offerAmount;
	}
	
	@Override
	public String toString() {
		return "Promotion [promotionId=" + promotionId + ", skuIds=" + skuIds + ", quantity=" + quantity
				+ ", offerAmount=" + offerAmount + "]";
	}
}