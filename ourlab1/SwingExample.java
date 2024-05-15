package ourlab1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingExample {
    public static void main(String[] args) {
        // 创建一个新的 JFrame 窗口
        JFrame frame = new JFrame("Swing 示例");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 创建一个按钮
        JButton button = new JButton("点击我");
        
        // 为按钮添加一个事件监听器
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 按钮被点击时，显示一条消息
                JOptionPane.showMessageDialog(frame, "按钮被点击了！");
            }
        });
        
        // 将按钮添加到 JFrame 中
        frame.getContentPane().add(button);
        
        // 显示窗口
        frame.setVisible(true);
    }
}
