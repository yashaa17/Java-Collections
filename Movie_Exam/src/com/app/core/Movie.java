package com.app.core;

import java.time.LocalDate;
import java.util.Objects;

public class Movie {
	private String movieId;
	private String movieName;
	private LocalDate releaseDate;
	private int ratings;
	public boolean InCinemas;
   private MovieType movietype;
	
	

	public Movie(String movieId, String movieName, LocalDate releaseDate, int ratings, 
		MovieType movietype) {
	super();
	this.movieId = movieId;
	this.movieName = movieName;
	this.releaseDate = releaseDate;
	this.ratings = ratings;
	this.InCinemas = true;
	this.movietype = movietype;
}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public boolean isInCinemas() {
		return InCinemas;
	}

	public void setInCinemas(boolean inCinemas) {
		InCinemas = inCinemas;
	}

	public MovieType getMovietype() {
		return movietype;
	}

	public void setMovietype(MovieType movietype) {
		this.movietype = movietype;
	}

	
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate + ", ratings="
				+ ratings + ", InCinemas=" + InCinemas + ", movietype=" + movietype + "]";
	};
	
	@Override
	public  boolean equals(Object obj) {
		if(obj instanceof Movie) {
			Movie m=(Movie) obj;
			return this.movieId.equals(m.movieId);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(movieId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
