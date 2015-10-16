package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import java.util.List;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@org.hibernate.annotations.Table(appliesTo = "datacenters")
public class Datacenter extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Embedded
	DatacenterInformation datacenterInformation;

	@Embedded
	ProviderInformation providerInformation;

	@Embedded
	Address address;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval = true)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinColumn(name = "datacenter_id", nullable = false)
	List<QuarterlyData> quarterlyData;

	public Datacenter() {
		datacenterInformation = new DatacenterInformation();
		providerInformation = new ProviderInformation();
		address = new Address();
	}

	@Override
	public String toString() {
		return String.format("Datacenter [datacenterInformation=%s, providerInformation=%s, address=%s]",
				datacenterInformation, providerInformation, address);
	}

	public DatacenterInformation getDatacenterInformation() {
		return datacenterInformation;
	}

	public void setDatacenterInformation(DatacenterInformation datacenterInformation) {
		this.datacenterInformation = datacenterInformation;
	}

	public ProviderInformation getProviderInformation() {
		return providerInformation;
	}

	public void setProviderInformation(ProviderInformation providerInformation) {
		this.providerInformation = providerInformation;
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

}
