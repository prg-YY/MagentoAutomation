package com.seleniummaster.magento.database;

import com.seleniummaster.magento.testdata.TestDataHolder;

public class QueryScript {
    //1-customer module(AbDuSaMed)
    public static String getNewlyAddedCustomer()
    {
        return "select entity_id,website_id,email from mg_customer_entity where email ='%s';";
    }
    //2-customer group(AbDuKaHar)
    public static String getNewlyAddedCustomerGroup()
    {
        return "select * from mg_customer_group where customer_group_id=56;";
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

    //store module
    public static String getNewlyAddedStoreView()
    {
        return "select * from mg_core_store_group;";//get store
    }
    public static String getNewlyAddedStore2()
    {
        return "select count(*) from mg_store order by store_id";
    }
    //user module
    public static String getNewlyAddedUser(){
        return "select count(*) from mg_customer_entity where email = '%s'";
    }

    public static String getNewlyAddedStore() {
        //return "select * from mg_core_store where code='%s';";
        //return "select * from mg_core_store_group name='%s';";
        return "select * from mg_core_store_group where name='%s';";
       //return "\"select * from i5751295_mg1.mg_core_store_group where name='ABC branch';";
    }
}
