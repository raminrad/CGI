package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

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

}
