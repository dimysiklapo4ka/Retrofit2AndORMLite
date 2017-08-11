package com.example.d1mys1klapo4ka.retrofit2andormlite.ormlite;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by d1mys1klapo4ka on 29.06.2017.
 */

public interface OrmLiteInterface {

    public List getAll(Class clazz) throws SQLException;


}
