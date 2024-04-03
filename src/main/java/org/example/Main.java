package org.example;

import org.example.classes.Account;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Account[] accounts = new Account[100];
    static int index = 0;

    public static void main(String[] args) {

        boolean isExit = false;


        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("==== 신한 은행 ====");
            System.out.println("1. 계좌개설 ");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 계좌 잔액 조회");
            System.out.println("5. 종료");
            System.out.println("항목을 입력하세요. ");

            int menu = Integer.parseInt(scanner.nextLine());
            switch (menu) {
                case 1:  //계좌개설
                    createAccount();
                    break;
                case 2:  //입금
                    credit();
                    break;
                case 3:  //출금
                    devit();
                    break;
                case 4:  //계좌 잔액 조회
                    retrieveAccount();
                    break;
                case 5:  //종료
                    isExit = true;
                    break;
            }
        } while (!isExit);
    }

    private static void devit() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("조회하려는 계좌 번호를 입력하세요. ");
        String accountNum = scanner.next();

        Account account = findAccountByAccountNumber(accountNum);

        if (account == null) {
            System.out.println("계좌번호가 존재하지 않습니다.");
            return;

        }
        System.out.println("출금하려는 계좌의 비밀번호를 입력하세요.");
        String pwd = scanner.next();

        if (account.getPwd().equals(pwd)) {
            System.out.println("출금하려는 금액을 입력하세요.");
            int amount = Integer.parseInt(scanner.next());

            account.withdraw(amount);


        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }


    }

    private static void credit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("입금하려는 계좌 번호를 입력하세요. ");
        String accountNum = scanner.next();

        Account account = findAccountByAccountNumber(accountNum);

        if (account == null) {
            System.out.println("계좌번호가 존재하지 않습니다.");
            return;
        }

        System.out.println("입금하려는 금액을 입력하세요.");
        int amount = Integer.parseInt(scanner.next());
        //int amount = Integer.parseInt(scanner.nextLine());

        account.deposit(amount);
        System.out.println("입금이 완료되었습니다.");


        /*for(int i =0; i<index;i++){
            if(tmpAccountNum == accounts[i].getAccountNumber()){
                System.out.println("입금하려는 금액을 입력하세요.");
                int money = scanner.nextInt();
                if (money <0){
                    System.out.println("0원 이하를 입금 할 수 없습니다.");
                    break;
                }
                int tmpMoney = accounts[i].getBalance();
                accounts[i].setBalance(money+tmpMoney);
            }
            else {
                System.out.println("입금하려는 계좌가 존재하지 않습니다.");
            }
        }*/

    }

    private static void retrieveAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("조회하려는 계좌 번호를 입력하세요. ");
        String accountNum = scanner.next();

        Account account = findAccountByAccountNumber(accountNum);

        if (account == null) {
            System.out.println("계좌번호가 존재하지 않습니다.");
            return;

        }
        System.out.println("조회하려는 계좌의 비밀번호를 입력하세요.");
        String pwd = scanner.next();

        if (account.getPwd().equals(pwd)) {
            account.printAccounts();

        } else {
            System.out.println("비밀번호가 올바르지 않습니다.");
        }

      /*  for(int i =0; i<index;i++){
            if(tmpAccountNum == accounts[i].getAccountNumber()){
                System.out.println("조회하려는 계좌번호의 비밀번호를 입력하세요.");
                String tmpPwd = scanner.next();
                if(tmpPwd == accounts[i].getPwd()){
                    accounts[i].printAccounts();
                }
                else {
                    System.out.println("비밀번호가 맞지 않습니다.");
                }
            }
            else {
                System.out.println("조회하려는 계좌가 존재하지 않습니다.");
            }
        }
*/
    }

    private static Account findAccountByAccountNumber(String accountNumber) {
        for (int i = 0; i < index; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }


        }
        return null;
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름 : ");
        String name = scanner.nextLine();

        System.out.println("비밀번호 : ");
        String pwd = scanner.nextLine();

        String accountNumber = generateTwelveDigitRandomNumber();

        int balance = 0;

        Account account = new Account(accountNumber, name, pwd, balance);
        accounts[index++] = account;

        account.printAccounts();


    }

    //신한은행 계좌번호는 12자리.
    public static String generateTwelveDigitRandomNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(12);

        for (int i = 0; i < 12; i++) {
            // 난수 생성 및 문자열에 추가
            sb.append(random.nextInt(10)); // 0부터 9 사이의 난수 생성
        }

        return sb.toString();
    }
}
