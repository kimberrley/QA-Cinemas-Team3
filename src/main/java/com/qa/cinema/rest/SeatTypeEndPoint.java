package com.qa.cinema.rest;

import javax.inject.Inject;
import com.qa.cinema.service.SeatTypeService;
import javax.ws.rs.*;

import com.qa.cinema.service.SeatTypeService;

@Path("seattype")
public class SeatTypeEndPoint {

	@Inject
	private SeatTypeService service;
	
	@GET
	@Path("json")
	@Produces({"application/json"})
	public String getSeatTypeAsJson(){
		return service.listAllSeatTypes();
		
	}
	
	@GET
	@Path("json")
	@Produces({"application/json"})
	public String getSeatTypeAsJsonBasedOnId(Long id){
		return service.listSeatTypeBasedOnId(id);
	}
	
}
