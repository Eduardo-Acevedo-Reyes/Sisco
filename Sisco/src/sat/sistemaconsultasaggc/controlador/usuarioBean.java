package sat.sistemaconsultasaggc.controlador;

public class usuarioBean {

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getRfccorto() {
		return rfccorto;
	}
	public void setRfccorto(String rfccorto) {
		this.rfccorto = rfccorto;
	}
	public String getAdministracion() {
		return administracion;
	}
	public void setAdministracion(String administracion) {
		this.administracion = administracion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidop() {
		return apellidop;
	}
	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}
	public String getApellidom() {
		return apellidom;
	}
	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}
        

        public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}

	private String usuario;
	private String contrasena;
	private String rfccorto;
	private String administracion;
	private String nombre;
	private String apellidop;
	private String apellidom;
        private int id;
	
	/*public usuarioBean(String  user, String pass){
		super();
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.rfccorto=rfccorto;
		this.administracion=administracion;
		this.nombre=nombre;
		this.apellidop=apellidop;
		this.apellidom=apellidom;
		
	}*/
	
}
