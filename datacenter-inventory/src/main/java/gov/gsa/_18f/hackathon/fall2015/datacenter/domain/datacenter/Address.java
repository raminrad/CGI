package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import javax.persistence.Access;
import javax.persistence.AccessType;
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

}
