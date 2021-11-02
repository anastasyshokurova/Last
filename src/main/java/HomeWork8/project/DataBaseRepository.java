package HomeWork8.project;

import HomeWork8.project.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";
    private String insertWeatherQuery = "insert into weather (city, local_date, temperature) values (?,?,?)";
    private String selectWeatherQuery = "select * from weather";

    static {
        try {
            Class.forName("org.sqlite.JDBS");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String getLastWeatherQuery;

    public boolean saveWeather(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement insertWeather = connection.prepareStatement(insertWeatherQuery);
            insertWeather.setString(1, weather.getCity());
            insertWeather.setString(2, weather.getLocalDate());
            insertWeather.setDouble(3, weather.getTemperature());

            return insertWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       throw new SQLException("Сохранение не выполнено!");
    }
    public  void saveWeather(List<Weather> weatherList) {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement insertWeather = connection.prepareStatement(insertWeatherQuery);
            for (Weather weather : weatherList) {
                insertWeather.setString(1, weather.getCity());
                insertWeather.setString(2, weather.getLocalDate());
                insertWeather.setDouble(3, weather.getTemperature());
                insertWeather.addBatch();
            }
            insertWeather.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Weather getSavedToDB(String city) {
        Weather weather = null;
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement getWeather = connection.prepareStatement(getLastWeatherQuery);
            getWeather.setString(1, city);
            ResultSet resultSet = getWeather.executeQuery();
            if (resultSet.first()) {
                weather = new Weather(resultSet.getString("city"), resultSet.getString("local_date"), resultSet.getDouble("temperature"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return weather;
        }

    public List<Weather> getSavedToDBList() {
        List weatherList = new ArrayList();

        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectWeatherQuery);

            while (resultSet.next()) {
                weatherList.add(new Weather(resultSet.getString("city"), resultSet.getString("local_date"),resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return weatherList;
    }
}
