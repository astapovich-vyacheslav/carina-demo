package com.qaprosoft.carina.demo.api.catfacts;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "https://catfact.ninja/breeds", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/catfacts/_get/breeds/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetBreedsMethod extends AbstractApiMethodV2 {

    public GetBreedsMethod() {
    }
}
