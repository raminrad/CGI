package gov.gsa._18f.hackathon.fall2015.datacenter.interfaces.rest;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Provider
public class RestMapperProvider implements ContextResolver<ObjectMapper> {

	final ObjectMapper defaultObjectMapper;

	public RestMapperProvider() {
		defaultObjectMapper = createDefaultMapper();
	}

	@Override
	public ObjectMapper getContext(final Class<?> type) {
		return defaultObjectMapper;
	}

	public static ObjectMapper createDefaultMapper() {
		final ObjectMapper result = new ObjectMapper();

		// lazy loading
		Hibernate4Module module = new Hibernate4Module();
		module.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, true);
		result.registerModule(module);
		result.enable(SerializationFeature.INDENT_OUTPUT);
		result.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		AnnotationIntrospector jackson = new JacksonAnnotationIntrospector();
		result.setAnnotationIntrospector(jackson);
		return result;
	}
}