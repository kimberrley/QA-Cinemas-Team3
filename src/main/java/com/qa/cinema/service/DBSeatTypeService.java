package com.qa.cinema.service;

import java.util.Collection;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.qa.cinema.persistence.SeatType;
import com.qa.cinema.util.JSONUtil;

public class DBSeatTypeService implements SeatTypeService{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	public String listAllSeatTypes(){	
		Query query = em.createQuery("SELECT m FROM SeatType m");
		Collection<SeatType> SeatTypes = (Collection<SeatType>) query.getResultList();
		return util.getJSONForObject(SeatTypes);
	};
	
	
	public String listSeatTypeBasedOnId(Long SeatId){
		SeatType seattype = findSeatType(SeatId);
		return util.getJSONForObject(seattype);
	};

	private SeatType findSeatType(Long seatId){
		return em.find(SeatType.class, seatId);
	}
}
