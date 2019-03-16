package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChatIntelligence {
	
	public static String returnMessage(String msg) {
		
		if(msg.toLowerCase().contains("nome")){
			String nome = msg.split(" ")[msg.split(" ").length-1];
			List<String> cumprimentos =
						new ArrayList<>(Arrays.asList("Olá "+nome+", como vai?", 
								"Oi "+nome+", tudo bem?", 
								"E ai "+nome+", tudo tranquilo?", 
								"Bom dia "+nome+", tudo bem?", 
								"Boa tarde "+nome+", tudo bem?", 
								"Boa noite "+nome+", tudo bem?"));
			
			return cumprimentos.get((int)Math.random() * cumprimentos.size());
		}
		
		List<String> rCumprimentos =
				new ArrayList<>(Arrays.asList("e voce", "oi", "ola", "tudo", "legal", "otimo", "sem problemas", "boa", "zen", "sussa", "sossegado", 
						"bem", 
						"tranquilo", 
						"ok", 
						"boa tarde", 
						"boa noite",
						"bom dia"));
		
		for (String resposta : rCumprimentos) {
			if(msg.toLowerCase().contains(resposta)) {
				List<String> reCumprimentos =
						new ArrayList<>(Arrays.asList("Que bom que voce esta bem! Eu também estou.", "Que bom, eu tambem.", "Que maravilha, eu tambem;.", "Legal, eu nao.", "Perfeito, eu tambem", "Eu tambem. O dia esta lindo hoje, não?"));
				return reCumprimentos.get((int)Math.random() * reCumprimentos.size());	
			}
		}
		
		
		
		
		
//		List<String> cumprimentos =
//				new ArrayList<>(Arrays.asList("Olá, como vai?", "Oi, tudo bem?", "E ai, tudo tranquilo?", "Bom dia, tudo bem?", "Boa tarde, tudo bem?", "Boa noite, tudo bem"));
//		List<String> rCumprimentos = new ArrayList<>(Arrays.asList("oi", "ola", "tudo bem", "bom dia", "boa tarde", "boa noite"));
//		
//		for (String cumprimento : rCumprimentos) {
//			if(msg.getMessage().contains(cumprimento)) {
//				System.out.println();
//			}
//			
//		}
		return null;
				
	}

}
