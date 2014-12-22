package es.javiergomez.recommender.service;

import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public interface MyRecommender {

	public abstract List<RecommendedItem> getRecommendations(Integer user,
			Integer nbRecommendations) throws TasteException;

}