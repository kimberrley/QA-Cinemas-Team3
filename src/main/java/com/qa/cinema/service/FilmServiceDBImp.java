package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Film;
import com.qa.cinema.util.JSONUtil;


@Stateless
@Default
public class FilmServiceDBImp implements FilmService{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllFilms() {
		Query query = em.createQuery("SELECT m FROM Film m");
		@SuppressWarnings("unchecked")
		Collection<Film> films = (Collection<Film>) query.getResultList();
		return util.getJSONForObject(films);
	}

	@Override
	public String getFilmById(Long filmId) {
		Query query = em.createQuery("SELECT f FROM Film f WHERE filmId =" + filmId);
		Film film = (Film) query.getSingleResult();
		return util.getJSONForObject(film);
	}

	@Override
	public String addNewFilm(String filmJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeFilm(Long filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateFilm(Long filmId, String filmUpdated) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}