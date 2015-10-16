package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.datacenter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter.DatacenterService;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.QuarterlyData;

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
	public void testBulkLoad() {
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

			d1.getServicesInformation().setAnnualCostPerSquareFt(100);
			d1.getServicesInformation().setColocationProvider(false);
			d1.getServicesInformation().setGrossFloorArea(1000);
			d1.getServicesInformation().setOwnershipType("Outsourcing");
			d1.getServicesInformation().setProvidingServices(false);

			WebTarget target = getClient().target(PATH);
			Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(
					Entity.entity(d1, MediaType.APPLICATION_JSON_TYPE));
			assertEquals(200, response.getStatus());

			QuarterlyData q1 = new QuarterlyData();
			q1.setAverageElectricityUsage(new BigDecimal(0));
			q1.setAverageItElectricityUsage(new BigDecimal(0));
			q1.setClosingFiscalYear(null);
			q1.setClosingQuarter(null);
			q1.setClosingStage("Not closing");
			q1.setCostPerKilowattHour(new BigDecimal(100.5));
			q1.setElectricityIndcluded(false);
			q1.setElectricityMetered(false);

			q1.setFte(new BigDecimal(20));
			q1.setFteCost(new BigDecimal(105));
			q1.setOtherServers(0);
			q1.setOverallFteReduction(7);
			q1.setRackCount(50);
			q1.setRealPropertyDisposition("test");
			q1.setTotalDecomissionedServers(1);
			q1.setTotalFloorAreaReclaimed(2);
			q1.setTotalHpcClusterNodes(3);
			q1.setTotalIbmMainframes(0);
			q1.setTotalItPowerCapacity(new BigDecimal(0));
			q1.setTotalServersMoved(100);
			q1.setTotalStorage(new BigDecimal(1000));
			q1.setTotalUnixServers(3);
			q1.setTotalVirtualHosts(0);
			q1.setTotalVirtualOs(9);
			q1.setTotalWindowsServers(2000);
			q1.setUsedStorage(new BigDecimal(500));

			for (int i = 2013; i < 2016; i++) {
				q1.setFiscalYear(i);
				for (int q = 1; q < 5; q++) {
					q1.setQuarter("Q" + q);

					WebTarget target2 = getClient().target(String.format("%s/%s/quarter", PATH, 1L));
					Response response2 = target2.request(MediaType.APPLICATION_JSON_TYPE).post(
							Entity.entity(q1, MediaType.APPLICATION_JSON_TYPE));
					assertEquals(200, response2.getStatus());
				}
			}

		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
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

			d1.getServicesInformation().setAnnualCostPerSquareFt(100);
			d1.getServicesInformation().setColocationProvider(false);
			d1.getServicesInformation().setGrossFloorArea(1000);
			d1.getServicesInformation().setOwnershipType("Outsourcing");
			d1.getServicesInformation().setProvidingServices(false);

			WebTarget target = getClient().target(PATH);
			Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(
					Entity.entity(d1, MediaType.APPLICATION_JSON_TYPE));
			assertEquals(200, response.getStatus());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	@Test
	public void testCreateQuarter() {
		try {

			QuarterlyData q1 = new QuarterlyData();
			q1.setAverageElectricityUsage(new BigDecimal(0));
			q1.setAverageItElectricityUsage(new BigDecimal(0));
			q1.setClosingFiscalYear(null);
			q1.setClosingQuarter(null);
			q1.setClosingStage("Not closing");
			q1.setCostPerKilowattHour(new BigDecimal(100.5));
			q1.setElectricityIndcluded(false);
			q1.setElectricityMetered(false);
			q1.setFiscalYear(2015);
			q1.setQuarter("Q1");
			q1.setFte(new BigDecimal(20));
			q1.setFteCost(new BigDecimal(105));
			q1.setOtherServers(0);
			q1.setOverallFteReduction(7);
			q1.setRackCount(50);
			q1.setRealPropertyDisposition("test");
			q1.setTotalDecomissionedServers(1);
			q1.setTotalFloorAreaReclaimed(2);
			q1.setTotalHpcClusterNodes(3);
			q1.setTotalIbmMainframes(0);
			q1.setTotalItPowerCapacity(new BigDecimal(0));
			q1.setTotalServersMoved(100);
			q1.setTotalStorage(new BigDecimal(1000));
			q1.setTotalUnixServers(3);
			q1.setTotalVirtualHosts(0);
			q1.setTotalVirtualOs(9);
			q1.setTotalWindowsServers(2000);
			q1.setUsedStorage(new BigDecimal(500));

			WebTarget target = getClient().target(String.format("%s/%s/quarter", PATH, 1L));
			Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(
					Entity.entity(q1, MediaType.APPLICATION_JSON_TYPE));
			assertEquals(200, response.getStatus());
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

}
