package org.craftercms.studio.test.utils;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

public class JsonTester {

	private static final String CSRF_COOKIE_NAME = "XSRF-TOKEN";
	private static final String CSRF_COOKIE_PATH = "/studio";
	private static final String CSRF_HEADER_NAME = "X-XSRF-TOKEN";

	private final int port;
	private String host;
	private String schema;
	private CloseableHttpClient httpClient;
    private BasicCookieStore cookieJar;

	public JsonTester(String schema,String host, int port){
		this.host =host;
		this.port=port;
		this.schema=schema;
		this.cookieJar = new BasicCookieStore();

		String uuid = UUID.randomUUID().toString();
		BasicClientCookie cookie = new BasicClientCookie(CSRF_COOKIE_NAME, uuid);
		cookie.setDomain(host);
		cookie.setPath(CSRF_COOKIE_PATH);
		this.cookieJar.addCookie(cookie);

		List<BasicHeader> headers = Arrays.asList(new BasicHeader(CSRF_HEADER_NAME, uuid));

		this.httpClient = HttpClientBuilder.create()
											.setDefaultCookieStore(cookieJar).setDefaultHeaders(headers).build();
	}

	public JsonRequest get(String url){
	     return new JsonRequest(schema,host,port,url,"GET",httpClient,cookieJar);
	}
	public JsonRequest post(String url){
		return new JsonRequest(schema,host,port,url,"POST",httpClient,cookieJar);
	}
}
