/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesMatematica;

import static Bancaria.Matematica.InfoClientes;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import javax.persistence.Tuple;


public class Calculando {
    

    public static DecimalFormat dff = new DecimalFormat("0.000");
    
    
       
    
    
    
    
        public static ArrayList<VendaDia> ArrumarDados(ArrayList<Integer> xiBaguncado ) throws Exception{        
            //Arrumar o xi e ni
            ArrayList<Integer> xi = new ArrayList<Integer>();
            ArrayList<Integer> ni = new ArrayList<Integer>();   
          //  ArrayList<Integer> porcentagem = new ArrayList<Integer>();    
            ArrayList<VendaDia> resultado = new ArrayList<VendaDia>();
            double niTotal = 0.0;
            double nixiTotal = 0.0;
           
            
            //
           /////Coloca meus dados de xiBagunçado e remove os repetidos e joga dentro de xi
            HashSet<Integer> hashSet = new HashSet<Integer>(xiBaguncado);  
            xi.addAll(hashSet);
            
            

            //atribui os valores de ni ao ArrayNi
            
            for (int i = 0; i < xi.size(); i++) {
                Integer contar = 0;
                for (int j = 0; j < xiBaguncado.size(); j++) {
                    if (xi.get(i).equals(xiBaguncado.get(j))) {
                        contar++;
                    }
                }
                ni.add(i, contar);
                
            }
            
            
             
            

            
            //For para calcular o valor total de ni e de ni.xi
            
            for (int i = 0; i < ni.size(); i++) {
                niTotal = ni.get(i) + niTotal;
                
                nixiTotal = nixiTotal + (xi.get(i) * ni.get(i));

            }
            
            System.out.println("NiTotal: "+ niTotal);
            System.out.println("ni.xi Total ="+nixiTotal);
            
            Double valorMedia = nixiTotal / xiBaguncado.size();
            
            System.out.println("Media "+ valorMedia);
            
           
            
            
            //Jogar os valores até então dentro do arrey de VendasDia
            
            for (int i = 0; i < xi.size(); i++) {
                VendaDia v = new VendaDia();
                v.setXi(xi.get(i));
                v.setNi(ni.get(i));
                v.setNixi(xi.get(i) * ni.get(i));
                
                double porcentagem = (ni.get(i) / niTotal) * 100;
                DecimalFormat df = new DecimalFormat("0.##");
                String dx = df.format(porcentagem);
                System.out.println("porcentagem "+ dx);
                dx = dx.replaceAll(",", ".");
               
                 System.out.println("porcentagem "+ dx);
                Double percent = Double.parseDouble(dx);
                
                v.setPorcentagem(percent);
                
                
                double contaDoida = Math.pow(xi.get(i) - valorMedia, 2) * ni.get(i);
                String contaDoida2 = df.format(contaDoida);
                contaDoida2 = contaDoida2.replaceAll(",", ".");
                double conta = Double.parseDouble(contaDoida2);
                

                
                v.setConta(conta);
                
                
                System.out.println("xi :" + v.getXi());
                System.out.println("ni :"+ v.getNi());
                System.out.println("ni.xi :"+ v.getNixi());
                System.out.println("porcentagem :"+ v.getPorcentagem());
                System.out.println("(x-X)^2 * ni :"+ v.getConta());
                System.out.println(" ");
                
                resultado.add(v);
                
            }

            return resultado;
        }
        
        
        
        
        public static ArrayList<ValorVendaDia> criarClasses(ArrayList<Double> valores){
            ArrayList<ValorVendaDia> resultado = new ArrayList<>();
            
            Double menorValor = valores.get(0);
            int posicaoMaiorValor = valores.size()- 1;
            Double maiorValor = valores.get(posicaoMaiorValor);
            menorValor = Math.ceil(menorValor);
            maiorValor = Math.ceil(maiorValor);
            Double quantidadeClasses = Math.sqrt(valores.size());
            quantidadeClasses = Math.floor(quantidadeClasses);
            System.out.println("Numero de classes sem filtro com arredondação: "+ quantidadeClasses);
            System.out.println("NUmero de elementos: " + valores.size());
            
            if (quantidadeClasses > 15) {
                quantidadeClasses = 10.0;
            }
            if (quantidadeClasses <= 5) {
                quantidadeClasses = 10.0;
            }
            
            System.out.println("Numero de classes com filtro: "+ quantidadeClasses);
            
            Double amplitude = (maiorValor - menorValor) / quantidadeClasses;
            System.out.println("esse é o menor valor"+ menorValor +"  o maior "+ maiorValor);
            System.out.println("a amplitude : " + amplitude);
            
            DecimalFormat df = new DecimalFormat("0.00");

            Double ClasseInicial = menorValor;
            Double ClasseFinal = menorValor + amplitude;
           
            
            int niTotal = valores.size();
            
            Double Media = 0.0;
            Double xiniTotal = 0.0;
  
            Double ContaParaVariancia = 0.0;
           
            

            //Gerando o meu array resultado
            
            for (int i = 0; i < quantidadeClasses; i++) {
                ValorVendaDia classe = new ValorVendaDia();
                DecimalFormat model = new DecimalFormat("0.00");
                String classeinicial = model.format(ClasseInicial);
                classeinicial = classeinicial.replaceAll(",", ".");
                String classefinal = model.format(ClasseFinal);
                classefinal = classefinal.replaceAll(",", ".");
                ClasseInicial = Double.parseDouble(classeinicial);
                ClasseFinal = Double.parseDouble(classefinal);
                
                
                String intervaloclasse = ClasseInicial + " |--- "+ ClasseFinal;
                System.out.println(intervaloclasse);

                classe.setClasses(intervaloclasse);
                
                Double xiClasse = (ClasseInicial + ClasseFinal)/ 2;
                
                String c = dff.format(xiClasse);
                c = c.replaceAll(",", ".");
                xiClasse = Double.parseDouble(c);
                classe.setXiClasses(xiClasse);
                int contadorNI = 0;
                
                for (int j = 0; j < valores.size(); j++) {
                    if (valores.get(j) >= ClasseInicial && valores.get(j) < ClasseFinal) {
                        contadorNI++;
                    }
                    if (valores.size() - 1 == j && valores.get(j) >= ClasseInicial && valores.get(j) <= ClasseFinal ) {
                        contadorNI++;
                    }
                }
                
                classe.setNiClasses(contadorNI);
                
                classe.setXiniClasses(classe.getXiClasses() * classe.getNiClasses());
                
                double porcentagem = ((double)contadorNI / (double)niTotal) * 100;
                
                String h = dff.format(porcentagem);
                h = h.replaceAll(",", ".");
                porcentagem = Double.parseDouble(h);
                classe.setPorcentagemClasses(porcentagem);
                
                resultado.add(classe);

                ClasseInicial = ClasseInicial + amplitude;
                ClasseFinal = ClasseFinal + amplitude;
            }
            
                //Calcular o xiniTotal
            for (int i = 0; i < resultado.size(); i++) {
                xiniTotal = xiniTotal + resultado.get(i).getXiniClasses();                   
            }
            String a = dff.format(xiniTotal);
            a = a.replaceAll(",", ".");
            xiniTotal = Double.parseDouble(a);
            System.out.println("xiniTotal : " + xiniTotal);
            Media = (double)xiniTotal / (double)niTotal;
            String b = dff.format(Media);
            b = b.replaceAll(",", ".");
            Media = Double.parseDouble(b);
            System.out.println("Essa é a mediaaa " + Media);
            
            
            //ADICIONAR O CAMPO CONTA AO ARRAY
            
            for (int i = 0; i < resultado.size(); i++) {
                double valor = resultado.get(i).xiClasses - Media;
                System.out.println("rsse valor ridiculo " + valor);
                String f = dff.format(valor);
                f = f.replaceAll(",", ".");
                valor = Double.parseDouble(f);
                
                double conta = valor * valor * resultado.get(i).niClasses;
                
                String d = dff.format(conta);
                d = d.replaceAll(",", ".");
                conta = Double.parseDouble(d);
                System.out.println("Contaaaaaaaaa" + conta);
                
                
                ContaParaVariancia = ContaParaVariancia + (double)conta;
                String e = dff.format(ContaParaVariancia);
                e = e.replaceAll(",", ".");
                ContaParaVariancia = Double.parseDouble(e);
                
                
                resultado.get(i).setContaClasses(conta);
                
                System.out.println("(x-X^2) == "+  conta);
                
            }
            System.out.println("contgaTotal = " + ContaParaVariancia);
            
            
            
            return resultado;
            
        }
        
        
        public static ArrayList<String>  pegarStringClientes(java.util.Date datainico, java.util.Date datafim) throws Exception{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String dataInicio = df.format(datainico);
            String dataFim = df.format(datafim); 
            ArrayList<String> resultado = new ArrayList<>();
            int maiorQuantidad= 0;
            double maiorValor = 0.0;
            String infoMaiorQuantidade ="";
            String infoMaiorValor = "";
            ArrayList<RelatorioClientes> dados = InfoClientes(datainico, datafim);
            for (int i = 0; i < dados.size(); i++) {
                if (dados.get(i).getCount() > maiorQuantidad) {
                    maiorQuantidad = dados.get(i).getCount();
                    infoMaiorQuantidade = "O Cliente que realizou o maior número de compras foi "+ dados.get(i).getNome_clientes() + " com um total de "+ maiorQuantidad + " compras.";
                }
                 if (dados.get(i).getSum() > maiorValor) {
                    maiorValor = dados.get(i).getSum();
                    infoMaiorValor = "O Cliente que mais gastou foi "+ dados.get(i).getNome_clientes() + " com um total de "+ maiorValor + " reais.";
                } 
            }
            resultado.add(infoMaiorQuantidade);
            resultado.add(infoMaiorValor);
            
            
            return resultado;
        }
        
        //aqui
        
        
        ///Copiei o metodo já existente , para poder retornar valores diferentes do anterior(Gambiarra)
            public static DadosEstatisticos MetodoContas(ArrayList<Double> valores,  ArrayList<ValorVendaDia> arrayvaloradia){
                
           
            DadosEstatisticos dados = new DadosEstatisticos();
            
            //Calcular Moda
            int qtdModa = 0;
            String moda = "";
            int maiorQtd =0;
                for (int i = 0; i < arrayvaloradia.size(); i++) {
                    if (arrayvaloradia.get(i).getNiClasses() > maiorQtd) {
                        maiorQtd = arrayvaloradia.get(i).getNiClasses();
                       
                        //moda = String.valueOf(arrayvaloradia.get(i).getXiClasses())+ " ,";
                    }
                }
                System.out.println("Maior" + maiorQtd);
                for (int i = 0; i < arrayvaloradia.size(); i++) {
                    if (arrayvaloradia.get(i).getNiClasses() == maiorQtd) {
                       qtdModa++;
                       moda = String.valueOf(arrayvaloradia.get(i).getXiClasses())+ " ;"; 
                    }
                }
                if (qtdModa == 1) {
                    moda = "Unimodal = " + moda;
                }
                if (qtdModa == 2) {
                    moda = "Bimodal = " + moda;
                }
                if (qtdModa >= 3 && qtdModa < arrayvaloradia.size()) {
                    moda = "Multimodal = " + moda;
                }
                if (qtdModa >= arrayvaloradia.size()) {
                    moda = "Não tem moda.";
                }
                dados.setModa(moda);
                
                //Mediana
                double mediana = 0.0;
                
                int tamanho = arrayvaloradia.size();
                if (tamanho % 2 == 0) {
                    int posicao = tamanho / 2;
                    mediana = (arrayvaloradia.get(posicao).getXiClasses() + arrayvaloradia.get(posicao+1 ).getXiClasses()) / 2;  
                } else {
                    int posicao = ((tamanho - 1) / 2)+1;
                    mediana = arrayvaloradia.get(posicao).getXiClasses();
                }
                dados.setMediana(String.valueOf(mediana));
            
            
            
            
            
            ArrayList<ValorVendaDia> resultado = new ArrayList<>();
            
            Double menorValor = valores.get(0);
            int posicaoMaiorValor = valores.size()- 1;
            Double maiorValor = valores.get(posicaoMaiorValor);
            menorValor = Math.ceil(menorValor);
            maiorValor = Math.ceil(maiorValor);
            Double quantidadeClasses = Math.sqrt(valores.size());
            quantidadeClasses = Math.floor(quantidadeClasses);
            System.out.println("Numero de classes sem filtro com arredondação: "+ quantidadeClasses);
            System.out.println("NUmero de elementos: " + valores.size());
            
            if (quantidadeClasses > 15) {
                quantidadeClasses = 10.0;
            }
            if (quantidadeClasses <= 5) {
                quantidadeClasses = 10.0;
            }
            
            System.out.println("Numero de classes com filtro: "+ quantidadeClasses);
            
            Double amplitude = (maiorValor - menorValor) / quantidadeClasses;
            System.out.println("esse é o menor valor"+ menorValor +"  o maior "+ maiorValor);
            System.out.println("a amplitude : " + amplitude);
            
            DecimalFormat df = new DecimalFormat("0.00");

            Double ClasseInicial = menorValor;
            Double ClasseFinal = menorValor + amplitude;
           
            
            int niTotal = valores.size();
            
            Double Media = 0.0;
            Double xiniTotal = 0.0;
            Double ContaParaVariancia = 0.0;
           
            

            //Gerando o meu array resultado
            
            for (int i = 0; i < quantidadeClasses; i++) {
                ValorVendaDia classe = new ValorVendaDia();
                DecimalFormat model = new DecimalFormat("0.00");
                String classeinicial = model.format(ClasseInicial);
                classeinicial = classeinicial.replaceAll(",", ".");
                String classefinal = model.format(ClasseFinal);
                classefinal = classefinal.replaceAll(",", ".");
                ClasseInicial = Double.parseDouble(classeinicial);
                ClasseFinal = Double.parseDouble(classefinal);
                
                
                String intervaloclasse = ClasseInicial + " |--- "+ ClasseFinal;
                System.out.println(intervaloclasse);
                
                classe.setClasses(intervaloclasse);
                
                Double xiClasse = (ClasseInicial + ClasseFinal)/ 2;
                
                String c = dff.format(xiClasse);
                c = c.replaceAll(",", ".");
                xiClasse = Double.parseDouble(c);
                classe.setXiClasses(xiClasse);
                int contadorNI = 0;
                
                for (int j = 0; j < valores.size(); j++) {
                    if (valores.get(j) >= ClasseInicial && valores.get(j) < ClasseFinal) {
                        contadorNI++;
                    }
                    if (valores.size() - 1 == j && valores.get(j) >= ClasseInicial && valores.get(j) <= ClasseFinal ) {
                        contadorNI++;
                    }
                }
                
                classe.setNiClasses(contadorNI);
                
                classe.setXiniClasses(classe.getXiClasses() * classe.getNiClasses());
                
                double porcentagem = ((double)contadorNI / (double)niTotal) * 100;
                 String h = dff.format(porcentagem);
            h = h.replaceAll(",", ".");
            porcentagem = Double.parseDouble(h);
                
                
                classe.setPorcentagemClasses(porcentagem);
                
                resultado.add(classe);

                ClasseInicial = ClasseInicial + amplitude;
                ClasseFinal = ClasseFinal + amplitude;
            }
            
                //Calcular o xiniTotal
            for (int i = 0; i < resultado.size(); i++) {
                xiniTotal = xiniTotal + resultado.get(i).getXiniClasses();                   
            }
             String a = dff.format(xiniTotal);
            a = a.replaceAll(",", ".");
            xiniTotal = Double.parseDouble(a);
            
            
            System.out.println("xiniTotal : " + xiniTotal);
            Media = (double)xiniTotal / (double)niTotal;
                        String b = dff.format(Media);
            b = b.replaceAll(",", ".");
            Media = Double.parseDouble(b);
            
            dados.setMedia(String.valueOf(Media));
            
            
            System.out.println("Essa é a mediaaa " + Media);
            
            
            //ADICIONAR O CAMPO CONTA AO ARRAY
            
            for (int i = 0; i < resultado.size(); i++) {
                
                double valor = resultado.get(i).xiClasses - Media;
                System.out.println("rsse valor ridiculo " + valor);
                String f = dff.format(valor);
                f = f.replaceAll(",", ".");
                valor = Double.parseDouble(f);
                
                double conta = valor * valor * resultado.get(i).niClasses;
                
                String d = dff.format(conta);
                d = d.replaceAll(",", ".");
                conta = Double.parseDouble(d);
                
                ContaParaVariancia = ContaParaVariancia + (double)conta;
                
                resultado.get(i).setContaClasses(conta);
                
                System.out.println("(x-X^2) == "+  conta);
                
            }
            System.out.println("contgaTotal = " + ContaParaVariancia);
            
            dados.setVariancia(String.valueOf(ContaParaVariancia));
            double desvioPadrao = Math.sqrt(ContaParaVariancia);
            
            
            dados.setDesvioPadrao(String.valueOf(desvioPadrao));
            System.out.println("desvio" + desvioPadrao);
                
            
            
            
            return dados;
            
        }
        

                
                
              
        
        
        
    
    
    //Copia do Metodo Arrumardados, o metodo arrumar dados retorna o objeto vendaDia , esse ira retorna o objeto DadosEstatisticos
     public static DadosEstatisticos ArrumarDadosEstatitiscos(ArrayList<Integer> xiBaguncado ) throws Exception{   
         
            DadosEstatisticos dados = new DadosEstatisticos();
         
            //Arrumar o xi e ni
            ArrayList<Integer> xi = new ArrayList<Integer>();
            ArrayList<Integer> ni = new ArrayList<Integer>();   
          //  ArrayList<Integer> porcentagem = new ArrayList<Integer>();    
            ArrayList<VendaDia> resultado = new ArrayList<VendaDia>();
            double niTotal = 0.0;
            double nixiTotal = 0.0;
           
            
            //
           /////Coloca meus dados de xiBagunçado e remove os repetidos e joga dentro de xi
            HashSet<Integer> hashSet = new HashSet<Integer>(xiBaguncado);  
            xi.addAll(hashSet);
            
            

            //atribui os valores de ni ao ArrayNi
            
            for (int i = 0; i < xi.size(); i++) {
                Integer contar = 0;
                for (int j = 0; j < xiBaguncado.size(); j++) {
                    if (xi.get(i).equals(xiBaguncado.get(j))) {
                        contar++;
                    }
                }
                ni.add(i, contar);
                
            }
            
            //Calcular Moda
            
            	int qtdModa = 0;
		int maiorValor = 0;
                String moda= "";
                for (int i = 0; i < ni.size(); i++) {
			if (ni.get(i) > maiorValor) {
				maiorValor = ni.get(i);
                               
			}
		}
		
                for (int i = 0; i < ni.size(); i++) {
                 
		if (ni.get(i) == maiorValor) {
			qtdModa++;
                        moda = moda + String.valueOf(xi.get(i)) + " ;";
		}             
                }

		if (qtdModa == 1) {
			dados.setModa("Unimodal : " + moda);
		}
		if (qtdModa == 2) {
			dados.setModa("Bimodal : " + moda);
		}
		if (qtdModa >= 3 && qtdModa < xi.size()) {
			dados.setModa("Multimodal " + moda);
		}
		if (qtdModa >= xi.size()) {
			moda = "Não tem moda";
			dados.setModa("Amodal");
		}
            
            dados.setModa(moda);
            
             
            

            
            //For para calcular o valor total de ni e de ni.xi
            
            for (int i = 0; i < ni.size(); i++) {
                niTotal = ni.get(i) + niTotal;
                
                nixiTotal = nixiTotal + (xi.get(i) * ni.get(i));

            }
            
            System.out.println("NiTotal: "+ niTotal);
            System.out.println("ni.xi Total ="+nixiTotal);
            
            Double valorMedia = nixiTotal / xiBaguncado.size();
            String g = dff.format(valorMedia);
            g = g.replaceAll(",", ".");
            dados.setMedia(g);
            
            
            System.out.println("Media aaa"+ valorMedia);
            
           
            
            
            //Jogar os valores até então dentro do arrey de VendasDia
            
             double variancia = 0.0;
            for (int i = 0; i < xi.size(); i++) {
                VendaDia v = new VendaDia();
                v.setXi(xi.get(i));
                v.setNi(ni.get(i));
                v.setNixi(xi.get(i) * ni.get(i));
                
                double porcentagem = (ni.get(i) / niTotal) * 100;
                DecimalFormat df = new DecimalFormat("0.##");
                String dx = df.format(porcentagem);
                System.out.println("porcentagem "+ dx);
                dx = dx.replaceAll(",", ".");
               
                 System.out.println("porcentagem "+ dx);
                Double percent = Double.parseDouble(dx);
                
                v.setPorcentagem(percent);
                
                
                double contaDoida = Math.pow(xi.get(i) - valorMedia, 2) * ni.get(i);
                
                String contaDoida2 = df.format(contaDoida);
                contaDoida2 = contaDoida2.replaceAll(",", ".");
                double conta = Double.parseDouble(contaDoida2);
                variancia = variancia + conta;
                

                
                v.setConta(conta);
                
                
                System.out.println("xi :" + v.getXi());
                System.out.println("ni :"+ v.getNi());
                System.out.println("ni.xi :"+ v.getNixi());
                System.out.println("porcentagem :"+ v.getPorcentagem());
                System.out.println("(x-X)^2 * ni :"+ v.getConta());
                System.out.println(" ");
                
                resultado.add(v);
                
            }
                double mediana = 0.0;
                
                int tamanho = ni.size();
                if (niTotal % 2 == 0) {
                    niTotal = niTotal - 1;
                    Double posicao1 = niTotal / 2;
                    Double local = 0.0;
                    for (int i = 0; i < ni.size(); i++) {
                        local = local + ni.get(i);
                        if ( posicao1 <= local) {
                            if (posicao1 +1 <= local) {
                                 mediana = (xi.get(i) + xi.get(i)) / (double)2; 
                                 break;
                            } else {
                                 mediana = (xi.get(i) + xi.get(i + 1)) / (double)2; 
                                 break;
                            }
                           
                        }
                        
                    }
                    
             
         } else {
                    Double posicao1 = ((niTotal - 1)/ 2) +1;
                    Double local = 0.0;
                    for (int i = 0; i < ni.size(); i++) {
                        local = local + ni.get(i);
                         if (posicao1 <= local) {
                             mediana = xi.get(i);
                             break;
                         }
                    }
         }
                
                
                
                
                

                
                double desvio = Math.sqrt(variancia);
                dados.setMediana(String.valueOf(mediana));
                dados.setVariancia(String.valueOf(variancia));
                dados.setDesvioPadrao(String.valueOf(desvio));

            return dados;
        }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
