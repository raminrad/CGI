package gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;

import java.util.ArrayList;
import java.util.List;

import org.jvnet.hk2.annotations.Service;

/**
 * @author dfladung
 *
 */
@Service(name = "mockDatacenterServiceImpl")
public class MockDatacenterServiceImpl implements DatacenterService {

	@Override
	public List<Datacenter> retrieveByCriteria(DatacenterSearchCriteria criteria) throws ApplicationException {
		List<Datacenter> results = new ArrayList<Datacenter>();

		Datacenter d1 = new Datacenter();
		d1.getDatacenterInformation().setId(1L);
		results.add(d1);

		return results;
	}

}
