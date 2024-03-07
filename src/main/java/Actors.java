import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Actors {
    public static final String API_KEY = "Yi98eG3Bo5xcvZ29iYAjlA==jFHYQ7RXR36nweGm";   // TODO --> add your api key about Actors here
    String netWorth;
    Boolean isAlive;

    public Actors(String netWorth, boolean isAlive){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.netWorth = netWorth;
        this.isAlive = true;
    }
    @SuppressWarnings({"deprecation"})
    /**
     * Retrieves data for the specified actor.
     * @param name for which Actor should be retrieved
     * @return a string representation of the Actors info or null if an error occurred
     */
    public String getActorData(String name) {
        try {
            URL url = new URL("https://api.api-ninjas.com/v1/celebrity?name="+
                    name.replace(" ", "+")+"&apikey="+API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("X-Api-Key", API_KEY);
            System.out.println(connection);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                System.out.println("API Response: " + response.toString());
                return response.toString().substring(1,response.toString().length()-1);
            } else {
                return "Error: " + connection.getResponseCode() + " " + connection.getResponseMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Not Found";
        }
    }
    public double getNetWorthViaApi(String actorsInfoJson){
        //TODO --> (This function must return the "NetWorth")
        double result = 0.0;
        JSONObject NetWorth = new JSONObject(actorsInfoJson);
        result = NetWorth.getDouble("net_worth");
        System.out.print("Net_Worth");
        return result;
    }

    public boolean isAlive(String actorsInfoJson){
        //TODO --> (If your chosen actor is alive it must return true otherwise it must return false)
        boolean statues = false;
        JSONObject Alive = new JSONObject(actorsInfoJson);
        statues = Alive.getBoolean("is_alive");
        System.out.print("Is Alive : ");
        return statues;
    }

    public String getDateOfDeathViaApi(String actorsInfoJson){
        //TODO --> (If your chosen actor is deceased it must return the date of death)  -->
        String date = "";
        try {
            JSONObject datedOfDeath = new JSONObject(actorsInfoJson);
            if (datedOfDeath.has("death")) {
                date = datedOfDeath.getString("death");
                System.out.println("Data of Death : " + date);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public double getDataHeight(String actorsInfoJson){
        double height = 0.0;
        JSONObject Height = new JSONObject(actorsInfoJson);
        height = Height.getDouble("height");
        System.out.print("Height : ");
        return  height;
    }

    public String getDataBirthday(String actorsInfoJson){
        String birthday = "";
        JSONObject Birthday = new JSONObject(actorsInfoJson);
        birthday = Birthday.getString("birthday");
        return " Birthday : " + birthday;
    }

    public int getDataAge(String actorsInfoJson){
        int age = 0;
        JSONObject Age = new JSONObject(actorsInfoJson);
        age = Age.getInt("age");
        System.out.print("Age : ");
        return age;
    }

    public String getDataGender(String actorsInfoJson){
        String gender = "";
        JSONObject Gender = new JSONObject(actorsInfoJson);
        gender = Gender.getString("gender");
        return "Gender : " + gender;
    }

    public String getDataNationality(String actorsInfoJson){
        String nationality="";
        JSONObject Nationality = new JSONObject(actorsInfoJson);
        nationality = Nationality.getString("nationality");
        return "Nationality : " + nationality;
    }

}