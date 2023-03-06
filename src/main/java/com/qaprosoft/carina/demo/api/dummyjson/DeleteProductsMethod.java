package com.qaprosoft.carina.demo.api.dummyjson;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/products/${id}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/dummy_json/products/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteProductsMethod extends AbstractApiMethodV2 {

    public DeleteProductsMethod (String id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_dummyjson"));
        replaceUrlPlaceholder("id", id);
    }
}
