package sat.sistemaconsultasaggc.controlador;

public class siscoBean {

	
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getNom_razon() {
		return nom_razon;
	}
	public void setNom_razon(String nom_razon) {
		this.nom_razon = nom_razon;
	}
	public String getFech_emi() {
		return fech_emi;
	}
	public void setFech_emi(String fech_emi) {
		this.fech_emi = fech_emi;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getEjer_de() {
		return ejer_de;
	}
	public void setEjer_de(String ejer_de) {
		this.ejer_de = ejer_de;
	}
	public String getEjer_a() {
		return ejer_a;
	}
	public void setEjer_a(String ejer_a) {
		this.ejer_a = ejer_a;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getId_program() {
		return id_program;
	}
	public void setId_program(String id_program) {
		this.id_program = id_program;
	}
	public String getId_a_prog() {
		return id_a_prog;
	}
	public void setId_a_prog(String id_a_prog) {
		this.id_a_prog = id_a_prog;
	}
	
	private String orden;
	private String rfc;
	private String nom_razon;
	private String fech_emi; //pr
	private String origen;
	private String ejer_de; //double
	private String ejer_a; // double
	private String objetivo;
	private String id_program;
	private String  id_a_prog;

	
	/*public siscoBean( String orden, String rfc, String nom_razon,String fech_emi,String origen, String ejer_de, String ejer_a,String objetivo,String id_program, String  id_a_prog){
		super();
		this.ejer_a=ejer_a;
		this.ejer_de=ejer_a;
		this.fech_emi=fech_emi;
		this.id_a_prog=id_a_prog;
		this.id_program=id_program;
		this.nom_razon=nom_razon;
		this.objetivo=objetivo;
		this.orden=orden;
		this.origen=origen;
		this.rfc=rfc;
		
		
		
	}*/
	
}
