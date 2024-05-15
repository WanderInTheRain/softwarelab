package basis;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 有向图结点类
 * @author YSJ
 * @version 1.0.0
 * @date 2017-09-15
 */
public class Vertex {
	public String name;
	public HashSet<Vertex> predecessors;
	public HashSet<Vertex> successors;
	public HashMap<Vertex, Integer> weights;
	
	public Vertex() {
		this.name = null;
		this.predecessors = new HashSet<>();
		this.successors = new HashSet<>();
		this.weights = new HashMap<>();
	}
	
	public Vertex(String name) {
		this.name = name;
		this.predecessors = new HashSet<>();
		this.successors = new HashSet<>();
		this.weights = new HashMap<>();
	}
	
	public boolean equals(Vertex v) {
		return this.name.equals(v.name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
