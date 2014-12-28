package es.javiergomez.recommender.rest;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import es.javiergomez.recommender.model.Movie;

@Path("/movies")
public class MovieRESTService {
	
	@Inject
	private EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getAllMovies() {
		final List<Movie> results =
			em.createQuery(
			"select e from Movie e order by e.name").getResultList();
		return results;
	}

}
