package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUsersResponse {

    int page, total;
    Support support;


    @Data
    public static class Support {
        String url, text;
    }
}
