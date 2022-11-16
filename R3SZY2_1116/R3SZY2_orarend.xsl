<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>HA Orarend - 2022/23 I. felev</h2>
                <table border="4">
                    <tr bgcolor="#9acd32">
                        <th>ID</th>
                        <th>Tipus</th>
                        <th>Targy</th>
                        <th>Idopont</th>
                        <th>Helyszin</th>
                        <th>Oktato</th>
                        <th>Szak</th>
                    </tr>
                    <xsl:for-each select="HA_Orarend/ora">
                        <tr>
                            <td><xsl:value-of select="@id"/></td>
                            <td><xsl:value-of select="@tipus"/></td>
                            <td><xsl:value-of select="targy"/></td>
                            <td>
                                <xsl:for-each select="idopont">
                                    <p><xsl:value-of select="nap"/></p>
                                    <p><xsl:value-of select="tol"/></p>
                                    <p><xsl:value-of select="ig"/></p>
                                </xsl:for-each>
                            </td>
                            <td><xsl:value-of select="helyszin"/></td>
                            <td><xsl:value-of select="oktato"/></td>
                            <td><xsl:value-of select="szak"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
