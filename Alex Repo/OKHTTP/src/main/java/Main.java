import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://swapi.dev/api/films")
                .build();

        Response response = client.newCall(request).execute();
        JsonNode root = mapper.readTree(response.body().string());
        response.close();
        JsonNode film = root.get("results").get(0);
        System.out.println(film.get("opening_crawl").asText());
    }
}
