package com.mucanze.restcountriesapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mucanze.restcountriesapi.model.Country;
import com.mucanze.restcountriesapi.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public Country save(Country country) {
		if(country.getSubRegion().getId() == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return countryRepository.save(country);
	}

	public Country update(Country country, Long id) {
		Country countrySaved = countryRepository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		
		BeanUtils.copyProperties(country, countrySaved, "id");
		countryRepository.save(countrySaved);
		
		return countrySaved;
	}

}
