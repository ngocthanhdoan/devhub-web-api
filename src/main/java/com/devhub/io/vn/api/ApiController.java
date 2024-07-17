package com.devhub.io.vn.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.MethodLookup.InvokedMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devhub.io.vn.plugins.DataSet;
import com.devhub.io.vn.plugins.returnObject;
import com.j4fun.plugins.InvokeMethod;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ApiController {

	private final DataSet dataSet;

	@Autowired
	public ApiController(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	@GetMapping("/api/**")
	public returnObject handleDynamicRequest(HttpServletRequest request,
			@RequestParam Map<String, String> queryParameters) {
		returnObject responseObject = new returnObject();

		try {
			ApiModun a = new ApiModun(dataSet);
			String requestUri = request.getRequestURI();
			String[] uriSegments = requestUri.split("/");
			String class_invoke = "";
			for (String segment : uriSegments) {
				if (!segment.isEmpty()) {
					class_invoke=a.getApiMethod(segment);
				}
			}
			responseObject.setReturnCode(200);
			responseObject.setReturnData(InvokeMethod.execute(class_invoke, queryParameters));
			responseObject.setMsgDescs("Success");
		} catch (Exception e) {
			responseObject.setReturnCode(500);
			responseObject.setMsgDescs("Internal Server Error: " + e.getMessage());
		}

		return responseObject;
	}
	// Define other API methods as needed
}
