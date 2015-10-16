package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import gov.gsa._18f.hackathon.fall2015.datacenter.domain.common.BaseEntity;

/**
 * @author dfladung
 *
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "components")
public class Component extends BaseEntity {

	private static final long serialVersionUID = 1L;

	String name;

	public Component() {

	}

	public Component(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Component [name=%s]", name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
