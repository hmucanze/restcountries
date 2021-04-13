package com.mucanze.restcountriesapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mucanze.restcountriesapi.event.ResourceCreatedEvent;
import com.mucanze.restcountriesapi.model.Country;
import com.mucanze.restcountriesapi.repository.CountryRepository;
import com.mucanze.restcountriesapi.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryResource {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Country> list(Pageable pageable) {
		return countryRepository.list(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Country> getById(@PathVariable Long id) {
		Optional<Country> countryReturned = countryRepository.findById(id);
		
		return countryReturned.isPresent() ? ResponseEntity.ok(countryReturned.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Country> save(@Valid @RequestBody Country country, HttpServletResponse response) {
		Country countryReturned = countryService.save(country);
		publisher.publishEvent(new ResourceCreatedEvent(this, response, countryReturned.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(countryReturned);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Country> update(@Valid @RequestBody Country country, @PathVariable Long id) {
		Country countryReturuned = countryService.update(country, id);
		return ResponseEntity.ok(countryReturuned);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		countryRepository.deleteById(id);
	}

}
