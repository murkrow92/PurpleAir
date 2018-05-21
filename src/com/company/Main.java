package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static int diffdays(Date ngaybatdau, Date ngaytinh) {
        long diff = ngaytinh.getTime() - ngaybatdau.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        System.out.println("de quy diff " + diffDays);
        if (diffDays > 10228) {
            ngaybatdau.setDate(ngaybatdau.getDate() + 10228);
            return diffdays(ngaybatdau, ngaytinh);
        }
        if (diffDays < 0) {
            ngaybatdau.setDate(ngaybatdau.getDate() - 10228);
            return diffdays(ngaybatdau, ngaytinh);
        }
        return (int) diffDays;
    }

    public static void main(String[] args) throws ParseException {
        float mphan = 10228 / 12;
        System.out.println("mat " + mphan + " ngay de di duoc 1 phan");
        float mdo = mphan / 30;
        System.out.println("mat " + mdo + " ngay de di duoc 1 do ");
        float mphut = mdo / 60;
        System.out.println("mat " + mphut + " ngay de di duoc 1 phut ");
        float ngay = 11 * mphan + 10 * mdo + 35 * mphut;
        System.out.println("mat " + ngay + " de di duoc 11p 10do 35p");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngaybatdau = sdf.parse("01/06/2009");
        ngaybatdau.setDate((int) (ngaybatdau.getDate() - ngay));//=>07/12/1982

        System.out.println(sdf.format(ngaybatdau));
        Scanner scanner = new Scanner(System.in);
        System.out.println(" nhap ngay tinh dd/MM/yyyy");
        Date ngaytinh = sdf.parse(scanner.next());
        int songaydadiduoc = diffdays(ngaybatdau, ngaytinh); //vi du: 1000 ngay
        System.out.println(songaydadiduoc);
        int soPhandiDuoc = (int) (songaydadiduoc / mphan); //mat 852 de di duoc 1 phan
        System.out.println(soPhandiDuoc);
        float songaycon = songaydadiduoc - (soPhandiDuoc * mphan); // 1000 - 852*1 = 148 ngay//tính số ngày dư con lai de tinh do
        System.out.println(soPhandiDuoc + " phan");
        System.out.println("so ngay con " + songaycon);
        int sododiduoc = (int) (songaycon / mdo); // 148/28.4 = 5 do
        System.out.println("di duoc " + sododiduoc + " do");
        songaycon = songaycon - (sododiduoc * mdo); // va con du 6 ngay
        System.out.println("so ngay con " + songaycon);
        float sophutdiduoc = songaycon / mphut;// voi 6 ngay con lai thi di duoc may' phut'
        System.out.println("so phut di duoc " + sophutdiduoc);

    }
}
