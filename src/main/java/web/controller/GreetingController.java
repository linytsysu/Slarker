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
public class GreetingController {

	@Autowired
	private VideoHallRepository videoHallRepository;
	
	@Autowired
	private CinemaRepository cinema_repo;

	@Autowired
	private MovieRepository movie_repo;
	
    @RequestMapping("/thymeleaf")
    public String thymeleaf(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	List<Cinema> cinemas = (List<Cinema>) cinema_repo.findAll();
    	
    	model.addAttribute("cinemas", cinemas);
    	
    	return "thymeleaf";
    }
    
    @RequestMapping("/test")
    public String test(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	List<Movie> movies = (List<Movie>) movie_repo.findAll();
    	
    	model.addAttribute("movies", movies);
    	
    	return "hihi";
    }
    
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        
    	Cinema cinema = new Cinema();
    	cinema.setCinemaName("万达影院");
    	cinema.setDetailedAddress("大学城GOGO新天地三楼");
    	
    	HallSeatStructure hallSeatStructure = new HallSeatStructure();
    	hallSeatStructure.addSeat(new Seat(1, 1, 1, 1));
    	hallSeatStructure.addSeat(new Seat(1, 2, 1, 2));
    	hallSeatStructure.addSeat(new Seat(1, 3, 1, 3));
    	hallSeatStructure.addSeat(new Seat(4, 5, 4, 5));
    	
    	VideoHall videoHall = new VideoHall();;
    	videoHall.setVoideHallName("SamepleVideoHall 1 厅");
    	videoHall.setCinema(cinema);
    	videoHall.setHallSeatStructure(hallSeatStructure);
    	
    	videoHallRepository.save(videoHall);
    	
    	model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/dealing")
    public String dealing(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	VideoHall videoHall = videoHallRepository.findByVideoHallId(1L);
    	System.out.println(videoHall.getVoideHallName());
    	System.out.println(videoHall.getCinema());
      	System.out.println(videoHall.getHallSeatStructure());
    	System.out.println(videoHall.getVideoHallId());
    	
    	List<Seat> seats = videoHall.getHallSeatStructure().getSeats();
    	
    	for (Seat seat: seats) {
    		System.out.println(seat);
    		System.out.println(seat.getLogicRow());
    		System.out.println(seat.getLogicCol());
    		System.out.println(seat.getSeatRow());
    		System.out.println(seat.getSeatPew());
    	}
    	
    	model.addAttribute("name", name);
		return "greeting";
    }

    @RequestMapping("/insertData")
    public String insertData(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	
    	
    	return "greeting";
    }
    
}