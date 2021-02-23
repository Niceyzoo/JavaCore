import java.net.MalformedURLException;
import java.net.URL;

public class main {

    public static void main(String[] args) throws MalformedURLException {

        // создаем URL
        URL url = new URL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/474212_PC?apikey=gWzPijujjlZT9vTv9IUMlr93BW3VC7jb&metric=true");


        // загружаем Json в виде Java строки
        String resultJson = JSONMain.parseUrl(url);
        // System.out.println("Полученный JSON:\n" + resultJson);

        // парсим полученный JSON и печатаем его на экран
        JSONMain.parseCurrentWeatherJson(resultJson);


    }
}
