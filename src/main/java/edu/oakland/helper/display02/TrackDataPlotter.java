package edu.oakland.helper.display02;

//include jfreechart-1.0.19.jar
//include jcommon-1.0.23.jar

import edu.oakland.helper.admin.TrackData;
import edu.oakland.helper.admin.LocationDataPoint;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class TrackDataPlotter extends JFrame{

  //constructor
  public TrackDataPlotter(TrackData data){
    float[] lat = extractLatFromTrackData(data);
    float[] lng = extractLngFromTrackData(data);
    XYSeries dataPoints = getTrackData();
    XYSeries dataLine = calculateLine();
    isValidTrackData = data.isValid();


  }
  public void displayPlotter(){
    // TrackDataPlotter example = new TrackDataPlotter(TrackData);
    // example.setSize(800, 400);
    // example.setLocationRelativeTo(null);
    // example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // example.setVisible(true);\
    //or place in constructor

    //Scatter Plot
    JFreeChart plotChart = ChartFactory.createScatterPlot(
    "Track Data Plot",
    "X-Axis", "Y-Axis", dataPoints);
    ChartPanel panel1 = new ChartPanel(plotChart);
    setContentPane(panel1);

    //Line Chart
    JFreeChart lineChart = ChartFactory.createXYLineChart(
    "Track Data Line Chart",
    "X-Axis", "Y-Axis", dataLine);
    ChartPanel panel2 = new ChartPanel(lineChart);
    setContentPane(panel2);

  }
  private XYSeries getTrackData(){
    XYSeries dataPoints = new XYSeries("Locations");
    for(i < lat.length){
      dataPoints.add(lat[i], lng[i]);
    }
    return dataPoints;
  }
  private XYSeries calculateLine(int[] x, int[] y){



  }
  private float[] extractLatFromTrackData(TrackData data){
    LocationDataPoint[] points = data.getLocationDataPoints();
    float[] latNum = [];
    for(i < points.length){
      latNum[i]= points[i].getLat();
    }
    return latNum;
  }
  private float[] extractLngFromTrackData(TrackData data){
    LocationDataPoint[] points = data.getLocationDataPoints();
    float[] lngNum = [];
    for(i < points.length){
      lngNum[i]= points[i].getLng();
    }
    return lngNum;
  }

}
