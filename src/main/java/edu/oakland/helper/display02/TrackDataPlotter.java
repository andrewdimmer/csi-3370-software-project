package edu.oakland.helper.display02;

import edu.oakland.helper.admin.LocationDataPoint;
import edu.oakland.helper.admin.TrackData;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 * This helper class plots the TrackData LocationDataPoints and calculates a line of best fit
 * and displays both in a JFreeChart.
 * Based on example from boraji.com/jfreechart-scatter-chart-example
 */
public class TrackDataPlotter extends JFrame {

  private float[] lat;
  private float[] lng;
  private XYSeries dataPoints;
  private XYSeries fitLine;
  private JFreeChart chart;
  private boolean displayedChart;

  /**
  * Creates a TrackDataPlotter object which contains a chart with the location
  * data as a series and the line of best fit represented by two points.
  *
  * @param data TrackData object representing the location data to be plotted
  */
  public TrackDataPlotter(TrackData data) {

    if (data == null) {
      throw new IllegalArgumentException("Track data is null");
    }
    if (data.getLocationDataPoints().length == 0) {
      throw new IllegalArgumentException("Track data has no points in it");
    }

    this.lat = extractLatFromTrackData(data);
    this.lng = extractLngFromTrackData(data);
    this.dataPoints = getTrackData(this.lng, this.lat);
    if (data.getLocationDataPoints().length >= 2) {
      this.fitLine = calculateLine(this.lng, this.lat);
    }
    this.chart = createChart();
  }

  /**
  * Creates a JFreeChart from the dataPoint series and fitLine series.
  *
  * @return JFreeChart poltting the location data points and line of best fit
  */
  private JFreeChart createChart() {

    // Create new series collection
    XYSeriesCollection dataset = new XYSeriesCollection();
    // Add series to series collection
    dataset.addSeries(this.dataPoints);
    if (fitLine != null) {
      dataset.addSeries(this.fitLine);
    }
    // Create dataset with series collection
    XYDataset dataPoints = dataset;
    // Create Scatter Plot with Fit Line
    JFreeChart plotChart = ChartFactory.createScatterPlot("Track Data Plot",
            "X-Axis", "Y-Axis", dataPoints);

    // Parameters for the chart including size of draw area at
    // free.org/jfreechart/javadoc/org/jfree/chart/ChartPanel*/
    ChartPanel panel = new ChartPanel(plotChart, 600, 600, 600, 600, 600, 600,
        true, false, false, false, false, false);

    add(panel);
    pack();
    setTitle("Line chart");

    // Create a renderer and alter how the series are displayed
    // jfree.org/jfreechart/javadoc/org/jfree/chart/renderer/xy/XYLineAndShapeRenderer
    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
    renderer.setSeriesLinesVisible(0, false);
    renderer.setSeriesLinesVisible(1, true);
    renderer.setSeriesShapesVisible(0, true);
    renderer.setSeriesShapesVisible(1, false);
    renderer.setSeriesPaint(0, Color.RED);
    renderer.setSeriesPaint(1, Color.BLUE);
    renderer.setSeriesStroke(0, new BasicStroke(2.0f));
    XYPlot plot = plotChart.getXYPlot();
    plot.setDomainGridlinesVisible(true);
    plot.setDomainGridlinePaint(Color.BLACK);

    // Lock the XY axis around the sample data lat and lng
    plot.getDomainAxis().setRange(-46, -44);
    plot.getRangeAxis().setRange(45, 46);

    plot.setRenderer(renderer);
    setLocationRelativeTo(null);

    return plotChart;

  }

  /**
   * Adds the coordinates of the location data as points in the dataPoints series.
   *
   * @param x float array of latitudes of location data points
   * @param y float array of longitudes of location data points
   * @return XYSeries dataPoints representing location data points
   */
  public XYSeries getTrackData(float[] x, float[] y) {
    XYSeries dataPoints = new XYSeries("Locations");
    for (int i = 0; i < x.length; i++) {
      dataPoints.add(x[i], y[i]);
    }
    return dataPoints;
  }

  /**
  * Calculates the line of best fit for the location points and represents it as a
  * series containing two endpoints of a line segment spanning the x range of the data.
  *
  * @param x float array of latitudes of location data points
  * @param y float array of longitudes of location data points
  * @return XYSeries fitLine representing a line of best fit for the location data points
  */
  private XYSeries calculateLine(float[] x, float[] y) {
    XYSeries fitLine = new XYSeries("Line");
    int length = x.length;
    float sumOfX = 0;
    float sumOfY = 0;
    float sumOfXy = 0;
    float sumOfxSquared = 0;
    double minX = this.dataPoints.getMinX();
    double maxX = this.dataPoints.getMaxX();

    for (int i = 0; i < length; i++) {
      sumOfxSquared += x[i] * x[i];
      sumOfX += x[i];
      sumOfXy += x[i] * y[i];
      sumOfY += y[i];
    }

    float topHalfOfEquation = length * sumOfXy - sumOfX * sumOfY;
    float bottomHalfOfEquation = length * sumOfxSquared - sumOfX * sumOfX;
    float slope = topHalfOfEquation / bottomHalfOfEquation;
    float b = (sumOfY - (slope * sumOfX)) / length;

    // Least Squares Regression = mx+b
    fitLine.add(minX, slope * minX + b);
    fitLine.add(maxX, slope * maxX + b);

    return fitLine;
  }

  /**
  * Gets the latitudes of location data points from TrackData and stores a float array.
  *
  * @param data TrackData object representing the location data to be plotted
  * @return float[] latNum containing x coordinates of location data points
  */
  private float[] extractLatFromTrackData(TrackData data) {
    LocationDataPoint[] points = data.getLocationDataPoints();
    float[] latNum = new float[points.length];
    for (int i = 0; i < points.length; i++) {
      latNum[i] = points[i].getLat();
    }
    return latNum;
  }

  /**
  * Gets the longitudes of location data points from TrackData and stores a float array.
  *
  * @param data TrackData object representing the location data to be plotted
  * @return float[] lngNum containing y coordinates of location data points
  */
  private float[] extractLngFromTrackData(TrackData data) {
    LocationDataPoint[] points = data.getLocationDataPoints();
    float[] lngNum = new float[points.length];
    for (int i = 0; i < points.length; i++) {
      lngNum[i] = points[i].getLng();
    }
    return lngNum;
  }

  /**
  * Displays the chart.
  */
  public void displayChart() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    displayedChart = true;
  }

  /**
   * Exposes the displayedChart attribute for testing and verification. Not to be used for
   * production.
   *
   * @return true if the chart was displayed to the user; false otherwise.
   */
  public boolean getDisplayedChart() {
    return displayedChart;
  }
}
