package io.github.selcukes.example.testng.api;

import com.fasterxml.jackson.databind.JsonNode;
import io.github.selcukes.core.page.ApiPage;
import io.github.selcukes.core.page.Pages;
import org.testng.annotations.Test;

import java.util.UUID;

public class GraphQLTest {
    ApiPage page;

    @Test(description = "Get Company data and verify CEO")
    public void verifyCeoTest() {

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("{ company { name ceo coo } }");
        page = Pages.apiPage();
        JsonNode body = page.request("https://api.spacex.land/graphql/")
            .post(query)
            .bodyJson()
            .at("/data/company/ceo");
        page.assertThat().object(body.asText()).isEqualTo("Elon Musk");
    }


    @Test(description = "Get Launches and verify MissionName should be 'Thaicom6'")
    public void verifyMissionName() {

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("query getLaunches($limit: Int!){ launches(limit: $limit) { mission_name } }");

        QueryLimit queryLimit = new QueryLimit();
        queryLimit.setLimit(10);
        query.setVariables(queryLimit);

        page = Pages.apiPage();
        JsonNode body = page.request("https://api.spacex.land/graphql/")
            .post(query)
            .bodyJson()
            .at("/data/launches")
            .get(0)
            .get("mission_name");
        page.assertThat().object(body.asText()).isEqualTo("Thaicom 6");

    }

    @Test(description = "Add User and verify returned data should correspond to data sent")
    public void verifyUserData() {

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation insert_users ($id: uuid!, $name: String!, $rocket: String!) { insert_users(objects: {id: $id, name: $name, rocket: $rocket}) { returning { id name rocket } } }");

        User myUser = User.builder()
            .id(UUID.randomUUID())
            .name("Selcukes")
            .rocket("One Stop Automation")
            .build();

        query.setVariables(myUser);

        page = Pages.apiPage();
        JsonNode body = page.request("https://api.spacex.land/graphql/")
            .post(query)
            .bodyJson()
            .at("/data/insert_users/returning")
            .get(0);
        page.assertThat().object(body.get("name").asText()).isEqualTo("Selcukes");
        page.assertThat().object(body.get("rocket").asText()).isEqualTo("One Stop Automation");
    }
}
