package gov.gsa._18f.hackathon.fall2015.datacenter.application.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.DatacenterSearchCriteria;
import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.QuarterlyData;

import java.util.List;

/**
 * @author dfladung
 *
 */
public interface DatacenterService {

	List<Datacenter> retrieveByCriteria(DatacenterSearchCriteria criteria) throws ApplicationException;

	Datacenter retrieve(Long id) throws ApplicationException;

	Long create(Datacenter datacenter) throws ApplicationException;

	Long create(Long id, QuarterlyData quarterlyData) throws ApplicationException;
	
	QuarterlyData retrieveQuarter(Long id) throws ApplicationException;

	List<QuarterlyData> retrieveQuartersByCriteria(DatacenterSearchCriteria dsc) throws ApplicationException;

}
