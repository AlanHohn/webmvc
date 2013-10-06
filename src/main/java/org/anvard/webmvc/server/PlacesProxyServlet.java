package org.anvard.webmvc.server;

import java.net.URI;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.proxy.ProxyServlet;
import org.eclipse.jetty.util.ssl.SslContextFactory;


public class PlacesProxyServlet extends ProxyServlet {

	private static final long serialVersionUID = -7441088044680657919L;
	
	private String placesUrl;
	private String apiKey;

	
	@Override
	public void init() throws ServletException {
		super.init();
		ServletConfig config = getServletConfig();
        placesUrl = config.getInitParameter("PlacesUrl");
        apiKey = config.getInitParameter("GoogleApiKey");
        // Allow override with system property
        try {
        	placesUrl = System.getProperty("PlacesUrl", placesUrl);
        	apiKey = System.getProperty("GoogleApiKey", apiKey);
        } catch (SecurityException e) {
        }
        if (null == placesUrl) {
        	placesUrl = "https://maps.googleapis.com/maps/api/place/search/json";
        }
	}

	@Override
	protected HttpClient newHttpClient() {
		SslContextFactory sslContextFactory = new SslContextFactory();
		HttpClient httpClient = new HttpClient(sslContextFactory);
		return httpClient;
	}

	@Override
	protected void customizeProxyRequest(Request proxyRequest,
			HttpServletRequest request) {
		proxyRequest.getHeaders().remove("Host");
	}

	@Override
	protected URI rewriteURI(HttpServletRequest request) {
		String query = request.getQueryString();
		return URI.create(placesUrl + "?" + query + "&key=" + apiKey);
	}

}
