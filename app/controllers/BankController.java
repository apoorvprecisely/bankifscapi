package controllers;

import models.Banks;
import models.Banks_Branches;
import play.db.Database;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apoorv on 19/05/16.
 */
public class BankController extends Controller
{
    @Inject
    Database db;
    public Result fetchBanks() throws SQLException
    {
        List<Banks> allbanks = Banks.find.select("name").findList();
        return ok(Json.toJson(allbanks));
    }

    public Result fetchCitiesForBank(String name) throws SQLException
    {
        List<Banks_Branches> citiesForBank = Banks_Branches.find.select("city").setDistinct(true).where().eq("bank_name", name).findList();
        return ok(Json.toJson(citiesForBank));
    }

    public Result fetchBranches(String bankName, String cityName) throws SQLException
    {
        List<Banks_Branches> citiesForBank = Banks_Branches.find.where().eq("bank_name", bankName).where().eq("city", cityName).findList();
        return ok(Json.toJson(citiesForBank));
    }
}
