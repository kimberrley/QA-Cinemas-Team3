package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ShowingService;



	@Path("/bookstore")
	public class ShowingEndPoint {

		@Inject
		private ShowingService ShowingService;

		@GET
		@Path("/json")
		@Produces({ "application/json" })
		public String getShowingsAsJson() {
			return ShowingService.getAllShowings();
		}
		
		@GET
		@Path("/json/{id}")
		@Produces({ "application/json" })
			public String getShowingBasedOnIDAsJson(@PathParam("screenId") Long id) {
				return ShowingService.getShowingBasedOnId(id);
			}


}