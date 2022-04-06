import by.epam.lab.bean.LenNum;

import static by.epam.lab.utils.Constants.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunner {

    public static void main(String[] args) {
        try {
            ResultSet rs = null;
            try (Connection cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                 Statement st = cn.createStatement();
                 PreparedStatement ps = cn.prepareStatement(SQL_INSERT_INTO_FREQUENCIES)) {
                st.executeUpdate(SQL_DELETE_FROM_FREQUENCIES);
                rs = st.executeQuery(SQL_SELECT_LEN_NUM);
                //1
                List<LenNum> lenNumList = new ArrayList<>();
                while (rs.next()) {
                    LenNum lenNum = new LenNum(rs.getInt(LEN_IND), rs.getInt(NUM_IND));
                    lenNumList.add(lenNum);
                    System.out.println(lenNum);
                }
                //3
                for (LenNum lenNum : lenNumList) {
                    ps.setInt(LEN_IND, lenNum.getLen());
                    ps.setInt(NUM_IND, lenNum.getNum());
                    ps.addBatch();
                }
                ps.executeBatch();

                rs = st.executeQuery(SQL_SELECT_FROM_FREQUENCIES_LEN_MORE_NUM);
                while (rs.next()) {
                    System.out.println(rs.getInt(LEN_IND) + SPLITTER + rs.getInt(NUM_IND));
                }
            } finally {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
