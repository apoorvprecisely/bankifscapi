package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.utils.UriEncoding;
import views.html.index;

import javax.inject.Inject;

import play.mvc.*;
import play.db.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by apoorv on 19/05/16.
 */
public class BankController extends Controller
{
    @Inject
    Database db;

    public Result fetchBanks() throws SQLException
    {
        String query = " select array_to_json(array_agg(row_to_json(t))) from ( select name from banks) t;";
        return connectAndGetJson(query);
    }

    public Result fetchCitiesForBank(String name) throws SQLException
    {
        String query = " select array_to_json(array_agg(row_to_json(t))) from ( select DISTINCT city from bank_branches where bank_name='" + name + "') t;";
        return connectAndGetJson(query);
    }

    public Result fetchBranches(String bankName, String cityName) throws SQLException
    {
        String query = " select array_to_json(array_agg(row_to_json(t))) from ( select ifsc,bank_name,branch,city from bank_branches where city='" + cityName + "' and bank_name='" + bankName + "') t;";
        return connectAndGetJson(query);
    }

    private Result connectAndGetJson(String query) throws SQLException
    {
        Connection connection = null;
        Statement statement = null;
        String name = "";
        try
        {
            connection = db.getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next())
            {
                name = rs.getString("array_to_json");
            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            if (statement != null)
            {
                statement.close();
            }

            if (connection != null)
            {
                connection.close();
            }

        }
        return ok(name);
    }

}
