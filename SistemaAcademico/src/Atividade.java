public class Atividade {
	private static final int MAX_VALOR = 30;
	// private static final int MAX_SOMA = 100; //Onde calcular maximo da
	// disciplina?
	private int valor;
	private double nota;

	public Atividade(int valor) throws Exception {
		if (valor > MAX_VALOR || valor < 0) {
			throw new Exception("Nota inválida");
		}
		this.setValor(valor);
		this.nota = 0;

	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if (valor >= 1 && valor <= MAX_VALOR)
			;
		this.valor = valor;
	}

	public double getNota() {
		return nota;
	}

	public void lancarNota(double nota) {
		if (nota >= 0 && nota <= this.valor)
			;
		this.nota = nota;
	}

}
