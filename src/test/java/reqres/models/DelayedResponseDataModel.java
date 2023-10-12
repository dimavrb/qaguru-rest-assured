package reqres.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DelayedResponseDataModel {

    @JsonProperty("id")
    int id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("avatar")
    private String avatar;
}
