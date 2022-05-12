package com.promotionEngine.Type;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.promotionEngine.objects.Promotion;

/**
 * @author Prashanth S
 *
 */
public class PromotionsParser {
	public static HashMap<Integer, Promotion> getPromotions() {
		HashMap<Integer, Promotion> promotion = new HashMap<Integer, Promotion>();
		try (FileReader fr = new FileReader("promotions.json")) {
			Object obj = new JSONParser().parse(fr);
			JSONObject promotions = (JSONObject) obj;
			JSONArray jArray = (JSONArray) promotions.get("promotions");
			ObjectMapper mapper = new ObjectMapper();

			for (int i = 0; i < jArray.size(); i++) {
				Promotion promo = mapper.readValue(jArray.get(i).toString(), Promotion.class);
				promotion.put(promo.getPromotionId(), promo);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return promotion;
	}
}