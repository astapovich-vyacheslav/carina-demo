package com.qaprosoft.carina.demo.api.dummyjson;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.*;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/users/add", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/dummy_json/users/_post/rq.json")
@ResponseTemplatePath(path = "api/dummy_json/users/_post/rs.json")
@Header(key = "Content-Type", value = "application/json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostUserMethod extends AbstractApiMethodV2 {

    public PostUserMethod() {
        super("api/dummy_json/users/_post/rq.json", "api/dummy_json/users/_post/rs.json", "api/dummy_json/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url_dummyjson"));
    }
}
