package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author dfladung
 *
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "datacenters")
public class Datacenter extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Embedded
	DatacenterInformation datacenterInformation;

	@Embedded
	Address address;

	@Embedded
	ServicesInformation servicesInformation;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	List<QuarterlyData> quarterlyData;

	public Datacenter() {
		datacenterInformation = new DatacenterInformation();
		address = new Address();
		servicesInformation = new ServicesInformation();
		quarterlyData = new ArrayList<QuarterlyData>();
	}

	@Override
	public String toString() {
		return String.format("Datacenter [datacenterInformation=%s, servicesInformation=%s, address=%s]",
				datacenterInformation, servicesInformation, address);
	}

	public DatacenterInformation getDatacenterInformation() {
		return datacenterInformation;
	}

	public void setDatacenterInformation(DatacenterInformation datacenterInformation) {
		this.datacenterInformation = datacenterInformation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<QuarterlyData> getQuarterlyData() {
		return quarterlyData;
	}

	public void setQuarterlyData(List<QuarterlyData> quarterlyData) {
		this.quarterlyData = quarterlyData;
	}

	public ServicesInformation getServicesInformation() {
		return servicesInformation;
	}

	public void setServicesInformation(ServicesInformation servicesInformation) {
		this.servicesInformation = servicesInformation;
	}

}
