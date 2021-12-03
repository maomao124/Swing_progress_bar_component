import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Project name(项目名称)：Swing进度条组件
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/12/3
 * Time(创建时间)： 19:38
 * Version(版本): 1.0
 * Description(描述)： Swing JProgressBar：进度条组件
 * //创建一个最小值是0，最大值是100的进度条
 * JProgressBar pgbar=new JProgressBar(0,100);
 * //创建一个最小值是0，最大值是60，当前值是20的进度条
 * JProgressBar pgbar=new JProgressBar(0,60,20);
 * JProqressBar类的常用方法
 * 方法名称	说明
 * getMaximum()	返回进度条的最大值
 * getMinimum()	返回进度条的最小值
 * getPercentComplete()	返回进度条的完成百分比
 * getString()	返回当前进度的 String 表示形式
 * getValue()	返回进度条的当前 value
 * setBorderPainted(boolean b)	设置 borderPainted 属性，如果进度条应该绘制其边框，则此属性为 true
 * setIndeterminate(boolean
 * newValue)	设置进度条的 indeterminate 属性，该属性确定进度条处于确定模式中还
 * 是处于不确定模式中
 * setMaximum(int n)	将进度条的最大值设置为 n
 * setMinimum(int n)	将进度条的最小值设置为 n
 * setOrientation(int newOrientation)	将进度条的方向设置为 newOrientation
 * setString(String s)	设置进度字符串的值
 * setStringPainted(boolean b)	设置 stringPainted 属性的值，该属性确定进度条是否应该呈现进度字符串
 * setValue(int n)	将进度条的当前值设置为 n
 * updateUI()	将 UI 属性重置为当前外观对应的值
 * 如果要执行一个未知长度的任务，可以调用 setlndeterminate(true) 将进度条设置为不确定模式。
 * 不确定模式的进度条将持续地显示动画来表示正进行的操作。一旦可以确定任务长度和进度量，则应该更新进度条的值，将其切换到确定模式。
 */

class Progress extends Thread
{
    JProgressBar progressBar;
    JButton button;
    //进度条上的数字
    int[] progressValues = {6, 18, 27, 39, 51, 66, 81, 100};

    Progress(JProgressBar progressBar, JButton button)
    {
        this.progressBar = progressBar;
        this.button = button;
    }

    public void run()
    {
        for (int i = 0; i < progressValues.length; i++)
        {
            try
            {
                Thread.sleep(300);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //设置进度条的值
            progressBar.setValue(progressValues[i]);
        }
        progressBar.setIndeterminate(false);
        progressBar.setString("升级完成！");
        button.setEnabled(true);
    }
}


public class test extends JFrame
{
    public test()
    {
        setLocation(1920/2-1280/2, 1080/2-720/2);
        setSize(1280, 720);
        setTitle("进度条示例");
        JLabel label = new JLabel("升级");
        JProgressBar jProgressBar = new JProgressBar(0, 100);
        JButton button = new JButton("完成");
        button.setEnabled(false);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5000, 20));
        Font font = new Font("宋体", Font.PLAIN, 20);
        label.setFont(font);
        jProgressBar.setFont(font);
        button.setFont(font);
        jPanel.add(label);
        jPanel.add(jProgressBar);
        jPanel.add(button);
        add(jPanel);
        jProgressBar.setStringPainted(true);
        jProgressBar.setLocation(200, 200);
        jProgressBar.setPreferredSize(new Dimension(500, 25));
        //jProgressBar.setString("正在升级...");
        //jProgressBar.setIndeterminate(true);
        new Progress(jProgressBar, button).start();
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args)
    {
        test t = new test();
        t.setVisible(true);
        t.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
