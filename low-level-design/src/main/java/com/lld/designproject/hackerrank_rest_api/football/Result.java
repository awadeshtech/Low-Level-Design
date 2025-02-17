package com.lld.designproject.hackerrank_rest_api.football;

import com.lld.designproject.hackerrank_rest_api.Driver;
import java.io.*;
import java.math.*;
import java.net.URL;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Result {
    private static String BASE_URL = "https://jsonmock.hackerrank.com/api/";

    class Data {
        String team1;
        String team2;
        String team1goals;
        String team2goals;
    }

    class Response {
        private int total_pages;
        private int per_page;
        private int total;
        List<Data> data;

        public int getTotalPages() {
            return total_pages;
        }

        public List<Data> getData() {
            return data;
        }
    }

    /*
     * Complete the 'getTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING team
     *  2. INTEGER year
     * output 35
     */


    public static void main(String[] args) {
        System.out.println(getTotalGoals("Barcelona", 2011));
    }

    public static int getTotalGoals(String team, int year) {
        String homeTeam = "football_matches?year=%s&team1=%s&page=%s";
        String visitingTeam = "football_matches?year=%s&team2=%s&page=%s";
        Stream<Data> result1 = FootballMatchApiInvoker.invokeAPI(BASE_URL + homeTeam, team, year);
        Stream<Data> result2 = FootballMatchApiInvoker.invokeAPI(BASE_URL + visitingTeam, team, year);
        return result1.mapToInt(data -> Integer.parseInt(data.team1goals)).sum() +
            result2.mapToInt(data -> Integer.parseInt(data.team2goals)).sum();
    }

    class FootballMatchApiInvoker {
        public static <Data> Stream<Data> invokeAPI(String url, String team, int year) {

            final Response firstPageResponse =
                HttpApiInvoker.invoke(String.format(url, year, team, 1), Response.class);


            return (Stream<Data>) Stream.concat(Stream.of(firstPageResponse),
                    IntStream.rangeClosed(2, firstPageResponse.getTotalPages()).parallel()
                        .mapToObj(i -> String.format(url, year, team, i))
                        .map(uri -> HttpApiInvoker.invoke(uri, Response.class))).map(Response::getData)
                .flatMap(List::stream);


        }
    }

    class HttpApiInvoker {
        private static final Gson gson = new Gson();

        public static Response invoke(final String url, final Class clazz) {
            final String finalUrl = url.replace(" ", "%20");
            final StringBuilder stringBuilder = new StringBuilder();
            try {
                final HttpsURLConnection connection = (HttpsURLConnection) new URL(finalUrl).openConnection();
                connection.getResponseCode();
                try (BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                    String l;
                    while ((l = bufferedReader.readLine()) != null) {
                        stringBuilder.append(l);
                    }
                }
                connection.disconnect();
            } catch (final Exception e) {

            }
            return (Response) gson.fromJson(stringBuilder.toString(), clazz);
        }
    }

}
