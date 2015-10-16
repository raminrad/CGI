package gov.gsa._18f.hackathon.fall2015.datacenter.infrastructure.persistence.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;
import gov.gsa._18f.hackathon.fall2015.datacenter.infrastructure.persistence.BaseRepository;

import org.springframework.stereotype.Repository;

/**
 * @author dfladung
 *
 */
@Repository
public class DatacenterRepository extends BaseRepository<Datacenter> {

	public DatacenterRepository() {
		super(Datacenter.class);
	}

}
