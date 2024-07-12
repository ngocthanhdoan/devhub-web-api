package com.j4fun.plugins;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.j4fun.eNum.DateEnum;

public class DateUtils {

    public static int getDayOfWeek(LocalDate date) {
        return date.getDayOfWeek().getValue(); // 1: Monday, 2: Tuesday, ..., 7: Sunday
    }
    public static List<LocalDate> getDaysInCurrentMonth() {
        List<LocalDate> daysOfMonth = new ArrayList<>();
        LocalDate       currentDate = LocalDate.now();
        LocalDate   firstDayOfMonth = currentDate.withDayOfMonth(1);
        int month                   = firstDayOfMonth.getMonthValue();
        int year                    = firstDayOfMonth.getYear();
        LocalDate lastDayOfMonth    = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
        for (LocalDate date = firstDayOfMonth; !date.isAfter(lastDayOfMonth); date = date.plusDays(1)) {
            daysOfMonth.add(date);
        }
        return daysOfMonth;
    }
    public static List<LocalDate> getDaysBetween(String startDateStr, String endDateStr) {
        List<LocalDate> daysBetween = new ArrayList<>();
        LocalDate startDate         = LocalDate.parse(startDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate           = LocalDate.parse(endDateStr  , DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            daysBetween.add(date);
        }
        return daysBetween;
    }

    public static void Test2() {
        String startDateStr = "2024-01-01";
        String endDateStr   = "2025-01-01";
        List<Map> listOutPut=new ArrayList<Map>();
        Map map= new HashMap();
        List<LocalDate> daysBetween = getDaysBetween(startDateStr, endDateStr);
        int dateCount=0;
        for (LocalDate date : daysBetween) {
            dateCount++;
            int dayOfWeek=getDayOfWeek(date);
            String alias_vni=DateEnum.getByCode(getDayOfWeek(date)).getVNI();
            String alias_enl=DateEnum.getByCode(getDayOfWeek(date)).getENL();
           
            System.out.println(dateCount+". "+alias_vni+" - "+alias_enl);         
        }
    }

    public static void main(String[] args) {
//        List<LocalDate> daysOfMonth = getDaysInCurrentMonth();
//        
//        for (LocalDate date : daysOfMonth) {
//            System.out.println("Ngày: " + date + ", " + map.get(getDayOfWeek(date)));
//        }
        Test2();
    }
}
