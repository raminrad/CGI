package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author dfladung
 *
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "core_classifications")
public class CoreClassification extends BaseEntity {

	private static final long serialVersionUID = 1L;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
