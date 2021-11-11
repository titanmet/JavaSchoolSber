package impl;

import config.TestConfig;
import lombok.extern.log4j.Log4j2;
import io.restassured.response.ValidatableResponse;
import model.ArticlePojo;
import service.ArticleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static io.restassured.RestAssured.given;
@Log4j2
public class ArticleServiceImpl implements ArticleService {
    TestConfig testConfig = new TestConfig();
    @Override
    public List<ArticlePojo> getArticles(String url) {
        String URL = testConfig.getURL() + url;
        List<ArticlePojo> articles = new ArrayList<>();

        ValidatableResponse rs = given().log().all()
                .get(URL)
                .then().log().ifError();
        RUN_CONTEXT.put("response", rs);
        try {
            articles = rs.extract().jsonPath().getList("articles.", ArticlePojo.class);
        } catch (Exception e) {
            log.error("Articles request exception: " + Arrays.toString(e.getStackTrace()));
        }
        return articles;
    }
}
