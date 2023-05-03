package Main;

public static void main(String[] args) {
    // Criar os objetos dos controllers
    CachorroController cachorroController = new CachorroController();
    GatoController gatoController = new GatoController();
    PassaroController passaroController = new PassaroController();
    ProprietarioController proprietarioController = new ProprietarioController();
    RelacaoAnimalProprietarioController relacaoController = new RelacaoAnimalProprietarioController();

    // Criar objeto da classe PetShopView e passar os controllers como parâmetro
    PetShopView petShopView = new PetShopView(cachorroController, gatoController, passaroController,
            proprietarioController, relacaoController);

    // Exibir o menu principal
    petShopView.mostrarMenu();
}

