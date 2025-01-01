package com.shugl.dmos.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;

@DynamoDBTable(tableName = "MarketingSignals")
@Data
public class Signal {

    @DynamoDBHashKey
    private String signalId;  // This is now the hash key for DynamoDB

    private String timestamp;
    private String signalType;
    private String value;
}
