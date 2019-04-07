package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import netflix.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
//----------------------------------------------------------    MOVIE    --------------------------------------------------------------
    @FXML
    public TextField movieTitle;
    public TextField movieDescription;
    public TextField movieDuration;
    public ChoiceBox <String> movieDistributor;
    public TextField movieCountry0;
    public TextField movieCountry1;
    public TextField movieCountry2;
    public TextField movieScore;
    public TextField movieDateProd;
    public TextField movieType;
    public TextField movieActor0;
    public TextField movieActor1;
    public TextField movieActor2;
    public TextField movieURL;
    public TextField moviePrice;
    public TextField movieDateRelease;
    public Label movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12, movie13, movie14;


    @FXML
    public void createMovie() throws InterruptedException {
        movie13.setText("");
        movie14.setText("");
        boolean check = true;
        if ((movieTitle.getText() == null || movieTitle.getText().isEmpty())) {
            movie1.setText("Title Error");
            check = false;
        } else {
            movie1.setText("");
        }
        ;
        if ((movieDescription.getText() == null || movieDescription.getText().isEmpty())) {
            movie2.setText("Description Error");
            check = false;
        } else {
            movie2.setText("");
        }
        ;
        if ((movieDuration.getText() == null || movieDuration.getText().isEmpty() || !movieDuration.getText().matches("-?\\d+(\\.\\d+)?"))) {
            movie3.setText("Duration Error");
            check = false;
        } else {
            movie3.setText("");
        }
        ;
        if ((movieCountry0.getText() == null || movieCountry0.getText().isEmpty() || !movieCountry0.getText().matches("[a-zA-Z ]+") || (!movieCountry1.getText().isEmpty() && !movieCountry1.getText().matches("[a-zA-Z ]+")) || (!movieCountry2.getText().isEmpty() && !movieCountry2.getText().matches("[a-zA-Z ]+")))) {
            movie5.setText("Country Error");
            check = false;
        } else {
            movie5.setText("");
        }
        ;
        if ((movieScore.getText() == null || movieScore.getText().isEmpty() || !movieScore.getText().matches("\\d+(\\.\\d+)?"))) {
            movie6.setText("Score Error");
            check = false;
        } else {
            movie6.setText("");
        }
        ;
        if ((movieDateProd.getText() == null || movieDateProd.getText().isEmpty() || !movieDateProd.getText().matches("\\d{2}-?\\d{2}-?\\d{4}"))) {
            movie7.setText("Date Error [dd-MM-yyyy]");
            check = false;
        } else {
            movie7.setText("");
        }
        ;
        if ((movieType.getText() == null || movieType.getText().isEmpty() || !movieType.getText().matches("[a-zA-Z]+"))) {
            movie8.setText("Type Error");
            check = false;
        } else {
            movie8.setText("");
        }
        ;
        if ((movieActor0.getText() == null || movieActor0.getText().isEmpty() || !movieActor0.getText().matches("[a-zA-Z ]+") || (!movieActor1.getText().isEmpty() && !movieActor1.getText().matches("[a-zA-Z ]+")) || (!movieActor2.getText().isEmpty() && !movieActor2.getText().matches("[a-zA-Z ]+")))) {
            movie9.setText("Actors Error");
            check = false;
        } else {
            movie9.setText("");
        }
        ;
        if ((movieURL.getText() == null || movieURL.getText().isEmpty())) {
            movie10.setText("URL Error");
            check = false;
        } else {
            movie10.setText("");
        }
        ;
        if ((moviePrice.getText() == null || moviePrice.getText().isEmpty() || !moviePrice.getText().matches("\\d+(\\.\\d+)?"))) {
            movie11.setText("Price Error");
            check = false;
        } else {
            movie11.setText("");
        }
        ;
        if ((movieDateRelease.getText() == null || movieDateRelease.getText().isEmpty() || !movieDateRelease.getText().matches("\\d+(\\.\\d+)?"))) {
            movie12.setText("Date Error [number]");
            check = false;
        } else {
            movie12.setText("");
        }
        ;


        if (check == true) {
            movie13.setText("New movie on list!");
            Movie controllerMovie = new Movie(movieTitle.getText(), movieDescription.getText(), Integer.parseInt(movieDuration.getText()), ControlPanel.searchDistributor(movieDistributor.getSelectionModel().getSelectedItem()),
                    new String[]{movieCountry0.getText(), movieCountry1.getText(), movieCountry2.getText()}, Integer.parseInt(movieScore.getText()), RandomFill.generateDate(movieDateProd.getText()), movieType.getText(),
                    new String[]{movieActor0.getText(), movieActor1.getText(), movieActor2.getText()}, movieURL.getText(), Double.parseDouble(moviePrice.getText()), Integer.parseInt(movieDateRelease.getText()));
            ControlPanel.addProduct(controllerMovie);

            items.add(movieTitle.getText());
            itemsID.add(controllerMovie.getIndexProduct());
            listProd.setItems(items);

            movieTitle.clear();
            movieDescription.clear();
            movieDuration.clear();
            movieCountry0.clear();
            movieCountry1.clear();
            movieCountry2.clear();
            movieScore.clear();
            movieDateProd.clear();
            movieType.clear();
            movieActor0.clear();
            movieActor1.clear();
            movieActor2.clear();
            movieURL.clear();
            moviePrice.clear();
            movieDateRelease.clear();
            movieDistributor.getSelectionModel().selectFirst();
//            TimeUnit.SECONDS.sleep(2);
//            movie13.setText("");
        }


    }

    @FXML
    public void createRandomMovie() throws InterruptedException {
        movie14.setText("New random movie on list!");
        Movie controllerRandomMovie = new Movie();
        ControlPanel.addProduct(controllerRandomMovie);

        items.add(controllerRandomMovie.getTitle());
        itemsID.add(controllerRandomMovie.getIndexProduct());
        listProd.setItems(items);
//        TimeUnit.SECONDS.sleep(2);
//        movie14.setText("");
    }
    //----------------------------------------------------------    LIVE STREAM    --------------------------------------------------------------
    @FXML
    public TextField liveTitle;
    public TextField liveDescription;
    public TextField liveDuration;
    public ChoiceBox <String> liveDistributor;
    public TextField liveCountry;
    public TextField liveScore;
    public TextField liveDate;
    public TextField livePrice;

    public Label live1, live2, live3, live4, live5, live6, live7, live8, live9, live10;

    @FXML
    public void createLiveStream() throws InterruptedException {
        live9.setText("");
        live10.setText("");
        boolean check = true;
        if ((liveTitle.getText() == null || liveTitle.getText().isEmpty())) {
            live1.setText("Title Error");
            check = false;
        } else {
            live1.setText("");
        };
        if ((liveDescription.getText() == null || liveDescription.getText().isEmpty())) {
            live2.setText("Description Error");
            check = false;
        } else {
            live2.setText("");
        };
        if ((liveDuration.getText() == null || liveDuration.getText().isEmpty() || !liveDuration.getText().matches("-?\\d+(\\.\\d+)?"))) {
            live3.setText("Duration Error");
            check = false;
        } else {
            live3.setText("");
        };
        if ((liveCountry.getText() == null || liveCountry.getText().isEmpty() || !liveCountry.getText().matches("[a-zA-Z ]+") )) {
            live5.setText("Country Error");
            check = false;
        } else {
            live5.setText("");
        };
        if ((liveScore.getText() == null || liveScore.getText().isEmpty() || !liveScore.getText().matches("\\d+(\\.\\d+)?"))) {
            live6.setText("Score Error");
            check = false;
        } else {
            live6.setText("");
        };
        if ((liveDate.getText() == null || liveDate.getText().isEmpty() || !liveDate.getText().matches("\\d{2}-?\\d{2}-?\\d{4}"))) {
            live7.setText("Date Error [dd-MM-yyyy]");
            check = false;
        } else {
            live7.setText("");
        };
        if ((livePrice.getText() == null || livePrice.getText().isEmpty() || !livePrice.getText().matches("\\d+(\\.\\d+)?"))) {
            live8.setText("Price Error");
            check = false;
        } else {
            live8.setText("");
        };



        if (check == true) {
            live9.setText("New liveStream on list!");
            LiveStream controllerLiveStream = new LiveStream(liveTitle.getText(), liveDescription.getText(), Integer.parseInt(liveDuration.getText()), ControlPanel.searchDistributor(liveDistributor.getSelectionModel().getSelectedItem()),
                    new String[]{liveCountry.getText()}, Integer.parseInt(liveScore.getText()), RandomFill.generateDate(liveDate.getText()), Double.parseDouble(livePrice.getText() ));
            ControlPanel.addProduct(controllerLiveStream);

            items.add(liveTitle.getText());
            itemsID.add(controllerLiveStream.getIndexProduct());
            listProd.setItems(items);

            liveTitle.clear();
            liveDescription.clear();
            liveDuration.clear();
            liveCountry.clear();
            liveScore.clear();
            liveDate.clear();
            livePrice.clear();
            liveDistributor.getSelectionModel().selectFirst();
//            TimeUnit.SECONDS.sleep(2);
//            movie13.setText("");
        }
    }

    @FXML
    public void createRandomLiveStream() throws InterruptedException {
        live10.setText("New random liveStream on list!");
        LiveStream controllerRandomLiveStream = new LiveStream();
        ControlPanel.addProduct(controllerRandomLiveStream);

        items.add(controllerRandomLiveStream.getTitle());
        itemsID.add(controllerRandomLiveStream.getIndexProduct());
        listProd.setItems(items);
//        TimeUnit.SECONDS.sleep(2);
//        movie14.setText("");
    }
    //----------------------------------------------------------    SERIES    --------------------------------------------------------------
    @FXML
    public TextField seriesTitle;
    public TextField seriesDescription;
    public TextField seriesDuration;
    public ChoiceBox <String> seriesDistributor;
    public TextField seriesCountry0;
    public TextField seriesCountry1;
    public TextField seriesCountry2;
    public TextField seriesScore;
    public TextField seriesDateProd;
    public TextField seriesType;
    public TextField seriesActor0;
    public TextField seriesActor1;
    public TextField seriesActor2;
    public TextField seriesPrice;
    public TextField seriesSeasonNum;
    public TextField seriesEpisodeNum;
    public TextField seriesDateRelease;
    public TextField seriesFrequency;
    public Label series1, series2, series3, series4, series5, series6, series7, series8, series9, series10, series11, series12, series13, series14, series15, series16;

    @FXML
    public void createSeries() throws InterruptedException {
        series15.setText("");
        series16.setText("");
        boolean check = true;
        if ((seriesTitle.getText() == null || seriesTitle.getText().isEmpty())) {
            series1.setText("Title Error");
            check = false;
        } else {
            series1.setText("");
        };
        if ((seriesDescription.getText() == null || seriesDescription.getText().isEmpty())) {
            series2.setText("Description Error");
            check = false;
        } else {
            series2.setText("");
        };
        if ((seriesDuration.getText() == null || seriesDuration.getText().isEmpty() || !seriesDuration.getText().matches("-?\\d+(\\.\\d+)?"))) {
            series3.setText("Duration Error");
            check = false;
        } else {
            series3.setText("");
        };
        if ((seriesCountry0.getText() == null || seriesCountry0.getText().isEmpty() || !seriesCountry0.getText().matches("[a-zA-Z ]+") || (!seriesCountry1.getText().isEmpty() && !seriesCountry1.getText().matches("[a-zA-Z ]+")) || (!seriesCountry2.getText().isEmpty() && !seriesCountry2.getText().matches("[a-zA-Z ]+")))) {
            series5.setText("Country Error");
            check = false;
        } else {
            series5.setText("");
        };
        if ((seriesScore.getText() == null || seriesScore.getText().isEmpty() || !seriesScore.getText().matches("\\d+(\\.\\d+)?"))) {
            series6.setText("Score Error");
            check = false;
        } else {
            series6.setText("");
        };
        if ((seriesDateProd.getText() == null || seriesDateProd.getText().isEmpty() || !seriesDateProd.getText().matches("\\d{2}-?\\d{2}-?\\d{4}"))) {
            series7.setText("Date Error [dd-MM-yyyy]");
            check = false;
        } else {
            series7.setText("");
        };
        if ((seriesType.getText() == null || seriesType.getText().isEmpty() || !seriesType.getText().matches("[a-zA-Z]+"))) {
            series8.setText("Type Error");
            check = false;
        } else {
            series8.setText("");
        };
        if ((seriesActor0.getText() == null || seriesActor0.getText().isEmpty() || !seriesActor0.getText().matches("[a-zA-Z ]+") || (!seriesActor1.getText().isEmpty() && !seriesActor1.getText().matches("[a-zA-Z ]+")) || (!seriesActor2.getText().isEmpty() && !seriesActor2.getText().matches("[a-zA-Z ]+")))) {
            series9.setText("Actors Error");
            check = false;
        } else {
            series9.setText("");
        };
        if ((seriesPrice.getText() == null || seriesPrice.getText().isEmpty() || !seriesPrice.getText().matches("\\d+(\\.\\d+)?"))) {
            series10.setText("Price Error");
            check = false;
        } else {
            series10.setText("");
        };
        if ((seriesSeasonNum.getText() == null || seriesSeasonNum.getText().isEmpty() || !seriesSeasonNum.getText().matches("\\d+(\\.\\d+)?"))) {
            series11.setText("Seasons Number Error");
            check = false;
        } else {
            series11.setText("");
        };
        if ((seriesEpisodeNum.getText() == null || seriesEpisodeNum.getText().isEmpty() || !seriesEpisodeNum.getText().matches("\\d+(\\.\\d+)?"))) {
            series12.setText("Episodes Number Error");
            check = false;
        } else {
            series12.setText("");
        };
        if ((seriesDateRelease.getText() == null || seriesDateRelease.getText().isEmpty() || !seriesDateProd.getText().matches("\\d{2}-?\\d{2}-?\\d{4}"))) {
            series13.setText("Date Error [dd-MM-yyyy]");
            check = false;
        } else {
            series13.setText("");
        };
        if ((seriesFrequency.getText() == null || seriesFrequency.getText().isEmpty() || !seriesFrequency.getText().matches("\\d+(\\.\\d+)?"))) {
            series14.setText("Frequency Error");
            check = false;
        } else {
            series14.setText("");
        };


        if (check == true) {
            series15.setText("New series on list!");
            ArrayList<Season> listSeason = RandomFill.generateListSeason(Integer.parseInt(seriesSeasonNum.getText()), Integer.parseInt(seriesEpisodeNum.getText()),
                    Integer.parseInt(seriesDuration.getText()), Integer.parseInt(seriesFrequency.getText()), RandomFill.generateDate(seriesDateRelease.getText()));

            Series controllerSeries = new Series(seriesTitle.getText(), seriesDescription.getText(), Integer.parseInt(seriesDuration.getText()), ControlPanel.searchDistributor(seriesDistributor.getSelectionModel().getSelectedItem()),
                    new String[]{seriesCountry0.getText(), seriesCountry1.getText(), seriesCountry2.getText()}, Integer.parseInt(seriesScore.getText()), RandomFill.generateDate(seriesDateProd.getText()),
                    seriesType.getText(), new String[]{seriesActor0.getText(), seriesActor1.getText(), seriesActor2.getText()}, Double.parseDouble(seriesPrice.getText()), listSeason );
            ControlPanel.addProduct(controllerSeries);

            items.add(seriesTitle.getText());
            itemsID.add(controllerSeries.getIndexProduct());
            listProd.setItems(items);

            seriesTitle.clear();
            seriesDescription.clear();
            seriesDuration.clear();
            seriesCountry0.clear();
            seriesCountry1.clear();
            seriesCountry2.clear();
            seriesScore.clear();
            seriesDateProd.clear();
            seriesType.clear();
            seriesActor0.clear();
            seriesActor1.clear();
            seriesActor2.clear();
            seriesPrice.clear();
            seriesSeasonNum.clear();
            seriesEpisodeNum.clear();
            seriesDateRelease.clear();
            seriesFrequency.clear();
            seriesDistributor.getSelectionModel().selectFirst();
//            TimeUnit.SECONDS.sleep(2);
//            movie13.setText("");
        }


    }
    @FXML
    public void createRandomSeries() throws InterruptedException {
        series16.setText("New random series on list!");
        Series controllerRandomSeries = new Series();
        ControlPanel.addProduct(controllerRandomSeries);

        items.add(controllerRandomSeries.getTitle());
        itemsID.add(controllerRandomSeries.getIndexProduct());
        listProd.setItems(items);
//        TimeUnit.SECONDS.sleep(2);
//        movie14.setText("");
    }



    //----------------------------------------------------------    USER    --------------------------------------------------------------
    public ListView<String> listProd = new ListView<String>();
    public ListView<String> listDist = new ListView<String>();
    public ListView<String> listUser = new ListView<String>();
    public ListView<String> listSub = new ListView<String>();
    ObservableList<String> items = FXCollections.observableArrayList ();
    public ArrayList<Integer> itemsID = new ArrayList<>();
    private int currentItemID;
    ObservableList<String> itemsD = FXCollections.observableArrayList ();
    ObservableList<String> itemsU = FXCollections.observableArrayList ();
    ObservableList<String> itemsS = FXCollections.observableArrayList ();

    ObservableList<String> userSubscriptionList = FXCollections.observableArrayList("Unsubscribe", "Basic", "Familly", "Premium");
    ObservableList<String> checkList = FXCollections.observableArrayList();

    @FXML
    public TextField userName;
    public TextField userSurname;
    public TextField userBirth;
    public TextField userEmail;
    public TextField userCardNum;
    public ChoiceBox <String> userSubscription;
    public Label user1, user2, user3, user4, user5, user6, user7, user8;
    public ImageView picture;

    @FXML
    private void initialize() {
        userSubscription.setValue("Basic");
        userSubscription.setItems(userSubscriptionList);
//        for (int i =0; i < ControlPanel.distributorSize(); i++) {         //wstawiłem wszystko do funkcji makeObjList z tego wzgledu żeby po wcisnieciu odswiezalo wszystkieChoiceBoxy z dystrybutorem
//            checkList.add(ControlPanel.getDistributor(i).getNameDistributor());
//        }
//        movieDistributor.setItems(checkList);
//        movieDistributor.getSelectionModel().selectFirst();
//        seriesDistributor.setItems(checkList);
//        seriesDistributor.getSelectionModel().selectFirst();
//        liveDistributor.setItems(checkList);
//        liveDistributor.getSelectionModel().selectFirst();
        makeObjLists();
    }

    public void deleteProduct () {
        try{
            ControlPanel.deleteListProduct(listProd.getSelectionModel().getSelectedIndex());
            makeObjLists();
        }catch (NumberFormatException ex) {
            //handle exception here
        }

    }
    public void deleteUser () {
        try{
            ControlPanel.deleteListUser(listUser.getSelectionModel().getSelectedIndex());
            makeObjLists();
        }catch (NumberFormatException ex) {
            //handle exception here
        }
    }
    public void deleteDistributor () {
        try{
            ControlPanel.deleteListDistributor(listDist.getSelectionModel().getSelectedIndex());
            makeObjLists();
        }catch (NumberFormatException ex) {
            //handle exception here
        }

    }
    @FXML
    public TextField priceProd;

    public void clickListProduct () {
        priceProd.setText(Double.toString(ControlPanel.getListProduct().get(listProd.getSelectionModel().getSelectedIndex()).getPrice()));
        info.setText(ControlPanel.getListProduct().get(listProd.getSelectionModel().getSelectedIndex()).toString());
        File file = new File(ControlPanel.getListProduct().get(listProd.getSelectionModel().getSelectedIndex()).getImage());
        picture.setImage(new Image(file.toURI().toString()));
        currentItemID = itemsID.get(listProd.getSelectionModel().getSelectedIndex());
    }
    public void changePriceProduct () {
        try{
            double setNumber = Double.valueOf(priceProd.getText());
            ControlPanel.getListSubscription().get(listSub.getSelectionModel().getSelectedIndex()).setPriceSubscription(setNumber);
        }catch (NumberFormatException ex) {
            //handle exception here
        }
    }
    @FXML
    public TextField priceSub;

    public void clickListSubscribtion () {
        priceSub.setText(Double.toString(ControlPanel.getSubscription(listSub.getSelectionModel().getSelectedIndex()).getPriceSubscription()));
        info.setText(ControlPanel.getListSubscription().get(listSub.getSelectionModel().getSelectedIndex()).toString());
        picture.setImage(null);
    }
    public void changePriceSubscribtion () {
        try{
            double setNumber = Double.valueOf(priceSub.getText());
            ControlPanel.getListSubscription().get(listSub.getSelectionModel().getSelectedIndex()).setPriceSubscription(setNumber);
        }catch (NumberFormatException ex) {
            //handle exception here
        }
    }
    @FXML
    public void clickListUser () {
        info.setText(ControlPanel.getListUser().get(listUser.getSelectionModel().getSelectedIndex()).toString());
        picture.setImage(null);
    }

    public void clickListDistributor () {
        info.setText(ControlPanel.getListDistributor().get(listDist.getSelectionModel().getSelectedIndex()).toString());
        picture.setImage(null);
    }


    public void makeObjLists () {
        itemsID.clear();
        items.clear();
        for (int i =0; i<ControlPanel.ProductSize(); i++)
        {
            itemsID.add(ControlPanel.getListProduct().get(i).getIndexProduct());
            items.add(ControlPanel.getListProduct().get(i).getTitle());
        }
        listProd.setItems(items);

        itemsD.clear();
        for (int j = 0; j<ControlPanel.distributorSize(); j++) {
            itemsD.add(ControlPanel.getListDistributor().get(j).getNameDistributor());
        }
        listDist.setItems(itemsD);

        itemsU.clear();
        for (int j = 0; j<ControlPanel.userSize(); j++) {
            itemsU.add(ControlPanel.getListUser().get(j).getUserName() + " " + ControlPanel.getListUser().get(j).getUserSurname());
        }
        listUser.setItems(itemsU);

        itemsS.clear();
        for (int j = 0; j<ControlPanel.sizeSubscription(); j++) {
            itemsS.add(ControlPanel.getListSubscription().get(j).getNameSubscription());
        }
        listSub.setItems(itemsS);

        checkList.clear();
        for (int i =0; i < ControlPanel.distributorSize(); i++) {
            checkList.add(ControlPanel.getDistributor(i).getNameDistributor());
        }
        movieDistributor.setItems(checkList);
        movieDistributor.getSelectionModel().selectFirst();
        seriesDistributor.setItems(checkList);
        seriesDistributor.getSelectionModel().selectFirst();
        liveDistributor.setItems(checkList);
        liveDistributor.getSelectionModel().selectFirst();
    }

    @FXML
    public void createUser() throws InterruptedException {
        user8.setText("");
        user7.setText("");
        boolean check = true;
        if ((userName.getText() == null || userName.getText().isEmpty())) {
            user1.setText("Name Error");
            check = false;
        } else {
            user1.setText("");
        };
        if ((userSurname.getText() == null || userSurname.getText().isEmpty())) {
            user2.setText("Surname Error");
            check = false;
        } else {
            user2.setText("");
        };
        if ((userBirth.getText() == null || userBirth.getText().isEmpty() || !userBirth.getText().matches("\\d{2}-?\\d{2}-?\\d{4}"))) {
            user3.setText("Date Error [dd-MM-yyyy]");
            check = false;
        } else {
            user3.setText("");
        };
        if ((userEmail.getText() == null || userEmail.getText().isEmpty())) {
            user4.setText("Email Error");
            check = false;
        } else {
            user4.setText("");
        };
        if ((userCardNum.getText() == null || userCardNum.getText().isEmpty() || !userCardNum.getText().matches("\\d{16}"))) {
            user5.setText("Card number Error [16digits]");
            check = false;
        } else {
            user5.setText("");
        };



        if (check == true) {
            user7.setText("New series on list!");
            User controllerUser = new User(userName.getText(), userSurname.getText(), RandomFill.generateDate(userBirth.getText()), userEmail.getText(), Long.parseLong(userCardNum.getText()),
                    ControlPanel.getSubscription(userSubscription.getSelectionModel().getSelectedIndex()));
            ControlPanel.addUser(controllerUser);

            userName.clear();
            userSurname.clear();
            userBirth.clear();
            userEmail.clear();
            userCardNum.clear();
            userSubscription.setValue("Basic");
        }
    }

    @FXML
    public void createRandomUser() throws InterruptedException {
        user8.setText("New random user on list!");
        User controllerRandomUser = new User();
        ControlPanel.addUser(controllerRandomUser);
//        TimeUnit.SECONDS.sleep(2);
//        movie14.setText("");
    }

    //----------------------------------------------------------    DISTRIBUTOR    --------------------------------------------------------------
    @FXML
    public TextField distributorName;
    public TextField distributorAccount;
    public TextField distributorPerView;
    public TextField distributorPerMonth;
    public Label distributor1, distributor2, distributor3, distributor4, distributor5, distributor6;


    @FXML
    public void createDistributor() throws InterruptedException {
        distributor6.setText("");
        distributor5.setText("");
        boolean check = true;
        if ((distributorName.getText() == null || distributorName.getText().isEmpty())) {
            distributor1.setText("Name Error");
            check = false;
        } else {
            distributor1.setText("");
        };
        if ((distributorAccount.getText() == null || distributorAccount.getText().isEmpty() || !distributorAccount.getText().matches("\\d{1}") )) {
            distributor2.setText("Account Error [16digits]");
            check = false;
        } else {
            distributor2.setText("");
        };
        if ((distributorPerView.getText() == null || distributorPerView.getText().isEmpty() || !distributorPerView.getText().matches("^\\d+(\\.\\d{0,2})?"))) {
            distributor3.setText("Digit Error");
            check = false;
        } else {
            distributor3.setText("");
        };
        if ((distributorPerMonth.getText() == null || distributorPerMonth.getText().isEmpty() || !distributorPerMonth.getText().matches("^\\d+(\\.\\d{0,2})?") )) {
            distributor4.setText("Digit Error");
            check = false;
        } else {
            distributor4.setText("");
        };

        if (check == true) {
            user5.setText("New distributor on list!");
            Distributor controllerDistributor = new Distributor(distributorName.getText(), Long.parseLong(distributorAccount.getText()),
                    Double.parseDouble(distributorPerView.getText()), Double.parseDouble(distributorPerMonth.getText()));
            ControlPanel.addDistributor(controllerDistributor);

            checkList.add(distributorName.getText());
            movieDistributor.setItems(checkList);
            seriesDistributor.setItems(checkList);
            liveDistributor.setItems(checkList);

            distributorName.clear();
            distributorAccount.clear();
            distributorPerView.clear();
            distributorPerMonth.clear();
        }

    }

    @FXML
    public void createRandomDistributor() throws InterruptedException {
        distributor6.setText("New random distributor on list!");
        Distributor controllerRandomDistributor = new Distributor();
        ControlPanel.addRandomDistributor(controllerRandomDistributor);

        checkList.add(controllerRandomDistributor.getNameDistributor());
        movieDistributor.setItems(checkList);
        seriesDistributor.setItems(checkList);
        liveDistributor.setItems(checkList);

        items.clear();
        itemsID.clear();
        for (int i =0; i<ControlPanel.ProductSize(); i++)
        {
            items.add(ControlPanel.getListProduct().get(i).getTitle());
            itemsID.add(ControlPanel.getListProduct().get(i).getIndexProduct());
        }
        listProd.setItems(items);
//        TimeUnit.SECONDS.sleep(2);
//        movie14.setText("");
    }

    @FXML
    public ListView<String> listTitle = new ListView<String>();
    public ArrayList<Integer> listIndex;
    public TextField findText;
    public Label info;

    public void find () {
        listIndex = new ArrayList<>();
        ObservableList<String> items = FXCollections.observableArrayList ();
        for (int i =0; i<ControlPanel.ProductSize(); i++)
        {
            if (ControlPanel.getListProduct().get(i).getTitle().toLowerCase().contains(findText.getText().toLowerCase())) {
                items.add(ControlPanel.getListProduct().get(i).getTitle());
                itemsID.add(ControlPanel.getListProduct().get(i).getIndexProduct());
                listIndex.add(ControlPanel.getListProduct().get(i).getIndexProduct());
                continue;
            }
            String[] actors = ControlPanel.getListProduct().get(i).getActors();
            if (actors != null) {
                for (int j = 0; j<actors.length; j++){
                if(actors[j].toLowerCase().contains(findText.getText().toLowerCase())) {
                    items.add(ControlPanel.getListProduct().get(i).getTitle());
                    itemsID.add(ControlPanel.getListProduct().get(i).getIndexProduct());
                    listIndex.add(ControlPanel.getListProduct().get(i).getIndexProduct());
                    break;
                }

            }
            }

        }
        listTitle.setItems(items);
    }


    public void click () {
        for (int i =0; i<ControlPanel.ProductSize(); i++) {
            if (ControlPanel.getListProduct().get(i).getIndexProduct() == listIndex.get(listTitle.getSelectionModel().getSelectedIndex()) ) {
                info.setText(ControlPanel.getListProduct().get(i).toString());
                File file = new File(ControlPanel.getListProduct().get(i).getImage());
                picture.setImage(new Image(file.toURI().toString()));
                currentItemID = itemsID.get(listProd.getSelectionModel().getSelectedIndex());
                break;
            }
        }
//        info.setText(listIndex.get(listTitle.getSelectionModel().getSelectedIndex()) +"");
//        //info.setText(ControlPanel.listProduct.get(listIndex.get(listTitle.getSelectionModel().getSelectedIndex())).toString());
    }
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    LineChart chartWindow = new LineChart<String, Number>(xAxis, yAxis);

    public void chartSetUp () {


        Product chartProduct = ControlPanel.findProductByIndex(currentItemID);


            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            LineChart<String, Number> chartWindow = new LineChart<String, Number>(xAxis, yAxis);

            XYChart.Series series = new XYChart.Series();
            series.setName(chartProduct.getTitle());
            //populating the series with data

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");
            for (int i = 0; i<chartProduct.getWatchViewsSize(); i++)
            {
                series.getData().add(new XYChart.Data( String.format(dateFormat.format(chartProduct.getWatchDateElement(i))), chartProduct.getWatchViewsElement(i)));

            }

           Scene scene  = new Scene(chartWindow,500,300);
            chartWindow.getData().add(series);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();




    }

    public void makeSerialization () throws IOException {
        ControlPanel.writeToFile();

    }
    public void stopProgram () {
        System.exit(0);
    }


}



