package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author dfladung
 *
 */
@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

	@Override
	public Response toResponse(ApplicationException e) {
		return Response.status(500).type(MediaType.APPLICATION_JSON_TYPE).entity(new RestApiError(e)).build();
	}
}
