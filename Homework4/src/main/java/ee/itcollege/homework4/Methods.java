package ee.itcollege.homework4;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;

class Methods {

    public static HashMap<String, String> getNew() {
        HashMap<String, String> oldNews = decodeJson();
        HashMap<String, String> actualNews = getHeadlines();
        HashMap<String, String> newNews = new HashMap<String, String>();

        Iterator actualIterator = actualNews.keySet().iterator();

        while(actualIterator.hasNext()) {
            String actualKey = actualIterator.next().toString();
            String actualValue = actualNews.get(actualKey);

            if(!oldNews.containsKey(actualKey))
                newNews.put(actualKey, actualValue);
        }
        oldNews.putAll(newNews);
        encodeJson(oldNews);

        return newNews;

    }

    public static HashMap<String, String> getHeadlines() {
        String url = "http://www.delfi.ee/";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            System.out.println("Could not connect to page specified. Error: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Could not connect to page specified. Error: " + e);
        }
        Elements headlines = doc.getElementsByClass("article-title");

        for(Element headline: headlines) {
            String time = LocalDateTime.now().toString().substring(0, 10);
            hashMap.put(headline.text(), time + headline.attr("href"));

        }

        return hashMap;
    }

    public static void encodeJson(HashMap<String, String> newMap) {
        JSONObject obj = new JSONObject();


        HashMap<String, String> oldMap = decodeJson();
        newMap.putAll(oldMap);
        Iterator iterator = newMap.keySet().iterator();

        while(iterator.hasNext()) {
            String key = iterator.next().toString();
            obj.put(key, newMap.get(key));
        }
        String toWrite = obj.toString();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\eriks\\Documents\\Git\\JavaTechnologies\\Homework4\\src\\main\\resources\\Json.txt"));
            writer.write(toWrite);
            writer.close();
        } catch (IOException e) {
            System.out.println("Json.txt not found!");
        }
    }

    public static HashMap<String, String> decodeJson() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\eriks\\Documents\\Git\\JavaTechnologies\\Homework4\\src\\main\\resources\\Json.txt"));
            String toRead = reader.readLine();


            JSONObject obj = new JSONObject(toRead);
            Iterator iterator = obj.keys();
            while(iterator.hasNext()) {
                String key = iterator.next().toString();
                String value = obj.get(key).toString();
                hashMap.put(key, value);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Json.txt not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static void printMap(HashMap<String, String> hashMap) {
        Iterator iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = hashMap.get(key);

            System.out.println(key);
            System.out.println(value.substring(0, 10));
            System.out.println("(" + value.substring(10, value.length()) + ")");
            System.out.println();
        }
    }

}
