package com.company;


import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class Main {

    public static void main(String[] args)throws IOException {
	// write your code here
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy ");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        Room room[] = new Room[17] ;

        room[0] = new Room(2000,0); //1
        room[1] = new Room(2100,0); //2
        room[2] = new Room(2000,100); //3
        room[3] = new Room(2100,0); //4
        room[4] = new Room(2000,0); //5
        room[5] = new Room(2000,0); //6
        room[6] = new Room(2000,100); //7
        room[7] = new Room(2000,0); //8
        room[8] = new Room(2000,100); //9
        room[9] = new Room(2000,0); //10
        room[10] = new Room(2000,0); //11
        room[11] = new Room(2000,100); //12
        room[12] = new Room(2000,0); //01
        room[13] = new Room(2000,100); //02
        room[14] = new Room(2200,0); //03
        room[15] = new Room(2500,0); //04
        room[16] = new Room(2000,100); //05

        readFile("electric_lastmont.txt",room,3);
        readFile("water_lastmont.txt",room,4);
        readFile("electric_thismont.txt",room,1);
        readFile("water_thismont.txt",room,2);


        String s = "";

        //write("new.txt",readFile("water_lastmont.txt",room,4));
        for (int i = 0; i < 17; i++) {
            if(i>11) {
                System.out.print("\nRoom [ " + 0+(int)(i-11) + " ] ||  ");
                s+="\nRoom [ " + 0+(int)(i-11) + " ] ||  ";
            }
            else {
                System.out.print("\nRoom [ " + (int)(i+1) + " ] ||  ");
                s+="\nRoom [ " + (int)(i+1) + " ] ||  ";
            }

            System.out.println(room[i].calculate(dtf.format(now)));
            s+=room[i].calculate(dtf.format(now));
        }


        write("Total.txt",s);
       // System.out.println(s);
    }

    public static String readFile(String what,Room[] room,int choice){
        String value = "" ;
        try {
            // อ่านไฟล์ชื่อ textfile.txt
            FileInputStream fstream = new FileInputStream(what);

            // Get the object of DataInputStream
            DataInputStream instream = new DataInputStream(fstream);
            BufferedReader bf = new BufferedReader(new InputStreamReader(instream));
            String line;

            // อ่านไฟล์ทีละบรรทัด
            int i= 0 ;
            while ((line = bf.readLine()) != null) {
                //System.out.println(line);
                value = value + "\n" + line ;

                if(choice == 1 ) room[i].setElectric_thismont(Integer.parseInt(line));
                else if(choice == 2) room[i].setWater_thismont(Integer.parseInt(line));
                else if(choice == 3) room[i].setElectric_lastmont(Integer.parseInt(line));
                else  room[i].setWater_lastmont(Integer.parseInt(line));
                i++;
            }
            // ปิด input stream
            instream.close();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
         return value;

    }

    public static void write(String what,String x){
        try {
            // สร้าง object เพื่อใช้เขียนไฟล์ โดยระบุชื่อไฟล์ที่ต้องการสร้าง
            FileWriter writer = new FileWriter(what);

            // สร้าง object เพื่อใช้เขียนข้อมูลลงไปในไฟล์
            BufferedWriter out = new BufferedWriter(writer);

            // เขียนข้อมูลลงไปในไฟล์
            out.write(x);


            // ปิดการเขียนไฟล์
            out.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
