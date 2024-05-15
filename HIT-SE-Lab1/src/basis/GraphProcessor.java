package basis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/**
 * 有向图的处理工具类
 * @author YSJ
 * @version 1.0.0
 * @date 2017-09-15
 */
public class GraphProcessor {
	/**
	 * 根据文件路径（名称）生成有向图
	 * @param fileName 文件路径（名称）
	 * @return 读取文件内容生成的有向图
	 */
	public static DirectedGraph generateGraph(String fileName) {
		Scanner in;
		String pre, post;
		DirectedGraph graph = new DirectedGraph();
		try {
			in = new Scanner(new FileInputStream(fileName));
			do {
				pre = parseText(in.next());				
			} while (pre == null && in.hasNext());
			if (pre != null) {
				graph.addVertex(pre);
			}
			while (in.hasNext()) {
				post = parseText(in.next());
				if (post != null ) {
					graph.addVertex(post);
					graph.addEdge(pre, post);
					pre = post;
				}
			}
		} catch (FileNotFoundException e) {
			System.exit(0);
		}
		return graph;
	}

	/**
	 * 处理字符串中的非法字符，返回满足格式要求的字符串
	 * @param str 待处理的字符串
	 * @return 处理后的满足格式要求的字符串
	 */
	public static String parseText(String str) {
		StringBuffer sb = new StringBuffer();
		if (str != null) {
			for (int i = 0; i < str.length(); ++i) {
				char c = str.charAt(i);
				if (Character.isLetter(c)) {
					sb.append(Character.toLowerCase(c));
				}
			}
		}
		return (sb.toString().equals("")) ? null : sb.toString();
	}

	/**
	 * 从有向图结点集合中随机选择一个结点
	 * @param set 待选择的集合
	 * @return 选择出的结点
	 */
	public static Vertex randomSelect(Collection<Vertex> set) {
		if (set == null || set.size() == 0) {
			return null;
		}
		int item = new Random().nextInt(set.size());
		int i = 0;
		for (Vertex v : set) {
			if (i == item) {
				return v;
			}
			++i;
		}
		return null;
	}
}
