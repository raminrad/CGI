package gov.gsa._18f.hackathon.fall2015.datacenter.domain.common;

import java.io.Serializable;

/**
 * @author dfladung
 *
 * @param <T>
 */
public interface Entity<T> extends Serializable {

	boolean sameIdentityAs(T other);

	Long getId();

	void setId(Long id);
}
