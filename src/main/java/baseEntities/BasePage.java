package baseEntities;

import core.DataBaseService;
import org.apache.log4j.Logger;


public class BasePage {
    protected DataBaseService dataBaseService;
    public static Logger logger = Logger.getLogger(BasePage.class);

    public void setUpConnectionDB() {
        dataBaseService = new DataBaseService();
    }

    public void closeConnectionDB(){
        dataBaseService.closeConnection();
    }


}
