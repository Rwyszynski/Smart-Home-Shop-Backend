package com.kodilla.smarthomeshop.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApi {

    public double getEuroExchangeRate() throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.nbp.pl/api/exchangerates/rates/a/eur/?format=json"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper = new ObjectMapper();
        CurrencyData data = mapper.readValue(response.body(), CurrencyData.class);
        return data.getRates().get(0).getMid();
    }
}
