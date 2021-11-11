package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlePojo {
    @JsonProperty("date")
    private String date;

    @JsonProperty("layout")
    private String layout;

    @JsonProperty("categories")
    private List<String> categories;

    @JsonProperty("title")
    private String title;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("url")
    private String url;

    @JsonProperty("content")
    private String content;

    @JsonProperty("tags")
    private List<Object> tags;
}
