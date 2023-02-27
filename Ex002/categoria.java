package Ex002;

public class categoria {

		private String nomeCat;
		private String idCategoria;
		
		public categoria(String nomeCat, String idCategoria) {
			super();
			this.setNomeCat(nomeCat);
			this.setIdCategoria(idCategoria);
		}

		public String getNomeCat() {
			return nomeCat;
		}

		public void setNomeCat(String nomeCat) {
			this.nomeCat = nomeCat;
		}

		public String getIdCategoria() {
			return idCategoria;
		}

		public void setIdCategoria(String idCategoria) {
			this.idCategoria = idCategoria;
		}
		
	
}
