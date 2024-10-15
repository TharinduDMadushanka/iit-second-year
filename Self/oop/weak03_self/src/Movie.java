public class Movie {

    private String title;
    private String category;
    private Director director;
    private int numAward;

    public Movie() {
    }

    public Movie(String title, String category, Director director) {
        this.title = title;
        this.category = category;
        this.director = director;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getNumAward() {
        return numAward;
    }

    public void setNumAward(int numAward) {
        this.numAward = numAward;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", director=" + director + ", numAward="+numAward+"]";
    }
}
