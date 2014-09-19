package sat.sistemaconsultasaggc.modelo;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.sql.*;
import javax.naming.*;

import sat.sistemaconsultasaggc.controlador.RegBean;
import sat.sistemaconsultasaggc.controlador.siscoBean;
import sat.sistemaconsultasaggc.controlador.usuarioBean;

import java.sql.*;
import java.util.LinkedList;


public class model   {

	private static Connection conn;
	
	public static void conectado()throws SQLException, ServletException {
		if(estoyConectado()) throw new SQLException("Ya esta� Conectado");
		try{
			 Context cxt= new InitialContext();
			 DataSource ds= (DataSource) cxt.lookup("java:comp/env/jdbc/sisco");
			 
			 if(cxt == null) throw new Exception("no se logro crear el contexto ERROR");
			 if(ds == null) throw new Exception ("no se concreto  el origen de datos ERROR");
			 
			 if(ds != null) conn=ds.getConnection();
			 
		}catch(Exception ex){
			throw new ServletException ("No se pudo concretar la accion hacia ",ex);
		}
	}
	
	public static boolean estoyConectado(){
		return (conn != null);
	}
	public static void desconectar(){
		if(conn != null){
			try{
				conn.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				conn= null;
			}
		}
	}
	
	public static LinkedList<siscoBean> getNomRazon(String nomRazon)throws SQLException, ServletException{		
		if(!estoyConectado()){
			conectado();
		}
		LinkedList<siscoBean> listaNomRazon= new LinkedList<siscoBean>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			
			pstmt=conn.prepareStatement("SELECT DISTINCT  nom_razon, rfc from Vista_Registros where nom_razon like ? ");  
			pstmt.setString(1,nomRazon.trim().toUpperCase() + "%");                                
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				
				siscoBean sB = new siscoBean();
				
				sB.setNom_razon(rs.getString(1));
                                sB.setRfc(rs.getString(2));
				
				listaNomRazon.add(sB);	
				
			}
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
		}
		desconectar();
		
		return listaNomRazon;
	}
	public static  LinkedList<siscoBean> getRFC(String nombreBanda) throws SQLException, ServletException{
		if (!estoyConectado()) {
			conectado();
		}
		LinkedList<siscoBean> listaContenidos= new LinkedList<siscoBean>();
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try{
			pstmt=conn.prepareStatement("select orden,rfc,nom_razon,to_char(fech_emi, 'DD-MM-YYYY'),origen,ejer_de, ejer_a,objetivo,id_program,id_a_prog FROM Vista_Registros where rfc = ? ");
			pstmt.setString(1, nombreBanda);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				siscoBean sB = new siscoBean();
				sB.setOrden(rs.getString(1));
				sB.setNom_razon(rs.getString(2));
				sB.setRfc(rs.getString(3));
                                sB.setFech_emi(rs.getString(4));
                                sB.setEjer_de(rs.getString(5));
                                sB.setEjer_a(rs.getString(6));
                                sB.setId_a_prog(rs.getString(7));
                                sB.setId_program(rs.getString(8));
				sB.setObjetivo(rs.getString(9));
				sB.setOrigen(rs.getString(10));
				
				listaContenidos.add(sB);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}finally{
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		desconectar();
		return listaContenidos;
		
	}
	
	
	public static  LinkedList<siscoBean> getNomRazonCompleto(String RFC) throws SQLException, ServletException{
		if (!estoyConectado()) {
			conectado();
		}
		LinkedList<siscoBean> listaNomRazonCompleto= new LinkedList<siscoBean>();
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		
		try{
			pstmt=conn.prepareStatement("select orden,rfc,nom_razon,fech_emi,origen,ejer_de, ejer_a,objetivo,id_program,id_a_prog from Vista_Registros where rfc = ? ");
			pstmt.setString(1, RFC.trim().toUpperCase());
			rs=pstmt.executeQuery();
			while (rs.next()) {
				siscoBean sB = new siscoBean();
				sB.setOrden(rs.getString(1));
				sB.setNom_razon(rs.getString(2));
				sB.setRfc(rs.getString(3));
                                sB.setFech_emi(rs.getString(4));
                                sB.setEjer_de(rs.getString(5));
                                sB.setEjer_a(rs.getString(6));
                                sB.setId_a_prog(rs.getString(7));
                                sB.setId_program(rs.getString(8));
				sB.setObjetivo(rs.getString(9));
				sB.setOrigen(rs.getString(10));
				
				
				listaNomRazonCompleto.add(sB);
			}
		}catch (Exception ex){
			ex.printStackTrace();
		}finally{
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		desconectar();
		return listaNomRazonCompleto;
		
	}
	
	
	
	//Recuperando Contraseña  por medio de RFC (esto se omite por el momento)
	/*public static LinkedList<usuarioBean> getPassword(String rfccorto)throws SQLException, ServletException{		
	if(!estoyConectado()){
			conectado();
		}
		LinkedList<usuarioBean> obtenPass= new LinkedList<usuarioBean>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			
			pstmt=conn.prepareStatement("select usuarios.contrasena from usuarios where rfccorto= ?");
			pstmt.setString(1,rfccorto.trim().toUpperCase());
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				
				usuarioBean uB = new usuarioBean();
				
				uB.setContrasena(rs.getString(1));
				
				
				obtenPass.add(uB);	
				
			}
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
		}
		desconectar();
		
		return obtenPass;
	}
	*/
	public static LinkedList<usuarioBean> getLogin(String usuario, String pass) throws SQLException, ServletException{
		
		if(!estoyConectado()){conectado();}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LinkedList<usuarioBean> Login= new LinkedList<usuarioBean>();
		try{
                                           
                                             //query cuando la tabla usuarios tenga la función de pgcrypto
                                             //"select usuario.usuario,usuario.contrasena from usuarios where usuario= ? and pgp_sym_decrypt(usuarios.contrasena, 'pass')=?) 
		pstmt=conn.prepareStatement("select usuarios.usuario,usuarios.contrasena from usuarios where usuario= ? and pgp_sym_decrypt(usuarios.contrasena, 'pass') = ?");
		pstmt.setString(1, usuario.trim().toUpperCase());
		pstmt.setString(2, pass.trim().toUpperCase());
		rs=pstmt.executeQuery();
		while(rs.next()){
			usuarioBean uB = new usuarioBean();
			
			
                        uB.setUsuario(rs.getString(1));
			uB.setContrasena(rs.getString(2));
			
			
			Login.add(uB);	
			
		}
		}catch(Exception ex){ex.printStackTrace();}
		finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
			
		}
		
		desconectar();
		return Login;
	}
	
	
	
	
//REGISTRO USUARIOS
	public static boolean Registra(RegBean Rb)throws SQLException, ServletException{
		if(!estoyConectado()){
			conectado();
			}
		
	
		PreparedStatement pstmt=null;
		boolean agregado=false;
		
		try{                                 //query cuando la tabla usuarios tenga la función de pgcrypto
                                                    //INSERT INTO usuarios (usuario,contrasena, rfccorto,administracion, nombre,apellidop,apellidom) VALUES (?,pgp_sym_encrypt(?, 'pass'),?,?,?,?,?)");
			pstmt=conn.prepareStatement("INSERT INTO usuarios (usuario,contrasena,rfccorto,administracion,nombre,apellidop,apellidom) VALUES (?,pgp_sym_encrypt(?, 'pass'),?,?,?,?,?)");
			pstmt.setString(1,Rb.getUsuario().toUpperCase() );
		        pstmt.setString(2,Rb.getContrasena().toUpperCase());
			pstmt.setString(3, Rb.getRfccorto().toUpperCase());
			pstmt.setString(4, Rb.getAdministracion().toUpperCase());
			pstmt.setString(5, Rb.getNombre().toUpperCase());
			pstmt.setString(6, Rb.getApellidop().toUpperCase());
			pstmt.setString(7, Rb.getApellidom().toUpperCase());
			  
			 pstmt.executeUpdate();
			 
			 agregado=true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			agregado=false;
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
		}
		
		desconectar();
		return agregado;
	}
	
	//ELIMINA USUARIO 
    public static boolean EliminaRegistro (String RFCorto)throws SQLException, ServletException{
        if(!estoyConectado()){
            conectado();
        }
        PreparedStatement pstmt=null;
        boolean elimina=false;
        try{
           pstmt=conn.prepareStatement("DELETE FROM usuarios WHERE rfccorto= ?");
            pstmt.setString(1, RFCorto.trim().toUpperCase());
            pstmt.executeUpdate();
            elimina=true;
        }catch(Exception ex){
            ex.printStackTrace();
            elimina=false;
        }finally{
          if(pstmt != null){
          pstmt.close();
          }
        }
        desconectar(); 
        return elimina;
    }
    //BuscaUser
    public static LinkedList<usuarioBean> getConsultaUsuario(String RFCcorto)throws SQLException,ServletException{
    if(!estoyConectado()){
    conectado();
    }
    PreparedStatement pstmt=null;
    ResultSet rs= null;
    LinkedList <usuarioBean> buscaUser = new LinkedList<usuarioBean>();
   
    try{
        pstmt=conn.prepareStatement("SELECT  usuario,contrasena,rfccorto,nombre,apellidop,apellidom,administracion FROM usuarios WHERE rfccorto=?");
        pstmt.setString(1, RFCcorto.trim().toUpperCase());
        rs=pstmt.executeQuery();
        while(rs.next()){
        	usuarioBean ub = new usuarioBean();
        	
        	ub.setUsuario(rs.getString(1));
        	ub.setContrasena(rs.getString(2));
        	ub.setRfccorto(rs.getString(3));
        	ub.setNombre(rs.getString(4));
        	ub.setApellidop(rs.getString(5));
        	ub.setApellidom(rs.getString(6));
        	ub.setAdministracion(rs.getString(7));
        	
        	buscaUser.add(ub);
        }
    }catch(Exception ex){
    ex.printStackTrace();
  
    }
    finally{
    if(pstmt != null){
        pstmt.close();
    }
    if(rs != null){
    	rs.close();
    }
    }
    desconectar();
    return buscaUser;
    }
        ///UPDATE USER
    public static boolean getUpdateUser(RegBean us)throws SQLException, ServletException{
    	if(!estoyConectado()){
    		conectado();
    	}
    	PreparedStatement pstmt2= null;
        ResultSet rs2=null;
        boolean listo=false;
        
        try{
        	pstmt2= conn.prepareStatement("UPDATE  usuarios  SET usuario = ?, contrasena = pgp_sym_encrypt(?, 'pass'), rfccorto=?, administracion=?, nombre=?, apellidoP=?, apellidoM=? where rfccorto=? ");
        	pstmt2.setString(1,us.getUsuario().trim().toUpperCase());
        	pstmt2.setString(2, us.getContrasena().trim().toUpperCase());
        	pstmt2.setString(3, us.getRfccorto().trim().toUpperCase());
        	pstmt2.setString(4, us.getAdministracion().trim().toUpperCase());
        	pstmt2.setString(5, us.getNombre().trim().toUpperCase());
        	pstmt2.setString(6, us.getApellidop().trim().toUpperCase());
        	pstmt2.setString(7, us.getApellidom().trim().toUpperCase());
        	
        	pstmt2.setString(8, us.getRfccorto().trim().toUpperCase());
        	
        	pstmt2.executeUpdate();
        	listo=true;
        	
        }catch(Exception ex){
        	ex.printStackTrace();
        	listo=false;
        }
        if(pstmt2 != null){
        	pstmt2.close();
        }
    	desconectar();
    	return listo;
    }
    
    
    
        //CONSULTA orden
	public static LinkedList<siscoBean> getOrden(String orden)throws SQLException, ServletException{		
		if(!estoyConectado()){
			conectado();
		}
		LinkedList<siscoBean> listaOrden= new LinkedList<siscoBean>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			
			pstmt=conn.prepareStatement("SELECT orden,rfc,nom_razon,to_char(fech_emi, 'DD-MM-YYYY'),origen,ejer_de, ejer_a,objetivo,id_program,id_a_prog FROM Vista_Registros WHERE orden= ?"); //orden
			pstmt.setString(1,orden.trim().toUpperCase() );                   
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				
				siscoBean sB = new siscoBean();
				
                                sB.setOrden(rs.getString(1));
                                sB.setRfc(rs.getString(2));
                                sB.setNom_razon(rs.getString(3));
                                sB.setFech_emi(rs.getString(4));
                                sB.setOrigen(rs.getString(5));
                                sB.setEjer_de(rs.getString(6));
                                sB.setEjer_a(rs.getString(7));
                                sB.setObjetivo(rs.getString(8));
                                sB.setId_program(rs.getString(9));
                                sB.setId_a_prog(rs.getString(10));
                                
				listaOrden.add(sB);	
				
			}
		}finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
		}
		desconectar();
		
		return listaOrden;
	}
        
        //admin
        public static LinkedList<usuarioBean> getLoginAdmin(String usuario, String pass)throws SQLException,ServletException{
		if(!estoyConectado()){conectado();}
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		LinkedList<usuarioBean> LoginAdmin= new LinkedList<usuarioBean>();
                                                     //query cuando la tabla usuarios tenga la función de pgcrypto
		try{                                //"select id from usuarios where usuario= ? and pgp_sym_decrypt(usuarios.contrasena, 'pass') = ?"
			pstmt=conn.prepareStatement("select id from usuarios where usuarios.usuario= ? and pgp_sym_decrypt(usuarios.contrasena, 'pass') = ?");
			pstmt.setString(1, usuario.trim().toUpperCase());
			pstmt.setString(2, pass.trim().toUpperCase());
			rs=pstmt.executeQuery();
			while(rs.next()){
				usuarioBean ub= new usuarioBean();
				
				ub.setId(rs.getInt(1));
				LoginAdmin.add(ub);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
			desconectar();
			return LoginAdmin;
		}
	}
	
}
