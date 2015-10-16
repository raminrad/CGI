package gov.gsa._18f.hackathon.fall2015.datacenter.domain.datacenter;

/**
 * @author dfladung
 *
 */
public enum RecordValidity {

	ValidFacility("Valid Facility"), InvalidFacility("Invalid Facility"), AddedFacility("Added Facility");

	String label;

	private RecordValidity(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public static RecordValidity fromString(String label) {
		if (label != null) {
			for (RecordValidity b : RecordValidity.values()) {
				if (label.equalsIgnoreCase(b.label)) {
					return b;
				}
			}
		}
		return null;
	}

}
