package com.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientApplication.class, args);
	}

}

@RestController
@RefreshScope
class MyController{

	@Value("${values.downstreamurl: default}")
	private String downstreamurl;

	@Value("${values.list: dummyy}")
	private List<String> values;

	@GetMapping("/downstreamurl")
	public String getDownstreamurl(){
		return "Downstream url : " +downstreamurl + " and list " +values;
	}
}
