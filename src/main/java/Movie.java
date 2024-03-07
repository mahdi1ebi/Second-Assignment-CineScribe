import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
public class Movie {
    public static final String API_KEY = "b6468b1b";   // TODO --> add your api key about Movie here
    int ImdbVotes;
    ArrayList<String> actorsList;
    String rating;

    public Movie(ArrayList<String> actorsList, String rating, int ImdbVotes){
        //TODO --> (Write a proper constructor using the get_from_api functions)
        this.ImdbVotes = ImdbVotes;
        this.rating = rating;
        this.actorsList = actorsList;
    }

    @SuppressWarnings("deprecation")
    /**
     * Retrieves data for the specified movie.
     *
     * @param title the name of the title for which MovieData should be retrieved
     * @return a string representation of the MovieData, or null if an error occurred
     */

    public String getMovieData(String title) throws IOException {

        URL url = new URL("https://www.omdbapi.com/?t="+title+"&apikey="+API_KEY);
        URLConnection Url = url.openConnection();
        Url.setRequestProperty("Authorization", "Key" + API_KEY);
        BufferedReader reader = new BufferedReader(new InputStreamReader(Url.getInputStream()));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine())!=null) {
            stringBuilder.append(line);
        }
        reader.close();
        //handle an error if the chosen movie is not found
        String response= stringBuilder.toString();
        if (response.substring(response.length() - 27).equals("\"Error\":\"Movie not found!\"}")) {
            return "Please check movies name !!!";
        }
        else
            return response;
    }
    public int getImdbVotesViaApi(String moviesInfoJson){
        //TODO --> (This function must change and return the "ImdbVotes" as an Integer)
        // NOTICE :: you are not permitted to convert this function to return a String instead of an int !!!
        int ImdbVotes = 0;
        JSONObject ImdBV = new JSONObject(moviesInfoJson);
        ImdbVotes = Integer.parseInt(ImdBV.getString("imdbVotes").replace("," , ""));
        return ImdbVotes;
    }

    public String getRatingViaApi(String moviesInfoJson){
        //TODO --> (This function must return the rating in the "Ratings" part
        // where the source is "Internet Movie Database")  -->
        String rating = "";
        JSONObject jsonArray = new JSONObject(moviesInfoJson);
        JSONArray rate = jsonArray.getJSONArray("Ratings");
        for (int i = 0 ; i < rate.length() ; i++ ){
            JSONObject rate2 = rate.getJSONObject(i);
            if (rate2.getString("Source").equals("Internet Movie Database")){
                rating = rate2.getString("Value");
            }

        }

        return  "Rating :" + rating;
    }

    public String getActorListViaApi(String moviesInfoJson){
        //TODO --> (This function must return the "Actors" in actorsList)
        String Actors = "";
        JSONObject actors = new JSONObject(moviesInfoJson);
        Actors = actors.getString("Actors");
        return "Actors : " + Actors;
    }

    public String getDataDirector(String moviesInfoJson){
        String Director = "";
        JSONObject director = new JSONObject(moviesInfoJson);
        Director = director.getString("Director");
        return "Director : " + Director;
    }

    public String getDataWriter(String moviesInfoJson){
        String Writer = "";
        JSONObject writer = new JSONObject(moviesInfoJson);
        Writer = writer.getString("Writer");
        return "Writer : " + Writer;
    }

    public String getDataYear(String moviesInfoJson){
        String Year = "";
        JSONObject year = new JSONObject(moviesInfoJson);
        Year = year.getString("Year");
        return "Year : " + Year;
    }

    public String getDataReleased(String moviesInfoJson){
        String Released = "";
        JSONObject released = new JSONObject(moviesInfoJson);
        Released = released.getString("Released");
        return "Released : " + Released;
    }

    public String getDataRuntime(String moviesInfoJson){
        String Runtime = "";
        JSONObject runtime = new JSONObject( moviesInfoJson);
        Runtime = runtime.getString("Runtime");
        return "Runtime : " + Runtime;
    }

    public String getDataGenre(String moviesInfoJson){
        String Gener = "";
        JSONObject gener = new JSONObject(moviesInfoJson);
        Gener = gener.getString("Genre");
        return "Gener : " + Gener;
    }

    public String getDataPlot(String moviesInfoJson){
        String Plot = "";
        JSONObject plot = new JSONObject(moviesInfoJson);
        Plot = plot.getString("Plot");
        return "Plot : " + Plot;
    }

    public String getDataLanguage(String moviesInfoJson){
        String Language = "";
        JSONObject language = new JSONObject(moviesInfoJson);
        Language = language.getString("Language");
        return "Language : " + Language;
    }

    public String getDataCountry(String moviesInfoJson){
        String Country = "";
        JSONObject country = new JSONObject(moviesInfoJson);
        Country = country.getString("Country");
        return "Country : " + Country;
    }

    public String getDataAwards(String moviesInfoJson){
        String Awards = "";
        JSONObject awards = new JSONObject(moviesInfoJson);
        Awards = awards.getString("Awards");
        return "Awards : " + Awards;
    }


}