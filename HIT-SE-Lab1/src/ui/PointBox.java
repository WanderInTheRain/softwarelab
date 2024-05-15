package ui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * 绘图面板上的顶点显示类，继承StackPane类目的是使顶点中的文本自动居中
 * @author XJL
 * @version 1.1.0
 * @date 2017-09-19
 */
public class PointBox extends StackPane {
    private DoubleProperty centerX = new SimpleDoubleProperty();	//顶点中心的X属性
    private DoubleProperty centerY = new SimpleDoubleProperty();	//顶点中心的y属性

    public PointBox() {
        super();
        //顶点中心x属性=左上角x位置属性+顶点宽度/2，顶点中心y属性=左上角y位置属性+顶点高度/2
        centerX.bind(this.layoutXProperty().add(this.prefWidthProperty().divide(2)));
        centerY.bind(this.layoutYProperty().add(this.prefHeightProperty().divide(2)));
    }

    public final double getCenterX() {
        return this.centerX.get();
    }

    public final void setCenterX(double value) {
        this.centerX.set(value);
    }

    public final double getCenterY() {
        return this.centerY.get();
    }

    public final void setCenterY(double value) {
        this.centerY.set(value);
    }

    public DoubleProperty centerXProperty() {
        return centerX;
    }

    public DoubleProperty centerYProperty() {
        return centerY;
    }

    /**
     * 获取绘图顶点对象内部的Circle形状对象
     * @return
     */
    public Circle getCircle() {
        for (Node node : this.getChildren()) {
            if (node instanceof Circle) {
                return (Circle)node;
            }
        }
        return null;
    }

    /**
     * 获取绘图顶点对象内部的Text文本对象
     */
    public Text getText() {
        for (Node node : this.getChildren()) {
            if (node instanceof Text) {
                return (Text)node;
            }
        }
        return null;
    }
}
