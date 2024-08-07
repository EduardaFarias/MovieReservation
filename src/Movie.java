public class Movie {
    private int id;
    private String title;
    private boolean isReserved;

    public Movie(int id, String title, boolean isReserved) {
        this.id = id;
        this.title = title;
        this.isReserved = isReserved;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
