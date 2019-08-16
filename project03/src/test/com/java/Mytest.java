/*
* JUnit test
*
* */

package test.com.java;

import com.java.domain.PC;
import com.java.service.EquipmentStatus;
import com.java.service.Team;
import org.junit.Test;

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
        System.out.println(pc1);
    }

    @Test
    public void test3() {
        // test Team
        LinkedHashMap<String, Integer> membersStructor = new LinkedHashMap<>();
        membersStructor.put("Programmer", 3);
        membersStructor.put("Designer", 2);
        membersStructor.put("Architect", 1);
        Team t1 = new Team("DevelopmentTeam", membersStructor);

        System.out.println(t1);
    }

}
