import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Municipio {

    private String matricula;
    private String nome;
    private float imposto;
    private int mesAtraso;
    private int municipios;

    //Construtor
    public Municipio() {
    }

    //Get e Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getImposto() {
        return imposto;
    }

    public void setImposto(float imposto) {
        this.imposto = imposto;
    }

    public int getMesAtraso() {
        return mesAtraso;
    }

    public void setMesAtraso(int mesAtraso) {
        this.mesAtraso = mesAtraso;
    }

    public int getMunicipios() {
        return municipios;
    }

    public void setMunicipios(int municipios) {
        this.municipios = municipios;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    //Metodos
    public void entrada() {
        Scanner ler = new Scanner(System.in);

        System.out.print("Insita sua matricula: ");
        matricula = ler.nextLine();

        System.out.print("Insira o seu nome: ");
        nome = ler.nextLine();

        System.out.print("Insira o imposto: ");
        imposto = ler.nextFloat();

        System.out.print("Insira os meses de atraso: ");
        mesAtraso = ler.nextInt();
    }

    public void conta() {
        if (mesAtraso > 0 && mesAtraso <= 5) {
            imposto = (imposto * 0.01f) + imposto;
        } else if (mesAtraso >= 6 && mesAtraso <= 8) {
            imposto = (imposto * 0.023f) + imposto;
        } else if (mesAtraso >= 9 && mesAtraso <= 10) {
            imposto = (imposto * 0.03f) + imposto;
        } else if (mesAtraso >= 11 && mesAtraso <= 12) {
            imposto = (imposto * 0.054f) + imposto;
        } else if (mesAtraso > 12) {
            imposto = (imposto * 0.1f) + imposto;
        }
    }

    public void tudo() {
        Scanner ler = new Scanner(System.in);
        int escolhaDoWhile;
        int escolhaSairUltimoWhile;
        do {

            Map<String, String> Listamat = new HashMap<String, String>();

            do {
                entrada();
                conta();
                Listamat.put(getMatricula(), getNome());

                System.out.println("\nO novo imposto a pagar e: " + getImposto());
                System.out.println("Cadastrado com sucesso!!! \n");

                System.out.println("Deseja cadastrar outro municipio?\n1 - SIM\n2 - NÃO ");
                escolhaDoWhile = ler.nextInt();

            } while (escolhaDoWhile != 2);

            do {
                System.out.println("Digite 1 para listar a matricula e 2 para listar matricula e nome: ");
                int escolha = ler.nextInt();


                if (escolha == 1) {
                    for (String i : Listamat.values()) {
                        System.out.println("\nMatricula e: " + i);
                    }
                } else {
                    for (Map.Entry<String, String> ListaMatNome : Listamat.entrySet()) {
                        System.out.println("\nA matriula  e: " + ListaMatNome.getKey() + "\nO nome e: " + ListaMatNome.getValue() + "\n");
                    }
                }

                System.out.println("DESEJA SAIR DA PARTE DE LISTAR CLIENTES?\n1 - SIM\n2 - NAO");
                escolhaDoWhile = ler.nextInt();

            } while (escolhaDoWhile != 1);
            System.out.println("\nDESEJA SAIR DO PROGRAMA?\n1 - SIM\n2 - NAO");
            escolhaSairUltimoWhile = ler.nextInt();
        }while(escolhaSairUltimoWhile != 1);
    }

    public void status(){
        System.out.println("Nome: " + getNome());
        System.out.println("Novo imposto: " + getImposto());
        System.out.println("Meses de atraso: " + getMesAtraso());
    }

}