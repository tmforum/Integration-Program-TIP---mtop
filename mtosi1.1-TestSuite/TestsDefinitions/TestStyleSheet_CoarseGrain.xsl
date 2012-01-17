<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xlink="http://www.w3.org/1999/xlink">
	<xsl:output method="html" media-type="text/html; charset=ISO-8859-1"/>
	<xsl:template match="/">
		<html>
			<head>
				<title>test cases</title>
			</head>
			<body>
				<table border="2px">
					<tr>
						<th>Test Identification</th>
						<td>
							<xsl:apply-templates select="//testId"/>
						</td>
					</tr>
					<tr>
						<th>517 Requirement</th>
						<td>
							<xsl:apply-templates select="//requirements"/>
						</td>
					</tr>
					<tr>
						<th>Operations</th>
						<td>
							<xsl:value-of select="//operations"/>
						</td>
					</tr>
					<tr>
						<th>Preconditions</th>
						<td>
							<xsl:apply-templates select="//preconditions"/>
						</td>
					</tr>
					<tr>
						<th>Test case</th>
						<td>
							<xsl:apply-templates select="//testCase"/>
						</td>
					</tr>
					<tr>
						<th>Post-conditions</th>
						<td>
							<xsl:apply-templates select="//postconditions"/>
						</td>
					</tr>
					<tr>
						<th>Comments</th>
						<td>
							<xsl:apply-templates select="//comments"/>
						</td>
					</tr>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="testId">
		<span style="width:150px">		
		Test Number:
		</span>
		<xsl:value-of select="number"/>
		<br/>
		<span style="width:150px">
		Test Category:
		</span>
		<xsl:value-of select="category"/>
		<br/>
		<span style="width:150px">
		MTOSI Interface:
		</span>
		<xsl:value-of select="interface"/>
		<br/>
		<span style="width:150px">
		Test Name:
		</span>
		<xsl:value-of select="name"/>
		<br/>
	</xsl:template>
	<xsl:template match="requirements">
		<xsl:value-of select="." disable-output-escaping="yes"/>
	</xsl:template>
	<xsl:template match="preconditions">
		<div style="font-family:Times New Roman">
			<xsl:value-of select="."/>
		</div>
	</xsl:template>
	<xsl:template match="testCase">
		<xsl:apply-templates select="request"/>
		Response: 
		<div style="margin-left: 30px; margin-top: 5px; margin-bottom: 15px">
			<xsl:value-of select="response" disable-output-escaping="yes"/>
		</div>
		XML Examples:
			<xsl:apply-templates select="xmlExamples"/>
		<br/>
	</xsl:template>
	<xsl:template match="request">
			Request: 
		<div style="margin-left: 30px; margin-top: 5px; margin-bottom: 15px">
			<xsl:apply-templates select="headerParameters"/>
			<xsl:apply-templates select="bodyParameters"/>
		</div>
	</xsl:template>
	<xsl:template match="headerParameters">
			Header Parameters:
<div style="margin-left: 30px; margin-top: 5px; margin-bottom: 10px; font-size:10pt">
			<xsl:value-of select="." disable-output-escaping="yes"/>
		</div>
	</xsl:template>
	<xsl:template match="bodyParameters">
			Body Parameters:
<div style="margin-left: 30px; margin-top: 5px; margin-bottom: 10px; font-size:10pt">
			<xsl:value-of select="." disable-output-escaping="yes"/>
		</div>
	</xsl:template>
	<xsl:template match="xmlExamples">
		<div style="margin-left: 30px; margin-top: 5px">
			<xsl:apply-templates select="xmlExample"/>
		</div>
	</xsl:template>
	<xsl:template match="xmlExample">
		<!--	<a href="{@xlink:href}"> -->
		<xsl:apply-templates select="input"/>
		<xsl:copy-of select="text()"/>
						&#160; &#160;
					<xsl:apply-templates select="output"/>
						&#160; &#160;
		</xsl:template>
	<xsl:template match="input">
		<xsl:value-of select="."/>
	</xsl:template>
	<xsl:template match="output">
		<xsl:copy-of select="text()"/>
		<xsl:value-of select="."/>
	</xsl:template>
	<xsl:template match="postconditions">
		In case of success<br/>
		<div style="text-indent:40px">
			<xsl:value-of select="success"/>
		</div>
	In case of failure<br/>
		<div style="text-indent:40px">
			<xsl:value-of select="failure"/>
		</div>
	</xsl:template>
	<xsl:template match="*[@xlink:type = 'simple' and @xlink:href]">
		<a href="{@xlink:href}">
			<xsl:apply-templates/>
		</a>
	</xsl:template>
	<xsl:template match="comments">
		<xsl:value-of select="." disable-output-escaping="yes"/>
	</xsl:template>
</xsl:stylesheet>
