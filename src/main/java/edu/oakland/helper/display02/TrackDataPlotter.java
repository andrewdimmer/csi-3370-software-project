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
    private float[] lat = extractLatFromTrackData(data);
    private float[] lng = extractLngFromTrackData(data);
    private XYSeries dataPoints = getTrackData(lat, lng);
    private XYSeries fitLine = calculateLine(lat, lng);
    private Boolean isValidTrackData = data.isValid();
    private JFreeChart chart = createChart();

  }
  private JFreeChart createChart(){

    // Create new series colection
    XYSeriesCollection dataset = new XYSeriesCollection();
    // Add series to series collection
    dataset.addSeries(this.dataPoints);
    dataset.addSeries(this.fitLine);
    // Create dataset with series collection
    XYDataset dataPoints = dataset;
    // Create Scatter Plot with Fit Line
    JFreeChart plotChart = ChartFactory.createScatterPlot(
    "Track Data Plot",
    "X-Axis", "Y-Axis", dataPoints);
    ChartPanel panel = new ChartPanel(plotChart, 600, 600, 600, 600, 600, 600,
            true, false, false, false, false, false);
      //panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
      add(panel);
      pack();
      setTitle("Line chart");
      XYPlot plot = plotChart.getXYPlot();
      // Create a renderer and alter how the series are displayed
      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
      renderer.setSeriesLinesVisible(0, false);
      renderer.setSeriesLinesVisible(1, true);
      renderer.setSeriesShapesVisible(0, true);
      renderer.setSeriesShapesVisible(1, false);
      renderer.setSeriesPaint(0, Color.RED);
      renderer.setSeriesPaint(1, Color.BLUE);
      renderer.setSeriesStroke(0, new BasicStroke(2.0f));
      plot.setDomainGridlinesVisible(true);
      plot.setDomainGridlinePaint(Color.BLACK);

      plot.setRenderer(renderer);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      return plotChart;

  }
  public XYSeries getTrackData(int[] x, int[] y){
    XYSeries dataPoints = new XYSeries("Locations");
    for(int i = 0; i < x.length; i++){
      dataPoints.add(x[i], y[i]);
    }
    return dataPoints;
  }

  private XYSeries calculateLine(int[] x, int[] y){
      XYSeries fitLine = new XYSeries("Locations");
      //placeholder for testing
      //fitLine.add(3, 5);
      //fitLine.add(12, 15);
      float sumOfX = 0;
      float sumOfY = 0;
      float sumOfXy = 0;
      float sumOfXSquared = 0;
      float xMin = x[0];
      float xMax = x[0];

      for(int i = 0; i < 5; i++) {
    		sumOfXSquared += x[i] * x[i];
    		sumOfX += x[i];
    	  sumOfXy += x[i] * y[i];
    	  sumOfY += y[i];

    	  if (x[i] < xMin){
    	    xMin = x[i];
          }

    	  if (x[i] > xMax){
    	    xMax = x[i];
          }

    	}

      float topHalfOfEquation = 5 * sumOfXy - sumOfX * sumOfY;
      float bottomHalfOfEquation = 5 * sumOfXSquared - sumOfX * sumOfX;
      float slope = topHalfOfEquation/bottomHalfOfEquation;
      float b = (sumOfY - (slope * sumOfX))/ 5;
      //Least Squares Regression = mx+b

      fitLine.add(xMin, slope * xMin + b);
      fitLine.add(xMax, slope * xMax + b);

      return fitLine;
  }

  private float[] extractLatFromTrackData(TrackData data){
    LocationDataPoint[] points = data.getLocationDataPoints();
    float[] latNum = new float[5];
    for(int i < points.length; i<=5; i++){
      latNum[i]= points[i].getLat();
    }
    return latNum;
  }

  private float[] extractLngFromTrackData(TrackData data){
    LocationDataPoint[] points = data.getLocationDataPoints();
    float[] lngNum = new float[5];
    for(int i < points.length; i<=5; i++){
      lngNum[i]= points[i].getLng();
    }
    return lngNum;
  }



}


