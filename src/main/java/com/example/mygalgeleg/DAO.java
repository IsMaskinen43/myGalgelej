package com.example.mygalgeleg;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class DAO implements IDAO {

    private List<DTOhigscore> dataList;
    private boolean conn = false;


    private static DAO single_instance = null;

    public static DAO getSingle_instance() {
        if (single_instance == null)
            single_instance = new DAO();
        return single_instance;
    }

    @Override
    public boolean openConn() {
        if (conn)
            return true;


        return false;
    }

    @Override
    public void closeConn() {

    }

    @Override
    public boolean isConn() {
        return false;
    }

    @Override
    public List<DTOhigscore> getData() {
        return null;
    }

    @Override
    public void safeData(DTOhigscore data) throws FileNotFoundException {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    private void writeFileOnInternalStorage(Context mcoContext, String sFileName, String sBody) {

    }
}