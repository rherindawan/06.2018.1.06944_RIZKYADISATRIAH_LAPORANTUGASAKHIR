/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta.basis.data;

import Database.koneksi;
import View.Login;
import View.*;
import java.sql.SQLException;
import java.text.ParseException;

/**
 *
 * @author ACER
 */
public class TABASISDATA {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws SQLException,ParseException{
      //Login login = new Login();
      //login.setVisible(true);
      new transaksiview().setVisible(true);
    }
    
}