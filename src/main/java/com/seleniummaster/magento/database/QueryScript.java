package com.seleniummaster.magento.database;


public class QueryScript {
    //1-customer module(AbDuSaMed)
    public static String getNewlyAddedCustomer()
    {
        return "select entity_id,website_id,email from mg_customer_entity where email ='%s';";
    }
    //2-customer group(AbDuKaHar)
    public static String getNewlyAddedCustomerGroup()
    {
        return "select * from mg_customer_group where customer_group_code='%s';";
    }
    //3-catalog module(Yusuf)
    public static String getNewlyAddedProduct()
    {
        return "select *from mg_catalog_product_entity_varchar where value='%s';";
    }
    //4-catalog module(sofia)
    public static String getNewlyAddedRootCategory()
    {
        return "select * from mg_catalog_category_entity_varchar where value='%s'";
    }
//5-select entity_id,website_id,email,group_id from mg_customer_entity where email='zuhrabatush@gmail.com';
    public static String getNewlyRegisteredUser()
    {
       return "select entity_id,website_id,email,group_id from mg_customer_entity where email='%s';" ;

    }
    //Kamer
    public static String getNewlyOrder(){
        return "select entity_id,protect_code,increment_id from mg_sales_flat_order where increment_id='%s';";
    }
    //melike
    public static String getNewAddedProduct()
    {
        return "select *from mg_catalog_product_entity_varchar where value='%s';";
    }
    //sales module(Yusuf)
    public static String getNewlyAddedTaxRule(){
        return "select * from mg_tax_calculation_rule where code = '%s'";
    }

    public static String getNewlyAddedCreditMemo(){
        return "select * from mg_sales_creditmemo_item where entity_id=6";
    }

    public static String getNewlyAddedRefund(){
        return "select * from mg_sales_refunded_aggregated_order where id='13';";
    }

    //store module
    public static String getNewlyAddedStoreView()
    {
        return "select store_id,code,name from mg_core_store where code='%s';";//get store view
    }
    public static String getCreditMemo()
    {
        return "select entity_id,product_id,qty,price,order_item_id,name,sku from mg_sales_flat_creditmemo_item where sku='UYD2021';";
    }
    //user module
    public static String getNewlyAddedUser(){
        return "select count(*) from mg_customer_entity where email = '%s'";
    }

    public static String getNewlyAddedStore() {
        return "select * from mg_core_store_group where name='%s';";
    }
    public static String getNewlyAddedSubCategory() {
        return "select * from mg_catalog_category_entity_varchar where value='%s';";
    }

}
