package com.qaprosoft.carina.demo.api.catfacts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "https://catfact.ninja/fact", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/catfacts/_get/fact/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetFactMethod extends AbstractApiMethodV2 {

    public GetFactMethod() {
    }
}
