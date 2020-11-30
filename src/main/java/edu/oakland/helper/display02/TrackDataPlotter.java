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
    private XYSeries dataPoints = getTrackData();
    private XYSeries fitLine = calculateLine();
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
    ChartPanel panel1 = new ChartPanel(plotChart, 600, 600, 600, 600, 600, 600,
            true, false, false, false, false, false);
    setContentPane(panel1);

    XYPlot plot = plotChart.getXYPlot();
    // Create a renderer and alter how the series are displayed
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesLinesVisible(0, false);
    renderer.setSeriesLinesVisible(1, true);
    renderer.setSeriesShapesVisible(0, true);
    renderer.setSeriesShapesVisible(1, false);
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesPaint(1 Color.BLUE);
    //renderer.setSeriesStroke(1, new BasicStroke(2.0f));
    plot.setDomainGridlinesVisible(true);
    plot.setDomainGridlinePaint(Color.BLACK);

    plot.setRenderer(renderer);

    return plotChart;

  }
  private XYSeries getTrackData(){
    XYSeries dataPoints = new XYSeries("Locations");
    for(i < lat.length){
      dataPoints.add(lat[i], lng[i]);
    }
    return dataPoints;
  }

  private XYSeries calculateLine(int[] x, int[] y){
      XYSeries fitLine = new XYSeries("Locations");
      //placeholder for testing
      //fitLine.add(3, 5);
      //fitLine.add(12, 15);

      return fitLine;


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

  public void displayPlot(){

    // Create Panel
    ChartPanel panel = new ChartPanel(this.chart);
    setContentPane(panel);
    chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    chartPanel.setBackground(Color.white);
    add(chartPanel);
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

  }


}


//place in displayCommInterface:
// TrackDataPlotter example = new TrackDataPlotter(TrackData);
// example.setSize(800, 400);
// example.setLocationRelativeTo(null);
// example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
// example.setVisible(true);
