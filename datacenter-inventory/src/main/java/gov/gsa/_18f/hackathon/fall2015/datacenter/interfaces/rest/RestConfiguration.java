package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest;

import java.util.logging.Logger;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @author dfladung
 *
 */
public class RestConfiguration extends ResourceConfig {

	public RestConfiguration() {
		// send bean validation errors
		this.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		register(RequestContextFilter.class);

		// application error mapping
		register(ApplicationExceptionMapper.class);

		// additional logging
		registerInstances(new LoggingFilter(Logger.getLogger(RestConfiguration.class.getName()), true));

		// json mapping via jackson
		register(RestMapperProvider.class);
		register(JacksonFeature.class);

		// Actual APIs
		packages("gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest");

	}
}
