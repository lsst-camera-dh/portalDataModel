/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lsst.portalDataModel.rest.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
/**
 *
 * @author jrb
 */
@XmlRootElement
public class PlotPointData implements Comparable<PlotPointData> {
  private double x;
  private double y;
  public PlotPointData() {}
  public PlotPointData(double x, double y) {
    this.x = x;
    this.y = y;
  }
  @XmlElement
  public double getX() {
    return x;
  }
  public void setX(float x)  {
    this.x = x;
  }
  @XmlElement
  public double getY() {
    return y;
  }
  public void setY(float y) {
    this.y = y;
  }
  @XmlTransient
  public int compareTo(PlotPointData other) {
    if (x < other.x) return -1;
    if (x > other.x) return 1;
    if (y < other.y) return -1;
    if (y > other.y) return 1;
    return 0;
  }
}
