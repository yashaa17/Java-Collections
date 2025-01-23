package com.app.validations;

import java.time.LocalDate;
import java.util.List;

import com.app.core.Movie;
import com.app.core.MovieType;
import com.app.customexceptions.CustExc;

public class Validation {
		public static Movie validateAllInput(String movieId,String movieName, String releaseDate,int ratings,String movieType,List <Movie> list) throws CustExc {
			
			
			 MovieType m=  parsetype(movieType);
			 movievalidation(movieType);
			 validateMovieId( movieId);
			 checkMovieDate(LocalDate.parse(releaseDate));
			 isDup( movieName, list);
			return new Movie(movieId,movieName,LocalDate.parse(releaseDate),ratings,m);
		}
		
		public static MovieType parsetype(String movietype) throws CustExc{
			MovieType m=MovieType.valueOf(movietype.toUpperCase());
			if(m==null) {
				throw new CustExc("Movie is not valid");
			}
			return m;
		}
		
			//MovieType Validation
			public static MovieType movievalidation(String movietypes) throws CustExc{
				for(MovieType m:MovieType.values()) {
					if(m.name().equalsIgnoreCase(movietypes)) {
						return m;
					}
				}
				throw new CustExc("movie is not present");
			}
			
		 //Movie name should not be greater than 8 characters
			public static void validateMovieId(String movieId) throws CustExc {
				if(movieId.length()<8) {
					throw new CustExc("Movie name must contain 8 characters");
				}
			}
			
		//release date should be future date
			public static void checkMovieDate(LocalDate releaseDate) throws CustExc{
				if(releaseDate.isBefore(LocalDate.now())) {
					throw new CustExc("Release date should be future date");
				}
			}
			
		//Checking Duplicate MovieName
			public static boolean isDup(String Name,List<Movie> list)
			{
				boolean flag=false;
				for(Movie m:list) {
					if(m.getMovieName().equals(Name)) {
						return true;
					}
				}
				return false;
			}
			
		
}
