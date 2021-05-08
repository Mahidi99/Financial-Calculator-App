package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Financial_Calculator_App extends Application {
    Stage window;
    Stage keyboardStage = new Stage();
    Scene sceneGoApp, sceneHome, sceneCompound, sceneCompoundFutureValue, sceneCompoundPresentValue,
            sceneCompoundPeriod, sceneCompoundPMT, sceneSaving, sceneSavingFutureValue, sceneSavingPresentValue,
            sceneSavingInterest, sceneSavingPeriod, sceneMortgage, sceneMortgagePMT, sceneMortgagePeriod,
            sceneLoan, sceneLoanPMT, sceneLoanAmount, sceneLoanTerm, sceneHistory;



    @Override
    public void start(Stage primaryStage) {

        ///////////////////////////////////////// GO ////////////////////////////////////////////

        window = primaryStage;
        window.setTitle("Financial Calculator App");

        GridPane grid = new GridPane(); // Creating a new grid pane
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setVgap(10);

        grid.setPadding(new Insets(0, 1, 5, 1));
        Image backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        BackgroundImage theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

//       create Background
        Background background = new Background(theme);
        grid.setBackground(background);


        Image imgLogo = new Image(getClass().getResourceAsStream("Logo1.png"));
        Label Logo = new Label("", new ImageView(imgLogo));

        grid.add(Logo, 3, 3);


//        Go Button
        Image Go = new Image(getClass().getResourceAsStream("goApp.png")); //Adding an image into a button
        Button GoApp = new Button("", new ImageView(Go));
        GoApp.setFont(Font.font(18));
        grid.add(GoApp, 3, 9);

//        Go Action Event
        GoApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                window.setScene(sceneHome);
            }

        });

        sceneGoApp = new Scene(grid, 600, 400);    //Set Scene


        ////////////////////////////////////////////////// H O M E ///////////////////////////////////////////////

        GridPane gridHome = new GridPane();
        gridHome.setAlignment(Pos.TOP_CENTER);
        gridHome.setVgap(10);

        gridHome.setPadding(new Insets(0, 1, 5, 1));

//        Background Image
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridHome.setBackground(background);


        Image imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Button Goback = new Button("", new ImageView(imgBack));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridHome.add(Goback, 2, 1);
        Goback.setOnAction(event -> window.setScene(sceneGoApp));

        Image imgQuit = new Image(getClass().getResourceAsStream("quit.png"));
        Button quit = new Button("", new ImageView(imgQuit));
        gridHome.add(quit, 6, 1);
        quit.setOnAction(event -> System.exit(0));

        Image imgHomeLogo = new Image(getClass().getResourceAsStream("HomeLogo.png"));
        Logo = new Label("", new ImageView(imgHomeLogo));
        gridHome.add(Logo, 3, 2);

        Image imgCompound = new Image(getClass().getResourceAsStream("Comp1.png")); //compound saving
        Button Compoundbtn = new Button("", new ImageView(imgCompound));
        gridHome.add(Compoundbtn, 3, 10);
        Compoundbtn.setOnAction(event -> window.setScene(sceneCompound));

        Image imgSaving = new Image(getClass().getResourceAsStream("sav1.png")); //savings
        Button Savingbtn = new Button("", new ImageView(imgSaving));
        gridHome.add(Savingbtn, 3, 15);
        Savingbtn.setOnAction(event -> window.setScene(sceneSaving));

        Image imgMort = new Image(getClass().getResourceAsStream("mort1.png")); // mortgage
        Button Mortgagebtn = new Button("", new ImageView(imgMort));
        gridHome.add(Mortgagebtn, 5, 10);
        Mortgagebtn.setOnAction(event -> window.setScene(sceneMortgage));

        Image imgLoan = new Image(getClass().getResourceAsStream("loan1.png")); // loan
        Button Loanbtn = new Button("", new ImageView(imgLoan));
        gridHome.add(Loanbtn, 5, 15);
        Loanbtn.setOnAction(event -> window.setScene(sceneLoan));

        Image imgHistory = new Image(getClass().getResourceAsStream("history1.png")); //History
        Button Historybtn = new Button("", new ImageView(imgHistory));
        gridHome.add(Historybtn, 3, 20);
        Historybtn.setOnAction(event -> window.setScene(sceneHistory));

        Image imgHelp = new Image(getClass().getResourceAsStream("help1.png")); //Help Centre
        Button Helpbtn = new Button("", new ImageView(imgHelp));
        gridHome.add(Helpbtn, 5, 20);
        Helpbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert HelpAlert = new Alert(Alert.AlertType.INFORMATION);
                HelpAlert.setTitle("Help View");
                HelpAlert.setHeaderText(null);
                HelpAlert.setContentText("There are 4 main calculator parts in this Financial Calculator App.\n" +
                        "They are compound saving, simple saving, loan and mortgage.\n Here you can click the " +
                        "button related to parameter that you want to find and go to the each calculation page.\n In compound " +
                        "calculator there are 4 categories related to 4 parameters. They are no of periods, " +
                        "future value, present value, payment.\n In saving calculator there are 4 categories; " +
                        "present value, future value and no of periods. In loan calculator there are 3 buttons that " +
                        "you can click and go. They are loan amount, loan term and PMT.\n" +
                        "In mortgage calculator you can find loan term and monthly payment.\n" +
                        " Here you can find one known parameter by giving " +
                        "other parameters in each category.\n As an example; If you want to find the present value of " +
                        "compound saving calculator you should click the present value button in compound page and " +
                        "and then should give the parameters; future value, interest, no of periods and PMT.\n\n" +
                        "This is same also in other calculator categories !");

                HelpAlert.showAndWait();
            }
        });


        sceneHome = new Scene(gridHome, 1200, 700);


        //////////////////////////////////////////// Compound Saving //////////////////////////////////////////////

        GridPane gridCompoundSaving = new GridPane();
        gridCompoundSaving.setAlignment(Pos.TOP_CENTER);
        gridCompoundSaving.setVgap(10);

        gridCompoundSaving.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridCompoundSaving.setBackground(background);

        Image imgBack1 = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack1));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridCompoundSaving.add(Goback, 2, 1);
        Goback.setOnAction(event -> window.setScene(sceneHome));


        Image imgCompoundL = new Image(getClass().getResourceAsStream("ComLogo.png"));
        Label Logo1 = new Label("", new ImageView(imgCompoundL));
        gridCompoundSaving.add(Logo1, 4, 2);

        Image CompoundImg1 = new Image(getClass().getResourceAsStream("future.png"));
        Button CompoundFutureValue = new Button("", new ImageView(CompoundImg1));
        CompoundFutureValue.setFont(Font.font(20));
        gridCompoundSaving.add(CompoundFutureValue, 4, 8);
        CompoundFutureValue.setOnAction(event -> window.setScene(sceneCompoundFutureValue));  //Change Scene to CompoundFutureValue On Button Click


        Image CompoundImg2 = new Image(getClass().getResourceAsStream("present.png"));
        Button CompoundPresentValue = new Button("", new ImageView(CompoundImg2));
        CompoundPresentValue.setFont(Font.font(20));
        gridCompoundSaving.add(CompoundPresentValue, 4, 10);
        CompoundPresentValue.setOnAction(event -> window.setScene(sceneCompoundPresentValue));  //Change Scene to CompoundPresentValue on Button Click


        Image CompoundImg4 = new Image(getClass().getResourceAsStream("periods.png"));
        Button CompoundPeriods = new Button("", new ImageView(CompoundImg4));
        CompoundPeriods.setFont(Font.font(20));
        gridCompoundSaving.add(CompoundPeriods, 6, 8);
        CompoundPeriods.setOnAction(event -> window.setScene(sceneCompoundPeriod));  //Change Scene to CompoundPeriods on Button Click

        Image CompoundImg5 = new Image(getClass().getResourceAsStream("PMT.png"));
        Button CompoundPMT = new Button("", new ImageView(CompoundImg5));
        CompoundPMT.setFont(Font.font(20));
        gridCompoundSaving.add(CompoundPMT, 6, 10);
        CompoundPMT.setOnAction(event -> window.setScene(sceneCompoundPMT));  //Change Scene to Add Vinyl on Butt

        sceneCompound = new Scene(gridCompoundSaving, 1400, 700);

        ////////////////////////////////////// Compound - Future Value /////////////////////////////////////////////



        GridPane gridCompoundFuture = new GridPane();
        gridCompoundFuture.setAlignment(Pos.TOP_CENTER);
        gridCompoundFuture.setVgap(10);

        gridCompoundFuture.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridCompoundFuture.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridCompoundFuture.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneCompound)); //change scene to Compound on click button

        Image CompoundImg7 = new Image(getClass().getResourceAsStream("futureLogo.png")); //logo of compound future value page
        Label CompoundFLogo = new Label("", new ImageView(CompoundImg7));
        gridCompoundFuture.add(CompoundFLogo, 3, 1);

        Label CompoundPresentValue4 = new Label("Present Value : ");  // Label of Present Value
        CompoundPresentValue4.setFont(Font.font(20));
        gridCompoundFuture.add(CompoundPresentValue4, 1, 5);


        TextField InputCompoundPresentValue4 = new TextField("");   // Textfield of the user input of Compound present value
        InputCompoundPresentValue4.setPromptText("Rs.");
        InputCompoundPresentValue4.setOnMouseClicked(event -> {
            keyboard(InputCompoundPresentValue4);
            keyboardStage.show();
                });
        gridCompoundFuture.add(InputCompoundPresentValue4, 2, 5);


        Label CompoundInterest1 = new Label("Interest Rate : "); // Label of Interest Rate
        CompoundInterest1.setFont(Font.font(20));
        gridCompoundFuture.add(CompoundInterest1, 1, 7);

        TextField InputCompoundInterest1 = new TextField(""); // Textfield of the user input of interest
        InputCompoundInterest1.setPromptText("\t\t\t\t%");
        InputCompoundInterest1.setOnMouseClicked(event -> {
            keyboard(InputCompoundInterest1);
            keyboardStage.show();
        });
        gridCompoundFuture.add(InputCompoundInterest1, 2, 7);

        Label CompoundPeriod1 = new Label("No of Periods : ");
        CompoundPeriod1.setFont(Font.font(20));
        gridCompoundFuture.add(CompoundPeriod1, 1, 9);

        TextField InputCompoundPeriod1 = new TextField(""); // Textfield of the user input of Compound periods
        InputCompoundPeriod1.setPromptText("years");
        InputCompoundPeriod1.setOnMouseClicked(event -> {
            keyboard(InputCompoundPeriod1);
            keyboardStage.show();
        });
        gridCompoundFuture.add(InputCompoundPeriod1, 2, 9);

        Label CompoundPMT1 = new Label("PMT : ");
        CompoundPMT1.setFont(Font.font(20));
        gridCompoundFuture.add(CompoundPMT1, 1, 11);

        TextField InputCompoundPMT1 = new TextField(""); // Textfield of the user input of Compound PMT
        InputCompoundPMT1.setPromptText("Rs.");
        InputCompoundPMT1.setOnMouseClicked(event -> {
            keyboard(InputCompoundPMT1);
            keyboardStage.show();
        });
        gridCompoundFuture.add(InputCompoundPMT1, 2, 11);


        // ------OUTPUTS------ //

        Label PresentValue2 = new Label("Present Value : "); // Label of Present value
        PresentValue2.setFont(Font.font(20));
        gridCompoundFuture.add(PresentValue2, 5, 5);

        Label OutputPresentValue2 = new Label("");  // Answer of present value
        OutputPresentValue2.setFont(Font.font(20));
        gridCompoundFuture.add(OutputPresentValue2, 6, 5);

        Label FutureValue2 = new Label("Future Value : "); // Label of Future value
        FutureValue2.setFont(Font.font(20));
        gridCompoundFuture.add(FutureValue2, 5, 7);

        Label OutputFutureValue2 = new Label(""); // Answer of future value
        OutputFutureValue2.setFont(Font.font(20));
        gridCompoundFuture.add(OutputFutureValue2, 6, 7);

        Label NoOfPayments2 = new Label("No of Periods : "); // Label of No of Payments
        NoOfPayments2.setFont(Font.font(20));
        gridCompoundFuture.add(NoOfPayments2, 5, 9);

        Label OutputNoOfPayments2 = new Label(""); // Answer of No of Payments
        OutputNoOfPayments2.setFont(Font.font(20));
        gridCompoundFuture.add(OutputNoOfPayments2, 6, 9);

        Label Interest2 = new Label("Interest Rate : "); // Label of Interest
        Interest2.setFont(Font.font(20));
        gridCompoundFuture.add(Interest2, 5, 11);

        Label OutputInterest2 = new Label(""); // Answer of Interest
        OutputInterest2.setFont(Font.font(20));
        gridCompoundFuture.add(OutputInterest2, 6, 11);

        Label PMT2 = new Label("PMT : "); // Label of PMT
        PMT2.setFont(Font.font(20));
        gridCompoundFuture.add(PMT2, 5, 13);

        Label OutputPMT2 = new Label(""); // Answer of PMT
        OutputPMT2.setFont(Font.font(20));
        gridCompoundFuture.add(OutputPMT2, 6, 13);

        // Calculating Present Value
        Image Calc4 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button CompoundCalc1 = new Button("", new ImageView(Calc4)); //creating the calculate button
        gridCompoundFuture.add(CompoundCalc1, 1, 15);

        CompoundCalc1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double P = Double.valueOf(InputCompoundPresentValue4.getText());
                Double r = Double.valueOf(InputCompoundInterest1.getText());
                Double t = Double.valueOf(InputCompoundPeriod1.getText());
                Double PMT = Double.valueOf(InputCompoundPMT1.getText());
                Double A = P * (Math.pow(1 + (r / 1200), 12 * t)) + (PMT * (Math.pow((1 + r / 1200), 12 * t) - 1) / (r / 1200)); // A = Future Value

                //for formatting to two decimal places
                DecimalFormat dec = new DecimalFormat("#.00");
                Double A1 = Double.valueOf(dec.format(A));

                OutputFutureValue2.setText(String.valueOf("Rs. " + A1));
                OutputPresentValue2.setText(String.valueOf("Rs. " + P));
                OutputInterest2.setText(String.valueOf(r + "%"));
                OutputNoOfPayments2.setText(String.valueOf(t + " years"));
                OutputPMT2.setText(String.valueOf("Rs. " + PMT));

                try{
                    LocalTime CompoundTime = LocalTime.now();
                    LocalDate CompoundDate = LocalDate.now();
                    FileWriter CompoundData = new FileWriter("Text.txt");
                    CompoundData.write("\n" +"Compound Saving" +"\n" + "Date : " + CompoundDate +"\n" +
                            "Time :" + CompoundTime +"\n" + "Compound Future Value : Rs." + A +"\n" +
                            "Compound Interest Rate: " + r +"\n" + "Compound Period: " + t
                            +"\n" +"Compound Present Value : $" + P);
                    CompoundData.close();

                    File record = new File("Text.txt");
                    Scanner scan = new Scanner(record);
                    while (scan.hasNextLine()){
                        String data = scan.nextLine();
                    }
                    scan.close();
                } catch (Exception e) {
                    Alert dataAlert = new Alert(Alert.AlertType.ERROR);
                    dataAlert.setHeaderText("Something went wrong");
                    dataAlert.setContentText("Press Ok and try again");
                    dataAlert.showAndWait();
                }
            }
        });


        sceneCompoundFutureValue = new Scene(gridCompoundFuture, 1300, 700);


        ////////////////////////////////////// Compound - Periods /////////////////////////////////////////////////



        GridPane gridCompoundPeriod = new GridPane();  //creating a new grid pane to compound period
        gridCompoundPeriod.setAlignment(Pos.TOP_CENTER);
        gridCompoundPeriod.setVgap(10);

        gridCompoundPeriod.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridCompoundPeriod.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridCompoundPeriod.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneCompound));

        Image CompoundImg9 = new Image(getClass().getResourceAsStream("periodLogo.png")); //logo
        Label CompoundPerLogo = new Label("", new ImageView(CompoundImg9));
        gridCompoundPeriod.add(CompoundPerLogo, 3, 1);

        Label CompoundPresentValue3 = new Label("Present Value : ");  // Label of present value
        CompoundPresentValue3.setFont(Font.font(20));
        gridCompoundPeriod.add(CompoundPresentValue3, 1, 5);

        TextField InputCompoundPresentValue3 = new TextField("");   // Textfield of the user input of present value
        InputCompoundPresentValue3.setPromptText("Rs.");
        InputCompoundPresentValue3.setOnMouseClicked(event -> {
            keyboard(InputCompoundPresentValue3);
            keyboardStage.show();
        });
        gridCompoundPeriod.add(InputCompoundPresentValue3, 2, 5);


        Label CompoundInterest3 = new Label("Interest Rate : "); // Label of compound interest
        CompoundInterest3.setFont(Font.font(20));
        gridCompoundPeriod.add(CompoundInterest3, 1, 7);

        TextField InputCompoundInterest3 = new TextField(""); // Textfield of the user input of compound interest
        InputCompoundInterest3.setPromptText("\t\t\t\t%");
        InputCompoundInterest3.setOnMouseClicked(event -> {
            keyboard(InputCompoundInterest3);
            keyboardStage.show();
        });
        gridCompoundPeriod.add(InputCompoundInterest3, 2, 7);


        Label CompoundFuture3 = new Label("Future Value : ");
        CompoundFuture3.setFont(Font.font(20));
        gridCompoundPeriod.add(CompoundFuture3, 1, 9);

        TextField InputCompoundFuture3 = new TextField(""); //// Textfield of the user input of future value
        InputCompoundFuture3.setPromptText("Rs.");
        InputCompoundFuture3.setOnMouseClicked(event -> {
            keyboard(InputCompoundFuture3);
            keyboardStage.show();
        });
        gridCompoundPeriod.add(InputCompoundFuture3, 2, 9);

        Label CompoundPMT3 = new Label("PMT : ");
        CompoundPMT3.setFont(Font.font(20));
        gridCompoundPeriod.add(CompoundPMT3, 1, 11);

        TextField InputCompoundPMT3 = new TextField(""); // Textfield of the user input of PMT
        InputCompoundPMT3.setPromptText("Rs.");
        InputCompoundPMT3.setOnMouseClicked(event -> {
            keyboard(InputCompoundPMT3);
            keyboardStage.show();
        });
        gridCompoundPeriod.add(InputCompoundPMT3, 2, 11);


        // ------OUTPUTS------ //

        Label PresentValue4 = new Label("Present Value : "); // Label of present value
        PresentValue4.setFont(Font.font(20));
        gridCompoundPeriod.add(PresentValue4, 5, 5);

        Label OutputPresentValue4 = new Label("");  // Answer of present value
        OutputPresentValue4.setFont(Font.font(20));
        gridCompoundPeriod.add(OutputPresentValue4, 6, 5);

        Label FutureValue4 = new Label("Future Value : "); // Label of future value
        FutureValue4.setFont(Font.font(20));
        gridCompoundPeriod.add(FutureValue4, 5, 7);

        Label OutputFutureValue4 = new Label(""); // Answer of future value
        OutputFutureValue4.setFont(Font.font(20));
        gridCompoundPeriod.add(OutputFutureValue4, 6, 7);

        Label NoOfPayments4 = new Label("No of Periods : "); // Label of no of Payments
        NoOfPayments4.setFont(Font.font(20));
        gridCompoundPeriod.add(NoOfPayments4, 5, 9);

        Label OutputNoOfPayments4 = new Label(""); // Answer of no of Payments
        OutputNoOfPayments4.setFont(Font.font(20));
        gridCompoundPeriod.add(OutputNoOfPayments4, 6, 9);

        Label Interest4 = new Label("Interest Rate : "); // Label of Interest
        Interest4.setFont(Font.font(20));
        gridCompoundPeriod.add(Interest4, 5, 11);

        Label OutputInterest4 = new Label(""); // Answer of Interest
        OutputInterest4.setFont(Font.font(20));
        gridCompoundPeriod.add(OutputInterest4, 6, 11);

        Label PMT4 = new Label("PMT : "); // Label of PMT
        PMT4.setFont(Font.font(20));
        gridCompoundPeriod.add(PMT4, 5, 13);

        Label OutputPMT4 = new Label(""); // Answer of PMT
        OutputPMT4.setFont(Font.font(20));
        gridCompoundPeriod.add(OutputPMT4, 6, 13);

        // Calculating No of period
        Image Calc6 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button CompoundCalc3 = new Button("", new ImageView(Calc6));
        gridCompoundPeriod.add(CompoundCalc3, 1, 15);

        //  Calculation for No of Periods
        CompoundCalc3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputCompoundFuture3.getText());
                Double P = Double.valueOf(InputCompoundPresentValue3.getText());
                Double r = Double.valueOf(InputCompoundInterest3.getText());
                Double PMT = Double.valueOf(InputCompoundPMT3.getText());
                Double t = Math.log((1 - ((r * P) / (100 * PMT))) / (Math.log(1 + (r / 100)) * 12)); // t = No of Periods

                OutputPresentValue4.setText(String.valueOf("Rs. " + P));
                OutputFutureValue4.setText(String.valueOf("Rs." + A));
                OutputInterest4.setText(String.valueOf(r + "%"));
                OutputNoOfPayments4.setText(String.valueOf(t + " years"));
                OutputPMT4.setText(String.valueOf("Rs. " + PMT));
            }
        });

        sceneCompoundPeriod = new Scene(gridCompoundPeriod, 1300, 700);


        ////////////////////////////////////// Compound - Payment(PMT) /////////////////////////////////////////////



        GridPane gridCompoundPMT = new GridPane(); //creating a new grid pane to Compound PMT
        gridCompoundPMT.setAlignment(Pos.TOP_CENTER);
        gridCompoundPMT.setVgap(10);

        gridCompoundPMT.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridCompoundPMT.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridCompoundPMT.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneCompound)); //change scene to compound on click button

        Image CompoundImg10 = new Image(getClass().getResourceAsStream("PMTlogo.png")); //logo of compound PMT page
        Label CompoundPMTLogo = new Label("", new ImageView(CompoundImg10));
        gridCompoundPMT.add(CompoundPMTLogo, 3, 1);

        Label CompoundPresentValue5 = new Label("Present Value : ");  // Label of present value
        CompoundPresentValue5.setFont(Font.font(20));
        gridCompoundPMT.add(CompoundPresentValue5, 1, 5);

        TextField InputCompoundPresentValue5 = new TextField("");   // Textfield of the user input of present value
        InputCompoundPresentValue5.setPromptText("Rs.");
        InputCompoundPresentValue5.setOnMouseClicked(event -> {
            keyboard(InputCompoundPresentValue5);
            keyboardStage.show();
        });
        gridCompoundPMT.add(InputCompoundPresentValue5, 2, 5);


        Label CompoundInterest5 = new Label("Interest Rate : "); // Label of interest rate
        CompoundInterest5.setFont(Font.font(20));
        gridCompoundPMT.add(CompoundInterest5, 1, 7);

        TextField InputCompoundInterest5 = new TextField(""); // Textfield of the user input of interest
        InputCompoundInterest5.setPromptText("\t\t\t\t%");
        InputCompoundInterest5.setOnMouseClicked(event -> {
            keyboard(InputCompoundInterest5);
            keyboardStage.show();
        });
        gridCompoundPMT.add(InputCompoundInterest5, 2, 7);

        Label CompoundFuture5 = new Label("Future Value : ");
        CompoundFuture5.setFont(Font.font(20));
        gridCompoundPMT.add(CompoundFuture5, 1, 9);

        TextField InputCompoundFuture5 = new TextField(""); // Textfield of the user input of future value
        InputCompoundFuture5.setPromptText("Rs.");
        InputCompoundFuture5.setOnMouseClicked(event -> {
            keyboard(InputCompoundFuture5);
            keyboardStage.show();
        });
        gridCompoundPMT.add(InputCompoundFuture5, 2, 9);

        Label CompoundPeriod5 = new Label("No of Periods : ");
        CompoundPeriod5.setFont(Font.font(20));
        gridCompoundPMT.add(CompoundPeriod5, 1, 11);

        TextField InputCompoundPeriod5 = new TextField(""); // Textfield of the user input of no of periods
        InputCompoundPeriod5.setPromptText("years");
        InputCompoundPeriod5.setOnMouseClicked(event -> {
            keyboard(InputCompoundPeriod5);
            keyboardStage.show();
        });
        gridCompoundPMT.add(InputCompoundPeriod5, 2, 11);


        // ------OUTPUTS------ //

        Label PresentValue5 = new Label("Present Value : "); // Label of present value
        PresentValue5.setFont(Font.font(20));
        gridCompoundPMT.add(PresentValue5, 5, 5);

        Label OutputPresentValue5 = new Label("");  // Answer of present value
        OutputPresentValue5.setFont(Font.font(20));
        gridCompoundPMT.add(OutputPresentValue5, 6, 5);

        Label FutureValue5 = new Label("Future Value : "); // Label of future value
        FutureValue5.setFont(Font.font(20));
        gridCompoundPMT.add(FutureValue5, 5, 7);

        Label OutputFutureValue5 = new Label(""); // Answer of future value
        OutputFutureValue5.setFont(Font.font(20));
        gridCompoundPMT.add(OutputFutureValue5, 6, 7);

        Label NoOfPayments5 = new Label("No of Periods : "); // Label of no of periods
        NoOfPayments5.setFont(Font.font(20));
        gridCompoundPMT.add(NoOfPayments5, 5, 9);

        Label OutputNoOfPayments5 = new Label(""); // Answer of no of periods
        OutputNoOfPayments5.setFont(Font.font(20));
        gridCompoundPMT.add(OutputNoOfPayments5, 6, 9);

        Label Interest5 = new Label("Interest Rate : "); // Label of Interest
        Interest5.setFont(Font.font(20));
        gridCompoundPMT.add(Interest5, 5, 11);

        Label OutputInterest5 = new Label(""); // Answer of Interest
        OutputInterest5.setFont(Font.font(20));
        gridCompoundPMT.add(OutputInterest5, 6, 11);

        Label PMT5 = new Label("PMT : "); // Label of PMT
        PMT5.setFont(Font.font(20));
        gridCompoundPMT.add(PMT5, 5, 13);

        Label OutputPMT5 = new Label(""); // Answer of PMT
        OutputPMT5.setFont(Font.font(20));
        gridCompoundPMT.add(OutputPMT5, 6, 13);

        // Calculating PMT
        Image Calc7 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button CompoundCalc5 = new Button("", new ImageView(Calc7));
        gridCompoundPMT.add(CompoundCalc5, 1, 15);

        //  Calculation for PMT
        CompoundCalc5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputCompoundFuture5.getText());
                Double P = Double.valueOf(InputCompoundPresentValue5.getText());
                Double r = Double.valueOf(InputCompoundInterest5.getText());
                Double t = Double.valueOf(InputCompoundPeriod5.getText());
                Double PMT = A / ((Math.pow(1 + r / 1200, 12 * t) - 1) / (r / 1200)); // PMT = Payment

                //for formatting to two decimal places
                DecimalFormat dec = new DecimalFormat("#.00");
                Double PMT1 = Double.valueOf(dec.format(PMT));

                OutputPresentValue5.setText(String.valueOf("Rs. " + P));
                OutputFutureValue5.setText(String.valueOf("Rs. " + A));
                OutputInterest5.setText(String.valueOf(r + "%"));
                OutputNoOfPayments5.setText(String.valueOf(t + " years"));
                OutputPMT5.setText(String.valueOf("Rs. " + PMT1));
            }
        });

        sceneCompoundPMT = new Scene(gridCompoundPMT, 1300, 700);


        ///////////////////////////////////// Compound - Present Value ///////////////////////////////////////////////



        GridPane gridCompoundPresent = new GridPane(); //creating a new grid pane to compound present value
        gridCompoundPresent.setAlignment(Pos.TOP_CENTER);
        gridCompoundPresent.setVgap(10);

        gridCompoundPresent.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridCompoundPresent.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridCompoundPresent.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneCompound));

        Image CompoundImg6 = new Image(getClass().getResourceAsStream("PresentLogo.png")); //logo of compound present value page
        Label CompoundPLogo = new Label("", new ImageView(CompoundImg6));
        gridCompoundPresent.add(CompoundPLogo, 3, 1);

        Label CompoundFutureValue4 = new Label("Future Value : ");  // Label of future value
        CompoundFutureValue4.setFont(Font.font(20));
        gridCompoundPresent.add(CompoundFutureValue4, 1, 5);

        TextField InputCompoundFutureValue4 = new TextField("");   // Textfield of the user input of future value
        InputCompoundFutureValue4.setPromptText("Rs.");
        InputCompoundFutureValue4.setOnMouseClicked(event -> {
            keyboard(InputCompoundFutureValue4);
            keyboardStage.show();
        });
        gridCompoundPresent.add(InputCompoundFutureValue4, 2, 5);


        Label CompoundInterest4 = new Label("Interest Rate : "); // Label of interest
        CompoundInterest4.setFont(Font.font(20));
        gridCompoundPresent.add(CompoundInterest4, 1, 7);

        TextField InputCompoundInterest4 = new TextField("");
        InputCompoundInterest4.setPromptText("\t\t\t\t%");
        InputCompoundInterest4.setOnMouseClicked(event -> {
            keyboard(InputCompoundInterest4);
            keyboardStage.show();
        });
        gridCompoundPresent.add(InputCompoundInterest4, 2, 7);

        Label CompoundPeriod4 = new Label("No of Periods : ");
        CompoundPeriod4.setFont(Font.font(20));
        gridCompoundPresent.add(CompoundPeriod4, 1, 9);

        TextField InputCompoundPeriod4 = new TextField("");
        InputCompoundPeriod4.setPromptText("years");
        InputCompoundPeriod4.setOnMouseClicked(event -> {
            keyboard(InputCompoundPeriod4);
            keyboardStage.show();
        });
        gridCompoundPresent.add(InputCompoundPeriod4, 2, 9);

        Label CompoundPMT4 = new Label("PMT : ");
        CompoundPMT4.setFont(Font.font(20));
        gridCompoundPresent.add(CompoundPMT4, 1, 11);

        TextField InputCompoundPMT4 = new TextField("");
        InputCompoundPMT4.setPromptText("Rs.");
        InputCompoundPMT4.setOnMouseClicked(event -> {
            keyboard(InputCompoundPMT4);
            keyboardStage.show();
        });
        gridCompoundPresent.add(InputCompoundPMT4, 2, 11);


        // ------OUTPUTS------ //

        Label PresentValue1 = new Label("Present Value : "); // Label of present value
        PresentValue1.setFont(Font.font(20));
        gridCompoundPresent.add(PresentValue1, 5, 5);

        Label OutputPresentValue1 = new Label("");  // Answer of present value
        OutputPresentValue1.setFont(Font.font(20));
        gridCompoundPresent.add(OutputPresentValue1, 6, 5);

        Label FutureValue1 = new Label("Future Value : "); // Label of future value
        FutureValue1.setFont(Font.font(20));
        gridCompoundPresent.add(FutureValue1, 5, 7);

        Label OutputFutureValue1 = new Label(""); // Answer of future value
        OutputFutureValue1.setFont(Font.font(20));
        gridCompoundPresent.add(OutputFutureValue1, 6, 7);

        Label NoOfPayments1 = new Label("No of Periods : "); // Label of Total of no of periods
        NoOfPayments1.setFont(Font.font(20));
        gridCompoundPresent.add(NoOfPayments1, 5, 9);

        Label OutputNoOfPayments1 = new Label(""); // Answer of Total of no of periods
        OutputNoOfPayments1.setFont(Font.font(20));
        gridCompoundPresent.add(OutputNoOfPayments1, 6, 9);

        Label Interest1 = new Label("Interest Rate : "); // Label of Interest
        Interest1.setFont(Font.font(20));
        gridCompoundPresent.add(Interest1, 5, 11);

        Label OutputInterest1 = new Label(""); // Answer of Interest
        OutputInterest1.setFont(Font.font(20));
        gridCompoundPresent.add(OutputInterest1, 6, 11);

        Label PMT1 = new Label("PMT : "); // Label of PMT
        PMT1.setFont(Font.font(20));
        gridCompoundPresent.add(PMT1, 5, 13);

        Label OutputPMT1 = new Label(""); // Answer of PMT
        OutputPMT1.setFont(Font.font(20));
        gridCompoundPresent.add(OutputPMT1, 6, 13);

        // Calculating Present Value
        Image Calc3 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button CompoundCalc4 = new Button("", new ImageView(Calc3));
        gridCompoundPresent.add(CompoundCalc4, 1, 15);

        //  Calculation for Present Value
        CompoundCalc4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputCompoundFutureValue4.getText());
                Double r = Double.valueOf(InputCompoundInterest4.getText());
                Double t = Double.valueOf(InputCompoundPeriod4.getText());
                Double PMT = Double.valueOf(InputCompoundPMT4.getText());
                Double P = (A - (PMT * (Math.pow((1 + r / 1200), 12 * t) - 1) / (r / 1200))) / (Math.pow(1 + (r / 1200), 12 * t)); // P = Present Value

                //for formatting to two decimal places
                DecimalFormat dec2 = new DecimalFormat("#.00");
                Double P2 = Double.valueOf(dec2.format(P));

                OutputPresentValue1.setText(String.valueOf("Rs. " + P2));
                OutputFutureValue1.setText(String.valueOf("Rs. " + A));
                OutputInterest1.setText(String.valueOf(r + "%"));
                OutputNoOfPayments1.setText(String.valueOf(t + " years"));
                OutputPMT1.setText(String.valueOf("Rs. " + PMT));
            }
        });

        sceneCompoundPresentValue = new Scene(gridCompoundPresent, 1300, 700);


        //////////////////////////////////////////// L O A N ////////////////////////////////////////



        GridPane gridLoan = new GridPane(); //creating a new grid pane to loan calculator
        gridLoan.setAlignment(Pos.TOP_CENTER);
        gridLoan.setVgap(10);

        gridLoan.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridLoan.setBackground(background);

        //Back Button
        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridLoan.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneHome));

        Image imgCD = new Image(getClass().getResourceAsStream("LoanLogo.png")); //
        Label LogoCD = new Label("", new ImageView(imgCD));
        gridLoan.add(LogoCD, 3, 2);

        Image imgLoan1 = new Image(getClass().getResourceAsStream("PMT.png"));
        Button btnLoanPMT = new Button("", new ImageView(imgLoan1));
        gridLoan.add(btnLoanPMT, 1, 10);
        btnLoanPMT.setOnAction(event -> window.setScene(sceneLoanPMT));


        Image imgLoan2 = new Image(getClass().getResourceAsStream("amount.png"));
        Button btnLoanAmount = new Button("", new ImageView(imgLoan2));
        btnLoanAmount.setFont(Font.font(20));
        gridLoan.add(btnLoanAmount, 3, 10);
        btnLoanAmount.setOnAction(event -> window.setScene(sceneLoanAmount));

        Image imgLoan3 = new Image(getClass().getResourceAsStream("periods.png"));
        Button btnLoanTerm = new Button("", new ImageView(imgLoan3));
        gridLoan.add(btnLoanTerm, 4, 10);
        btnLoanTerm.setOnAction(event -> window.setScene(sceneLoanTerm));

        sceneLoan = new Scene(gridLoan, 1400, 700);

        ///////////////////////////////////////////////// LOAN - PMT //////////////////////////////////////////////////////

        GridPane gridLoanPMT = new GridPane();
        gridLoanPMT.setAlignment(Pos.TOP_CENTER);
        gridLoanPMT.setVgap(10);


        gridLoanPMT.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridLoanPMT.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridLoanPMT.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneLoan));

        Image imgSortItem = new Image(getClass().getResourceAsStream("PMTlogo.png")); // Logo of Loan
        Logo = new Label("", new ImageView(imgSortItem));
        gridLoanPMT.add(Logo, 2, 1);

        Label L_LoanAmount1 = new Label("Loan Amount : ");  // Label of Home Price
        L_LoanAmount1.setFont(Font.font(20));
        gridLoanPMT.add(L_LoanAmount1, 1, 5);

        TextField InputL_LoanAmount1 = new TextField("");   // Textfield of the user input of Home Price
        InputL_LoanAmount1.setMaxWidth(150);
        InputL_LoanAmount1.setPromptText("Rs.");
        InputL_LoanAmount1.setOnMouseClicked(event -> {
            keyboard(InputL_LoanAmount1);
            keyboardStage.show();
        });
        gridLoanPMT.add(InputL_LoanAmount1, 2, 5);

        Label L_LoanTerm1 = new Label("Loan Term : ");
        L_LoanTerm1.setFont(Font.font(20));
        gridLoanPMT.add(L_LoanTerm1, 1, 7);

        TextField InputL_LoanTerm1 = new TextField("");
        InputL_LoanTerm1.setMaxWidth(150);
        InputL_LoanTerm1.setPromptText("years");
        InputL_LoanTerm1.setOnMouseClicked(event -> {
            keyboard(InputL_LoanTerm1);
            keyboardStage.show();
        });
        gridLoanPMT.add(InputL_LoanTerm1, 2, 7);

        Label L_InterestRate1 = new Label("Interest Rate : ");
        L_InterestRate1.setFont(Font.font(20));
        gridLoanPMT.add(L_InterestRate1, 1, 9);

        TextField InputL_InterestRate1 = new TextField("");
        InputL_InterestRate1.setMaxWidth(150);
        InputL_InterestRate1.setPromptText("\t\t\t%");
        InputL_InterestRate1.setOnMouseClicked(event -> {
            keyboard(InputL_InterestRate1);
            keyboardStage.show();
        });
        gridLoanPMT.add(InputL_InterestRate1, 2, 9);


        // ------OUTPUTS------ //

        Label LbLoanAmount1 = new Label("Loan Amount : "); // Label of Home Price
        LbLoanAmount1.setFont(Font.font(20));
        gridLoanPMT.add(LbLoanAmount1, 5, 5);

        Label OutputL_LoanAmount1 = new Label("");  // Home Price in Outputs
        OutputL_LoanAmount1.setFont(Font.font(20));
        gridLoanPMT.add(OutputL_LoanAmount1, 6, 5);

        Label LbInterestRate1 = new Label("Interest Rate : "); // Label of Interest Rate
        LbInterestRate1.setFont(Font.font(20));
        gridLoanPMT.add(LbInterestRate1, 5, 7);

        Label OutputL_InterestRate1 = new Label(""); // Answer of Interest Rate
        OutputL_InterestRate1.setFont(Font.font(20));
        gridLoanPMT.add(OutputL_InterestRate1, 6, 7);

        Label LbLoanTerm1 = new Label("Loan Term : "); // Label of Number of Payments
        LbLoanTerm1.setFont(Font.font(20));
        gridLoanPMT.add(LbLoanTerm1, 5, 9);

        Label OutputL_LoanTerm1 = new Label(""); // Answer of Number of Payments
        OutputL_LoanTerm1.setFont(Font.font(20));
        gridLoanPMT.add(OutputL_LoanTerm1, 6, 9);

        Label LbMonthlyPayment1 = new Label("PMT : "); // Label of Number of Payments
        LbMonthlyPayment1.setFont(Font.font(20));
        gridLoanPMT.add(LbMonthlyPayment1, 5, 11);

        Label OutputL_MonthlyPayment1 = new Label(""); // Answer of Number of Payments
        OutputL_MonthlyPayment1.setFont(Font.font(20));
        gridLoanPMT.add(OutputL_MonthlyPayment1, 6, 11);


        Image CalcL_PMT = new Image(getClass().getResourceAsStream("calculate.png")); // Calculate Button
        Button LoanCalculatePMT = new Button("", new ImageView(CalcL_PMT));
        gridLoanPMT.add(LoanCalculatePMT, 1, 19);

        //  Calculation for Monthly payment of Loan
        LoanCalculatePMT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double PV = Double.valueOf(InputL_LoanAmount1.getText());
                Double t = Double.valueOf(InputL_LoanTerm1.getText());
                Double r = Double.valueOf(InputL_InterestRate1.getText());
                Double PMT = (PV * r) / (1 - (1 / Math.pow((1 + r), t)));
                ; // PMT = Monthly Payment

                //for formatting to two decimal places
                DecimalFormat dec = new DecimalFormat("#.00");
                Double PMT1 = Double.valueOf(dec.format(PMT));

                OutputL_MonthlyPayment1.setText(String.valueOf("Rs. " + PMT1));
                OutputL_LoanAmount1.setText(String.valueOf("Rs." + PV));
                OutputL_InterestRate1.setText(String.valueOf(r + "%"));
                OutputL_LoanTerm1.setText(String.valueOf(t + " years"));
            }
        });
        sceneLoanPMT = new Scene(gridLoanPMT, 1400, 700);


        ///////////////////////////////////////////////// LOAN - Amount //////////////////////////////////////////////////////

        GridPane gridLoanAmount = new GridPane();
        gridLoanAmount.setAlignment(Pos.TOP_CENTER);
        gridLoanAmount.setVgap(10);


        gridLoanAmount.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridLoanAmount.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridLoanAmount.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneLoan));

        Image imgLoanAmount = new Image(getClass().getResourceAsStream("AmountLogo.png")); // Logo of Loan
        Logo = new Label("", new ImageView(imgLoanAmount));
        gridLoanAmount.add(Logo, 2, 1);

        Label L_LoanPMT2 = new Label("PMT : ");  // Label of Home Price
        L_LoanPMT2.setFont(Font.font(20));
        gridLoanAmount.add(L_LoanPMT2, 1, 5);

        TextField InputL_LoanPMT2 = new TextField("");   // Textfield of the user input of Home Price
        InputL_LoanPMT2.setMaxWidth(150);
        InputL_LoanPMT2.setPromptText("Rs.");
        InputL_LoanPMT2.setOnMouseClicked(event -> {
            keyboard(InputL_LoanPMT2);
            keyboardStage.show();
        });
        gridLoanAmount.add(InputL_LoanPMT2, 2, 5);

        Label L_LoanTerm2 = new Label("Loan Term : ");
        L_LoanTerm2.setFont(Font.font(20));
        gridLoanAmount.add(L_LoanTerm2, 1, 7);

        TextField InputL_LoanTerm2 = new TextField("");
        InputL_LoanTerm2.setMaxWidth(150);
        InputL_LoanTerm2.setPromptText("years");
        InputL_LoanTerm2.setOnMouseClicked(event -> {
            keyboard(InputL_LoanTerm2);
            keyboardStage.show();
        });
        gridLoanAmount.add(InputL_LoanTerm2, 2, 7);

        Label L_InterestRate2 = new Label("Interest Rate : ");
        L_InterestRate2.setFont(Font.font(20));
        gridLoanAmount.add(L_InterestRate2, 1, 9);

        TextField InputL_InterestRate2 = new TextField("");
        InputL_InterestRate2.setMaxWidth(150);
        InputL_InterestRate2.setPromptText("\t\t\t%");
        InputL_InterestRate2.setOnMouseClicked(event -> {
            keyboard(InputL_InterestRate2);
            keyboardStage.show();
        });
        gridLoanAmount.add(InputL_InterestRate2, 2, 9);


        // ------OUTPUTS------ //

        Label LbLoanAmount2 = new Label("Loan Amount : "); // Label of Home Price
        LbLoanAmount2.setFont(Font.font(20));
        gridLoanAmount.add(LbLoanAmount2, 5, 5);

        Label OutputL_LoanAmount2 = new Label("");  // Home Price in Outputs
        OutputL_LoanAmount2.setFont(Font.font(20));
        gridLoanAmount.add(OutputL_LoanAmount2, 6, 5);

        Label LbInterestRate2 = new Label("Interest Rate : "); // Label of Interest Rate
        LbInterestRate2.setFont(Font.font(20));
        gridLoanAmount.add(LbInterestRate2, 5, 7);

        Label OutputL_InterestRate2 = new Label(""); // Answer of Interest Rate
        OutputL_InterestRate2.setFont(Font.font(20));
        gridLoanAmount.add(OutputL_InterestRate2, 6, 7);

        Label LbLoanTerm2 = new Label("Loan Term : "); // Label of Number of Payments
        LbLoanTerm2.setFont(Font.font(20));
        gridLoanAmount.add(LbLoanTerm2, 5, 9);

        Label OutputL_LoanTerm2 = new Label(""); // Answer of Number of Payments
        OutputL_LoanTerm2.setFont(Font.font(20));
        gridLoanAmount.add(OutputL_LoanTerm2, 6, 9);

        Label LbMonthlyPayment2 = new Label("PMT : "); // Label of Number of Payments
        LbMonthlyPayment2.setFont(Font.font(20));
        gridLoanAmount.add(LbMonthlyPayment2, 5, 11);

        Label OutputL_MonthlyPayment2 = new Label(""); // Answer of Number of Payments
        OutputL_MonthlyPayment2.setFont(Font.font(20));
        gridLoanAmount.add(OutputL_MonthlyPayment2, 6, 11);


        Image CalcL_Amount = new Image(getClass().getResourceAsStream("calculate.png")); // Calculate Button
        Button LoanCalculateAmount = new Button("", new ImageView(CalcL_Amount));
        gridLoanAmount.add(LoanCalculateAmount, 1, 19);

        //  Calculation for Monthly payment of Loan
        LoanCalculateAmount.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double PMT = Double.valueOf(InputL_LoanPMT2.getText());
                Double t = Double.valueOf(InputL_LoanTerm2.getText());
                Double r = Double.valueOf(InputL_InterestRate2.getText());
                Double PV = (PMT / r) * (1 - (1 / Math.pow((1 + r), t)));
                ; // Amount = Monthly Payment

                //for formatting to two decimal places
                DecimalFormat dec = new DecimalFormat("#.00");
                Double PV1 = Double.valueOf(dec.format(PV));

                OutputL_MonthlyPayment2.setText(String.valueOf("Rs. " + PMT));
                OutputL_LoanAmount2.setText(String.valueOf("Rs." + PV1));
                OutputL_InterestRate2.setText(String.valueOf(r + "%"));
                OutputL_LoanTerm2.setText(String.valueOf(t + " years"));
            }
        });
        sceneLoanAmount = new Scene(gridLoanAmount, 1400, 700);

        ///////////////////////////////////////////////// LOAN - Term //////////////////////////////////////////////////////

        GridPane gridLoanTerm = new GridPane();
        gridLoanTerm.setAlignment(Pos.TOP_CENTER);
        gridLoanTerm.setVgap(10);


        gridLoanTerm.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridLoanTerm.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridLoanTerm.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneLoan));

        Image imgLoanTerm = new Image(getClass().getResourceAsStream("TermLogo.png")); // Logo of Loan
        Logo = new Label("", new ImageView(imgLoanTerm));
        gridLoanTerm.add(Logo, 2, 1);

        Label L_LoanPMT3 = new Label("PMT : ");  // Label of Home Price
        L_LoanPMT3.setFont(Font.font(20));
        gridLoanTerm.add(L_LoanPMT3, 1, 5);

        TextField InputL_LoanPMT3 = new TextField("");   // Textfield of the user input of Home Price
        InputL_LoanPMT3.setMaxWidth(150);
        InputL_LoanPMT3.setPromptText("Rs.");
        InputL_LoanPMT3.setOnMouseClicked(event -> {
            keyboard(InputL_LoanPMT3);
            keyboardStage.show();
        });
        gridLoanTerm.add(InputL_LoanPMT3, 2, 5);

        Label L_LoanAmount3 = new Label("Loan Amount : ");
        L_LoanAmount3.setFont(Font.font(20));
        gridLoanTerm.add(L_LoanAmount3, 1, 7);

        TextField InputL_LoanAmount3 = new TextField("");
        InputL_LoanAmount3.setMaxWidth(150);
        InputL_LoanAmount3.setPromptText("years");
        InputL_LoanAmount3.setOnMouseClicked(event -> {
            keyboard(InputL_LoanAmount3);
            keyboardStage.show();
        });
        gridLoanTerm.add(InputL_LoanAmount3, 2, 7);

        Label L_InterestRate3 = new Label("Interest Rate : ");
        L_InterestRate3.setFont(Font.font(20));
        gridLoanTerm.add(L_InterestRate3, 1, 9);

        TextField InputL_InterestRate3 = new TextField("");
        InputL_InterestRate3.setMaxWidth(150);
        InputL_InterestRate3.setPromptText("\t\t\t%");
        InputL_InterestRate3.setOnMouseClicked(event -> {
            keyboard(InputL_InterestRate3);
            keyboardStage.show();
        });
        gridLoanTerm.add(InputL_InterestRate3, 2, 9);


        // ------OUTPUTS------ //

        Label LbLoanAmount3 = new Label("Loan Amount : "); // Label of Home Price
        LbLoanAmount3.setFont(Font.font(20));
        gridLoanTerm.add(LbLoanAmount3, 5, 5);

        Label OutputL_LoanAmount3 = new Label("");  // Home Price in Outputs
        OutputL_LoanAmount3.setFont(Font.font(20));
        gridLoanTerm.add(OutputL_LoanAmount3, 6, 5);

        Label LbInterestRate3 = new Label("Interest Rate : "); // Label of Interest Rate
        LbInterestRate3.setFont(Font.font(20));
        gridLoanTerm.add(LbInterestRate3, 5, 7);

        Label OutputL_InterestRate3 = new Label(""); // Answer of Interest Rate
        OutputL_InterestRate3.setFont(Font.font(20));
        gridLoanTerm.add(OutputL_InterestRate3, 6, 7);

        Label LbLoanTerm3 = new Label("Loan Term : "); // Label of Number of Payments
        LbLoanTerm3.setFont(Font.font(20));
        gridLoanTerm.add(LbLoanTerm3, 5, 9);

        Label OutputL_LoanTerm3 = new Label(""); // Answer of Number of Payments
        OutputL_LoanTerm3.setFont(Font.font(20));
        gridLoanTerm.add(OutputL_LoanTerm3, 6, 9);

        Label LbMonthlyPayment3 = new Label("PMT : "); // Label of Number of Payments
        LbMonthlyPayment3.setFont(Font.font(20));
        gridLoanTerm.add(LbMonthlyPayment3, 5, 11);

        Label OutputL_MonthlyPayment3 = new Label(""); // Answer of Number of Payments
        OutputL_MonthlyPayment3.setFont(Font.font(20));
        gridLoanTerm.add(OutputL_MonthlyPayment3, 6, 11);


        Image CalcL_Term = new Image(getClass().getResourceAsStream("calculate.png")); // Calculate Button
        Button LoanCalculateTerm = new Button("", new ImageView(CalcL_Term));
        gridLoanTerm.add(LoanCalculateTerm, 1, 19);

        //  Calculation for Monthly payment of Loan
        LoanCalculateTerm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double PMT = Double.valueOf(InputL_LoanPMT3.getText());
                Double PV = Double.valueOf(InputL_LoanAmount3.getText());
                Double r = Double.valueOf(InputL_InterestRate3.getText());
                Double t = Math.log((PMT / r) / ((PMT / r) - PV)) / Math.log(1 + r); // t = Loan Term

                OutputL_MonthlyPayment3.setText(String.valueOf("Rs. " + PMT));
                OutputL_LoanAmount3.setText(String.valueOf("Rs." + PV));
                OutputL_InterestRate3.setText(String.valueOf(r + "%"));
                OutputL_LoanTerm3.setText(String.valueOf(t + " years"));
            }
        });

        sceneLoanTerm = new Scene(gridLoanTerm, 1400, 700);

        /////////////////////////////////////// Simple Saving ///////////////////////////////////////////////



        GridPane gridSimple = new GridPane();
        gridSimple.setAlignment(Pos.TOP_CENTER);
        gridSimple.setVgap(10);

        gridSimple.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridSimple.setBackground(background);


        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridSimple.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneHome));

        Image imgRemove = new Image(getClass().getResourceAsStream("SimpleLogo.png")); // logo
        Label LogoRemove = new Label("", new ImageView(imgRemove));
        gridSimple.add(LogoRemove, 3, 2);

        Image imgSaving1 = new Image(getClass().getResourceAsStream("future.png"));
        Button SavingFutureValue = new Button("", new ImageView(imgSaving1));
        gridSimple.add(SavingFutureValue, 3, 8);
        SavingFutureValue.setOnAction(event -> window.setScene(sceneSavingFutureValue));


        Image imgSaving2 = new Image(getClass().getResourceAsStream("present.png"));
        Button SavingPresentValue = new Button("", new ImageView(imgSaving2));
        SavingPresentValue.setFont(Font.font(20));
        gridSimple.add(SavingPresentValue, 5, 8);
        SavingPresentValue.setOnAction(event -> window.setScene(sceneSavingPresentValue));

        Image imgSaving3 = new Image(getClass().getResourceAsStream("interest.png"));
        Button SavingInterest = new Button("", new ImageView(imgSaving3));
        gridSimple.add(SavingInterest, 3, 10);
        SavingInterest.setOnAction(event -> window.setScene(sceneSavingInterest));


        Image imgSaving4 = new Image(getClass().getResourceAsStream("sav1.png"));
        Button SavingPeriod = new Button("", new ImageView(imgSaving4));
        SavingPeriod.setFont(Font.font(20));
        gridSimple.add(SavingPeriod, 5, 10);
        SavingPeriod.setOnAction(event -> window.setScene(sceneSavingPeriod));

        sceneSaving = new Scene(gridSimple, 1400, 700);

        /////////////////////////////////////Saving - Future Value//////////////////////////////////////////////



        GridPane gridSavingFuture = new GridPane();
        gridSavingFuture.setAlignment(Pos.TOP_CENTER);
        gridSavingFuture.setVgap(10);

        gridSavingFuture.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridSavingFuture.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridSavingFuture.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneSaving));

        Image SavingImg7 = new Image(getClass().getResourceAsStream("futureLogo.png")); //logo of compound present value page
        Label SavingFLogo = new Label("", new ImageView(SavingImg7));
        gridSavingFuture.add(SavingFLogo, 3, 1);

        Label SavingPresentValue1 = new Label("Present Value : ");  // Label of Auto Price
        SavingPresentValue1.setFont(Font.font(20));
        gridSavingFuture.add(SavingPresentValue1, 1, 5);

        TextField InputSavingPresentValue4 = new TextField("");   // Textfield of the user input of Auto Price
        InputSavingPresentValue4.setPromptText("Rs.");
        InputSavingPresentValue4.setOnMouseClicked(event -> {
            keyboard(InputSavingPresentValue4);
            keyboardStage.show();
        });
        gridSavingFuture.add(InputSavingPresentValue4, 2, 5);


        Label SavingInterest1 = new Label("Interest Rate : "); // Label of Loan Term
        SavingInterest1.setFont(Font.font(20));
        gridSavingFuture.add(SavingInterest1, 1, 7);

        TextField InputSavingInterest1 = new TextField("");
        InputSavingInterest1.setPromptText("\t\t\t\t%");
        InputSavingInterest1.setOnMouseClicked(event -> {
            keyboard(InputSavingInterest1);
            keyboardStage.show();
        });
        gridSavingFuture.add(InputSavingInterest1, 2, 7);

        Label SavingPeriod1 = new Label("No of Periods : ");
        SavingPeriod1.setFont(Font.font(20));
        gridSavingFuture.add(SavingPeriod1, 1, 9);

        TextField InputSavingPeriod1 = new TextField("");
        InputSavingPeriod1.setPromptText("years");
        InputSavingPeriod1.setOnMouseClicked(event -> {
            keyboard(InputSavingPeriod1);
            keyboardStage.show();
        });
        gridSavingFuture.add(InputSavingPeriod1, 2, 9);


        // ------OUTPUTS------ //

        Label S_PresentValue2 = new Label("Present Value : "); // Label of Total Loan Amount
        S_PresentValue2.setFont(Font.font(20));
        gridSavingFuture.add(S_PresentValue2, 5, 5);

        Label OutputS_PresentValue2 = new Label("");  // Answer of Total Loan Amount
        OutputS_PresentValue2.setFont(Font.font(20));
        gridSavingFuture.add(OutputS_PresentValue2, 6, 5);

        Label S_FutureValue2 = new Label("Future Value : "); // Label of Upfront Amount
        S_FutureValue2.setFont(Font.font(20));
        gridSavingFuture.add(S_FutureValue2, 5, 7);

        Label OutputS_FutureValue2 = new Label(""); // Answer of Upfront Amount
        OutputS_FutureValue2.setFont(Font.font(20));
        gridSavingFuture.add(OutputS_FutureValue2, 6, 7);

        Label S_NoOfPayments2 = new Label("No of Periods : "); // Label of Total of 60 Loan Payments
        S_NoOfPayments2.setFont(Font.font(20));
        gridSavingFuture.add(S_NoOfPayments2, 5, 9);

        Label OutputS_NoOfPayments2 = new Label(""); // Answer of Total of 60 Loan Payments
        OutputS_NoOfPayments2.setFont(Font.font(20));
        gridSavingFuture.add(OutputS_NoOfPayments2, 6, 9);

        Label S_Interest2 = new Label("Interest Rate : "); // Label of Total Loan Interest
        S_Interest2.setFont(Font.font(20));
        gridSavingFuture.add(S_Interest2, 5, 11);

        Label OutputS_Interest2 = new Label(""); // Answer of Total Loan Interest
        OutputS_Interest2.setFont(Font.font(20));
        gridSavingFuture.add(OutputS_Interest2, 6, 11);

        // Button for Calculating Present Value
        Image CalcS1 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button SavingCalc1 = new Button("", new ImageView(CalcS1));
        gridSavingFuture.add(SavingCalc1, 1, 15);

        //  Calculation for Future Value
        SavingCalc1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double P = Double.valueOf(InputSavingPresentValue4.getText());
                Double r = Double.valueOf(InputSavingInterest1.getText());
                Double t = Double.valueOf(InputSavingPeriod1.getText());
                Double A = P * (Math.pow(1 + (r / 1200), 12 * t)); // A = Future Value
                DecimalFormat dec = new DecimalFormat("#.00");

                Double A1 = Double.valueOf(dec.format(A));  //for formatting to two decimal places
                OutputS_FutureValue2.setText(String.valueOf("Rs." + A1));
                OutputS_PresentValue2.setText(String.valueOf("Rs. " + P));
                OutputS_Interest2.setText(String.valueOf(r + "%"));
                OutputS_NoOfPayments2.setText(String.valueOf(t + " years"));
            }
        });

        sceneSavingFutureValue = new Scene(gridSavingFuture, 1300, 700);


        ///////////////////////////////////////////////Saving - Present Value//////////////////////////////////////////



        GridPane gridSavingPresent = new GridPane();
        gridSavingPresent.setAlignment(Pos.TOP_CENTER);
        gridSavingPresent.setVgap(10);

        gridSavingPresent.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridSavingPresent.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridSavingPresent.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneSaving));

        Image SavingImg6 = new Image(getClass().getResourceAsStream("PresentLogo.png")); //logo of compound present value page
        Label SavingPLogo = new Label("", new ImageView(SavingImg6));
        gridSavingPresent.add(SavingPLogo, 3, 1);

        Label SavingFutureValue4 = new Label("Future Value : ");  // Label of Auto Price
        SavingFutureValue4.setFont(Font.font(20));
        gridSavingPresent.add(SavingFutureValue4, 1, 5);

        TextField InputSavingFutureValue4 = new TextField("");   // Textfield of the user input of Auto Price
        InputSavingFutureValue4.setPromptText("Rs.");
        InputSavingFutureValue4.setOnMouseClicked(event -> {
            keyboard(InputSavingFutureValue4);
            keyboardStage.show();
        });
        gridSavingPresent.add(InputSavingFutureValue4, 2, 5);


        Label SavingInterest4 = new Label("Interest Rate : "); // Label of Loan Term
        SavingInterest4.setFont(Font.font(20));
        gridSavingPresent.add(SavingInterest4, 1, 7);

        TextField InputSavingInterest4 = new TextField("");
        InputSavingInterest4.setPromptText("\t\t\t\t%");
        InputSavingInterest4.setOnMouseClicked(event -> {
            keyboard(InputSavingInterest4);
            keyboardStage.show();
        });
        gridSavingPresent.add(InputSavingInterest4, 2, 7);

        Label SavingPeriod4 = new Label("No of Periods : ");
        SavingPeriod4.setFont(Font.font(20));
        gridSavingPresent.add(SavingPeriod4, 1, 9);

        TextField InputSavingPeriod4 = new TextField("");
        InputSavingPeriod4.setPromptText("years");
        InputSavingPeriod4.setOnMouseClicked(event -> {
            keyboard(InputSavingPeriod4);
            keyboardStage.show();
        });
        gridSavingPresent.add(InputSavingPeriod4, 2, 9);


        // ------OUTPUTS------ //

        Label S_PresentValue1 = new Label("Present Value : "); // Label of Total Loan Amount
        S_PresentValue1.setFont(Font.font(20));
        gridSavingPresent.add(S_PresentValue1, 5, 5);

        Label OutputS_PresentValue1 = new Label("");  // Answer of Total Loan Amount
        OutputS_PresentValue1.setFont(Font.font(20));
        gridSavingPresent.add(OutputS_PresentValue1, 6, 5);

        Label S_FutureValue1 = new Label("Future Value : "); // Label of Upfront Amount
        S_FutureValue1.setFont(Font.font(20));
        gridSavingPresent.add(S_FutureValue1, 5, 7);

        Label OutputS_FutureValue1 = new Label(""); // Answer of Upfront Amount
        OutputS_FutureValue1.setFont(Font.font(20));
        gridSavingPresent.add(OutputS_FutureValue1, 6, 7);

        Label S_NoOfPayments1 = new Label("No of Periods : "); // Label of Total of 60 Loan Payments
        S_NoOfPayments1.setFont(Font.font(20));
        gridSavingPresent.add(S_NoOfPayments1, 5, 9);

        Label OutputS_NoOfPayments1 = new Label(""); // Answer of Total of 60 Loan Payments
        OutputS_NoOfPayments1.setFont(Font.font(20));
        gridSavingPresent.add(OutputS_NoOfPayments1, 6, 9);

        Label S_Interest1 = new Label("Interest Rate : "); // Label of Total Loan Interest
        S_Interest1.setFont(Font.font(20));
        gridSavingPresent.add(S_Interest1, 5, 11);

        Label OutputS_Interest1 = new Label(""); // Answer of Total Loan Interest
        OutputS_Interest1.setFont(Font.font(20));
        gridSavingPresent.add(OutputS_Interest1, 6, 11);


        // Calculating Present Value
        Image Calc8 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button SavingCalc4 = new Button("", new ImageView(Calc8));
        gridSavingPresent.add(SavingCalc4, 1, 15);

        //  Calculation for Present Value
        SavingCalc4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputSavingFutureValue4.getText());
                Double r = Double.valueOf(InputSavingInterest4.getText());
                Double t = Double.valueOf(InputSavingPeriod4.getText());
                Double P = A / (Math.pow(1 + (r / 1200), 12 * t)); // P = Present Value

                //for formatting to two decimal places
                DecimalFormat dec2 = new DecimalFormat("#.00");
                Double P2 = Double.valueOf(dec2.format(P));

                OutputS_PresentValue1.setText(String.valueOf("Rs. " + P2));
                OutputS_FutureValue1.setText(String.valueOf("Rs." + A));
                OutputS_Interest1.setText(String.valueOf(r + "%"));
                OutputS_NoOfPayments1.setText(String.valueOf(t + " years"));
            }
        });


        sceneSavingPresentValue = new Scene(gridSavingPresent, 1300, 700);


        ///////////////////////////////////// Saving - Interest Rate //////////////////////////////////////////////



        GridPane gridSavingInterest = new GridPane();
        gridSavingInterest.setAlignment(Pos.TOP_CENTER);
        gridSavingInterest.setVgap(10);

        gridSavingInterest.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridSavingInterest.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridSavingInterest.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneSaving));

        Image SavingImg8 = new Image(getClass().getResourceAsStream("InterestLogo.png")); //logo of compound present value page
        Label SavingILogo = new Label("", new ImageView(SavingImg8));
        gridSavingInterest.add(SavingILogo, 3, 1);

        Label SavingPresentValue2 = new Label("Present Value : ");  // Label of Auto Price
        SavingPresentValue2.setFont(Font.font(20));
        gridSavingInterest.add(SavingPresentValue2, 1, 5);

        TextField InputSavingPresentValue2 = new TextField("");   // Textfield of the user input of Auto Price
        InputSavingPresentValue2.setPromptText("Rs.");
        InputSavingPresentValue2.setOnMouseClicked(event -> {
            keyboard(InputSavingPresentValue2);
            keyboardStage.show();
        });
        gridSavingInterest.add(InputSavingPresentValue2, 2, 5);


        Label SavingFuture2 = new Label("Future Value : "); // Label of Loan Term
        SavingFuture2.setFont(Font.font(20));
        gridSavingInterest.add(SavingFuture2, 1, 7);

        TextField InputSavingFuture2 = new TextField("");
        InputSavingFuture2.setPromptText("Rs.");
        InputSavingFuture2.setOnMouseClicked(event -> {
            keyboard(InputSavingFuture2);
            keyboardStage.show();
        });
        gridSavingInterest.add(InputSavingFuture2, 2, 7);

        Label SavingPeriod2 = new Label("No of Periods : ");
        SavingPeriod2.setFont(Font.font(20));
        gridSavingInterest.add(SavingPeriod2, 1, 9);

        TextField InputSavingPeriod2 = new TextField("");
        InputSavingPeriod2.setPromptText("years");
        InputSavingPeriod2.setOnMouseClicked(event -> {
            keyboard(InputSavingPeriod2);
            keyboardStage.show();
        });
        gridSavingInterest.add(InputSavingPeriod2, 2, 9);


        // ------OUTPUTS------ //

        Label S_PresentValue3 = new Label("Present Value : "); // Label of Total Loan Amount
        S_PresentValue3.setFont(Font.font(20));
        gridSavingInterest.add(S_PresentValue3, 5, 5);

        Label OutputS_PresentValue3 = new Label("");  // Answer of Total Loan Amount
        OutputS_PresentValue3.setFont(Font.font(20));
        gridSavingInterest.add(OutputS_PresentValue3, 6, 5);

        Label S_FutureValue3 = new Label("Future Value : "); // Label of Upfront Amount
        S_FutureValue3.setFont(Font.font(20));
        gridSavingInterest.add(S_FutureValue3, 5, 7);

        Label OutputS_FutureValue3 = new Label(""); // Answer of Upfront Amount
        OutputS_FutureValue3.setFont(Font.font(20));
        gridSavingInterest.add(OutputS_FutureValue3, 6, 7);

        Label S_NoOfPayments3 = new Label("No of Periods : "); // Label of Total of 60 Loan Payments
        S_NoOfPayments3.setFont(Font.font(20));
        gridSavingInterest.add(S_NoOfPayments3, 5, 9);

        Label OutputS_NoOfPayments3 = new Label(""); // Answer of Total of 60 Loan Payments
        OutputS_NoOfPayments3.setFont(Font.font(20));
        gridSavingInterest.add(OutputS_NoOfPayments3, 6, 9);

        Label S_Interest3 = new Label("Interest Rate : "); // Label of Total Loan Interest
        S_Interest3.setFont(Font.font(20));
        gridSavingInterest.add(S_Interest3, 5, 11);

        Label OutputS_Interest3 = new Label(""); // Answer of Total Loan Interest
        OutputS_Interest3.setFont(Font.font(20));
        gridSavingInterest.add(OutputS_Interest3, 6, 11);


        // Calculating Present Value
        Image S_Calc5 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button SavingCalc2 = new Button("", new ImageView(S_Calc5));
        gridSavingInterest.add(SavingCalc2, 1, 15);

        //  Calculation for Interest Rate
        SavingCalc2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputSavingFuture2.getText());
                Double P = Double.valueOf(InputSavingPresentValue2.getText());
                Double t = Double.valueOf(InputSavingPeriod2.getText());
                Double r = t * (Math.pow(A / P, 1 / (12 * t)) - 1); // r = Interest Rate


                OutputS_PresentValue3.setText(String.valueOf("Rs. " + P));
                OutputS_FutureValue3.setText(String.valueOf("Rs." + A));
                OutputS_Interest3.setText(String.valueOf(r + "%"));
                OutputS_NoOfPayments3.setText(String.valueOf(t + " years"));
            }
        });

        sceneSavingInterest = new Scene(gridSavingInterest, 1300, 700);


        ///////////////////////////////////// Saving - Periods //////////////////////////////////////////////



        GridPane gridSavingPeriod = new GridPane();
        gridSavingPeriod.setAlignment(Pos.TOP_CENTER);
        gridSavingPeriod.setVgap(10);

        gridSavingPeriod.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridSavingPeriod.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridSavingPeriod.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneSaving));

        Image SavingImg9 = new Image(getClass().getResourceAsStream("periodLogo.png")); //logo of compound present value page
        Label SavingPerLogo = new Label("", new ImageView(SavingImg9));
        gridSavingPeriod.add(SavingPerLogo, 3, 1);

        Label SavingPresentValue3 = new Label("Present Value : ");  // Label of Auto Price
        SavingPresentValue3.setFont(Font.font(20));
        gridSavingPeriod.add(SavingPresentValue3, 1, 5);

        TextField InputSavingPresentValue3 = new TextField("");   // Textfield of the user input of Auto Price
        InputSavingPresentValue3.setPromptText("Rs.");
        InputSavingPresentValue3.setOnMouseClicked(event -> {
            keyboard(InputSavingPresentValue3);
            keyboardStage.show();
        });
        gridSavingPeriod.add(InputSavingPresentValue3, 2, 5);


        Label SavingInterest3 = new Label("Interest Rate : "); // Label of Loan Term
        SavingInterest3.setFont(Font.font(20));
        gridSavingPeriod.add(SavingInterest3, 1, 7);

        TextField InputSavingInterest3 = new TextField("");
        InputSavingInterest3.setPromptText("\t\t\t\t%");
        InputSavingInterest3.setOnMouseClicked(event -> {
            keyboard(InputSavingInterest3);
            keyboardStage.show();
        });
        gridSavingPeriod.add(InputSavingInterest3, 2, 7);

        Label SavingFuture3 = new Label("Future Value : ");
        SavingFuture3.setFont(Font.font(20));
        gridSavingPeriod.add(SavingFuture3, 1, 9);

        TextField InputSavingFuture3 = new TextField("");
        InputSavingFuture3.setPromptText("Rs.");
        InputSavingFuture3.setOnMouseClicked(event -> {
            keyboard(InputSavingFuture3);
            keyboardStage.show();
        });
        gridSavingPeriod.add(InputSavingFuture3, 2, 9);

        // ------OUTPUTS------ //

        Label S_PresentValue4 = new Label("Present Value : "); // Label of Total Loan Amount
        S_PresentValue4.setFont(Font.font(20));
        gridSavingPeriod.add(S_PresentValue4, 5, 5);

        Label OutputS_PresentValue4 = new Label("");  // Answer of Total Loan Amount
        OutputS_PresentValue4.setFont(Font.font(20));
        gridSavingPeriod.add(OutputS_PresentValue4, 6, 5);

        Label S_FutureValue4 = new Label("Future Value : "); // Label of Upfront Amount
        S_FutureValue4.setFont(Font.font(20));
        gridSavingPeriod.add(S_FutureValue4, 5, 7);

        Label OutputS_FutureValue4 = new Label(""); // Answer of Upfront Amount
        OutputS_FutureValue4.setFont(Font.font(20));
        gridSavingPeriod.add(OutputS_FutureValue4, 6, 7);

        Label S_NoOfPayments4 = new Label("No of Periods : "); // Label of Total of 60 Loan Payments
        S_NoOfPayments4.setFont(Font.font(20));
        gridSavingPeriod.add(S_NoOfPayments4, 5, 9);

        Label OutputS_NoOfPayments4 = new Label(""); // Answer of Total of 60 Loan Payments
        OutputS_NoOfPayments4.setFont(Font.font(20));
        gridSavingPeriod.add(OutputS_NoOfPayments4, 6, 9);

        Label S_Interest4 = new Label("Interest Rate : "); // Label of Total Loan Interest
        S_Interest4.setFont(Font.font(20));
        gridSavingPeriod.add(S_Interest4, 5, 11);

        Label OutputS_Interest4 = new Label(""); // Answer of Total Loan Interest
        OutputS_Interest4.setFont(Font.font(20));
        gridSavingPeriod.add(OutputS_Interest4, 6, 11);


        // Calculating Present Value
        Image S_Calc6 = new Image(getClass().getResourceAsStream("calculate.png"));
        Button SavingCalc3 = new Button("", new ImageView(S_Calc6));
        gridSavingPeriod.add(SavingCalc3, 1, 15);

        //  Calculation for No of Periods
        SavingCalc3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputSavingFuture3.getText());
                Double P = Double.valueOf(InputSavingPresentValue3.getText());
                Double r = Double.valueOf(InputSavingInterest3.getText());
                Double t = (Math.log(A / P)) / (12 * (Math.log(1 + (r / 1200)))); // t = No of Periods


                OutputS_PresentValue4.setText(String.valueOf("Rs. " + P));
                OutputS_FutureValue4.setText(String.valueOf("Rs." + A));
                OutputS_Interest4.setText(String.valueOf(r + "%"));
                OutputS_NoOfPayments4.setText(String.valueOf(t + " years"));
            }
        });

        sceneSavingPeriod = new Scene(gridSavingPeriod, 1300, 700);

        /////////////////////////////////////// MORTGAGE ///////////////////////////////////////////////



        GridPane gridMortgage = new GridPane();
        gridMortgage.setAlignment(Pos.TOP_CENTER);
        gridMortgage.setVgap(10);

        gridMortgage.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridMortgage.setBackground(background);


        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridMortgage.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneHome));

        Image imgMortgage = new Image(getClass().getResourceAsStream("MortgageLogo.png")); // logo
        Label LogoMortgage = new Label("", new ImageView(imgMortgage));
        gridMortgage.add(LogoMortgage, 3, 2);

        Image imgMortgage1 = new Image(getClass().getResourceAsStream("PMT.png"));
        Button MortgagePMT = new Button("", new ImageView(imgMortgage1));
        MortgagePMT.setFont(Font.font(20));
        gridMortgage.add(MortgagePMT, 3, 8);
        MortgagePMT.setOnAction(event -> window.setScene(sceneMortgagePMT));


        Image imgMortgage2 = new Image(getClass().getResourceAsStream("periods.png"));
        Button MortgagePeriod = new Button("", new ImageView(imgMortgage2));
        MortgagePeriod.setFont(Font.font(20));
        gridMortgage.add(MortgagePeriod, 5, 8);
        MortgagePeriod.setOnAction(event -> window.setScene(sceneMortgagePeriod));


        sceneMortgage = new Scene(gridMortgage, 1400, 700);


        ///////////////////////////////////////////////// MORTGAGE - Monthly Payment //////////////////////////////////////////////////////

        GridPane gridMortgagePMT = new GridPane();
        gridMortgagePMT.setAlignment(Pos.TOP_CENTER);
        gridMortgagePMT.setVgap(10);


        gridMortgagePMT.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridMortgagePMT.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridMortgagePMT.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneMortgage));

        Image imgLoanPMT = new Image(getClass().getResourceAsStream("PMTlogo.png")); // Logo of Mortgage
        Logo = new Label("", new ImageView(imgLoanPMT));
        gridMortgagePMT.add(Logo, 2, 1);

        Label HomePrice = new Label("Home Price : ");  // Label of Home Price
        HomePrice.setFont(Font.font(20));
        gridMortgagePMT.add(HomePrice, 1, 5);

        TextField InputHomePrice = new TextField("");   // Textfield of the user input of Home Price
        InputHomePrice.setMaxWidth(150);
        InputHomePrice.setPromptText("Rs.");
        InputHomePrice.setOnMouseClicked(event -> {
            keyboard(InputHomePrice);
            keyboardStage.show();
        });
        gridMortgagePMT.add(InputHomePrice, 2, 5);

        Label MortgageLoanTerm = new Label("Loan Term : ");
        MortgageLoanTerm.setFont(Font.font(20));
        gridMortgagePMT.add(MortgageLoanTerm, 1, 7);

        TextField InputMortgageLoanTerm = new TextField("");
        InputMortgageLoanTerm.setMaxWidth(150);
        InputMortgageLoanTerm.setPromptText("years");
        InputMortgageLoanTerm.setOnMouseClicked(event -> {
            keyboard(InputMortgageLoanTerm);
            keyboardStage.show();
        });
        gridMortgagePMT.add(InputMortgageLoanTerm, 2, 7);

        Label MortgageInterestRate = new Label("Interest Rate : ");
        MortgageInterestRate.setFont(Font.font(20));
        gridMortgagePMT.add(MortgageInterestRate, 1, 9);

        TextField InputMortgageInterestRate = new TextField("");
        InputMortgageInterestRate.setMaxWidth(150);
        InputMortgageInterestRate.setPromptText("\t\t\t%");
        InputMortgageInterestRate.setOnMouseClicked(event -> {
            keyboard(InputMortgageInterestRate);
            keyboardStage.show();
        });
        gridMortgagePMT.add(InputMortgageInterestRate, 2, 9);


        // ------OUTPUTS------ //

        Label HomePrice1 = new Label("Home Price : "); // Label of Home Price
        HomePrice1.setFont(Font.font(20));
        gridMortgagePMT.add(HomePrice1, 5, 5);

        Label OutputHomePrice1 = new Label("");  // Home Price in Outputs
        OutputHomePrice1.setFont(Font.font(20));
        gridMortgagePMT.add(OutputHomePrice1, 6, 5);

        Label MortgageInterestRate1 = new Label("Interest Rate : "); // Label of Interest Rate
        MortgageInterestRate1.setFont(Font.font(20));
        gridMortgagePMT.add(MortgageInterestRate1, 5, 7);

        Label OutputMortgageInterestRate1 = new Label(""); // Answer of Interest Rate
        OutputMortgageInterestRate1.setFont(Font.font(20));
        gridMortgagePMT.add(OutputMortgageInterestRate1, 6, 7);

        Label MonthlyPayment1 = new Label("Monthly Payment : "); // Label of Monthly Payment
        MonthlyPayment1.setFont(Font.font(18));
        gridMortgagePMT.add(MonthlyPayment1, 5, 9);

        Label OutputMonthlyPayment1 = new Label(""); // Answer of Monthly Payment
        OutputMonthlyPayment1.setFont(Font.font(20));
        gridMortgagePMT.add(OutputMonthlyPayment1, 6, 9);

        Label LoanTerm1 = new Label("Loan Term : "); // Label of Number of Payments
        LoanTerm1.setFont(Font.font(20));
        gridMortgagePMT.add(LoanTerm1, 5, 11);

        Label OutputLoanTerm1 = new Label(""); // Answer of Number of Payments
        OutputLoanTerm1.setFont(Font.font(20));
        gridMortgagePMT.add(OutputLoanTerm1, 6, 11);


        Image CalcM_PMT = new Image(getClass().getResourceAsStream("calculate.png")); // Calculate Button
        Button MortgageCalculate1 = new Button("", new ImageView(CalcM_PMT));
        gridMortgagePMT.add(MortgageCalculate1, 1, 19);

        //  Calculation for Monthly payment of Mortgage
        MortgageCalculate1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputHomePrice.getText());
                Double t = Double.valueOf(InputMortgageLoanTerm.getText());
                Double r = Double.valueOf(InputMortgageInterestRate.getText());
                Double PMT = ((A * r / 1200) * (Math.pow((1 + (r / 1200)), 12 * t))) / (Math.pow((1 + (r / 1200)), 12 * t) - 1); // PMT = Monthly Payment

                //for formatting to two decimal places
                DecimalFormat dec = new DecimalFormat("#.00");
                Double PMT1 = Double.valueOf(dec.format(PMT));

                OutputMonthlyPayment1.setText(String.valueOf("Rs. " + PMT1));
                OutputHomePrice1.setText(String.valueOf("Rs." + A));
                OutputMortgageInterestRate1.setText(String.valueOf(r + "%"));
                OutputLoanTerm1.setText(String.valueOf(t + " years"));
            }
        });

        sceneMortgagePMT = new Scene(gridMortgagePMT, 1400, 700);

        ///////////////////////////////////////////////// MORTGAGE - Period //////////////////////////////////////////////////////

        GridPane gridMortgagePeriod = new GridPane();
        gridMortgagePeriod.setAlignment(Pos.TOP_CENTER);
        gridMortgagePeriod.setVgap(10);


        gridMortgagePeriod.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridMortgagePeriod.setBackground(background);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridMortgagePeriod.add(Goback, 1, 1);
        Goback.setOnAction(event -> window.setScene(sceneMortgage));

        Image imgLogoMP = new Image(getClass().getResourceAsStream("periodLogo.png")); // Logo of Mortgage
        Logo = new Label("", new ImageView(imgLogoMP));
        gridMortgagePeriod.add(Logo, 2, 1);

        Label HomePrice2 = new Label("Home Price : ");  // Label of Home Price
        HomePrice2.setFont(Font.font(20));
        gridMortgagePeriod.add(HomePrice2, 1, 5);

        TextField InputHomePrice2 = new TextField("");   // Textfield of the user input of Home Price
        InputHomePrice2.setMaxWidth(150);
        InputHomePrice2.setPromptText("Rs.");
        InputHomePrice2.setOnMouseClicked(event -> {
            keyboard(InputHomePrice2);
            keyboardStage.show();
        });
        gridMortgagePeriod.add(InputHomePrice2, 2, 5);


        Label MortgageMonthlyPayment2 = new Label("Monthly Payment : "); // Label of monthly Payment
        MortgageMonthlyPayment2.setFont(Font.font(20));
        gridMortgagePeriod.add(MortgageMonthlyPayment2, 1, 7);

        TextField InputMortgageMonthlyPayment2 = new TextField("");
        InputMortgageMonthlyPayment2.setMaxWidth(150);
        InputMortgageMonthlyPayment2.setPromptText("Rs.");
        InputMortgageMonthlyPayment2.setOnMouseClicked(event -> {
            keyboard(InputMortgageMonthlyPayment2);
            keyboardStage.show();
        });
        gridMortgagePeriod.add(InputMortgageMonthlyPayment2, 2, 7);

        Label MortgageInterestRate2 = new Label("Interest Rate : ");
        MortgageInterestRate2.setFont(Font.font(20));
        gridMortgagePeriod.add(MortgageInterestRate2, 1, 9);

        TextField InputMortgageInterestRate2 = new TextField("");
        InputMortgageInterestRate2.setMaxWidth(150);
        InputMortgageInterestRate2.setPromptText("\t\t\t%");
        InputMortgageInterestRate2.setOnMouseClicked(event -> {
            keyboard(InputMortgageInterestRate2);
            keyboardStage.show();
        });
        gridMortgagePeriod.add(InputMortgageInterestRate2, 2, 9);


        // ------OUTPUTS------ //

        Label HomePrice3 = new Label("Home Price : "); // Label of Home Price
        HomePrice3.setFont(Font.font(20));
        gridMortgagePeriod.add(HomePrice3, 5, 5);

        Label OutputHomePrice3 = new Label("");  // Home Price in Outputs
        OutputHomePrice3.setFont(Font.font(20));
        gridMortgagePeriod.add(OutputHomePrice3, 6, 5);

        Label MortgageInterestRate3 = new Label("Interest Rate : "); // Label of Interest Rate
        MortgageInterestRate3.setFont(Font.font(20));
        gridMortgagePeriod.add(MortgageInterestRate3, 5, 7);

        Label OutputMortgageInterestRate3 = new Label(""); // Answer of Interest Rate
        OutputMortgageInterestRate3.setFont(Font.font(20));
        gridMortgagePeriod.add(OutputMortgageInterestRate3, 6, 7);

        Label MonthlyPayment3 = new Label("Monthly Payment : "); // Label of Monthly Payment
        MonthlyPayment3.setFont(Font.font(18));
        gridMortgagePeriod.add(MonthlyPayment3, 5, 9);

        Label OutputMonthlyPayment3 = new Label(""); // Answer of Monthly Payment
        OutputMonthlyPayment3.setFont(Font.font(20));
        gridMortgagePeriod.add(OutputMonthlyPayment3, 6, 9);

        Label LoanTerm3 = new Label("Loan Term : "); // Label of loan term
        LoanTerm3.setFont(Font.font(20));
        gridMortgagePeriod.add(LoanTerm3, 5, 11);

        Label OutputLoanTerm3 = new Label(""); // Answer of Loan term
        OutputLoanTerm3.setFont(Font.font(20));
        gridMortgagePeriod.add(OutputLoanTerm3, 6, 11);


        Image CalcMP = new Image(getClass().getResourceAsStream("calculate.png")); // Calculate Button
        Button MortgageCalculate4 = new Button("", new ImageView(CalcMP));
        gridMortgagePeriod.add(MortgageCalculate4, 1, 19);

        //  Calculation for Loan Term of Mortgage
        MortgageCalculate4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Double A = Double.valueOf(InputHomePrice2.getText());
                Double PMT = Double.valueOf(InputMortgageMonthlyPayment2.getText());
                Double r = Double.valueOf(InputMortgageInterestRate2.getText());
                Double t = Math.log((1 - (((r / 100) * A) / PMT)) / (Math.log((1 + (r / 100)))) * 12); // t = Loan Term


                OutputMonthlyPayment3.setText(String.valueOf("Rs. " + PMT));
                OutputHomePrice3.setText(String.valueOf("Rs." + A));
                OutputMortgageInterestRate3.setText(String.valueOf(r + "%"));
                OutputLoanTerm3.setText(String.valueOf(t + " years"));
            }
        });

        sceneMortgagePeriod = new Scene(gridMortgagePeriod, 1400, 700);

        /////////////////////////////////////////// History ///////////////////////////////////////////////////////

        GridPane gridHistory = new GridPane();
        gridHistory.setAlignment(Pos.TOP_CENTER);
        gridHistory.setVgap(10);

        gridHistory.setPadding(new Insets(0, 1, 5, 1));
        backgroundImage = new Image(getClass().getResourceAsStream("background.jpg"));

        theme = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        // create Background
        background = new Background(theme);
        gridHistory.setBackground(background);

        sceneHistory = new Scene(gridHistory, 1000, 950);

        imgBack = new Image(getClass().getResourceAsStream("Back.png"));
        Goback = new Button("", new ImageView(imgBack));
        Goback.setFont(Font.font(20));
        Goback.setTextAlignment(TextAlignment.LEFT);
        gridHistory.add(Goback, 5, 1);
        Goback.setOnAction(event -> window.setScene(sceneHome));

        Image imgPrint = new Image(getClass().getResourceAsStream("historyLogo.png"));
        Logo = new Label("", new ImageView(imgPrint));
        gridHistory.add(Logo, 3, 1);

        TextArea TA = new TextArea("");
        TA.setTranslateY(400);
        TA.setTranslateX(400);
        TA.setMaxSize(300,300);
        gridHistory.getChildren().add(TA);


        /////////////////////////////////////////////////////////////////////////////////////////

        window.setScene(sceneGoApp);
        window.show();

        //////////////////Creating a gridpane for keyboard/////////////////

        GridPane keyboardpane=new GridPane();
        keyboardpane.setPadding(new Insets(10,10,10,10));
        keyboardpane.setVgap(8);
        keyboardpane.setHgap(10);

        //////////////////Creating Number buttons for keyboard///////////

        Image one = new Image(getClass().getResourceAsStream("1.png")); //adding an image into button
        No1=new Button("",new ImageView(one));
        No1.setMaxSize(300,10);
        GridPane.setConstraints(No1,0,0);
        keyboardpane.getChildren().addAll(No1);

        Image two = new Image(getClass().getResourceAsStream("2.png"));
        No2=new Button("",new ImageView(two));
        No2.setMaxSize(300,10);
        GridPane.setConstraints(No2,1,0);
        keyboardpane.getChildren().addAll(No2);

        Image three = new Image(getClass().getResourceAsStream("3.png"));
        No3=new Button("",new ImageView(three));
        No3.setMaxSize(300,10);
        GridPane.setConstraints(No3,2,0);
        keyboardpane.getChildren().addAll(No3);

        Image four = new Image(getClass().getResourceAsStream("4.png"));
        No4=new Button("",new ImageView(four));
        No4.setMaxSize(300,10);
        GridPane.setConstraints(No4,0,1);
        keyboardpane.getChildren().addAll(No4);

        Image five = new Image(getClass().getResourceAsStream("5.png"));
        No5=new Button("",new ImageView(five));
        No5.setMaxSize(300,10);
        GridPane.setConstraints(No5,1,1);
        keyboardpane.getChildren().addAll(No5);

        Image six = new Image(getClass().getResourceAsStream("6.png"));
        No6=new Button("",new ImageView(six));
        No6.setMaxSize(300,10);
        GridPane.setConstraints(No6,2,1);
        keyboardpane.getChildren().addAll(No6);

        Image seven = new Image(getClass().getResourceAsStream("7.png"));
        No7=new Button("",new ImageView(seven));
        No7.setMaxSize(300,10);
        GridPane.setConstraints(No7,0,2);
        keyboardpane.getChildren().addAll(No7);

        Image eight = new Image(getClass().getResourceAsStream("8.png"));
        No8=new Button("",new ImageView(eight));
        No8.setMaxSize(300,10);
        GridPane.setConstraints(No8,1,2);
        keyboardpane.getChildren().addAll(No8);

        Image nine = new Image(getClass().getResourceAsStream("9.png"));
        No9=new Button("",new ImageView(nine));
        No9.setMaxSize(300,10);
        GridPane.setConstraints(No9,2,2);
        keyboardpane.getChildren().addAll(No9);

        Image zero = new Image(getClass().getResourceAsStream("0.png"));
        No0=new Button("",new ImageView(zero));
        No0.setMaxSize(300,10);
        GridPane.setConstraints(No0,0,3);
        keyboardpane.getChildren().addAll(No0);

        Image imgPoint = new Image(getClass().getResourceAsStream("point.png"));
        Point=new Button(".",new ImageView(imgPoint));
        Point.setMaxSize(300,10);
        GridPane.setConstraints(Point,1,3);
        keyboardpane.getChildren().addAll(Point);

        Image imgMinus = new Image(getClass().getResourceAsStream("Minus.png"));
        MinusMark=new Button("",new ImageView(imgMinus));
        MinusMark.setMaxSize(300,10);
        GridPane.setConstraints(MinusMark,2,3);
        keyboardpane.getChildren().addAll(MinusMark);

        Image imgClear = new Image(getClass().getResourceAsStream("clear.png"));
        clear=new Button("",new ImageView(imgClear));
        clear.setMaxSize(300,10);
        GridPane.setConstraints(clear,1,4);
        keyboardpane.getChildren().addAll(clear);

        Scene scene = new Scene(keyboardpane);
        keyboardStage.setScene(scene);
        //keyboardStage.show();
    }

    public static void main(String[] args) { launch(args); }

    //////////////////Calling methods for every buttons of keyboard/////////////////

    public static Button No1;
    public static Button No2;
    public static Button No3;
    public static Button No4;
    public static Button No5;
    public static Button No6;
    public static Button No7;
    public static Button No8;
    public static Button No9;
    public static Button No0;
    public static Button Point;
    public static Button clear;
    public static Button MinusMark;

//////////////////Calling methods for actions of the keyboard buttons/////////////////

    public static void keyboard(TextField T){
        No1.setOnAction(event -> T.setText(T.getText()+"1"));
        No2.setOnAction(event -> T.setText(T.getText()+"2"));
        No3.setOnAction(event -> T.setText(T.getText()+"3"));
        No4.setOnAction(event -> T.setText(T.getText()+"4"));
        No5.setOnAction(event -> T.setText(T.getText()+"5"));
        No6.setOnAction(event -> T.setText(T.getText()+"6"));
        No7.setOnAction(event -> T.setText(T.getText()+"7"));
        No8.setOnAction(event -> T.setText(T.getText()+"8"));
        No9.setOnAction(event -> T.setText(T.getText()+"9"));
        No0.setOnAction(event -> T.setText(T.getText()+"0"));
        Point.setOnAction(event -> T.setText(T.getText()+"."));
        MinusMark.setOnAction(event -> T.setText(T.getText()+"-"));
        clear.setOnAction(event -> T.setText(T.getText().substring(0,T.getText().length()-1)));
    }

}
