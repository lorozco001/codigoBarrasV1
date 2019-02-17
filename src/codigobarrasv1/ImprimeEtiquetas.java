/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoBarrasV1;

import java.io.ByteArrayInputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author loroz
 */
public class ImprimeEtiquetas {

    static String plantillaEtiqueta;
   // static Logger _logger = Logger.getLogger(ImprimeEtiquetas.class); 
    
    public static void imprimeEtiqueta(String ubicacion) throws Exception {

		// todo lo necesario para imprimir
		// FileReader archivoPlantilla;
		// String plantilla;
		String etiqueta;
		PrintService service;
		DocPrintJob job;
		Doc doc;
                
               /* FileReader lector = new FileReader("pruebaEtiquetas.prn");
                BufferedReader BR =new BufferedReader(lector);
               //String texto;
                String temp="";
                String bfRead;
                while((bfRead=BR.readLine())!=null){
                    temp =temp+bfRead+"/n";
                }
                //texto=temp;
                plantillaEtiqueta=temp;
               */
              plantillaEtiqueta="<xpml><page quantity='0' pitch='7.1 mm'></xpml>I8,1,001\n" +
"q413\n" +
"OD,N\n" +
"JF\n" +
"j136\n" +
"WN\n" +
"ZT\n" +
"Q57,25\n" +
"<xpml></page></xpml><xpml><page quantity='1' pitch='7.1 mm'></xpml>N\n" +
"A69,22,2,1,1,1,N,\"UNAM\"\n" +
"A77,45,2,3,1,1,N,\"DGAC\"\n" +
"B320,47,2,1C,4,8,21,N,\"%s\"\n" +
"A230,22,2,2,1,1,N,\"%s\"\n" +
"A374,44,2,4,1,1,N,\"X\"\n" +
"P1\n" +
"<xpml></page></xpml><xpml><end/></xpml>";
              
             
                        // DocFlavor[] sabores;

		try {
			// cargo la plantilla e inserto la ubicaci—n a imprimir
			// _logger.debug("Cargando rutas");
			// properties.load(ReimprimeEtiquetas.class.getClassLoader().getResourceAsStream("Rutas.properties"));
			// _logger.debug("Leyendo archivo " +
			// properties.getProperty("ruta.plantilla"));
			// plantilla = leeArchivo(properties.getProperty("ruta.plantilla"));
			// _logger.debug(plantilla);

			
                        System.out.println(ubicacion);
			etiqueta = String.format(plantillaEtiqueta, ubicacion, ubicacion);
			                 System.out.println(etiqueta);
			// _logger.debug(etiqueta);
			// archivoPlantilla = new
			// FileReader(properties.getProperty("ruta.plantilla"));
			// _logger.debug("insertando ubicaci—n");
			// etiqueta = String.format(archivoPlantilla.toString(), ubicacion);

			// preparo el trabajo de impresi—n
			System.out.println("iniciando impresi—n");
			service = PrintServiceLookup.lookupDefaultPrintService();
			// sabores = service.getSupportedDocFlavors();
			// for (int i = 0; i < sabores.length; i++) {
			// _logger.debug(sabores[i].getMimeType());
			// }
			job = service.createPrintJob();
			                 System.out.println(job.getAttributes());

			// preparo el documento...
			System.out.println("preparando documento");
			doc = new SimpleDoc(new ByteArrayInputStream(etiqueta.getBytes()),
					DocFlavor.INPUT_STREAM.AUTOSENSE, null);
			// doc = new SimpleDoc(etiqueta, DocFlavor.STRING.TEXT_PLAIN, null);

			// e imprimo
			System.out.println("imprimiendo");
			job.print(doc, null);

			// y terminamos...
			// System.out.println("Se imprimi— etiqueta " + ubicacion);
			System.out.println("Se imprimi— etiqueta " + ubicacion);

		} catch (PrintException e) {
			System.out.println(e);
		}
		
		

	} // imprimeEtiqueta
    
}
