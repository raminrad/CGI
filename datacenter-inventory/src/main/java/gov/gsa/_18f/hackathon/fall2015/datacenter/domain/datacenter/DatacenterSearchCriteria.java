package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import java.io.Serializable;

/**
 * @author dfladung
 *
 */
public class DatacenterSearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	Long datacenterId;

	Long quarterId;

	Integer fiscalYear;

	String quarter;

	public Long getDatacenterId() {
		return datacenterId;
	}

	public void setDatacenterId(Long datacenterId) {
		this.datacenterId = datacenterId;
	}

	public Integer getFiscalYear() {
		return fiscalYear;
	}

	public void setFiscalYear(Integer fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public Long getQuarterId() {
		return quarterId;
	}

	public void setQuarterId(Long quarterId) {
		this.quarterId = quarterId;
	}

}
