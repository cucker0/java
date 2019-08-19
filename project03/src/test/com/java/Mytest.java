/*
* JUnit test
*
* */

package test.com.java;

import com.java.domain.*;
import com.java.service.EquipmentRepository;
import com.java.service.EquipmentStatus;
import com.java.service.Team;
import com.java.service.TeamException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Mytest {
    @Test
    public void test1() {
        // test EquipmentStatus class

        EquipmentStatus[] es = EquipmentStatus.values();
        for (EquipmentStatus e : es) {
            System.out.println(e);
        }

    }

    @Test
    public void test2() {
        // test PC class
        PC pc1 = new PC("dell 7400", "dell e 2900");
        PC pc2 = new PC("dell 7400", "dell e 2900");
        NoteBook nb1 = new NoteBook("HUAWEI MateBook X Pro 2019(深空灰)", 8999.00);
        NoteBook nb12 = new NoteBook("HUAWEI MateBook 13(魅海蓝)", 3999.00);
        Printer prt1 = new Printer("爱普生（EPSON）L4168墨仓式品质款 彩色无线多功能一体机", "EPSON");
        Printer prt2 = new Printer("惠普 （HP） 136w 锐系列新品激光多功能一体机", "HP");
        System.out.println(pc1);

        EquipmentRepository repository = new EquipmentRepository();
        repository.addEquipment(pc1);
        repository.addEquipment(pc2);
        repository.addEquipment(nb1);
        repository.addEquipment(nb12);
        repository.addEquipment(prt1);
        repository.addEquipment(prt2);
    }

    @Test
    public void test3() {
        // test Team
        LinkedHashMap<Class, HashMap> membersStructor = new LinkedHashMap<>();
        HashMap post1 = new HashMap(); // 岗位要求
        post1.put("max", 3);
        post1.put("total", 0);
        HashMap post2 = new HashMap();
        post2.put("max", 2);
        post2.put("total", 0);
        HashMap post3 = new HashMap();
        post3.put("max", 1);
        post3.put("total", 0);
        membersStructor.put(Programmer.class, post1);
        membersStructor.put(Designer.class, post2);
        membersStructor.put(Architect.class, post3);
        Team t1 = new Team("DevelopmentTeam", membersStructor);

        Programmer p1 = new Programmer("章亦春", 28, 60000);
        Designer d1 = new Designer("雷响", 22, 50000);
        Architect a1 = new Architect("马云", 50, 200000);
        Architect a2 = new Architect("李彦宏", 46, 200000);
//        try {
//            t1.addMember(p1);
//            t1.addMember(d1);
//            t1.addMember(a1);
//            t1.addMember(a2);
//            System.out.println("00===00  "); // 如果前面的语句发生了异常，此语句不执行
//            t1.addMember(a1);
//        } catch (TeamException e) {
//            System.out.println(e.getMessage());
//        }
        try {
            t1.addMember(p1);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        try {
            t1.addMember(d1);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        try {
            t1.addMember(a1);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        try {
            t1.addMember(a2);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
        try {
            t1.addMember(a1);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(t1);

        test2();

        ArrayList<Equipment> repository = EquipmentRepository.getRepository();
        Equipment e = repository.get(2);
//        System.out.println("33===  " + e);
        p1.receiveEquipment(e);
        d1.receiveEquipment(e);
        System.out.println(repository);

    }


}
