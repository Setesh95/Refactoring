public class Vehicle{
	private String modelo;
	private String marca;
	private int categoria;
	public static final int BASIC=1;
	public static final int GENERAL=2;
	public static final int LUXE=3;

	public Vehicle(String modelo,String marca,int categoria){
		this.modelo = modelo;
		this.marca = marca;
		this.categoria = categoria;
	}
	
	public String getModel(){
		return this.modelo;
	}

	public String getMarca(){
		return this.marca;
	}

	public int getCategoria(){
		return this.categoria;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

	public String toString(){
		return this.marca+" "+this.modelo;
	}
}
