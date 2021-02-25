
import org.json.simple.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

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

    public  static void  OneDayWeather (String resultJson, String CITY)
    {
        try {

            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("DailyForecasts");





                JSONObject weather = (JSONObject) weatherArray.get(0);
                JSONObject ArrWeather = (JSONObject) weatherArray.get(0);
                JSONObject Day = (JSONObject) ArrWeather.get("Day");
                JSONObject weatherTemp = (JSONObject) weather.get("Temperature");
                JSONObject weatherMinValue = (JSONObject) weatherTemp.get("Minimum");
                JSONObject weatherMaxValue = (JSONObject) weatherTemp.get("Maximum");

                System.out.println(" В городе " + CITY);
                System.out.println(" на дату " + weather.get("Date"));
                System.out.println(" ожидается " + Day.get("IconPhrase"));
                System.out.println(" минимальная температура: " + weatherMinValue.get("Value"));
                System.out.println(" максимальная температура: " + weatherMaxValue.get("Value") + "\n");





        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }

    public static void parseCurrentWeatherJson(String resultJson, String CITY) {
        try {

            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("DailyForecasts");


            for (int i = 0; i < weatherArray.size(); i++) {


                JSONObject weather = (JSONObject) weatherArray.get(i);
                JSONObject ArrWeather = (JSONObject) weatherArray.get(i);
                JSONObject Day = (JSONObject) ArrWeather.get("Day");
                JSONObject weatherTemp = (JSONObject) weather.get("Temperature");
                JSONObject weatherMinValue = (JSONObject) weatherTemp.get("Minimum");
                JSONObject weatherMaxValue = (JSONObject) weatherTemp.get("Maximum");

                System.out.println(" " + (i+1) + " день в городе " + CITY);
                System.out.println(" на дату " + weather.get("Date"));
                System.out.println(" ожидается " + Day.get("IconPhrase"));
                System.out.println(" минимальная температура: " + weatherMinValue.get("Value"));
                System.out.println(" максимальная температура: " + weatherMaxValue.get("Value") + "\n");


            }


        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
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
