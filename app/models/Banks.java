package models;

import com.avaje.ebean.Model;

import javax.persistence.*;


/**
 * Created by apoorv on 20/05/16.
 */
@Entity
public class Banks extends Model
{
    @Id
    public Integer id;
    public static Finder<Integer, Banks> find = new Model.Finder<>(Integer.class, Banks.class);
    public String name;
}
