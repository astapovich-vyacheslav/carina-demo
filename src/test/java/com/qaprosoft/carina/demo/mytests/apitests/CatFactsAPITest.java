package com.qaprosoft.carina.demo.mytests.apitests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.catfacts.GetBreedsMethod;
import com.qaprosoft.carina.demo.api.catfacts.GetFactMethod;
import com.qaprosoft.carina.demo.api.dummyjson.*;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.isA;

public class CatFactsAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetRandomFact() {
        LOGGER.info("GET: RANDOM FACT");
        GetFactMethod getFactMethod = new GetFactMethod();
        Response response = getFactMethod.callAPIExpectSuccess();
        response.then().statusCode(200).contentType("application/json");
        response.then().body("$", hasKey("fact"));
        response.then().body("$", hasKey("length"));
        response.then().body("fact", isA(String.class));
        response.then().body("length", isA(Integer.class));
    }

    @Test
    public void testGetBreeds() {
        LOGGER.info("GET: BREEDS");
        GetBreedsMethod getBreedsMethod = new GetBreedsMethod();
        getBreedsMethod.callAPIExpectSuccess();
        getBreedsMethod.validateResponse();
    }
}