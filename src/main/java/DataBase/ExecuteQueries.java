package DataBase;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExecuteQueries {

    public static void main(String[] args) {
        DataBase database = new DataBase();
        try {
            System.out.println(database.executeQueryForString("SELECT CONCAT(m.first_name, ' ', m.last_name) AS full_name " +
                    "FROM manager m " +
                    "JOIN department d ON m.department_id = d.id " +
                    "WHERE d.name = 'Комната добра'"+ "\t\t"));

            System.out.println(database.executeQueryForString("SELECT CONCAT(first_name, ' ', last_name) AS full_name " +
                    "FROM manager " +
                    "WHERE phone IS NOT NULL AND email LIKE '%gmail.com'" + "\t\t"));

            System.out.println(database.executeQueryForString("SELECT t.id FROM ticket t " +
                    "JOIN category c ON t.category_id = c.id " +
                    "WHERE t.creation_timestamp BETWEEN '2018-04-19' AND '2018-05-03' " +
                    "AND c.name = 'Финансы'"+"\t\t"));

            System.out.println(database.executeQueryForString("SELECT t.title " +
                    "FROM ticket t " +
                    "JOIN contact c ON t.contact_id = c.id " +
                    "WHERE t.priority = 'P4' AND first_name = 'Татьяна' AND last_name = 'Алимова';"+"\t\t"));

            List<Map<String, String>> queryResultDepartment = database.executeQueryForList("SELECT name, phone, email FROM department WHERE name LIKE '%website.com';");
            for (Map<String, String> row : queryResultDepartment) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

            List<Map<String, String>> queryResultManager = database.executeQueryForList("SELECT * FROM manager WHERE first_name = 'Oicm' AND last_name = 'Sdyw';"+"\t\t");
            for (Map<String, String> row : queryResultManager) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

            List<Map<String, String>> queryResult = database.executeQueryForList("SELECT m.first_name, m.last_name, d.name " +
                    "FROM manager m " +
                    "JOIN department d ON m.department_id=d.id " +
                    "WHERE d.name = 'ACRO';"+"\t\t");
            for (Map<String, String> row : queryResult) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

            List<Map<String, String>> RandomManagerQuery = database.executeQueryForList("SELECT CONCAT(manager.first_name, ' ' ,manager.last_name)AS full_name, manager.phone, manager.skype, manager.email, manager.login, manager.creation_timestamp, " +
                    "manager.is_admin, manager.update_timestamp, department.name AS department " +
                    "FROM manager " +
                    "JOIN department ON manager.department_id = department.id " +
                    "JOIN ticket ON manager.id = ticket.assignee_id " +
                    "JOIN company ON ticket.company_ticket_id = company.max_ticket_id " +
                    "JOIN stage ON ticket.stage_id = stage.id " +
                    "JOIN category ON ticket.category_id = category.id " +
                    "ORDER BY RANDOM() " +
                    "LIMIT 1;"+"\t\t");
            for (Map<String, String> row : RandomManagerQuery) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

            List<Map<String, String>> RandomDepartmentQuery = database.executeQueryForList("SELECT d.name AS title, d.phone, d.skype, d.website, d.email, d.country, d.city, d.street, d.building, d.room_number, d.update_timestamp, " +
                    "d.creation_timestamp, CONCAT(m.first_name, ' ', m.last_name) AS Managers " +
                    "FROM department d " +
                    "JOIN manager m ON d.id = m.department_id " +
                    "ORDER BY RANDOM() " +
                    "LIMIT 1;"+"\t\t");
            for (Map<String, String> row : RandomDepartmentQuery) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

            List<Map<String, String>> RandomCategoryQuery = database.executeQueryForList("SELECT category.name, ticket.title, company.name AS company, stage.name AS stage " +
                    "FROM category " +
                    "JOIN ticket ON category.id = ticket.category_id " +
                    "JOIN stage ON ticket.stage_id = stage.id " +
                    "JOIN company ON ticket.company_ticket_id = company.max_ticket_id " +
                    "ORDER BY RANDOM() " +
                    "LIMIT 1;"+"\t\t");
            for (Map<String, String> row : RandomCategoryQuery) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

            List<Map<String, String>> TicketInformationQuery = database.executeQueryForList("SELECT t.title, t.description, t.priority, s.name AS stage, c.name AS category, CONCAT(con.first_name,' ',con.last_name) AS contact, com.name AS company\n" +
                    "FROM ticket t\n" +
                    "JOIN stage s ON t.stage_id = s.id\n" +
                    "JOIN category c ON t.category_id=c.id\n" +
                    "JOIN contact con ON t.contact_id=con.id\n" +
                    "JOIN company com ON t.company_ticket_id = com.max_ticket_id\n" +
                    "WHERE t.title = 'Samokat15';"+"\t\t");
            for (Map<String, String> row : TicketInformationQuery) {
                for (Map.Entry<String, String> entry : row.entrySet()) {
                    String columnName = entry.getKey();
                    String columnValue = entry.getValue();
                    System.out.println(columnName + ": " + columnValue);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.close();
        }
    }
    //public HashMap<String,String>
}
