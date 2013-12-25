package com.redfin.sitemapgenerator;

import java.net.URL;
import java.util.HashMap;

class UrlUtils {

	static void checkUrl(String url, String baseUrl) {
		// The url can be a 
		try {
			URL base = new URL(baseUrl);
			URL newUrl = new URL(url);
			String baseHost = stripWWW(base.getHost());
			
			String urlHost = stripWWW(newUrl.getHost());
			if(null != urlHost && null != baseHost && urlHost.endsWith(baseHost)){
				//System.out.println("UrlUtils.checkUrl() "+urlHost+","+baseHost);
			}else{
				throw new RuntimeException("Url '" + url + "' doesn't belong to base URL '" + baseUrl+"'.");
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Could not test Url '" + url + "' belonging  to base URL '" + baseUrl+"'.",e);
			
		}		
		// Is there a better test to use here?
		/*if (!url.startsWith(baseUrl)) {
			throw new RuntimeException("Url " + url + " doesn't start with base URL " + baseUrl);
		}*/
	}
	
	private final static String stripWWW(String hostName){
		if(hostName != null && hostName.toLowerCase().startsWith("www.")){
			return hostName.substring(4);
		}
		return hostName;
	}

	static <K,V> HashMap<K,V> newHashMap() {
		return new HashMap<K,V>();
	}
	
	public static void main(String[] args) {
		checkUrl("http://commuinty.aspect.com", "http://www.aspect.com");
		checkUrl("http://www.commuinty.aspect.com/", "http://www.aspect.com/");
		checkUrl("http://www.commuinty.aspect1.com/", "http://www.aspect.com/");

	}
	
}
