import by.epam.lab.bean.NumLen;

import static by.epam.lab.utils.Constants.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {

    public static void main(String[] args) {
        try {
            Class.forName(CLASS_NAME);
            ResultSet rs = null;
            try (Connection cn = DriverManager.getConnection(DB_URL, USER, PASSWORD); Statement st = cn.createStatement()) {
                //1
                List<NumLen> numLenList = new ArrayList<>();
                rs = st.executeQuery(SQL_SELECT_LEN_NUM);
                while (rs.next()) {
                    NumLen numLen = new NumLen(rs.getInt(1), rs.getInt(2));
                    numLenList.add(numLen);
                }
                //2
                st.executeUpdate(SQL_DELETE_FROM_FREQUENCIES);
                //3
                PreparedStatement ps = cn.prepareStatement(SQL_INSERT_INTO_FREQUENCIES);
                for (NumLen numLen : numLenList) {
                    ps.setInt(1, numLen.getLen());
                    ps.setInt(2, numLen.getNum());
                    ps.addBatch();
                }
                ps.executeBatch();

                rs = st.executeQuery(SQL_SELECT_FROM_FREQUENCIES_LEN_MORE_NUM);
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + ARROW + rs.getInt(2));
                }
            } finally {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
