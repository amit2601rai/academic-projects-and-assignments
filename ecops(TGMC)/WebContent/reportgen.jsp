<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%><%@taglib
	uri="http://struts.apache.org/tags-bean" prefix="bean"%><html>
<head>
<title>reportgen</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.awt.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.lowagie.text.*"%>
<%@ page import="com.lowagie.text.pdf.*"%>
<%@ page import="com.lowagie.text.html.*"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.sql.*"%>
<%@ page import="net.sf.jasperreports.engine.JRExporterParameter"%>
<%@ page import="net.sf.jasperreports.engine.JasperCompileManager"%>
<%@ page import="net.sf.jasperreports.engine.JasperFillManager"%>
<%@ page import="net.sf.jasperreports.engine.JasperPrint"%>
<%@ page import="net.sf.jasperreports.engine.export.JRPdfExporter"%>
<%@ page import="net.sf.jasperreports.engine.util.JRLoader"%>
<%@page import ="elites.model.*" %>




<%
String temp_file="",temp_file1="",temp_file2="";
Connection conn=null;	
    	try{			
    			DbModel dm=new DbModel();
    conn= dm.getConnection1();
    out.print("connection is"+conn);
    	    }
    		catch(Exception e)
    		{System.out.print("error in conn is "+e);}
String newp="<?xml version='1.0' encoding='UTF-8'?>\n<jasperReport xmlns='http://jasperreports.sourceforge.net/jasperreports' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd' name='AKHIL' language='groovy' pageWidth='595' pageHeight='842' columnWidth='555' leftMargin='20' rightMargin='20' topMargin='20' bottomMargin='20'>\n<queryString>\n<![CDATA[SELECT * FROM ELITE.RTOD]]>\n</queryString>\n<field name='RNAME' class='java.lang.String'>\n<fieldDescription><![CDATA[]]></fieldDescription>\n</field>\n<field name='DNAME' class='java.lang.String'>\n<fieldDescription><![CDATA[]]></fieldDescription>\n</field>\n<background>\n<band splitType='Stretch'/>\n</background>\n<title>\n<band height='79' splitType='Stretch'>\n<staticText>\n<reportElement x='240' y='32' width='100' height='20'/>\n<textElement/>\n<text><![CDATA[HEADRER KI MAA KA]]></text>\n</staticText>\n</band>\n</title>\n<pageHeader>\n<band height='35' splitType='Stretch'/>\n</pageHeader>\n<columnHeader>\n<band height='61' splitType='Stretch'/>\n</columnHeader>\n<detail>\n<band height='125' splitType='Stretch'>\n<textField>\n<reportElement x='59' y='20' width='100' height='20'/>\n<textElement/>\n<textFieldExpression class='java.lang.String'><![CDATA[$F{RNAME}]]></textFieldExpression>\n</textField>\n<textField>\n<reportElement x='437' y='20' width='100' height='20'/>\n<textElement/>\n<textFieldExpression class='java.lang.String'><![CDATA[$F{DNAME}]]></textFieldExpression>\n</textField>\n</band>\n</detail>\n<columnFooter>\n<band height='45' splitType='Stretch'/>\n</columnFooter>\n<pageFooter>\n<band height='54' splitType='Stretch'/>\n</pageFooter>\n<summary>\n<band height='42' splitType='Stretch'/>\n</summary>\n</jasperReport>";
 String rep="<?xml version='1.0' encoding='UTF-8'?><jasperReport xmlns='http://jasperreports.sourceforge.net/jasperreports' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='http://jasperreports.sourceforge.net/jasperreports http://jasperreports.sourceforge.net/xsd/jasperreport.xsd' name='anand' language='groovy' pageWidth='595' pageHeight='842' columnWidth='555' leftMargin='20' rightMargin='20' topMargin='20' bottomMargin='20'>	<queryString>		<![CDATA[SELECT NAME,COUNT(VALUE) AS VAL FROM ELITE.TEMP GROUP BY NAME ORDER BY 1]]>	</queryString>	<field name='NAME' class='java.lang.String'>		<fieldDescription><![CDATA[]]></fieldDescription>	</field>	<field name='VAL' class='java.lang.Integer'>		<fieldDescription><![CDATA[]]></fieldDescription>	</field>	<variable name='serv' class='java.lang.String'/>	<filterExpression><![CDATA[$F{NAME}]]></filterExpression>	<group name='serv'>		<groupExpression><![CDATA[$F{NAME}]]></groupExpression>	</group>	<group name='serv1'>		<groupExpression><![CDATA[$F{NAME}]]></groupExpression>		<groupHeader>			<band height='50'/>		</groupHeader>		<groupFooter>			<band height='50'/>		</groupFooter>	</group>	<background>		<band splitType='Stretch'/>	</background>	<title>		<band height='79' splitType='Stretch'/>	</title>	<pageHeader>		<band height='35' splitType='Stretch'/>	</pageHeader>	<detail>		<band height='122'>			<pie3DChart><chart><reportElement x='203' y='22' width='200' height='100'/><chartTitle/><chartSubtitle/><chartLegend/></chart>	<pieDataset maxCount='6' minPercentage='1.0'><dataset resetType='None'/><keyExpression><![CDATA[$F{NAME}]]></keyExpression>	<valueExpression><![CDATA[$F{VAL}]]></valueExpression><labelExpression><![CDATA[$F{NAME}]]></labelExpression></pieDataset>	<pie3DPlot>	<plot/><itemLabel color='#000000' backgroundColor='#FFFFFF'/></pie3DPlot></pie3DChart></band></detail><columnFooter><band height='45' splitType='Stretch'/></columnFooter><pageFooter><band height='54' splitType='Stretch'/></pageFooter><summary><band height='42' splitType='Stretch'/></summary></jasperReport>"; 
  temp_file="AKHIL";
  temp_file2="anand";
			temp_file1=newp;
			
			
			System.out.print(temp_file1+"        ");
	System.out.print(System.getProperty("user.dir"));
			try{System.out.print("11");
			BufferedWriter bw=new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"/temp.jrxml"));
			bw.write(newp);
			bw.close();
			System.out.print("22");
			JasperCompileManager.compileReportToFile(System.getProperty("user.dir")+"/temp.jrxml");
			System.out.print("33");	
				JasperFillManager.fillReportToFile(System.getProperty("user.dir")+"/"+temp_file+".jasper",new HashMap(),conn);
				System.out.print("44");
				File file = new File(System.getProperty("user.dir")+"/"+temp_file+".jrprint");
				System.out.print("55");
				JasperPrint jasperPrint = (JasperPrint)	JRLoader.loadObject(file);
				System.out.print("66");
				JRPdfExporter pdfExporter = new JRPdfExporter();
				System.out.print("77");
				pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				System.out.print("88");
				String loc=System.getProperty("user.dir");
				System.out.print(loc);
				pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,"E:/TGMC/elites/WebContent/pdf"+"/"+temp_file+".pdf");
				System.out.print("99");
				pdfExporter.exportReport();
				System.out.print("10");
				%><a href="/elites/pdf/<%=temp_file %>.pdf">click to view the report</a><%
    	}catch(Exception e)
		{System.out.print("error is "+e);
			out.print("<b><font color='black'>ERROR:Causes May Be,</font></b><br/><span style='font-weight:none;'>1.&nbsp;Details Entered May Be Incorrect <br/> 2.&nbsp;There May Be Error With Our DataBase<br/> Server</span>"+e.toString());
			}
 %>

</body>
</html>