package com.lld.designproject.hackerrank_rest_api;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.net.ssl.*;

public class Driver {
    public static void main(String[] args) {
        //Invoke Rest API with paginated response & calculate average pulse for given doctor.id, diagnosis.name from response.
        System.out.println(Result.invoke(2, "Pulmonary embolism"));
    }

    class Result {

        class Data {
            Diagnosis diagnosis;
            Doctor doctor;
            Vitals vitals;
        }

        class Doctor {
            int id;
        }

        class Vitals {
            int pulse;
        }

        class Diagnosis {
            String name;
        }

        // create a class to deserialize response
        class ResponseData extends HackerRankAPIInvoker.Response<Data> {
        }

        public static int invoke(int doctorId, String diagnosisName) {
            return HackerRankAPIInvoker.invokeAPI("/medical_records?page=%s", ResponseData.class)
                .filter(data -> data.doctor.id == doctorId && data.diagnosis.name.equals(diagnosisName))
                .mapToInt(data -> data.vitals.pulse)
                .average()
                .stream()
                .mapToLong(Math::round)
                .mapToInt(e -> (int) e)
                .findAny()
                .orElse(0);
        }
    }

    class HackerRankAPIInvoker {
        private static final String BASE_URL = "https://jsonmock.hackerrank.com/api";

        public static abstract class Response<Data> {
            private int total_pages;

            private List<Data> data;

            public int getTotalPages() {
                return total_pages;
            }

            public List<Data> getData() {
                return data;
            }
        }

        public static <Data> Stream<Data> invokeAPI(
            final String url,
            final Class<? extends Response<Data>> clazz) {
            final Response firstPageResponse = HttpAPIInvoker.invoke(String.format(BASE_URL + url, 1), clazz);
            return Stream.concat(Stream.of(firstPageResponse),
                    IntStream.rangeClosed(2, firstPageResponse.getTotalPages())
                        .parallel()
                        .mapToObj(i -> String.format(BASE_URL + url, i))
                        .map(uri -> HttpAPIInvoker.invoke(uri, clazz)))
                .map(Response::getData)
                .flatMap(List::stream);
        }
    }

    class HttpAPIInvoker {
        private static final Gson GSON = new Gson();

        public static <Response> Response invoke(final String url, final Class<Response> clazz) {
            final String finalUrl = url.replace(" ", "%20");
            final StringBuilder responseBuilder = new StringBuilder();
            try {
                final HttpsURLConnection connection = (HttpsURLConnection) new URL(finalUrl).openConnection();
                connection.getResponseCode();
                try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                    String l;
                    while ((l = bufferedReader.readLine()) != null) {
                        responseBuilder.append(l);
                    }
                }
                connection.disconnect();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
            return GSON.fromJson(responseBuilder.toString(), clazz);
        }
    }

}
