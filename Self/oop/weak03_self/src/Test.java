import java.util.Date;

public class Test {
    public static void main(String[] args) {

        Director director = new Director("TDM","Shankar");
        Date dob = new Date(19,04,2002);
        director.setDob(dob);
        director.setNumDirectedMovie(10);

        System.out.println(director);
        System.out.println("Name: " + director.getName());
        System.out.println("Surname: " + director.getSurname());
        System.out.println("Date: " + director.getDob().getDate());
        System.out.println("Num Directed Movie: " + director.getNumDirectedMovie());

        System.out.println("==============================");

        Movie movie = new Movie("Avatar","Fantasy",director);
        System.out.println(movie);

        movie.setNumAward(3);
        System.out.println(movie);
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Category "+movie.getCategory());
        System.out.println("Name of the Director: "+movie.getDirector().getName());
        System.out.println("Surname of the Director: "+movie.getDirector().getSurname());
        System.out.println("Number of Award: "+movie.getNumAward());

    }
}