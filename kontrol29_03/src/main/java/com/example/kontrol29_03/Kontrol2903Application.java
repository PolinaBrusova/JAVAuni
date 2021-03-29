package com.example.kontrol29_03;

import com.example.kontrol29_03.Models.Cathegory;
import com.example.kontrol29_03.Models.Client;
import com.example.kontrol29_03.Models.Task;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class Kontrol2903Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Kontrol2903Application.class, args);

        //Пример выполнения пост-запроса категории
        Cathegory testCathecory = new Cathegory("Countries");
        JSONObject cathegoryJSON = new JSONObject();
        cathegoryJSON.put("naming", testCathecory.getNaming());
        URL url = new URL("http://localhost:8080/api/Kr29/addCathegory");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setDoOutput(true);
        try(OutputStream os = httpURLConnection.getOutputStream()) {
            byte[] input = cathegoryJSON.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        //Пример выполнения постзапроса Клиента
        Client testClient = new Client("13pol", "Polina", "Brusova", "Igorevna", "13.01.2002");
        JSONObject clientJSON = new JSONObject();
        clientJSON.put("login", testClient.getLogin());
        clientJSON.put("firstName", testClient.getFirstName());
        clientJSON.put("lastName", testClient.getLastName());
        clientJSON.put("fatherName", testClient.getFatherName());
        clientJSON.put("birthDate", testClient.getBirthDate());
        URL url2 = new URL("http://localhost:8080/api/Kr29/addClient");
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url2.openConnection();
        httpURLConnection2.setRequestMethod("POST");
        httpURLConnection2.setRequestProperty("Content-Type", "application/json; utf-8");
        httpURLConnection2.setRequestProperty("Accept", "application/json");
        httpURLConnection2.setDoOutput(true);
        try(OutputStream os = httpURLConnection2.getOutputStream()) {
            byte[] input = clientJSON.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(httpURLConnection2.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }

        //Пример выполнения гет-запроса
        StringBuilder result4 = new StringBuilder();
        URL url4 = new URL("http://localhost:8080/api/Kr29/AllCathegories");
        HttpURLConnection httpURLConnection4 = (HttpURLConnection) url4.openConnection();
        httpURLConnection4.setRequestMethod("GET");
        try (var reader = new BufferedReader(
                new InputStreamReader(httpURLConnection4.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null;) {
                result4.append(line);
            }
            System.out.println(result4);
        }
    }

}
