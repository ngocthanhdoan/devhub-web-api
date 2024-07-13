package com.devhub.io.vn.api;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.devhub.io.vn.plugins.returnObject;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ApiController { @GetMapping("/api/**")
    public returnObject handleDynamicRequest(HttpServletRequest request, @RequestParam Map<String, String> queryParameters) {
        returnObject responseObject = new returnObject();

        try {
            String requestUri = request.getRequestURI();
            String[] uriSegments = requestUri.split("/");
            StringBuilder responseData = new StringBuilder();
            for (String segment : uriSegments) {
                if (!segment.isEmpty()) {
                    responseData.append("Segment: ").append(segment).append("\n");
                }
            }
            responseData.append("Query parameters: ").append(queryParameters);
            responseObject.setReturnCode(200);
            responseObject.setReturnData(responseData.toString());
            responseObject.setMsgDescs("Success");
        } catch (Exception e) {
            responseObject.setReturnCode(500);
            responseObject.setMsgDescs("Internal Server Error: "+e.getMessage());
        }

        return responseObject;
    }
    // Define other API methods as needed
}
