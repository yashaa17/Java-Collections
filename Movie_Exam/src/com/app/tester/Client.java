package com.app.tester;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import com.app.core.*;

import static com.app.validations.Validation.*;

public class Client {

	public static void main(String[] args) {
			ArrayList<Movie> list=new ArrayList<>();
			
		try(Scanner sc=new Scanner(System.in)){
			boolean exit=false;
			while(!exit) {
				
				System.out.println("Enter the Choice: \n"
						               + "1. Add Movies\n"
										+ "2. Display All Movies\n"
						               + "3. Diaplay Movies as per Sorted release date\n"
										+ "4. Display Movies by Movie Type\n"
						               + "5. Update Movie rating\n"
										+ "6. Remove Movie\n"
						               + "7. Exit");
				try {
					switch(sc.nextInt()) {
					case 1:
						//accept Movies
						System.out.println("1.Movie_Id\n"
								+"2.MovieName\n"
								+" 3.releaseDate\n"
								+ " 4. Rating\n"
								+ "5. MovieType");
						
						Movie movie=validateAllInput(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.next(),list);
						list.add(movie);
						System.out.println("New Movie is Added");
						break;
						
					case 2:
						System.out.println("Display All movie Details");
						list.stream().forEach(System.out::println);
						break;
						
					case 3://Display Movies as per sorted date
						System.out.println("Display Movies sorted as per release date");
						list.stream().sorted(Comparator.comparing(Movie::getReleaseDate)).forEach(System.out::println);
//						list.sort(Comparator.comparing(Movie::getReleaseDate));
//						for (Movie movie1 : list) {
//							System.out.println(movie1);
//						}
						break;
						
					case 4://Display by movietype
						System.out.println("Enter the movie Type");
						MovieType movietype= MovieType.valueOf(sc.next()) ;
						System.out.println("Display as per movie type");
						List<Movie> m=list.stream()
													.filter(s -> s.getMovietype()==movietype)
													.collect(Collectors.toList());
						System.out.println("Movies as per movietype :"+movietype);
						m.forEach(System.out::println);
						break;
						
					case 5://update movie rating
						System.out.println("Enter the movie Name");
						 String moviename=sc.next();
						System.out.println("Enter new Rating");
						int newRating=sc.nextInt();
						
						Optional<Movie> movien=list.stream().filter(m1 -> m1.getMovieName().equals(moviename)).findFirst();
						
						if(movien.isPresent()) {
							movien.get().setRatings(newRating);
						}
						break;
						
					case 6://remove movie
						System.out.println("Enter the movie name");
						list.removeIf(m1 -> m1.getMovieName().equals(sc.next()));
						System.out.println("Movie removed ");
						break;
						
					case 7:
						System.exit(1);
						break;
				
						
					}		
					
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
			}
		}
		

	}

}
/*//Movie movie=validateAllInput(sc.next(),sc.next(),list);
list.add(movie);
SOP(Movie is added)

//Display All Movies
list.stream().forEach(System.out::println);

//Display Movies as per sorted rrelease date
list.stream().sorted(Comparator.comparing(Movie::getReleaseDate())).forEach(System.out::println);

//Display Movies as per movietype
List<Movie> moviet=list.stream().filter(m1 -> m1.getMovieType()==movietype).Collect(Collectors.toList());
		moviet.forEach(System.out::println);
		
//Update Movie Rating
	System.out.println("Enter the movie name");
	mn=sc.next();
	System.out.println("Enter new Rating");
	nr=sc.nextInt();
Optional<Movie> m2=list.stream().filter(m4 -> m4.getMoviename.equals(mn)).findFirst();

if(mn.isPresent()) {
	mn.get().setRatings(nr);
}
break;*/








