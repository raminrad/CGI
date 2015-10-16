package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter.Datacenter;

import java.io.Serializable;
import java.util.List;

/**
 * @author dfladung
 *
 */
public class DatacenterList implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Datacenter> data;

	public DatacenterList() {

	}

	public DatacenterList(List<Datacenter> data) {
		this.data = data;
	}

	public List<Datacenter> getData() {
		return data;
	}

	public void setData(List<Datacenter> data) {
		this.data = data;
	}

}
