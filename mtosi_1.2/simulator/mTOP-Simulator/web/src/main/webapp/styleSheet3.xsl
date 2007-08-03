<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html><title>Tables</title>
	 <body>
	<xsl:apply-templates/>
</body></html>
</xsl:template>

	
<xsl:template match="md">	
<table border="1" color="BCEDF1">
	<body>
		<tr>
			<th>mdNm</th>
			<th>discoveredName</th>
			<th>resourceState</th>
			<th>source</th>
			<th>managed elements</th>
		</tr>
		<tr>
			<td><xsl:value-of select="mdNm"/> </td>
			<td><xsl:value-of select="mdAttrs/discoveredName"/> </td>
			<td><xsl:value-of select="mdAttrs/resourceState"/> </td>
			<td><xsl:value-of select="mdAttrs/source"/> </td>
			<td><xsl:apply-templates select="meList"/></td>
		</tr>
	</body>
</table>
</xsl:template>

<xsl:template match="meList">

<!--<xsl:for-each select="meInv">
<xsl:value-of select="meNm"/> <br/>
</xsl:for-each>-->
<xsl:apply-templates select="meInv"/>
</xsl:template>

<xsl:template match="meInv">	
<table border="1" color="BCEDF1">
	<body>
		<tr>
			<th>meNm</th>
			<th>discoveredName</th>
			<th>resourceState</th>
			<th>source</th>
			<th>equipment holders</th>
			<th>physical termination points</th>
		</tr>
		<tr>
			<td><xsl:value-of select="meNm"/> </td>
			<td><xsl:value-of select="meAttrs/discoveredName"/> </td>
			<td><xsl:value-of select="meAttrs/resourceState"/> </td>	
			<td><xsl:value-of select="meAttrs/source"/> </td>
			<td><xsl:apply-templates select="ehList"/> </td>
			<td><xsl:apply-templates select="ptpList"/> </td>
		</tr>
	</body>
</table>
</xsl:template>

<xsl:template match="ehList">
<!--<xsl:for-each select="ehInv">
<xsl:value-of select="ehNm"/> <br/>
</xsl:for-each>-->
<xsl:apply-templates select="ehInv"/>
</xsl:template>

<xsl:template match="ptpList">
<!--<xsl:for-each select="ptpInv">
<xsl:value-of select="ptpNm"/> <br/>
</xsl:for-each>-->
<xsl:apply-templates select="ptpInv"/>
</xsl:template>

<xsl:template match="ehInv">	
<table border="1" color="BCEDF1">
	<body>
		<tr>
			<th>ehNm</th>
			<th>discoveredName</th>
			<th>alarmReportingIndicator</th>
			<th>resourceState</th>
			<th>source</th>
			<th>equipments</th>
		</tr>
		<tr>
			<td><xsl:value-of select="ehNm"/> </td>
			<td><xsl:value-of select="ehAttrs/discoveredName"/> </td>
			<td><xsl:value-of select="ehAttrs/alarmReportingIndicator"/> </td>
			<td><xsl:value-of select="ehAttrs/resourceState"/> </td>	
			<td><xsl:value-of select="ehAttrs/source"/> </td>
			<td><xsl:apply-templates select="eq"/> </td>
		</tr>
	</body>
</table>
</xsl:template>


<xsl:template match="ptpInv">	
<table border="1" color="BCEDF1">
	<body>
		<tr>
			<th>ptpNm</th>
			<th>discoveredName</th>
			<th>resourceState</th>
			<th>source</th>
			<th>direction</th>
			<th>connection termination points</th>
		</tr>
		<tr>
			<td><xsl:value-of select="ptpNm"/> </td>
			<td><xsl:value-of select="ptpAttrs/discoveredName"/> </td>
			<td><xsl:value-of select="ptpAttrs/resourceState"/> </td>	
			<td><xsl:value-of select="ptpAttrs/source"/> </td>
			<td><xsl:value-of select="ptpAttrs/direction"/> </td>
			<td><xsl:apply-templates select="ctpList"/> </td>
		</tr>
	</body>
</table>
</xsl:template>

<xsl:template match="ctpList">
<!--<xsl:for-each select="ctpInv">
<xsl:value-of select="ctpNm"/> <br/>
</xsl:for-each>-->
<xsl:apply-templates select="ctpInv"/>
</xsl:template>


<xsl:template match="ctpInv">	
<table border="1" color="BCEDF1">
	<body>
		<tr>
			<th>ctpNm</th>
			<th>discoveredName</th>
			<th>resourceState</th>
			<th>source</th>
			<th>connection State</th>
		</tr>
		<tr>
			<td><xsl:value-of select="ctpNm"/> </td>
			<td><xsl:value-of select="ctpAttrs/discoveredName"/> </td>
			<td><xsl:value-of select="ctpAttrs/resourceState"/> </td>	
			<td><xsl:value-of select="ctpAttrs/source"/> </td>
			<td><xsl:value-of select="ctpAttrs/connectionState"/> </td>
		</tr>
	</body>
</table>
</xsl:template>


</xsl:stylesheet>  

