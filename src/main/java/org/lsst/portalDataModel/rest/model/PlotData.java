/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lsst.portalDataModel.rest.model;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jrb
 */
@XmlRootElement
public class PlotData {
  private String title;
  private String xtitle;
  private String ytitle;
  private ArrayList<PlotPointData> points;
  private double minx=0.0;
  private double miny=0.0;
  private double maxx=0.0;
  private double maxy=0.0;
  private boolean isSorted = false;
  
  public PlotData() {}
  public PlotData(String title, String xtitle, String ytitle,
      ArrayList<PlotPointData> points) {
      this.title = title;
      this.xtitle = xtitle;
      this.ytitle = ytitle;
      this.points = points;
      findBounds(0);
  }
  @XmlElement
  public String getTitle() {return title; }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  @XmlElement
  public String getXtitle() {return xtitle; }
  
  public void setXtitle(String xtitle) {
    this.xtitle = xtitle;
  }
  
  @XmlElement
  public String getYtitle() {return ytitle; }
  
  public void setYtitle(String ytitle) {
    this.ytitle = ytitle;
  }
  
  @XmlElement
  public ArrayList<PlotPointData> getPoints() { return points; }
  
  public void setPoints(ArrayList<PlotPointData> points) {
    this.points = points;
    isSorted=false;
  }
  
  public void addPoints(ArrayList<PlotPointData> newPoints) {
    if (points == null)  {
      points = new ArrayList<PlotPointData>();
    }
    points.addAll(newPoints);
    isSorted=false;
  }
  public void addPoint(PlotPointData newPoint) {
    if (points == null) {
      points = new ArrayList<PlotPointData>();
    }
    points.add(newPoint);
    isSorted=false;
  }
  
  @XmlTransient
  private void findBounds(int startIndex) {
     if (points != null) {
      if (!isSorted) sortByX();
      minx = points.get(0).getX();
      maxx = points.get(points.size() - 1).getX();
      for (PlotPointData point: points.subList(startIndex, points.size())) {
        if (point.getY() > maxy) {
          maxy = point.getY();
        }
        if (point.getY() < miny) {
          miny = point.getY();
        }
      }
    }
  }
   
  @XmlTransient
  public void sortByX() {
    Collections.sort(points);
    isSorted = true;
  }
}
