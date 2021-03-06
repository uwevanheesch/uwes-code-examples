package nl.han.oose.dea.database;

import nl.han.oose.dea.Order;
import nl.han.oose.dea.Item;

import javax.enterprise.inject.Default;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Default
public class ItemDAOMySQL implements IItemDAO {

    IDBConnectionFactory dbConnectionFactory = new DBConnectionFactory();

    @Override
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

    @Override
    public void addItem(Item item) {
        String sqlQuery = "INSERT INTO STOCK_ITEMS VALUES (?,?)";
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be inserted due to database problem.", e);
        }
    }

    @Override
    public Item findItemByName(String name) {
        String sqlQuery = "SELECT * FROM STOCK_ITEMS WHERE name=?";
        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Item(resultSet.getString("name"), resultSet.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Values could not be retrieved due to database problem.", e);
        }
        return null;
    }

    public Order getOrderById(int orderId) {
        String sqlQuery = "SELECT * FROM ORDER_ITEMS WHERE id=?";
        Order order = null;

        try (
                Connection con = dbConnectionFactory.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
        ) {
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (order == null) {
                    order = new Order(resultSet.getInt("id"),
                            resultSet.getString("description"));
                }
                order.getStockItems().add(findItemByName(resultSet.getString("stock_item")));
            }

            if (order == null) {
                throw new IllegalArgumentException("No order with that id found: " + orderId);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Values could not be retrieved due to database problem.", e);
        }
        return order;
    }

}
