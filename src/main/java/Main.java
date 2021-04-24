import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        DbManager db = new DbManager("localhost:3306", "root", "8976yd46", "jtest");
        Connection conn = db.connect();
        Statement statement1 = conn.createStatement();
        statement1.execute("create table if not exists Student(" +
                "id integer primary key auto_increment, " +
                "name varchar(100), " +
                "rate double);");

        String s1_name = "Corwin of Amber";
        double s1_rate = 190;
        String ins1 = "insert into Student(name, rate) values('" + s1_name + "', " + s1_rate + ")";
        //statement1.execute(ins1);
        String s2_name = "Han Solo";
        double s2_rate = 180;

        PreparedStatement statement2 = conn.prepareStatement("insert into Student(name, rate) value(?,?)");
        statement2.setString(1, s2_name);
        statement2.setDouble(2, s2_rate);
        //statement2.executeUpdate();

        String se1 = "select * from Student";
        ResultSet set = db.getSelectQuery(se1, conn);
        while (set.next()){
            System.out.println(set.getInt("id") + " " + set.getString("name") + " " + set.getDouble("rate"));
        }
    }
}
