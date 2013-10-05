package org.anvard.webmvc.server;

import java.net.URL;
import java.security.ProtectionDomain;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedServer {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server();

		ServerConnector connector = new ServerConnector(server);
		connector.setPort(9999);

		HttpConfiguration https = new HttpConfiguration();
        https.addCustomizer(new SecureRequestCustomizer());
		SslContextFactory sslContextFactory = new SslContextFactory();
		sslContextFactory.setKeyStorePath(EmbeddedServer.class.getResource(
				"/keystore.jks").toExternalForm());
		sslContextFactory.setKeyStorePassword("123456");
		sslContextFactory.setKeyManagerPassword("123456");
		ServerConnector sslConnector = new ServerConnector(server,
				new SslConnectionFactory(sslContextFactory, "http/1.1"),
				new HttpConnectionFactory(https));
		sslConnector.setPort(9998);

		server.setConnectors(new Connector[] { connector, sslConnector });

		WebAppContext context = new WebAppContext();
		context.setServer(server);
		context.setContextPath("/");

		ProtectionDomain protectionDomain = EmbeddedServer.class
				.getProtectionDomain();
		URL location = protectionDomain.getCodeSource().getLocation();
		context.setWar(location.toExternalForm());

		server.setHandler(context);
		while (true) {
			try {
				server.start();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			System.in.read();
			server.stop();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(100);
		}
	}

}
