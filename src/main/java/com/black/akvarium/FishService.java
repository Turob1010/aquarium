package com.black.akvarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.black.akvarium.Constants.FEMALE;
import static com.black.akvarium.Constants.MALE;

public class FishService {
    Random random = new Random(1000);
    List<Fish> fishList = new ArrayList<>();
    List<Thread> threadList = new ArrayList<>();

    private void create(int fishId, boolean fishGender, int lifespan) throws InterruptedException {
        Thread.sleep(1000);
            String gender;
        if (fishGender) {
            gender = MALE;
        } else {
            gender =FEMALE;
        }
        Fish fish = new Fish(fishId, gender , lifespan);
        fishList.add(fish);
        threadList.add(new Thread(fish));
        System.out.println("fish Id  =  "
                + fishId
                + ",  "
                + "fish gender =  "
                + gender
                + ",  "
                + "lifeSpan =  "
                + lifespan
                + "  years");
    }

public void generateFishDate() throws InterruptedException {
       int fishCount = random.nextInt(20);
        for(int i = 0; i < fishCount; i++) {
            int fishId = random.nextInt(20);
            boolean fishGender = random.nextBoolean();
            int lifespan = 1 + random.nextInt(10);
          create(fishId, fishGender, lifespan);
        }
      System.out.println("Count of fish " +  fishCount);
      System.out.println("Count of male fish = " +
              fishList
                      .stream()
                      .filter(male -> male.gender.equals(MALE))
              .toList().size());
      System.out.println("Count of female fish = " +
              fishList
                      .stream()
                      .filter(male -> male.gender.equals(FEMALE))
              .toList().size());
      System.out.println();
  }

  public void meetFish() throws InterruptedException {
      List<String> genders = fishList
              .stream().map(f -> f.gender).toList();
      int countOfBabyFish = 0;
      for (String gender : genders) {
          int fishId = random.nextInt(20);
          boolean fishGender = random.nextBoolean();
          int lifespan = 1 + random.nextInt(15);
          if (!gender.equals(MALE)) {
              // new fish is created
              create(fishId, fishGender, lifespan);
              countOfBabyFish++;
          }
      }
      System.out.println("Baby fish were born  " + countOfBabyFish);
      System.out.println("Count of fish " +  fishList.size());
      System.out.println("Count of male fish = " +
              fishList
                      .stream()
                      .filter(male -> male.gender.equals(MALE))
                      .toList().size());
      System.out.println("Count of female fish = " +
              fishList
                      .stream()
                      .filter(male -> male.gender.equals(FEMALE))
                      .toList().size());
    }
}
