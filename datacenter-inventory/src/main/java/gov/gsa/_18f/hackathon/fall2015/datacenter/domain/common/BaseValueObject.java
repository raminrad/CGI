package gov.gsa._18f.hackathon.fall2015.datacenter.domain.common;

import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @author dfladung
 * 
 */
public abstract class BaseValueObject implements ValueObject<BaseValueObject> {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean sameValueAs(BaseValueObject other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}

}
