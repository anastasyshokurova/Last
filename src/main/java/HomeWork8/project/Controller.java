package HomeWork8.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
    private Map<Integer, HomeWork7.Period> variants = new HashMap<>();

    public Controller(){
        variants.put(1, HomeWork7.Period.NOW);
        variants.put(5, HomeWork7.Period.FIVE_DAYS);
    }
    public void getWeather (String userInput, String selectedCity) throws IOException {
        Integer option = Integer.parseInt(userInput);

        switch (variants.get(option)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
        }
    }

}