package netflix;

import java.io.Serializable;
import java.util.Date;

public class Episode implements Serializable {
    private String episodeTitle;
    private int duration;
    private Date releaseDate;
    /** Creating new Episode with settings*/
    public Episode(String episodeTitle, int duration, Date releaseDate) {
        this.episodeTitle = episodeTitle;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }
    /** Creating new Random Episode*/
    public Episode () {
        this.episodeTitle = "default";
        this.duration = 0;
        this.releaseDate = null;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "episodeTitle='" + episodeTitle + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
