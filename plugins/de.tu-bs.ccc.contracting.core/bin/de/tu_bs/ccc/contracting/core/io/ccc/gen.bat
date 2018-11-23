ECHO OFF
ECHO Generate Java files from XSD
xjc.exe -d ..\..\..\..\..\..\..\..\src\ -p de.tu_bs.ccc.contracting.core.io.ccc .\XMLCCC.xsd
PAUSE
