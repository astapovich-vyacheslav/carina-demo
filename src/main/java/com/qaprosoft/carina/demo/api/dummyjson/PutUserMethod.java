package com.qaprosoft.carina.demo.api.dummyjson;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/users/${id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/dummy_json/users/_put/rq.json")
@Header(key = "Content-Type", value = "application/json")
@ResponseTemplatePath(path = "api/dummy_json/users/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutUserMethod extends AbstractApiMethodV2 {

    public PutUserMethod (int id) {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_dummyjson"));
        replaceUrlPlaceholder("id", String.valueOf(id));
    }
}
