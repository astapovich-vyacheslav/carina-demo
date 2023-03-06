package com.qaprosoft.carina.demo.api.dummyjson;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/products/${id}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/dummy_json/products/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetProductsMethod extends AbstractApiMethodV2 {
    
    public GetProductsMethod(int id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_dummyjson"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
