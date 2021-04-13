package com.mucanze.restcountriesapi.repository.country;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.mucanze.restcountriesapi.model.Country;

public class CountryRepositoryImpl implements CountryRepositoryQuery {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Country> list(Pageable pageable) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Country> criteria = builder.createQuery(Country.class);
		Root<Country> root = criteria.from(Country.class);
		
		Sort sort = pageable.getSort();
		if(sort.isSorted()) {
			Sort.Order order = sort.iterator().next();
			String property = order.getProperty();
			
			criteria.orderBy(order.isAscending() ? builder.asc(root.get(property)) : builder.desc(root.get(property)));
		}
		
		criteria.select(root);
		TypedQuery<Country> query = entityManager.createQuery(criteria);
		return query.getResultList();
	}

}
