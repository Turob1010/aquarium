package com.black.akvarium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AkvariumApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(AkvariumApplication.class, args);

		FishService service = new FishService();
		service.generateFishDate();
		service.meetFish();

	}
}
