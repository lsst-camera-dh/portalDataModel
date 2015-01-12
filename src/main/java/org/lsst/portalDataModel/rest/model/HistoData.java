/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lsst.portalDataModel.rest.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;


/**
 * Generic 1-d histogram description:  a collection of pairs (label, count)
 * @author jrb
 */
@XmlRootElement       // <- This denotes that this is a contained XML or JSON element
public class HistoData {
  private String title;
  private String xtitle;   // optional
  boolean numeric = false;  // true if x-axis labels are numbers
  private ArrayList<HistoPointData> points;
  private int maxcount =0;

  public HistoData() {}
  public HistoData(String title, String xtitle, boolean numeric, 
      ArrayList<HistoPointData> points ) {
    this.title = title;
    this.xtitle = title;
    this.numeric = numeric;
    this.points = points;
    findMaxcount();
  }
  
  @XmlElement
  public String getTitle() { return title; }
  
  public void setTitle(String title)  {
    this.title = title;
  }
  
  @XmlElement
  public String getXtitle() { return xtitle; }
  
  public void setXtitle(String xtitle) {
    this.xtitle = xtitle;
  }
  @XmlElement 
  public boolean isNumeric() { return numeric; }
  
  @XmlElement
  public ArrayList<HistoPointData> getPoints() {
    return points;
  }
  
  @XmlElement
  public int getMaxcount() { return maxcount; }
  
  public void setPoints(ArrayList<HistoPointData> points) {
    this.points = points;
  }
  public void addPoints(ArrayList<HistoPointData> newPoints) {
    if (points == null)  {
      points = new ArrayList<HistoPointData>();
    }
    points.addAll(newPoints);
  }
  public void addPoint(HistoPointData newPoint) {
    if (points == null) {
      points = new ArrayList<HistoPointData>();
    }
    points.add(newPoint);
  }
  
  @XmlTransient
  private void findMaxcount() {
     if (points != null) {
      for (HistoPointData point: points) {
        if (point.getCount() > maxcount) {
          maxcount = point.getCount();
        }
      }
    }
  }
}
