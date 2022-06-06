package hcmexp.exp4;

/**
 * @author Yaxin
 * @date 2022/6/5 11:28
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FaceRecognition {

    static int width = 16;

    static int height = 20;

    static int N = 2 * height * width * 2;
    //	隐含层神经元个数
    static int L = height * width;
    //	输出层神经元个数
    static int M = 16;
    //	精度
    static double epsilon = 0.001;
    //	学习率
    static double alpha = 0.33;
    static double a = -1.0;
    //	输入层到隐含层的权值
    static double[][] V = new double[N][L];
    //	隐含层到输出层的权值
    static double[][] W = new double[L][M];
    //	隐含层的阈值
    static double[] fai = new double[L];
    //	输出层的阈值
    static double[] sita = new double[M];

    static double[][] deltaW = new double[L][M];
    static double[] deltaSita = new double[M];

    static double[][] deltaV = new double[N][L];
    static double[] deltaFai = new double[L];
    static double[] FE = new double[M];

    static BufferedImage compressImg(BufferedImage OriginalImg,int width, int height, int type){
        BufferedImage res = new BufferedImage(width, height, type);
        Graphics2D graphics = res.createGraphics();
        graphics.drawImage(OriginalImg, 0, 0, width, height, null);
        graphics.dispose();
        return res;
    }

    static double[] getImagePixel(String image){
        File img = new File(image);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = compressImg(ImageIO.read(img), width * 2, height * 2, BufferedImage.TYPE_BYTE_GRAY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        double[] pixel = new double[N];
        int k = 0;
        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                int rgb = bufferedImage.getRGB(i, j);
                rgb &= 0xff;
                pixel[k++] = rgb/255.0;
            }
        }
        return pixel;
    }

    static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(a * x));
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                V[i][j] = Math.random() * 2.0 - 1.0;
            }
        }
        for (int j = 0; j < L; j++) {
            for (int k = 1; k < M; k++) {
                W[j][k] = Math.random() * 2.0 - 1.0;
            }
        }
        for (int j = 0; j < L; j++) {
            fai[j] = Math.random() * 2.0 - 1.0;
        }
        for (int k = 1; k < M; k++) {
            sita[k] = Math.random() * 2.0 - 1.0;
        }
    }

    static boolean trainBP(double[] X, int[] D) {
        double[] H = new double[L];
        for (int j = 0; j < L; j++) {
            double derta = 0.0;
            for (int i = 0; i < N; i++) {
                derta += X[i] * V[i][j];
            }
            H[j] = sigmoid(derta + fai[j]);
        }

        double[] Y = new double[M];
        for (int k = 1; k < M; k++) {
            double derta = 0.0;
            for (int j = 0; j < L; j++) {
                derta += H[j] * W[j][k];
            }
            Y[k] = sigmoid(derta + sita[k]);
        }

        double[] deltaK = new double[M];
        double E = 0.0;
        for (int k = 1; k < M; k++) {
            E += (D[k] - Y[k]) * (D[k] - Y[k]);
            deltaK[k] = (D[k] - Y[k]) * Y[k] * (1 - Y[k]);
        }
        if (E / 2 < epsilon) return true;

        double[] deltaJ = new double[L];
        for (int j = 0; j < L; j++) {
            double beta = 0.0;
            for (int k = 1; k < M; k++) {
                beta += deltaK[k] * W[j][k];
            }
            deltaJ[j] = H[j] * (1 - H[j]) * beta;
        }

        for (int j = 0; j < L; j++) {
            for (int k = 1; k < M; k++) {
                deltaW[j][k] = alpha * deltaK[k] * H[j];
//				deltaW[j][k] = (arph/(1+L))*(deltaW[j][k]+1)*deltaK[k]*H[j];
                W[j][k] += deltaW[j][k];
            }
        }
        for (int k = 1; k < M; k++) {
            deltaSita[k] = alpha * deltaK[k];
//			deltaSita[k] = (arph/(1+L))*(detaSitla[k]+1)*deltaK[k];
            sita[k] += deltaSita[k];
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < L; j++) {
                deltaV[i][j] = alpha * deltaJ[j] * X[i];
//				deltaV[i][j] = (arph/(1+N))*(deltaV[i][j]+1)*deltaJ[j]*X[i];
                V[i][j] += deltaV[i][j];
            }
        }
        for (int j = 0; j < L; j++) {
            deltaFai[j] = alpha * deltaJ[j];
//			deltaFai[j] = (arph/(1+N))*(deltaFai[j]+1)*deltaJ[j];
            fai[j] += deltaFai[j];
        }

        return false;
    }

    static int BP(double[] X) {
        int ans = 0;
        double[] H = new double[L];
        for (int j = 0; j < L; j++) {
            double derta = 0.0;
            for (int i = 0; i < N; i++) {
                derta += X[i] * V[i][j];
            }
            H[j] = sigmoid(derta - fai[j]);
        }
        double[] Y = new double[M];
        for (int k = 1; k < M; k++) {
            double derta = 0.0;
            for (int j = 0; j < L; j++) {
                derta += H[j] * W[j][k];
            }
            Y[k] = sigmoid(derta - sita[k]);
        }

        double min = Double.MAX_VALUE;

        for (int n = 1; n < M; n++) {
            double E = 0.0;
            int[] D = new int[M];
            D[n] = 1;
            for (int k = 1; k < M; k++) {
                E += Math.abs((D[k] - Y[k]) * (D[k] - Y[k]));
            }
            FE[n] = 1.0 / Math.exp(E / 2.0);
            if (E / 2 < min) {
                min = E / 2;
                ans = n;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        init();
        int tmp = 1;
        //训练：
        while (tmp < 10000) {
            System.out.println("training times:" + tmp);
            //每人的前5份照片做训练集
            int i = 1, j = 1;
            while (i <= 15) {
                while (j <= 5) {
                    String person = i < 10 ? "0" + i : "" + i;
                    String imagePath;
                    imagePath = "C:\\JavaProjects\\learnhub\\src\\hcmexp\\exp4\\YALE\\" + "subject" + person + "_" + j + ".bmp";
                    double[] X = getImagePixel(imagePath);
                    int[] D = new int[M];
                    D[i] = 1;
                    boolean flag = trainBP(X, D);
                    if (flag) break;
                    j++;
                }
                i++;
            }
            tmp++;
        }
        System.out.println("training over!");
        //测试
        //每人的后6张照片做测试
        System.out.println("跑测试中...");
        double rightTimes = 0, total = 0;
        for (int i = 1; i < 16; i++) {
            for (int j = 6; j <= 11; j++) {
                String imagePath;
                String person = i < 10 ? "0" + i : "" + i;
                imagePath = "C:\\JavaProjects\\learnhub\\src\\hcmexp\\exp4\\YALE\\" + "subject" + person + "_" + j + ".bmp";
                double[] X = getImagePixel(imagePath);
                int ans = BP(X);
                System.out.println("预测答案：" + ans + " "+ "正确答案：" + i);
                if(ans == i){
                    rightTimes++;
                }
                total++;
            }
        }
        System.out.println("本次测试正确率：" + rightTimes / total);
    }
}

