package dbEntries;


import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class UsersTable {
    public static Logger logger = Logger.getLogger(UsersTable.class);

    DataBaseService dataBaseService;

    public UsersTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }


    public void createTable() {
        logger.info("Создаем таблицу users");

        String createTableSQL = "CREATE TABLE users (" +
                "id SERIAL PRIMARY KEY, " +
                "login CHARACTER VARYING(30), " +
                "password CHARACTER VARYING(30), " +
                ");";
        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу users");

        String dropTableUsersSQL = "DROP TABLE users;";

        dataBaseService.executeSQL(dropTableUsersSQL);
    }

    public ResultSet getAllUsers() {
        logger.info("Получаем все записи из таблицы users");

        String sql = "SELECT * FROM users ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getUserByID(int id) {
        String sql = "SELECT * FROM users WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addUser(String login, String password) {
        logger.info("Добавляем запись в таблицу users");

        String insertTableSQL = "INSERT INTO public.users(" +
                "login, password)" +
                "VALUES ('" + login + "', '" + password +");";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
