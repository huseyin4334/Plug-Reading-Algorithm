package com.company;

import java.sql.*;
import java.util.ArrayList;

public class sql_islemleri {


    public static Connection connect() throws ClassNotFoundException {
        Connection conn = null;

        try {
            // db parameters
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:images/YENİ.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } /*finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }*/
        return conn;
    }





    //-------------------------     SELECT ALL      -----------------------------------------


    public void insert(String firmaAdi, String saat, String tarih, ArrayList<String[]> urunler ,String fisNo, String genel_toplam) {
        String satis = "INSERT INTO satis(firmaAdı, tarih, fisNo, toplamFiyat, saat) VALUES(?,?,?,?,?)";
        String id = "select max(ID) as id from satis";
        int idd;
        String urunlere = "INSERT INTO urunler(ID, urun, KDV, fiyat) VALUES(?,?,?,?)";
        try{
            Connection conn = connect();


            PreparedStatement preparedStmt = conn.prepareStatement(satis);
            preparedStmt.setString (1, firmaAdi);
            preparedStmt.setString   (2, tarih);
            preparedStmt.setString   (3, fisNo);
            preparedStmt.setString (4, genel_toplam);
            preparedStmt.setString (5, saat);
            preparedStmt.executeUpdate();


            Statement stmt  = conn.createStatement();
            ResultSet results = stmt.executeQuery(id);
            idd = results.getInt("id");

            preparedStmt = conn.prepareStatement(urunlere);

            for(int i=0; i<urunler.size();i++) {
                preparedStmt.setInt(1, idd);
                for(int j = 0;  j<3;j++) {
                    preparedStmt.setString(j + 2, urunler.get(i)[j]);
                }
                preparedStmt.executeUpdate();
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }




        //-------------------------        SEARCH       -----------------------------------------

    public ArrayList<String[]> search(String name, String tarih){
        ArrayList<String[]> rows=new ArrayList<>();
        String sql = "SELECT satis.ID, satis.firmaAdı, satis.tarih, satis.fisNo, urunler.urun, urunler.KDV, urunler.Fiyat, satis.toplamFiyat FROM satis,urunler where satis.ID = urunler.ID and satis.firmaAdı='"+name+"' and satis.tarih='"+tarih+"'";
        System.out.println(sql);

        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet results    = stmt.executeQuery(sql);

            // loop through the result set
            while(results.next()) {   // Move the cursor to the next row, return false if no more row
                int id_temp = results.getInt("ID");
                String firmaAdi_temp = results.getString("firmaAdı");
                String tarih_temp = results.getString("tarih");
                String fisno_temp=results.getString("fisNo");
                String urun_temp = results.getString("urun");
                String KDV_temp = results.getString("KDV");
                String Fiyat_temp = results.getString("Fiyat");
                String GenelFiyat_temp = results.getString("toplamFiyat");

                String[] temp ={String.valueOf(id_temp),firmaAdi_temp, tarih_temp, fisno_temp, urun_temp, String.valueOf(KDV_temp), String.valueOf(Fiyat_temp) , GenelFiyat_temp};
                rows.add(temp) ;

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return rows;
    }

    public ArrayList<String[]> search_name(String name){
        ArrayList<String[]> rows=new ArrayList<>();
        String sql = "SELECT satis.ID, satis.firmaAdı, satis.tarih, satis.fisNo, urunler.urun, urunler.KDV, urunler.Fiyat, satis.toplamFiyat FROM satis,urunler where satis.ID = urunler.ID and satis.firmaAdı='"+name+"'";
        System.out.println(sql);

        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet results    = stmt.executeQuery(sql);

            // loop through the result set
            while(results.next()) {   // Move the cursor to the next row, return false if no more row
                int id_temp = results.getInt("ID");
                String firmaAdi_temp = results.getString("firmaAdı");
                String tarih_temp = results.getString("tarih");
                String fisno_temp=results.getString("fisNo");
                String urun_temp = results.getString("urun");
                String KDV_temp = results.getString("KDV");
                String Fiyat_temp = results.getString("Fiyat");
                String GenelFiyat_temp = results.getString("toplamFiyat");

                String[] temp ={String.valueOf(id_temp),firmaAdi_temp, tarih_temp, fisno_temp, urun_temp, String.valueOf(KDV_temp), String.valueOf(Fiyat_temp) , GenelFiyat_temp};
                rows.add(temp) ;

            }

            for(int i=0;i<rows.size();i++){
                System.out.println(rows.get(i)[0]+" "+rows.get(i)[1]+" "+rows.get(i)[2]+" "+rows.get(i)[3]+" "+rows.get(i)[4]+" "+rows.get(i)[5]+" "+rows.get(i)[6]+" "+rows.get(i)[7]+" ");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return rows;
    }


    public ArrayList<String[]> search_tarih(String tarih){
        ArrayList<String[]> rows=new ArrayList<>();
        String sql = "SELECT satis.ID, satis.firmaAdı, satis.tarih, satis.fisNo, urunler.urun, urunler.KDV, urunler.Fiyat, satis.toplamFiyat FROM satis,urunler where satis.ID = urunler.ID and satis.firmaAdı='"+tarih+"'";
        System.out.println(sql);

        try {
            Connection conn = connect();
            Statement stmt  = conn.createStatement();
            ResultSet results    = stmt.executeQuery(sql);

            // loop through the result set
            while(results.next()) {   // Move the cursor to the next row, return false if no more row
                int id_temp = results.getInt("ID");
                String firmaAdi_temp = results.getString("firmaAdı");
                String tarih_temp = results.getString("tarih");
                String fisno_temp=results.getString("fisNo");
                String urun_temp = results.getString("urun");
                String KDV_temp = results.getString("KDV");
                String Fiyat_temp = results.getString("Fiyat");
                String GenelFiyat_temp = results.getString("toplamFiyat");

                String[] temp ={String.valueOf(id_temp),firmaAdi_temp, tarih_temp, fisno_temp, urun_temp, String.valueOf(KDV_temp), String.valueOf(Fiyat_temp) , GenelFiyat_temp};
                rows.add(temp) ;

            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return rows;
    }




}
