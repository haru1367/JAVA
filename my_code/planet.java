package Programmers;

//외계행성의 데이터를 입력받아 생명체가 거주가능한 행성인지 판단하는 프로그램
import java.util.Scanner;
import java.util.ArrayList;


class Extra_planet{
    String name;
    ArrayList<String> info; //0 : 행성이름 , 1 : 행성 질량 , 2: 행성 이심률 , 3: 행성 장반경 ,4 :자전주기 ,5: 공전주기 , 6: 모항성 광도, 7,:모항성 광구온도
    ArrayList<String>result = new ArrayList<>();
    double long_distance;
    double short_distance;
    Extra_planet(String planet, ArrayList<String>planet_info) {
        this.name = planet;
        this.info = planet_info;
    }
    public void test1() { // 행성 질량 체크 (지구질량의 10배 이상일경우 가스행성일 확률이 높다)
        if (Double.parseDouble(this.info.get(1)) * 317.82838 > 10.0) {
            this.result.add("가스행성일 가능성이 높습니다.");
        }

    }
    public void test2() { //행성의 이심률 테스트 (이심률이 크면 기후변화가 극단적이다)
        if (Double.parseDouble(this.info.get(2)) > 0.25) {
                this.result.add("이심률이 다소 극단적입니다. 기후변화가 클 가능성이 높습니다.");
        } else {
            double dx = Double.parseDouble(this.info.get(2));
            this.long_distance = Double.parseDouble(this.info.get(3)) * 5.204267;
            double short_distance2 = long_distance * long_distance *(1-dx*dx);
            this.short_distance = Math.sqrt(short_distance2);

        }
    }
    public void test3() { // 자전주기, 공전주기 테스트 (자전주기와 공전주기가 비슷하면 조석고정현상이 나타나 부적합한 환경이된다.)
        if (Math.abs(Double.parseDouble(this.info.get(4)) - Double.parseDouble(this.info.get(5))) < 5 ) {
            this.result.add("자전주기와 공전주기가 비슷해 조석고정현상이 나타날 가능성이 높습니다.");
        }
    }
    public void test4() { //모항성의 광도에따른 골디락스존 범위 판단 테스트(행성의 근일점과 원일점이 모두 골디락스존 범위안에 들어가야한다.)
        double goldRocks_zone = Math.sqrt(Double.parseDouble(this.info.get(6)));
        double long_zone = goldRocks_zone * 1.15;
        double short_zone = goldRocks_zone * 0.95;
        if (short_distance > long_zone) {
            this.result.add("행성이 골디락스존 범위보다 바깥쪽에 있어 다소 추울 수 있습니다.");
        } else if (short_distance > short_zone && short_distance < long_zone && long_distance > long_zone) {
            this.result.add("행성의 원일점이 골디락스존 범위보다 바깥쪽에 있어 겨울에 다소 추울 수 있습니다.");
        } else if (short_distance < short_zone && long_distance > long_zone) {
            this.result.add("행성의 근일점이 골디락스존 범위보다 안쪽에 있고 원일점이 범위 바깥에 있어 기후가 다소 극단적일수 있습니다.");
        } else if (short_distance < short_zone && long_distance > short_zone && long_distance < long_zone) {
            this.result.add("행성의 근일점이 골디락스존 범위보다 안쪽에 있어 여름에 다소 더울 수 있습니다.");
        } else if (long_distance < short_zone) {
            this.result.add("행성이 골디락스존 범위보다 안쪽에있어 다소 더울 수 있습니다.");
        }
    }

    public void test5() { // 모항성의 표면 온도 판단( 5300켈빈이상 6100켈빈 이하가 적당하다)
        if (Integer.parseInt(this.info.get(7)) < 5300 || Integer.parseInt(this.info.get(7)) > 6100 ) {
            this.result.add("생명체가 거주하기엔 모항성의 온도가 부적절합니다.");
        }
    }

    public void planet_result() { //판단결과를 출력한다.
        if (this.result.isEmpty()) {
            System.out.println("생명체가 거주하기 적합한 행성입니다.");
        } else {
            for (String s : this.result) {
                System.out.println(s);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String>planet_info = new ArrayList<>();
            System.out.println("1.행성의 이름 : ");
            String planet_name = sc.nextLine();
            System.out.println("2.행성의 질량 : ");
            String planet_mass = sc.nextLine();
            System.out.println("3.행성의 이심률 : ");
            String planet_erate = sc.nextLine();
            System.out.println("4.행성의 공전 장반경 : ");
            String planet_long_rotate = sc.nextLine();
            System.out.println("5.행성 자전 주기 : ");
            String planet_self_rotate = sc.nextLine();
            System.out.println("6.행성 공전 주기 : ");
            String planet_rotate = sc.nextLine();
            System.out.println("7.모항성의 광도 : ");
            String star_light = sc.nextLine();
            System.out.println("8.모항성의 광구 온도 : ");
            String star_temperature = sc.nextLine();
            planet_info.add(planet_name);
            planet_info.add(planet_mass);
            planet_info.add(planet_erate);
            planet_info.add(planet_long_rotate);
            planet_info.add(planet_self_rotate);
            planet_info.add(planet_rotate);
            planet_info.add(star_light);
            planet_info.add(star_temperature);
            Extra_planet planet = new Extra_planet(planet_name,planet_info);
            planet.test1();
            planet.test2();
            planet.test3();
            planet.test4();
            planet.test5();
            planet.planet_result();

    }
}
