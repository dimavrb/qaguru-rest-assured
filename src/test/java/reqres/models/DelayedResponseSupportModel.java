package reqres.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DelayedResponseSupportModel {

    @JsonProperty("url")
    String url;

    @JsonProperty("text")
    String text;

}
