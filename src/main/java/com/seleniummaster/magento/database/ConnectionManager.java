package com.seleniummaster.magento.database;

import com.seleniummaster.magento.utility.TestBasePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager extends TestBasePage {
    //create a method to connect database
    public static Connection connectToDataBaseServer(String  dbUserName,String dbPassword,ConnectionType connectionType) {
        Connection connection=null;
        String JTDS_Driver=prop.getProperty("JTDS_Driver");//sql
        String MYSQL_Driver=prop.getProperty("MYSQLDriver");//my sql
        switch (connectionType){
            case MSSQLSERVER:
                try {
                    Class.forName(JTDS_Driver);//load the drive in to memory
                } catch (ClassNotFoundException e) {
                    new RuntimeException("Please check driver information");
                }
                try {
                    connection= DriverManager.getConnection(ConnectionURL.getMssqlString(),dbUserName,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case MYSQLServer:
                // Class.forName(MYSQL_Driver).newInstance();
                try {
                    Class.forName(MYSQL_Driver).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    connection=DriverManager.getConnection(ConnectionURL.getMysqlString(),dbUserName,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(ConnectionURL.getMysqlString());
                break;
            default:
                System.out.println("You need to specify data base connection type(MSSQL or MySQL)");
        }
        //verify if the connection is established or not
        try {
            if(!connection.isClosed()){
                System.out.println("Data base connection is established");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
