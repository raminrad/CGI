package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

import javax.persistence.Embeddable;

/**
 * @author dfladung
 *
 */
public enum NonCoreSubcategory {

	SpecialPurpose("Special Purpose Processing Node"), InstallationProcessing("Installation Processing Node");

	String label;

	private NonCoreSubcategory(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static NonCoreSubcategory fromString(String label) {
		if (label != null) {
			for (NonCoreSubcategory b : NonCoreSubcategory.values()) {
				if (label.equalsIgnoreCase(b.label)) {
					return b;
				}
			}
		}
		return null;
	}
}
