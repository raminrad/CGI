package gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author dfladung
 *
 */
@Service("mockDatacenterServiceImpl")
public class MockDatacenterServiceImpl implements DatacenterService {

	@Override
	public List<Datacenter> retrieveByCriteria(DatacenterSearchCriteria criteria) throws ApplicationException {
		List<Datacenter> results = new ArrayList<Datacenter>();

		Datacenter d1 = new Datacenter();
		d1.setId(1L);
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

		results.add(d1);

		return results;
	}

}
