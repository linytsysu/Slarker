package web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.models.Cinema;
import web.models.HallSeatStructure;
import web.models.Movie;
import web.models.Seat;
import web.models.VideoHall;
import web.repositories.CinemaRepository;
import web.repositories.MovieRepository;
import web.repositories.VideoHallRepository;

@Controller
public class MovieController {

	@Autowired
	private VideoHallRepository videoHallRepository;
	
	@Autowired
	private MovieRepository movie_repo;

    @RequestMapping("/movie/{movieid}")
    public String thymeleaf(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	List<Movie> movies =  (List<Movie>) movie_repo.findAll();
    	Movie movie = movies.get(0);
        model.addAttribute("movie",movie);
    	// model.addAttribute("movies", movies);
    	
    	return "movie";
    }
}
