package com.dragon;

public class Main {
    public static void main(String[] args) {
        String qjsjq = "2024-12-09 08:00";
        String qjsjz = "2024-12-10 23:59";
        String startDate = qjsjq.substring(0, qjsjq.indexOf(" "));
        String startTime = qjsjq.substring(qjsjq.indexOf(" ")+1,qjsjq.length());

        String endDate = qjsjz.substring(0, qjsjz.indexOf(" "));
        String endTime = qjsjz.substring(qjsjz.indexOf(" ")+1,qjsjz.length());
    }
}
