package com.shugl.dmos.lambda;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;

public class SignalProcessor implements RequestHandler<Map<String, String>, String> {

    private final DynamoDB dynamoDB = new DynamoDB(AmazonDynamoDBClientBuilder.defaultClient());

    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        try {
            String tableName = "MarketingSignals";
            Table table = dynamoDB.getTable(tableName);
            table.putItem(new Item()
                    .withPrimaryKey("SignalID", event.get("SignalID"))
                    .withString("Timestamp", event.get("Timestamp"))
                    .withString("SignalType", event.get("SignalType"))
                    .withString("Value", event.get("Value")));
            return "Signal stored successfully!";
        } catch (Exception e) {
            context.getLogger().log("Error: " + e.getMessage());
            return "Failed to process signal.";
        }
    }
}
