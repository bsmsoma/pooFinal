
public class TesteInstituicao {

    public static void main(String[] args) {
        
    GerenciadorDeInstituicao gerenciador = new GerenciadorDeInstituicao();
    
    String g = gerenciador.cadastrarCurso(101, "POO", 15.5);
    
    
    //System.out.println(g);
       
    //System.out.println(gerenciador.buscarCurso(101));
    
    

    Aluno alun = new AlunoRegular(10, "pedro", "pedrofdd@gmail", 101);
    
    
    
    
    
}
