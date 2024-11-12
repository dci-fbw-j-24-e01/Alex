package com.example.f10_pagingSorting.db;

import com.example.f10_pagingSorting.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
