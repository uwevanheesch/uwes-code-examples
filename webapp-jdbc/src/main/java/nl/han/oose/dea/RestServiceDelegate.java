package nl.han.oose.dea;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import nl.han.oose.dea.webservices.MyObjectMapper;

import java.io.IOException;
import java.util.List;

public class RestServiceDelegate {

    public static final String REST_URL = "http://localhost:8080/items";

    public RestServiceDelegate() {
        Unirest.setObjectMapper(new MyObjectMapper());
    }

    public Item getItem(String name){
        Item retValue = null;

        try {
            HttpResponse<Item> jsonResponse = Unirest.get(REST_URL+ "/"+name)
                    .header("accept", "application/json")
                    .asObject(Item.class);
            retValue = jsonResponse.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return retValue;
    }

    public void postItem(Item item) throws RuntimeException {
        HttpResponse<String> response = null;
        try {
            response = Unirest.post(REST_URL)
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(item)
                    .asString();

        } catch (UnirestException e) {
            throw new RuntimeException(response.getStatusText(), e);
        }
    }

    public List<Item> getAllItems() {
        List<Item> itemList = null;
        try {
            HttpResponse<JsonNode> jsonResponse = Unirest.get(REST_URL)
                    .header("accept", "application/json")
                    .asJson();

            ObjectMapper objectMapper = new ObjectMapper();
            TypeFactory typeFactory = objectMapper.getTypeFactory();

            String response = jsonResponse.getBody().toString();

            try {
                itemList =
                        objectMapper.readValue(response,
                                typeFactory.constructCollectionType(List.class, Item.class));


            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return itemList;
    }

}
