package com.seleniummaster.magento.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataAccess {
    public CachedRowSet readFromDataBase(Connection connection, String query) {
        CachedRowSet cachedRowSet = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet == null) {
                System.out.println("No records found.");
            } else {
                cachedRowSet.populate(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cachedRowSet;
    }

    public boolean getRowCount(CachedRowSet cachedRowSet) {
        int rowCount = 0;
        while (true) {
            try {
                if (!cachedRowSet.next()) {
                    break;
                }
                rowCount = cachedRowSet.getRow();
                System.out.println("row count is " + rowCount);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    //Abdusamad
    public void getCustomers() {

    }

    //Abdukahar
    public void getCustomerGroups() {

    }

    //yusuf
    public void getProductInfo() {

    }

    //Sofia
    public void getProductRootCategory() {

    }


        //Zuhra
        public void getRegisteredUsers () {

        }

        //Kamer
        public void getOrders () {

        }

        //Ayper
        public void getCreditMemos () {

        } //Leila

        public void getStoreInfo () {

        } //Melika

        public void getStockInfo () {

        }

        //Dilnur
        public void getSubCategory () {

        }

        //Abdusamad
        public void getStoreView () {

        }

        //Yusuf
        public void getTaxRule () {

        }
        //Sofia
        public void getRefund () {

        }
    }
