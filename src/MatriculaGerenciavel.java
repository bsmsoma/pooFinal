

public interface MatriculaGerenciavel { 
 // Notas: aceitar somente em matricula ATIVA e com valores validos. 
 // Pode ser chamado de novo para corrigir. Retornar sucesso ou motivo. 
 String lancarNotas(double nota1, double nota2); 
 // Faltas: somar a quantidade recebida, se a regra permitir. 
 String registrarFaltas(int quantidade); 
 // Situacao: alterar conforme as regras e retornar sucesso ou motivo. 
 String trancar(); 
 String cancelar(); 
 // Consultas: calcular sem modificar o objeto. 
 double calcularMedia(); 
 String retornarResultado(); 
} 
