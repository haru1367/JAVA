package Programmers;
//Tv리모컨 프로그램
import java.util.Scanner;

class Tv {
    public static int status_chennel = 1;
    public static int status_volume = 10;
    public static boolean volume0 = false;
    public void status_print() {
        System.out.println(String.format("현재 채널은 %d번 입니다.",this.status_chennel));
        System.out.println(String.format("현재 음량은 %d 입니다.",this.status_volume));
        if (this.volume0) {
            System.out.println("현재 음소거 상태입니다.");
        }

    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tv tv = new Tv();
        boolean power = false;
        while (true) {
            System.out.println("TV를 켜시겠습니까?");
            System.out.println("(1)네  (2)아니오");
            int T = sc.nextInt();
            if (T == 1) {
                power = true;
                tv.status_print();
                break;
            } else if (T == 2) {
                power = false;
                break;
            } else {
                System.out.println("다시 입력해주세요!");
            }
        }
        System.out.println();

        while (power) {
            System.out.println();
            System.out.println("0.채널이동");
            System.out.println("1.다음채널");
            System.out.println("2.이전채널");
            System.out.println("3.음량+");
            System.out.println("4.음량-");
            System.out.println("5.음소거");
            System.out.println("6.Tv 종료");
            System.out.println();
            System.out.println("*실행할 버튼을 눌러주세요 : ");
            int button = sc.nextInt();
            if (button == 6) { // 전원 off
                System.out.println("전원이 꺼졌습니다.");
                break;
            }
            switch (button) {
                case 0 : // 원하는 채널로 이동
                    System.out.println("원하시는 채널을 입력해주세요(1~1000번) : ");
                    int want = sc.nextInt();
                    if (want > 1000 || want <1) {
                        System.out.println("범위를 벗어났습니다!");
                        break;
                    } else {
                        tv.status_chennel = want;
                        tv.status_print();
                    }
                    break;

                case 1 : // 채널 조정+
                    tv.status_chennel++;
                    if (tv.status_chennel == 1000) {
                        tv.status_chennel = 1;
                    }
                    tv.status_print();
                    break;
                case 2: // 채널 조정-
                    tv.status_chennel--;
                    if (tv.status_chennel == 0) {
                        tv.status_chennel = 999;
                    }
                    tv.status_print();
                    break;
                case 3: // 음량 조절 +
                    tv.status_volume++;
                    if (tv.status_volume == 31) {
                        System.out.println("현재 음량이 최대입니다!");
                        tv.status_volume = 30;
                    }
                    tv.status_print();
                    break;
                case 4: // 음량 조절-;
                    tv.status_volume--;
                    if (tv.status_volume == -1) {
                        System.out.println("현재 음량이 최소입니다!");
                        tv.status_volume = 0;
                    }
                    tv.status_print();
                    break;
                case 5: // 음소거
                    if (tv.volume0 == true) {
                        tv.volume0 = false;
                    } else {
                        tv.volume0 = true;
                    }
                    tv.status_print();
                    break;
                default:
                    System.out.println("다시 선택해주세요!");
                    break;
            }
        }
    }
}
