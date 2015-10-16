package gov.gsa._18f.hackathon.fall2015.datacenter.domain.common;

import java.io.Serializable;

/**
 * @author dfladung
 *
 * @param <T>
 */
public interface ValueObject<T> extends Serializable {

	boolean sameValueAs(T other);

}
