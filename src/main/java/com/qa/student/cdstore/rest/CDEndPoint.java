package com.qa.student.cdstore.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.student.cdstore.service.CdService;

@Path("/cdstore")
public class CDEndPoint {

	@Inject
	private CdService cdService;

	@GET
	@Path("/json")
	@Produces({ "application/json" })
	public String getCDsAsJson() {
		return cdService.getAllCDs();
	}

	@GET
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String getaCDAsJson(@PathParam("id") Integer id) {
		return cdService.getCD(id);
	}
	
	@POST
	@Path("/json")
	@Produces({ "application/json" })
	public String addNewCDToMap(String cdJson) {
		return cdService.addNewCDs(cdJson);
	}

	@PUT
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String replaceCDFromCDStore(@PathParam("id") Integer id, String cdJson) {
		return cdService.replaceCD(id, cdJson);
	}

	@DELETE
	@Path("/json/{id}")
	@Produces({ "application/json" })
	public String deleteCDFromCDStore(@PathParam("id") Integer id) {
		return cdService.deleteCD(id);
	}
	
}
