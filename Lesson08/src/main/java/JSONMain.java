import org.json.simple.*;

import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONMain {

    /*
     Метод для получения данных по указанной ссылке
     url - ссылка в виде объекта URL
     return содержимое страницы на указанной ссылке в url
     */
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL

        //c  помощью конструкции
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                //   System.out.println(inputLine);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();

    }

    public static Connection connection;
    public static Statement statement;

    public static List<WeatherT> OneDayWeather(String resultJson, String CITY) {
        try {

            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("DailyForecasts");

            JSONObject weather = (JSONObject) weatherArray.get(0);
            JSONObject ArrWeather = (JSONObject) weatherArray.get(0);
            JSONObject Day = (JSONObject) ArrWeather.get("Day");
            JSONObject weatherTemp = (JSONObject) weather.get("Temperature");
            JSONObject weatherMinValue = (JSONObject) weatherTemp.get("Minimum");
            JSONObject weatherMaxValue = (JSONObject) weatherTemp.get("Maximum");


            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
            statement = connection.createStatement();
            String strDate = weather.get("Date").toString();
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Weather(id INTEGER PRIMARY KEY NOT NULL, City STRING NOT NULL, Date STRING NOT NULL, Weather STRING NOT NULL, MinT REAL NOT NULL, MaxT REAL NOT NULL);");
            statement.executeUpdate("INSERT OR REPLACE INTO Weather(id,City,Date,Weather,MinT,MaxT) VALUES(1,'" + CITY + "','" + strDate + "','" + Day.get("IconPhrase").toString() + "'," + Double.parseDouble(weatherMinValue.get("Value").toString()) + "," + Double.parseDouble(weatherMaxValue.get("Value").toString()) + ");");
            List<WeatherT> Wt = new ArrayList<WeatherT>();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Weather");
            while (resultSet.next()) {
                Wt.add(new WeatherT(resultSet.getInt("id"), resultSet.getString("City"), resultSet.getString("Date"), resultSet.getString("Weather"), resultSet.getDouble("MinT"), resultSet.getDouble("MaxT")));
            }

            return Wt;




/*
                System.out.println(" В городе " + CITY);
                System.out.println(" на дату " + weather.get("Date"));
                System.out.println(" ожидается " + Day.get("IconPhrase"));
                System.out.println(" минимальная температура: " + weatherMinValue.get("Value"));
                System.out.println(" максимальная температура: " + weatherMaxValue.get("Value") + "\n");
*/


        } catch (ParseException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                statement.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static List<WeatherT> parseCurrentWeatherJson(String resultJson, String CITY) {
        try {

            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("DailyForecasts");

            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
            statement = connection.createStatement();


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Weather5(id INTEGER PRIMARY KEY NOT NULL, City STRING NOT NULL, Date STRING NOT NULL, Weather STRING NOT NULL, MinT REAL NOT NULL, MaxT REAL NOT NULL);");
            List<WeatherT> Wt = new ArrayList<WeatherT>();
            for (int i = 0; i < weatherArray.size(); i++) {


                JSONObject weather = (JSONObject) weatherArray.get(i);
                JSONObject ArrWeather = (JSONObject) weatherArray.get(i);
                JSONObject Day = (JSONObject) ArrWeather.get("Day");
                JSONObject weatherTemp = (JSONObject) weather.get("Temperature");
                JSONObject weatherMinValue = (JSONObject) weatherTemp.get("Minimum");
                JSONObject weatherMaxValue = (JSONObject) weatherTemp.get("Maximum");

                String strDate = weather.get("Date").toString();

                statement.executeUpdate("INSERT OR REPLACE INTO Weather5(id,City,Date,Weather,MinT,MaxT) VALUES(" + (i + 1) + ",'" + CITY + "','" + strDate + "','" + Day.get("IconPhrase").toString() + "'," + Double.parseDouble(weatherMinValue.get("Value").toString()) + "," + Double.parseDouble(weatherMaxValue.get("Value").toString()) + ");");


            }
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Weather5");
            while (resultSet.next()) {
                Wt.add(new WeatherT(resultSet.getInt("id"), resultSet.getString("City"), resultSet.getString("Date"), resultSet.getString("Weather"), resultSet.getDouble("MinT"), resultSet.getDouble("MaxT")));
            }
            return Wt;


        } catch (ParseException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        } finally {
            try {
                statement.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static String GetKey(String resultJson) {
        String key = "";
        try {

            JSONArray weatherJsonObject = (JSONArray) JSONValue.parseWithException(resultJson);
            JSONObject weather = (JSONObject) weatherJsonObject.get(0);
            key = (String) weather.get("Key");


        } catch (ParseException e) {
            e.printStackTrace();
        }

        return key;
    }


}
