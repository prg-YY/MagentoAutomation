package com.seleniummaster.magento.database;

import com.seleniummaster.magento.utility.TestBasePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager extends TestBasePage {
    //create a method to connect database
    public static Connection connectToDataBaseServer(ConnectionType connectionType) {
        Connection connection = null;
        switch (connectionType){
            case MYSQLServer:
                try {
                 Class.forName(prop.getProperty("MYSQLDriver")).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    connection=DriverManager.getConnection(ConnectionURL.getMysqlString(),prop.getProperty("dbUserName"),
                            prop.getProperty("dbPassword"));
                } catch (SQLException throttles) {
                    throttles.printStackTrace();
                }
                break;
            case MSSQLSERVER:
                try {
                    Class.forName(prop.getProperty("JTDS_Driver")).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    connection=DriverManager.getConnection(ConnectionURL.getMssqlString(),prop.getProperty("dbUserName")
                            ,prop.getProperty("dbPassword"));
                } catch (SQLException throttles) {
                    throttles.printStackTrace();
                }
                break;
            default:
                System.out.println("You need to specify data base connection type(MSSQL or MySQL)");
        }
        //verify if the connection is established or not
        try {
            if(!connection.isClosed()){
                System.out.println("Data base connection is established");
            }
        } catch (SQLException throttles) {
            throttles.printStackTrace();
        }
        return connection;
    }
    public static void closeDataBaseConnection(Connection connection){
        try {
            if(connection.isClosed()){
                System.out.println("Data base connection has been closed");
            }else{
                connection.close();
                System.out.println("connection is closed!");
            }
        } catch (SQLException throttles) {
            throttles.printStackTrace();
        }
    }
}
