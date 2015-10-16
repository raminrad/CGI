package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter.DatacenterService;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;
import gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.BaseResource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
