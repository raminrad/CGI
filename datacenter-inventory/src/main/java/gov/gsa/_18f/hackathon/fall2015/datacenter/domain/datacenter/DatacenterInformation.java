package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dfladung
 *
 */
@Embeddable
public class DatacenterInformation extends BaseValueObject {

	private static final long serialVersionUID = 1L;

	@Column(name = "datacenter_name", nullable = false)
	String datacenterName;

	@Column(name = "datacenter_id", unique = true, nullable = false)
	String datacenterId;

	@Column(name = "ageny_datacenter_id", nullable = false)
	String agencyDataCenterId;

	@Column(name = "legacy_id")
	String legacyId;

	@Column(name = "published_name", nullable = false)
	String publishedName;

	@Column(nullable = false)
	String status;

	@Column(nullable = false)
	String validity;

	@Column(name = "agency_abbreviation", nullable = false)
	String agencyAbbreviation;

	@Column(nullable = false)
	String component;

	@Column(name = "office_name")
	String officeName;

	@Column(nullable = false)
	String classification;

	@Column
	String subcategory;

	@Override
	public String toString() {
		return String
				.format("DatacenterInformation [datacenterId=%s, agencyDataCenterId=%s, legacyId=%s, datacenterName=%s, publishedName=%s, status=%s]",
						datacenterId, agencyDataCenterId, legacyId, datacenterName, publishedName, status);
	}

	public String getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(String datacenterId) {
		this.datacenterId = datacenterId;
	}

	public String getAgencyDataCenterId() {
		return agencyDataCenterId;
	}

	public void setAgencyDataCenterId(String agencyDataCenterId) {
		this.agencyDataCenterId = agencyDataCenterId;
	}

	public String getLegacyId() {
		return legacyId;
	}

	public void setLegacyId(String legacyId) {
		this.legacyId = legacyId;
	}

	public String getDatacenterName() {
		return datacenterName;
	}

	public void setDatacenterName(String datacenterName) {
		this.datacenterName = datacenterName;
	}

	public String getPublishedName() {
		return publishedName;
	}

	public void setPublishedName(String publishedName) {
		this.publishedName = publishedName;
	}

	public String getAgencyAbbreviation() {
		return agencyAbbreviation;
	}

	public void setAgencyAbbreviation(String agencyAbbreviation) {
		this.agencyAbbreviation = agencyAbbreviation;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

}
