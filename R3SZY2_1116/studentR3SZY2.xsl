<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Halllgatok adatai - for-each, value-of</h2>
                <table border="4">
                    <tr bgcolor="#9acd32">
                        <th>ID</th>
                        <th>Last name</th>
                        <th>First name</th>
                        <th>Nickname</th>
                        <th>Age</th>
                        <th>Scholarship</th>
                    </tr>
                    <xsl:for-each select="class/student">
                        <tr>
                            <td>
                                <xsl:value-of select="@id"/>
                            </td>
                            <td><xsl:value-of select="lastname"/></td>
                            <td><xsl:value-of select="firstname"/></td>
                            <td><xsl:value-of select="nickname"/></td>
                            <td><xsl:value-of select="age"/></td>
                            <td><xsl:value-of select="scholarship"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
