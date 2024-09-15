package Model;
import Model.Cargo;

public class Funcionario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private Enum cargo;
    private boolean isAdmin;

    public Funcionario (int id, String nome, boolean isAdmin, String cargo){
        this.id = id;
        this.nome = nome;
        this.isAdmin = isAdmin;
        this.cargo = Cargo.setCargo(cargo);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    //To remove only for tests
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Enum getCargo() {
        return this.cargo;
    }

    public String getCargoDescricao(){
        Cargo c = (Cargo) this.cargo;
        return c.getDescricaoEnumCargo(this.cargo);
    }

    public void setCargo(String cargo) {
        this.cargo = Cargo.setCargo(cargo);
    }
}
