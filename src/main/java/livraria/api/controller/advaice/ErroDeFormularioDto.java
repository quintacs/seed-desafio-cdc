package livraria.api.controller.advaice;

public class ErroDeFormularioDto extends Exception{
	
	
	private static final long serialVersionUID = 1L;
	private String campo;
	private String erro;
	

	//public ErroDeFormularioDto() {}

	public ErroDeFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
