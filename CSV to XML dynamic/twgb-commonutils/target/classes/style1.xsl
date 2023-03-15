<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
    <xsl:template match="/">Sr,ProjectName,Owner,Cost1,Dept,Dept2,Dept3,Dept4
        <xsl:for-each select="Responses//Response">
            <xsl:value-of select="concat(Sr, ',' ,ProjectName, ',' ,Owner, ',' ,Cost1, ',' ,Dept, ',' ,Dept2, ',' ,Dept3, ',' ,Dept4,'&#xA;')"/>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>