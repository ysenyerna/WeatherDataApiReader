import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
	public static void main(String[] args) {
		System.out.println("Weather Data API Reader");
		System.out.println("-----------------------\n");

		String url = "https://api.open-meteo.com/v1/forecast?latitude=41.85&longitude=-87.65&current=temperature_2m";

		System.out.println("Location: Chicago\n");
		System.out.println("Connecting to weather API...\n");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(url))
		.GET().build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("API Reponse:");
			System.out.println(response.body());
			System.out.println("\nWeather data retrieved successfully.");
		}
		catch (Exception e) {
			System.out.println("Error reading the Open-Meteo API");
			e.printStackTrace();
		}
		
	}

}
