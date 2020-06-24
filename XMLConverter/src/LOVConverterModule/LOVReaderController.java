/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOVConverterModule;

import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Matheus
 */
public class LOVReaderController {
    LOVReaderScreen screen;
    
    private String savePath;
    private boolean tryAgain;
    
    public LOVReaderController() {
        //saveOnCSV();
        screen = new LOVReaderScreen();
        screen.setListenerLoadFile(new loadFile());
        screen.setListenerSave(new saveConvertion());
        //saveOnExcel();
        this.savePath = null;
        this.tryAgain = false;
    }
    
    private String chooseObject(){
        screen.setLblLog("Escolha o arquivo desejado...");
        String path = "";
        try{
            //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
            JFileChooser file = new JFileChooser();
            file.setFileSelectionMode(JFileChooser.FILES_ONLY);
            file.setDialogTitle("Selecione o objeto XML");
            file.showOpenDialog(null);
                        
            if(file.getSelectedFile().toString().endsWith(".xml") || file.getSelectedFile().toString().endsWith(".XML")){
                path = file.getSelectedFile().toString();
                System.out.println("Caminho: " + path);
                screen.setTxtPath(path);
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Selecione um arquivo do tipo \".XML\"");
                path = "not_xml";
            }
        } catch(Exception e){
            path = "cancel";
        }
        return path;
    } 
    
    private ArrayList<relLOV> readXML(String path){
        ArrayList<relLOV> result = new ArrayList<>();
        if("".equals(path)){
            path = chooseObject();
        }
        
        try {
            boolean nodeExists = false;
            if(!path.equals("")){
                if(!"cancel".equals(path) && !"not_xml".equals(path)) {
                    screen.setLblLog("Carregando arquivo...");
                    // Creating a constructor of file class and parsing an XML file
                    //System.out.println("caminho: " + path);

                    File file = new File(path);
                    //File file = new File("C:\\Users\\mathe\\Documents\\NetBeansProjects\\XMLReader\\XMLFile.xml");
                    //File file = new File("D:\\Documentos\\Drivers\\Google Drive (Trabalho)\\Documentos\\2. Projetos\\1. TIM\\2. Projetos\\IP19\\Merge\\Siebel Pós-Pago IP13\\3. DPSIEBELPOS00000865\\Objetos\\1. IP13\\2. NREP\\Funcionalidade\\ADM_CRIACAO_TRIPLETA_PROD_FUNC.xml");
                    // An instance of factory that gives a document builder  
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    // An instance of builder to parse the specified xml file  
                    DocumentBuilder db = dbf.newDocumentBuilder();
                    Document doc = db.parse(file);
                    doc.getDocumentElement().normalize();

                    System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
                    NodeList nodeList = doc.getElementsByTagName("List_spcOf_spcValues_spcChild_spc_lprUDA_rpr");

                    // NodeList is not iterable, so we are using for loop
                    for (int itr = 0; itr < nodeList.getLength(); itr++) {
                        nodeExists = true;
                        relLOV rel = new relLOV();
                        Node node = nodeList.item(itr);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement = (Element) node;
                            rel.setTYPE(eElement.getElementsByTagName("Type").item(0).getTextContent());
                            rel.setNAME(eElement.getElementsByTagName("Name").item(0).getTextContent());
                            rel.setVAL(eElement.getElementsByTagName("Value").item(0).getTextContent());
                            rel.setSUB_TYPE(eElement.getElementsByTagName("Sub_spcType").item(0).getTextContent());
                            rel.setORDER_BY(eElement.getElementsByTagName("Order_spcBy").item(0).getTextContent());
                            rel.setLOW(eElement.getElementsByTagName("Low").item(0).getTextContent());
                            rel.setHIGH(eElement.getElementsByTagName("High").item(0).getTextContent());
                            rel.setACTIVE_FLG(eElement.getElementsByTagName("Active").item(0).getTextContent());
                            rel.setTRANSLATE_FLG(eElement.getElementsByTagName("Translate").item(0).getTextContent());
                            rel.setMULTILINGUAL_FLG(eElement.getElementsByTagName("Multilingual").item(0).getTextContent());
                            rel.setRPLCTN_LVL_CD(eElement.getElementsByTagName("Replication_spcLevel").item(0).getTextContent());
                            rel.setTARGET_LOW(eElement.getElementsByTagName("Target_spcLow").item(0).getTextContent());
                            rel.setTARGET_HIGH(eElement.getElementsByTagName("Target_spcHigh").item(0).getTextContent());
                            rel.setLANG_ID(eElement.getElementsByTagName("Language").item(0).getTextContent());
                            rel.setPARENT_LANGUAGE(eElement.getElementsByTagName("Parent_spcLanguage").item(0).getTextContent());
                            rel.setDFLT_LIC_FLG(eElement.getElementsByTagName("Default_spcLIC_spcFlag").item(0).getTextContent());
                            rel.setMODIFIABLE(eElement.getElementsByTagName("Modifiable").item(0).getTextContent());
                            rel.setPARENT_VALUE(eElement.getElementsByTagName("Parent_spcValue").item(0).getTextContent());
                            rel.setPARENT(eElement.getElementsByTagName("Parent").item(0).getTextContent());
                            rel.setPARENT_TYPE(eElement.getElementsByTagName("Parent_spcType").item(0).getTextContent());
                            rel.setCODE(eElement.getElementsByTagName("Class_spcCode").item(0).getTextContent());
                            rel.setPARENT_SUBTYPE(eElement.getElementsByTagName("Parent_spcSub_spcType").item(0).getTextContent());
                            rel.setPARENT_ORGANIZATION(eElement.getElementsByTagName("Parent_spcOrganization").item(0).getTextContent());
                            rel.setFIBER_RELEASE(eElement.getElementsByTagName("Fiber_spcRelease").item(0).getTextContent());
                            rel.setWEIGHTING_FACTOR(eElement.getElementsByTagName("Weighting_spcFactor").item(0).getTextContent());
                            rel.setORGANIZATION(eElement.getElementsByTagName("Organization").item(0).getTextContent());
                            rel.setDESC_TEXT(eElement.getElementsByTagName("Description").item(0).getTextContent());

                            // IDIOMA
                            rel.setLANGUAGE_CODE(eElement.getElementsByTagName("Language_spcCode").item(0).getTextContent());
                            rel.setLANGUAGE_NAME(eElement.getElementsByTagName("Language_spcName").item(0).getTextContent());
                        }
                        result.add(rel);
                    }
                    System.out.println("Total de Objetos: " + nodeList.getLength());

                    if(nodeExists == false){
                        String[] options = {"Sim", "Não"};
                        int x = JOptionPane.showOptionDialog(null, "O Arquivo encontrado não é um XML de LOV. Deseja selecionar outro arquivo?", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        if(x==0){
                            tryAgain = true;
                        } else {
                            tryAgain = false;
                        }
                    }
                }                
            } else {
                readXML("");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    // Function to show the comparizon result on screen
    public boolean showXMLConvertionResult(String path){
        boolean converted = false;
        screen.setLblLog("Preenchendo a tabela...");
        
        try{
            //Prenche table
            ArrayList<relLOV> rel = readXML(path);
            DefaultTableModel dt = (DefaultTableModel) screen.tblLOVResult.getModel();
            
            if(rel.size() > 0){
                dt.setNumRows(rel.size());
                        
                for (int i = 0; i < rel.size(); i++) {
                    dt.setValueAt(rel.get(i).getTYPE(), i, 0);
                    dt.setValueAt(rel.get(i).getNAME(), i, 1);
                    dt.setValueAt(rel.get(i).getVAL(), i, 2);
                    dt.setValueAt(rel.get(i).getSUB_TYPE(), i, 3);
                    dt.setValueAt(rel.get(i).getORDER_BY(), i, 4);
                    dt.setValueAt(rel.get(i).getLOW(), i, 5);
                    dt.setValueAt(rel.get(i).getHIGH(), i, 6);
                    dt.setValueAt(rel.get(i).getACTIVE_FLG(), i, 7);
                    dt.setValueAt(rel.get(i).getTRANSLATE_FLG(), i, 8);
                    dt.setValueAt(rel.get(i).getMULTILINGUAL_FLG(), i, 9);
                    dt.setValueAt(rel.get(i).getRPLCTN_LVL_CD(), i, 10);
                    dt.setValueAt(rel.get(i).getTARGET_LOW(), i, 11);
                    dt.setValueAt(rel.get(i).getTARGET_HIGH(), i, 12);
                    dt.setValueAt(rel.get(i).getLANG_ID(), i, 13);
                    dt.setValueAt(rel.get(i).getPARENT_LANGUAGE(), i, 14);
                    dt.setValueAt(rel.get(i).getDFLT_LIC_FLG(), i, 15);
                    dt.setValueAt(rel.get(i).getMODIFIABLE(), i, 16);
                    dt.setValueAt(rel.get(i).getPARENT_VALUE(), i, 17);
                    dt.setValueAt(rel.get(i).getPARENT(), i, 18);
                    dt.setValueAt(rel.get(i).getPARENT_TYPE(), i, 19);
                    dt.setValueAt(rel.get(i).getCODE(), i, 20);
                    dt.setValueAt(rel.get(i).getPARENT_SUBTYPE(), i, 21);
                    dt.setValueAt(rel.get(i).getPARENT_ORGANIZATION(), i, 22);
                    dt.setValueAt(rel.get(i).getFIBER_RELEASE(), i, 23);
                    dt.setValueAt(rel.get(i).getWEIGHTING_FACTOR(), i, 24);
                    dt.setValueAt(rel.get(i).getORGANIZATION(), i, 25);
                    dt.setValueAt(rel.get(i).getDESC_TEXT(), i, 26);

                    // IDIOMA
                    if("PTB".equals(rel.get(i).getLANGUAGE_CODE()) || "ENU".equals(rel.get(i).getLANGUAGE_CODE())){
                            dt.setValueAt(rel.get(i).getLANGUAGE_CODE(), i, 27);
                    } else {
                            dt.setValueAt("PTB", i, 27);
                    }

                    if("Português do Brasil".equals(rel.get(i).getLANGUAGE_NAME()) || "Portuguese-Brazilian".equals(rel.get(i).getLANGUAGE_NAME())){
                            dt.setValueAt("Portuguese-Brazilian", i, 28);
                    } else if((rel.get(i).getLANGUAGE_NAME()).equals("Inglês americano") || (rel.get(i).getLANGUAGE_NAME()).equals("English-American")){
                            dt.setValueAt("English-American", i, 28);
                    } else {
                            dt.setValueAt("Portuguese-Brazilian", i, 28);
                    }
                }
                screen.setLblLog("Tabela preenchida com sucesso... Total de linhas: " + rel.size());
                converted = true;
            } if (tryAgain){
                tryAgain = false;
                showXMLConvertionResult("");                
            }
            
        } catch(Exception e) {
            screen.setLblLog("Erro ao preencer tabela...");
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela...\nErro: " + e);
            converted = false;
        }
        
        return converted;
    }
    
    // This Class save the "Batimento" result on CSV File
    private void saveAsCSV(){
        ArrayList<relLOV> result = readXML(screen.getTxtPath());
        try{
            String path;    
            if("".equals(savePath) || savePath == null){
                //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setDialogTitle("Selecione o caminho desejado para salvar o arquivo");
                //fc.setCurrentDirectory("");
                fc.showOpenDialog(null);
                path = fc.getSelectedFile().toString() + "\\LOV_" + result.get(0).getTYPE() + ".csv";
                this.savePath = fc.getSelectedFile().toString();
            } else {
                path = savePath + "\\LOV_" + result.get(0).getTYPE() + ".csv";
            }
            
            
            String header = "TYPE;NAME;VAL;SUB_TYPE;ORDER_BY;LOW;HIGH;ACTIVE_FLG;TRANSLATE_FLG;MULTILINGUAL_FLG;RPLCTN_LVL_CD;TARGET_LOW;TARGET_HIGH;LANG_ID;PARENT_LANGUAGE;DFLT_LIC_FLG;MODIFIABLE;PARENT_VALUE;PARENT;PARENT_TYPE;CODE;PARENT_SUBTYPE;PARENT_ORGANIZATION;FIBER_RELEASE;WEIGHTING_FACTOR;ORGANIZATION;DESC_TEXT;LANGUAGE_CODE;LANGUAGE_NAME\n";
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));
                buff.append(header);

                for (int i = 0; i < result.size(); i++) {
                    buff.append(result.get(i).getTYPE() + ";");
                    buff.append(result.get(i).getNAME() + ";");
                    buff.append(result.get(i).getVAL() + ";");
                    buff.append(result.get(i).getSUB_TYPE() + ";");
                    buff.append(result.get(i).getORDER_BY() + ";");
                    buff.append(result.get(i).getLOW() + ";");
                    buff.append(result.get(i).getHIGH() + ";");
                    buff.append(result.get(i).getACTIVE_FLG() + ";");
                    buff.append(result.get(i).getTRANSLATE_FLG() + ";");
                    buff.append(result.get(i).getMULTILINGUAL_FLG() + ";");
                    buff.append(result.get(i).getRPLCTN_LVL_CD() + ";");
                    buff.append(result.get(i).getTARGET_LOW() + ";");
                    buff.append(result.get(i).getTARGET_HIGH() + ";");
                    buff.append(result.get(i).getLANG_ID() + ";");
                    buff.append(result.get(i).getPARENT_LANGUAGE() + ";");
                    buff.append(result.get(i).getDFLT_LIC_FLG() + ";");
                    buff.append(result.get(i).getMODIFIABLE() + ";");
                    buff.append(result.get(i).getPARENT_VALUE() + ";");
                    buff.append(result.get(i).getPARENT() + ";");
                    buff.append(result.get(i).getPARENT_TYPE() + ";");
                    buff.append(result.get(i).getCODE() + ";");
                    buff.append(result.get(i).getPARENT_SUBTYPE() + ";");
                    buff.append(result.get(i).getPARENT_ORGANIZATION() + ";");
                    buff.append(result.get(i).getFIBER_RELEASE() + ";");
                    buff.append(result.get(i).getWEIGHTING_FACTOR() + ";");
                    buff.append(result.get(i).getORGANIZATION() + ";");
                    buff.append(result.get(i).getDESC_TEXT() + ";");

                    // IDIOMA
                    if((result.get(i).getLANGUAGE_CODE()).equals("PTB") || (result.get(i).getLANGUAGE_CODE()).equals("ENU")){
                        buff.append(result.get(i).getLANGUAGE_CODE() + ";");
                    } else {
                        buff.append("PTB;");
                    }
                    
                    if((result.get(i).getLANGUAGE_NAME()).equals("Português do Brasil") || (result.get(i).getLANGUAGE_NAME()).equals("Portuguese-Brazilian")){
                        buff.append("Portuguese-Brazilian\n");
                    } else if((result.get(i).getLANGUAGE_NAME()).equals("Inglês americano") || (result.get(i).getLANGUAGE_NAME()).equals("English-American")){
                        buff.append("English-American\n");
                    } else {
                        buff.append("Portuguese-Brazilian\n");
                    }
                }
                buff.close();
                JOptionPane.showMessageDialog(null, "CSV gerado com sucesso!\nCaminho: " + path);
            }            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar converter o XML em CSV!\nErro: " + e);
        }
    }
    
    // Function used to save the result on Excel File
    private void saveAsXLS(){
        try{
            // This ArrayList is based on the "resultByThread" class and receive the result of the function getThreadResult().
            // This Function do a Select Query on the CTRL_LOG_COMP_REP table
            ArrayList<relLOV> result = readXML(screen.getTxtPath());
            
            String path;    
            if("".equals(savePath) || savePath == null){
                //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setDialogTitle("Selecione o caminho desejado para salvar o arquivo");
                //fc.setCurrentDirectory("");
                fc.showOpenDialog(null);
                path = fc.getSelectedFile().toString() + "\\LOV_" + result.get(0).getTYPE() + ".xls";
                this.savePath = fc.getSelectedFile().toString();
            } else {
                path = savePath + "\\LOV_" + result.get(0).getTYPE() + ".xls";
            }
            
            WritableWorkbook workbook = Workbook.createWorkbook(new File(path));            
            WritableSheet sheet = workbook.createSheet(result.get(0).getTYPE(), 0);
            
            sheet.addCell(new Label(0,0, "TYPE"));
            sheet.addCell(new Label(1,0, "NAME"));
            sheet.addCell(new Label(2,0, "VAL"));
            sheet.addCell(new Label(3,0, "SUB_TYPE"));
            sheet.addCell(new Label(4,0, "ORDER_BY"));
            sheet.addCell(new Label(5,0, "HIGH"));
            sheet.addCell(new Label(6,0, "LOW"));
            sheet.addCell(new Label(7,0, "ACTIVE_FLG"));
            sheet.addCell(new Label(8,0, "TRANSLATE_FLG"));
            sheet.addCell(new Label(9,0, "MULTILINGUAL_FLG"));
            sheet.addCell(new Label(10,0, "RPLCTN_LVL_CD"));
            sheet.addCell(new Label(11,0, "TARGET_LOW"));
            sheet.addCell(new Label(12,0, "TARGET_HIGH"));
            sheet.addCell(new Label(13,0, "LANG_ID"));
            sheet.addCell(new Label(14,0, "DFLT_LIC_FLG"));
            sheet.addCell(new Label(15,0, "MODIFIABLE"));
            sheet.addCell(new Label(16,0, "CODE"));
            sheet.addCell(new Label(17,0, "WEIGHTING_FACTOR"));
            sheet.addCell(new Label(18,0, "DESC_TEXT"));
            sheet.addCell(new Label(19,0, "ORGANIZATION"));
            sheet.addCell(new Label(20,0, "PARENT_TYPE"));
            sheet.addCell(new Label(21,0, "PARENT_VALUE"));
            sheet.addCell(new Label(22,0, "PARENT_LANGUAGE"));
            sheet.addCell(new Label(23,0, "PARENT_SUBTYPE"));
            sheet.addCell(new Label(24,0, "PARENT_ORGANIZATION"));
            
            for (int i = 0; i < result.size(); i++){
                sheet.addCell(new Label(0, i + 1,result.get(i).getTYPE()));
                sheet.addCell(new Label(1, i + 1,result.get(i).getNAME()));
                sheet.addCell(new Label(2, i + 1,result.get(i).getVAL()));
                sheet.addCell(new Label(3, i + 1,result.get(i).getSUB_TYPE()));
                sheet.addCell(new Label(4, i + 1,result.get(i).getORDER_BY()));
                sheet.addCell(new Label(5, i + 1,result.get(i).getLOW()));
                sheet.addCell(new Label(6, i + 1,result.get(i).getHIGH()));
                sheet.addCell(new Label(7, i + 1,result.get(i).getACTIVE_FLG()));
                sheet.addCell(new Label(8, i + 1,result.get(i).getTRANSLATE_FLG()));
                sheet.addCell(new Label(9, i + 1,result.get(i).getMULTILINGUAL_FLG()));
                sheet.addCell(new Label(10, i + 1,result.get(i).getRPLCTN_LVL_CD()));
                sheet.addCell(new Label(11, i + 1,result.get(i).getTARGET_LOW()));
                sheet.addCell(new Label(12, i + 1,result.get(i).getTARGET_HIGH()));
                sheet.addCell(new Label(13, i + 1,result.get(i).getLANG_ID()));
                sheet.addCell(new Label(14, i + 1,result.get(i).getDFLT_LIC_FLG()));
                sheet.addCell(new Label(15, i + 1,result.get(i).getMODIFIABLE()));
                sheet.addCell(new Label(16, i + 1,result.get(i).getCODE()));
                sheet.addCell(new Label(17, i + 1,result.get(i).getWEIGHTING_FACTOR()));
                sheet.addCell(new Label(18, i + 1,result.get(i).getDESC_TEXT()));
                sheet.addCell(new Label(19, i + 1,result.get(i).getORGANIZATION()));
                sheet.addCell(new Label(20, i + 1,result.get(i).getPARENT_TYPE()));
                sheet.addCell(new Label(21, i + 1,result.get(i).getPARENT_VALUE()));
                sheet.addCell(new Label(22, i + 1,result.get(i).getPARENT_LANGUAGE()));
                sheet.addCell(new Label(23, i + 1,result.get(i).getPARENT_SUBTYPE()));
                sheet.addCell(new Label(24, i + 1,result.get(i).getPARENT_ORGANIZATION()));
            }
            
            workbook.write();
            workbook.close();
            
            JOptionPane.showMessageDialog(null, "Excel gerado com sucesso!\nCaminho: " + path);
        } catch (IOException | WriteException ex){
            JOptionPane.showMessageDialog(null, "Erro ao tentar converter o XML em Excel!\nErro: " + ex);
        }
    }
    
    private void saveAsSQLInsert(){
        ArrayList<relLOV> result = readXML(screen.getTxtPath());
        try{
            String path;    
            if("".equals(savePath) || savePath == null){
                //Abre caixa de dialogo para selecionar caminho do arquivo que será gerado.
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fc.setDialogTitle("Selecione o caminho desejado para salvar o arquivo");
                //fc.setCurrentDirectory("");
                fc.showOpenDialog(null);
                path = fc.getSelectedFile().toString() + "\\LOV_" + result.get(0).getTYPE() + ".sql";
                this.savePath = fc.getSelectedFile().toString();
            } else {
                path = savePath + "\\LOV_" + result.get(0).getTYPE() + ".sql";
            }
            
            String sqlHeader = "INSERT INTO SIEBEL.EIM_LST_OF_VAL (";
            String sqlColumn = "";
            String sqlValue = ") VALUES (";
            String sqlEnd = ");\n";
            
            if (!path.isEmpty()) {            
                BufferedWriter buff = new BufferedWriter(new FileWriter(path));

                for (int i = 0; i < result.size(); i++) {
                    // ROW_ID
                    sqlColumn += "ROW_ID"; sqlValue += (i+1);

                    // CHILD COLUMNS
                    if(!"".equals(result.get(i).getTYPE()) && result.get(i).getTYPE() != null){ sqlColumn += ", LOV_TYPE"; sqlValue += ", '" + result.get(i).getTYPE() + "'"; } else { sqlColumn += ", LOV_TYPE"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getNAME()) && result.get(i).getNAME() != null){ sqlColumn += ", LOV_NAME"; sqlValue += ", '" + result.get(i).getNAME() + "'"; } else { sqlColumn += ", LOV_NAME"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getVAL()) && result.get(i).getVAL() != null){ sqlColumn += ", LOV_VAL"; sqlValue += ", '" + result.get(i).getVAL() + "'"; } else { sqlColumn += ", LOV_VAL"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getSUB_TYPE()) && result.get(i).getSUB_TYPE() != null){ sqlColumn += ", LOV_SUB_TYPE"; sqlValue += ", '" + result.get(i).getSUB_TYPE() + "'"; } else { sqlColumn += ", LOV_SUB_TYPE"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getORDER_BY()) && result.get(i).getORDER_BY() != null){ sqlColumn += ", LOV_ORDER_BY"; sqlValue += ", " + result.get(i).getORDER_BY(); } else { sqlColumn += ", LOV_ORDER_BY"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getLOW()) && result.get(i).getLOW() != null){ sqlColumn += ", LOV_LOW"; sqlValue += ", '" + result.get(i).getLOW() + "'"; } else { sqlColumn += ", LOV_LOW"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getHIGH()) && result.get(i).getHIGH() != null){ sqlColumn += ", LOV_HIGH"; sqlValue += ", '" + result.get(i).getHIGH() + "'"; } else { sqlColumn += ", LOV_HIGH"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getACTIVE_FLG()) && result.get(i).getACTIVE_FLG() != null){ sqlColumn += ", LOV_ACTIVE_FLG"; sqlValue += ", '" + result.get(i).getACTIVE_FLG() + "'"; } else { sqlColumn += ", LOV_ACTIVE_FLG"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getTRANSLATE_FLG()) && result.get(i).getTRANSLATE_FLG() != null){ sqlColumn += ", LOV_TRANSLATE_FLG"; sqlValue += ", '" + result.get(i).getTRANSLATE_FLG() + "'"; } else { sqlColumn += ", LOV_TRANSLATE_FLG"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getMULTILINGUAL_FLG()) && result.get(i).getMULTILINGUAL_FLG() != null){ sqlColumn += ", LOV_MULTILINGUALFL"; sqlValue += ", '" + result.get(i).getMULTILINGUAL_FLG() + "'"; } else { sqlColumn += ", LOV_MULTILINGUALFL"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getRPLCTN_LVL_CD()) && result.get(i).getRPLCTN_LVL_CD() != null){ sqlColumn += ", LOV_RPLCTN_LVL_CD"; sqlValue += ", '" + result.get(i).getRPLCTN_LVL_CD() + "'"; } else { sqlColumn += ", LOV_RPLCTN_LVL_CD"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getTARGET_LOW()) && result.get(i).getTARGET_LOW() != null){ sqlColumn += ", LOV_TARGET_LOW"; sqlValue += ", " + result.get(i).getTARGET_LOW(); } else { sqlColumn += ", LOV_TARGET_LOW"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getTARGET_HIGH()) && result.get(i).getTARGET_HIGH() != null){ sqlColumn += ", LOV_TARGET_HIGH"; sqlValue += ", " + result.get(i).getTARGET_HIGH(); } else { sqlColumn += ", LOV_TARGET_HIGH"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getLANG_ID()) && result.get(i).getLANG_ID() != null){ sqlColumn += ", LOV_LANG_ID"; sqlValue += ", '" + result.get(i).getLANG_ID() + "'"; } else { sqlColumn += ", LOV_LANG_ID"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getDFLT_LIC_FLG()) && result.get(i).getDFLT_LIC_FLG() != null){ sqlColumn += ", LOV_DFLT_LIC_FLG"; sqlValue += ", '" + result.get(i).getDFLT_LIC_FLG() + "'"; } else { sqlColumn += ", LOV_DFLT_LIC_FLG"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getMODIFIABLE()) && result.get(i).getMODIFIABLE() != null){ sqlColumn += ", LOV_MODIFIABLE_FLG"; sqlValue += ", '" + result.get(i).getMODIFIABLE() + "'"; } else { sqlColumn += ", LOV_MODIFIABLE_FLG"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getCODE()) && result.get(i).getCODE() != null){ sqlColumn += ", LOV_CODE"; sqlValue += ", '" + result.get(i).getCODE() + "'"; } else { sqlColumn += ", LOV_CODE"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getWEIGHTING_FACTOR()) && result.get(i).getWEIGHTING_FACTOR() != null){ sqlColumn += ", LOV_WEIGHTINGFACTO"; sqlValue += ", " + result.get(i).getWEIGHTING_FACTOR(); } else { sqlColumn += ", LOV_TYPE"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getORGANIZATION()) && result.get(i).getORGANIZATION() != null){ sqlColumn += ", LOV_BI"; sqlValue += ", '" + result.get(i).getORGANIZATION() + "'"; } else { sqlColumn += ", LOV_BI"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getDESC_TEXT()) && result.get(i).getDESC_TEXT() != null){ sqlColumn += ", LOV_DESC_TEXT"; sqlValue += ", '" + result.get(i).getDESC_TEXT() + "'"; } else { sqlColumn += ", LOV_DESC_TEXT"; sqlValue += ", " + null; }

                    // PARENT
                    if(!"".equals(result.get(i).getPARENT_VALUE()) && result.get(i).getPARENT_VALUE() != null){ sqlColumn += ", PAR_VAL"; sqlValue += ", '" + result.get(i).getPARENT_VALUE() + "'"; } else { sqlColumn += ", PAR_VAL"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getPARENT_TYPE()) && result.get(i).getPARENT_TYPE() != null){ sqlColumn += ", PAR_TYPE"; sqlValue += ", '" + result.get(i).getPARENT_TYPE() + "'"; } else { sqlColumn += ", PAR_TYPE"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getPARENT_LANGUAGE()) && result.get(i).getPARENT_LANGUAGE() != null){ sqlColumn += ", PAR_LANG_ID"; sqlValue += ", '" + result.get(i).getPARENT_LANGUAGE() + "'"; } else { sqlColumn += ", PAR_LANG_ID"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getPARENT_SUBTYPE()) && result.get(i).getPARENT_SUBTYPE() != null){ sqlColumn += ", PAR_SUB_TYPE"; sqlValue += ", '" + result.get(i).getPARENT_SUBTYPE() + "'"; } else { sqlColumn += ", PAR_SUB_TYPE"; sqlValue += ", " + null; }
                    if(!"".equals(result.get(i).getPARENT_ORGANIZATION()) && result.get(i).getPARENT_ORGANIZATION() != null){ sqlColumn += ", PAR_BI"; sqlValue += ", '" + result.get(i).getPARENT_ORGANIZATION() + "'"; } else { sqlColumn += ", PAR_BI"; sqlValue += ", " + null; }

                    // DEFAULT COLUMNS
                    sqlColumn += ", IF_ROW_BATCH_NUM"; sqlValue += ", " + (screen.getTxtIfRowBatchNum());
                    sqlColumn += ", IF_ROW_STAT"; sqlValue += ", '" + (screen.getTxtIfRowStat() + "'");
                    sqlColumn += ", LOV_WS_ID"; sqlValue += ", '" + (screen.getTxtLovWSId() + "'");
                    sqlColumn += ", LOV_REQD_LIC_FLG"; sqlValue += ", '" + (screen.getCbbLovReqdLicFlg() + "'");
                    sqlColumn += ", LOV_MORG_DSALW_FLG"; sqlValue += ", '" + (screen.getCbbLovMorgDsalwFlg() + "'");
                    
                    // CREATE INSERT LINE
                    buff.append(sqlHeader + sqlColumn + sqlValue + sqlEnd);
                    
                    sqlHeader = "INSERT INTO SIEBEL.EIM_LST_OF_VAL (";
                    sqlColumn = "";
                    sqlValue = ") VALUES (";
                    sqlEnd = ");\n";
                }
                buff.close();
                JOptionPane.showMessageDialog(null, "Arquivo SQL gerado com sucesso!\nCaminho: " + path);
            }            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar converter o XML em SQL!\nErro: " + e);
        }
    }
    
    private class loadFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            screen.clearTxtPath();
            if(showXMLConvertionResult("")){
                screen.setBtnSaveEnabled(true);
            }
        }
        
    }
    
    private class saveConvertion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String[] options = {"CSV","Excel","Insert SQL","Ambos"};
            int x = JOptionPane.showOptionDialog(null, "O Arquivo encontrado não é um XML de LOV. Deseja selecionar outro arquivo?", "Erro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            
            if(x==0){
                saveAsCSV();
                savePath = null;
            } else if(x==1){
                saveAsXLS();
                savePath = null;
            } else if(x==2){
                saveAsSQLInsert();
                savePath = null;
            } else {
                saveAsCSV();
                saveAsXLS();
                saveAsSQLInsert();
                savePath = null;
            }
        }
        
    }
    
    private class relLOV {
        private String TYPE;
        private String NAME;
        private String VAL;
        private String SUB_TYPE;
        private String ORDER_BY;
        private String LOW;
        private String HIGH;
        private String ACTIVE_FLG;
        private String TRANSLATE_FLG;
        private String MULTILINGUAL_FLG;
        private String RPLCTN_LVL_CD;
        private String TARGET_LOW;
        private String TARGET_HIGH;
        private String LANG_ID;
        private String PARENT_LANGUAGE;
        private String DFLT_LIC_FLG;
        private String MODIFIABLE;
        private String PARENT_VALUE;
        private String PARENT;
        private String PARENT_TYPE;
        private String CODE;
        private String PARENT_SUBTYPE;
        private String PARENT_ORGANIZATION;
        private String FIBER_RELEASE;
        private String WEIGHTING_FACTOR;
        private String ORGANIZATION;
        private String DESC_TEXT;

        // IDIOMA
        private String LANGUAGE_CODE;
        private String LANGUAGE_NAME;

        public relLOV() {
            this.TYPE = null;
            this.NAME = null;
            this.VAL = null;
            this.SUB_TYPE = null;
            this.ORDER_BY = null;
            this.LOW = null;
            this.HIGH = null;
            this.ACTIVE_FLG = null;
            this.TRANSLATE_FLG = null;
            this.MULTILINGUAL_FLG = null;
            this.RPLCTN_LVL_CD = null;
            this.TARGET_LOW = null;
            this.TARGET_HIGH = null;
            this.LANG_ID = null;
            this.PARENT_LANGUAGE = null;
            this.DFLT_LIC_FLG = null;
            this.MODIFIABLE = null;
            this.PARENT_VALUE = null;
            this.PARENT = null;
            this.PARENT_TYPE = null;
            this.CODE = null;
            this.PARENT_SUBTYPE = null;
            this.PARENT_ORGANIZATION = null;
            this.FIBER_RELEASE = null;
            this.WEIGHTING_FACTOR = null;
            this.ORGANIZATION = null;
            this.DESC_TEXT = null;
            this.LANGUAGE_CODE = null;
            this.LANGUAGE_NAME = null;
        }

        public String getTYPE() {
            return TYPE;
        }

        public void setTYPE(String TYPE) {
            this.TYPE = TYPE;
        }

        public String getNAME() {
            return NAME;
        }

        public void setNAME(String NAME) {
            this.NAME = NAME;
        }

        public String getVAL() {
            return VAL;
        }

        public void setVAL(String VAL) {
            this.VAL = VAL;
        }

        public String getSUB_TYPE() {
            return SUB_TYPE;
        }

        public void setSUB_TYPE(String SUB_TYPE) {
            this.SUB_TYPE = SUB_TYPE;
        }

        public String getORDER_BY() {
            return ORDER_BY;
        }

        public void setORDER_BY(String ORDER_BY) {
            this.ORDER_BY = ORDER_BY;
        }

        public String getLOW() {
            return LOW;
        }

        public void setLOW(String LOW) {
            this.LOW = LOW;
        }

        public String getHIGH() {
            return HIGH;
        }

        public void setHIGH(String HIGH) {
            this.HIGH = HIGH;
        }

        public String getACTIVE_FLG() {
            return ACTIVE_FLG;
        }

        public void setACTIVE_FLG(String ACTIVE_FLG) {
            this.ACTIVE_FLG = ACTIVE_FLG;
        }

        public String getTRANSLATE_FLG() {
            return TRANSLATE_FLG;
        }

        public void setTRANSLATE_FLG(String TRANSLATE_FLG) {
            this.TRANSLATE_FLG = TRANSLATE_FLG;
        }

        public String getMULTILINGUAL_FLG() {
            return MULTILINGUAL_FLG;
        }

        public void setMULTILINGUAL_FLG(String MULTILINGUAL_FLG) {
            this.MULTILINGUAL_FLG = MULTILINGUAL_FLG;
        }

        public String getRPLCTN_LVL_CD() {
            return RPLCTN_LVL_CD;
        }

        public void setRPLCTN_LVL_CD(String RPLCTN_LVL_CD) {
            this.RPLCTN_LVL_CD = RPLCTN_LVL_CD;
        }

        public String getTARGET_LOW() {
            return TARGET_LOW;
        }

        public void setTARGET_LOW(String TARGET_LOW) {
            this.TARGET_LOW = TARGET_LOW;
        }

        public String getTARGET_HIGH() {
            return TARGET_HIGH;
        }

        public void setTARGET_HIGH(String TARGET_HIGH) {
            this.TARGET_HIGH = TARGET_HIGH;
        }

        public String getLANG_ID() {
            return LANG_ID;
        }

        public void setLANG_ID(String LANG_ID) {
            this.LANG_ID = LANG_ID;
        }

        public String getPARENT_LANGUAGE() {
            return PARENT_LANGUAGE;
        }

        public void setPARENT_LANGUAGE(String PARENT_LANGUAGE) {
            this.PARENT_LANGUAGE = PARENT_LANGUAGE;
        }

        public String getDFLT_LIC_FLG() {
            return DFLT_LIC_FLG;
        }

        public void setDFLT_LIC_FLG(String DFLT_LIC_FLG) {
            this.DFLT_LIC_FLG = DFLT_LIC_FLG;
        }

        public String getMODIFIABLE() {
            return MODIFIABLE;
        }

        public void setMODIFIABLE(String MODIFIABLE) {
            this.MODIFIABLE = MODIFIABLE;
        }

        public String getPARENT_VALUE() {
            return PARENT_VALUE;
        }

        public void setPARENT_VALUE(String PARENT_VALUE) {
            this.PARENT_VALUE = PARENT_VALUE;
        }

        public String getPARENT() {
            return PARENT;
        }

        public void setPARENT(String PARENT) {
            this.PARENT = PARENT;
        }

        public String getPARENT_TYPE() {
            return PARENT_TYPE;
        }

        public void setPARENT_TYPE(String PARENT_TYPE) {
            this.PARENT_TYPE = PARENT_TYPE;
        }

        public String getCODE() {
            return CODE;
        }

        public void setCODE(String CODE) {
            this.CODE = CODE;
        }

        public String getPARENT_SUBTYPE() {
            return PARENT_SUBTYPE;
        }

        public void setPARENT_SUBTYPE(String PARENT_SUBTYPE) {
            this.PARENT_SUBTYPE = PARENT_SUBTYPE;
        }

        public String getPARENT_ORGANIZATION() {
            return PARENT_ORGANIZATION;
        }

        public void setPARENT_ORGANIZATION(String PARENT_ORGANIZATION) {
            this.PARENT_ORGANIZATION = PARENT_ORGANIZATION;
        }

        public String getFIBER_RELEASE() {
            return FIBER_RELEASE;
        }

        public void setFIBER_RELEASE(String FIBER_RELEASE) {
            this.FIBER_RELEASE = FIBER_RELEASE;
        }

        public String getWEIGHTING_FACTOR() {
            return WEIGHTING_FACTOR;
        }

        public void setWEIGHTING_FACTOR(String WEIGHTING_FACTOR) {
            this.WEIGHTING_FACTOR = WEIGHTING_FACTOR;
        }

        public String getORGANIZATION() {
            return ORGANIZATION;
        }

        public void setORGANIZATION(String ORGANIZATION) {
            this.ORGANIZATION = ORGANIZATION;
        }

        public String getDESC_TEXT() {
            return DESC_TEXT;
        }

        public void setDESC_TEXT(String DESC_TEXT) {
            this.DESC_TEXT = DESC_TEXT;
        }

        public String getLANGUAGE_CODE() {
            return LANGUAGE_CODE;
        }

        public void setLANGUAGE_CODE(String LANGUAGE_CODE) {
            this.LANGUAGE_CODE = LANGUAGE_CODE;
        }

        public String getLANGUAGE_NAME() {
            return LANGUAGE_NAME;
        }

        public void setLANGUAGE_NAME(String LANGUAGE_NAME) {
            this.LANGUAGE_NAME = LANGUAGE_NAME;
        }
        
        
    }
    
}
