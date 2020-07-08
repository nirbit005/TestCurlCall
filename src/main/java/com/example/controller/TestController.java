package com.example.controller;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
	public String testController() throws Exception {
		System.out.println("Hello!!!");
		Thread.sleep(1000);
		
		String searchDirectory = "/Users/nirmal/testpnradtf/";
		try (Stream<Path> files = Files.walk(Paths.get(searchDirectory))) {
	         // files
	           //     .filter(f -> f.getFileName().toString().equals(fileName))
	            //    .collect(Collectors.toList());
			
			List<Path> val = files.map(Path::getFileName).collect(Collectors.toList());
			val.stream()	//.map(v -> v.getFileName())
				.forEach(System.out::println);

			String ydate =	LocalDate.now().minusDays(1).toString();
			String dtSea = ydate.substring(8) + ydate.substring(5, 7);
			System.out.println(dtSea);
			String dttSea = "1411";
			
			val.stream().filter(p -> p.toString().toLowerCase().contains("_adtfinfo") && p.toString().contains(dttSea))
			.forEach(System.out::println);
			
			val.stream().filter(p -> p.toString().toLowerCase().contains("_pnrinfo") && p.toString().contains(dttSea))
			.forEach(System.out::println);
			
	//		String fileName = "1411_*";
	//		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:*" + fileName);
	//		files.filter(matcher::matches).forEach(System.out::println);
	

	    }
		
		return "success";
		
	//curl -X GET  http://localhost:8080/test
	//curl -X POST http://localhost:8080/actuator/shutdown	
	//curl -X GET  http://localhost:8080/actuator/health
	}
}
