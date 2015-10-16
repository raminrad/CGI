package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

/**
 * @author dfladung
 *
 */
@Embeddable
public class DatacenterInformation extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "datacenter_id", unique = true, nullable = false)
	String datacenterId;

	@Column(name = "ageny_datacenter_id", nullable = false)
	String agencyDataCenterId;

	@Column(name = "legacy_id")
	String legacyId;

}
