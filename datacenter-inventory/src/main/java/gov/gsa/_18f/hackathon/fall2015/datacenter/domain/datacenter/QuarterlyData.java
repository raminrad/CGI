package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

/**
 * @author dfladung
 *
 */
@Entity
@Table(name = "quarterly_data")
public class QuarterlyData extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "fiscal_year", nullable = false)
	Integer fiscalYear;

	@Column(nullable = false)
	String quarter;

	@Column(nullable = false)
	BigDecimal fte;

	@Column(name = "fte_cost")
	BigDecimal fteCost;

	@Column(name = "electricity_indcluded", nullable = false)
	@org.hibernate.annotations.Type(type = "yes_no")
	Boolean electricityIndcluded;

	@Column(name = "electricity_metered", nullable = false)
	@org.hibernate.annotations.Type(type = "yes_no")
	Boolean electricityMetered;

	@Column(name = "total_power_capacity")
	BigDecimal totalPowerCapacity;

	@Column(name = "total_it_power_capacity")
	BigDecimal totalItPowerCapacity;

	@Column(name = "averate_electricity_usage")
	BigDecimal averageElectricityUsage;

	@Column(name = "averate_it_electricity_usage")
	BigDecimal averageItElectricityUsage;

	@Column(name = "cost_per_kwh")
	BigDecimal costPerKilowattHour;

	@Column(name = "rack_count", nullable = false)
	Integer rackCount;

	@Column(name = "total_ibm_mainframes", nullable = false)
	Integer totalIbmMainframes;

	@Column(name = "total_other_mainframes", nullable = false)
	Integer totalOtherMainframes;

	@Column(name = "total_windows_servers", nullable = false)
	Integer totalWindowsServers;

	@Column(name = "total_unix_servers", nullable = false)
	Integer totalUnixServers;

	@Column(name = "total_linux_servers", nullable = false)
	Integer totalLinuxServers;

	@Column(name = "total_hpc_cluster_nodes", nullable = false)
	Integer totalHpcClusterNodes;

	@Column(name = "other_servers", nullable = false)
	Integer otherServers;

	@Column(name = "total_virtual_hosts", nullable = false)
	Integer totalVirtualHosts;

	@Column(name = "total_virtual_os", nullable = false)
	Integer totalVirtualOs;

	@Column(name = "total_storage", nullable = false)
	BigDecimal totalStorage;

	@Column(name = "used_storage", nullable = false)
	BigDecimal usedStorage;

	@Column(name = "closing_stage", nullable = false)
	String closingStage;

	@Column(name = "closing_fiscal_year")
	Integer closingFiscalYear;

	@Column(name = "closing_quarter")
	String closingQuarter;

	@Column(name = "real_property_disposition")
	String realPropertyDisposition;

	@Column(name = "total_floor_area_reclaimed")
	Integer totalFloorAreaReclaimed;

	@Column(name = "total_decomissioned_servers")
	Integer totalDecomissionedServers;

	@Column(name = "total_servers_moved")
	Integer totalServersMoved;

	@Column(name = "overall_fte_reduction")
	Integer overallFteReduction;

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

	public BigDecimal getFte() {
		return fte;
	}

	public void setFte(BigDecimal fte) {
		this.fte = fte;
	}

	public BigDecimal getFteCost() {
		return fteCost;
	}

	public void setFteCost(BigDecimal fteCost) {
		this.fteCost = fteCost;
	}

	public Boolean getElectricityIndcluded() {
		return electricityIndcluded;
	}

	public void setElectricityIndcluded(Boolean electricityIndcluded) {
		this.electricityIndcluded = electricityIndcluded;
	}

	public Boolean getElectricityMetered() {
		return electricityMetered;
	}

	public void setElectricityMetered(Boolean electricityMetered) {
		this.electricityMetered = electricityMetered;
	}

	public BigDecimal getTotalPowerCapacity() {
		return totalPowerCapacity;
	}

	public void setTotalPowerCapacity(BigDecimal totalPowerCapacity) {
		this.totalPowerCapacity = totalPowerCapacity;
	}

	public BigDecimal getTotalItPowerCapacity() {
		return totalItPowerCapacity;
	}

	public void setTotalItPowerCapacity(BigDecimal totalItPowerCapacity) {
		this.totalItPowerCapacity = totalItPowerCapacity;
	}

	public BigDecimal getAverageElectricityUsage() {
		return averageElectricityUsage;
	}

	public void setAverageElectricityUsage(BigDecimal averageElectricityUsage) {
		this.averageElectricityUsage = averageElectricityUsage;
	}

	public BigDecimal getAverageItElectricityUsage() {
		return averageItElectricityUsage;
	}

	public void setAverageItElectricityUsage(BigDecimal averageItElectricityUsage) {
		this.averageItElectricityUsage = averageItElectricityUsage;
	}

	public BigDecimal getCostPerKilowattHour() {
		return costPerKilowattHour;
	}

	public void setCostPerKilowattHour(BigDecimal costPerKilowattHour) {
		this.costPerKilowattHour = costPerKilowattHour;
	}

	public Integer getRackCount() {
		return rackCount;
	}

	public void setRackCount(Integer rackCount) {
		this.rackCount = rackCount;
	}

	public Integer getTotalIbmMainframes() {
		return totalIbmMainframes;
	}

	public void setTotalIbmMainframes(Integer totalIbmMainframes) {
		this.totalIbmMainframes = totalIbmMainframes;
	}

	public Integer getTotalOtherMainframes() {
		return totalOtherMainframes;
	}

	public void setTotalOtherMainframes(Integer totalOtherMainframes) {
		this.totalOtherMainframes = totalOtherMainframes;
	}

	public Integer getTotalWindowsServers() {
		return totalWindowsServers;
	}

	public void setTotalWindowsServers(Integer totalWindowsServers) {
		this.totalWindowsServers = totalWindowsServers;
	}

	public Integer getTotalUnixServers() {
		return totalUnixServers;
	}

	public void setTotalUnixServers(Integer totalUnixServers) {
		this.totalUnixServers = totalUnixServers;
	}

	public Integer getTotalLinuxServers() {
		return totalLinuxServers;
	}

	public void setTotalLinuxServers(Integer totalLinuxServers) {
		this.totalLinuxServers = totalLinuxServers;
	}

	public Integer getTotalHpcClusterNodes() {
		return totalHpcClusterNodes;
	}

	public void setTotalHpcClusterNodes(Integer totalHpcClusterNodes) {
		this.totalHpcClusterNodes = totalHpcClusterNodes;
	}

	public Integer getOtherServers() {
		return otherServers;
	}

	public void setOtherServers(Integer otherServers) {
		this.otherServers = otherServers;
	}

	public Integer getTotalVirtualHosts() {
		return totalVirtualHosts;
	}

	public void setTotalVirtualHosts(Integer totalVirtualHosts) {
		this.totalVirtualHosts = totalVirtualHosts;
	}

	public Integer getTotalVirtualOs() {
		return totalVirtualOs;
	}

	public void setTotalVirtualOs(Integer totalVirtualOs) {
		this.totalVirtualOs = totalVirtualOs;
	}

	public BigDecimal getTotalStorage() {
		return totalStorage;
	}

	public void setTotalStorage(BigDecimal totalStorage) {
		this.totalStorage = totalStorage;
	}

	public BigDecimal getUsedStorage() {
		return usedStorage;
	}

	public void setUsedStorage(BigDecimal usedStorage) {
		this.usedStorage = usedStorage;
	}

	public String getClosingStage() {
		return closingStage;
	}

	public void setClosingStage(String closingStage) {
		this.closingStage = closingStage;
	}

	public Integer getClosingFiscalYear() {
		return closingFiscalYear;
	}

	public void setClosingFiscalYear(Integer closingFiscalYear) {
		this.closingFiscalYear = closingFiscalYear;
	}

	public String getClosingQuarter() {
		return closingQuarter;
	}

	public void setClosingQuarter(String closingQuarter) {
		this.closingQuarter = closingQuarter;
	}

	public String getRealPropertyDisposition() {
		return realPropertyDisposition;
	}

	public void setRealPropertyDisposition(String realPropertyDisposition) {
		this.realPropertyDisposition = realPropertyDisposition;
	}

	public Integer getTotalFloorAreaReclaimed() {
		return totalFloorAreaReclaimed;
	}

	public void setTotalFloorAreaReclaimed(Integer totalFloorAreaReclaimed) {
		this.totalFloorAreaReclaimed = totalFloorAreaReclaimed;
	}

	public Integer getTotalDecomissionedServers() {
		return totalDecomissionedServers;
	}

	public void setTotalDecomissionedServers(Integer totalDecomissionedServers) {
		this.totalDecomissionedServers = totalDecomissionedServers;
	}

	public Integer getTotalServersMoved() {
		return totalServersMoved;
	}

	public void setTotalServersMoved(Integer totalServersMoved) {
		this.totalServersMoved = totalServersMoved;
	}

	public Integer getOverallFteReduction() {
		return overallFteReduction;
	}

	public void setOverallFteReduction(Integer overallFteReduction) {
		this.overallFteReduction = overallFteReduction;
	}

}
