package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter.DatacenterService;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.QuarterlyData;
import gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.BaseResource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dfladung
 *
 */
@Path("/datacenter")
public class DatacenterResource extends BaseResource {

	private static final Log logger = LogFactory.getLog(DatacenterResource.class);

	@Autowired
	DatacenterService datacenterService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public DatacenterList retrieve(@QueryParam("fromDate") String fromDate) {
		try {
			// Date from = (StringUtils.isEmpty(fromDate)) ? new DateTime().withTimeAtStartOfDay().toDate()
			// : parseDate(fromDate);

			DatacenterSearchCriteria search = new DatacenterSearchCriteria();

			List<Datacenter> data = datacenterService.retrieveByCriteria(search);
			return new DatacenterList(data);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Datacenter retrieve(@PathParam("id") Long id) {
		try {
			Datacenter data = datacenterService.retrieve(id);
			return data;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Datacenter create(Datacenter input) {
		try {
			Long id = datacenterService.create(input);
			Datacenter data = datacenterService.retrieve(id);
			return data;
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/quarter/{quarterId}")
	public QuarterlyData retrieveQuarter(@PathParam("id") Long id, @PathParam("quarterId") Long qid) {
		try {
			return datacenterService.retrieveQuarter(qid);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}/quarter")
	public QuarterlyData create(@PathParam("id") Long id, QuarterlyData data) {
		try {
			Long qid = datacenterService.create(id, data);
			return datacenterService.retrieveQuarter(qid);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}
}
