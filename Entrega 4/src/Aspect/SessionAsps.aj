package Aspect;

public aspect SessionAsps {
	pointcut callSessionAspectPointCut() :
        call(String model.Sessao.getChaveSessao());
	
	pointcut callSessionAspectPointCut2() :
		call(void model.Sessao.classificaSessao(*));
	

	pointcut callSessionAspectPointCut3() :
		call(void model.Sessao.finalizaSessao(*));

	before(): callSessionAspectPointCut() {
		System.out.println("A chave de sessão é :");
	}
	
	String around() : callSessionAspectPointCut() {		
		String s = proceed();
		return s + "m4c4C0";
	}
	
	
	before() : callSessionAspectPointCut2() {
		System.out.println("O estado da sessao atual é: ");
		
	}
	
	before() : callSessionAspectPointCut3() {
		System.out.println("Finalizando Sessao: ");
	}
	
	after() : callSessionAspectPointCut3() {
		System.out.println("Sessao finalizada com sucesso!");
	}
	
	
}
