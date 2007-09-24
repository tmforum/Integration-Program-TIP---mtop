<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!--good-->
	<xsl:template match="/">
		<html>
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
		<xsl:apply-templates select="ftpInv"/>
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
						<xsl:if test="mdAttrs/supportingOSNameList">
							<th bgcolor="ff99ff">supportingOSNameList</th>
						</xsl:if>
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
						</xsl:if>
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
						<xsl:if test="mdAttrs/supportingOSNameList">
							<td>
								<xsl:value-of select="mdAttrs/supportingOSNameList"/>
							</td>
						</xsl:if>
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
		<div style="position:relative;left:45px">
			<table border="3" bordercolor="330099">
				<body>
					<tr>
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
						<xsl:if test="meAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="meAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="meAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="meAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="meAttrs/location">
							<th bgcolor="ffff99">location</th>
						</xsl:if>
						<xsl:if test="meAttrs/manufacturer">
							<th bgcolor="ffff99">manufacturer</th>
						</xsl:if>
						<xsl:if test="meAttrs/productName">
							<th bgcolor="ffff99">productName</th>
						</xsl:if>
						<xsl:if test="meAttrs/version">
							<th bgcolor="ffff99">version</th>
						</xsl:if>
						<xsl:if test="meAttrs/InSyncState">
							<th bgcolor="ffff99">InSyncState</th>
						</xsl:if>
						<xsl:if test="meAttrs/supportedRates">
							<th bgcolor="ffff99">supportedRates</th>
						</xsl:if>
						<xsl:if test="meAttrs/communicationState">
							<th bgcolor="ffff99">communicationState</th>
						</xsl:if>
						<xsl:if test="meAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="meAttrs/manufacturerDate">
							<th bgcolor="ffff99">manufacturerDate</th>
						</xsl:if>
						<xsl:if test="meAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
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
						<xsl:if test="meAttrs/source">
							<td>
								<xsl:value-of select="meAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/owner">
							<td>
								<xsl:value-of select="meAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/aliasNameList">
							<td>
								<xsl:value-of select="meAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/resourceState">
							<td>
								<xsl:value-of select="meAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/location">
							<td>
								<xsl:value-of select="meAttrs/location"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/manufacturer">
							<td>
								<xsl:value-of select="meAttrs/manufacturer"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/productName">
							<td>
								<xsl:value-of select="meAttrs/productName"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/version">
							<td>
								<xsl:value-of select="meAttrs/version"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/InSyncState">
							<td>
								<xsl:value-of select="meAttrs/InSyncState"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/supportedRates">
							<td>
								<xsl:value-of select="meAttrs/supportedRates"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/communicationState">
							<td>
								<xsl:value-of select="meAttrs/communicationState"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/networkAccessDomain">
							<td>
								<xsl:value-of select="meAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/manufacturerDate">
							<td>
								<xsl:value-of select="meAttrs/manufacturerDate"/>
							</td>
						</xsl:if>
						<xsl:if test="meAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="meAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
						<xsl:if test="containingMLSNNameList">
							<td>
								<xsl:value-of select="containingMLSNNameList"/>
							</td>
						</xsl:if>
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
						<xsl:if test="mlsnAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/subnetworkType">
							<th bgcolor="ffff99">subnetworkType</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/supportedRates">
							<th bgcolor="ffff99">supportedRates</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="mlsnAttrs/vendorExtension">
							<th bgcolor="ffff99">vendorExtension</th>
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
						<xsl:if test="mlsnAttrs/namingOS">
							<td>
								<xsl:value-of select="mlsnAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/userLabel">
							<td>
								<xsl:value-of select="mlsnAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/source">
							<td>
								<xsl:value-of select="mlsnAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/owner">
							<td>
								<xsl:value-of select="mlsnAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/aliasNameList">
							<td>
								<xsl:value-of select="mlsnAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/resourceState">
							<td>
								<xsl:value-of select="mlsnAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/supportedRates">
							<td>
								<xsl:value-of select="mlsnAttrs/supportedRates"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/networkAccessDomain">
							<td>
								<xsl:value-of select="mlsnAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="mlsnAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="mlsnAttrs/vendorExtensions"/>
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
						<xsl:if test="tlAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="tlAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="tlAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="tlAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="tlAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="tlAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="tlAttrs/direction">
							<th bgcolor="ffff99">direction</th>
						</xsl:if>
						<xsl:if test="tlAttrs/rate">
							<th bgcolor="ffff99">rate</th>
						</xsl:if>
						<xsl:if test="tlAttrs/aEndTP">
							<th bgcolor="ffff99">aEndTP</th>
						</xsl:if>
						<xsl:if test="tlAttrs/zEndTP">
							<th bgcolor="ffff99">zEndTP</th>
						</xsl:if>
						<xsl:if test="tlAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="tlAttrs/alarmReportingIndicator">
							<th bgcolor="ffff99">alarmReportingIndicator</th>
						</xsl:if>
						<xsl:if test="tlAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
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
						<xsl:if test="tlAttrs/namingOS">
							<td>
								<xsl:value-of select="tlAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/userLabel">
							<td>
								<xsl:value-of select="tlAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/source">
							<td>
								<xsl:value-of select="tlAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/owner">
							<td>
								<xsl:value-of select="tlAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/aliasNameList">
							<td>
								<xsl:value-of select="tlAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/resourceState">
							<td>
								<xsl:value-of select="tlAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/direction">
							<td>
								<xsl:value-of select="tlAttrs/direction"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/rate">
							<td>
								<xsl:value-of select="tlAttrs/rate"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/aEndTP">
							<td>
								<xsl:value-of select="tlAttrs/aEndTP"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/zEndTP">
							<td>
								<xsl:value-of select="tlAttrs/zEndTP"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/networkAccessDomain">
							<td>
								<xsl:value-of select="tlAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/alarmReportingIndicator">
							<td>
								<xsl:value-of select="tlAttrs/alarmReportingIndicator"/>
							</td>
						</xsl:if>
						<xsl:if test="tlAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="tlAttrs/vendorExtensions"/>
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
		<div style="position:relative;left:65px">
			<table border="3" bordercolor="6666FF">
				<body>
					<tr>
						<th bgcolor="ff3333">ehNm</th>
						<xsl:if test="ehAttrs/discoveredName">
							<th bgcolor="ffff99">discoveredName</th>
						</xsl:if>
						<xsl:if test="ehAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="ehAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="ehAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="ehAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="ehAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="ehAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="ehAttrs/alarmReportingIndicator">
							<th bgcolor="ffff99">alarmReportingIndicator</th>
						</xsl:if>
						<xsl:if test="ehAttrs/holderType">
							<th bgcolor="ffff99">holderType</th>
						</xsl:if>
						<xsl:if test="ehAttrs/acceptableEquipmentTypeList">
							<th bgcolor="ffff99">acceptableEquipmentTypeList</th>
						</xsl:if>
						<xsl:if test="ehAttrs/expectedOrInstalledEquipment">
							<th bgcolor="ffff99">expectedOrInstalledEquipment</th>
						</xsl:if>
						<xsl:if test="ehAttrs/holderState">
							<th bgcolor="ffff99">holderState</th>
						</xsl:if>
						<xsl:if test="ehAttrs/location">
							<th bgcolor="ffff99">location</th>
						</xsl:if>
						<xsl:if test="ehAttrs/manufacturer">
							<th bgcolor="ffff99">manufacturer</th>
						</xsl:if>
						<xsl:if test="ehAttrs/manufacturerDate">
							<th bgcolor="ffff99">manufacturerDate</th>
						</xsl:if>
						<xsl:if test="ehAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
						</xsl:if>
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
						<xsl:if test="ehAttrs/namingOS">
							<td>
								<xsl:value-of select="ehAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/userLabel">
							<td>
								<xsl:value-of select="ehAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/source">
							<td>
								<xsl:value-of select="ehAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/owner">
							<td>
								<xsl:value-of select="ehAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/aliasNameList">
							<td>
								<xsl:value-of select="ehAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/resourceState">
							<td>
								<xsl:value-of select="ehAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/alarmReportingIndicator">
							<td>
								<xsl:value-of select="ehAttrs/alarmReportingIndicator"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/holderType">
							<td>
								<xsl:value-of select="ehAttrs/holderType"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/acceptableEquipmentTypeList">
							<td>
								<xsl:value-of select="ehAttrs/acceptableEquipmentTypeList"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/expectedOrInstalledEquipment">
							<td>
								<xsl:value-of select="ehAttrs/expectedOrInstalledEquipment"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/holderState">
							<td>
								<xsl:value-of select="ehAttrs/holderState"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/location">
							<td>
								<xsl:value-of select="ehAttrs/location"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/manufacturer">
							<td>
								<xsl:value-of select="ehAttrs/manufacturer"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/manufacturerDate">
							<td>
								<xsl:value-of select="ehAttrs/manufacturerDate"/>
							</td>
						</xsl:if>
						<xsl:if test="ehAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="ehAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
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
						<xsl:if test="ptpAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/direction">
							<th bgcolor="ffff99">direction</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/tpProtectionAssociation">
							<th bgcolor="ffff99">tpProtectionAssociation</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/edgePoint">
							<th bgcolor="ffff99">edgePoint</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/equipmentProtected">
							<th bgcolor="ffff99">equipmentProtected</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/egressTMDState">
							<th bgcolor="ffff99">egressTMDState</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/ingressTMDState">
							<th bgcolor="ffff99">InSyncState</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/ingressTransmissionDescriptor">
							<th bgcolor="ffff99">ingressTransmissionDescriptor</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/egressTransmissionDescriptor">
							<th bgcolor="ffff99">egressTransmissionDescriptor</th>
						</xsl:if>
						<xsl:if test="ptpAttrs/transmissionParams">
							<th bgcolor="ffff99">transmissionParams</th>
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
						<xsl:if test="ptpAttrs/namingOS">
							<td>
								<xsl:value-of select="ptpAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/userLabel">
							<td>
								<xsl:value-of select="ptpAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/source">
							<td>
								<xsl:value-of select="ptpAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/owner">
							<td>
								<xsl:value-of select="ptpAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/aliasNameList">
							<td>
								<xsl:value-of select="ptpAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/resourceState">
							<td>
								<xsl:value-of select="ptpAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/direction">
							<td>
								<xsl:value-of select="ptpAttrs/direction"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/tpProtectionAssociation">
							<td>
								<xsl:value-of select="ptpAttrs/tpProtectionAssociation"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/edgePoint">
							<td>
								<xsl:value-of select="ptpAttrs/edgePoint"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/networkAccessDomain">
							<td>
								<xsl:value-of select="ptpAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/equipmentProtected">
							<td>
								<xsl:value-of select="ptpAttrs/equipmentProtected"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/egressTMDState">
							<td>
								<xsl:value-of select="ptpAttrs/egressTMDState"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/ingressTMDState">
							<td>
								<xsl:value-of select="ptpAttrs/ingressTMDState"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/ingressTransmissionDescriptor">
							<td>
								<xsl:value-of select="ptpAttrs/ingressTransmissionDescriptor"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/manufacturerDate">
							<td>
								<xsl:value-of select="ptpAttrs/manufacturerDate"/>
							</td>
						</xsl:if>
						<xsl:if test="ptpAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="ptpAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
					</tr>
				</body>
			</table>
			<br/>
			<xsl:if test="ctpList">
				<xsl:apply-templates select="ctpList"/>
			</xsl:if>
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
						<xsl:if test="ftpAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/direction">
							<th bgcolor="ffff99">direction</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/tpProtectionAssociation">
							<th bgcolor="ffff99">tpProtectionAssociation</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/edgePoint">
							<th bgcolor="ffff99">edgePoint</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/equipmentProtected">
							<th bgcolor="ffff99">equipmentProtected</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/egressTMDState">
							<th bgcolor="ffff99">egressTMDState</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/ingressTMDState">
							<th bgcolor="ffff99">InSyncState</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/connectionState">
							<th bgcolor="ffff99">connectionState</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/tpMappingMode">
							<th bgcolor="ffff99">tpMappingMode</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/ingressTransmissionDescriptor">
							<th bgcolor="ffff99">ingressTransmissionDescriptor</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/egressTransmissionDescriptor">
							<th bgcolor="ffff99">egressTransmissionDescriptor</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/transmissionParams">
							<th bgcolor="ffff99">transmissionParams</th>
						</xsl:if>
						<xsl:if test="ftpAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
						</xsl:if>
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
						<xsl:if test="ftpAttrs/namingOS">
							<td>
								<xsl:value-of select="ftpAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/userLabel">
							<td>
								<xsl:value-of select="ftpAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/source">
							<td>
								<xsl:value-of select="ftpAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/owner">
							<td>
								<xsl:value-of select="ftpAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/aliasNameList">
							<td>
								<xsl:value-of select="ftpAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/resourceState">
							<td>
								<xsl:value-of select="ftpAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/direction">
							<td>
								<xsl:value-of select="ftpAttrs/direction"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/tpProtectionAssociation">
							<td>
								<xsl:value-of select="ftpAttrs/tpProtectionAssociation"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/edgePoint">
							<td>
								<xsl:value-of select="ftpAttrs/edgePoint"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/networkAccessDomain">
							<td>
								<xsl:value-of select="ftpAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/equipmentProtected">
							<td>
								<xsl:value-of select="ftpAttrs/equipmentProtected"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/egressTMDState">
							<td>
								<xsl:value-of select="ftpAttrs/egressTMDState"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/ingressTMDState">
							<td>
								<xsl:value-of select="ftpAttrs/ingressTMDState"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/ingressTransmissionDescriptor">
							<td>
								<xsl:value-of select="ftpAttrs/ingressTransmissionDescriptor"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/manufacturerDate">
							<td>
								<xsl:value-of select="ftpAttrs/manufacturerDate"/>
							</td>
						</xsl:if>
						<xsl:if test="ftpAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="ftpAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
					</tr>
				</body>
			</table>
			<br/>
			<xsl:if test="ctpList">
				<xsl:apply-templates select="ctpList"/>
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
						<xsl:if test="pgpAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/protectionGroupType">
							<th bgcolor="ffff99">protectionGroupType</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/protectionSchemeState">
							<th bgcolor="ffff99">protectionSchemeState</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/reversionMode">
							<th bgcolor="ffff99">reversionMode</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/rate">
							<th bgcolor="ffff99">rate</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/pgpParameters">
							<th bgcolor="ffff99">pgpParameters</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/pgpTPList">
							<th bgcolor="ffff99">pgpTPList</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/G_774_3_APSfunction">
							<th bgcolor="ffff99">G_774_3_APSfunction</th>
						</xsl:if>
						<xsl:if test="pgpAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
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
						<xsl:if test="pgpAttrs/namingOS">
							<td>
								<xsl:value-of select="pgpAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/userLabel">
							<td>
								<xsl:value-of select="pgpAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/source">
							<td>
								<xsl:value-of select="pgpAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/owner">
							<td>
								<xsl:value-of select="pgpAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/aliasNameList">
							<td>
								<xsl:value-of select="pgpAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/resourceState">
							<td>
								<xsl:value-of select="pgpAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/protectionGroupType">
							<td>
								<xsl:value-of select="pgpAttrs/protectionGroupType"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/protectionSchemeState">
							<td>
								<xsl:value-of select="pgpAttrs/protectionSchemeState"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/reversionMode">
							<td>
								<xsl:value-of select="pgpAttrs/reversionMode"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/rate">
							<td>
								<xsl:value-of select="pgpAttrs/rate"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/pgpParameters">
							<td>
								<xsl:value-of select="pgpAttrs/pgpParameters"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/pgpTPList">
							<td>
								<xsl:value-of select="pgpAttrs/pgpTPList"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/G_774_3_APSfunction">
							<td>
								<xsl:value-of select="pgpAttrs/G_774_3_APSfunction"/>
							</td>
						</xsl:if>
						<xsl:if test="pgpAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="pgpAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
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
						<th bgcolor="ff3333">epgpNm</th>
						<xsl:if test="epgpAttrs/discoveredName">
							<th bgcolor="ffff99">discoveredName</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/protectionGroupType">
							<th bgcolor="ffff99">protectionGroupType</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/protectionSchemeState">
							<th bgcolor="ffff99">protectionSchemeState</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/reversionMode">
							<th bgcolor="ffff99">reversionMode</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/rate">
							<th bgcolor="ffff99">rate</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/epgpParameters">
							<th bgcolor="ffff99">epgpParameters</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/epgpTPList">
							<th bgcolor="ffff99">epgpTPList</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/G_774_3_APSfunction">
							<th bgcolor="ffff99">G_774_3_APSfunction</th>
						</xsl:if>
						<xsl:if test="epgpAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
						</xsl:if>
					</tr>
					<tr>
						<td>
							<xsl:value-of select="epgpNm"/>
						</td>
						<xsl:if test="epgpAttrs/discoveredName">
							<td>
								<xsl:value-of select="epgpAttrs/discoveredName"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/namingOS">
							<td>
								<xsl:value-of select="epgpAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/userLabel">
							<td>
								<xsl:value-of select="epgpAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/source">
							<td>
								<xsl:value-of select="epgpAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/owner">
							<td>
								<xsl:value-of select="epgpAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/aliasNameList">
							<td>
								<xsl:value-of select="epgpAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/resourceState">
							<td>
								<xsl:value-of select="epgpAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/protectionGroupType">
							<td>
								<xsl:value-of select="epgpAttrs/protectionGroupType"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/protectionSchemeState">
							<td>
								<xsl:value-of select="epgpAttrs/protectionSchemeState"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/reversionMode">
							<td>
								<xsl:value-of select="epgpAttrs/reversionMode"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/rate">
							<td>
								<xsl:value-of select="epgpAttrs/rate"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/epgpParameters">
							<td>
								<xsl:value-of select="epgpAttrs/epgpParameters"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/epgpTPList">
							<td>
								<xsl:value-of select="epgpAttrs/epgpTPList"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/G_774_3_APSfunction">
							<td>
								<xsl:value-of select="epgpAttrs/G_774_3_APSfunction"/>
							</td>
						</xsl:if>
						<xsl:if test="epgpAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="epgpAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
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
						<xsl:if test="sncAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="sncAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="sncAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="sncAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="sncAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="sncAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="sncAttrs/sncState">
							<th bgcolor="ffff99">sncState</th>
						</xsl:if>
						<xsl:if test="sncAttrs/direction">
							<th bgcolor="ffff99">direction</th>
						</xsl:if>
						<xsl:if test="sncAttrs/rate">
							<th bgcolor="ffff99">rate</th>
						</xsl:if>
						<xsl:if test="sncAttrs/staticProtectionLevel">
							<th bgcolor="ffff99">staticProtectionLevel</th>
						</xsl:if>
						<xsl:if test="sncAttrs/sncType">
							<th bgcolor="ffff99">sncType</th>
						</xsl:if>
						<xsl:if test="sncAttrs/aEnd">
							<th bgcolor="ffff99">aEnd</th>
						</xsl:if>
						<xsl:if test="sncAttrs/zEnd">
							<th bgcolor="ffff99">zEnd</th>
						</xsl:if>
						<xsl:if test="sncAttrs/rerouteAllowed">
							<th bgcolor="ffff99">rerouteAllowed</th>
						</xsl:if>
						<xsl:if test="sncAttrs/networkRouted">
							<th bgcolor="ffff99">networkRouted</th>
						</xsl:if>
						<xsl:if test="sncAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="sncAttrs/alarmReportingIndicator">
							<th bgcolor="ffff99">alarmReportingIndicator</th>
						</xsl:if>
						<xsl:if test="sncAttrs/fixed">
							<th bgcolor="ffff99">fixed</th>
						</xsl:if>
						<xsl:if test="sncAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
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
						<xsl:if test="sncAttrs/namingOS">
							<td>
								<xsl:value-of select="sncAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/userLabel">
							<td>
								<xsl:value-of select="sncAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/source">
							<td>
								<xsl:value-of select="sncAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/owner">
							<td>
								<xsl:value-of select="sncAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/aliasNameList">
							<td>
								<xsl:value-of select="sncAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/resourceState">
							<td>
								<xsl:value-of select="sncAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/sncState">
							<td>
								<xsl:value-of select="sncAttrs/sncState"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/direction">
							<td>
								<xsl:value-of select="sncAttrs/direction"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/rate">
							<td>
								<xsl:value-of select="sncAttrs/rate"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/staticProtectionLevel">
							<td>
								<xsl:value-of select="sncAttrs/staticProtectionLevel"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/sncType">
							<td>
								<xsl:value-of select="sncAttrs/sncType"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/aEnd">
							<td>
								<xsl:value-of select="sncAttrs/aEnd"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/zEnd">
							<td>
								<xsl:value-of select="sncAttrs/zEnd"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/rerouteAllowed">
							<td>
								<xsl:value-of select="sncAttrs/rerouteAllowed"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/networkRouted">
							<td>
								<xsl:value-of select="sncAttrs/networkRouted"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/networkRouted">
							<td>
								<xsl:value-of select="sncAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/alarmReportingIndicator">
							<td>
								<xsl:value-of select="sncAttrs/alarmReportingIndicator"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/fixed">
							<td>
								<xsl:value-of select="sncAttrs/fixed"/>
							</td>
						</xsl:if>
						<xsl:if test="sncAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="sncAttrs/vendorExtensions"/>
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
						<th bgcolor="ff3333">tpPoolNm</th>
						<xsl:if test="tppoolAttrs/discoveredName">
							<th bgcolor="ffff99">discoveredName</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/alarmReportingIndicator">
							<th bgcolor="ffff99">alarmReportingIndicator</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/holderType">
							<th bgcolor="ffff99">holderType</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/acceptableEquipmentTypeList">
							<th bgcolor="ffff99">acceptableEquipmentTypeList</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/expectedOrInstalledEquipment">
							<th bgcolor="ffff99">expectedOrInstalledEquipment</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/holderState">
							<th bgcolor="ffff99">holderState</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/location">
							<th bgcolor="ffff99">location</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/manufacturer">
							<th bgcolor="ffff99">manufacturer</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/manufacturerDate">
							<th bgcolor="ffff99">manufacturerDate</th>
						</xsl:if>
						<xsl:if test="tppoolAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
						</xsl:if>
					</tr>
					<tr>
						<td>
							<xsl:value-of select="tpPoolNm"/>
						</td>
						<xsl:if test="tppoolAttrs/discoveredName">
							<td>
								<xsl:value-of select="tppoolAttrs/discoveredName"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/namingOS">
							<td>
								<xsl:value-of select="tppoolAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/userLabel">
							<td>
								<xsl:value-of select="tppoolAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/source">
							<td>
								<xsl:value-of select="tppoolAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/owner">
							<td>
								<xsl:value-of select="tppoolAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/aliasNameList">
							<td>
								<xsl:value-of select="tppoolAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/resourceState">
							<td>
								<xsl:value-of select="tppoolAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/alarmReportingIndicator">
							<td>
								<xsl:value-of select="tppoolAttrs/alarmReportingIndicator"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/holderType">
							<td>
								<xsl:value-of select="tppoolAttrs/holderType"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/acceptableEquipmentTypeList">
							<td>
								<xsl:value-of select="tppoolAttrs/acceptableEquipmentTypeList"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/expectedOrInstalledEquipment">
							<td>
								<xsl:value-of select="tppoolAttrs/expectedOrInstalledEquipment"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/holderState">
							<td>
								<xsl:value-of select="tppoolAttrs/holderState"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/location">
							<td>
								<xsl:value-of select="tppoolAttrs/location"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/manufacturer">
							<td>
								<xsl:value-of select="tppoolAttrs/manufacturer"/>
							</td>
						</xsl:if>
						<xsl:if test="tppoolAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="tppoolAttrs/vendorExtensions"/>
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
						<th bgcolor="ff3333">ctpNm</th>
						<xsl:if test="ctpAttrs/discoveredName">
							<th bgcolor="ffff99">discoveredName</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/direction">
							<th bgcolor="ffff99">direction</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/tpProtectionAssociation">
							<th bgcolor="ffff99">tpProtectionAssociation</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/edgePoint">
							<th bgcolor="ffff99">edgePoint</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/networkAccessDomain">
							<th bgcolor="ffff99">networkAccessDomain</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/equipmentProtected">
							<th bgcolor="ffff99">equipmentProtected</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/egressTMDState">
							<th bgcolor="ffff99">egressTMDState</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/ingressTMDState">
							<th bgcolor="ffff99">ingressTMDState</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/connectionState">
							<th bgcolor="ffff99">connectionState</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/tpMappinMode">
							<th bgcolor="ffff99">tpMappingMode</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/ingressTransmissionDescriptorName">
							<th bgcolor="ffff99">ingressTransmissionDescriptorName</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/egressTransmissionDescriptorName">
							<th bgcolor="ffff99">egressTransmissionDescriptorName</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/transmissionParams">
							<th bgcolor="ffff99">transmissionParams</th>
						</xsl:if>
						<xsl:if test="ctpAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
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
						<xsl:if test="ctpAttrs/namingOS">
							<td>
								<xsl:value-of select="ctpAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/userLabel">
							<td>
								<xsl:value-of select="ctpAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/source">
							<td>
								<xsl:value-of select="ctpAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/owner">
							<td>
								<xsl:value-of select="ctpAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/aliasNameList">
							<td>
								<xsl:value-of select="ctpAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/resourceState">
							<td>
								<xsl:value-of select="ctpAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/direction">
							<td>
								<xsl:value-of select="ctpAttrs/direction"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/tpProtectionAssoctiation">
							<td>
								<xsl:value-of select="ctpAttrs/tpProtectionAssociation"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/edgePoint">
							<td>
								<xsl:value-of select="ctpAttrs/edgePoint"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/networkAccessDomain">
							<td>
								<xsl:value-of select="ctpAttrs/networkAccessDomain"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/equipmentProtected">
							<td>
								<xsl:value-of select="ctpAttrs/equipmentProtected"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/egressTMDState">
							<td>
								<xsl:value-of select="ctpAttrs/egressTMDState"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/ingressTMDState">
							<td>
								<xsl:value-of select="ctpAttrs/ingressTMDState"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/connectionState">
							<td>
								<xsl:value-of select="ctpAttrs/connectionState"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/tpMappingMode">
							<td>
								<xsl:value-of select="ctpAttrs/tpMappingMode"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/ingressTransmissionDescriptorName">
							<td>
								<xsl:value-of select="ctpAttrs/ingressTransmissionDescriptorName"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/egressTransmissionDescriptorName">
							<td>
								<xsl:value-of select="ctpAttrs/egressTransmissionDescriptorName"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/transmissionParams">
							<td>
								<xsl:value-of select="ctpAttrs/transmissionParams"/>
							</td>
						</xsl:if>
						<xsl:if test="ctpAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="ctpAttrs/vendorExtensions"/>
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
						<xsl:if test="eqAttrs/namingOS">
							<th bgcolor="ffff99">namingOS</th>
						</xsl:if>
						<xsl:if test="eqAttrs/userLabel">
							<th bgcolor="ffff99">userLabel</th>
						</xsl:if>
						<xsl:if test="eqAttrs/source">
							<th bgcolor="ffff99">source</th>
						</xsl:if>
						<xsl:if test="eqAttrs/owner">
							<th bgcolor="ffff99">owner</th>
						</xsl:if>
						<xsl:if test="eqAttrs/aliasNameList">
							<th bgcolor="ffff99">aliasNameList</th>
						</xsl:if>
						<xsl:if test="eqAttrs/resourceState">
							<th bgcolor="ffff99">resourceState</th>
						</xsl:if>
						<xsl:if test="eqAttrs/alarmReportingIndicator">
							<th bgcolor="ffff99">alarmReportingIndicator</th>
						</xsl:if>
						<xsl:if test="eqAttrs/expectedEquipmentObjectType">
							<th bgcolor="ffff99">expectedEquipmentObjectType</th>
						</xsl:if>
						<xsl:if test="eqAttrs/installedEquipmentObjectType">
							<th bgcolor="ffff99">installedEquipmentObjectType</th>
						</xsl:if>
						<xsl:if test="eqAttrs/installedPartNumber">
							<th bgcolor="ffff99">installedPartNumber</th>
						</xsl:if>
						<xsl:if test="eqAttrs/installedSerialNumber">
							<th bgcolor="ffff99">installedSerialNumber</th>
						</xsl:if>
						<xsl:if test="eqAttrs/servciceState">
							<th bgcolor="ffff99">serviceState</th>
						</xsl:if>
						<xsl:if test="eqAttrs/installedVersion">
							<th bgcolor="ffff99">installedVersion</th>
						</xsl:if>
						<xsl:if test="eqAttrs/manufacturer">
							<th bgcolor="ffff99">manufacturer</th>
						</xsl:if>
						<xsl:if test="eqAttrs/protectionRole">
							<th bgcolor="ffff99">protectionRole</th>
						</xsl:if>
						<xsl:if test="eqAttrs/protectionRoleSchemeState">
							<th bgcolor="ffff99">protectionRoleSchemeState</th>
						</xsl:if>
						<xsl:if test="eqAttrs/manufacturerDate">
							<th bgcolor="ffff99">manufacturerDate</th>
						</xsl:if>
						<xsl:if test="eqAttrs/vendorExtensions">
							<th bgcolor="ffff99">vendorExtensions</th>
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
						<xsl:if test="eqAttrs/namingOS">
							<td>
								<xsl:value-of select="eqAttrs/namingOS"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/userLabel">
							<td>
								<xsl:value-of select="eqAttrs/userLabel"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/source">
							<td>
								<xsl:value-of select="eqAttrs/source"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/owner">
							<td>
								<xsl:value-of select="eqAttrs/owner"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/aliasNameList">
							<td>
								<xsl:value-of select="eqAttrs/aliasNameList"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/resourceState">
							<td>
								<xsl:value-of select="eqAttrs/resourceState"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/alarmReportingIndicator">
							<td>
								<xsl:value-of select="eqAttrs/alarmReportingIndicator"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/expectedEquipmentObjectType">
							<td>
								<xsl:value-of select="eqAttrs/expectedEquipmentObjectType"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/installedEquipmentObjectType">
							<td>
								<xsl:value-of select="eqAttrs/installedEquipmentObjectType"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/installedPartNumber">
							<td>
								<xsl:value-of select="eqAttrs/installedPartNulmber"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/installedSerialNumber">
							<td>
								<xsl:value-of select="eqAttrs/installedSerialNumber"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/serviceState">
							<td>
								<xsl:value-of select="eqAttrs/serviceState"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/installedVersion">
							<td>
								<xsl:value-of select="eqAttrs/installedVersion"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/manufacturer">
							<td>
								<xsl:value-of select="eqAttrs/manufacturer"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/protectionRole">
							<td>
								<xsl:value-of select="eqAttrs/protectionRole"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/protectionSchemeState">
							<td>
								<xsl:value-of select="eqAttrs/protectionSchemeState"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/manufacturerDate">
							<td>
								<xsl:value-of select="eqAttrs/manufacturerDate"/>
							</td>
						</xsl:if>
						<xsl:if test="eqAttrs/vendorExtensions">
							<td>
								<xsl:value-of select="eqAttrs/vendorExtensions"/>
							</td>
						</xsl:if>
					</tr>
				</body>
			</table>
		</div>
	</xsl:template>
</xsl:stylesheet>
<!-- web27705.mail.ukl.yahoo.com uncompressed/chunked Sun Sep 23 07:48:15 GMT 2007 -->
<!-- web50911.mail.re2.yahoo.com uncompressed/chunked Mon Sep 24 01:26:40 PDT 2007 -->
