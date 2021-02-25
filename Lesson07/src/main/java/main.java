import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class main {
    public static String API_KEY = "yyMmZUSm1gv8fwSsBVSmDS0XMmLkAp7R";
    public static String key;

    public static void main(String[] args) throws IOException {

        System.out.println("Введите название города на английском: ");

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader in = new BufferedReader(inputStreamReader);

        String NameCity = in.readLine();


        // создаем URL
        URL urlKey = new URL("http://dataservice.accuweather.com/locations/v1/cities/search?apikey=" + API_KEY + "&q=" + NameCity);
        boolean run=true;

        while (run){
            System.out.println("1: Показать погоду на 1 день | 2: Показать погоду на 5 дней | 3: Выйти из программы");
            String menu = in.readLine();


            switch (menu) {
                case "1": {
                    // загружаем Json в виде Java строки
                    String resultJson = JSONMain.parseUrl(urlKey);
                    // System.out.println("Полученный JSON:\n" + resultJson);
                    key = JSONMain.GetKey(resultJson);
                    URL url = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + key + "?apikey=" + API_KEY + "&q&metric=true");
                    resultJson = JSONMain.parseUrl(url);
                    // парсим полученный JSON и печатаем его на экран
                    JSONMain.OneDayWeather(resultJson, NameCity);
                    break;

                }
                case "2": {
                    String resultJson = JSONMain.parseUrl(urlKey);
                    // System.out.println("Полученный JSON:\n" + resultJson);
                    key = JSONMain.GetKey(resultJson);
                    URL url = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + key + "?apikey=" + API_KEY + "&q&metric=true");
                    resultJson = JSONMain.parseUrl(url);
                    JSONMain.parseCurrentWeatherJson(resultJson, NameCity);
                    break;
                }
                case "3": {
                    run =false;
                    break;
                }
            }

        }






    }
}
