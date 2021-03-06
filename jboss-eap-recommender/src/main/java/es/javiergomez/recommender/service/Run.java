package es.javiergomez.recommender.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class Run {

	public Run() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws TasteException 
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public static void main(String[] args) throws IOException, TasteException, URISyntaxException {

		MyRecommender recommender;
		List<RecommendedItem> recommendations;
		
		recommender = new MyUserBasedRecommender();
		recommendations = recommender.getRecommendations(2, 3);
		for (RecommendedItem recommendation : recommendations) {
			  System.out.println(recommendation);
			}

	}

}
