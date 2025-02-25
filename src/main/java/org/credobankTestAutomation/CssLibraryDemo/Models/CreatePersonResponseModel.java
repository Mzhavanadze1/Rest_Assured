package org.credobankTestAutomation.CssLibraryDemo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.transform.Result;
import java.util.LinkedHashMap;

@Getter
@Setter
@ToString
public class CreatePersonResponseModel {
    public boolean success;
    @JsonProperty("Version")
    public String version;
    @JsonProperty("StatusCode")
    public int statusCode;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Result")
    public LinkedHashMap result;
    @JsonProperty("error")
    public String error;

}
