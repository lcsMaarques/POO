package BD;

import java.util.ArrayList;

import PetShopDB.mvc.models.Animal;
import PetShopDB.mvc.models.PassaroModel;
import PetShopDB.mvc.models.ProprietarioModel;

public class BD {
	
	public static ArrayList<Animal> animais = new ArrayList<>();
	public static ArrayList<ProprietarioModel> proprietarios = new ArrayList<>();
	
	public static boolean existeProprietario(Integer ID) {
		for(ProprietarioModel p : proprietarios) {
			if(ID.equals(p.getID())) return true;
		}
		return false;
	}
	
	public static boolean existeProprietario(String CPF) {
		for(ProprietarioModel p : proprietarios) {
			if(CPF.equals(p.getCpf())) return true;
		}
		return false;
	}
	
	public static boolean existeAnimal(Integer ID) {
		for(Animal a : animais) {
			if(ID.equals(a.getID())) return true;
		}
		return false;
	}
	
	public static boolean existeAnimal(String numeroAnilha) {
		for(Animal a : animais) {
			if(a.getClass().getSimpleName().equals("PassaroModel"))
				if(numeroAnilha.equals(((PassaroModel) a).getNumeroAnilha())) return true;
		}
		return false;
	}

}