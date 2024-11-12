package dci.j24e01;

import jdbc.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        try(var conn = DBUtils.getConnection();
            Scanner sc = new Scanner(System.in);
        ) {
            System.out.println("Data before transaction");
            System.out.println("-----------------------");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from accounts");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2));
            }

            System.out.println("\nTx begins here");
            System.out.println("-----------------------");

            conn.setAutoCommit(false);

            st.executeUpdate("UPDATE accounts SET balance=balance-250000 WHERE name='oleg'");
            st.executeUpdate("UPDATE accounts SET balance=balance+250000 WHERE name='robin'");

            System.out.println("\nCan you please confirm the Tx? [Y/N] ");

            String option = sc.nextLine();

            if (option.equalsIgnoreCase("Y")) {
                conn.commit();
                System.out.println("Tx commited!!");
            } else {
                conn.rollback();
                System.out.println("Tx rolledback!!");
            }

            System.out.println("\nData after transaction");
            System.out.println("-----------------------");

            rs = st.executeQuery("select * from accounts");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getInt(2));
            }
        }
//        conn.close();
    }
}