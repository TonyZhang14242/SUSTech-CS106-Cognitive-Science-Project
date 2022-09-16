import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Stroop{
    static JFrame main=Main.main;
    static JPanel panel=new JPanel();
    static JLabel pane=new JLabel();
    static Font f = new Font("宋体", Font.PLAIN, 100);
    static JButton button1=new JButton("红色");
    static JButton button2=new JButton("蓝色");
    static JButton button3=new JButton("绿色");
    static JButton button4=new JButton("黑色");
    /*static JButton button5=new JButton("Pink");
    static JButton button6=new JButton("Orange");*/
    static String[] test1_1 ={"红色","蓝色","黑色","绿色","蓝色"};
    static Color[] color1_1 = {Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};
    static String[] answer1_1 = {"红色","蓝色","黑色","绿色","蓝色"};
    static String[] test1_2 ={"红色","黑色","红色","绿色","蓝色"};
    static Color[] color1_2 = {Color.BLACK,Color.BLUE,Color.GREEN,Color.RED,Color.RED};
    static String[] answer1_2 = {"红色","黑色","红色","绿色","蓝色"};
    static String[] test1_3 ={"蓝色","蓝色","红色","红色","黑色"};
    static Color[] color1_3 = {Color.BLUE,Color.BLUE,Color.RED,Color.RED,Color.BLACK};
    static String[] answer1_3 = {"蓝色","蓝色","红色","红色","黑色"};
    static String[] test2_1 ={"Green","Blue","Red","Black","Green"};
    static Color[] color2_1 = {Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};
    static String[] answer2_1 = {"绿色","蓝色","红色","黑色","绿色"};
    static String[] test2_2 ={"Black","Green","Red","Blue","Red"};
    static Color[] color2_2 = {Color.RED,Color.BLUE,Color.GREEN,Color.GREEN,Color.BLACK};
    static String[] answer2_2 = {"黑色","绿色","红色","蓝色","红色"};
    static String[] test2_3 ={"Red","Blue","Green","Blue","Black"};
    static Color[] color2_3 = {Color.RED,Color.BLUE,Color.GREEN,Color.BLUE,Color.BLACK};
    static String[] answer2_3 = {"红色","蓝色","绿色","蓝色","黑色"};
    static String[] test3_1 ={"hóng sè","hēi sè","lán sè","lǜ sè","hēi sè"};
    static Color[] color3_1 = {Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK,Color.BLACK};
    static String[] answer3_1 = {"红色","黑色","蓝色","绿色","黑色"};
    static String[] test3_2 ={"hēi sè","lán sè","hóng sè","lǜ sè","hóng sè"};
    static Color[] color3_2 = {Color.RED,Color.BLACK,Color.BLUE,Color.RED,Color.GREEN};
    static String[] answer3_2 = {"黑色","蓝色","红色","绿色","红色"};
    static String[] test3_3 ={"lán sè","hēi sè","lán sè","hóng sè","lǜ sè"};
    static Color[] color3_3 = {Color.BLUE,Color.BLACK,Color.BLUE,Color.RED,Color.GREEN};
    static String[] answer3_3 = {"蓝色","黑色","蓝色","红色","绿色"};
    static String[][] ALLtest = {test1_1,test1_2,test1_3,test2_1,test2_2,test2_3,test3_1,test3_2,test3_3,test3_3};
    static Color[][] ALLcolor = {color1_1,color1_2,color1_3,color2_1,color2_2,color2_3,color3_1,color3_2,color3_3,color3_3};
    static String[][] ALLanswer = {answer1_1,answer1_2,answer1_3,answer2_1,answer2_2,answer2_3,answer3_1,answer3_2,answer3_3,answer1_1};
    static String[] text;//add text
    static Color[] colors;//add color
    static int cnt = -1;
    static int correct=0;
    static double time=System.currentTimeMillis();
    static BufferedWriter writer;

    static {
        try {
            String root = System.getProperty("user.dir");
            String FileName = "data.txt";
            String FilePath = root + File.separator+"src" + File.separator +FileName;
            writer = new BufferedWriter(new FileWriter(FilePath,true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test(int n) throws Exception{
        main.setVisible(false);
        main=new Main();
        main.setVisible(true);

        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        main.setSize((int)width,(int)height);//设置大小
        main.setLocation(0,0); //设置窗体居中显示
        main.setTitle("Stroop");
        main.setLayout(null);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridLayout(2,1));
        panel.setLayout(new GridLayout(3,2));
        JPanel panel2=new JPanel();
        button1.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setText(test1_1[n]);
                pane.setFont(new Font("宋体", Font.PLAIN, 250));
                pane.setForeground(color1_1[n]);
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                //System.out.println(System.currentTimeMillis()-time);
                time = System.currentTimeMillis();
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                String[] answer = ALLanswer[cnt];
                if (answer[n].equals("红色")) {
                    correct++;
                    try {
                        writer.write(cost + ",correct");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        writer.write(cost + ",false");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                cnt++;
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                if (cnt< 9){
                pane.setText(text[n]);
                pane.setFont(new Font("宋体", Font.PLAIN, 250));
                pane.setForeground(colors[n]);}
                if (cnt == 9) {
                    try {
                        writer.write("base test finished");
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    main.setVisible(false);
                    System.out.println((double) correct / 9);
                    try {
                        picTest.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button2.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setText(test1_1[n]);
                pane.setFont(new Font("宋体", Font.PLAIN, 250));
                pane.setForeground(color1_1[n]);
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                String[] answer = ALLanswer[cnt];
                if (answer[n].equals("蓝色")) {
                    correct++;
                    try {
                        writer.write(cost + ",correct");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        writer.write(cost + ",false");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                cnt++;
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                if (cnt< 9){
                    pane.setText(text[n]);
                    pane.setFont(new Font("宋体", Font.PLAIN, 250));
                    pane.setForeground(colors[n]);}
                if (cnt == 9) {
                    try {
                        writer.write("base test finished");
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    main.setVisible(false);
                    System.out.println((double) correct / text.length);
                    try {
                        picTest.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button3.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setText(test1_1[n]);
                pane.setFont(new Font("宋体", Font.PLAIN, 250));
                pane.setForeground(color1_1[n]);
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                String[] answer = ALLanswer[cnt];
                if (answer[n].equals("绿色")) {
                    correct++;
                    try {
                        writer.write(cost + ",correct");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        writer.write(cost + ",false");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                cnt++;
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                if (cnt< 9){
                    pane.setText(text[n]);
                    pane.setFont(new Font("宋体", Font.PLAIN, 250));
                    pane.setForeground(colors[n]);}
                if (cnt == 9) {
                    try {
                        writer.write("base test finished");
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    main.setVisible(false);
                    System.out.println((double) correct / 9);
                    try {
                        picTest.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button4.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setText(test1_1[n]);
                pane.setFont(new Font("宋体", Font.PLAIN, 250));
                pane.setForeground(color1_1[n]);
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();

                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                String[] answer = ALLanswer[cnt];
                if (answer[n].equals("黑色")) {
                    correct++;
                    try {
                        writer.write(cost + ",correct");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        writer.write(cost + ",false");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                cnt++;
                colors = ALLcolor[cnt];
                text = ALLtest[cnt];
                if (cnt< 9){
                    pane.setText(text[n]);
                    pane.setFont(new Font("宋体", Font.PLAIN, 250));
                    pane.setForeground(colors[n]);}
                if (cnt == 9) {
                    try {
                        writer.write("base test finished");
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    main.setVisible(false);
                    System.out.println((double) correct / 9);
                    try {
                        picTest.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        /*button5.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setText(text[cnt]);
                pane.setFont(new Font("Times new Roman", Font.PLAIN, 250));
                pane.setForeground(colors[cnt]);
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();

                if (colors[cnt] == Color.PINK) {
                    correct++;
                    try {
                        writer.write(cost + ",correct");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        writer.write(cost + ",false");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                cnt++;
                if (cnt< (text).length){
                    pane.setText(text[cnt]);
                    pane.setFont(new Font("Times new Roman", Font.PLAIN, 250));
                    pane.setForeground(colors[cnt]);}
                if (cnt == text.length) {
                    try {
                        writer.write("---");
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    main.setVisible(false);
                    System.out.println((double) correct / text.length);
                    System.exit(0);
                }
            }
        });
        button6.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setText(text[cnt]);
                pane.setFont(new Font("Times new Roman", Font.PLAIN, 250));
                pane.setForeground(colors[cnt]);
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();

                if (colors[cnt] == Color.ORANGE) {
                    correct++;
                    try {
                        writer.write(cost + ",correct");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        writer.write(cost + ",false");
                        writer.newLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                cnt++;
                if (cnt< (text).length){
                    pane.setText(text[cnt]);
                    pane.setFont(new Font("Times new Roman", Font.PLAIN, 250));
                    pane.setForeground(colors[cnt]);}
                if (cnt == text.length) {
                    try {
                        writer.write("---");
                        writer.newLine();
                        writer.flush();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    main.setVisible(false);
                    System.out.println((double) correct / text.length);
                    System.exit(0);
                }
            }
        });*/
        pane.setText("按下任意键开始，请选出文字描述的颜色");
        pane.setFont(new Font("宋体", Font.PLAIN, 50));
        panel2.add(pane);
        button1.setFont(f);
        button2.setFont(f);
        button3.setFont(f);
        button4.setFont(f);
        /* button5.setFont(f);
        button6.setFont(f);*/
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        /*panel.add(button5);
        panel.add(button6);*/
       main.add(panel2);
       main.add(panel);
    }
}
