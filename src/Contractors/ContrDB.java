package Contractors;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContrDB {
    private final StringProperty TITLE;
    private final StringProperty yearReleased;
    private final StringProperty rated;



    public ContrDB(String title,String yearreleased, String rated) {
        this.TITLE =new SimpleStringProperty(title);
        this.yearReleased =new SimpleStringProperty(yearreleased);
        this.rated =new SimpleStringProperty(rated);

    }

    public String getTITLE() {
        return TITLE.get();
    }

    public StringProperty TITLEProperty() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE.set(TITLE);
    }

    public String getYearReleased() {
        return yearReleased.get();
    }

    public StringProperty yearReleasedProperty() {
        return yearReleased;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased.set(yearReleased);
    }

    public String getRated() {
        return rated.get();
    }

    public StringProperty ratedProperty() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated.set(rated);
    }
}
