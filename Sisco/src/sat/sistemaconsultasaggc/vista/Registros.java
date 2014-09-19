package sat.sistemaconsultasaggc.vista;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sat.sistemaconsultasaggc.controlador.RegBean;
import sat.sistemaconsultasaggc.controlador.usuarioBean;
import sat.sistemaconsultasaggc.modelo.model;

/**
 * Servlet implementation class Registros
 */
public class Registros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registros() {
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
		String usuario=request.getParameter("usuario");
		String contrasena=request.getParameter("pass");
		String rfccorto=request.getParameter("rfccorto");
		String administracion=request.getParameter("admin");
		String nombre=request.getParameter("nombre");
		String apeP=request.getParameter("apeP");
		String apeM=request.getParameter("apeM");
                
                String EliminaRFC=request.getParameter("EliminaRFC");
                
                String BuscaUser= request.getParameter("BuscaUser");
                
       String user=request.getParameter("user");
       String pass= request.getParameter("pass");
       String EliminaRFC1= request.getParameter("EliminaRFC1");
       String nombre1= request.getParameter("nombre1");
       String apeP1=request.getParameter("apeP1");
       String apeM1=request.getParameter("apeM1");
       String Admini=request.getParameter("Admini");
                
if(usuario != null){		
		RegBean uB = new RegBean(usuario,contrasena,rfccorto,administracion,nombre,apeP,apeM);
		try{

			boolean agregado = model.Registra(uB);
			if(agregado){
				request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("ErrorRegistro.jsp").forward(request, response);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
                
}
if(EliminaRFC != null){
            try{
                boolean elimina=model.EliminaRegistro(EliminaRFC.toUpperCase());
                
                if(elimina){
				request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("ErrorRegistro.jsp").forward(request, response);
			}
            }catch(Exception ex){
            ex.printStackTrace();
            }

          }

if(BuscaUser != null){
	LinkedList<usuarioBean> listaBusqueda ;
    try{
        listaBusqueda= model.getConsultaUsuario(BuscaUser);
    
    if(listaBusqueda.isEmpty()){
    	request.getRequestDispatcher("ErrorRegistro.jsp").forward(request, response);
    }else{
    	request.setAttribute("listaBusqueda",listaBusqueda);
        request.getRequestDispatcher("ModifacaUsuarios.jsp").forward(request, response); 
    }
    }catch(Exception ex){
    ex.printStackTrace();
    }
}

if(user != null || pass != null || EliminaRFC1 != null || nombre1 != null || apeP1 != null || apeM1 != null || Admini != null){
	RegBean us = new RegBean(user,pass,EliminaRFC1,Admini,nombre1,apeP1,apeM1);
	try{
		boolean actualizado=model.getUpdateUser(us);
		if(actualizado){
			request.getRequestDispatcher("Mensaje.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("ErrorRegistro.jsp").forward(request, response);
		}
		
	}catch(Exception ex){ex.printStackTrace();
	}
	
}

		
	}

}
