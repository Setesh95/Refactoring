public class Vehicle{
	private String modelo;
	private String marca;
	private String categoria;

	public Vehicle(String modelo,String marca,String categoria){
		this.modelo = modelo;
		this.marca = marca;
		this.categoria = categoria;
	}
	
	public String getModelo(){
		return this.modelo;
	}

	public String getMarca(){
		return this.marca;
	}

	public String getCategoria(){
		return this.categoria;
	}
	
	public void setModelo(String modelo){
		this.modelo = modelo;
	}

	public void setMarca(String marca){
		this.marca = marca;
	}

	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
}
