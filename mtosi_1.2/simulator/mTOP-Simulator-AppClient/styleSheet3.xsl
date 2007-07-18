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
	<xsl:template match="sncList">
		<xsl:apply-templates select="sncInv"/>
	</xsl:template>
	<xsl:template match="ctpList">
		<xsl:apply-templates select="ctpInv"/>
	</xsl:template>

<!-- ************** inv **************** -->

	<xsl:template match="md">
		<table border="2" bordercolor="red" bgcolor="FFCC99">
			<body>
				<tr>
					<th>mdNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>managed elements</th>
					<th>multilayer subnetwork</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="mdNm"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="mdAttrs/source"/>
					</td>
					<td>
						<xsl:apply-templates select="meList"/>
					</td>
					<td>
						<xsl:apply-templates select="mlsnList"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="meInv">
		<table border="2" bordercolor="red" bgcolor="99FFFF">
			<body>
				<tr>
					<th>meNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>equipment holders</th>
					<th>physical termination points</th>
					<th>floating termination points</th>
					<th>protection group</th>
				</tr>
				<tr>
					<td>
						<xsl:value-of select="meNm"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/discoveredName"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/resourceState"/>
					</td>
					<td>
						<xsl:value-of select="meAttrs/source"/>
					</td>
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
				</tr>
			</body>
		</table>
	</xsl:template>
	<xsl:template match="mlsnInv">
		<table border="2" bordercolor="red" bgcolor="6699CC">
			<body>
				<tr>
					<th>mlsnNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
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
						<xsl:value-of select="mlsnAttrs/source"/>
					</td>
					<td>
						<xsl:apply-templates select="sncList"/>
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
					<th>ehNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>direction</th>
					<th>equipments</th>
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
					<th>ptpNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>direction</th>
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
					<th>ftpNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>direction</th>
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
					<th>pgpNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>direction</th>
					<th>??</th>
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
	<xsl:template match="sncInv">
		<table border="1">
			<body>
				<tr>
					<th>sncNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>direction</th>
					<th>subNetwork </th>
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
	<xsl:template match="ctpInv">
		<table border="1">
			<body>
				<tr>
					<th>ctpNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>connection State</th>
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
					<th>eqNm</th>
					<th>discoveredName</th>
					<th>resourceState</th>
					<th>source</th>
					<th>connectionState</th>
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
					<td>
						<xsl:value-of select="eqAttrs/source"/>
					</td>
					<td>
						<xsl:value-of select="eqAttrs/connectionState"/>
					</td>
				</tr>
			</body>
		</table>
	</xsl:template>
</xsl:stylesheet>
