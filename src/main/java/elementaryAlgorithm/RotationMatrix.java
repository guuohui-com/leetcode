package elementaryAlgorithm;


import java.util.Scanner;

/**
 * @功能职责: 旋转矩阵
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class RotationMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] pam = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                pam[i][j] = scanner.nextInt();
            }
        }
        int t = scanner.nextInt();
        t = t%4;
        int tem = 0;
        if (t == 1){
            //x,y 交换，
            for (int i = 1; i <= (n+1)/2; i++) {
                for (int j = i; j < (n+1); j++) {
                    tem = pam[i][j];
                    pam[i][j] = pam[j][i];
                    pam[j][i] = tem;
                }
            }
            //左右翻着
            for (int i = 1; i < (n+1); i++) {
                for (int j = 1; j <= (n+1)/2; j++) {
                    tem = pam[i][j];
                    pam[i][j] = pam[i][n+1-j];
                    pam[i][n+1-j] = tem;
                }
            }
        }

        if (t == 2){
            for (int i = 1; i <= (n+1)/2; i++) {
                for (int j = 1; j < (n+1); j++) {
                    //上线翻折 ，左右翻着
                    tem = pam[i][j];
                    pam[i][j] = pam[n+1-i][n+1-j];
                    pam[n+1-i][n+1-j] = tem;
                }
            }
        }

        if (t == 3){
            //x,y 交换，
            for (int i = 1; i <= (n+1)/2; i++) {
                for (int j = i; j < (n+1); j++) {
                    tem = pam[i][j];
                    pam[i][j] = pam[j][i];
                    pam[j][i] = tem;
                }
            }
            //上下翻着
            for (int i = 1; i <= (n+1)/2; i++) {
                for (int j = 1; j < (n+1); j++) {
                    tem = pam[i][j];
                    pam[i][j] = pam[n+1-i][j];
                    pam[n+1-i][j] = tem;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (j != n){
                    System.out.print(pam[i][j] + " ");
                }else {
                    System.out.print(pam[i][j]);
                }
            }
            System.out.print("\n");
        }
    }
}
