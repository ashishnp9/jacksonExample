package com.journaldev.jackson.model;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ashish Patel
 */
public class Test {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        Animal myDog = new Dog("ruffus","english shepherd");

        Animal myCat = new Cat("goya", "mice");

        try {

            String dogJson = objectMapper.writeValueAsString(myDog);

            System.out.println(dogJson);

            Animal deserializedDog = objectMapper.readValue(dogJson, Animal.class);

            if(deserializedDog instanceof Dog){
                Dog dog = (Dog) deserializedDog;
                sendMailToDog(dog);
            }else if(deserializedDog instanceof Cat){
                Cat cat = (Cat) deserializedDog;
                sendMailToCat(cat);
            }

//            System.out.println("Deserialized dogJson Class: " + deserializedDog.getClass().getSimpleName());
//
//            String catJson = objectMapper.writeValueAsString(myCat);
//
//            Animal deseriliazedCat = objectMapper.readValue(catJson, Animal.class);
//
//            System.out.println("Deserialized catJson Class: " + deseriliazedCat.getClass().getSimpleName());



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendMailToDog(Dog dog){
        System.out.println("getBreed ==> "+dog.getBreed());
    }

    public static void sendMailToCat(Cat cat){
        System.out.println("getFavoriteToy ==> "+cat.getFavoriteToy());
    }

}
