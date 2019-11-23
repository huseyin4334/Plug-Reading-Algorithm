package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    //                                                  TARİH  ------------------------------------------
    public void tarih(String text) {
        System.out.println(text);//d means digit
        //([0-2][0-9]|(3)[0-1]).(((0)[0-9])|((1)[0-2])).([0-9][0-9][0-9][0-9])
        String arama = "([0-2][0-9]|(3)[0-1])([.-/])(((0)[0-9])|((1)[0-2]))([.-/])([0-9][0-9][0-9][0-9])";
        Pattern pattern = Pattern.compile(arama);

        Matcher eslesme = pattern.matcher(text);


        int count = 0;
        while (eslesme.find()) {
            count++;
            tarih_temp = eslesme.group();
            System.out.println(eslesme.group());
        }


    }


    //                                                  SAAT  ------------------------------------------
    public void saat(String text){
        String arama = "(([0-2][0-9]):([0-5][0-9]))";
        Pattern pattern = Pattern.compile(arama);

        Matcher eslesme = pattern.matcher(text);

        int count = 0;
        while (eslesme.find()) {
            count++;
            saat_temp = eslesme.group();
            System.out.println(eslesme.group());
        }

    }



    String firmaAdi_temp;
    String tarih_temp;
    String fisno_temp = "";
    String saat_temp;
    ArrayList<String[]> urunler = new ArrayList<>();
    String urun_temp="";
    String KDV_temp="";
    String Fiyat_temp="";
    String[] urunler_temp;
    String GenelFiyat_temp = "";

    public void dosya_okuma() throws IOException {
        // The name of the file to open.
        String fileName = "temp.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            int j = 0;
            int k = 0;
            ArrayList<Character> sayilar = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null) {
                if (j == 0){
                    firmaAdi_temp=line;
                    j++;
                }

                else if (line.matches("(?i:.*fisno.*)") || line.matches("(?i:.*fis no.*)") || line.matches("(?i:.*fisnQ.*)") || line.matches("(?i:.*fisn0.*)") || line.matches("(?i:.*tisno.*)")){
                    for(int i = 0 ; i < line.length(); i++ )
                    {
                        if(Character.isDigit(line.charAt(i)))
                        {
                            fisno_temp += line.charAt(i);
                        }
                    }
                }
                else if (line.matches("(?i:.*top.)") || line.matches("(?i:.*toplam.*)") || line.matches("(?i:.*foplam.*)") || line.matches("(?i:.*fop.)") || line.matches("(?i:.*t0blam.*)")){
                    for(int i = 0 ; i < line.length(); i++ )
                    {
                        if(Character.isDigit(line.charAt(i)) || line.charAt(i) == ',')
                        {
                            GenelFiyat_temp += line.charAt(i);
                        }
                    }
                }
                else if (line.matches("(?i:.*%.*)")){

                    int i;
                    for(i = 0 ; i < line.length(); i++ )
                    {
                        if(line.charAt(i) != '%'){
                            urun_temp += line.charAt(i);
                        }
                        else {
                            break;
                        }
                    }

                    int l;
                    for (l = i+1;l<line.length();l++){
                        if(line.charAt(l) != ' ' && line.charAt(l) != '*'){
                            KDV_temp += line.charAt(l);
                        }
                        else {
                            break;
                        }
                    }

                    int b;
                    for(b=l+1;b<line.length();b++){
                        if(line.charAt(b) != ' ' && line.charAt(b) != '*' && line.charAt(b) != '%'){
                            Fiyat_temp += line.charAt(b);
                        }
                    }
                    urunler_temp = new String[3];
                    urunler_temp[0]=urun_temp;
                    urunler_temp[1]=KDV_temp;
                    urunler_temp[2]=Fiyat_temp;
                    urunler.add(urunler_temp);
                    urun_temp="";
                    KDV_temp="";
                    Fiyat_temp="";
                }

            }
            j=0;
            for(int i = 0;i<urunler.size();i++){
                System.out.println(firmaAdi_temp+"\n"+tarih_temp+"\n"+urunler.get(i)[0]+"\n"+urunler.get(i)[1]+"\n"+urunler.get(i)[2]+"\n"+GenelFiyat_temp);
            }
            // Always close files.
            bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }


    public void dosya_yazma(String text) throws IOException {
        // The name of the file to open.
        String fileName = "temp.txt";

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(text);

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '" + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}
