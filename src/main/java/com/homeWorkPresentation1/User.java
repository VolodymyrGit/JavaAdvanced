package com.homeWorkPresentation1;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String fullName;
    private List<Address> adresses;
    private int age;
    private List<Animal> animals;

    public User() {}

    public User(String fullName, List<Address> adresses, int age, List<Animal> animals) {
        this.fullName = fullName;
        this.adresses = adresses;
        this.age = age;
        this.animals = animals;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Address> getAddresses() {
        return adresses;
    }

    public void setAddresses(List<Address> adresses) {
        this.adresses = adresses;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void validateUserAge (User u) throws ClassCastException {
        if(u.getAge() < 18) {
            throw new ClassCastException("User age < 18");
        } else {
            System.out.println("Everything is ok");
        }
    }

    public void addAddressToUser(User u, Address a) {
        List<Address> newAddresses;
        newAddresses = u.getAddresses();
        newAddresses.add(a);
        u.setAddresses(newAddresses);
    }

    public void deleteAddressFromUser(User u, Address a) {
        List<Address> newAddresses;
        newAddresses = u.getAddresses();
        newAddresses.remove(a);
        u.setAddresses(newAddresses);
    }

    public void fullNameCorrections (User u, String newFullName) {
        u.setFullName(newFullName);
    }

    public User createUser() {
        Animal animal = new Animal("Dog", "Brovko");
        Address address = new Address("Ukraine", "Lviv");

        List<Address> adrList = new ArrayList();
        adrList.add(address);

        List<Animal> aniList = new ArrayList();
        aniList.add(animal);

        return new User("John Doe", adrList, 20, aniList);
    }
}

//    Створити клас User, який має у собі такі поля:
//        fullName
//        Address - клас
//        age
//        колекцію домашніх тварин List<Animal>
//
//Реалізувати такі методи та тести для них (для кожного тест або декілька) :
//        перевірки чи користувач повнолітній(якщо ні, то кидати кастомну помилку)
//        додавання адреси до користувача
//        видалення адреси в користувача
//        додати тваринку до списку тваринок
//        видалення тваринки в користувача
//        редагування поля fullName в користувача