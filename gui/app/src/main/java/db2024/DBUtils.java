package db2024;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
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

    public static void updateTable(JTable table, ResultSet resultSet) {
        // THIS WAS SUCH AN HELL!!!
        // WHY IS THERE NO BUILTIN METHOD TO CONVERT A RESULTSET INTO A JTABLE???
        final var headers = extractHeaders(resultSet);
        final var values = extractElems(resultSet);
        final var rows = values.size();
        final var cols = values.get(0).size();
        final var tmp = new DefaultTableModel();
        tmp.setColumnIdentifiers(new Vector<String>(headers));
        tmp.setColumnCount(cols);
        tmp.setRowCount(rows);
        System.out.println(cols);
        System.out.println(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println(i + " " + j);
                System.out.println(values.get(i).get(j));
                tmp.setValueAt(values.get(i).get(j), i, j);
            }
        }
        table.setModel(tmp);
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
        return tableModel;
    }

    private static List<List<Object>> extractElems(ResultSet resultSet) {
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

    private static List<String> extractHeaders(ResultSet resultSet) {
        try {
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                res.add(resultSet.getMetaData().getColumnLabel(i));
            }
            return res;
        } catch (Throwable t) {
            throw new IllegalStateException("could not extract resultSet metadata");
        }
    }
}
