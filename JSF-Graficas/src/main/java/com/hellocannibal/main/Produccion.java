package com.hellocannibal.main;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import org.primefaces.model.chart.ChartSeries;

@ManagedBean (name="main")
public class Produccion {

    private BarChartModel compras;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public BarChartModel getCompras(){
    	return compras;
    }
 
    private void createAnimatedModels() {
      
        
        compras= initBarModel();
        compras.setTitle("Grafica de Compras");
        compras.setAnimate(true);
        compras.setLegendPosition("ne");
        Axis  yAxis=compras.getAxis(AxisType.Y);
        yAxis.setLabel("Compras");
        yAxis.setMin(0);
        yAxis.setMax(200);
        
        
        yAxis=compras.getAxis(AxisType.X);
        yAxis.setLabel("Años");
        
        
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
       
        ChartSeries apple = new ChartSeries();
        apple.setLabel("Apple");
        apple.set("2005", 108);
        apple.set("2006", 109);
        apple.set("2007", 82);
        apple.set("2008", 40);
        apple.set("2009", 15);
        
        ChartSeries android = new ChartSeries();
        android.setLabel("Android");
        android.set("2005", 149);
        android.set("2006", 190);
        android.set("2007", 194);
        android.set("2008", 150);
        android.set("2009", 121);
        
        model.addSeries(apple);
        model.addSeries(android);
        return model;
    }
     
   
    
}
