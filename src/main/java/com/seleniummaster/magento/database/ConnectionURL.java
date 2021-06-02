package com.seleniummaster.magento.database;

import com.seleniummaster.magento.utility.TestBasePage;

public class ConnectionURL extends TestBasePage {
    private static String mysqlString;
    private static String mssqlString;
    static {
        mysqlString=String.format("jdbc:mysql://%s:%s/%s?useSSL=false",prop.getProperty("dbURL"),prop.getProperty("dbPort"),prop.getProperty("defaultSchema"));
        mssqlString=String.format("jdbc:jtds:sqlserver://%s:%s;DatabaseName=%s",prop.getProperty("dbURL"),prop.getProperty("dbPort"),prop.getProperty("defaultSchema"));
    }
    public static String getMysqlString() {
        return mysqlString;
    }
    public static String getMssqlString() {
        return mssqlString;
    }

}
