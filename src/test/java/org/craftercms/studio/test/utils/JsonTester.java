package org.craftercms.studio.test.utils;

import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class JsonTester {

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
		this.httpClient = HttpClientBuilder.create().setDefaultCookieStore(cookieJar).build();
	}

	public JsonRequest get(String url){
	     return new JsonRequest(schema,host,port,url,"GET",httpClient,cookieJar);
	}
	public JsonRequest post(String url){
		return new JsonRequest(schema,host,port,url,"POST",httpClient,cookieJar);
	}
}
