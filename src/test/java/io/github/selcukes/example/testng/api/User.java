package io.github.selcukes.example.testng.api;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class User {
    UUID id;
    String name;
    String rocket;
}
