package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dfladung
 *
 */
@Embeddable
public class ServicesInformation extends BaseValueObject {

	private static final long serialVersionUID = 1L;

	@Column(name = "ownership_type", nullable = false)
	String ownershipType;

	@Column(name = "colocation_provider", nullable = false)
	Boolean colocationProvider;

	@Column(name = "colocation_provider_type")
	String colocationProviderType;

	@Column(name = "government_wide_provider")
	@org.hibernate.annotations.Type(type = "yes_no")
	Boolean governmentWidePartner;

	@Column(name = "providing_services", nullable = false)
	@org.hibernate.annotations.Type(type = "yes_no")
	Boolean providingServices;

	@Column(name = "percent_services_paid")
	Integer percentServicesPaid;

	@Column(name = "other_agencies_serviced")
	String otherAgenciesServiced;

	@Column(name = "datacenter_tier")
	String datacenterTier;

	@Column(name = "gross_floor_area", nullable = false)
	Integer grossFloorArea;

	@Column(name = "total_customer_floor_area")
	Integer totalCustomerFloorArea;

	@Column(name = "annual_cost", nullable = false)
	Integer annualCostPerSquareFt;

	public Integer getGrossFloorArea() {
		return grossFloorArea;
	}

	public void setGrossFloorArea(Integer grossFloorArea) {
		this.grossFloorArea = grossFloorArea;
	}

	public Integer getTotalCustomerFloorArea() {
		return totalCustomerFloorArea;
	}

	public void setTotalCustomerFloorArea(Integer totalCustomerFloorArea) {
		this.totalCustomerFloorArea = totalCustomerFloorArea;
	}

	public Integer getAnnualCostPerSquareFt() {
		return annualCostPerSquareFt;
	}

	public void setAnnualCostPerSquareFt(Integer annualCostPerSquareFt) {
		this.annualCostPerSquareFt = annualCostPerSquareFt;
	}

	public String getOwnershipType() {
		return ownershipType;
	}

	public void setOwnershipType(String ownershipType) {
		this.ownershipType = ownershipType;
	}

	public Boolean getColocationProvider() {
		return colocationProvider;
	}

	public void setColocationProvider(Boolean colocationProvider) {
		this.colocationProvider = colocationProvider;
	}

	public String getColocationProviderType() {
		return colocationProviderType;
	}

	public void setColocationProviderType(String colocationProviderType) {
		this.colocationProviderType = colocationProviderType;
	}

	public Boolean getGovernmentWidePartner() {
		return governmentWidePartner;
	}

	public void setGovernmentWidePartner(Boolean governmentWidePartner) {
		this.governmentWidePartner = governmentWidePartner;
	}

	public Boolean getProvidingServices() {
		return providingServices;
	}

	public void setProvidingServices(Boolean providingServices) {
		this.providingServices = providingServices;
	}

	public Integer getPercentServicesPaid() {
		return percentServicesPaid;
	}

	public void setPercentServicesPaid(Integer percentServicesPaid) {
		this.percentServicesPaid = percentServicesPaid;
	}

	public String getOtherAgenciesServiced() {
		return otherAgenciesServiced;
	}

	public void setOtherAgenciesServiced(String otherAgenciesServiced) {
		this.otherAgenciesServiced = otherAgenciesServiced;
	}

	public String getDatacenterTier() {
		return datacenterTier;
	}

	public void setDatacenterTier(String datacenterTier) {
		this.datacenterTier = datacenterTier;
	}

}
