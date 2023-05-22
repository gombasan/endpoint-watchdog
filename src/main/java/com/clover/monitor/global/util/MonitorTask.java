package com.clover.monitor.global.util;

import java.util.TimerTask;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.clover.monitor.domain.monitor.entity.Monitor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class MonitorTask extends TimerTask {

	private final RestTemplate restTemplate = new RestTemplate();

	private Monitor monitor;

	@Override
	public void run() {
		String endPoint = monitor.getEndPoint();
		long startTime = System.currentTimeMillis();
		ResponseEntity<String> forEntity = restTemplate.getForEntity(endPoint, String.class);
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("EndPoint : " + endPoint + " Get Status : " + forEntity.getStatusCode());
		System.out.println("요청 시간 : " + duration);
	}

}
