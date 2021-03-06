package com.huawei.openstack4j.model.cloudeye;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by coa.ke on 6/24/17.
 */
public enum  Filter {
    AVERAGE, VARIANCE, MIN, MAX, SUM;

    @JsonValue
    public String value() {
        return name().toLowerCase();
    }

    //default to DESC
    @JsonCreator
    public static Filter value(String v)
    {
        try {
            return valueOf(v.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
