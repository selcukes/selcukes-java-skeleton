package io.github.selcukes.example.testng.api;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
	UUID id;
	String name;
	String rocket;
}
