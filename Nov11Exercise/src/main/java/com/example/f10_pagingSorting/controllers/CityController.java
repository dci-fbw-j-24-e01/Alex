package com.example.f10_pagingSorting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

    @GetMapping("/")
    public String root() {

        return "index";
    }
    // Exercise:
    // Create a page where you show a table with the cities in the DB
    // use pagination to show only 50 cities in each page
    // pagination should have a Next button and a Previous button
    // those buttons should only be enabled/visible if there is a next or previous
    //
    //
    // BONUS 1:
    // Add a select that allows you to choose between 20, 50, 100 or 200 cities at a time
    //
    // BONUS 2:
    // Add a select that allows you to sort by
    // - Default (by id)
    // - Name ASC
    // - Name DESC
    // - Pop ASC
    // - POP DESC
    //
    // BONUS 3:
    // Add number buttons to the page navigator
    // You should show a maximum of 6 number buttons in case there are more than 6 pages
    // <First> <Previous> <1> <2> ... <4> <5> <Next> <Last>
}
