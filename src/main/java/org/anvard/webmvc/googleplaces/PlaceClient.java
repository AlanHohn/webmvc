package org.anvard.webmvc.googleplaces;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class PlaceClient {

	private static final String URL = "https://maps.googleapis.com/maps/api/place/search/json?location={location}&radius=1000&types=food&sensor=false&key={key}";
	private static final String LOCATION = "39.016249,-77.122993";

	public static void main(String[] args) {
		trustAllSSL();
		String key = args[0];
		RestTemplate tmpl = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new MappingJacksonHttpMessageConverter());
		tmpl.setMessageConverters(converters);
		PlaceResponse response = tmpl.getForObject(URL, PlaceResponse.class,
				LOCATION, key);
		System.out.println(response);
	}

	public static void trustAllSSL() {
		try {
			final SSLContext ctx = SSLContext.getInstance("TLS");
			final X509TrustManager tm = new X509TrustManager() {
				public void checkClientTrusted(final X509Certificate[] xcs,
						final String string) throws CertificateException {
				}

				public void checkServerTrusted(final X509Certificate[] xcs,
						final String string) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLContext.setDefault(ctx);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}
}
