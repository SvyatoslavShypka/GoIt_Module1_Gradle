package com.goit.dto;

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

        NameDto dto = null;
        try {
            dto = gson.fromJson(new String(stream.readAllBytes()), NameDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(dto);
//        System.out.println("================================");
//        dto.setName(null);
        String toJson = gson.toJson(dto);
        System.out.println(toJson);

        }

    }
}
