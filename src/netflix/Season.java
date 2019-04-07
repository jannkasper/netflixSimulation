package netflix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Season implements Serializable  {
    private int numberSeason;
    private ArrayList<Episode> listEpisodes;


    public Season(int numberSeason) {
        this.numberSeason = numberSeason;
        this.listEpisodes = new ArrayList<Episode>();
    }
    public Season(int numberSeason, ArrayList<Episode> listEpisodes) {
        this.numberSeason = numberSeason;
        this.listEpisodes = listEpisodes;
    }
    public Season() {
        this.numberSeason = 0;
        this.listEpisodes = null;
    }

    public void wypisz () {
        for (int i = 0; i < listEpisodes.size(); i++) {
            System.out.println(listEpisodes.get(i).toString());
        }

    }


    public void addEpisode (String name, int duration, Date releaseDate) {
        listEpisodes.add(new Episode(name, duration, releaseDate));
    }
    public void addEpisode (Episode nextEpisode) {
        listEpisodes.add(nextEpisode);
    }

    public int getNumberEpisodes () {
        return listEpisodes.size();
    }
}
