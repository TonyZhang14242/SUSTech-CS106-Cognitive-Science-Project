import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class calculate {
    static JFrame main = Main.main;
    static JPanel panel = new JPanel();
    static JLabel pane = new JLabel();
    static JButton button=new JButton("Confirm");
    static int input;static double cost;
    static int cnt=0;
    static boolean validity;
    static Font f = new Font("Times new Roman", Font.PLAIN, 50);
    static JTextField field = new JTextField(150);
    static String[][] test = {{"14*8-2*4", "22*6+3*2", "3*74+5*3", "54*7+3*4", "18*7-2*3"},
            {"52*8-5*3 (tips: 401)", "86*3+4*3  (tips:270)", "4*64-4*2  (tips:248)", "8*13+4*3  (tips:116)", "5*22-6*9  (tips:56)"},
            {"67*3+2*8  (tips:185)", "5*24-6*8  (tips:82)", "61*2-7*7  (tips:83)", "23*7+4*4  (tips:167)", "19*6+3*2  (tips:108)"}};
    static int[][] answer = {{104, 138, 237, 390, 120}, {401, 270, 248, 116, 56}, {217, 72, 73, 177, 120}};
    static double time = System.currentTimeMillis();
    static BufferedWriter writer;

    static {
        try {
            String root = System.getProperty("user.dir");
            String FileName = "data.txt";
            String FilePath = root + File.separator + "src" + File.separator + FileName;
            writer = new BufferedWriter(new FileWriter(FilePath, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static {
        main.setVisible(false);
        main = new Main();
        main.setVisible(true);
        double width = Toolkit.getDefaultToolkit().getScreenSize().width; //得到当前屏幕分辨率的高
        double height = Toolkit.getDefaultToolkit().getScreenSize().height;//得到当前屏幕分辨率的宽
        main.setSize((int) width/2, (int) height/2);//设置大小
        field.setFont(f);
        main.setLocation((int) width/4, (int) height/4); //设置窗体居中显示
        main.setTitle("calTest");
        main.setLayout(null);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setLayout(new GridLayout(2, 1));
        panel.setLayout(new GridLayout(3, 2));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,1));
        button.setSize(200,100);

        pane.setFont(new Font("宋体", Font.PLAIN, 40));
        panel2.add(field);
        panel2.add(pane);
        panel2.add(button);
        main.add(panel2);
    }

    public static void test(int n) throws Exception {
        boolean turn= new Random().nextBoolean();

        pane.setText(test[0][n]);
        time = System.currentTimeMillis();

        button.addActionListener(e -> {
            try {
                validity=true;
                Integer.parseInt(field.getText());
            }
            catch (Exception e1){
                validity=false;
            }

            if (!field.getText().equals("")&&validity) {

                input = Integer.parseInt(field.getText());
                field.setText("");
                cost = System.currentTimeMillis() - time;
                time = System.currentTimeMillis();
                cnt++;
                if (cnt == 1) {
                    if (input == answer[0][n]) {
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
                    if (turn)
                        pane.setText(test[1][n]);
                    else pane.setText(test[2][n]);
                } else if (cnt == 2) {
                    if (turn) {
                        if (input == answer[1][n]) {
                            try {
                                writer.write(cost + ",correct,correct tips");
                                writer.newLine();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            try {
                                writer.write(cost + ",false,correct tips");
                                writer.newLine();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        pane.setText(test[2][n]);
                    } else {
                        if (input == answer[2][n]) {
                            try {
                                writer.write(cost + ",correct,incorrect tips");
                                writer.newLine();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            try {
                                writer.write(cost + ",false,incorrect tips");
                                writer.newLine();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                        pane.setText(test[1][n]);
                    }
                } else {
                    if (turn) {
                        if (input == answer[2][n]) {
                            try {
                                writer.write(cost + ",correct,incorrect tips");
                                writer.newLine();
                                writer.flush();


                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            try {
                                writer.write(cost + ",false,incorrect tips");
                                writer.newLine();
                                writer.flush();


                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    else {
                        if (input == answer[1][n]) {
                            try {
                                writer.write(cost + ",correct,correct tips");
                                writer.newLine();
                                writer.flush();

                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            try {
                                writer.write(cost + ",false,correct tips");
                                writer.newLine();
                                writer.flush();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    try {
                        writer.write("calculate test finished");
                        writer.newLine();
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "Thanks!");
                    System.exit(0);
                }

            }
            else
            JOptionPane.showMessageDialog(null,"Invalid input!");

        });

    }
}
