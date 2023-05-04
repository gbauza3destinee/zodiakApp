import com.bloomtech.zodiakProject.UserDao;

import java.util.ArrayList;
import java.util.HashMap;

public class App {

    HashMap <String, ArrayList<String>> elementalToZodiacMap = new HashMap<>();


    public static void main(String[] args) {

        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper();
        UserDao userDao = new UserDao();



    }
}
