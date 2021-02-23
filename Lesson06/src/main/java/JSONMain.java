import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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

    public static void parseCurrentWeatherJson(String resultJson) {
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("DailyForecasts");


            for (int i = 0; i < weatherArray.size(); i++) {


                JSONObject weather = (JSONObject) weatherArray.get(i);
                JSONObject weatherTemp = (JSONObject) weather.get("Temperature");
                JSONObject weatherMinValue = (JSONObject) weatherTemp.get("Minimum");
                JSONObject weatherMaxValue = (JSONObject) weatherTemp.get("Maximum");

                System.out.println("Дата: " + weather.get("Date"));
                System.out.println("Минимальная температура: " + weatherMinValue.get("Value"));
                System.out.println("Максимальная температура: " + weatherMaxValue.get("Value"));


            }


        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }


    }


}
