import java.time.LocalDate;
import java.util.Date;

public class Director {

    private String name;
    private String surname;
    private int numDirectedMovie;
    private LocalDate dob;

    public Director() {
    }

    public Director(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getNumDirectedMovie() {
        return numDirectedMovie;
    }

    public void setNumDirectedMovie(int numDirectedMovie) {
        this.numDirectedMovie = numDirectedMovie;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Director [name= " + name + ", surname= " + surname+" dob= " + dob +", Movies Directed= " + numDirectedMovie + "]";
    }
}
