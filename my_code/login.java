package Programmers;
// 로그인,회원가입 프로그램

import java.util.Scanner;
import java.util.HashMap;

class Login {
    HashMap<String,String>info = new HashMap<>();
    private boolean log_Check = false;
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public void system(int select) {
        switch (select) {
            case 1:
                System.out.println();
                String newID;
                while (true) {
                    System.out.println("아이디 입력 : ");
                    newID = this.input();
                    if (newID.length() >= 6 && newID.length() <= 14) {
                        break;
                    } else {
                        System.out.println("**아이디를 6~ 14자 사이로 만들어주세요!");
                    }
                }
                String newPW;
                while (true) {
                    System.out.println("비밀번호 입력 : ");
                    newPW = this.input();
                    if (newPW.length() >= 8 && newPW.length() <= 16) {
                        break;
                    } else {
                        System.out.println("**비밀번호를 8~16자 사이로 만들어주세요!");
                    }
                }
                if (this.info.containsKey(newID)) {
                    System.out.println("이미 존재하는 아이디입니다.");
                }else {
                    this.info.put(newID, newPW);
                    System.out.println("회원가입 완료");
                }
                break;
            case 2:
                System.out.println();
                if (this.log_Check) {
                    System.out.println("이미 로그인 되어있습니다. 로그아웃을 먼저 진행해주세요!");
                } else {

                    System.out.println("*아이디를 입력해주세요 : ");
                    String ID = this.input();
                    System.out.println("*비밀번호를 입력해주세요 : ");
                    String PW = this.input();
                    if (!this.info.containsKey(ID)) {
                        System.out.println("등록되지 않은 아이디입니다 !");
                    } else {
                        if (!this.info.get(ID).equals(PW)) {
                            System.out.println("비밀번호가 틀렸습니다 !");
                        } else {
                            this.log_Check = true;
                            System.out.println("로그인 되었습니다 !");
                        }
                    }
                }
                break;
            case 3:
                if (!this.log_Check) {
                    System.out.println("로그인을 먼저 진행해주세요!");
                } else {
                    this.log_Check = false;
                    System.out.println("로그아웃 되었습니다!");
                }
                break;
            case 4:
                if (this.log_Check) {
                    System.out.println("로그아웃을 먼저 진행해주세요!");
                } else {
                    System.out.println("가입하신 아이디를 입력해주세요 : ");
                    String ID = this.input();
                    if (!this.info.containsKey(ID)) {
                        System.out.println("등록되지 않은 ID 입니다.");
                    } else {
                        String PW = this.info.get(ID);
                        System.out.print("비밀번호는 앞 3자리까지만 보여집니다. : ");
                        for (int i = 0; i <= 2; i++) {
                            System.out.print(PW.charAt(i));
                        }
                        for (int i = 1; i <= PW.length() - 3; i++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                }
                break;
            default:
                System.out.println("숫자를 다시 입력해주세요!");

        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();
        System.out.println("-----------------------------------------------");
        while (true) {
            System.out.println("1.회원가입");
            System.out.println("2.로그인");
            System.out.println("3.로그아웃");
            System.out.println("4.비밀번호 찾기");
            System.out.println("5.종료");
            System.out.println("실행할 항목의 번호를 입력해주세요 : ");
            int select = sc.nextInt();
            if (select == 5) {
                break;
            } else {
                login.system(select);
            }
            System.out.println("--------------------------------------------------");

        }
        sc.close();
    }
}

