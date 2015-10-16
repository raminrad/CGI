package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseValueObject;

/**
 * @author dfladung
 *
 */
@Embeddable
@Access(AccessType.FIELD)
public class Address extends BaseValueObject {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	String city;

	@Column(name = "state_abbreviation", nullable = false)
	String state;

	@Column
	String province;

	@Column(nullable = false, length = 5)
	String zip;

	@Column(nullable = false)
	String country;

	@Override
	public String toString() {
		return String.format("Address [city=%s, state=%s, province=%s, zip=%s, country=%s]", city, state, province,
				zip, country);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
