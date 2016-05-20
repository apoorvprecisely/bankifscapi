package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by apoorv on 20/05/16.
 */
@Entity
public class Banks_Branches
{
    @Id
    public String ifsc;

    public String bank_id;
    public String bank_name;
    public String branch;
    public String address;
    public String city;
    public String district;
    public String state;
    public static Model.Finder<String, Banks_Branches> find = new Model.Finder<>(String.class, Banks_Branches.class);

}
