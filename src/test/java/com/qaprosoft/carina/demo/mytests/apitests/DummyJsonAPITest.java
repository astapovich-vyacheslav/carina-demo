package com.qaprosoft.carina.demo.mytests.apitests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.api.dummyjson.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class DummyJsonAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testGetProductByDummyID () {
        LOGGER.info("GET: PRODUCT");
        GetProductsMethod getProductsMethod = new GetProductsMethod(1);
        getProductsMethod.callAPIExpectSuccess();
        getProductsMethod.validateResponse();
    }


    @Test
    public void testAddDummyProduct () {
        LOGGER.info("POST: ADD PRODUCT");
        PostProductsMethod postProductsMethod = new PostProductsMethod();
        postProductsMethod.callAPIExpectSuccess();
        postProductsMethod.validateResponse();
    }

    @Test
    public void testDeleteDummyProduct () {
        LOGGER.info("DELETE: PRODUCT");
        DeleteProductsMethod deleteProductMethod = new DeleteProductsMethod("2");
        deleteProductMethod.callAPIExpectSuccess();
        deleteProductMethod.validateResponse(JSONCompareMode.LENIENT);
    }
}
