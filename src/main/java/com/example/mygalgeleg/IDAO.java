package com.example.mygalgeleg;

import java.io.FileNotFoundException;
import java.util.List;

public interface IDAO {

    boolean openConn();
    void closeConn();
    boolean isConn();
    List<DTOhigscore> getData();
    void safeData(DTOhigscore data) throws FileNotFoundException;

}
