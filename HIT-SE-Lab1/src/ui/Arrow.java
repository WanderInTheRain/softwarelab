package ui;

import javafx.beans.InvalidationListener;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Transform;

/**
 * @author XJL
 * @date 2017-09-18
 * @version 1.0.0
 */
public class Arrow extends Group {
    private Line line;  //箭头的直线部分

    private static final double arrow_size = 8;    //箭头大小

    public Arrow(Line line, int weight) {
        this(line, new Polygon(), new Text(String.valueOf(weight)));
    }

    /**
     *
     * @param line 箭头的直线部分
     * @param triangle 箭头的三角形部分
     * @param text 箭头的标签部分（权值）
     */
    private Arrow(Line line, Polygon triangle, Text text) {
        super(line, triangle, text);    //超类Group的构造
        this.line = line;

        double sxInit = getStartX();    //获得直线的起点x坐标
        double syInit = getStartY();    //获得直线的起点y坐标
        double exInit = getEndX();      //获得直线的终点x坐标
        double eyInit = getEndY();      //获得直线的终点y坐标

        double dxInit = exInit - sxInit;    //横坐标差
        double dyInit = eyInit - syInit;    //纵坐标差
        double angleInit = Math.atan2(dyInit, dxInit);  //直线角度

        Transform transInit = Transform.translate(exInit, eyInit);  //初始化变换tansInit,将其x坐标偏移设置为直线的终点x坐标，y坐标偏移设置为直线的终点y坐标
        transInit = transInit.createConcatenation(Transform.rotate(Math.toDegrees(angleInit), 0, 0));   //设置绕点(0,0)旋转一定的角度（直线的角度）
        triangle.getPoints().clear();   //清空三角形中原有的点
        triangle.getPoints().addAll(    //将三角形初始位置设置在点(0,0)处
                0.0, 0.0,
                - arrow_size, arrow_size / 2,
                - arrow_size, - arrow_size / 2);
        triangle.getTransforms().clear();   //清空三角形已有的变换
        triangle.getTransforms().add(transInit);    //将为三角形添加变换transInit
        triangle.setFill(Color.PURPLE);     //设置三角形颜色为紫色

        text.setWrappingWidth(40);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);
        text.setFill(Color.PURPLE);
        text.setLayoutX((sxInit + exInit) / 2 - text.getWrappingWidth() / 2);   //设置文本x坐标为直线的中点x坐标
        text.setLayoutY((syInit + eyInit) / 2 - text.getScaleY());  //设置文本y坐标为直线的中点y坐标

        //初始化属性监听器updater，用于在直线的位置属性变化时更新三角形与文本的位置属性，以便保持箭头形状
        InvalidationListener updater = o -> {
            double sx = getStartX();
            double sy = getStartY();
            double ex = getEndX();
            double ey = getEndY();

            double dx = ex - sx;
            double dy = ey - sy;
            double angle = Math.atan2(dy, dx);

            //更新过程与初始化计算方法相同
            Transform transform = Transform.translate(ex, ey);
            transform = transform.createConcatenation(Transform.rotate(Math.toDegrees(angle), 0, 0));
            triangle.getPoints().clear();
            triangle.getPoints().addAll(
                    0.0, 0.0,
                    - arrow_size, arrow_size / 2,
                    - arrow_size, - arrow_size / 2);
            triangle.getTransforms().clear();
            triangle.getTransforms().add(transform);
            triangle.setFill(Color.PURPLE);

            text.setLayoutX((sx + ex) / 2 - text.getWrappingWidth() / 2);
            text.setLayoutY((sy + ey) / 2 - text.getScaleY());
        };

        //将监听器updater添加到直线的各位置属性
        startXProperty().addListener(updater);
        startYProperty().addListener(updater);
        endXProperty().addListener(updater);
        endYProperty().addListener(updater);
    }

    /**
     *
     * @param value 箭头的颜色
     */
    public void setStroke(Paint value) {
        this.line.setStroke(value);
    }

    /**
     *
     * @param value 箭头的直线宽度
     */
    public void setStrokeWidth(double value) {
        this.line.setStrokeWidth(value);
    }

    /**
     *
     * @param value 为直线的起点x坐标设置的值
     */
    public final void setStartX(double value) {
        line.setStartX(value);
    }

    /**
     *
     * @return 直线的起点x坐标
     */
    public final double getStartX() {
        return line.getStartX();
    }

    /**
     *
     * @return 直线的startX属性
     */
    public final DoubleProperty startXProperty() {
        return line.startXProperty();
    }

    /**
     *
     * @param value 为直线的起点y坐标设置的值
     */
    public final void setStartY(double value) {
        line.setStartY(value);
    }

    /**
     *
     * @return 直线的起点y坐标
     */
    public final double getStartY() {
        return line.getStartY();
    }

    /**
     *
     * @return 直线的startY属性
     */
    public final DoubleProperty startYProperty() {
        return line.startYProperty();
    }

    /**
     *
     * @param value 为直线的终点x坐标设置的值
     */
    public final void setEndX(double value) {
        line.setEndX(value);
    }

    /**
     *
     * @return 直线的终点x坐标
     */
    public final double getEndX() {
        return line.getEndX();
    }

    /**
     *
     * @return 直线的endX属性
     */
    public final DoubleProperty endXProperty() {
        return line.endXProperty();
    }

    /**
     *
     * @param value 为直线的终点y坐标设置的值
     */
    public final void setEndY(double value) {
        line.setEndY(value);
    }

    /**
     *
     * @return 直线的终点y坐标
     */
    public final double getEndY() {
        return line.getEndY();
    }

    /**
     *
     * @return 直线的endY属性
     */
    public final DoubleProperty endYProperty() {
        return line.endYProperty();
    }
}
