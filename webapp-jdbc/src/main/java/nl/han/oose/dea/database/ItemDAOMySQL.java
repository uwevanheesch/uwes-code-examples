package nl.han.oose.dea.database;

import nl.han.oose.dea.webservices.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOMySQL {

    private DBConnectionFactory dbConnectionFactory = new DBConnectionFactory();

    public List<Item> getItems() {
        List<Item> resultList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM STOCK_ITEMS";
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                resultList.add(new Item(resultSet.getString("name"), resultSet.getString("description")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be retrieved due to database problem.", e);
        }
        return resultList;
    }

    public void addItem(Item item) {
        String sqlQuery = "INSERT INTO STOCK_ITEMS VALUES (?,?)";
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1,item.getName());
            preparedStatement.setString(2,item.getDescription());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be inserted due to database problem.", e);
        }
    }

    public Item findItemByName(String name) {
        String sqlQuery = "SELECT * FROM STOCK_ITEMS WHERE name=?";
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return new Item(resultSet.getString("name"),resultSet.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be retrieved due to database problem.", e);
        }
        return null;
    }

}