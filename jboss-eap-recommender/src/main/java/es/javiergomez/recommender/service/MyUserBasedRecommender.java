package es.javiergomez.recommender.service;



import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;

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


@Singleton
public class MyUserBasedRecommender implements MyRecommender {

	private static DataModel model;


	public MyUserBasedRecommender() throws IOException, URISyntaxException {
		super();
//		 The first thing we have to do is load the data from the file
		
		URL res = MyUserBasedRecommender.class.getResource("/dataset.csv");

//		this.model = new FileDataModel(new File(res.getPath()));
		this.model = new FileDataModel(new File(res.toURI().getSchemeSpecificPart()));
	}
	
	
	/* (non-Javadoc)
	 * @see es.javiergomez.recommender.MyRecommender#getRecommendations(java.lang.Integer, java.lang.Integer)
	 */
	public List<RecommendedItem> getRecommendations(Integer user,Integer nbRecommendations ) throws TasteException 
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
