<?xml version="1.0" encoding="ISO-8859-1" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<!--<xsl:output method="html" encoding="ISO-8859-1" />-->
 <xsl:template match="/">
    <html>
<!--<head>
	<title>a</title>
</head>	-->		
			<body>
				<xsl:apply-templates/>
			</body>
		</html>
		</xsl:template>
	
	<!-- ************** lists **************** -->
	<xsl:template match="mdList">
		<xsl:apply-templates select="md"/>
	</xsl:template>
	<xsl:template match="meList">
		<xsl:apply-templates select="meInv"/>
	</xsl:template>
	<xsl:template match="mlsnList">
		<xsl:apply-templates select="mlsnInv"/>
	</xsl:template>
	<xsl:template match="tlList">
		<xsl:apply-templates select="tlInv"/>
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

	<!-- ************** inventories **************** -->
	<xsl:template match="md">
<div style="position:relative;left:5px">
<!--<div class="level1">-->
		<table border="3" bordercolor="black">
			<body>
				<tr>
					<th bgcolor="ff3333">mdNm</th>
					<xsl:if test="mdAttrs/discoveredName">
						<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="mdAttrs/namingOS">
						<th bgcolor="ffff99">namingOS</th>
					</xsl:if>
					<xsl:if test="mdAttrs/userLabel">
						<th bgcolor="ffff99">userLabel</th>
					</xsl:if>
					<xsl:if test="mdAttrs/source">
						<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="mdAttrs/owner">
						<th bgcolor="ffff99">owner</th>
					</xsl:if>
					<xsl:if test="mdAttrs/aliasNameList">
						<th bgcolor="ffff99">aliasNameList</th>
					</xsl:if>
					<xsl:if test="mdAttrs/resourceState">
						<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="mdAttrs/networkAccessDomain">
						<th bgcolor="ffff99">networkAccessDomain</th>
					</xsl:if>
					<xsl:if test="supportingOSNameList">
						<th bgcolor="ff99ff">supportingOSNameList</th>
					</xsl:if>
					<!--<th bgcolor="6699CC">managed elements</th>
					<th bgcolor="9999CC">multilayer subnetwork</th>-->
				</tr>
				<tr>
					<td>
						<xsl:value-of select="mdNm"/>
					</td>
					<xsl:if test="mdAttrs/discoveredName">
					<td>
						<xsl:value-of select="mdAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="mdAttrs/namingOS">
					<td>
						<xsl:value-of select="mdAttrs/namingOS"/>
					</td>
					</xsl:if>
					<xsl:if test="mdAttrs/userLabel">
					<td>
						<xsl:value-of select="mdAttrs/userLabel"/>
					</td>
					</xsl:if>
						<xsl:if test="mdAttrs/source">
					<td>
						<xsl:value-of select="mdAttrs/source"/>
					</td>
					</xsl:if >
					<xsl:if test="mdAttrs/owner">
						<td>
						<xsl:value-of select="mdAttrs/owner"/>
					</td>
					</xsl:if>
					<xsl:if test="mdAttrs/aliasNameList">
					<td>
						<xsl:value-of select="mdAttrs/aliasNameList"/>
					</td>
					</xsl:if>
					<xsl:if test="mdAttrs/resourceState">
					<td>
						<xsl:value-of select="mdAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="mdAttrs/networkAccessDomain">
					<td>
						<xsl:value-of select="mdAttrs/networkAccessDomain"/>
					</td>
					</xsl:if>
					<xsl:if test="supportingOSNameList">
					<td>
					<xsl:value-of select="supportingOSNameList"/>
						</td>
					</xsl:if>
					<!--<td>
						<xsl:apply-templates select="meList"/>
					</td>
					<td align="left">
						<xsl:apply-templates select="mlsnList"/>
					</td>-->
				</tr>
			</body>
		</table>
		<br/>
	<xsl:apply-templates select="meList"/>	
	<xsl:apply-templates select="mlsnList"/>	
	<xsl:apply-templates select="tlList"/>	
	</div>
	</xsl:template>
	
	<xsl:template match="meInv">
	<!--<div class="level2">-->
	<!--<br/>-->
	<div style="position:relative;left:45px">
		<table border="3" bordercolor="330099">
			<body>
				<tr>
					<!--<xsl:for-each select="meAttrs/*">-->
					<th bgcolor="ff3333">meNm</th>
					<xsl:if test="meAttrs/discoveredName">
						<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="meAttrs/namingOS">
						<th bgcolor="ffff99">namingOS</th>
					</xsl:if>
					<xsl:if test="meAttrs/userLabel">
						<th bgcolor="ffff99">userLabel</th>
					</xsl:if>
					<xsl:if test="containingMLSNNameList"> 
						<th bgcolor="ff99ff">containingMLSNNameList</th>
					</xsl:if> 
				</tr>
				<tr>
					<td>
						<xsl:value-of select="meNm"/>
					</td>
				<xsl:if test="meAttrs/discoveredName">
					<td>
						<xsl:value-of select="meAttrs/discoveredName"/>
					</td>
					</xsl:if> 
					<xsl:if test="meAttrs/namingOS">
					<td>
						<xsl:value-of select="meAttrs/namingOS"/>
					</td>
					</xsl:if> 
					<xsl:if test="meAttrs/userLabel">
					<td>
						<xsl:value-of select="meAttrs/userLabel"/>
					</td>
					</xsl:if> 
					<xsl:if test="containingMLSNNameList">
					<td>
						<xsl:value-of select="containingMLSNNameList"/>
					</td>
					</xsl:if> 
					<!--<td>
						<xsl:value-of select="meAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/source"/>
					</td>-->
					<!--<td>
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
					</td>-->
				</tr>
			</body>
		</table>
		<br/>
			<xsl:apply-templates select="ehList"/>	
			<xsl:if test="ptpList">
			<xsl:apply-templates select="ptpList"/>	
			</xsl:if>
			<xsl:if test="ftpList">
			<xsl:apply-templates select="ftpList"/>	
			</xsl:if>
			<xsl:if test="pgpList">
			<xsl:apply-templates select="pgpList"/>	
			</xsl:if>
			<xsl:if test="epgpList">
			<xsl:apply-templates select="epgpList"/>	
			</xsl:if>
		</div>
	</xsl:template>
	
	<xsl:template match="mlsnInv">
	<div style="position:relative;left:45px">
		<table border="3" bordercolor="009999">
			<body>
				<tr>
					<th bgcolor="ff3333">mlsnNm</th>
					<xsl:if test="mlsnAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="mlsnAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="associatedMEList">
					<th bgcolor="ff99ff">associatedMEList</th>
					</xsl:if>
					</tr>
				<tr>				
					<td> 
						<xsl:value-of select="mlsnNm"/>
					</td>
					<xsl:if test="mlsnAttrs/discoveredName">					
					<td>
						<xsl:value-of select="mlsnAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="mlsnAttrs/resourceState">
					<td>
						<xsl:value-of select="mlsnAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="associatedMEList">
					<td>
						<xsl:value-of select="associatedMEList"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
		<br/>
		<xsl:if test="sncList">
		<xsl:apply-templates select="sncList"/>
		</xsl:if>
		<xsl:if test="tpPoolList">
		<xsl:apply-templates select="tpPoolList"/>
		</xsl:if>
		</div>	
	</xsl:template>
	
	<xsl:template match="tlInv">
	<div style="position:relative;left:45px">
		<table border="3" bordercolor="FF9966">
			<body>
				<tr>
					<th bgcolor="ff3333">tlNm</th>
					<xsl:if test="tlAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="tlAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					</tr>
				<tr>				
					<td> 
						<xsl:value-of select="tlNm"/>
					</td>
					<xsl:if test="tlAttrs/discoveredName">					
					<td>
						<xsl:value-of select="tlAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="tlAttrs/resourceState">
					<td>
						<xsl:value-of select="tlAttrs/resourceState"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
		<br/>
		<xsl:if test="sncList">
		<xsl:apply-templates select="sncList"/>
		</xsl:if>
		<xsl:if test="tpPoolList">
		<xsl:apply-templates select="tpPoolList"/>
		</xsl:if>
		</div>	
	</xsl:template>
	
	<xsl:template match="ehInv">
	<div style="position:absolute;left:65px">
		<table border="3" bordercolor="6666FF">
			<body>
				<tr>
					<th bgcolor="ff3333">ehNm</th>
					<xsl:if test="ehAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					
					<xsl:if test="ehAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					
					<xsl:if test="ehAttrs/source">	
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					
					<xsl:if test="ehAttrs/direction">	
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
						
					<!--<th bgcolor="ffcccc">equipments</th>-->
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ehNm"/>
					</td>
					<xsl:if test="ehAttrs/discoveredName">	
					<td>
						<xsl:value-of select="ehAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="ehAttrs/resourceState">
					<td>
						<xsl:value-of select="ehAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="ehAttrs/source">
					<td>
						<xsl:value-of select="ehAttrs/source"/>
					</td>
					</xsl:if>
					<xsl:if test="ehAttrs/direction">
					<td>
						<xsl:value-of select="ehAttrs/direction"/>
					</td>
					</xsl:if>
				<!--	<td>
						<xsl:apply-templates select="eqInv"/>
					</td>-->
				</tr>
			</body>
		</table>
		<br/>
			<xsl:if test="eqInv">
			<xsl:apply-templates select="eqInv"/>
			</xsl:if>
		</div>
	</xsl:template>
	
	<xsl:template match="ptpInv">
	<div style="position:relative;left:65px">
		<table border="3" bordercolor="99FFFF">
			<body>
				<tr>
					<th bgcolor="ff3333">ptpNm</th>
					<xsl:if test="ptpAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					
					<xsl:if test="ptpAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					
					<xsl:if test="ptpAttrs/source">
					<th bgcolor="ffff99">source</th>
						</xsl:if>
					
					<xsl:if test="ptpAttrs/direction">
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
				
					<xsl:if test="supportingEquipList">
					<th bgcolor="ff99ff">supportingEquipList</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ptpNm"/>
					</td>
					<xsl:if test="ptpAttrs/discoveredName">
					<td>
						<xsl:value-of select="ptpAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="ptpAttrs/resourceState">
					<td>
						<xsl:value-of select="ptpAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="ptpAttrs/source">
					<td>
						<xsl:value-of select="ptpAttrs/source"/>
					</td>
					</xsl:if>
					<xsl:if test="ptpAttrs/direction">
					<td>
						<xsl:value-of select="ptpAttrs/direction"/>
					</td>
					</xsl:if>
				<xsl:if test="supportingEquipList">
					<td>
					<xsl:value-of select="supportingEquipList"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
<br/>
			<xsl:apply-templates select="ctpInv"/>
</div>	
	</xsl:template>
	
	<xsl:template match="ftpInv">
	<div style="position:relative;left:65px">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff3333">ftpNm</th>
					<xsl:if test="ftpAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="ftpAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="fptAttrs/source">
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="ftpAttrs/direction">
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
					<th>floating termination points</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ftpNm"/>
					</td>
						<xsl:if test="ftpAttrs/discoveredName">
					<td>
						<xsl:value-of select="ftpAttrs/discoveredName"/>
					</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/resourceState">
					<td>
						<xsl:value-of select="ftpAttrs/resourceState"/>
					</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/source">
					<td>
						<xsl:value-of select="ftpAttrs/source"/>
					</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/direction">
					<td>
						<xsl:value-of select="ftpAttrs/direction"/>
					</td>
						</xsl:if>
				</tr>
			</body>
		</table>
		<br/>
<xsl:if test="ctpInv">
			<xsl:apply-templates select="ctpInv"/>
			</xsl:if>
</div>	
	</xsl:template>
	
	<xsl:template match="pgpInv">
	<div style="position:relative;left:65px">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff3333">pgpNm</th>
					<xsl:if test="pgpAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="pgpAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="pgpAttrs/source">
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="pgpAttrs/direction">
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="pgpNm"/>
					</td>
					<xsl:if test="pgpAttrs/discoveredName">
					<td>
						<xsl:value-of select="pgpAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="pgpAttrs/resourceState">
					<td>
						<xsl:value-of select="pgpAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="pgpAttrs/source">
					<td>
						<xsl:value-of select="pgpAttrs/source"/>
					</td>
					</xsl:if>
					<xsl:if test="pgpAttrs/direction">
					<td>
						<xsl:value-of select="pgpAttrs/direction"/>
					</td>
					</xsl:if>
					<!--<td>
						<xsl:apply-templates select="eqList"/>
					</td>-->
				</tr>
			</body>
		</table>
	</div>
	</xsl:template>

	<xsl:template match="epgpInv">
<div style="position:relative;left:65px">
		<table border="1">
			<body>
				<tr>
					<th bgcolor="ff0000">epgpNm</th>
					<xsl:if test="pgpAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="egpAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="epgpAttrs/source">
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="epgpAttrs/direction">
					<th bgcolor="ffff99">direction</th>
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
</div>	
	</xsl:template>

	<xsl:template match="sncInv">
	<div style="position:relative;left:65px">
			<table border="3" bordercolor="FF9999">
			<body>
				<tr>
					<th bgcolor="ff3333">sncNm</th>
					<xsl:if test="sncAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="sncAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="sncAttrs/source">
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="sncAttrs/direction">
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="sncNm"/>
					</td>
					<xsl:if test="sncAttrs/discoveredName">
					<td>
						<xsl:value-of select="sncAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="sncAttrs/discoveredName">
					<td>
						<xsl:value-of select="sncAttrs/resourceState"/>
					</td>
						</xsl:if>
					<xsl:if test="sncAttrs/discoveredName">
					<td>
						<xsl:value-of select="sncAttrs/source"/>
					</td>
					</xsl:if>
					<xsl:if test="sncAttrs/direction">
					<td>
						<xsl:value-of select="sncAttrs/direction"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
		<br/>
		</div>
	</xsl:template>
	
	<xsl:template match="tpPoolInv">
	<div style="position:relative;left:65px">
		<table border="3" bordercolor="9999CC">
			<body>
				<tr>
				<th bgcolor="ff3333">tppoolNm</th>
					<xsl:if test="tppoolAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="tppoolAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="tppoolAttrs/source">
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="tppoolAttrs/direction">
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="tppoolNm"/>
					</td>
					<xsl:if test="tppoolAttrs/discoveredName">
					<td>
						<xsl:value-of select="tppoolAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="tppoolAttrs/resourceState">
					<td>
						<xsl:value-of select="tppoolAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="tppoolAttrs/source">
					<td>
						<xsl:value-of select="tppoolAttrs/source"/>
					</td>
					</xsl:if>
					<xsl:if test="tppoolAttrs/direction">
					<td>
						<xsl:value-of select="tppoolAttrs/direction"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
	</div>	
	</xsl:template>
	
	<xsl:template match="ctpInv">
		<div style="position:relative;left:85px">
		<table border="3" bordercolor="CCFFFF">
			<body>
				<tr>
					<th bgcolor="ff0000">ctpNm</th>
					<xsl:if test="ctpAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="ctpAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
					<xsl:if test="ctpAttrs/source">
					<th bgcolor="ffff99">source</th>
					</xsl:if>
					<xsl:if test="ctpAttrs/direction">
					<th bgcolor="ffff99">direction</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="ctpNm"/>
					</td>
					<xsl:if test="ctpAttrs/discoveredName">
					<td>
						<xsl:value-of select="ctpAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="ctpAttrs/resourceState">
					<td>
						<xsl:value-of select="ctpAttrs/resourceState"/>
					</td>
					</xsl:if>
					<xsl:if test="ctpAttrs/source">
					<td>
						<xsl:value-of select="ctpAttrs/source"/>
					</td>
					</xsl:if>
					<xsl:if test="ctpAttrs/connectionState">
					<td>
						<xsl:value-of select="ctpAttrs/connectionState"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
	</div>
	</xsl:template>
	
	<xsl:template match="eqInv">
	<div style="position:relative;left:85px">
		<table border="3" bordercolor="9999FF">
			<body>
				<tr>
						<th bgcolor="ff3333">eqNm</th>
					<xsl:if test="eqAttrs/discoveredName">
					<th bgcolor="ffff99">discoveredName</th>
					</xsl:if>
					<xsl:if test="eqAttrs/resourceState">
					<th bgcolor="ffff99">resourceState</th>
					</xsl:if>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="eqNm"/>
					</td>
					<xsl:if test="eqAttrs/discoveredName">
					<td>
						<xsl:value-of select="eqAttrs/discoveredName"/>
					</td>
					</xsl:if>
					<xsl:if test="eqAttrs/resourceState">
					<td>
						<xsl:value-of select="eqAttrs/resourceState"/>
					</td>
					</xsl:if>
				</tr>
			</body>
		</table>
		</div>
	</xsl:template>
</xsl:stylesheet>
