<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<title>Tables</title>
			<body>
				<xsl:apply-templates/>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="mdList">
		<xsl:apply-templates select="md"/>
	</xsl:template>
	<xsl:template match="meList">
		<xsl:apply-templates select="meInv"/>
	</xsl:template>
	<xsl:template match="mlsnList">
		<xsl:apply-templates select="mlsnInv"/>
	</xsl:template>
	<xsl:template match="ehList">
		<xsl:apply-templates select="ehInv"/>
	</xsl:template>
	<xsl:template match="ptpList">
		<xsl:apply-templates select="ptpInv"/>
	</xsl:template>
	<xsl:template match="ftpList">
		<xsl:apply-templates select="ptpInv"/>
	</xsl:template>
	<xsl:template match="pgpList">
		<xsl:apply-templates select="pgpInv"/>
	</xsl:template>
	<xsl:template match="epgpList">
		<xsl:apply-templates select="epgpInv"/>
	</xsl:template>
	<xsl:template match="sncList">
		<xsl:apply-templates select="sncInv"/>
	</xsl:template>
	<xsl:template match="tpPoolList">
		<xsl:apply-templates select="tpPoolInv"/>
	</xsl:template>
	<xsl:template match="ctpList">
		<xsl:apply-templates select="ctpInv"/>
	</xsl:template>
	<!-- ************** inv **************** -->
	<xsl:template match="md">
		<table border="2" bordercolor="red">
			<body>
				<tr>
					<th bgcolor="ff0000">mdNm</th>
					<xsl:if test="mdAttrs/discoveredName">
						<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="mdAttrs/namingOS">
						<th bgcolor="ffff00">namingOS</th>
					</xsl:if>
					<xsl:if test="mdAttrs/userLabel">
						<th bgcolor="ffff00">userLabel</th>
					</xsl:if>
					<xsl:if test="mdAttrs/source">
						<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="mdAttrs/owner">
						<th bgcolor="ffff00">owner</th>
					</xsl:if>
					<xsl:if test="mdAttrs/aliasNameList">
						<th bgcolor="ffff00">aliasNameList</th>
					</xsl:if>
					<xsl:if test="mdAttrs/resourceState">
						<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="mdAttrs/networkAccessDomain">
						<th bgcolor="ffff00">networkAccessDomain</th>
					</xsl:if>
					<xsl:if test="supportingOSNameList">
						<th bgcolor="ffff00">supportingOSNameList</th>
					</xsl:if>
					<th bgcolor="6699CC">managed elements</th>
					<th bgcolor="9999CC">multilayer subnetwork</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="mdNm"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/namingOS"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/userLabel"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/source"/>
					</td>
						<td>
						<xsl:value-of select="mdAttrs/owner"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/aliasNameList"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/resourceStatel"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/networkAccessDomain"/>
					</td>
					<td>
						<xsl:value-of select="supportingOSNameList"/>
					</td>
					<td>
						<xsl:apply-templates select="meList"/>
					</td>
					<td align="left">
						<xsl:apply-templates select="mlsnList"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="meInv">
		<table border="2" bordercolor="red">
			<body>
				<tr>
					<!--<xsl:for-each select="meAttrs/*">-->
					<th bgcolor="ff0000">meNm</th>
					<xsl:if test="meAttrs/discoveredName">
						<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="meAttrs/namingOS">
						<th bgcolor="ffff00">namingOS</th>
					</xsl:if>
					<xsl:if test="meAttrs/userLabel">
						<th bgcolor="ffff00">userLabel</th>
					</xsl:if>
					<xsl:if test="meAttrs/containingMLSNNameList">
						<th bgcolor="ffff09">containingMLSNNameList</th>
					</xsl:if>
					<!--<xsl:if test="meAttrs/discoveredName">
					<th bgcolor="#ffff66">source</th>
					<xsl:if test="meAttrs/discoveredName">
					<th bgcolor="#ffff66">owner</th>
					<xsl:if test="meAttrs/discoveredName">
					<th bgcolor="#ffff66">aliasNameList</th>
					<xsl:if test="meAttrs/discoveredName">
					<th bgcolor="#ffff66">resourceState</th>
					<th bgcolor="#ffff66">location</th>
					<th bgcolor="#ffff66">manufacturer</th>
					<th bgcolor="#ffff66">productName</th>
					<th bgcolor="#ffff66">version</th>
					<th bgcolor="#ffff66">InSynState</th>
					<th bgcolor="#ffff66">supportedRates</th>
					<th bgcolor="#ffff66">communicationState</th>
					<th bgcolor="#ffff66">netWorkAccessDomain</th>
					<th bgcolor="#ffff66">manufacturerDate</th>
					<th bgcolor="#ffff66">vendorExtensions</th>-->
					<th bgcolor="66CC66">equipment holders</th>
					<th bgcolor="66CC99">physical termination points</th>
					<th bgcolor="66CCCC">floating termination points</th>
					<th bgcolor="66CCFF">protection group</th>
					<th bgcolor="66CC33">equipment protection group</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="meNm"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/namingOS"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/userLabel"/>
					</td>
					<td>
						<xsl:value-of select="containingMLSNNameList"/>
					</td>
					<!--<td>
						<xsl:value-of select="meAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/source"/>
					</td>-->
					<td>
						<xsl:apply-templates select="ehList"/>
					</td>
					<td>
						<xsl:apply-templates select="ptpList"/>
					</td>
					<td>
						<xsl:apply-templates select="ftpList"/>
					</td>
					<td>
						<xsl:apply-templates select="pgpList"/>
					</td>
					<td>
						<xsl:apply-templates select="epgpList"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="mlsnInv">
		<table border="2" bordercolor="red" bgcolor="6699CC">
			<body>
				<tr>
					<th bgcolor="ff0000">mlsnNm</th>
					
					<xsl:if test="mlsnAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					
					<xsl:if test="mlsnAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					
					<th bgcolor="99CC99">SubNetwork Connection</th>
					
					<th bgcolor="99CCCC">TpPool</th>
					
				</tr>
				<tr>
					<td> 
						<xsl:value-of select="mlsnNm"/>
					</td>
					<td>
						<xsl:value-of select="mlsnAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="mlsnAttrs/resourceState"/>
					</td>
					<td>
						<xsl:apply-templates select="sncList"/>
					</td>
					<td>
						<xsl:apply-templates select="tpPoolList"/>
					</td>
					<!--<td><xsl:apply-templates select="tlList"/> </td>-->
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="ehInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">ehNm</th>
					<xsl:if test="ehAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					
					<xsl:if test="ehAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					
					<xsl:if test="ehAttrs/source">	
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					
					<xsl:if test="ehAttrs/direction">	
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
						
					<th bgcolor="ffcccc">equipments</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ehNm"/>
					</td>
					<td>
						<xsl:value-of select="ehAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="ehAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="ehAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="ehAttrs/direction"/>
					</td>
					<td>
						<xsl:apply-templates select="eqInv"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="ptpInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">ptpNm</th>
					
					<xsl:if test="ptpAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					
						<xsl:if test="ptpAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					
					<xsl:if test="ptpAttrs/source">
					<th bgcolor="ffff00">source</th>
						</xsl:if>
					
					<xsl:if test="ptpAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
					
					<th>connection termination points</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ptpNm"/>
					</td>
					<td>
						<xsl:value-of select="ptpAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="ptpAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="ptpAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="ptpAttrs/direction"/>
					</td>
					<td>
						<xsl:apply-templates select="ctpList"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="ftpInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">ftpNm</th>
					<xsl:if test="ftpAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="ftpAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="fptAttrs/source">
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="ftpAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
					<th>floating termination points</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ftpNm"/>
					</td>
					<td>
						<xsl:value-of select="ftpAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="ftpAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="ftpAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="ftpAttrs/direction"/>
					</td>
					<td>
						<xsl:apply-templates select="ftpList"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="pgpInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">pgpNm</th>
					<xsl:if test="pgpAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="pgpAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="pgpAttrs/source">
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="pgpAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="pgpNm"/>
					</td>
					<td>
						<xsl:value-of select="pgpAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="pgpAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="pgpAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="pgpAttrs/direction"/>
					</td>
					<!--<td>
						<xsl:apply-templates select="eqList"/>
					</td>-->
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="epgpInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">epgpNm</th>
					<xsl:if test="pgpAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="egpAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="epgpAttrs/source">
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="epgpAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="epgpNm"/>
					</td>
					<td>
						<xsl:value-of select="epgpAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="epgpAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="epgpAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="epgpAttrs/direction"/>
					</td>
					<!--<td>
						<xsl:apply-templates select="eqList"/>
					</td>-->
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="sncInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">sncNm</th>
					<xsl:if test="sncAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="sncAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="sncAttrs/source">
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="sncAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="sncNm"/>
					</td>
					<td>
						<xsl:value-of select="sncAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="sncAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="sncAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="sncAttrs/direction"/>
					</td>
					<td>
						<xsl:apply-templates select="ftpList"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="tpPoolInv">
		<table border="1">
			<body>
				<tr>
				<th bgcolor="ff0000">tppoolNm</th>
					<xsl:if test="tppoolAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="tppoolAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="tppoolAttrs/source">
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="tppoolAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="tppoolNm"/>
					</td>
					<td>
						<xsl:value-of select="tppoolAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="tppoolAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="tppoolAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="tppoolAttrs/direction"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="ctpInv">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">ctpNm</th>
					<xsl:if test="ctpAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="ctpAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
					<xsl:if test="ctpAttrs/source">
					<th bgcolor="ffff00">source</th>
					</xsl:if>
					<xsl:if test="ctpAttrs/direction">
					<th bgcolor="ffff00">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ctpNm"/>
					</td>
					<td>
						<xsl:value-of select="ctpAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="ctpAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="ctpAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="ctpAttrs/connectionState"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="eqInv">
		<table border="1">
			<body>
				<tr>
						<th bgcolor="ff0000">eqNm</th>
					<xsl:if test="eqAttrs/discoveredName">
					<th bgcolor="ffff00">discoveredName</th>
					</xsl:if>
					<xsl:if test="eqAttrs/resourceState">
					<th bgcolor="ffff00">resourceState</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="eqNm"/>
					</td>
					<td>
						<xsl:value-of select="eqAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="eqAttrs/resourceState"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
</xsl:stylesheet>
