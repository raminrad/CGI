package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import java.io.Serializable;

/**
 * @author dfladung
 *
 */
public class DatacenterSearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
