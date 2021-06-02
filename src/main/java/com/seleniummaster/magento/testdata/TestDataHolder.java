package com.seleniummaster.magento.testdata;

public class TestDataHolder {
    private static String customerGroupName;
    private static String productCategoryProductName;

    public TestDataHolder() {
    }


    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public void setCustomerGroupName(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }

    public static String getProductCategoryProductName() {
        return productCategoryProductName;
    }

    public static void setProductCategoryProductName(String productCategoryProductName) {
        TestDataHolder.productCategoryProductName = productCategoryProductName;
    }
}
