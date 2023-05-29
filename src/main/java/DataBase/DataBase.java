package DataBase;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DataBase {
    private Connection connection;

    public DataBase() {
        Properties properties = new Properties();
        try (InputStream inputStream = DataBase.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to PostgreSQL server!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String executeQueryForString(String query) throws SQLException{
        if(connection== null){
            System.out.println("Connection is not established");
            return null;
        }
        try(PreparedStatement statment = connection.prepareStatement(query);
            ResultSet resultSet = statment.executeQuery()){
            StringBuilder result = new StringBuilder();
            while (resultSet.next()){
                String fullName = resultSet.getString(1);
                result.append(fullName).append("\n");
            }
            return result.toString();
        }
    }

    public List<Map<String,String>> executeQueryForList(String sqlQuery) throws SQLException {
        if(connection == null){
            System.out.println("Connection is not established");
            return null;
        }
        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery)){
            List<Map<String,String>> resultList = new ArrayList<>();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()){
                Map<String,String > rowMap = new HashMap<>();
                for(int i =1; i<= columnCount;i++){
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);
                    rowMap.put(columnName,columnValue);
                }
                resultList.add(rowMap);
            }
            return resultList;
        }
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}