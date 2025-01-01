package com.shugl.dmos.model;

import lombok.Data;

@Data
public class Signal {
    private String signalId;
    private String timestamp;
    private String signalType;
    private String value;
}
