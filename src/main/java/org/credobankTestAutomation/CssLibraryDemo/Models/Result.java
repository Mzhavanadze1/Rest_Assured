package org.credobankTestAutomation.CssLibraryDemo.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Result {
    @JsonProperty("Id")
    public int id;
    @JsonProperty("OperationId")
    public int operationId;
    @JsonProperty("OperationTypeId")
    public int operationTypeId;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("AMLStatusId")
    public int aMLStatusId;
    @JsonProperty("PersonalN")
    public String personalN;
    @JsonProperty("PersonId")
    public int personId;
}
