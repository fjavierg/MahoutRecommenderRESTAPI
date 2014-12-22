package es.javiergomez.recommender.rest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import es.javiergomez.recommender.service.MyRecommender;
import es.javiergomez.recommender.service.MyUserBasedRecommender;

/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/rec")
@RequestScoped
public class MyRecommenderRESTService {
	
    @Inject
    private Logger log;

	@Inject
	MyRecommender recommender;
	
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecommendedItem> getRecommendations(@PathParam("id") int id) throws IOException, TasteException {

//    	MyRecommender recommender;
//		URL res = MyRecommenderRESTService.class.getResource("/dataset.csv");
//		recommender = new MyUserBasedRecommender(res.getPath());

    	log.warning(recommender.toString());
    	
		List<RecommendedItem> recommendations;
		recommendations = recommender.getRecommendations(id, 3);
        return recommendations;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RecommendedItem> Recommendations() throws IOException, TasteException {
		
//    	MyRecommender recommender = null;
//		URL res = MyRecommenderRESTService.class.getResource("/dataset.csv");
		
//		recommender = new MyUserBasedRecommender(res.getPath());
//		recommender = new MyUserBasedRecommender("C:/Users/Javier/jbdevstudio/runtimes/jboss-eap/standalone/deployments/jboss-eap-recommender.war/WEB-INF/classes/dataset.csv");

    	log.warning(recommender.toString());
    	
    	List<RecommendedItem> recommendations = null;
		recommendations = recommender.getRecommendations(2, 3);

        return recommendations;

    }
    
    
}
