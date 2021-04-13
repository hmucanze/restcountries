package com.mucanze.restcountriesapi.repository.country;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mucanze.restcountriesapi.model.Country;

public interface CountryRepositoryQuery {
	
	public List<Country> list(Pageable pageable);

}
