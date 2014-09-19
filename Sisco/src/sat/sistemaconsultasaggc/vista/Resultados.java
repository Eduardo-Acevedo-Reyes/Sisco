package sat.sistemaconsultasaggc.vista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sat.sistemaconsultasaggc.controlador.siscoBean;
import sat.sistemaconsultasaggc.modelo.model;

/**
 * Servlet implementation class Resultados
 */
public class Resultados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String orden= request.getParameter("orden");
String rfc=request.getParameter("rfc");
String nomRazon=request.getParameter("nomRazon");
String nomRazonCompletoRFC=request.getParameter("nomRazonCompletoRFC");  ///por rfc
String excel = request.getParameter("excel");
String excel2 = request.getParameter("excel2");

siscoBean sb;


if(orden != null){
            LinkedList<siscoBean> listaOrden;
		try {
		listaOrden= model.getOrden(orden.trim().toUpperCase()); //orden
		
		if(listaOrden.isEmpty()){
			 request.getRequestDispatcher("Error.jsp").forward(request, response);
		}else {
			
                        
                        request.setAttribute("listaOrden", listaOrden);
			 request.getRequestDispatcher("Resultados.jsp").forward(request, response); //EjemploDatawritview
		}       
		} catch (SQLException e) {
		
		e.printStackTrace();
		}	
	}
if(rfc != null){
	LinkedList<siscoBean> lista;
	
	try {
		
		lista = model.getRFC(rfc.trim().toUpperCase());
		
		if(lista.isEmpty()){
			
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		
		}else {
			request.setAttribute("lista", lista);
			request.setAttribute("listaExcel", lista);
			request.getRequestDispatcher("ResultadosRFC.jsp").forward(request, response);
			//ReporteExcel.jsp  BORRARLO
                        //ResultadosRFC
                        //EjemploDataWrid.jsp
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
 }  




//EXCEL
if(excel != null){
	LinkedList<siscoBean> listaex1;
	
	try {
		
		listaex1 = model.getRFC(excel.trim());
		
		if(listaex1.isEmpty()){
			
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		
		}else {
			request.setAttribute("listaex1", listaex1);
			request.getRequestDispatcher("DuplicaExcel.jsp").forward(request, response);
			
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
 }  


if(excel2 != null){
	LinkedList<siscoBean> listaex;
	
	try {
		
		listaex = model.getRFC(excel2.trim());
		
		if(listaex.isEmpty()){
			
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		
		}else {
			request.setAttribute("listaex2", listaex);
			request.getRequestDispatcher("DuplicaExcel2.jsp").forward(request, response);
			
			
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
 }  
//

if(nomRazon!= null){
	LinkedList<siscoBean> listaNomRazon;
	try {
		listaNomRazon= model.getNomRazon(nomRazon.trim().toUpperCase());
		
		if(listaNomRazon.isEmpty()){
			request.getRequestDispatcher("Error.jsp").forward(request, response);
		}else {
			
			 request.setAttribute("listaNomRazon", listaNomRazon);
			 request.getRequestDispatcher("ResultadosNomRazon.jsp").forward(request, response);
		}
		} catch (SQLException e) {
		
		e.printStackTrace();
		}	
 }
 
 if(nomRazonCompletoRFC!= null){
		LinkedList<siscoBean> listaNomRazonCompletoRFC;
		try {
                        
			listaNomRazonCompletoRFC= model.getNomRazonCompleto(nomRazonCompletoRFC.trim());
			
			if(listaNomRazonCompletoRFC.isEmpty()){
				request.getRequestDispatcher("Error.jsp").forward(request, response);
			}else {
				 request.setAttribute("listaExcel2", listaNomRazonCompletoRFC);
				 request.setAttribute("listaNomRazonCompleto", listaNomRazonCompletoRFC);
				 request.getRequestDispatcher("ResultadosNomRazonCompleto.jsp").forward(request, response);
			}
			} catch (SQLException e) {
			
			e.printStackTrace();
			}	
	 }
 
 
 
 
 }
}


