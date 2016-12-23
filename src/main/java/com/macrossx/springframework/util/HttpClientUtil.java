package com.macrossx.springframework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpClientUtil {
	public static <T> T send(final HttpUriRequest request, String defaultCharset, Class<T> classJson) {
		return send(request).flatMap(e -> {
			try {
				return Optional.of(new Gson().fromJson(EntityUtils.toString(e, defaultCharset), classJson));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				log.info("{}", e);
				return Optional.empty();
			}
		}).orElse(null);
	}

	private static Optional<HttpEntity> send(final HttpUriRequest request) {
		try {
			CloseableHttpResponse response = HttpClients.createDefault().execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK != statusCode) {
				log.info("{}-{}", statusCode, "request error!");
				return Optional.empty();
			}
			HttpEntity entity = response.getEntity();
			// result = EntityUtils.toString(entity, "utf-8");
			return Optional.of(entity);
		} catch (IOException e) {
			log.info("{}", e);
			return Optional.empty();
		}
	}
}
