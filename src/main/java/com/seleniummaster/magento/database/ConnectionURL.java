package com.seleniummaster.magento.database;

import com.seleniummaster.magento.utility.TestBasePage;

public class ConnectionURL extends TestBasePage {
    private static String mysqlString;
    private static String mssqlString;
    static {
        mysqlString=String.format("jdbc:mysql://%s:%s/%s?useSSL=false",prop.getProperty("dbURL"),prop.getProperty("dbPort"),prop.getProperty("defaultSchema"));
        String conURL="jdbc:mysql://198.12.211.114:3306/i5751295_mg1?useSSL=false";
        mssqlString=String.format("jdbc:jtds:sqlserver://%s:%s;DatabaseName=%s",prop.getProperty("dbURL"),prop.getProperty("dbPort"),prop.getProperty("defaultSchema"));
    }

    public static String getMysqlString() {
        return mysqlString;
    }

    public static void setMysqlString(String mysqlString) {
        ConnectionURL.mysqlString = mysqlString;
    }

    public static String getMssqlString() {
        return mssqlString;
    }

    public static void setMssqlString(String mssqlString) {
        ConnectionURL.mssqlString = mssqlString;
    }
}
