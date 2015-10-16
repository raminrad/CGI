package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.datacenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter.DatacenterService;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dfladung
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/components.xml" })
public class DatacenterResourceTest {

	private static final Log logger = LogFactory.getLog(DatacenterResourceTest.class);

	private static final String PATH = "http://localhost:8080/datacenter-inventory/rest/datacenter";

	@Autowired
	DatacenterService datacenterService;

	protected Client getClient() {
		ClientConfig cc = new ClientConfig().register(new JacksonFeature());
		Client client = ClientBuilder.newClient(cc);
		return client;
	}

	@Test
	public void testCreate() {
		try {
			Datacenter d1 = new Datacenter();
			d1.getDatacenterInformation().setDatacenterId("FDCCI-DC-45736");
			d1.getDatacenterInformation().setAgencyDataCenterId("FDCCI-DC-2782");

			d1.getDatacenterInformation().setStatus("Existing");
			d1.getDatacenterInformation().setValidity("ValidFacility");
			d1.getDatacenterInformation().setAgencyAbbreviation("GSA");
			d1.getDatacenterInformation().setComponent("FAS");
			d1.getDatacenterInformation().setDatacenterName("3R-VA0080ZZ");
			d1.getDatacenterInformation().setPublishedName("Sterling, VA");
			d1.getDatacenterInformation().setClassification("NonCore");

			d1.getAddress().setCity("Sterling");
			d1.getAddress().setState("VA");
			d1.getAddress().setZip("20166");
			d1.getAddress().setState("MD");
			d1.getAddress().setCountry("US");

			WebTarget target = getClient().target(PATH);
			Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(
					Entity.entity(d1, MediaType.APPLICATION_JSON_TYPE));
			assertEquals(200, response.getStatus());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

}
