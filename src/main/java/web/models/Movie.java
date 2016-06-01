package web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Movie")
public class Movie implements Serializable {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 5046320505351582223L;

	public Movie() {}
	
	public Movie(String name, List<String> directors, List<String> actors, String poster, List<String> type,
			String country, String language, String duration, Calendar releaseTime, List<String> version, double star,
			String backgroundImage) {
		super();
		this.name = name;
		this.directors = directors;
		this.actors = actors;
		this.poster = poster;
		this.type = type;
		this.country = country;
		this.language = language;
		this.duration = duration;
		this.releaseTime = releaseTime;
		this.version = version;
		this.star = star;
		this.backgroundImage = backgroundImage;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieId")
	private Long movieId;
	
	@Column(name = "name")
	private String name;
	
//	@ElementCollection
//	@JoinTable(
//			name = "movie_directors",
//			joinColumns = @JoinColumn( name = "movieIdMovie" )
//	)
//	@Column(name = "directors", nullable = false)
	@ElementCollection
	@Column(name = "directors", nullable = false)
	private List<String> directors;
	
	@ElementCollection
	@Column(name = "actors")
	private List<String> actors;
	
	@Column(name = "poster")
	private String poster;
	
	@ElementCollection
	@Column(name = "type")
	private List<String> type;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "duration")
	private String duration;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "releaseTime")
	private Calendar releaseTime;
	
	@ElementCollection
	@Column(name = "version")
	private List<String> version;
	
	@Column(name = "star")
	private double star;
	
	@Column(name = "backgroundImage")
	private String backgroundImage;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getActors() {
		return actors;
	}

	public void setActors(List<String> actors) {
		this.actors = actors;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Calendar getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Calendar releaseTime) {
		this.releaseTime = releaseTime;
	}

	public List<String> getVersion() {
		return version;
	}

	public void setVersion(List<String> version) {
		this.version = version;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
}
