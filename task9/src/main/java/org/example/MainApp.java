package org.example;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.*;
import java.lang.reflect.Field;

public class MainApp {
    private static Connection connection;
    private static Statement statement;
    public static void process(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            String tableName = tableAnnotation.Title();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE if NOT EXISTS ").append(tableName).append("(");

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    String columnName = field.getName();
                    queryBuilder.append(columnName);
                    if (columnName=="dangerLvl"){
                        queryBuilder.append(" int");
                    } else if (columnName=="date") {
                        queryBuilder.append(" date");
                    }else
                    {
                        queryBuilder.append(" varchar(30)");
                    }

                    queryBuilder.append(", ");
                }
            }
            queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
            queryBuilder.append(");");
            String createTableQuery = queryBuilder.toString();
//
            try {
                statement.execute(createTableQuery);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void clearTable(String tableName) {
        String clearTableQuery = "DELETE FROM " + tableName;
//
        try {
            statement.executeUpdate(clearTableQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addToTable(Object object) {
        Class<?> clazz = object.getClass();
        if (clazz.isAnnotationPresent(Table.class)) {
            Table tableAnnotation = clazz.getAnnotation(Table.class);
            String tableName = tableAnnotation.Title();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("INSERT INTO ").append(tableName).append(" (");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    String columnName = field.getName();
                    queryBuilder.append(columnName).append(", ");
                }
            }
            queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
            queryBuilder.append(") VALUES (");
            for (Field field : fields) {
                if (field.isAnnotationPresent(Column.class)) {
                    try {
                        field.setAccessible(true);
                        Object value = field.get(object);
                        if (value instanceof String || value instanceof Color) {
                            queryBuilder.append("'").append(value).append("', ");
                        } else if (value instanceof Date) {
                            queryBuilder.append("'").append(value).append("'::date, ");
                        }else
                        {
                            queryBuilder.append(value).append(", ");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            queryBuilder.delete(queryBuilder.length() - 2, queryBuilder.length());
            queryBuilder.append(");");
            String addToTableQuery = queryBuilder.toString();
//
            try {
                statement.execute(addToTableQuery);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {
        connect();
        Hare hare0 = new Hare("Петя", 0, Color.white);
        Hare hare1 = new Hare("Саня", 2, Color.brown);
        Hare hare2 = new Hare("Федя", 3, Color.black);
        Hare1 haree = new Hare1("asd",2,Color.black, Date.valueOf("2007-12-02"));
        process(Hare.class);
        process(Hare1.class);
        clearTable("Hare");
        clearTable("Hare1");
        addToTable(haree);
        addToTable(hare0);
        addToTable(hare1);
        addToTable(hare2);
        disconnect();
    }
    public static void connect(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tp","Aerlen","");
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }
    }
    public static void disconnect() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}