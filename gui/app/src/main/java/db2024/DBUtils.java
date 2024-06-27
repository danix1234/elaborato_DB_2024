package db2024;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class DBUtils {
    public static TableModel emptyTable() {
        return new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return 0;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return null;
            }

        };
    }

    public static TableModel createTable(ResultSet resultSet) {
        var values = extractElems(resultSet);
        var tableModel = new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return values.size();
            }

            @Override
            public int getColumnCount() {
                return values.get(0).size();
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return values.get(rowIndex).get(columnIndex);
            }
            
        };
        // TODO: add headers
        return tableModel;
    }

    public static List<List<Object>> extractElems(ResultSet resultSet) {
        try {
            List<List<Object>> res = new ArrayList<>();
            final int cols = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {
                List<Object> tmp = new ArrayList<>();
                for (int i = 1; i <= cols; i++) {
                    tmp.add(resultSet.getObject(i));
                }
                res.add(tmp);
            }
            return res;
        } catch (Throwable t) {
            throw new IllegalStateException("could not convert result set to list of list");
        }
    }
}
