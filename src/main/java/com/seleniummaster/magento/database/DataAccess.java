package com.seleniummaster.magento.database;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DataAccess {
    //get product information - Yusuf
    public boolean getProductID(String productID, Connection connection) {
        boolean isProductExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlScript = String.format("select *from mg_catalog_category_product where product_id=299", productID);
        try {
            resultSet = statement.executeQuery(sqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (cachedRowSet == null) {
            System.out.println("No records Found");
            return false;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int count = 0;
        while (true) {
            try {
                if (!cachedRowSet.next()) {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                int productId = cachedRowSet.getInt("product_id");
                int productPosition = cachedRowSet.getInt("position");
                int categoryId = cachedRowSet.getInt("category_id");
                System.out.printf("product_id=%d position=%s category_id=%s",
                        productId, productPosition, categoryId);
                count = cachedRowSet.getRow();
                System.out.println("Total Rows: " + count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count >= 1) {
            isProductExist = true;
        }
        return isProductExist;

    }

    //get tax rule information - Yusuf
    public boolean getTaxRule(String taxRuleID, Connection connection) {
        boolean isCustomerExist = false;
        Statement statement = null;
        ResultSet resultSet = null;
        CachedRowSet cachedRowSet = null;
        try {
            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlScript = String.format("select *from mg_tax_calculation_rule where tax_calculation_rule_id=76",
                taxRuleID);
        try {
            resultSet = statement.executeQuery(sqlScript);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (resultSet == null) {
            System.out.println("No records Found");
            return isCustomerExist;
        } else {
            try {
                cachedRowSet.populate(resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        int count = 0;
        while (true) {
            try {
                if (!cachedRowSet.next()) {
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                int taxRuleId = cachedRowSet.getInt("tax_calculation_rule_id");
                String code = cachedRowSet.getString("code");
                int priority = cachedRowSet.getInt("priority");
                int position = cachedRowSet.getInt("position");
                System.out.println(String.format("taxRuleId=%d code=%s priority=%d position=%d ",
                        taxRuleId, code, priority, position));
                count = cachedRowSet.getRow();
                System.out.println("Total Rows: " + count);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (count >= 1) {
            isCustomerExist = true;
        }
        return isCustomerExist;

    }

    //    public boolean insertNewCategory(CategoryObject categoryObject,Connection connection){
//        String insertQuery="insert into cc_CubeCart_category" +
//                "(cat_name,cat_desc,cat_parent_id,cat_image,per_ship,seo_meta_title,seo_meta_description," +
//                "seo_meta_keywords,priority,status)values(?,?,?,?,?,?,?,?,?,?)";
//        PreparedStatement insertStatement=null;
//        try {
//            insertStatement=connection.prepareStatement(insertQuery);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            insertStatement.setString(1, categoryObject.getCat_name());
//            insertStatement.setString(2, categoryObject.getCat_desc());
//            insertStatement.setInt(3, categoryObject.getCat_parent_id());
//            insertStatement.setInt(4, categoryObject.getCat_image());
//            insertStatement.setInt(5, categoryObject.getPer_ship());
//            insertStatement.setString(6, categoryObject.getSeoMetaTitle());
//            insertStatement.setString(7, categoryObject.getSeoMetaDescription());
//            insertStatement.setString(8, categoryObject.getSeoMetaKeyWord());
//            insertStatement.setInt(9, categoryObject.getPriority());
//            insertStatement.setInt(10, categoryObject.getStatus());
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        int affectiveRow=0;
//        try {
//            affectiveRow=insertStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(String.format("%d rows affected",affectiveRow));
//        if(affectiveRow>=1)
//            return true;
//        else
//            return false;
//    }
    public boolean deleteCategory(String categoryName, Connection connection) {
        String deleteQuery = "delete from cc_CubeCart_category where cat_name=?";
        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = connection.prepareStatement(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            deleteStatement.setString(1, categoryName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int affectedRows = 0;
        try {
            affectedRows = deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%d row affected", affectedRows));
        if (affectedRows >= 1)
            return true;
        else
            return false;
    }

}
