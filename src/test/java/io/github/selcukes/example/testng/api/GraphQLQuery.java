package io.github.selcukes.example.testng.api;

import lombok.Data;

@Data
public class GraphQLQuery {
    String query;
    Object variables;

}
