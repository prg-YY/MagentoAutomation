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
        return "select * from mg_customer_group where customer_group_id=56;";
    }
    //3-catalog module(Yusuf)
    public static String getNewlyAddedProduct()
    {
        return "select *from mg_catalog_category_product where product_id=299";
    }
    //4-catalog module(sofia)
    public static String getNewlyAddedRootCategory()
    {
        return "select category_id from mg_catalog_category_product where category_id=7";
    }
//5-select entity_id,website_id,email,group_id from mg_customer_entity where email='zuhrabatush@gmail.com';
    public static String getNewlyRegisteredUser()
    {
       return "select entity_id,website_id,email,group_id from mg_customer_entity where email='%s';" ;

    }
    //sales module(Yusuf)
    public static String getNewlyAddedTaxRule(){
        return "select count(*) from mg_tax_calculation_rule where code = '%s'";
    }

    public static String getNewlyAddedCreditMemo(){
        return "select * from mg_sales_creditmemo_item where entity_id=6";
    }

    //store module
    public static String getNewlyAddedStore()
    {
        return "select count(*) from mg_store where code = 'default'";
    }
    public static String getNewlyAddedStore2()
    {
        return "select count(*) from mg_store order by store_id";
    }
    //user module
    public static String getNewlyAddedUser(){
        return "select count(*) from mg_customer_entity where email = '%s'";
    }
}
