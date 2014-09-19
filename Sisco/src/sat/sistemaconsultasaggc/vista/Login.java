package sat.sistemaconsultasaggc.vista;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sat.sistemaconsultasaggc.controlador.siscoBean;
import sat.sistemaconsultasaggc.controlador.usuarioBean;
import sat.sistemaconsultasaggc.modelo.model;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass= request.getParameter("pass");
		String usuario = request.getParameter("usuario");
		//String rfccorto= request.getParameter("rfccorto");
if (pass != null){
			LinkedList<usuarioBean> Login;
			LinkedList<usuarioBean> LoginAdmin;
				
		try{	
			Login=model.getLogin(usuario.trim().toUpperCase(), pass.trim().toUpperCase());
			//
			LoginAdmin=model.getLoginAdmin(usuario.trim().toUpperCase(), pass.trim().toUpperCase());
			//
			request.setAttribute("LoginAdmin", LoginAdmin);
			LinkedList<usuarioBean> listaAdmin = (LinkedList) request.getAttribute("LoginAdmin");
			Iterator itr = listaAdmin.iterator();
			
			if(Login.isEmpty()){
				
				request.getRequestDispatcher("ErrorLogin.jsp").forward(request, response);
				
			}else if(LoginAdmin.isEmpty()){
				request.getRequestDispatcher("ErrorLogin.jsp").forward(request, response);
			}else if(itr.hasNext()){
				
				//ADMIN
				usuarioBean uB=(usuarioBean) itr.next();
				if(uB.getId() == 19){ //ESTO SE REFIERE QUE SI CUMPLE CON LA CONTRASEÑA Y EL USUARIO QUE CORRESPONDE AL ID 1 
                                                     //SI EL ID 1 NO LO OCUPA EL ADMINISTRADOR MODIFICAR EL NUMERO POR ID RESPECTIVO. 
                                    HttpSession session = request.getSession(true);
				   session.setAttribute("usuario", usuario);
				   request.getRequestDispatcher("admin.jsp").forward(request, response);
				//	
					
				}else {
					HttpSession session = request.getSession(true);
					session.setAttribute("usuario", usuario);
					request.getRequestDispatcher("inicio.jsp").forward(request, response);
				}
			}
			
		}catch(Exception ex){ex.printStackTrace();
		}
		
}	
                
     /*  ESTO SE OMITE, ES PARA RESTABLECER LA CONTRASEÑA POR MEDIO DE LA RFC
       if(rfccorto != null){
			
			
			LinkedList<usuarioBean> listaPass;
			
			try {
				
				listaPass= model.getPassword(rfccorto.toUpperCase());
				
				if(listaPass.isEmpty()){
					
					request.getRequestDispatcher("ErrorLogin.jsp").forward(request, response);
				
				}else {
					request.setAttribute("listaPass", listaPass);
					request.getRequestDispatcher("Recuperada.jsp").forward(request, response);
					
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		 
			
		}*/
		
		
		
		
		
		
		}
		
}
