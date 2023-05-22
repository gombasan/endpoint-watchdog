package com.clover.monitor.domain.monitor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clover.monitor.domain.monitor.service.MonitoringService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/monitor")
@RequiredArgsConstructor
public class MonitorController {

	private final MonitoringService monitoringService;


	@GetMapping("/start")
	public void monitoringStart() {
		monitoringService.startMonitoring();
	}

	@GetMapping("/stop")
	public void monitoringStop() {
		monitoringService.stopMonitoring();
	}
}
