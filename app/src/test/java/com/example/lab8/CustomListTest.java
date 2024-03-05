package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }



    @Test
    public void hasCityTest() {
        list = MockCityList();
        assertFalse(list.hasCity("Edmonton")); // Assuming "Edmonton" is not initially in the list
        list.addCity(new City("Edmonton", "AB"));
        assertTrue(list.hasCity("Edmonton")); // After adding "Edmonton", it should return true
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City edmonton = new City("Edmonton", "AB");
        list.addCity(edmonton);
        assertTrue(list.hasCity("Edmonton")); // Check if "Edmonton" exists before deletion
        list.deleteCity(edmonton);
        assertFalse(list.hasCity("Edmonton")); // Check if "Edmonton" is deleted successfully
    }



}
