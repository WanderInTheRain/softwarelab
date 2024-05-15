package basis;

import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * 随机游走的线程控制类
 * @author XJL
 * @version 1.0.0
 * @date 2017-09-20
 */
public class RandomWalker implements Runnable {
    private TextArea area;				//随机游走控制面板的结果显示区域
    private ArrayList<Vertex> vertices;	//有向图的顶点列表
    private Thread thread;				//用于控制的线程
    private boolean suspended;			//用于标注线程是否暂停

    public RandomWalker(TextArea a, ArrayList<Vertex> l) {
        this.area = a;
        this.vertices = l;
    }

    /**
     * 线程的运行方法
     */
    @Override
    public void run() {
        HashMap<Vertex, HashSet<Vertex>> walkedVertices = new HashMap<>();	//用于记录已被随机游走过的有向边
        for (Vertex v : vertices) {
            walkedVertices.put(v, new HashSet<>());
        }
        Vertex pre = vertices.get(new Random().nextInt(vertices.size()));	//用于记录有向边起点
        Vertex next;	//用于记录有向边终点
        StringBuffer sb = new StringBuffer();	//随机游走结果字符串构造器
        sb.append(pre.name);
        area.setText(sb.toString());
        while (true) {
            try {
                Thread.sleep(1000);		//线程休眠一秒后运行
                //线程同步，若线程暂停则进入等待状态
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            next = GraphProcessor.randomSelect(pre.successors);	//随机选择pre结点的一个后继结点
            //若没有后继结点，则随机游走停止
            if (next == null) {
                break;
            }
            //更新显示随机游走结果
            sb.append(" " + next.name);
            area.setText(sb.toString());
            //若遇到已经游走过的有向边，则停止随机游走
            if (walkedVertices.get(pre).contains(next)) {
                break;
            }
            walkedVertices.get(pre).add(next);	//记录已经游走过的有向边
            pre = next;	//沿路径向前移动
        }
    }

    /**
     * 线程开始运行
     */
    public void start() {
        if(thread == null){
            thread = new Thread(this, "RandomWalkThread");
            thread.start();
        }
    }

    /**
     * 线程暂停
     */
    public void suspend() {
        suspended = true;
    }

    /**
     * 线程继续
     */
    public synchronized void resume() {
        suspended = false;
        notify();
    }
}
