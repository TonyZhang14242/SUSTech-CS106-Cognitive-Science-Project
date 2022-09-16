import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class picTest {
    static JFrame main=Main.main;
    static JPanel panel=new JPanel();
    static JLabel pane=new JLabel();
    static Font f = new Font("Times new Roman", Font.PLAIN, 150);
    static JButton button1=new JButton("A");
    static JButton button2=new JButton("B");
    static JButton button3=new JButton("C");
    static JButton button4=new JButton("D");
    static String[] picname1 ={"pic1_1.png","pic1_2.png","pic1_3.png","pic1_4.png","pic1_5.png"};
    static String[] answer1  ={"B","D","C","A","B"};
    static String[] picname2 ={"pic2_1.png","pic2_2.png","pic2_3.png","pic2_4.png","pic2_5.png"};
    static String[] answer2 = {"D","B","C","C","D"};
    static String[] picname3 ={"pic3_1.png","pic3_2.png","pic3_3.png","pic3_4.png","pic3_5.png"};
    static String[] answer3 = {"C","D","C","D","A"};
    static String[][] ALLpic = {picname1,picname2,picname3,picname3};
    static String[][] ALLanswer ={answer1,answer2,answer3,answer3};

    static String[] picName;
    static String[] answer;
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
    public static void test(int n) throws Exception {
        main.setVisible(false);
        main = new Main();
        main.setVisible(true);

        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        main.setSize((int) width, (int) height);//设置大小
        main.setLocation(0, 0); //设置窗体居中显示
        main.setTitle("picTest");
        main.setLayout(null);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridLayout(2, 1));
        panel.setLayout(new GridLayout(3, 2));
        JPanel panel2 = new JPanel();
        button1.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setIcon(new ImageIcon("src//picture//"+picname1[n]));
                pane.setText("");
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                //System.out.println(System.currentTimeMillis()-time);
                time = System.currentTimeMillis();
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];

                if (answer[n].equals( "A")) {
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
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (cnt< 3) {
                    pane.setIcon(new ImageIcon("src//picture//" + picName[n]));
                }
                if (cnt == 3) {
                    try {
                        writer.write("picture test finish");
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
                    System.out.println((double) correct / picName.length);
                    try {
                        calculate.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button2.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setIcon(new ImageIcon("src//picture//"+picname1[n]));
                pane.setText("");
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                //System.out.println(System.currentTimeMillis()-time);
                time = System.currentTimeMillis();
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (answer[n].equals("B")) {
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
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (cnt< 3) {
                    pane.setIcon(new ImageIcon("src//picture//" + picName[n]));
                }
                if (cnt == 3) {
                    try {
                        writer.write("picture test finish");
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
                    System.out.println((double) correct / picName.length);
                    try {
                        calculate.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button3.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setIcon(new ImageIcon("src//picture//"+picname1[n]));
                pane.setText("");
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                //System.out.println(System.currentTimeMillis()-time);
                time = System.currentTimeMillis();
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (answer[n].equals( "C")) {
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
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (cnt< 3) {
                    pane.setIcon(new ImageIcon("src//picture//" + picName[n]));
                }
                if (cnt == 3) {
                    try {
                        writer.write("picture test finish");
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
                    System.out.println((double) correct / picName.length);
                    try {
                        calculate.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        button4.addActionListener(e -> {
            if (cnt==-1){
                cnt++;
                pane.setIcon(new ImageIcon("src//picture//"+picname1[n]));
                pane.setText("");
                time = System.currentTimeMillis();
            }
            else {
                double cost = System.currentTimeMillis() - time;
                //System.out.println(System.currentTimeMillis()-time);
                time = System.currentTimeMillis();
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (answer[n].equals( "D")) {
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
                picName = ALLpic[cnt];
                answer =ALLanswer[cnt];
                if (cnt< 3) {
                    pane.setIcon(new ImageIcon("src//picture//" + picName[n]));
                }
                if (cnt == 3) {
                    try {
                        writer.write("picture test finish");
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
                    System.out.println((double) correct / picName.length);
                    try {
                        calculate.test(n);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        pane.setText("按下任意键开始，请选出图中的动物");
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
