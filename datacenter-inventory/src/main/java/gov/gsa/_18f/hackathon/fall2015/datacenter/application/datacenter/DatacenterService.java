package gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;

import java.util.List;

/**
 * @author dfladung
 *
 */
public interface DatacenterService {

	List<Datacenter> retrieveByCriteria(DatacenterSearchCriteria criteria) throws ApplicationException;

}
