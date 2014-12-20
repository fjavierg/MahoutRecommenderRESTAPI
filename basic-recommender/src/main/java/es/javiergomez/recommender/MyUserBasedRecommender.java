package es.javiergomez.recommender;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;



public class MyUserBasedRecommender implements MyRecommender {

	private DataModel model;

	public MyUserBasedRecommender(String file) throws IOException {
		super();
//		 The first thing we have to do is load the data from the file
		this.model = new FileDataModel(new File(file));
	}
	
	
	/* (non-Javadoc)
	 * @see es.javiergomez.recommender.MyRecommender#getRecommendations(java.lang.Integer, java.lang.Integer)
	 */
	public  List<RecommendedItem> getRecommendations(Integer user,Integer nbRecommendations ) throws TasteException 
	{


			
//		 In this example, we want to create a user-based recommender
//		 compute the correlation coefficient between their interactions.
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		
//		 The next thing we have to do is to define which similar users we want to leverage for the recommender. 
//		 For the sake of simplicity, we'll use all that have a similarity greater than 0.1.	
			UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
		
//		 Now we have all the pieces to create our recommender:
			UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
			
//		 We can easily ask the recommender for recommendations now. 
//		 If we wanted to get three items recommended for the user with userID 2, we would do it like this:
			List<RecommendedItem> recommendations = recommender.recommend(user, nbRecommendations);
			return recommendations;

	}

}
