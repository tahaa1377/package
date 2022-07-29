package cmpt213.assignment3.packagedeliveries;

import cmpt213.assignment3.packagedeliveries.model.Book;
import cmpt213.assignment3.packagedeliveries.model.Electronic;
import cmpt213.assignment3.packagedeliveries.model.Perishable;
import cmpt213.assignment3.packagedeliveries.model.Package;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static final String FILE_PATH ="cmpt213/assignment3/packagedeliveries/list.json";

    public static ArrayList<Package> packageArrayList = new ArrayList<>();


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/MainController.fxml"));
        primaryStage.setTitle("main");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
         packageArrayList = read_file();

        launch(args);
    }


    private static ArrayList<Package> read_file(){

        Gson myGson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                new TypeAdapter<LocalDateTime>() {
                    @Override
                    public void write(JsonWriter jsonWriter,
                                      LocalDateTime localDateTime) throws IOException {
                        jsonWriter.value(localDateTime.toString());
                    }
                    @Override
                    public LocalDateTime read(JsonReader jsonReader) throws IOException {
                        return LocalDateTime.parse(jsonReader.nextString());
                    }
                }).create();

        ArrayList<Package> aPackages = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Perishable> perishables = new ArrayList<>();
        ArrayList<Electronic> electronics = new ArrayList<>();

        Path path = Paths.get(FILE_PATH);


        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            books = myGson.fromJson(reader, new TypeToken<List<Book>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            perishables = myGson.fromJson(reader, new TypeToken<List<Perishable>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            electronics = myGson.fromJson(reader, new TypeToken<List<Electronic>>(){}.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Book b:books) {
            if (b.getAuthor_name() != null){
                aPackages.add(b);
            }
        }

        for (Perishable p:perishables) {
            if (p.getExpiry_date() != null){
                aPackages.add(p);
            }
        }

        for (Electronic e:electronics) {
            if (e.getEnvironmental_handling_fee() != 0){
                aPackages.add(e);
            }
        }



        return aPackages;
    }



    public static void write_json_file() {

        Gson myGson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class,
                new TypeAdapter<LocalDateTime>() {
                    @Override
                    public void write(JsonWriter jsonWriter,
                                      LocalDateTime localDateTime) throws IOException {
                        jsonWriter.value(localDateTime.toString());
                    }
                    @Override
                    public LocalDateTime read(JsonReader jsonReader) throws IOException {
                        return LocalDateTime.parse(jsonReader.nextString());
                    }
                }).create();

        try (FileWriter writer = new FileWriter(FILE_PATH)) {

            myGson.toJson(packageArrayList, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
