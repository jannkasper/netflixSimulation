package netflix;

import java.io.File;
import java.io.Serializable;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.scene.image.Image;
import java.util.*;

public class RandomFill implements Serializable {
    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lower = upper.toLowerCase(Locale.ROOT);
    private static final SecureRandom RANDOM = new SecureRandom();

    /** Generate randome string */
    public static String generateString(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(upper.charAt(RANDOM.nextInt(upper.length())));
        for (int i = 0; i < count; ++i) {
            sb.append(lower.charAt(RANDOM.nextInt(lower.length())));
        }
        return sb.toString();
    }
    /** Generate randome Number in range (a,b) */
    public static int generateNumber(int min, int max) {
        Random rand = new Random ();
        int number = rand.nextInt(max) + min;
        return number;
    }
    /** Generate default text in description */
    public static String generateText () {
        String text = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        //+ "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ";
        return text;
    }
    /** Generate randome title of product */
    public static String generateTitle () {
        String listTitle [] = {"reject", "rabid", "brick", "aromatic", "club", "daffy", "chubby", "melodic", "country", "pumped", "bee", "expert", "birds", "tough", "superb", "peck", "mist", "subdued", "suspend",
                "mate", "educe", "view", "stroke", "instrument", "cloistered", "shut", "pour", "snow", "yard", "line", "disgusting", "boundary"};
        Random rand = new Random ();
        int first = rand.nextInt(listTitle.length-1);
        int second = rand.nextInt(listTitle.length-1);
        return listTitle[first] + " " + listTitle[second];
    }
    /** Generate randome distributor name */
    public static String generateCompany () {
        String listCompany [] = { "Domil", "Lunor", "Syize", "Cofix", "Sylile", "Agidel", "Bovile", "Finose", "Quiloo", "Postive", "Electrori", "Venor", "Acerose", " Esose", "Scita", "Ofic", "Difit", "Outive", "Archil"};
        Random rand = new Random ();
        int first = rand.nextInt(listCompany.length-1);
        int second = rand.nextInt(listCompany.length-1);
        return listCompany[first] + " " + listCompany[second];
    }
    /** Generate randome list of countries */
    public static String [] generateCountry () {
        String listCountry [] = {"Ghana", "India", "Switzerland", "Germany", "Peru", "Uruguay", "USA", "Thailand", "Slovakia", "Denmark", "Kazakhstan", "Fiji", "Madagascar", "Spain", "Turkey", "Namibia"};
        Random rand = new Random ();
        int amount = generateNumber(1,3);
        String country [] = new String [amount];
        for (int i = 0; i< amount; i++)
        {
            country[i] =  listCountry[rand.nextInt(listCountry.length-1)];
        }
        return country;
    }
    /** Generate randome type of product */
    public static String generateType () {
        String[] listOfTypes = {"Adventure", "Historical", "Musical", "War", "Western", "Horror", "Comedy", "Thriller", "Action", "Sci-Fiction", "Drama", "Fantastic"};
        return listOfTypes[generateNumber(0,listOfTypes.length)];
    }
    /** Generate randome list of actors */
    public static String[] generateActors () {
        String listActors [] = {"Gary Oldman", "Al Pacino", "Samuel L. Jackson", "Marlon Brando", "Jeff Bridges", "Nancy Carlsson-Paige", "Robin Williams", "Morgan Freeman", "Denzel Washington", "Jack Nicholson", "Tom Cruise", "Brad Pitt", "Harrison Ford", "Leonardo DiCaprio", "Ryan Gosling", "George Clooney", "Clint Eastwood"};
        Random rand = new Random ();
        int amount = generateNumber(1,3);
        String actors [] = new String [amount];
        for (int i = 0; i< amount; i++)
        {
            actors[i] =  listActors[rand.nextInt(listActors.length-1)];
        }
        return actors;
    }
    /** Generate randome season list for series */
    public static ArrayList<Season> generateListSeason () {
        ArrayList<Season> listSeason = new ArrayList<Season>();
        int numberSeason = generateNumber(3,10);
        int numberEpisode = generateNumber(5,15);
        int duration = generateNumber(30,60);
        int frequency = generateNumber(2,7);
        Date date = new Date ();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, -generateNumber((numberSeason*numberEpisode*frequency)-30,(numberSeason*numberEpisode*frequency)+30));
        date = c.getTime();

        return generateListSeason(numberSeason, numberEpisode, duration, frequency, date);
    }
    /** Generate randome season list with default values */
    public static ArrayList<Season> generateListSeason (int numberSeason, int numberEpisode, int duration, int frequency, Date date) {
        ArrayList<Season> listSeason = new ArrayList<Season>();

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        for (int i =0; i<numberSeason; i++) {
            ArrayList<Episode> listEpisode = new ArrayList<Episode>();

            for (int j =0; j <numberEpisode; j++) {
                listEpisode.add(new Episode(RandomFill.generateString(8), duration, date));
                c.add(Calendar.DATE, frequency);
                date = c.getTime();
            }
            listSeason.add(new Season(i,listEpisode));
        }


        return listSeason;
    }
    /** Generate randome future date for LiveStream */
    public static Date generateFutureDate () {
        Date date = new Date ();
        //System.out.println(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, generateNumber(5,30));
        date = c.getTime();
        return date;
    }
    /** Generate randome date for Movies and Series  */
    public static Date generatePastDate () {
        Date date = new Date ();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, generateNumber(0,30));
        c.add(Calendar.MONTH, -generateNumber(5,12));
        c.add(Calendar.YEAR, -generateNumber(0,5));
        date = c.getTime();
        return date;
    }
    /** Generate randome birth date for user */
    public static Date generateBirthdayDate () {
        Date date = new Date ();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, generateNumber(0,30));
        c.add(Calendar.MONTH, -generateNumber(5,12));
        c.add(Calendar.YEAR, -generateNumber(18,60));
        date = c.getTime();
        return date;
    }
    public static Date generateDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
    /** Generate randome product */
    public static Product generateProduct () {
            int type = generateNumber(0,2);
            Product newProduct = null;
            switch (type) {
                case 0 :
                    newProduct = new LiveStream();
                    break;
                case 1:
                    newProduct = new Movie ();
                    break;
                case 2:
                    newProduct = new Series();
                    break;
            }
            return  newProduct;

    }

    public static ArrayList<Product> generateListProduct (Distributor thisDistributor) {
        int amount = generateNumber(0,3);
        ArrayList<Product> listProduct = new ArrayList<Product>();
        for (int i =0; i <amount; i++) {
            int type = generateNumber(0,2);
            switch (type) {
                case 0 :
                    Product newLiveStream = new LiveStream();
                    newLiveStream.setDistributor(thisDistributor);
                    listProduct.add(newLiveStream);
                    ControlPanel.addProduct(newLiveStream);
                    break;
                case 1:
                    Product newMovie = new Movie ();
                    newMovie.setDistributor(thisDistributor);
                    listProduct.add(newMovie);
                    ControlPanel.addProduct(newMovie);
                    break;
                case 2:
                    Product newSeries = new Series();
                    newSeries.setDistributor(thisDistributor);
                    listProduct.add(newSeries);
                    ControlPanel.addProduct(newSeries);
                    break;
            }

        }


        return listProduct;
    }
}