package com.ratnikov.HW.HW2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MyHtmlImpl implements MyHtml{
    @Override
    public StringBuilder stringBuilder(ResultSet resultSet) throws SQLException {
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        while (resultSet.next()) {
            // process each row of query results
            resultingHtml.append("<tr>"); // add row start tag
            resultingHtml.append("<td>").append(resultSet.getString("emp_name")).append("</td>"); // appending employee name
            resultingHtml.append("<td>").append(resultSet.getDouble("salary")).append("</td>"); // appending employee salary for period
            resultingHtml.append("</tr>"); // add row end tag
            totals += resultSet.getDouble("salary"); // add salary to totals
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml;
    }
}
