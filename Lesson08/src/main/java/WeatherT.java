public class WeatherT {

    public int id;
    public String City;
    public String Date;
    public String Weather;
    public Double MinT;
    public Double MaxT;

    public WeatherT(int id, String city, String date, String weather, Double minT, Double maxT) {
        this.id = id;
        this.City = city;
        this.Date = date;
        this.Weather = weather;
        this.MinT = minT;
        this.MaxT = maxT;
    }

    @Override
    public String toString() {
        return String.format("Город: %s\n Дата: %s\n Погода: %s\n Минимальная температура: %s\n Максимальная температура: %s\n",  this.City, this.Date, this.Weather, this.MinT, this.MaxT);
    }
}
