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
public class HistoPointData {
  private String label;
  private int count;
  public HistoPointData() {}
  public HistoPointData(String label, int count) {
    this.label = label;
    this.count = count;
  }
  @XmlElement
  public String getLabel() {
    return label;
  }
  public void setLabel(String label)  {
    this.label = label;
  }
  @XmlElement
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
}
