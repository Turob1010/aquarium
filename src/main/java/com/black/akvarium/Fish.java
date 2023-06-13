package com.black.akvarium;

public class Fish implements Runnable{
int id;
String gender;
int lifespan;

    public Fish(int id, String gender, int lifespan) {
        this.id = id;
        this.gender = gender;
        this.lifespan = lifespan;
    }

    @Override
    public void run() {

    }
}
