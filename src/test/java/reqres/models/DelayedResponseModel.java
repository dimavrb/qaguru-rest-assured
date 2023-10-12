package reqres.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude()
public class DelayedResponseModel {
    String page, per_page, total, total_pages;
    List<DelayedResponseDataModel> data;
    DelayedResponseSupportModel support;

 }
