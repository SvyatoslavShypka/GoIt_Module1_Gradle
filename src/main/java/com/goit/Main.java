package com.goit;

import com.goit.dto.CurrencyDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {

        try (InputStream stream = Main.class.getClassLoader().getResourceAsStream("ex1.json")) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();

        CurrencyDto dto = null;
        try {
            dto = gson.fromJson(new String(stream.readAllBytes()), CurrencyDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String toJson = gson.toJson(dto);
        System.out.println(toJson);
        }
    }
}
