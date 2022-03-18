package dbEntries;

import core.DataBaseService;
import org.apache.log4j.Logger;

import java.sql.ResultSet;

public class DressesTable {

    public static Logger logger = Logger.getLogger(DressesTable.class);

    DataBaseService dataBaseService;

    public DressesTable(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }


    public void createTable() {
        logger.info("Создаем таблицу dresses");

        String createTableSQL = "CREATE TABLE dresses (" +
                "id SERIAL PRIMARY KEY, " +
                "type CHARACTER VARYING(20), " +
                "size CHAR, " +
                "color CHARACTER VARYING(20), " +
                ");";
        dataBaseService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем таблицу dresses");

        String dropTableInvoicesSQL = "DROP TABLE dresses;";

        dataBaseService.executeSQL(dropTableInvoicesSQL);
    }

    public ResultSet getAllDresses() {
        logger.info("Получаем все записи из таблицы dresses");

        String sql = "SELECT * FROM dresses ORDER BY id ASC;";

        return dataBaseService.executeQuery(sql);
    }

    public ResultSet getDressByID(int id) {
        String sql = "SELECT * FROM dresses WHERE id = " + id + ";";

        return dataBaseService.executeQuery(sql);
    }

    public void addDress(String type, char size , String color ) {
        logger.info("Добавляем запись в таблицу dresses");

        String insertTableSQL = "INSERT INTO public.dresses(" +
                "type, size,color)" +
                "VALUES ('" + type + "', '"+ size + "', '"+ color +");";

        dataBaseService.executeSQL(insertTableSQL);
    }
}
