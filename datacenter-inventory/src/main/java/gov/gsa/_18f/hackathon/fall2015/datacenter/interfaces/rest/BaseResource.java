package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest;

import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationErrorCode;
import gov.gsa._18f.hackathon.fall2015.datacenter.application.ApplicationException;

import java.util.Date;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author dfladung
 * 
 */
public abstract class BaseResource {

	public Date parseDate(String date) {
		try {
			DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
			return fmt.parseDateTime(date).toDate();
		} catch (Exception e) {
			throw new ApplicationException(ApplicationErrorCode.E_InvalidArgument, e.getMessage());
		}

	}
}
