package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;

public class screen extends javax.swing.JFrame {

    String input_şirketAdı ;
    String input_tarih ;
    sql_islemleri islem = new sql_islemleri();



    public screen()
    {
        initComponents();
    }


    //ANA PENCERE GÖVDESİ-------------------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        resim = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tümBilgiler = new javax.swing.JTextArea();
        tarih = new javax.swing.JTextField();
        tarih.setText("Yaz..");
        şirket = new javax.swing.JTextField();
        şirket.setText("Yaz..");
        aramaButonu = new javax.swing.JButton();
        resimSeç = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        list1 = new javax.swing.JTable();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resim.setText("Resim Gösterilecek");

        tümBilgiler.setColumns(20);
        tümBilgiler.setRows(5);
        jScrollPane1.setViewportView(tümBilgiler);

        aramaButonu.setText("ARA");
        aramaButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aramaButonuActionPerformed(evt);
            }
        });

        resimSeç.setText("Resim Seç");
        resimSeç.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resimSecActionPerformed(evt);
            }
        });

        jLabel1.setText("Tarih:");

        jLabel2.setText("İşletme adı:");

        /*list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });*/

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(resim, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(76, 76, 76)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(236, 236, 236)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(aramaButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addGap(16, 16, 16)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(tarih, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(şirket, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(resimSeç, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(şirket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(50, 50, 50)
                                                .addComponent(aramaButonu))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(resimSeç)
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                                        .addComponent(resim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }





    //ARAMA BUTONUNA BASILDIĞI ZAMAN YAPILACAKLAR------------------------------------------------------------------------
    JFrame frr= new JFrame();
    private void aramaButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aramaButonuActionPerformed
        // TODO add your handling code here:
        // kanka burada ara butonuna basınca olacakları yapıcaksınız

        /*screenx s = new screenx();
        s.setVisible(true);*/

        String[] column ={"ID","Firma Adi","tarih","Fis No","Urun","KDV","Fiyat","Toplam Fiyat"};
        input_şirketAdı = şirket.getText();
        input_tarih = tarih.getText();

        if (input_tarih.equals("Yaz..")){
            ArrayList<String[]> aramasonucu = islem.search_name(input_şirketAdı);
            dizi = aramasonucu.toArray(new String[aramasonucu.size()][]);
            list1 = new javax.swing.JTable(dizi,column);
        }
        else if(input_şirketAdı.equals("Yaz..")){
            ArrayList<String[]> aramasonucu = islem.search_tarih(input_tarih);
            dizi = aramasonucu.toArray(new String[aramasonucu.size()][]);
            list1 = new javax.swing.JTable(dizi,column);
        }else {
            ArrayList<String[]> aramasonucu = islem.search(input_şirketAdı,input_tarih);
            dizi = aramasonucu.toArray(new String[aramasonucu.size()][]);
            list1 = new javax.swing.JTable(dizi,column);
        }

        frr.add(list1);
        frr.setLocationRelativeTo(null);
        frr.setSize(1000,250);
        frr.setVisible(true);



        şirket.setText("Yaz..");
        tarih.setText("Yaz..");

    }




    //RESİM SEC BUTONUNA BASILDIĞI ZAMAN YAPILACAKLAR-------------------------------------------------------------------

    private void resimSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resimSeçActionPerformed

        JFileChooser j = new JFileChooser(new File("/home/huseyin/IdeaProjects/yazlab-1/images/"),FileSystemView.getFileSystemView());

        // invoke the showsOpenDialog function to show the save dialog
        int r = j.showOpenDialog(null);

        four_point.dispose();
        // if the user selects a file
        if (r == JFileChooser.APPROVE_OPTION)

        {
            // set the label to the path of the selected file
            four_point = new duzeltici(j.getSelectedFile().getAbsolutePath());
        }
        // if the user cancelled the operation
        else
            System.out.println("the user cancelled the operation");

            //---------     PARSİNG     ------------------------------------

            /*islem.insert(pars edilen bilgiler );*/
        /*ImageIcon icon = new ImageIcon("warpOut.png");
        resim.setIcon(icon);*/

    }






    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                screen ekran = new screen();
                ekran.setVisible(true);
            }
        });
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aramaButonu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable list1;
    // private javax.swing.JTable list1;
    private javax.swing.JLabel resim;
    private javax.swing.JButton resimSeç;
    private javax.swing.JTextField tarih;
    static javax.swing.JTextArea tümBilgiler;
    private javax.swing.JTextField şirket;
    duzeltici four_point = new duzeltici(); //-----------> resmi kırpmak için kullandık
    String[][] dizi; //-------------> searchten gelen Arraylistin String dizisine dönüştürülmesi iç in kullandık.
    // End of variables declaration//GEN-END:variables




}
