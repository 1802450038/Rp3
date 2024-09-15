package Model;

public enum Cargo {
    CAIXA("Caixa"),
    ATENDENTE("Atendente"),
    GERENTE("Gerente"),
    INVALIDO("Invalido");


    private String descricao;

    Cargo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDescricaoCargo(Cargo cargo) {
        return cargo.descricao;
    }

    public String getDescricaoEnumCargo(Enum car) {
        Cargo cargo = Cargo.setCargoEnum(car);
        return cargo.descricao;
    }

    public static Cargo setCargoEnum (Enum car) {
        if (car == CAIXA){
            return CAIXA;
        } else if (car == ATENDENTE) {
            return ATENDENTE;
        } else if (car == GERENTE) {
            return GERENTE;
        } else {
            return INVALIDO;
        }
    }


    public static Cargo setCargo (String valor) {
        if (valor.equals("Caixa")){
            return CAIXA;
        } else if (valor.equals("Atendente")) {
            return ATENDENTE;
        } else if (valor.equals("Gerente")) {
            return GERENTE;
        } else {
            return INVALIDO;
        }
    }

}
