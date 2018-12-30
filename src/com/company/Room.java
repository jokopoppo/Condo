package com.company;

/**
 * Created by PC on 27/11/2559.
 */
public class Room {

    private int room_price = 2000 ;

    private int electric_lastmont = 0 ;
    private int water_lastmont = 0 ;

    private int electric_thismont = 0 ;
    private int water_thismont = 0 ;

    private static final int trash = 50 ;

    private static final int water_unit = 15 ;
    private static final int electric_unit = 7 ;

    public int internet = 100 ;
    public Room (){



    }

    public Room (int price){
        setRoom_price(price);


    }

    public String calculate(String m){

        int water ;
        int electric ;

        int wunit = (this.getWater_thismont() - this.getWater_lastmont());
        int eunit = (this.getElectric_thismont() - this.getElectric_lastmont());
        if( wunit < 5 ) wunit = 5;
//        wunit ++ ;
        eunit++;
        water =  wunit * water_unit ;
        electric = eunit * electric_unit ;

        if((int)(water + electric + getRoom_price() + trash + internet )>10000){

            throw new ExceptionInInitializerError();
        }
        return m + "\n น้ำ :  " + wunit + "x" + water_unit + " = "+water + " บาท " + "\n" +
                " ไฟ :  "+ eunit+ "x" + electric_unit +" = " +electric + " บาท " + "\n" +
                "ค่าห้อง : " + room_price + "\n" +
                "ค่าขยะ : " + trash + "\n" +
                "ค่าเนต : " + internet + "\n" +
                " สุทธิ : " + (int)(water + electric + getRoom_price() + trash + internet )+ " บาท" +"\n" ;



    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }

    public int getElectric_thismont() {
        return electric_thismont;
    }

    public void setElectric_thismont(int electric_thismont) {
        if(electric_thismont > electric_lastmont)this.electric_thismont = electric_thismont;
        else {
            System.out.println("Error: Electric : " + electric_thismont + " :: " + getElectric_lastmont() );
            throw new ExceptionInInitializerError();
        }
    }

    public int getWater_thismont() {
        return water_thismont;
    }

    public void setWater_thismont(int water_thismont) {
        if(water_thismont >= water_lastmont)this.water_thismont = water_thismont;
        else {
            System.out.println("Error: Water : " + water_thismont + " :: " + getWater_lastmont() );
            throw new ExceptionInInitializerError();
        }
    }

    public int getElectric_lastmont() {
        return electric_lastmont;
    }

    public void setElectric_lastmont(int electric_lastmont) {
        this.electric_lastmont = electric_lastmont;
    }

    public int getWater_lastmont() {
        return water_lastmont;
    }

    public void setWater_lastmont(int water_lastmont) {
        this.water_lastmont = water_lastmont;
    }
}
