package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

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

}
