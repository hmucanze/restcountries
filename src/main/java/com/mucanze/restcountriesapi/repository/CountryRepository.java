package com.mucanze.restcountriesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mucanze.restcountriesapi.model.Country;
import com.mucanze.restcountriesapi.repository.country.CountryRepositoryQuery;

public interface CountryRepository extends JpaRepository<Country, Long>, CountryRepositoryQuery {

}
