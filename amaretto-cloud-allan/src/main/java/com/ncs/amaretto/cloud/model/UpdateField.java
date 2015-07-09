package com.ncs.amaretto.cloud.model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "fieldName", "fieldValue" })
public class UpdateField {

    @JsonProperty("FieldName")
    private String fieldName;

    @JsonProperty("FieldValue")
    private String fieldValue;

    public static final UpdateField newInstance(String fieldName, String fieldValue) {
        UpdateField newInstance = new UpdateField();

        newInstance.fieldName = fieldName;
        newInstance.fieldValue = fieldValue;

        return newInstance;

    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

}
