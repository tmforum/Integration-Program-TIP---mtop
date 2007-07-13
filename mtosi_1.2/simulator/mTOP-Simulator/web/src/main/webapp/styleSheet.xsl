<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<!-- tp MNS DESS Telecom Germain SIGETY Stephane MARIANI -->
<!-- fichier feuille de style XSLT du réseau à manager -->

<xsl:template match="/">
<html><body>
	<h2><center><font color="blue"><xsl:value-of select="Network/name/networkName"/></font></center></h2>
	<xsl:apply-templates/>
</body></html>
</xsl:template>

	
<xsl:template match="Network">
	<xsl:apply-templates select="mElement"/>	
</xsl:template>


<xsl:template match="mElement">
	<h4>managed element : </h4>
			<h2><font color="A21432"><xsl:value-of select="discoveredName/managedElementName"/></font></h2>
  	
  			<table border="1" color="BCEDF1">
  				<tr bgcolor="90DCF2">
    				<th>productName</th>
    				<th>manufacturer</th>
    			</tr>
    		
    			<tr>
  					<td><xsl:value-of select="productName"/></td>
  					<td><xsl:value-of select="manufacturer"/></td>
  				</tr>
			</table>
		<h4>equipement holders : </h4>
			<table border="1">
  				<tr bgcolor="#9acd32">
    				<th>discoveredName</th>
    				<th>holderState</th>
    				<th>Expected Equip. ObjectType</th>
    				<th>equipName</th>
    				<th>serviceState</th>
    				<th>manufacturer</th>
    				<th>PTP</th>
    			</tr>
				<xsl:apply-templates select="eHolder"/>
			</table>
		
		<h4>Cross Connections : </h4>
		<table border="1">
  				<tr bgcolor="#9acd32">
  					<th>State</th>
    				<th>aEndNameList</th>
    				<th>zEndNameList</th>
    				<th>direction</th>
    				<th>link_rate</th>
    			<xsl:apply-templates select="cConnection"/>
    			</tr>
		</table>
	<hr></hr>
</xsl:template>


<xsl:template match="cConnection">
	<tr>
		<td><xsl:value-of select="active"/></td>
		<td><xsl:apply-templates select="aEndNameList"/></td> 
		<td><xsl:apply-templates select="zEndNameList"/></td> 
		<td><xsl:value-of select="direction"/></td>
		<td><xsl:value-of select="link_rate"/></td>
	</tr>
</xsl:template>


<xsl:template match="aEndNameList">

<xsl:for-each select="*">
		<b><xsl:value-of select="local-name()"/></b> : <xsl:value-of select="."/><br />
</xsl:for-each>
</xsl:template>

<xsl:template match="zEndNameList">

<xsl:for-each select="*">
		<b><xsl:value-of select="local-name()"/></b> : <xsl:value-of select="."/><br />
</xsl:for-each>
</xsl:template>


<xsl:template match="equipmentHolderName">
salut
</xsl:template>

<xsl:template match="equipmentName">
<p>salut</p>
</xsl:template>


<xsl:template match="eHolder">
	   			<tr>
    		  		<td><xsl:value-of select="discoveredName/equipmentHolderName"/></td>
  					<td><xsl:value-of select="holderState"/></td>
  					<td><xsl:value-of select="ExpectedEquipmentObjectType"/></td>
  					<td><xsl:value-of select="equipement/discoveredName/equipmentName"/></td>
  					<td><xsl:value-of select="equipement/serviceState"/></td>
  					<td><xsl:value-of select="equipement/manufacturer"/></td>
  					<td>
  						<table border="1">
  							<tr bgcolor="F5F746">
								<th>PTP Name</th>
    							<th>PTP Label</th>
    							<th>PTP direction</th>
    							<th>CTP name</th>
    							<th>CTP direction</th>   				
    						</tr>
    						<xsl:apply-templates select="equipement/tPoint/logicPort"/>
    					</table>
    				</td>
  				</tr>
</xsl:template>



<xsl:template match="logicPort">
    			<tr>
  					<xsl:apply-templates select=".."/>
  					<td><font size="2"><xsl:value-of select="discoveredName/CTPName"/></font></td>
  					<td><font size="2"><xsl:value-of select="direction"/></font></td>
  				</tr>
</xsl:template>



<xsl:template match="tPoint">
  					<td><font size="2"><xsl:value-of select="discoveredName/PTPName"/></font></td>
  					<td><font size="2"><xsl:value-of select="label"/></font></td>
  					<td><font size="2"><xsl:value-of select="direction"/></font></td>
</xsl:template>

</xsl:stylesheet>  

